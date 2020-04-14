package com.nano.msc.evaluation.devicedata.service.impl;

import com.alibaba.fastjson.JSON;
import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.devicedata.component.DataParserContext;
import com.nano.msc.common.constants.CacheCons;
import com.nano.msc.evaluation.devicedata.param.ParamDeviceData;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.service.DeviceDataService;
import com.nano.msc.evaluation.info.service.InfoOperationService;
import com.nano.msc.evaluation.param.ParamCollector;
import com.nano.msc.redis.service.RedisService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import javax.annotation.PostConstruct;

/**
 * 仪器数据服务实现类
 * @author nano
 */
@Service
public class DeviceDataServiceImpl implements DeviceDataService {

    private static final Logger logger = LoggerFactory.getLogger(DeviceDataServiceImpl.class);


    @Autowired
    private InfoOperationService operationService;


    @Autowired
    private DataParserContext dataParserContext;


    /**
     * 仪器数据解析的Map 键是DeviceCode，值是对应的DataParser
     */
    private Map<Integer, DeviceDataParser> dataParserMap;


    @Autowired
    private RedisService redisService;

    /**
     * 处理采集器上传而来的仪器数据
     * @param paramCollector 数据参数苏
     * @return 是否成功
     */
    @Override
    public CommonResult<ResultVo> handleCollectorPostDeviceData(ParamCollector paramCollector) {

        if (paramCollector == null) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_FORMAT_ERROR));
        }

        // 原始待解析的数据
        String rawData = paramCollector.getData();
        int operationNumber = paramCollector.getOperationNumber();
        // TODO:判断当前的手术场次号是否处于正在采集状态，不是则不要
        if (operationNumber < 0) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_NOT_EXIST, "手术场次号不存在"));
        }
        ParamDeviceData paramDeviceData;
        try {
            paramDeviceData = JSON.parseObject(rawData, ParamDeviceData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_PARSE_EXCEPTION, "仪器数据参数解析异常"));
        }

        // 说明存在这个仪器的解析器
        if (!dataParserMap.containsKey(paramDeviceData.getDeviceCode())) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.UNKNOWN_DATA_TYPE, "没有对应仪器号"));
        }
        // 解析并存储这个JSON
        boolean success = dataParserMap.get(paramDeviceData.getDeviceCode()).parseDeviceDataStringAndSave(paramDeviceData.getDeviceData());
        if(!success) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.DATA_PARSE_EXCEPTION, "仪器数据解析错误"));
        }
        logger.info("接收仪器数据:" + paramDeviceData.toString());

        // 将最新的数据存入Redis
        String key = CacheCons.NEWEAST_DEVICE_DATA_HEAD + operationNumber
                + CacheCons.SEPARATOR + paramDeviceData.getDeviceCode();
        redisService.set(key, paramDeviceData.getDeviceData(), 3600);

        return CommonResult.success(ResultVo.responseDeviceData());
    }


    /**
     * 使用手术场次号+仪器号获取这个仪器最新的仪器数据
     * @param operationNumber 手术场次号
     * @param deviceCode 仪器号
     * @return 最新数据实体
     */
    @Override
    public CommonResult getNewestDeviceData(Integer operationNumber, Integer deviceCode) {

        String key = CacheCons.NEWEAST_DEVICE_DATA_HEAD + operationNumber
                + CacheCons.SEPARATOR + deviceCode;
        // 获取最新数据的JSON字符串
        String redisData = (String) redisService.get(key);

        // 缓存命中直接返回结果
        if (redisData != null) {
            logger.info("取缓存");
            return CommonResult.success(redisData);
        }

        // 缓存没有命中
        // 首先看看当前的手术场次号是否正在进行--即是否在Redis的一个手术场次号构成的集合中
        boolean isValidOperationNumber = redisService.sIsMember(CacheCons.OPERATION_NUMBER_SET, operationNumber);
        if (!isValidOperationNumber) {
            // 返回空数据
            return CommonResult.success("");
        }

        // 如果是开始状态，但是依然可能没有数据，此时直接返回空？？此处还需要斟酌一下
        return CommonResult.success("");
    }


    /**
     * 容器构造时初始化
     */
    @PostConstruct
    private void init() {
        this.dataParserMap = dataParserContext.getDataParserMap();
    }
}
