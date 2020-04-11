package com.nano.msc.evaluation.info.controller;


import com.nano.msc.evaluation.info.service.InfoEvaluationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 术后评价信息控制器
 * @author nano
 */
@RestController
@RequestMapping("/evaluation")
public class InfoEvaluationController {

    @Autowired
    private InfoEvaluationService evaluationService;


}
