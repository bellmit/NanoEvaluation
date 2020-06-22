package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.DataNuoHe9002s;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.NuoHe9002sRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 诺和的数据解析器
 * @author nano
 */
@Component
public class ParserNuoHe implements DeviceDataParser {

    @Autowired
    private NuoHe9002sRepository repository;

    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {
        // 解析数据
        DataNuoHe9002s deviceData = JSON.parseObject(deviceRawData, DataNuoHe9002s.class);
        // 保存数据
        return repository.save(deviceData) != null;
    }
}
