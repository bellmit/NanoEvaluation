package com.nano.msc.info;

import com.alibaba.fastjson.JSON;
import com.nano.msc.common.enums.CollectCodeEnum;
import com.nano.msc.evaluation.devicedata.entity.Norwamd9002s;
import com.nano.msc.evaluation.devicedata.param.ParamDeviceData;
import com.nano.msc.evaluation.enums.DeviceCodeEnum;
import com.nano.msc.evaluation.param.ParamCollector;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeviceDataTest {


    @Test
    public void postDeviceData() {

        Norwamd9002s norwamd9002s = new Norwamd9002s();
        norwamd9002s.setSerialNumber("X123123");
        norwamd9002s.setOperationNumber(27);
        norwamd9002s.setBS(12);
        norwamd9002s.setCSI(45);
        norwamd9002s.setEMG(45);
        norwamd9002s.setSQI(67);
        ParamDeviceData deviceData = new ParamDeviceData();
        deviceData.setDeviceCode(DeviceCodeEnum.NORWAMD_9002S.getCode());
        deviceData.setDeviceData(JSON.toJSONString(norwamd9002s));

        ParamCollector paramCollector = new ParamCollector();
        paramCollector.setRequestCode(CollectCodeEnum.COLLECTION_DEVICE_DATA.getCode());
        paramCollector.setMac("08:00:20:0A:8C:6D");
        paramCollector.setOperationNumber(27);
        // 默认无数据
        paramCollector.setData(JSON.toJSONString(deviceData));
        System.out.println(JSON.toJSONString(paramCollector));
    }


}
