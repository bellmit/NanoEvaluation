package com.nano.msc.evaluation.info.controller;

import com.nano.msc.common.exceptions.ExceptionAsserts;
import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.evaluation.param.ParamCollector;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.service.DeviceDataCollectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 数据采集流程前端总控制器
 * @author nano
 */
@Slf4j
@Api(tags = "DeviceDataCollectionController", description = "数据采集流程前端控制器")
@RestController
@RequestMapping("/collection")
public class DeviceDataCollectionController {


    @Autowired
    private DeviceDataCollectionService deviceDataCollectionService;

    /**
     * 接收平板上传的各种信息
     *
     * @return 是否成功
     */
    @PostMapping("/collectdata")
    @ApiOperation(value = "接收采集器各种通信数据")
    public CommonResult<ResultVo> handleCollectorPostData(
           @Valid @RequestBody ParamCollector paramCollector) {
        if (paramCollector == null) {
            log.error("仪器数据请求失败:" + paramCollector.toString());
            ExceptionAsserts.fail("仪器数据请求失败");
        }
        // 进行数据处理并返回结果
        return deviceDataCollectionService.handleCollectorPostedData(paramCollector);
    }

}
