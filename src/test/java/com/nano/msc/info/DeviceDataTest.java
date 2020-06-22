package com.nano.msc.info;

import com.alibaba.fastjson.JSON;
import com.nano.msc.common.enums.CollectorCodeEnum;
import com.nano.msc.evaluation.devicedata.entity.DataNuoHe9002s;
import com.nano.msc.evaluation.devicedata.entity.DataPuKeYy106;
import com.nano.msc.evaluation.devicedata.param.ParamDeviceData;
import com.nano.msc.evaluation.enums.DeviceInfoEnum;
import com.nano.msc.evaluation.info.repository.InfoOperationRepository;
import com.nano.msc.evaluation.param.ParamCollector;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeviceDataTest {


    @Autowired
    private InfoOperationRepository operationRepository;


    @Test
    public void postDeviceDataNuoHe() {

        DataNuoHe9002s dataNuoHe9002S = new DataNuoHe9002s();
        dataNuoHe9002S.setSerialNumber("X123123");
        dataNuoHe9002S.setOperationNumber(27);
        dataNuoHe9002S.setBs(12);
        dataNuoHe9002S.setCsi(45);
        dataNuoHe9002S.setEmg(45);
        dataNuoHe9002S.setSqi(67);
        ParamDeviceData deviceData = new ParamDeviceData();
        deviceData.setDeviceCode(DeviceInfoEnum.NORWAMD_9002S.getDeviceCode());
        deviceData.setDeviceData(JSON.toJSONString(dataNuoHe9002S));

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

        DataPuKeYy106 dataPuKeYy106 = new DataPuKeYy106();
        dataPuKeYy106.setSerialNumber("X123123");
        dataPuKeYy106.setOperationNumber(27);
        dataPuKeYy106.setAi(45);
        dataPuKeYy106.setBsr(12);
        dataPuKeYy106.setEmg(87);
        dataPuKeYy106.setSqi(90);
        ParamDeviceData deviceData = new ParamDeviceData();
        deviceData.setDeviceCode(DeviceInfoEnum.PEARLCARE_YY106.getDeviceCode());
        deviceData.setDeviceData(JSON.toJSONString(dataPuKeYy106));

        ParamCollector paramCollector = new ParamCollector();
        paramCollector.setRequestCode(CollectorCodeEnum.COLLECTION_DEVICE_DATA.getCode());
        paramCollector.setMac("08:00:20:0A:8C:6D");
        paramCollector.setOperationNumber(27);
        // 默认无数据
        paramCollector.setData(JSON.toJSONString(deviceData));
        System.out.println(JSON.toJSONString(paramCollector));
    }


    @Test
    public void test33() {

        System.out.println("123");
        operationRepository.findFinishedOperationListDesc(1, PageRequest.of(0, 5));

    }


}
