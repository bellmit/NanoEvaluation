package com.nano.msc.evaluation.devicedata.service.impl;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.devicedata.entity.DataAiQin;
import com.nano.msc.evaluation.devicedata.entity.DataBaoLaiTeA8;
import com.nano.msc.evaluation.devicedata.entity.DataMaiRuiT8;
import com.nano.msc.evaluation.devicedata.entity.DataMaiRuiWatoex65;
import com.nano.msc.evaluation.devicedata.entity.DataNuoHe9002s;
import com.nano.msc.evaluation.devicedata.entity.DataPuKeYy106;
import com.nano.msc.evaluation.devicedata.entity.DataYiAn8700A;
import com.nano.msc.evaluation.devicedata.repository.AiQinRepository;
import com.nano.msc.evaluation.devicedata.repository.BaoLaiTeRepository;
import com.nano.msc.evaluation.devicedata.repository.MaiRuiT8Repository;
import com.nano.msc.evaluation.devicedata.repository.MaiRuiWatoex65Repository;
import com.nano.msc.evaluation.devicedata.repository.NuoHe9002sRepository;
import com.nano.msc.evaluation.devicedata.repository.PuKeYy106Repository;
import com.nano.msc.evaluation.devicedata.repository.YiAn8700ARepository;
import com.nano.msc.evaluation.devicedata.service.DeviceDataService;
import com.nano.msc.evaluation.enums.DeviceInfoEnum;
import com.nano.msc.evaluation.info.entity.InfoDevice;
import com.nano.msc.evaluation.info.repository.InfoDeviceRepository;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private NuoHe9002sRepository nuoHe9002sRepository;

	@Autowired
	private BaoLaiTeRepository baoLaiTeRepository;


	@Autowired
	private YiAn8700ARepository yiAn8700ARepository;

	@Autowired
	private AiQinRepository aiQinRepository;

	@Autowired
	private MaiRuiT8Repository maiRuiT8Repository;

	@Autowired
	private MaiRuiWatoex65Repository maiRuiWatoex65Repository;

	/**
	 * 获取仪器历史数据
	 *
	 * @param operationNumber 手术场次号
	 * @param deviceCodeString 仪器号字符串形式
	 * @param serialNumber 序列号
	 * @param page 页数
	 * @param size 大小
	 * @return 数据列表
	 */
	@Override
	public CommonResult getDeviceHistoryData(int operationNumber, String deviceCodeString, String serialNumber, int page, int size) {

		// 获取仪器信息
		InfoDevice infoDevice = deviceRepository.findByDeviceCodeAndDeviceSerialNumber(deviceCodeString, serialNumber);
		int deviceCode = Integer.parseInt(infoDevice.getDeviceCode());

		// TODO:其他仪器的历史数据还需要做
		// 获取普可历史数据 分页查询 默认1000条数据
		if (deviceCode == DeviceInfoEnum.PEARLCARE_YY106.deviceCode) {
			List<DataPuKeYy106> dataList = puKeYy106Repository.findByOperationNumberAndSerialNumber(operationNumber, serialNumber);
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("Ai", dataList.stream().map(DataPuKeYy106::getAi).collect(Collectors.toList()));
			dataMap.put("EMG", dataList.stream().map(DataPuKeYy106::getEmg).collect(Collectors.toList()));
			dataMap.put("SQI", dataList.stream().map(DataPuKeYy106::getSqi).collect(Collectors.toList()));
			dataMap.put("BSR", dataList.stream().map(DataPuKeYy106::getBsr).collect(Collectors.toList()));
			dataMap.put("time", dataList.stream().map(DataPuKeYy106::getGmtCreate).collect(Collectors.toList()));
			return CommonResult.success(dataMap);
		} else if (deviceCode == DeviceInfoEnum.NORWAMD_9002S.deviceCode) {
			List<DataNuoHe9002s> dataList = nuoHe9002sRepository.findByOperationNumberAndSerialNumber(operationNumber, serialNumber);
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("BS", dataList.stream().map(DataNuoHe9002s::getBs).collect(Collectors.toList()));
			dataMap.put("EMG", dataList.stream().map(DataNuoHe9002s::getEmg).collect(Collectors.toList()));
			dataMap.put("SQI", dataList.stream().map(DataNuoHe9002s::getSqi).collect(Collectors.toList()));
			dataMap.put("CSI", dataList.stream().map(DataNuoHe9002s::getCsi).collect(Collectors.toList()));
			dataMap.put("time", dataList.stream().map(DataNuoHe9002s::getGmtCreate).collect(Collectors.toList()));
			return CommonResult.success(dataMap);
		} else if (deviceCode == DeviceInfoEnum.BAO_LAI_TE.deviceCode) {
			List<DataBaoLaiTeA8> dataList = baoLaiTeRepository.findByOperationNumberAndSerialNumber(operationNumber, serialNumber);
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("HR", dataList.stream().map(DataBaoLaiTeA8::getHr).collect(Collectors.toList()));
			dataMap.put("SpO2", dataList.stream().map(DataBaoLaiTeA8::getSpo2).collect(Collectors.toList()));
			dataMap.put("PR", dataList.stream().map(DataBaoLaiTeA8::getPr).collect(Collectors.toList()));
			dataMap.put("Temp", dataList.stream().map(DataBaoLaiTeA8::getTemperature).collect(Collectors.toList()));
			dataMap.put("time", dataList.stream().map(DataBaoLaiTeA8::getGmtCreate).collect(Collectors.toList()));
			return CommonResult.success(dataMap);

		} else if (deviceCode == DeviceInfoEnum.YI_AN_8700_A.deviceCode) {
			List<DataYiAn8700A> dataList = yiAn8700ARepository.findByOperationNumberAndSerialNumber(operationNumber, serialNumber);
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("PEAK", dataList.stream().map(DataYiAn8700A::getPeak).collect(Collectors.toList()));
			dataMap.put("MEAN", dataList.stream().map(DataYiAn8700A::getPmean).collect(Collectors.toList()));
			dataMap.put("PEEP", dataList.stream().map(DataYiAn8700A::getPeep).collect(Collectors.toList()));
			dataMap.put("MV", dataList.stream().map(DataYiAn8700A::getMv).collect(Collectors.toList()));
			dataMap.put("Vte", dataList.stream().map(DataYiAn8700A::getVte).collect(Collectors.toList()));
			dataMap.put("Freq", dataList.stream().map(DataYiAn8700A::getFreq).collect(Collectors.toList()));
			dataMap.put("time", dataList.stream().map(DataYiAn8700A::getGmtCreate).collect(Collectors.toList()));
			return CommonResult.success(dataMap);
		} else if (deviceCode == DeviceInfoEnum.AI_QIN_EGOS600A.deviceCode) {
			List<DataAiQin> dataList = aiQinRepository.findByOperationNumberAndSerialNumber(operationNumber, serialNumber);
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("TOI1", dataList.stream().map(DataAiQin::getToi1).collect(Collectors.toList()));
			dataMap.put("TOI2", dataList.stream().map(DataAiQin::getToi2).collect(Collectors.toList()));
			dataMap.put("TOI3", dataList.stream().map(DataAiQin::getToi3).collect(Collectors.toList()));
			dataMap.put("TOI4", dataList.stream().map(DataAiQin::getToi4).collect(Collectors.toList()));
			dataMap.put("THI1", dataList.stream().map(DataAiQin::getThi1).collect(Collectors.toList()));
			dataMap.put("THI2", dataList.stream().map(DataAiQin::getThi2).collect(Collectors.toList()));
			dataMap.put("THI3", dataList.stream().map(DataAiQin::getThi3).collect(Collectors.toList()));
			dataMap.put("THI4", dataList.stream().map(DataAiQin::getThi4).collect(Collectors.toList()));
			dataMap.put("time", dataList.stream().map(DataAiQin::getGmtCreate).collect(Collectors.toList()));
			return CommonResult.success(dataMap);
		} else if (deviceCode == DeviceInfoEnum.MAI_RUI_T8.deviceCode) {
			List<DataMaiRuiT8> dataList = maiRuiT8Repository.findByOperationNumberAndSerialNumber(operationNumber, serialNumber);
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("Resp", dataList.stream().map(DataMaiRuiT8::getRespRespirationRate).collect(Collectors.toList()));
			dataMap.put("ECG", dataList.stream().map(DataMaiRuiT8::getEcgHeartRate).collect(Collectors.toList()));
			dataMap.put("SpO2", dataList.stream().map(DataMaiRuiT8::getSpo2PercentOxygenSaturation).collect(Collectors.toList()));
			dataMap.put("PR", dataList.stream().map(DataMaiRuiT8::getSpo2PulseRate).collect(Collectors.toList()));
			dataMap.put("time", dataList.stream().map(DataMaiRuiT8::getGmtCreate).collect(Collectors.toList()));
			return CommonResult.success(dataMap);
		} else if (deviceCode == DeviceInfoEnum.MAI_RUI_WATOEX_65.deviceCode) {
			List<DataMaiRuiWatoex65> dataList = maiRuiWatoex65Repository.findByOperationNumberAndSerialNumber(operationNumber, serialNumber);
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("Ppeak", dataList.stream().map(DataMaiRuiWatoex65::getPPeak).collect(Collectors.toList()));
			dataMap.put("Pmean", dataList.stream().map(DataMaiRuiWatoex65::getPMean).collect(Collectors.toList()));
			dataMap.put("PEEP", dataList.stream().map(DataMaiRuiWatoex65::getPEEP).collect(Collectors.toList()));
			dataMap.put("MV", dataList.stream().map(DataMaiRuiWatoex65::getMV).collect(Collectors.toList()));
			dataMap.put("I:E", dataList.stream().map(DataMaiRuiWatoex65::getIE).collect(Collectors.toList()));
			dataMap.put("Rate", dataList.stream().map(DataMaiRuiWatoex65::getRate).collect(Collectors.toList()));
			dataMap.put("time", dataList.stream().map(DataMaiRuiWatoex65::getGmtCreate).collect(Collectors.toList()));
			return CommonResult.success(dataMap);
		}



		return CommonResult.success(new ArrayList<>());
	}
}
