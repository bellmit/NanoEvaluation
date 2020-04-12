package com.nano.msc.evaluation.devicedata.parse;

import com.nano.msc.evaluation.devicedata.parse.base.DeviceDataParser;

import org.springframework.stereotype.Component;

/**
 * 诺和的数据解析器
 * @author nano
 */
@Component
public class NuoHeParser implements DeviceDataParser {

    @Override
    public DeviceData parseDeviceDataString(String deviceRawData) {
        System.out.println("Ohhhhhhh");
        return null;
    }
}
