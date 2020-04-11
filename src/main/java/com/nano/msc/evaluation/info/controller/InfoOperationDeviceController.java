package com.nano.msc.evaluation.info.controller;

import com.nano.msc.evaluation.info.service.InfoOperationDeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 手术使用仪器控制器
 * @author nano
 */
@RestController
@RequestMapping("/operation_device")
public class InfoOperationDeviceController {

    @Autowired
    private InfoOperationDeviceService operationDeviceService;


}
