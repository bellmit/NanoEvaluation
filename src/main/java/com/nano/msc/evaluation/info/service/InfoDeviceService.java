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

    /**
     * 通过仪器号查询对应拥有的仪器列表
     * @param deviceCode 仪器号
     * @return 仪器列表
     */
    CommonResult getSerialNumberListByDeviceCode(String deviceCode);


    /**
     * 通过仪器号与序列号获取仪器信息卡片内容
     *
     * @param deviceCode 仪器号
     * @param deviceSerialNumber 序列号
     * @return 信息卡片内容
     */
    CommonResult getDeviceCardDetailInfo(String deviceCode, String deviceSerialNumber);

}
