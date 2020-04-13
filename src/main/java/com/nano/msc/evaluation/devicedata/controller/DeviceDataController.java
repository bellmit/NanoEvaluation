package com.nano.msc.evaluation.devicedata.controller;

import com.nano.msc.common.exceptions.ExceptionAsserts;
import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.devicedata.service.DeviceDataService;
import com.nano.msc.evaluation.param.ParamCollector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "DeviceDataController", description = "仪器数据上传前端控制器")
@RestController
@RequestMapping("/data")
public class DeviceDataController {


    @Autowired
    private DeviceDataService deviceDataService;


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
            ExceptionAsserts.fail("仪器数据请求失败");
        }
        // 进行数据处理并返回结果
        return deviceDataService.handleCollectorPostDeviceData(paramCollector);
    }
}
