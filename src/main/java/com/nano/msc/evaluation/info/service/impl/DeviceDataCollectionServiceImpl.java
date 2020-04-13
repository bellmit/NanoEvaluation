package com.nano.msc.evaluation.info.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nano.msc.common.enums.CollectCodeEnum;
import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.exceptions.ExceptionAsserts;
import com.nano.msc.common.utils.CollectionUtil;
import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.enums.DeviceCodeEnum;
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
@Slf4j
public class DeviceDataCollectionServiceImpl implements DeviceDataCollectionService {


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
    public CommonResult<ResultVo> handleCollectorPostData(ParamCollector paramCollector) {

        int requestCode = paramCollector.getRequestCode();
        // 返回服务器状态
        if (requestCode == CollectCodeEnum.SERVER_STATUS.getCode()) {
            return CommonResult.success(ResultVo.responseServerStatus());

            // 接收到手术信息数据
        } else if (requestCode == CollectCodeEnum.COLLECTION_OPERATION_INFO.getCode()) {
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
            // 将手术信息存储入数据库，如果成功则返回存入信息，否则抛异常
            InfoOperation savedInfoOperation = operationService.handleNewOperationInfoRequestAndSave(infoOperation);

            // 解析使用的仪器信息
            String deviceInfo = infoOperation.getUsedDeviceInfo();
            System.out.println(deviceInfo);
            List<InfoDevice> usedDevices = JSONObject.parseArray(deviceInfo, InfoDevice.class);
            CollectionUtil.printList(usedDevices);
            boolean matchFlag = false;
            for (InfoDevice device : usedDevices) {
                // 说明是合格的仪器信息
                if (DeviceCodeEnum.matchDeviceCodeEnum(device.getDeviceCode()) != null) {
                    matchFlag = true;
                    InfoDevice alreadyHaveDeviceInfo = deviceService.findByDeviceCodeAndDeviceSerialNumber(device.getDeviceCode(), device.getDeviceSerialNumber());
                    // 说明数据库中还没有这个仪器的数据
                    if(alreadyHaveDeviceInfo == null) {
                        InfoDevice saveNewDevice = deviceService.save(device);
                        if (saveNewDevice == null) {
                            ExceptionAsserts.fail("仪器信息保存失败");
                        }
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
                }
            }
            if (!matchFlag) {
                return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_SAVE_ERROR, "使用仪器信息全部无效"));
            }
            log.info("Insert operation info:" + infoOperation.toString());
            return CommonResult.success(ResultVo.responseOperationInfo(infoOperation.getOperationNumber()));

            // 收到手术开始信息
        } else if(requestCode == CollectCodeEnum.COLLECTION_START_OPERATION.getCode()) {
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
            // 收到手术标记信息
        } else if(requestCode == CollectCodeEnum.COLLECTION_OPERATION_MARK.getCode()) {

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

            // 收到手术结束信息
        } else if(requestCode == CollectCodeEnum.COLLECTION_STOP_OPERATION.getCode()) {
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

            // 收到手术后仪器评价信息
        } else if(requestCode == CollectCodeEnum.COLLECTION_DEVICE_EVALUATION.getCode()) {

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
            // 未知的请求Code
        } else {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.UNKNOWN_DATA_TYPE));
        }
    }

}
