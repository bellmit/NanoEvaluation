package com.nano.msc.evaluation.devicedata.service.impl;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.devicedata.entity.PuKeYy106;
import com.nano.msc.evaluation.devicedata.repository.PuKeYy106Repository;
import com.nano.msc.evaluation.devicedata.service.DataPuKeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 普可YY106数据服务
 *
 * @author: nano
 * @time: 2020/6/2 16:32
 */
public class DataPuKeServiceImpl implements DataPuKeService {


	@Autowired
	private PuKeYy106Repository puKeYy106Repository;

	/**
	 * 列出历史仪器数据
	 *
	 * @param operationNumber 手术场次号
	 * @param serialNumber 序列号
	 * @return 数据列表
	 */
	@Override
	public CommonResult listHistoryDeviceData(int operationNumber, String serialNumber, int page, int size) {

		// 获取页数数据
		Page<PuKeYy106> dataPage = puKeYy106Repository.findByOperationNumberAndSerialNumber(operationNumber,
				serialNumber, PageRequest.of(page, size));

		return CommonResult.success(dataPage);
	}
}
