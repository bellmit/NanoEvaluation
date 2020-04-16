package com.nano.msc;


import com.nano.msc.mq.consumer.IndicatorService;
import com.nano.msc.mq.enums.QueueEnum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestMessageQueue {


    @Autowired
    private IndicatorService indicatorService;


    @Test
    public void testKafkaSend() {

        int a = 100;
        while (true) {

            if (a-- == 0) break;
            indicatorService.sendMessage("deviceData", "DeviceDataNuoHe:" + a);
        }

    }




}
