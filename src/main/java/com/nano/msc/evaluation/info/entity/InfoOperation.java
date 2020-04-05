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
    private String admissionNumber;

    /**
     * 医院的手术顺序号
     * 每个医院的都不一样
     */
    @NotBlank(message = "hospital_operation_number must cannot empty")
    @Column(name = "hospital_operation_number")
    private String hospitalOperationNumber;


    /**************************************病人信息*********************************************/
    /**
     * 病人身份证号
     */
    @NotBlank(message = "patientId must cannot empty")
    @Column(name = "patient_id")
    private String patientId;

    /**
     * 性别0--男，1--女
     */
    @NotNull(message = "sex must cannot empty")
    @Column(name = "sex")
    private Integer sex;

    /**
     * 身高
     */
    @NotNull(message = "height must cannot empty")
    @Column(name = "height")
    private Integer height;

    /**
     * 体重
     */
    @NotNull(message = "weight must cannot empty")
    @Column(name = "weight")
    private Float weight;

    /**
     * 年龄
     */
    @NotNull(message = "age must cannot empty")
    @Column(name = "age")
    private Integer age;


    /**************************************手术信息*********************************************/
    /**
     * 手术名称
     */
    @NotBlank(message = "operationName must cannot empty")
    @Column(name = "operation_name")
    private String operationName;

    /**
     * 麻醉方式
     */
    @Column(name = "anesthesia_mode")
    private String anesthesiaMode;

    /**
     * 是否急诊
     */
    @Column(name = "is_urgent")
    private Boolean isUrgent;

    /**
     * ASA等级
     */
    @Column(name = "asa_level")
    private Integer asaLevel;

    /**
     * 既往病史
     */
    @Column(name = "medical_history")
    private String medicalHistory;

    /**
     * 特殊情况
     */
    @Column(name = "special_case")
    private String specialCase;


    /**************************************数据采集信息*********************************************/
    /**
     * 本次采集采集器MAC地址
     */
    @Column(name = "collector_mac_address")
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
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "gmt_create")
    @ApiModelProperty(value = "创建时间")
    @CreationTimestamp
    private LocalDateTime gmtCreate;

    /**
     * 数据修改时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @Column(name = "gmt_modified")
    @ApiModelProperty(value = "更新时间")
    @UpdateTimestamp
    private LocalDateTime gmtModified;
}

