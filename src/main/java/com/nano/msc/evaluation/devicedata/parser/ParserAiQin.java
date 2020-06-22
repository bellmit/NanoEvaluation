package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.DataAiQin;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.AiQinRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 爱琴EGOS600A数据解析
 *
 * @author nano
 */
@Component
public class ParserAiQin implements DeviceDataParser {

    @Autowired
    private AiQinRepository repository;


    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {
        // 解析数据
        DataAiQin deviceData = JSON.parseObject(deviceRawData, DataAiQin.class);

        repository.save(deviceData);
        // 保存数据
        return true;
    }
}
