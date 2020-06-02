package com.nano.msc.evaluation.devicedata.component;

import com.nano.msc.evaluation.devicedata.repository.BaoLaiTeRepository;
import com.nano.msc.evaluation.devicedata.repository.LiBangEliteV8Repository;
import com.nano.msc.evaluation.devicedata.repository.MaiRuiT8Repository;
import com.nano.msc.evaluation.devicedata.repository.MaiRuiWatoex55ProRepository;
import com.nano.msc.evaluation.devicedata.repository.MaiRuiWatoex65Repository;
import com.nano.msc.evaluation.devicedata.repository.Norwamd9002sRepository;
import com.nano.msc.evaluation.devicedata.repository.PuKeYy106Repository;
import com.nano.msc.evaluation.devicedata.repository.YiAn8700ARepository;
import com.nano.msc.evaluation.enums.DeviceInfoEnum;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

/**
 * 仪器数据相关的上下文信息
 *
 * @author: nano
 * @time: 2020/6/1 16:04
 */
@Component
public class DeviceDataContext implements InitializingBean, ApplicationContextAware {

	/**
	 * 仪器数据RepositoryMap
	 */
	@Getter
	private Map<Integer, JpaRepository> dataRepositoryMap;

	/**
	 * 应用上下文
	 */
	private ApplicationContext applicationContext;

	public DeviceDataContext() {
		dataRepositoryMap = new HashMap<>();
	}

	/**
	 * 将各个数据repository放入map中
	 */
	@Override
	public void afterPropertiesSet() {
		dataRepositoryMap.put(DeviceInfoEnum.NORWAMD_9002S.getDeviceCode(), applicationContext.getBean(Norwamd9002sRepository.class));
		dataRepositoryMap.put(DeviceInfoEnum.PEARLCARE_YY106.getDeviceCode(), applicationContext.getBean(PuKeYy106Repository.class));
		dataRepositoryMap.put(DeviceInfoEnum.BAO_LAI_TE.getDeviceCode(), applicationContext.getBean(BaoLaiTeRepository.class));
		dataRepositoryMap.put(DeviceInfoEnum.YI_AN_8700_A.getDeviceCode(), applicationContext.getBean(YiAn8700ARepository.class));
		dataRepositoryMap.put(DeviceInfoEnum.MAI_RUI_T8.getDeviceCode(), applicationContext.getBean(MaiRuiT8Repository.class));
		dataRepositoryMap.put(DeviceInfoEnum.MAI_RUI_WATOEX_65.getDeviceCode(), applicationContext.getBean(MaiRuiWatoex65Repository.class));
		dataRepositoryMap.put(DeviceInfoEnum.MAI_RUI_WATOEX_55_PRO.getDeviceCode(), applicationContext.getBean(MaiRuiWatoex55ProRepository.class));
		dataRepositoryMap.put(DeviceInfoEnum.LI_BANG_ELITE_V8.getDeviceCode(), applicationContext.getBean(LiBangEliteV8Repository.class));

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (this.applicationContext == null) {
			this.applicationContext = applicationContext;
		}
	}
}
