package com.nano.msc.evaluation.devicedata.parser;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.entity.DataPuKeYy106;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.PuKeYy106Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ParserPuKe implements DeviceDataParser {


    @Autowired
    private PuKeYy106Repository repository;

    @Override
    public boolean parseDeviceDataStringAndSave(String deviceRawData) {

        log.info("解析数据:" + deviceRawData);

        // 解析数据
        DataPuKeYy106 deviceData = JSON.parseObject(deviceRawData, DataPuKeYy106.class);

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
