package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.BaoLaiTe;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.BaoLaiTeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 解析宝莱特A8的解析器
 * @author nano
 */
@Component
public class ParserBaoLaiTeA8 implements DeviceDataParser {

    @Autowired
    private BaoLaiTeRepository repository;

    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {

        BaoLaiTe deviceData = JSON.parseObject(deviceRawData, BaoLaiTe.class);
        return repository.save(deviceData) == null;
    }
}
