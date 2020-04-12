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
import lombok.NoArgsConstructor;

/**
 * 医疗仪器的基础属性
 *
 * @version V1.0
 * Description: 仪器生产厂商 仪器序列号 购买时间 使用年限
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@NoArgsConstructor
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
     * 仪器代号
     */
    @NotBlank(message = "deviceCode must cannot empty")
    @ApiModelProperty(value = "仪器代号", example = "30")
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 设备序列号，不一定唯一
     */
    @NotBlank(message = "deviceSerialNumber must cannot empty")
    @ApiModelProperty(value = "设备序列号", example = "B123XY182019")
    @Column(name = "device_serial_number")
    private String deviceSerialNumber;

    /**
     * 设备购买时间
     */
    @ApiModelProperty(value = "设备购买时间", example = "2018.06.25")
    @Column(name = "device_produce_date")
    private LocalDate deviceProduceDate;

    /**
     * 仪器的使用年限
     */
    @NotNull(message = "deviceServiceLife must cannot empty")
    @ApiModelProperty(value = "仪器的使用年限", example = "5")
    @Column(name = "device_service_life")
    private Double deviceServiceLife;

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


    public InfoDevice(@NotBlank(message = "deviceCode must cannot empty") String deviceCode, @NotBlank(message = "deviceSerialNumber must cannot empty") String deviceSerialNumber, @NotNull(message = "deviceServiceLife must cannot empty") Double deviceServiceLife) {
        this.deviceCode = deviceCode;
        this.deviceSerialNumber = deviceSerialNumber;
        this.deviceServiceLife = deviceServiceLife;
    }
}
