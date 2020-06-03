package com.nano.msc.evaluation.devicedata.service;

import com.nano.msc.common.vo.CommonResult;

/**
 * 仪器数据服务
 * @author cz
 */
public interface DeviceDataService {


	/**
	 * 获取仪器历史数据
	 *
	 * @param operationNumber 手术场次号
	 * @param serialNumber 序列号
	 * @param page 页数
	 * @param size 大小
	 * @return 数据列表
	 */
	CommonResult getDeviceHistoryData(int operationNumber, String serialNumber, int page, int size);


}
