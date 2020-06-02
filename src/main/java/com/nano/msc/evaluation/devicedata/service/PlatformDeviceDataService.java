package com.nano.msc.evaluation.devicedata.service;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.platform.vo.DeviceDataStatisticVo;

import java.util.List;

/**
 * 平台仪器数据相关的服务
 * @author: nano
 */
public interface PlatformDeviceDataService {

	/**
	 * 获取仪器数据统计信息
	 *
	 * @param operationNumber 手术场次号
	 * @return 统计信息
	 */
	List<DeviceDataStatisticVo> getDeviceDataStatisticData(int operationNumber);



}
