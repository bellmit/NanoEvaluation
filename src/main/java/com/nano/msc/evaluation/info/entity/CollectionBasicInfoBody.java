package com.nano.msc.evaluation.info.entity;



import lombok.Data;

/**
 * 采集基本信息实体
 * @author cz
 *
 * 这个实体包含了病人信息和仪器基本信息
 */
@Data
public class CollectionBasicInfoBody {

    /**
     * 医院地区
     */
    private String hospitalArea;

    /**
     * 医院等级
     */
    private String hospitalLevel;

    /**
     * 医院代号
     */
    private String hospitalCode;

    /**
     * 病人身份证号
     */
    private String patientId;

    /**
     * 病人住院号
     */
    private String admissionId;

    /**
     * 病人年龄
     */
    public String patientAge;

    /**
     * 病人身高
     */
    private String patientHeight;

    /**
     * 病人体重
     */
    private String patientWeight;

    /**
     * 病人性别
     */
    private String patientSex;

    /**
     * 手术名称
     */
    private String operationName;

    /**
     * 经过选择的手术名称
     */
    private String choosedOperationName;

    /**
     * 医院实际的手术序列号
     */
    private String hospitalOperationNumber;

    /**
     * 手术是否急诊
     */
    private String operationIsUrgent;

    /**
     * 手术ASA等级
     */
    private String operationASALevel;

    /**
     * 手术麻醉方式
     */
    private String operationAnesthesiaMode;

    /**
     * 病人既往病史
     */
    private String pastMedicalHistory = "无";

    /**
     * 病人特殊情况
     */
    private String specialCase = "无";

    /**
     * 使用的仪器信息
     */
    private String usedDeviceInfo;


}
