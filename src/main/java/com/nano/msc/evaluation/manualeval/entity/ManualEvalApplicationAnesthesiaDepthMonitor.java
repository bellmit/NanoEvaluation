package com.nano.msc.evaluation.manualeval.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 问卷评价之仪器评价之麻醉深度监护仪
 * @author nano
 */
@Data
@Entity(name = "manualEvalApplicationAnesthesiaDepthMonitor")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "manual_eval_application_anesthesia_depth_monitor")
public class ManualEvalApplicationAnesthesiaDepthMonitor implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    private String companyName;

    private String deviceType;

    private String otherDeviceType;

    private String doctorName;

    private String doctorCompany;

    private String doctorDepartment;

    private String doctorDuty;

    private String doctorProfessionalTitle;

    private String doctorWorkYear;

    private String doctorFamiliarWithDevice;

    private String controlPanelDesignReasonable;

    private String controlPanelOperationConvenient;

    private String displayScreenDesignReasonable;

    private String displayScreenOperationConvenient;

    private String leadWireDesignReasonable;

    private String leadWireOperationConvenient;

    private String moveAndFixDeviceDesignReasonable;

    private String moveAndFixDeviceOperationConvenient;

    private String backupPowerUseTimeDesignReasonable;

    private String backupPowerUseTimeOperationConvenient;

    private String monitorParameterSetAndValueDesignReasonable;

    private String monitorParameterSetAndValueOperationConvenient;

    private String monitorParameterDisplayWayDesignReasonable;

    private String monitorParameterDisplayWayOperationConvenient;

    private String turnOnSelfTestDesignReasonable;

    private String turnOnSelfTestOperationConvenient;

    private String monitorParameterComprehensiveDesignReasonable;

    private String monitorParameterComprehensiveOperationConvenient;

    private String dataStoreFunctionDesignReasonable;

    private String dataStoreFunctionOperationConvenient;

    private String dataExportFunctionDesignReasonable;

    private String dataExportFunctionOperationConvenient;

    private String parameterAccuracyWithAnesthesiaDepth;

    private String parameterAccuracyWithComaDepth;

    private String parameterAccuracyWithBrainDamage;

    private String parameterAccuracyWithResponseTime;

    private String jamproofCapabilityWithMonitor;

    private String alertDeviceInTime;

    private String faultRateWithMainframe;

    private String faultRateWithMonitorModule;

    private String faultRateWithLeadWireAndSensor;

    private String anesthesiaInductionSatisfaction;

    private String anesthesiaMaintainSatisfaction;

    private String anesthesiaRecoverySatisfaction;

    private String consciousJudgeSatisfaction;

    private String brainDamageJudgeSatisfaction;

    private String advantageCompareOtherBrand;

    private String disadvantageCompareOtherBrand;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Column(name = "gmt_create", updatable = false)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Column(name = "gmt_modified")
    private LocalDateTime gmtModified;



}
