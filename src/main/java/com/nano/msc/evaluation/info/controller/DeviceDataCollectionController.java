package com.nano.msc.evaluation.info.controller;

import com.nano.msc.common.exceptions.ExceptionAsserts;
import com.nano.msc.common.utils.ParseJsonUtil;
import com.nano.msc.common.vo.CollectionVo;
import com.nano.msc.evaluation.param.CollectDataParam;
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

/**
 * 仪器数据采集前端控制器
 * @author nano
 */
@Api(tags = "DeviceDataCollectionController", description = "仪器数据采集前端控制器")
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
    public CommonResult<CollectionVo> handleCollectorPostData(
           @Valid @RequestBody CollectDataParam collectDataParam) {
        // 解析字符串
//        CollectDataParam collectDataParam = ParseJsonUtil.parseAndCheck(jsonData, CollectDataParam.class);

        if (collectDataParam == null) {
            ExceptionAsserts.fail("仪器数据请求失败");
        }
        System.out.println(collectDataParam.toString());
        System.out.println(collectDataParam.getData());
        // 进行数据处理并返回结果
        return deviceDataCollectionService.handleCollectorPostData(collectDataParam);
    }

}
