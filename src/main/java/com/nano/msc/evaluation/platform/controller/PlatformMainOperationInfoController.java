package com.nano.msc.evaluation.platform.controller;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.service.InfoEvaluationService;
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
 * 平台手术信息控制器
 *
 * @author: nano
 * @time: 2020/5/25 20:59
 */
@Slf4j
@Api(tags = "PlatformOperationInfoController", description = "平台主页手术信息相关接口")
@RestController
@RequestMapping("/platform/operation/main")
public class PlatformMainOperationInfoController {

	/**
	 * 手术信息的服务
	 */
	@Autowired
	private InfoOperationService operationService;


	@Autowired
	private InfoEvaluationService evaluationService;


	/**
	 * 获取正在进行的手术场次
	 *
	 * @return 手术信息
	 */
	@ApiOperation("获取总手术场次数")
	@GetMapping("/count_operation_number")
	public CommonResult countAllOperationNumber() {
		return operationService.countAllOperationNumber();
	}


	/**
	 * 手术信息分页查询 按照时间顺序降序排列
	 *
	 * @param page 页数
	 * @param size 个数
	 * @return 结果
	 */
	@ApiOperation("手术信息分页查询")
	@GetMapping("/list")
	public CommonResult listNewOperationInfo(@Min(value = 0, message = "页数不能小于1") @RequestParam(value = "page", defaultValue = "0") Integer page,
										  @Min(value = 1, message = "数据个数不能小于1") @RequestParam(value = "size", defaultValue = "5") Integer size) {
		return operationService.getOperationList(page, size);
	}


	/**
	 * 获取正在进行的手术场次
	 *
	 * @return 手术信息
	 */
	@ApiOperation("获取正在进行的手术场次")
	@GetMapping("/processing")
	public CommonResult getProcessingOperationList() {
		return operationService.getProcessingOperationList();
	}


	/**
	 * 获取历史手术采集次数信息
	 *
	 * @param days 历史天数
	 * @return 手术场次信息
	 */
	@ApiOperation(value = "获取历史手术采集次数信息", notes = "参数为历史天数")
	@GetMapping("/history_operation_number")
	public CommonResult getHistoryOperationNumber(@RequestParam(value = "days", defaultValue = "7") int days) {
		return operationService.getHistoryOperationNumber(days);
	}


	/**
	 * 获取所以术后评价信息个数
	 *
	 * @return 术后评价信息个数
	 */
	@ApiOperation("获取所以术后评价信息个数")
	@GetMapping("/evaluation_counter")
	public CommonResult<Integer> countDeviceEvaluationNumber() {
		return evaluationService.countAllEvaluationNumber();
	}



}
