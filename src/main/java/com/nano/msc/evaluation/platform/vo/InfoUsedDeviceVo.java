package com.nano.msc.evaluation.platform.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 某次手术使用的仪器信息的VO
 *
 * @author: nano
 * @time: 2020/6/3 20:00
 */
@Data
public class InfoUsedDeviceVo implements Serializable {

	/**
	 * 手术顺序号
	 */
	private Integer operationNumber;

	/**
	 * 仪器号
	 */
	private String deviceCode;

	/**
	 * 仪器信息的ID号 外键仪器信息表的主键ID号
	 */
	private Integer deviceInfoId;


	/**
	 * 数据总条数
	 */
	private Integer dataNumber;

	/**
	 * 手术持续时间
	 */
	private long operationDurationTime;

	/**
	 * 掉线率
	 */
	private double dropRate;

	/**
	 * 采集开始时间
	 */
	private LocalDateTime collectionStartTime;

	/**
	 * 采集结束时间
	 */
	private LocalDateTime collectionEndTime;


	// 以下补充仪器信息
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

}
