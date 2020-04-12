package com.nano.msc.evaluation.devicedata.service.impl;

import com.alibaba.fastjson.JSON;
import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.vo.CollectionVo;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.devicedata.component.DataParserContext;
import com.nano.msc.evaluation.devicedata.param.ParamDeviceData;
import com.nano.msc.evaluation.devicedata.parse.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.service.DeviceDataService;
import com.nano.msc.evaluation.info.service.InfoOperationService;
import com.nano.msc.evaluation.param.ParamCollector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import javax.annotation.PostConstruct;

import lombok.Getter;

/**
 * 仪器数据服务实现类
 * @author nano
 */
@Service
public class DeviceDataServiceImpl implements DeviceDataService {

    @Autowired
    private InfoOperationService operationService;


    @Autowired
    private DataParserContext dataParserContext;


    /**
     * 仪器数据解析的Map 键是DeviceCode，值是对应的DataParser
     */
    private Map<Integer, DeviceDataParser> dataParserMap;

    /**
     * 处理采集器上传而来的仪器数据
     * @param paramCollector 数据参数苏
     * @return 是否成功
     */
    @Override
    public CommonResult<CollectionVo> handleCollectorPostDeviceData(ParamCollector paramCollector) {

        if (paramCollector == null) {
            return CommonResult.failed(CollectionVo.error(ExceptionEnum.DATA_FORMAT_ERROR));
        }

        // 原始待解析的数据
        String rawData = paramCollector.getData();
        int operationNumber = paramCollector.getOperationNumber();
        if (operationNumber < 0) {
            return CommonResult.failed(CollectionVo.error(ExceptionEnum.DATA_NOT_EXIST, "手术场次号不存在"));
        }
        ParamDeviceData paramDeviceData;
        try {
            paramDeviceData = JSON.parseObject(rawData, ParamDeviceData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(CollectionVo.error(ExceptionEnum.DATA_PARSE_EXCEPTION, "仪器数据解析异常"));
        }


        dataParserMap.get(30).parseDeviceDataString("");
        return CommonResult.success(CollectionVo.responseDeviceData());
    }


    /**
     * 容器构造时初始化
     */
    @PostConstruct
    private void init() {
        this.dataParserMap = dataParserContext.getDataParserMap();
    }
}
