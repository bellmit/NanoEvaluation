package com.nano.msc.evaluation.info.controller;

import com.nano.msc.common.vo.CollectionPostEntity;
import com.nano.msc.common.vo.CollectionVo;
import com.nano.msc.common.vo.CommonResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 仪器数据采集前端控制器
 * @author nano
 */
@Api("仪器数据采集的前端控制器")
@RestController
@RequestMapping("/collection")
public class DeviceDataCollectionController {



    @PostMapping("/devicedata")
    public CommonResult postDeviceDataCollectionMessage(
            @RequestBody CollectionPostEntity collectionPostEntity) {
        return CommonResult.success(collectionPostEntity);
    }

}
