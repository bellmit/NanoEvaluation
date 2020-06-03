package com.nano.msc.evaluation.devicedata.service.impl;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.devicedata.entity.PuKeYy106;
import com.nano.msc.evaluation.devicedata.repository.PuKeYy106Repository;
import com.nano.msc.evaluation.devicedata.service.DeviceDataService;
import com.nano.msc.evaluation.enums.DeviceInfoEnum;
import com.nano.msc.evaluation.info.entity.InfoDevice;
import com.nano.msc.evaluation.info.repository.InfoDeviceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 仪器数据服务
 *
 * @author: nano
 * @time: 2020/6/2 20:39
 */
@Service
public class DeviceDataServiceImpl implements DeviceDataService {


	@Autowired
	private InfoDeviceRepository deviceRepository;


	@Autowired
	private PuKeYy106Repository puKeYy106Repository;


	/**
	 * 获取仪器历史数据
	 *
	 * @param operationNumber 手术场次号
	 * @param serialNumber 序列号
	 * @param page 页数
	 * @param size 大小
	 * @return 数据列表
	 */
	@Override
	public CommonResult getDeviceHistoryData(int operationNumber, String serialNumber, int page, int size) {

		// 获取仪器信息
		InfoDevice infoDevice = deviceRepository.findByDeviceSerialNumber(serialNumber);
		int deviceCode = Integer.parseInt(infoDevice.getDeviceCode());

		// 获取普可历史数据 分页查询 默认1000条数据
		if (deviceCode == DeviceInfoEnum.PEARLCARE_YY106.deviceCode) {
			List<PuKeYy106> dataList = puKeYy106Repository.findByOperationNumberAndSerialNumber(operationNumber, serialNumber);
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("Ai", dataList.stream().map(PuKeYy106::getAi).collect(Collectors.toList()));
			dataMap.put("EMG", dataList.stream().map(PuKeYy106::getEMG).collect(Collectors.toList()));
			dataMap.put("SQI", dataList.stream().map(PuKeYy106::getSQI).collect(Collectors.toList()));
			dataMap.put("BSR", dataList.stream().map(PuKeYy106::getBSR).collect(Collectors.toList()));
			dataMap.put("time", dataList.stream().map(PuKeYy106::getGmtCreate).collect(Collectors.toList()));
			return CommonResult.success(dataMap);
		} else if (deviceCode == DeviceInfoEnum.NORWAMD_9002S.deviceCode) {

		}


		return CommonResult.success(new ArrayList<>());
	}
}
