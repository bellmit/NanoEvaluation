package com.nano.msc.evaluation.devicedata.service;

import com.nano.msc.common.vo.CommonResult;


/**
 * 普可数据服务
 * @author cz
 */
public interface DataPuKeService {


	/**
	 * 列出历史仪器数据
	 *
	 * @param operationNumber 手术场次号
	 * @param serialNumber 序列号
	 * @return 数据列表
	 */
	CommonResult listHistoryDeviceData(int operationNumber, String serialNumber, int page, int size);




}
