package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.MaiRuiWatoex65;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.MaiRuiWatoex65Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 迈瑞WATOEX65麻醉机数据解析
 * @author nano
 */
@Component
public class ParserMaiRuiWatoex65 implements DeviceDataParser {
    @Autowired
    private MaiRuiWatoex65Repository repository;

    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {

        // 解析数据
        MaiRuiWatoex65 deviceData = JSON.parseObject(deviceRawData, MaiRuiWatoex65.class);

        // 保存数据
        return repository.save(deviceData) != null;
    }
}
