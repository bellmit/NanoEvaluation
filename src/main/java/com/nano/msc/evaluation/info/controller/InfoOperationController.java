package com.nano.msc.evaluation.info.controller;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.service.InfoOperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

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


    /**
     * 手术信息分页查询
     *
     * @param page 页数
     * @param size 个数
     * @return 结果
     */
    @GetMapping("/list")
    public CommonResult listOperationInfo(@Min(value = 0, message = "页数不能小于1") @RequestParam(value = "page", defaultValue = "0") Integer page,
                                          @Min(value = 1, message = "数据个数不能小于1") @RequestParam(value = "size", defaultValue = "5") Integer size) {
        return operationService.list(page, size);
    }

}
