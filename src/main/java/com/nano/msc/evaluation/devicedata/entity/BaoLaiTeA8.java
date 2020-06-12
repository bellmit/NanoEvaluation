package com.nano.msc.evaluation.devicedata.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nano.msc.common.converter.LocalDateTimeConverter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
 * 宝莱特的数据实体类
 * @author cz
 *
 * 存储不同的参数数值以及对应的波形字符串以备后续使用
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "data_BaoLaiTe")
public class BaoLaiTeA8 implements Serializable {

    private static final long serialVersionUID = -8052271381912697989L;

    /**
     * 心率数据值及其波形 E0
     */
    private Integer hr;

    /**
     * 血氧值模块数据及其波形 E1
     */
    private Integer spo2;

    /**
     * 脉搏数据值 E2
     */
    private Integer pr;

    /**
     * 呼吸率及其波形 E3
     */
    private Integer breatheRate;

    /**
     * 体温值 E4
     */
    private Double temperature;

    /**
     * 无创血压全部数值（3个） E5 NIBP
     */
    private Double nibpSys;
    private Double nibpMap;
    private Double nibpDia;


    /**
     * 有创血压全部数值（3个） 感觉对应的是P2
     */
    private Double ibpSys;
    private Double ibpMap;
    private Double ibpDia;


    //---------下面的参数暂时没有------------------

    /**
     * CO2值 含两个参数
     */
    private Double co2Et;
    private Double co2Fi;


    /**
     * O2值 含两个参数 E8
     */
    private Double o2Et;
    private Double o2Fi;


    /**
     * N2O值 含两个参数 E9
     */
    private Double n2oEt;
    private Double n2oFi;


    /**
     * AA值 含两个参数 EA
     */
    private Double aaEt;
    private Double aaFi;

    /**
     * ICG 参数
     */
    private Double icgCi;
    private Double icgCo;
    private Double icgHr;
    private Double icgSi;
    private Double icgSv;
    private Double icgSvr;
    private Double icgSvri;
    private Double icgTfc;
    private Double icgTfi;

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
