package com.nano.msc.evaluation.info.controller;

import com.nano.msc.evaluation.info.service.InfoDeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 手术仪器控制器
 * @author nano
 */
@RestController
@RequestMapping("/device")
public class InfoDeviceController {

    @Autowired
    private InfoDeviceService deviceService;





}
