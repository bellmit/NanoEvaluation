package com.nano.msc.evaluation.info.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nano.msc.common.enums.CollectorCodeEnum;
import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.exceptions.ExceptionAsserts;
import com.nano.msc.common.utils.CollectionUtil;
import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.enums.DeviceInfoEnum;
import com.nano.msc.evaluation.enums.OperationStateEnum;
import com.nano.msc.evaluation.info.entity.InfoDevice;
import com.nano.msc.evaluation.info.entity.InfoEvaluation;
import com.nano.msc.evaluation.info.entity.InfoOperationDevice;
import com.nano.msc.evaluation.info.entity.InfoOperationMark;
import com.nano.msc.evaluation.info.service.InfoDeviceService;
import com.nano.msc.evaluation.info.service.InfoEvaluationService;
import com.nano.msc.evaluation.info.service.InfoOperationDeviceService;
import com.nano.msc.evaluation.info.service.InfoOperationMarkService;
import com.nano.msc.evaluation.param.ParamCollector;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.service.DeviceDataCollectionService;
import com.nano.msc.evaluation.info.service.InfoOperationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 仪器数据采集整个流程控制的服务类
 * @author nano
 */
@Service
public class DeviceDataCollectionServiceImpl implements DeviceDataCollectionService {

    private static final Logger logger = LoggerFactory.getLogger("DeviceDataCollectionServiceImpl");

    @Autowired
    private InfoOperationService operationService;

    @Autowired
    private InfoDeviceService deviceService;

    @Autowired
    private InfoOperationDeviceService operationDeviceService;

    @Autowired
    private InfoOperationMarkService markService;

    @Autowired
    private InfoEvaluationService evaluationService;


    /**
     * 处理采集器上传的各种数据 开启事务
     *
     * @param paramCollector 数据实体参数
     * @return 处理结果
     */
    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public CommonResult<ResultVo> handleCollectorPostedData(ParamCollector paramCollector) {
        int requestCode = paramCollector.getRequestCode();
        // 返回服务器状态
        if (requestCode == CollectorCodeEnum.SERVER_STATUS.getCode()) {
            logger.info("请求服务器状态");
            return CommonResult.success(ResultVo.responseServerStatus());

            // 接收到手术基本信息数据
        } else if (requestCode == CollectorCodeEnum.COLLECTION_OPERATION_INFO.getCode()) {
            logger.info("上传手术信息并返回手术场次号");
            logger.info(paramCollector.getData());
            return handleCollectionInfoAndReturnOperationNumber(paramCollector);
            // 收到手术开始信息
        } else if(requestCode == CollectorCodeEnum.COLLECTION_START_OPERATION.getCode()) {
            logger.info("收到手术开始信息" + paramCollector.getOperationNumber());
            return handleCollectionStartInfo(paramCollector);

            // 收到手术标记信息
        } else if(requestCode == CollectorCodeEnum.COLLECTION_OPERATION_MARK.getCode()) {
            logger.info("收到手术标记信息:" + paramCollector.getOperationNumber());
            logger.info(paramCollector.getData());
            return handleCollectionMarkInfo(paramCollector);

            // 收到手术结束信息
        } else if(requestCode == CollectorCodeEnum.COLLECTION_STOP_OPERATION.getCode()) {
            logger.info("收到手术结束信息" + paramCollector.getOperationNumber());
            return handleCollectionStopInfo(paramCollector);

            // 收到手术后仪器评价信息
        } else if(requestCode == CollectorCodeEnum.COLLECTION_DEVICE_EVALUATION.getCode()) {
            logger.info("收到手术后仪器评价信息" + paramCollector.getOperationNumber());
            logger.info(paramCollector.getData());
            return handleCollectionEvaluationInfo(paramCollector);

            // 未知的请求Code
        } else {
            logger.error("未知的请求Code");
            return CommonResult.failed(ResultVo.error(ExceptionEnum.UNKNOWN_DATA_TYPE));
        }
    }


