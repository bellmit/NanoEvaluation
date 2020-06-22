package com.nano.msc.evaluation.platform.controller;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.service.InfoEvaluationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 仪器术后评价平台接口
 *
 * @author: nano
 * @time: 2020/5/27 9:22
 */
@Slf4j
@Api(tags = "PlatformDeviceEvaluationController", description = "平台仪器术后评价接口")
@RestController
@RequestMapping("/platform/device_evaluation")
public class PlatformDeviceEvaluationController {


	@Autowired
	private InfoEvaluationService evaluationService;


	@ApiOperation("根据序列号查询仪器评价信息")
	@GetMapping("/statistic_one")
	public CommonResult getOneDeviceStatisticInfo(@RequestParam(value = "deviceCode", defaultValue = "32") Integer deviceCode,
												  @RequestParam(value = "serialNumber", defaultValue = "123456") String serialNumber) {
		return evaluationService.getOneDeviceEvaluationStatisticInfo(deviceCode, serialNumber);
	}


	@ApiOperation("查询某台仪器全部评价信息")
	@GetMapping("/statistic_total")
	public CommonResult getTotalDeviceStatisticInfo(@RequestParam(value = "deviceCode", defaultValue = "30") Integer deviceCode) {
		return evaluationService.getTotalDeviceEvaluationStatisticInfo(deviceCode);
	}




}
