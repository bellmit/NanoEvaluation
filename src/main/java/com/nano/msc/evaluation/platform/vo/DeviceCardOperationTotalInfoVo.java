package com.nano.msc.evaluation.platform.vo;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Transient;

import lombok.Data;

/**
 * 用于仪器卡片的手术完整信息的展示VO
 *
 * @author: nano
 * @time: 2020/6/8 17:23
 */
@Data
public class DeviceCardOperationTotalInfoVo {

	private Integer operationNumber;

	/**
	 * 住院号
	 */
	private String admissionId;

	/**
	 * 医院的手术顺序号
	 * 每个医院的都不一样
	 */
	private String hospitalOperationNumber;


	/**************************************病人信息*********************************************/
	/**
	 * 病人身份证号
	 */
	private String patientId;

	/**
	 * 性别0--男，1--女
	 */
	private Integer patientSex;

	/**
	 * 身高
	 */
	private Integer patientHeight;

	/**
	 * 体重
	 */
	private Double patientWeight;

	/**
	 * 年龄
	 */
	private Integer patientAge;


	/**************************************手术信息*********************************************/
	/**
	 * 手术名称
	 */
	private String operationName;

	/**
	 * 麻醉方式
	 */
	private String operationAnesthesiaMode;

	/**
	 * 是否急诊
	 */
	private Boolean operationIsUrgent;

	/**
	 * ASA等级
	 */
	private Integer operationAsaLevel;

	/**
	 * 既往病史
	 */
	private String pastMedicalHistory;

	/**
	 * 特殊情况
	 */
	private String specialCase;

	/**
	 * 使用仪器信息
	 *
	 * 不与手术信息数据表对应
	 *
	 * 获取此值之后再解析成仪器信息表
	 */
	@Transient
	private String usedDeviceInfo;

	/**
	 * 用于给平台展示的使用的仪器
	 */
	private String usedDeviceInfoForPlatform;


	/**************************************数据采集信息*********************************************/
	/**
	 * 本次采集采集器MAC地址
	 */
	private String collectorMacAddress;

	/**
	 * 手术开始时间
	 */
	private LocalDateTime operationStartTime;

	/**
	 * 手术结束时间
	 */
	private LocalDateTime operationEndTime;

	/**
	 * 手术状态
	 */
	private Integer operationState;



	//-------------------------------以下是这场手术使用的这个仪器采集的信息-------------------------------------------

	/**
	 * 数据总条数
	 */
	private Integer dataNumber;

	/**
	 * 手术持续时间
	 */
	private Long operationDurationTime;

	/**
	 * 掉线率
	 */
	private Double dropRate;

	//-------------------------------以下是这场手术使用的这个仪器的信息-------------------------------------------

	/**
	 * 仪器代号
	 */
	private String deviceCode;

	/**
	 * 设备序列号，不一定唯一
	 */
	private String deviceSerialNumber;

	/**
	 * 设备购买时间
	 */
	private LocalDate deviceProduceDate;

	/**
	 * 仪器的使用年限
	 */
	private Double deviceServiceLife;

	/**
	 * 仪器名称
	 */
	private String deviceName;

	/**
	 * 公司名字
	 */
	private String companyName;

	/**
	 * 仪器类别
	 */
	private String deviceType;


	//-------------------------------以下是这场手术这个仪器的评价信息-------------------------------------------

	/**
	 * 使用科室
	 */
	private String deviceDepartment;

	/**
	 * 使用评价等级
	 */
	private String experienceLevel;

	/**
	 * 可靠性等级
	 */
	private String reliabilityLevel;

	/**
	 * 是否有错误信息
	 */
	private String hasError;

	/**
	 * 错误原因
	 */
	private String knownError;

	/**
	 * 其他错误
	 */
	private String otherError;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 记录人签名
	 */
	private String recordName;

}
