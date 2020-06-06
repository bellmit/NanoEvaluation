package com.nano.msc.evaluation.platform.controller;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.service.InfoDeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 平台仪器Card控制器
 *
 * @author: nano
 * @time: 2020/6/6 11:57
 */
@Slf4j
@Api(tags = "PlatformDeviceCardController", description = "平台仪器Card控制器")
@RestController
@RequestMapping("/platform/device_card")
public class PlatformDeviceCardController {

	@Autowired
	private InfoDeviceService deviceService;


	@ApiOperation("查询手术场次号拥有的序列号列表")
	@GetMapping("/device_serial_number_list")
	public CommonResult getHistoryCollectionTime(@RequestParam(value = "deviceCode", defaultValue = "30") String deviceCode) {
		return deviceService.getSerialNumberListByDeviceCode(deviceCode);
	}



	@ApiOperation("查询某台仪器卡片展示信息")
	@GetMapping("/device_statistic_info")
	public CommonResult getDeviceCardInfo(@RequestParam(value = "deviceCode", defaultValue = "30") String deviceCode,
											   @RequestParam(value = "deviceSerialNumber", defaultValue = "11111") String deviceSerialNumber) {
		return deviceService.getDeviceCardDetailInfo(deviceCode, deviceSerialNumber);
	}



}
