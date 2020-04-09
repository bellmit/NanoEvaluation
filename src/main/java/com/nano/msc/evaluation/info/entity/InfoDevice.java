package com.nano.msc.evaluation.info.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nano.msc.common.converter.LocalDateTimeConverter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
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
 * 医疗仪器的基础属性
 *
 * @version V1.0
 * @date 2019/4/2 20:14
 * @email vinicolor.violet.end@gmail.com
 * Description: 仪器生产厂商 仪器序列号 购买时间 使用年限
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_device")
public class InfoDevice implements Serializable {

    private static final long serialVersionUID = 233410313766289238L;
    /**
     * 自动增长ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 设备生产厂商
     */
    @NotBlank(message = "deviceCode must cannot empty")
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 设备序列号，不一定唯一
     */
    @NotBlank(message = "deviceSerialNumber must cannot empty")
    @Column(name = "device_serial_number")
    private String deviceSerialNumber;

    /**
     * 设备购买时间
     */
    @NotBlank(message = "deviceProduceDate must cannot empty")
    @Column(name = "device_produce_date")
    private LocalDate deviceProduceDate;

    /**
     * 仪器的使用年限
     */
    @NotNull(message = "deviceServiceLife must cannot empty")
    @Column(name = "device_service_life")
    private Float deviceServiceLife;

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