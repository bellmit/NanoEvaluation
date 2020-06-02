package com.nano.msc.platform;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.devicedata.repository.PuKeYy106Repository;
import com.nano.msc.evaluation.info.service.InfoOperationService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: nano
 * @time: 2020/5/26 19:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PlatformDeviceInfoTest {

	@Autowired
	private InfoOperationService operationService;

	@Autowired
	private PuKeYy106Repository puKeYy106Repository;


	@Test
	public void testHistoryCollectionTime() {

		System.out.println(JSON.toJSONString(operationService.getHistoryCollectionTime(7).getData()));

	}


	@Test
	public void testNeweastOperationInfo() {

		;
		System.out.println(JSON.toJSONString(operationService.getOperationList(0, 3)));
	}


	@Test
	public void testPuKe() {
	}
}
