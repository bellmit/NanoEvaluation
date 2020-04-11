package com.nano.msc.evaluation.info.controller;

import com.nano.msc.evaluation.info.service.InfoOperationMarkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 手术标记信息控制器
 * @author nano
 */
@RestController
@RequestMapping("/operation_mark")
public class InfoOperationMarkController {

    @Autowired
    private InfoOperationMarkService operationMarkService;


}
