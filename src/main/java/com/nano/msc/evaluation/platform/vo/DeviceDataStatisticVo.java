package com.nano.msc.evaluation.platform.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 仪器数据统计信息的VO
 *
 * @author: nano
 * @time: 2020/5/31 17:37
 * 统计信息包含：仪器名称、仪器序列号、公司名称、手术总时长、手术采集总数据条数、断线率、采集特殊情况等
 */
@Data
public class DeviceDataStatisticVo implements Serializable {

	/**
	 * 公司名称
	 */
	private String companyName;

	/**
	 * 仪器名称
	 */
	private String deviceName;

	/**
	 * 序列号
	 */
	private String serialNumber;


	/**
	 * 数据总条数
	 */
	private Integer dataNumber;



}
