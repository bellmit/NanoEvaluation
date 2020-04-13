package com.nano.msc.evaluation.manualeval.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 人工问卷评价只维修记录
 * @author nano
 */
@Entity(name = "manualEvalMaintenanceRecord")
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "manual_eval_maintenance_record")
public class ManualEvalMaintenanceRecord implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    private String hospitalName;

    private String deviceProducer;

    private String deviceName;

    private String deviceUniqueId;

    private String hasBeenUsedYears;

    private String guaranteePeriod;

    private String extendWarrantyPrice;

    private String chargeMan;

    private String faultHappenTime;

    private String informMaintainTime;

    private String startMaintainTime;

    private String recoverUseTime;

    private String maintainWay;

    private String maintainPerson;

    private String isInWarrantyPeriod;

    private String faultReason;

    private String isChangeAccessory;

    private String isFixFault;

    private String maintainResponseTimeSatisfaction;

    private String maintainPriceSatisfaction;

    private String maintainServiceAttitudeSatisfaction;

    private String maintainWholeProcessSatisfaction;

    private String accessoryPrice;

    private String maintainPrice;

    private String otherPrice;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Column(name = "gmt_create", updatable = false)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Column(name = "gmt_modified")
    private LocalDateTime updateTime;


}
