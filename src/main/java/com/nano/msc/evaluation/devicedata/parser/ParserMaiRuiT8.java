package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.MaiRuiT8;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.MaiRuiT8Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 迈瑞T8数据解析器
 * @author nano
 */
@Component
public class ParserMaiRuiT8 implements DeviceDataParser {

    @Autowired
    private MaiRuiT8Repository repository;

    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {
        // 解析数据
        MaiRuiT8 deviceData = JSON.parseObject(deviceRawData, MaiRuiT8.class);

        // 保存数据
        return repository.save(deviceData) != null;
    }
}
