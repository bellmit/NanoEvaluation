package com.nano.msc.evaluation.platform.controller;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.service.InfoDeviceService;
import com.nano.msc.evaluation.info.service.InfoOperationDeviceService;
import com.nano.msc.evaluation.info.service.InfoOperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 平台仪器信息控制器
 *
 * @author: nano
 * @time: 2020/5/25 20:59
 */
@Slf4j
@Api(tags = "PlatformDeviceInfoController", description = "平台主页仪器信息相关接口")
@RestController
@RequestMapping("/platform/device")
public class PlatformMainDeviceInfoController {

	@Autowired
	private InfoDeviceService infoDeviceService;


	/**
	 * 手术信息的服务
	 */
	@Autowired
	private InfoOperationService operationService;


	/**
	 * 手术仪器使用信息
	 */
	@Autowired
	private InfoOperationDeviceService operationDeviceService;

	/**
	 * 获取接入仪器总数量
	 * @return 数量
	 */
	@ApiOperation("获取接入仪器总数量")
	@GetMapping("/count")
	public CommonResult getDeviceNumber() {
		return infoDeviceService.getDeviceNumber();
	}


	/**
	 * 获取仪器历史开机信息
	 *
	 * @param days 历史天数
	 * @return 开机信息
	 */
	@ApiOperation(value = "获取仪器历史开机数量", notes = "参数为历史天数")
	@GetMapping("/history_device_open_number")
	public CommonResult getHistoryDeviceOpenNumber(@RequestParam(value = "days", defaultValue = "7") int days) {
		return operationDeviceService.getDeviceOpenNumberHistory(days);
	}


	/**
	 * 获取仪器历史采集时间信息
	 *
	 * @param days 历史天数
	 * @return 采集时间列表
	 */
	@ApiOperation("查询历史采集时长")
	@GetMapping("/history_collection_time")
	public CommonResult getHistoryCollectionTime(@RequestParam(value = "days", defaultValue = "7")
														 @Min(value = 1, message = "查询历史日期不能小于1")  int days) {
		return operationService.getHistoryCollectionTime(days);
	}


}
