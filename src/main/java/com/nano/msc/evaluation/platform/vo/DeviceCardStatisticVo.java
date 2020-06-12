package com.nano.msc.evaluation.platform.vo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 仪器Card统计信息的Vo
 *
 * @author: nano
 * @time: 2020/6/6 15:59
 */
@Data
public class DeviceCardStatisticVo {

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


	//----------------------以下是统计信息----------------------------
	/**
	 * 总的已完成手术场次
	 */
	private Integer totalFinishOperationNumber;

	/**
	 * 手术持续时间
	 */
	private Long operationDurationTimeAll;

	/**
	 * 平均掉线率
	 */
	private Double averageDropRate;

}
