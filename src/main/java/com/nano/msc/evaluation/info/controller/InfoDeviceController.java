package com.nano.msc.evaluation.info.controller;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.service.InfoDeviceService;
import com.nano.msc.evaluation.info.service.impl.InfoDeviceServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import io.swagger.annotations.Api;

/**
 * 手术仪器控制器
 * @author nano
 */
@RestController
@RequestMapping("/device")
@Api(value = "InfoDeviceController", description = "仪器控制器")
public class InfoDeviceController {

    @Autowired
    private InfoDeviceServiceImpl deviceService;

    private int counter = 0;

    @GetMapping("/list")
    public CommonResult getDeviceInfo(@Min(value = 0, message = "页数不能小于1") @RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @Min(value = 1, message = "数据个数不能小于1") @RequestParam(value = "size", defaultValue = "5") Integer size) {
        System.out.println("Get Request:" + counter++);
        return deviceService.list(page, size);
    }



}
