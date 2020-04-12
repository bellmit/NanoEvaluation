package com.nano.msc.evaluation.info.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nano.msc.common.converter.LocalDateTimeConverter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 手术信息实体
 *
 * @author nano
 * Description: 手术的各类信息汇总表
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_operation")
public class InfoOperation implements Serializable {

    private static final long serialVersionUID = -5085503116296589504L;
    /**
     * 手术顺序号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_operation_number")
    private Integer operationNumber;

    /**
     * 住院号
     */
    @NotBlank(message = "operationName must cannot empty")
    @ApiModelProperty(value = "住院号", example = "438212309123")
    private String admissionNumber;

    /**
     * 医院的手术顺序号
     * 每个医院的都不一样
     */
    @NotBlank(message = "hospital_operation_number must cannot empty")
    @Column(name = "hospital_operation_number")
    @ApiModelProperty(value = "医院的手术顺序号", example = "AS1235621")
    private String hospitalOperationNumber;


    /**************************************病人信息*********************************************/
    /**
     * 病人身份证号
     */
    @NotBlank(message = "patientId must cannot empty")
    @ApiModelProperty(value = "病人身份证号", example = "400382195912021273")
    @Column(name = "patient_id")
    private String patientId;

    /**
     * 性别0--男，1--女
     */
    @NotNull(message = "sex must cannot empty")
    @ApiModelProperty(value = "性别0--男，1--女", example = "0")
    @Column(name = "sex")
    private Integer sex;

    /**
     * 身高
     */
    @NotNull(message = "height must cannot empty")
    @ApiModelProperty(value = "身高", example = "180")
    @Column(name = "height")
    private Integer height;

    /**
     * 体重
     */
    @NotNull(message = "weight must cannot empty")
    @ApiModelProperty(value = "体重", example = "70")
    @Column(name = "weight")
    private Double weight;

    /**
     * 年龄
     */
    @NotNull(message = "age must cannot empty")
    @ApiModelProperty(value = "年龄", example = "87")
    @Column(name = "age")
    private Integer age;


    /**************************************手术信息*********************************************/
    /**
     * 手术名称
     */
    @NotBlank(message = "operationName must cannot empty")
    @Column(name = "operation_name")
    @ApiModelProperty(value = "手术名称", example = "剪脚趾甲")
    private String operationName;

    /**
     * 麻醉方式
     */
    @Column(name = "anesthesia_mode")
    @ApiModelProperty(value = "麻醉方式", example = "局部麻醉")
    private String anesthesiaMode;

    /**
     * 是否急诊
     */
    @Column(name = "is_urgent")
    @ApiModelProperty(value = "是否急诊", example = "true")
    private Boolean isUrgent;

    /**
     * ASA等级
     */
    @Column(name = "asa_level")
    @ApiModelProperty(value = "ASA等级", example = "3")
    private Integer asaLevel;

    /**
     * 既往病史
     */
    @Column(name = "medical_history")
    @ApiModelProperty(value = "既往病史", example = "无")
    private String medicalHistory;

    /**
     * 特殊情况
     */
    @Column(name = "special_case")
    @ApiModelProperty(value = "特殊情况", example = "无")
    private String specialCase;

    /**
     * 使用仪器信息
     *
     * 不与手术信息数据表对应
     *
     * 获取此值之后再解析成仪器信息表
     */
    @Transient
    private String usedDeviceInfo;

    /**************************************数据采集信息*********************************************/
    /**
     * 本次采集采集器MAC地址
     */
    @Column(name = "collector_mac_address")
    @ApiModelProperty(value = "本次采集采集器MAC地址", example = "08:00:20:0A:8C:6D")
    private String collectorMacAddress;

    /**
     * 手术开始时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "operation_start_time")
    private LocalDateTime operationStartTime;

    /**
     * 手术结束时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "operation_end_time")
    private LocalDateTime operationEndTime;

    /**
     * 手术状态
     */
    @Column(name = "operation_state")
    private Integer operationState;


    /**
     * 数据创建时间
     */
//    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "gmt_create")
    @ApiModelProperty(value = "创建时间")
    @CreationTimestamp
    private LocalDateTime gmtCreate;

    /**
     * 数据修改时间
     */
//    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "gmt_modified")
    @ApiModelProperty(value = "更新时间")
    @UpdateTimestamp
    private LocalDateTime gmtModified;
}

