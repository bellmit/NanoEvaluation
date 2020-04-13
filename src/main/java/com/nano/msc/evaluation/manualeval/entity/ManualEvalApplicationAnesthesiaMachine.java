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
 * 问卷评价之仪器评价之麻醉机
 * @author nano
 */
@Data
@Entity(name = "manualEvalApplicationAnesthesiaMachine")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "manual_eval_application_anesthesia_machine")
public class ManualEvalApplicationAnesthesiaMachine implements Serializable {
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

    private String handControlDeviceDesignReasonable;

    private String handControlDeviceOperationConvenient;

    private String bellowsAndItsPositionDesignReasonable;

    private String bellowsAndItsPositionOperationConvenient;

    private String sodaLimeTankWithLoadAndUnloadDesignReasonable;

    private String sodaLimeTankWithLoadAndUnloadOperationConvenient;

    private String breathLoopAndInterfaceDesignReasonable;

    private String breathLoopAndInterfaceOperationConvenient;

    private String gasFlowControlDeviceDesignReasonable;

    private String gasFlowControlDeviceOperationConvenient;

    private String backupPowerUseTimeDesignReasonable;

    private String backupPowerUseTimeOperationConvenient;

    private String volatilizeTankAndSwitchDesignReasonable;

    private String volatilizeTankAndSwitchOperationConvenient;

    private String flueGasLetOutDeviceDesignReasonable;

    private String flueGasLetOutDeviceOperationConvenient;

    private String moveAndFixDeviceDesignReasonable;

    private String moveAndFixDeviceOperationConvenient;

    private String operatingFloorSizeAndPositionDesignReasonable;

    private String operatingFloorSizeAndPositionOperationConvenient;

    private String lockerDesignReasonable;

    private String lockerOperationConvenient;

    private String dataInterfaceTypeAndFunctionDesignReasonable;

    private String dataInterfaceTypeAndFunctionOperationConvenient;

    private String breathPatternTypeDesignReasonable;

    private String breathPatternTypeOperationConvenient;

    @Column(name = "etco2_module_design_reasonable")
    private String etCo2ModuleDesignReasonable;

    @Column(name = "etco2_module_operation_convenient")
    private String etCo2ModuleOperationConvenient;

    private String anestheticMolMonitorModuleDesignReasonable;

    private String anestheticMolMonitorModuleOperationConvenient;

    private String turnOnSelfTestDesignReasonable;

    private String turnOnSelfTestOperationConvenient;

    private String dataExportFunctionDesignReasonable;

    private String dataExportFunctionOperationConvenient;

    private String parameterAccuracyWithSelfTest;

    private String parameterAccuracyWithTidalVolume;

    private String parameterAccuracyWithBreathFrequency;

    private String parameterAccuracyWithAirwayPressure;

    private String parameterAccuracyWithInspiratoryAndExpiratory;

    private String parameterAccuracyWithOxygenMol;

    private String parameterAccuracyWithVolatilizeTanksMolControl;

    private String parameterAccuracyWithMac;

    @Column(name = "parameter_accuracy_with_etco2")
    private String parameterAccuracyWithEtCo2;

    private String loopClosureWithSodaLimeTank;

    private String loopClosureWithBretheLoop;

    private String loopClosureWithFlueGasLetOutLoop;

    private String alertDeviceInTime;

    private String faultRateWithMainframe;

    private String faultRateWithMonitorModule;

    private String faultRateWithAssistDevice;

    private String mechanicalVentilationWithSatisfaction;

    private String anestheticEffectWithSatisfaction;

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
