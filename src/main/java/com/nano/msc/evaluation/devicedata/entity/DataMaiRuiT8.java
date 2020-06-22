package com.nano.msc.evaluation.devicedata.entity;


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
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 迈瑞T8监护仪数据实体
 *
 * @author cz
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "data_MaiRuiT8")
public class DataMaiRuiT8 implements Serializable {

    private static final long serialVersionUID = 2996146984144237891L;
    /**
     * ECG Heart Rate
     */
    private Integer ecgHeartRate;

    /**
     * ECG PVC Sum
     */
    private Integer ecgPvcSum;

    /**
     * ECG ST_I
     */
    private Double ecgStParameterValueSt_I;

    /**
     * ECG ST_II
     */
    private Double ecgStParameterValueSt_II;

    /**
     * ECG ST_III
     */
    private Double ecgStParameterValueSt_III;

    /**
     * ECG ST_aVR
     */
    private Double ecgStParameterValueSt_aVR;

    /**
     * ECG ST_aVL
     */
    private Double ecgStParameterValueSt_aVL;

    /**
     * ECG ST_aVF
     */
    private Double ecgStParameterValueSt_aVF;

    /**
     * ECG ST_V1
     */
    private Double ecgStParameterValueSt_V1;

    /**
     * ECG ST_V2
     */
    private Double ecgStParameterValueSt_V2;

    /**
     * ECG ST_V3
     */
    private Double ecgStParameterValueSt_V3;

    /**
     * ECG ST_V4
     */
    private Double ecgStParameterValueSt_V4;

    /**
     * ECG ST_V5
     */
    private Double ecgStParameterValueSt_V5;

    /**
     * ECG ST_V6
     */
    private Double ecgStParameterValueSt_V6;

    /**
     * ECG ST_V
     */
    private Double ecgStParameterValueSt_V;

    /**
     * RESP Respiration Rate
     */
    private Integer respRespirationRate;


    /**
     * SPO2 Percent Oxygen Saturation
     */
    private Integer spo2PercentOxygenSaturation;


    /**
     * SPO2 pulse rate
     */
    private Integer spo2PulseRate;

    /**
     * SPO2 pulse PI
     */
    private Double spo2PI;


    /**
     * NIBP Non-Invasive Blood Pressure Systolic
     */
    private Double nibpNonInvasiveBloodPressureSystolic;


    /**
     * NIBP Non-Invasive Blood Pressure Diastolic
     */
    private Double nibpNonInvasiveBloodPressureDiastolic;

    /**
     * NIBP Non-Invasive Blood Pressure Mean
     */
    private Double nibpNonInvasiveBloodPressureMean;

    /**
     * TEMP NON-Specific Temperature 1
     */
    private Double tempNonSpecificTemperature1;


    /**
     * TEMP NON-Specific Temperature 2
     */
    private Double tempNonSpecificTemperature2;


    /**
     * Temperature Difference Between the two temps
     */
    private Double tempNonSpecificTemperatureDifference;


    /**
     * CO Cardiac output
     */
    private Double coCardiacOutput;

    /**
     * CO Aperiodic parameter Cardiac index
     */
    private Double coCardiacIndex;

    /**
     * CO Aperiodic parameter Blood Pressure
     */
    private Double coBloodPressure;


    /**
     * AG CO2ET
     */
    private Integer agCo2Et;

    /**
     * AG CO2Fi
     */
    private Integer agCo2Fi;


    /**
     * AG O2Et
     */
    private Integer agO2Et;

    /**
     * AG O2Fi
     */
    private Integer agO2Fi;


    /**
     * AG N2OEt
     */
    private Integer agN2oEt;

    /**
     * AG O2Fi
     */
    private Integer agN2oFi;


    /**
     * AG ISOEt
     */
    private Double agIsoEt;

    /**
     * AG ISOFi
     */
    private Double agIsoFi;

    /**
     * AG AwRR
     */
    private Double agAwRr;


    /**
     * ART Invasive Blood Pressure Systolic
     */
    private Integer artInvasiveBloodPressureSystolic;

    /**
     * ART Invasive Blood Pressure Systolic
     */
    private Integer artInvasiveBloodPressureMean;

    /**
     * ART Invasive Blood Pressure Systolic
     */
    private Integer artInvasiveBloodPressureDiastolic;


    /**
     * ART Invasive Blood Pressure Systolic
     */
    private Integer paInvasiveBloodPressureSystolic;

    /**
     * ART Invasive Blood Pressure Systolic
     */
    private Integer paInvasiveBloodPressureMean;

    /**
     * ART Invasive Blood Pressure Systolic
     */
    private Integer paInvasiveBloodPressureDiastolic;

    /**
     * ART PPV
     */
    private Integer artPpv;

    /**
     * PR
     */
    private Integer prPr;

    /**
     * 自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

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
    /**
     * 序列号
     */
    @Column(name = "device_serial_number")
    private String serialNumber;

    /**
     * 手术顺序号
     */
    @NotNull(message = "operationNumber must cannot empty")
    @Column(name = "operation_number")
    private Integer operationNumber;
}
