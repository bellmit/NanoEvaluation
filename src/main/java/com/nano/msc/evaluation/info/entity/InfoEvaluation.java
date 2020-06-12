package com.nano.msc.evaluation.info.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 评价表单实体 用于每次结束数据采集对仪器进行评价
 *
 * @author cz
 * Description：手术场次号 仪器代号 仪器序列号 科室 使用的各种信息等
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "info_evaluation")
@AllArgsConstructor
public class InfoEvaluation implements Serializable {

    private static final long serialVersionUID = -4113168698465125393L;
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
    @Column(name = "operation_number")
    private Integer operationNumber;

    /**
     * 仪器代号
     */
    @Column(name = "device_code")
    private Integer deviceCode;

    /**
     * 仪器序列号
     */
    @Column(name = "serial_number")
    private String serialNumber;

    /**
     * 使用科室
     */
    @Column(name = "device_department")
    private String deviceDepartment;

    /**
     * 使用评价等级
     */
    @Column(name = "experience_level")
    private String experienceLevel;

    /**
     * 可靠性等级
     */
    @Column(name = "reliability_level")
    private String reliabilityLevel;

    /**
     * 是否有错误信息
     */
    @Column(name = "has_error")
    private Boolean hasError;

    /**
     * 错误原因
     */
    @Column(name = "known_error")
    private String knownError;

    /**
     * 其他错误
     */
    @Column(name = "other_error")
    private String otherError;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 记录人签名
     */
    @Column(name = "record_name")
    private String recordName;

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


    public InfoEvaluation() {
    }

    public InfoEvaluation(Integer operationNumber, Integer deviceCode, String serialNumber, String deviceDepartment, String experienceLevel, String reliabilityLevel, Boolean hasError, String knownError, String otherError, String remark, String recordName) {
        this.operationNumber = operationNumber;
        this.deviceCode = deviceCode;
        this.serialNumber = serialNumber;
        this.deviceDepartment = deviceDepartment;
        this.experienceLevel = experienceLevel;
        this.reliabilityLevel = reliabilityLevel;
        this.hasError = hasError;
        this.knownError = knownError;
        this.otherError = otherError;
        this.remark = remark;
        this.recordName = recordName;
    }


    /**
     * 将存储的故障码转换为故障字符串
     *
     * @return 故障字符串
     */
    public static String convertErrorCodeToErrorString(String knownError) {

        if (knownError == null || knownError.length() == 0) {
            return "";
        }
        // 转换为2进制的ErrorCode字符串 Eg:1010
        String errorCode = Integer.toBinaryString(Integer.parseInt(knownError));

        if (errorCode.length() == 1) {
            errorCode = "000" + errorCode;
        } else if (errorCode.length() == 2) {
            errorCode = "00" + errorCode;
        } else if (errorCode.length() == 3) {
            errorCode = "0" + errorCode;
        }
        StringBuilder errorInfoBuilder = new StringBuilder();
        if (errorCode.charAt(0) == '1') {
            errorInfoBuilder.append("部件损坏").append(" ");
        }
        if (errorCode.charAt(1) == '1') {
            errorInfoBuilder.append("软件故障").append(" ");
        }
        if (errorCode.charAt(2) == '1') {
            errorInfoBuilder.append("操作失误").append(" ");
        }
        if (errorCode.charAt(3) == '1') {
            errorInfoBuilder.append("环境因素").append(" ");
        }
        return errorInfoBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(convertErrorCodeToErrorString("5"));;
    }
}
