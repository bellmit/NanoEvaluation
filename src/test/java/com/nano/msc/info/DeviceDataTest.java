package com.nano.msc.info;

import com.alibaba.fastjson.JSON;
import com.nano.msc.common.enums.CollectorCodeEnum;
import com.nano.msc.evaluation.devicedata.entity.NuoHe9002s;
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

        NuoHe9002s nuoHe9002S = new NuoHe9002s();
        nuoHe9002S.setSerialNumber("X123123");
        nuoHe9002S.setOperationNumber(27);
        nuoHe9002S.setBs(12);
        nuoHe9002S.setCsi(45);
        nuoHe9002S.setEmg(45);
        nuoHe9002S.setSqi(67);
        ParamDeviceData deviceData = new ParamDeviceData();
        deviceData.setDeviceCode(DeviceInfoEnum.NORWAMD_9002S.getDeviceCode());
        deviceData.setDeviceData(JSON.toJSONString(nuoHe9002S));

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
        puKeYy106.setBsr(12);
        puKeYy106.setEmg(87);
        puKeYy106.setSqi(90);
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
