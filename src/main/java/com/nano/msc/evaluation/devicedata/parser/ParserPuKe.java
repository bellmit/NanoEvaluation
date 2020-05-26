package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.PearlcareYy106;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.PearlcareYy106Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ParserPuKe implements DeviceDataParser {


    @Autowired
    private PearlcareYy106Repository repository;

    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {

        log.info("解析数据:" + deviceRawData);

        // 解析数据
        PearlcareYy106 deviceData = JSON.parseObject(deviceRawData, PearlcareYy106.class);

        log.info("解析后:" + deviceData.toString());
        // 保存数据
        try {
            repository.save(deviceData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static void main(String[] args) {

        ParserPuKe parserPuKe = new ParserPuKe();
        parserPuKe.parseDeviceDataStringAndSave("{\\\"ai\\\":-1000,\\\"bSR\\\":-1000,\\\"eMG\\\":-1000,\\\"operationNumber\\\":3,\\\"sQI\\\":-1000}");


    }

}
