package com.nano.msc.evaluation.devicedata.parse.base;


/**
 * 解析采集器上传而来的仪器监测数据基类
 *
 * @author nano
 */
public interface DeviceDataParser {


    /**
     * 解析仪器原始数据并返回解析得到的仪器对象
     *
     * @param deviceRawData 原始数据
     * @return 解析后的仪器对象
     */
    boolean parseDeviceDataStringAndSave(String deviceRawData);


}
