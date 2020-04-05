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
 * 宜安8700A麻醉机的数据实体类
 * @author cz
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "data_YiAn8700A")
public class YiAn8700A implements Serializable {

    private static final long serialVersionUID = -2529981539986516802L;
    @Column(name = "PEAK")
    private Double PEAK;

    @Column(name = "PLAT")
    private Double PLAT;

    @Column(name = "Pmean")
    private Double Pmean;

    @Column(name = "PEEP")
    private Double PEEP;

    @Column(name = "MV")
    private Double MV;

    @Column(name = "Vte")
    private Double Vte;

    @Column(name = "Freq")
    private Double Freq;

    @Column(name = "Fio2")
    private Double Fio2;

    @Column(name = "Etco2")
    private Double Etco2;

    @Column(name = "fico2")
    private Double fico2;

    @Column(name = "N2OInsp")
    private Double N2OInsp;

    @Column(name = "N2OExp")
    private Double N2OExp;

    @Column(name = "MAC")
    private Double MAC;

    @Column(name = "N2O")
    private Double N2O;

    @Column(name = "AIR")
    private Double AIR;

    @Column(name = "O2")
    private Double O2;

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
