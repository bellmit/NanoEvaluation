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
 * 迈瑞WATOEX麻醉机数据实体类
 *
 * @author msc206
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "data_MaiRuiWatoex65")
public class MaiRuiWatoex65 implements Serializable {

    private static final long serialVersionUID = 9019102392148835864L;

    @Column(name = "PMean")
    private Integer PMean;

    @Column(name = "PEEP")
    private Integer PEEP;

    @Column(name = "PPlat")
    private Integer PPlat;

    @Column(name = "PPeak")
    private Integer PPeak;

    @Column(name = "MV")
    private Double MV;

    @Column(name = "TVe")
    private Integer TVe;

    @Column(name = "IE")
    private Double IE;

    @Column(name = "Rate")
    private Integer Rate;

    @Column(name = "C")
    private Integer C;

    @Column(name = "R")
    private Integer R;

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
