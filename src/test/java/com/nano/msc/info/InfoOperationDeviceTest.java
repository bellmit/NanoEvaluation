package com.nano.msc.info;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.info.repository.InfoOperationDeviceRepository;
import com.nano.msc.evaluation.info.service.InfoOperationDeviceService;
import com.nano.msc.evaluation.info.service.impl.InfoOperationDeviceServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: nano
 * @time: 2020/5/26 16:20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class InfoOperationDeviceTest {


	@Autowired
	private InfoOperationDeviceRepository operationDeviceRepository;

	@Autowired
	private InfoOperationDeviceService infoOperationDeviceService;

	@Test
	public void testHistoryNumber() {

		log.info(JSON.toJSONString(infoOperationDeviceService.getDeviceOpenNumberHistory(7)));
	}

}
