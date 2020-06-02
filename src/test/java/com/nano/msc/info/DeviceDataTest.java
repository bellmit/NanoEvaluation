package com.nano.msc.info;

import com.alibaba.fastjson.JSON;
import com.nano.msc.common.enums.CollectorCodeEnum;
import com.nano.msc.evaluation.devicedata.entity.Norwamd9002s;
import com.nano.msc.evaluation.devicedata.entity.PuKeYy106;
import com.nano.msc.evaluation.devicedata.param.ParamDeviceData;
import com.nano.msc.evaluation.enums.DeviceInfoEnum;
import com.nano.msc.evaluation.param.ParamCollector;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class DeviceDataTest {


    @Test
    public void postDeviceDataNuoHe() {

        Norwamd9002s norwamd9002s = new Norwamd9002s();
        norwamd9002s.setSerialNumber("X123123");
        norwamd9002s.setOperationNumber(27);
        norwamd9002s.setBS(12);
        norwamd9002s.setCSI(45);
        norwamd9002s.setEMG(45);
        norwamd9002s.setSQI(67);
        ParamDeviceData deviceData = new ParamDeviceData();
        deviceData.setDeviceCode(DeviceInfoEnum.NORWAMD_9002S.getDeviceCode());
        deviceData.setDeviceData(JSON.toJSONString(norwamd9002s));

        ParamCollector paramCollector = new ParamCollector();
        paramCollector.setRequestCode(CollectorCodeEnum.COLLECTION_DEVICE_DATA.getCode());
        paramCollector.setMac("08:00:20:0A:8C:6D");
        paramCollector.setOperationNumber(27);
        // 默认无数据
        paramCollector.setData(JSON.toJSONString(deviceData));
        System.out.println(JSON.toJSONString(paramCollector));
    }


    @Test
    public void postDeviceDataPuKe() {

        PuKeYy106 puKeYy106 = new PuKeYy106();
        puKeYy106.setSerialNumber("X123123");
        puKeYy106.setOperationNumber(27);
        puKeYy106.setAi(45);
        puKeYy106.setBSR(12);
        puKeYy106.setEMG(87);
        puKeYy106.setSQI(90);
        ParamDeviceData deviceData = new ParamDeviceData();
        deviceData.setDeviceCode(DeviceInfoEnum.PEARLCARE_YY106.getDeviceCode());
        deviceData.setDeviceData(JSON.toJSONString(puKeYy106));

        ParamCollector paramCollector = new ParamCollector();
        paramCollector.setRequestCode(CollectorCodeEnum.COLLECTION_DEVICE_DATA.getCode());
        paramCollector.setMac("08:00:20:0A:8C:6D");
        paramCollector.setOperationNumber(27);
        // 默认无数据
        paramCollector.setData(JSON.toJSONString(deviceData));
        System.out.println(JSON.toJSONString(paramCollector));
    }


}
