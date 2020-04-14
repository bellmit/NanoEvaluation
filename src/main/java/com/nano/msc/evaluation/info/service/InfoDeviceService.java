package com.nano.msc.evaluation.info.service;


import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoDevice;

public interface InfoDeviceService {

    InfoDevice save(InfoDevice infoDevice);

    InfoDevice findByDeviceCodeAndDeviceSerialNumber(String deviceCode, String deviceSerialNumber);

    CommonResult getAll();

    CommonResult list(Integer page, Integer size);
}
