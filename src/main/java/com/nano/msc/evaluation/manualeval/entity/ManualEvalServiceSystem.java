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
 * 人工评价服务体系
 * @author nano
 */
@Data
@Entity(name = "manualEvalServiceSystem")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "manual_eval_service_system")
public class ManualEvalServiceSystem implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String deviceCategory;

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

    private String isProvideConsultBeforeSale;

    private String isKnowYourDemand;

    private String isProvideTrial;

    private String isExplainFunction;

    private String isIntroductionDeviceMaintainAndUpdateDetail;

    private String isProvideInstallAndTrain;

    private String guaranteePeriod;

    private String visitCustomerPeriod;

    private String visitCustomerWay;

    private String averageResponseTimeWhenDeviceFault;

    private String averageMaintainTimeWhenDeviceFault;

    private String jingXiaoBiDeviceWorkYear;

    private String jingXiaoBiPatientNumEveryYear;

    private String jingXiaoBiAveragePayEveryPatient;

    private String jingXiaoBiDeviceSalePrice;

    private String jingXiaoBiTotalPayForMaintainAfterBuy;

    private String economicApplicabilityPerformanceRate;

    private String economicApplicabilityFirstGuaranteePeriod;

    private String economicApplicabilityRenewalMethodAndPrice;

    private String economicApplicabilityWarrantyPrice;

    private String economicApplicabilitySoftwareUpdatePrice;

    private String trainServiceDescriptionPractical;

    private String trainServiceFeedbackInTime;

    private String trainServiceRemoteTechnicalSupport;

    private String trainServiceClinicalApplicationTraining;

    private String trainServiceDeviceInstallMaintainTraining;

    private String afterSaleServiceResponseTime;

    private String afterSaleServiceFaultExcludeTime;

    private String afterSaleServiceMaintainPrice;

    private String afterSaleServiceProducerAttitude;

    private String afterSaleServiceComplaintHandingSatisfaction;


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
