package com.nano.msc.useless;



import lombok.Data;

/**
 * 浙江普可的数据实体类
 * @author cz
 */
@Data
public class DataPuKe {

    /**
     * 仪器号
     */
    private Integer operationNumber = 0;

    /**
     * 序列号
     */
    private String serialNumber;

    /**
     * AI
     */
    private Integer Ai = 0;

    /**
     * BSR
     */
    private Integer BSR = 0;

    /**
     * EMG
     */
    private Integer EMG = 0;

    /**
     * SQI
     */
    private Integer SQI = 0;


    public DataPuKe(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
