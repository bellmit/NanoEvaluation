package com.nano.msc.evaluation.info.controller;

import com.nano.msc.common.vo.ResultDTO;
import com.nano.msc.common.vo.ResultVO;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.service.InfoOperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/info/operation")
@Api(value = "手术信息Controller")
public class InfoOperationController {

    @Autowired
    private InfoOperationService infoOperationService;


    @PostMapping("/add")
    public ResultVO addOperationInfo(@RequestBody InfoOperation infoOperation) {
        return ResultVO.checkAndReturn(ResultDTO
                .success(infoOperationService.addOperationInfo(infoOperation)));
    }


    @GetMapping("/all")
    public ResultVO findAllOperationInfo() {
        return ResultVO.checkAndReturn(ResultDTO
                .success(infoOperationService.findAllOperationInfo()));
    }
}
