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
 * 平台详细手术信息控制器
 *
 * @author: nano
 * @time: 2020/5/25 20:59
 */
@Slf4j
@Api(tags = "PlatformDetailOperationInfoController", description = "平台详细手术信息相关接口")
@RestController
@RequestMapping("/platform/operation/detail")
public class PlatformDetailOperationInfoController {

	/**
	 * 手术信息的服务
	 */
	@Autowired
	private InfoOperationService operationService;

	/**
	 * 术后仪器评价信息服务
	 */
	@Autowired
	private InfoEvaluationService evaluationService;


	@ApiOperation("获取某场手术详细信息")
	@GetMapping("/all_info")
	public CommonResult getAllOperationInfo(@RequestParam(value = "operationNumber")
												@Min(value = 1, message = "查询手术场次号不能小于1")  int operationNumber) {


		return operationService.getDetailInfoOfOneOperation(operationNumber);

	}

}
