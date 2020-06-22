package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.DataYiAn8700A;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.YiAn8700ARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 宜安8700A麻醉机数据解析器
 * @author nano
 */
@Component
public class ParserYiAn8700A implements DeviceDataParser {

    @Autowired
    private YiAn8700ARepository repository;


    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {
        // 解析数据
        DataYiAn8700A deviceData = JSON.parseObject(deviceRawData, DataYiAn8700A.class);

        // 保存数据
        return repository.save(deviceData) != null;
    }
}
