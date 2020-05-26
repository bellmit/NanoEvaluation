package com.nano.msc.evaluation.info.service;


import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoDevice;

/**
 * 仪器信息服务接口
 * @author: nano
 */
public interface InfoDeviceService {

    InfoDevice save(InfoDevice infoDevice);

    InfoDevice findByDeviceCodeAndDeviceSerialNumber(String deviceCode, String deviceSerialNumber);

    CommonResult getAll();


    CommonResult list(Integer page, Integer size);


    /**
     * 获取接入仪器总数量
     * @return 数量
     */
    CommonResult getDeviceNumber();
}
