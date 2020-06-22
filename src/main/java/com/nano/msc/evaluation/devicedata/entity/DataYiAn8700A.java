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
@Table(name = "data_yi_an8700a")
public class DataYiAn8700A implements Serializable {

    private static final long serialVersionUID = -2529981539986516802L;
    @Column(name = "peak")
    private Double peak;

    @Column(name = "plat")
    private Double plat;

    @Column(name = "pmean")
    private Double pmean;

    @Column(name = "peep")
    private Double peep;

    @Column(name = "mv")
    private Double mv;

    @Column(name = "vte")
    private Double vte;

    @Column(name = "freq")
    private Double freq;

    @Column(name = "fio2")
    private Double fio2;

    @Column(name = "etco2")
    private Double etco2;

    @Column(name = "fico2")
    private Double fico2;

    @Column(name = "n2oInsp")
    private Double n2oInsp;

    @Column(name = "n2oExp")
    private Double n2oExp;

    @Column(name = "mac")
    private Double mac;

    @Column(name = "n2o")
    private Double n2o;

    @Column(name = "air")
    private Double air;

    @Column(name = "o2")
    private Double o2;

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
