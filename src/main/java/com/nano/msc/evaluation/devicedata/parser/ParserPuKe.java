package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.PearlcareYy106;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.PearlcareYy106Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParserPuKe implements DeviceDataParser {


    @Autowired
    private PearlcareYy106Repository repository;

    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {

        // 解析数据
        PearlcareYy106 deviceData = JSON.parseObject(deviceRawData, PearlcareYy106.class);

        // 保存数据
        return repository.save(deviceData) != null;
    }


}
