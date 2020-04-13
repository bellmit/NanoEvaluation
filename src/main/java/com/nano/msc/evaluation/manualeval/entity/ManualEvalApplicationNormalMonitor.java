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
 * 人工问卷评价--仪器临床应用评价--普通监护仪
 * @author nano
 */
@Data
@Entity(name = "manualEvalApplicationNormalMonitor")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "manual_eval_application_normal_monitor")
public class ManualEvalApplicationNormalMonitor implements Serializable {

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

    private String pulseOxygenSaturationModuleDesignReasonable;

    private String pulseOxygenSaturationModuleOperationConvenient;

    @Column(name = "ecg_module_design_reasonable")
    private String ECGModuleDesignReasonable;

    @Column(name = "ecg_module_operation_convenient")
    private String ECGModuleOperationConvenient;

    @Column(name = "nibp_cuff_design_reasonable")
    private String NIBPCuffDesignReasonable;

    @Column(name = "nibp_cuff_operation_convenient")
    private String NIBPCuffOperationConvenient;

    @Column(name = "ibp_module_design_reasonable")
    private String IBPModuleDesignReasonable;

    @Column(name = "ibp_module_operation_convenient")
    private String IBPModuleOperationConvenient;

    @Column(name = "etco2_module_design_reasonable")
    private String ETCO2ModuleDesignReasonable;

    @Column(name = "etco2_module_operation_convenient")
    private String ETCO2ModuleOperationConvenient;

    private String backupPowerUseTimeDesignReasonable;

    private String backupPowerUseTimeOperationConvenient;

    private String transportFunctionDesignReasonable;

    private String transportFunctionOperationConvenient;

    private String monitorParameterLayoutDesignReasonable;

    private String monitorParameterLayoutOperationConvenient;

    private String monitorParameterAdjustDesignReasonable;

    private String monitorParameterAdjustOperationConvenient;

    private String monitorParameterComprehensiveDesignReasonable;

    private String monitorParameterComprehensiveOperationConvenient;

    private String turnOnSelfTestDesignReasonable;

    private String turnOnSelfTestOperationConvenient;

    private String dataExportFunctionDesignReasonable;

    private String dataExportFunctionOperationConvenient;

    private String parameterAccuracyWithHeartRate;

    @Column(name = "parameter_accuracy_with_nibp")
    private String parameterAccuracyWithNIBP;

    @Column(name = "parameter_accuracy_with_ibp")
    private String parameterAccuracyWithIBP;

    private String parameterAccuracyWithPulseOxygenSaturation;

    private String parameterAccuracyWithBodyTemperature;

    @Column(name = "parameter_accuracy_with_etco2")
    private String parameterAccuracyWithETCO2;

    @Column(name = "parameter_accuracy_with_et_anesthetics_mol")
    private String parameterAccuracyWithETAnestheticsMol;

    private String parameterAccuracyWithOtherParameter;

    @Column(name = "jamproof_capability_with_ecg")
    private String jamproofCapabilityWithECG;

    @Column(name = "jamproof_capability_with_bp")
    private String jamproofCapabilityWithBP;

    private String jamproofCapabilityWithPulseOxygenSaturation;

    private String alertDeviceInTime;

    private String faultRateWithMainframe;

    private String faultRateWithMonitorModule;

    private String faultRateWithLeadWireAndSensor;

    @Column(name = "monitor_bp_with_satisfaction")
    private String monitorBPWithSatisfaction;

    @Column(name = "monitor_ecg_with_satisfaction")
    private String monitorECGWithSatisfaction;

    private String monitorPulseOxygenSaturationWithSatisfaction;

    @Column(name = "monitor_etco2_with_satisfaction")
    private String monitorETCO2WithSatisfaction;

    private String advantageCompareOtherBrand;

    private String disadvantageCompareOtherBrand;

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
