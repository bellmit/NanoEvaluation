package com.nano.msc.evaluation.devicedata.param;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 上传到服务器的数据实体参数类
 * @author cz
 */
@Data
@NoArgsConstructor
public class ParamDeviceData {

    /**
     * 仪器号
     */
    private int deviceCode;

    /**
     * 仪器数据
     */
    private String deviceData;


    public ParamDeviceData(int deviceCode, String deviceData) {
        this.deviceCode = deviceCode;
        this.deviceData = deviceData;
    }
}
