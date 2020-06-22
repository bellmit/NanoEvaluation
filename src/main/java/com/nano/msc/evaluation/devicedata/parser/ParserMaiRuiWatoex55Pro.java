package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.DataMaiRuiWatoex55Pro;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.MaiRuiWatoex55ProRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 迈瑞WATOEX55Pro数据解析器
 * @author nano
 */
@Component
public class ParserMaiRuiWatoex55Pro implements DeviceDataParser {

    @Autowired
    private MaiRuiWatoex55ProRepository repository;

    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {

        // 解析数据
        DataMaiRuiWatoex55Pro deviceData = JSON.parseObject(deviceRawData, DataMaiRuiWatoex55Pro.class);

        // 保存数据
        return repository.save(deviceData) != null;
    }
}