    /**
     * 处理采集基本信息并返回手术场次号
     *
     * @return 手术场次号
     */
    private CommonResult<ResultVo> handleCollectionInfoAndReturnOperationNumber(ParamCollector paramCollector) {

        System.out.println(paramCollector.getData());

        InfoOperation infoOperation;
        try {
            infoOperation = JSONObject.parseObject(paramCollector.getData(), InfoOperation.class);
            // 身份证号全部转为大写
            infoOperation.setPatientId(infoOperation.getPatientId().toUpperCase());
            // 补充信息:补充MAC地址和设置手术状态为准备,初始化开始和结束时间为当前
            infoOperation.setCollectorMacAddress(paramCollector.getMac());
            infoOperation.setOperationState(OperationStateEnum.PREPARING.getCode());
            infoOperation.setOperationStartTime(LocalDateTime.now());
            infoOperation.setOperationEndTime(LocalDateTime.now());
        } catch (Exception e) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_FORMAT_ERROR, "手术基本信息参数错误"));
        }

        // 解析使用的仪器信息
        String deviceInfo = infoOperation.getUsedDeviceInfo();
        List<InfoDevice> usedDevices = JSONObject.parseArray(deviceInfo, InfoDevice.class);
        // 构造插入用于平台展示的仪器名称
        StringBuilder platformUsedDeviceInfoBuilder = new StringBuilder();
        for (InfoDevice device : usedDevices) {
            DeviceInfoEnum infoEnum = DeviceInfoEnum.matchDeviceCodeEnum(device.getDeviceCode());
            if (infoEnum != null) {
                platformUsedDeviceInfoBuilder.append(infoEnum.getDeviceName()).append(" ");
            }
        }
        // 插入用于平台展示的仪器信息并更新手术信息实体
        infoOperation.setUsedDeviceInfoForPlatform(platformUsedDeviceInfoBuilder.toString().trim());
        // 将手术信息存储入数据库，如果成功则返回存入信息，否则抛异常 此时已经有手术场次号了
        InfoOperation savedInfoOperation = operationService.handleNewOperationInfoRequestAndSave(infoOperation);

        for (InfoDevice device : usedDevices) {
            // 说明是合格的仪器信息
            if (DeviceInfoEnum.matchDeviceCodeEnum(device.getDeviceCode()) != null) {
                InfoDevice alreadyHaveDeviceInfo = deviceService.findByDeviceCodeAndDeviceSerialNumber(device.getDeviceCode(), device.getDeviceSerialNumber());
                // 说明数据库中还没有这个仪器的数据
                if(alreadyHaveDeviceInfo == null) {
                    // 补充一些信息并将这个仪器信息保存到数据库中
                    DeviceInfoEnum infoEnum = DeviceInfoEnum.matchDeviceCodeEnum(device.getDeviceCode());
                    if (infoEnum != null) {
                        device.setDeviceName(infoEnum.getDeviceName());
                        device.setCompanyName(infoEnum.getCompanyName());
                        device.setDeviceType(infoEnum.getDeviceType());

                    } else {
                        ExceptionAsserts.fail("未知的仪器代号:" + device.toString());
                    }
                    InfoDevice saveNewDevice = deviceService.save(device);
                    if (saveNewDevice == null) {
                        ExceptionAsserts.fail("仪器信息保存失败");
                    }
                    // 构造并存储使用仪器的信息
                    InfoOperationDevice operationDevice = new InfoOperationDevice();
                    operationDevice.setDeviceCode(saveNewDevice.getDeviceCode());
                    operationDevice.setDeviceInfoId(saveNewDevice.getId());
                    operationDevice.setOperationNumber(savedInfoOperation.getOperationNumber());
                    operationDeviceService.save(operationDevice);
                    // 说明数据库中有这个仪器信息，直接记录下来即可
                } else {
                    // 将手术使用信息存入到手术仪器关系表中
                    InfoOperationDevice operationDevice = new InfoOperationDevice();
                    operationDevice.setDeviceCode(alreadyHaveDeviceInfo.getDeviceCode());
                    operationDevice.setDeviceInfoId(alreadyHaveDeviceInfo.getId());
                    operationDevice.setOperationNumber(savedInfoOperation.getOperationNumber());
                    operationDeviceService.save(operationDevice);
                }
            } else {
                return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_SAVE_ERROR, "使用仪器信息代号无效" + device.toString()));
            }
        }


        // 返回手术场次号
        return CommonResult.success(ResultVo.responseOperationInfo(infoOperation.getOperationNumber()));
    }


    /**
     * 处理手术开始的数据
     *
     * @param paramCollector 采集器参数
     * @return 是否成功
     */
    private CommonResult<ResultVo> handleCollectionStartInfo(ParamCollector paramCollector) {

        int operationNumber = paramCollector.getOperationNumber();
        InfoOperation operation = operationService.findByOperationNumber(operationNumber);
        if(operation == null) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_NOT_EXIST, "手术场次号不存在"));
        } else {
            // 说明当前手术状态不是等待状态 则不能开始
            if (!operation.getOperationState().equals(OperationStateEnum.PREPARING.getCode())) {
                return CommonResult.failed(ResultVo.error(ExceptionEnum.NO_LEADING_DATA, "手术已经开始或者已经结束"));
            } else {
                // 将手术状态设置为正在进行
                operation.setOperationStartTime(LocalDateTime.now());
                operation.setOperationState(OperationStateEnum.PROGRESSING.getCode());
                // 更新状态
                operationService.update(operation);
            }
        }
        // 回复OK
        return CommonResult.success(ResultVo.responseStartOperation());

    }

    /**
     * 处理接收到手术标记信息的数据
     *
     * @param paramCollector 采集器数据
     * @return 是否成功
     */
    private CommonResult<ResultVo> handleCollectionMarkInfo(ParamCollector paramCollector) {
        // 获取当前手术信息
        InfoOperation operation = operationService.findByOperationNumber(paramCollector.getOperationNumber());
        if(operation == null) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_NOT_EXIST, "当前标记无对应手术场次号"));
        }
        // 解析标记信息为列表
        List<InfoOperationMark> operationMarkList;
        try {
            operationMarkList = JSONObject.parseArray(paramCollector.getData(), InfoOperationMark.class);
        } catch (Exception e) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_FORMAT_ERROR, "手术标记信息参数错误"));
        }

        // TODO:需要判断标记的时间与手术时间，标记时间必须在手术范围之内 前期不好控制，可以后期进行删选
        // 此处设置手术场次号
        operationMarkList.forEach(mark -> mark.setOperationNumber(paramCollector.getOperationNumber()));
        markService.saveAll(operationMarkList);
        return CommonResult.success(ResultVo.responseMarkInfo());
    }

    /**
     * 处理接收到手术结束的信息
     *
     * @param paramCollector 采集器数据
     * @return 是否成功
     */
    private CommonResult<ResultVo> handleCollectionStopInfo(ParamCollector paramCollector) {
        int operationNumber = paramCollector.getOperationNumber();
        InfoOperation operation = operationService.findByOperationNumber(operationNumber);
        if(operation == null) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_NOT_EXIST, "手术场次号不存在"));
        } else {
            // 说明当前手术状态不是开始状态 则不能开始
            if (!operation.getOperationState().equals(OperationStateEnum.PROGRESSING.getCode())) {
                return CommonResult.failed(ResultVo.error(ExceptionEnum.NO_LEADING_DATA, "手术暂未开始或者已经结束"));
            } else {
                // 将手术状态设置为已经结束
                operation.setOperationEndTime(LocalDateTime.now());
                operation.setOperationState(OperationStateEnum.FINISHED.getCode());
                // 更新状态
                operationService.update(operation);
            }
        }

        // 回复OK
        return CommonResult.success(ResultVo.responseStopOperation());
    }

    /**
     * 处理接收到术后仪器评价的数据
     *
     * @param paramCollector 采集器参数
     * @return 是否成功
     */
    private CommonResult<ResultVo> handleCollectionEvaluationInfo(ParamCollector paramCollector) {

        // 获取当前手术信息
        InfoOperation operation = operationService.findByOperationNumber(paramCollector.getOperationNumber());
        if(operation == null) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_NOT_EXIST, "当前标记无对应手术场次号"));
        }
        // 解析术后评价信息为列表
        List<InfoEvaluation> evaluationList;
        try {
            evaluationList = JSONObject.parseArray(paramCollector.getData(), InfoEvaluation.class);
        } catch (Exception e) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_FORMAT_ERROR, "术后仪器评价信息参数错误"));
        }
        evaluationService.saveAll(evaluationList);
        return CommonResult.success(ResultVo.responseDeviceEvaluation());
    }



}
