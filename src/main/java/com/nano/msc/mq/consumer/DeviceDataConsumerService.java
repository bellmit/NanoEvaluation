package com.nano.msc.mq.consumer;

import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.evaluation.devicedata.component.DataParserContext;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

import javax.annotation.PostConstruct;

/**
 * 仪器数据的消费者
 */
@Component
public class DeviceDataConsumerService {

    private Logger LOG = LoggerFactory.getLogger(DeviceDataConsumerService.class);

    @Autowired
    private DataParserContext dataParserContext;


    /**
     * 仪器数据解析的Map 键是DeviceCode，值是对应的DataParser
     */
    private Map<Integer, DeviceDataParser> dataParserMap;


    @KafkaListener(topics = "deviceData")
    public void processMessage(ConsumerRecord<Integer, String> record) {
//        LOG.info("processMessage, topic = {}, msg = {}", record.topic(), record.value());

        System.out.println(record.value());

        String[] values = record.value().split("@");
        if (values.length != 2) {
            return;
        }

        int deviceCode = Integer.parseInt(values[0]);
        String deviceRawData = values[1];

        // 说明存在这个仪器的解析器
        if (!dataParserMap.containsKey(deviceCode)) {
            return ;
        }
        // 解析并存储这个JSON
        boolean success = dataParserMap.get(deviceCode).parseDeviceDataStringAndSave(deviceRawData);
        LOG.info(success + "");
    }

    /**
     * 容器构造时初始化
     */
    @PostConstruct
    private void init() {
        this.dataParserMap = dataParserContext.getDataParserMap();
    }
}
