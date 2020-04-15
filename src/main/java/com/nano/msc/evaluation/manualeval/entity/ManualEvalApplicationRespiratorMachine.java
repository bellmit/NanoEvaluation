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
 * 人工问卷评价--临床应用评价--呼吸机
 * @author nano
 */
@Data
@Entity(name = "manualEvalApplicationRespiratorMachine")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "manual_eval_application_respirator_machine")
public class ManualEvalApplicationRespiratorMachine implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    private String airCompressorDesignReasonable;

    private String airCompressorOperationConvenient;

    private String wetDeviceDesignReasonable;

    private String wetDeviceOperationConvenient;

    private String breathLoopAndInterfaceDesignReasonable;

    private String breathLoopAndInterfaceOperationConvenient;

    private String moveAndFixDeviceDesignReasonable;

    private String moveAndFixDeviceOperationConvenient;

    private String backupPowerUseTimeDesignReasonable;

    private String backupPowerUseTimeOperationConvenient;

    private String transportFunctionDesignReasonable;

    private String transportFunctionOperationConvenient;

    private String gasFlowAdjustDeviceDesignReasonable;

    private String gasFlowAdjustDeviceOperationConvenient;

    private String breathPatternTypeDesignReasonable;

    private String breathPatternTypeOperationConvenient;

    @Column(name = "etco2_module_design_reasonable")
    private String ETCO2ModuleDesignReasonable;

    @Column(name = "etco2_module_operation_convenient")
    private String ETCO2ModuleOperationConvenient;

    @Column(name = "o2_module_design_reasonable")
    private String O2ModuleDesignReasonable;

    @Column(name = "o2_module_operation_convenient")
    private String O2ModuleOperationConvenient;

    private String monitorAirwayPressureDesignReasonable;

    private String monitorAirwayPressureOperationConvenient;

    private String monitorParameterComprehensiveDesignReasonable;


    private String monitorParameterComprehensiveOperationConvenient;

    private String turnOnSelfTestDesignReasonable;

    private String turnOnSelfTestOperationConvenient;

    private String dataExportFunctionDesignReasonable;

    private String dataExportFunctionOperationConvenient;

    private String parameterAccuracyWithTidalVolume;

    private String parameterAccuracyWithBreathFrequency;

    private String parameterAccuracyWithAirwayPressure;

    private String parameterAccuracyWithInspiratoryAndExpiratory;

    private String parameterAccuracyWithOxygenMol;

    @Column(name = "parameter_accuracy_with_etco2")
    private String parameterAccuracyWithETCO2;

    private String alertDeviceInTime;

    private String faultRateWithMainframe;

    private String faultRateWithMonitorModule;

    private String faultRateWithAssistDevice;

    private String lungVentilationComplication;

    private String lungInfectionComplication;

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
