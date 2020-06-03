package com.nano.msc.evaluation.devicedata.service.impl;

import com.nano.msc.common.exceptions.ExceptionAsserts;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.devicedata.component.DeviceDataContext;
import com.nano.msc.evaluation.devicedata.service.PlatformDeviceDataService;
import com.nano.msc.evaluation.enums.DeviceInfoEnum;
import com.nano.msc.evaluation.info.entity.InfoDevice;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.entity.InfoOperationDevice;
import com.nano.msc.evaluation.info.repository.InfoDeviceRepository;
import com.nano.msc.evaluation.info.repository.InfoOperationDeviceRepository;
import com.nano.msc.evaluation.info.repository.InfoOperationRepository;
import com.nano.msc.evaluation.platform.vo.DeviceDataStatisticVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import cn.hutool.core.bean.BeanUtil;

/**
 * 平台仪器数据相关的服务实现类
 *
 * @author: nano
 * @time: 2020/5/25 14:32
 */
@Service
public class PlatformDeviceDataServiceImpl implements PlatformDeviceDataService {

	/**
	 * 手术仪器信息repository
	 */
	@Autowired
	private InfoOperationDeviceRepository operationDeviceRepository;


	@Autowired
	private InfoDeviceRepository infoDeviceRepository;




	/**
	 * 获取仪器数据统计信息
	 *
	 * @param operationNumber 手术场次号
	 * @return 统计信息
	 */
	@Override
	public List<DeviceDataStatisticVo> getDeviceDataStatisticData(int operationNumber) {
		List<InfoOperationDevice> operationDeviceList = operationDeviceRepository.findByOperationNumber(operationNumber);
		if (operationDeviceList.size() == 0) {
			ExceptionAsserts.fail("没有找到手术信息:" + operationNumber);
		}

		List<DeviceDataStatisticVo> statisticVoList = new ArrayList<>(6);
		// 手术仪器信息列表
		for (InfoOperationDevice operationDevice : operationDeviceList) {
			DeviceDataStatisticVo statisticVo = new DeviceDataStatisticVo();
			// Copy属性值
			BeanUtil.copyProperties(operationDevice, statisticVo);
			// 查询仪器序列号
			Optional<InfoDevice> optional = infoDeviceRepository.findById(operationDevice.getDeviceInfoId());
			if (optional.isPresent()) {
				InfoDevice infoDevice = optional.get();
				statisticVo.setSerialNumber(infoDevice.getDeviceSerialNumber());
			}
			DeviceInfoEnum infoEnum = DeviceInfoEnum.matchDeviceCodeEnum(operationDevice.getDeviceCode());
			if (infoEnum != null) {
				statisticVo.setDeviceCode(infoEnum.getDeviceCode() + "");
				statisticVo.setCompanyName(infoEnum.getCompanyName());
				statisticVo.setDeviceName(infoEnum.getDeviceName());
			} else {
				ExceptionAsserts.fail("找不到仪器号:" + operationDevice.getDeviceCode());
			}
			statisticVoList.add(statisticVo);
		}
		return statisticVoList;
	}

}
