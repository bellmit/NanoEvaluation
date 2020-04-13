package com.nano.msc.evaluation.devicedata.parse;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.Norwamd9002s;
import com.nano.msc.evaluation.devicedata.parse.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.Norwamd9002sRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 诺和的数据解析器
 * @author nano
 */
@Component
public class NuoHeParser implements DeviceDataParser {

    @Autowired
    private Norwamd9002sRepository norwamd9002sRepository;

    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {
        // 解析数据
        Norwamd9002s norwamd9002sData = JSON.parseObject(deviceRawData, Norwamd9002s.class);
        // 保存数据
        return norwamd9002sRepository.save(norwamd9002sData) == null;
    }
}
