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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 手术标记信息实体
 *
 * @author cz
 * Description: 标记大类型 标记小类型 事件类型 途径 剂量 不良反应/特殊情况
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@NoArgsConstructor
@Table(name = "info_operation_mark")
public class InfoOperationMark implements Serializable {

    private static final long serialVersionUID = -4892589808381433198L;
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
    @NotNull(message = "operation_Number must cannot empty")
    @Column(name = "operation_Number")
    private Integer operationNumber;

    /**
     * 标记大类型
     */
    @NotBlank(message = "mark_main_type must cannot empty")
    @Column(name = "mark_main_type")
    private String markMainType;

    /**
     * 标记类型
     */
    @NotBlank(message = "`mark_sub_Type` must cannot empty")
    @Column(name = "`mark_sub_Type`")
    private String markSubType;

    /**
     * 事件类型
     */
    @NotBlank(message = "mark_event must cannot empty")
    @Column(name = "mark_event")
    private String markEvent;

    /**
     * 途径
     */
    @NotBlank(message = "give_medicine_method must cannot empty")
    @Column(name = "give_medicine_method")
    private String giveMedicineMethod;

    /**
     * 剂量
     */
    @NotBlank(message = "give_medicine_volume must cannot empty")
    @Column(name = "give_medicine_volume")
    private String giveMedicineVolume;

    /**
     * 不良反应/特殊情况
     */
    @NotBlank(message = "side_effect must cannot empty")
    @Column(name = "side_effect")
    private String sideEffect;

    /**
     * 标记信息标记的时间
     */
    @JsonSerialize(using = LocalDateTimeConverter.class)
    @NotNull(message = "mark_time must cannot empty")
    @Column(name = "mark_time")
    private LocalDateTime markTime;


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


    public InfoOperationMark(@NotBlank(message = "operation_Number must cannot empty") Integer operationNumber, @NotBlank(message = "mark_main_type must cannot empty") String markMainType, @NotBlank(message = "`mark_sub_Type` must cannot empty") String markSubType, @NotBlank(message = "mark_event must cannot empty") String markEvent, @NotBlank(message = "give_medicine_method must cannot empty") String giveMedicineMethod, @NotBlank(message = "give_medicine_volume must cannot empty") String giveMedicineVolume, @NotBlank(message = "side_effect must cannot empty") String sideEffect, @NotNull(message = "mark_time must cannot empty") LocalDateTime markTime) {
        this.operationNumber = operationNumber;
        this.markMainType = markMainType;
        this.markSubType = markSubType;
        this.markEvent = markEvent;
        this.giveMedicineMethod = giveMedicineMethod;
        this.giveMedicineVolume = giveMedicineVolume;
        this.sideEffect = sideEffect;
        this.markTime = markTime;
    }
}
