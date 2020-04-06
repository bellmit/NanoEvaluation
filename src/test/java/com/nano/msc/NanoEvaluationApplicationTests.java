package com.nano.msc;

import com.nano.msc.msm.service.MsmService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class NanoEvaluationApplicationTests {

	@Autowired
	private MsmService cmsService;

	@Test
	void contextLoads() {
		Map<String, Object> map = new HashMap<>();
		map.put("code", "1231");
		cmsService.sendMsm(map, "15923021755");

	}

}
