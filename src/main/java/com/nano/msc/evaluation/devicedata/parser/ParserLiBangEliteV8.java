package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.LiBangEliteV8;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.LiBangEliteV8Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 理邦EliteV8数据解析器
 * @author nano
 */
@Component
public class ParserLiBangEliteV8 implements DeviceDataParser {

    @Autowired
    private LiBangEliteV8Repository repository;

    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {
        // 解析数据
        LiBangEliteV8 deviceData = JSON.parseObject(deviceRawData, LiBangEliteV8.class);
        // 保存数据
        return repository.save(deviceData) != null;
    }
}
