package com.nano.msc.evaluation.info.controller;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.service.InfoOperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import io.swagger.annotations.Api;

/**
 * 手术信息控制器
 * @author nano
 */
@RestController
@Api(tags = "InfoOperationController", description = "手术信息控制器")
@RequestMapping("/operation")
public class InfoOperationController {


    @Autowired
    private InfoOperationService operationService;


    @PostMapping("/add")
    public CommonResult addOperationInfo(@Valid @RequestBody InfoOperation operation) {
        return CommonResult.success(operation);
    }

}
