package com.nano.msc.useless;



import lombok.Data;

/**
 * 诺和的数据实体类
 * @author cz
 */
@Data
public class DataNuoHe {

    /**
     * 手术场次号
     */
    private Integer operationNumber;

    /**
     * 序列号
     */
    private String serialNumber;

    /**
     * CSI
     */
    private Integer csi;

    /**
     * BS
     */
    private Integer bs;

    /**
     * SQI
     */
    private Integer sqi;

    /**
     * EMG
     */
    private Integer emg;

    /**
     * 采集时间
     */
    private String gmtCreate;

    public DataNuoHe() {}

    public DataNuoHe(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
