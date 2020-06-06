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
import lombok.NoArgsConstructor;

/**
 * 手术仪器信息实体
 *
 * @author nano
 * @version V1.0
 * @date 2019/5/28 13:00
 * Description:手术场次号 仪器号 仪器序列号
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@NoArgsConstructor
@Table(name = "info_operation_device")
public class InfoOperationDevice implements Serializable {

    private static final long serialVersionUID = -7456701585085979233L;

    /**
     * 标记id，自动增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    /**
     * 手术顺序号
     */
    @NotNull(message = "OperationNumber must cannot empty")
    @Column(name = "operation_number")
    private Integer operationNumber;

    /**
     * 仪器号
     */
    @NotNull(message = "DeviceCode must cannot empty")
    @Column(name = "device_code")
    private String deviceCode;

    /**
     * 仪器信息的ID号 外键仪器信息表的主键ID号
     */
    @Column(name = "device_info_id")
    private Integer deviceInfoId;


    /**
     * 数据总条数
     */
    private Integer dataNumber;

    /**
     * 手术持续时间
     */
    private Long operationDurationTime;

    /**
     * 掉线率
     */
    private Double dropRate;

    /**
     * 采集开始时间
     */
    private LocalDateTime collectionStartTime;

    /**
     * 采集结束时间
     */
    private LocalDateTime collectionEndTime;


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


    public InfoOperationDevice(@NotNull(message = "OperationNumber must cannot empty") Integer operationNumber, @NotNull(message = "DeviceCode must cannot empty") String deviceCode, @NotBlank(message = "DeviceInfoId must cannot empty") Integer deviceInfoId) {
        this.operationNumber = operationNumber;
        this.deviceCode = deviceCode;
        this.deviceInfoId = deviceInfoId;
    }
}
