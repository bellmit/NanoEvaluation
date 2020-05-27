package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.common.utils.TimeStampUtils;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.entity.InfoOperationDevice;
import com.nano.msc.evaluation.info.repository.InfoOperationDeviceRepository;
import com.nano.msc.evaluation.info.service.InfoOperationDeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.hutool.core.map.MapUtil;

/**
 * 仪器使用信息服务接口
 * @author: nano
 */
@Service
public class InfoOperationDeviceServiceImpl implements InfoOperationDeviceService {

    @Autowired
    private InfoOperationDeviceRepository operationDeviceRepository;


    @Override
    public InfoOperationDevice save(InfoOperationDevice operationDevice) {
        return operationDeviceRepository.save(operationDevice);
    }


    /**
     * 获取仪器历史开机信息
     * @return 开机信息
     */
    @Override
    public CommonResult getDeviceOpenNumberHistory(int historyDays) {

        // 存放历史开机数的Map，key是历史日期，0是今天，1是昨天，value是当天开机的仪器数
        Map<LocalDate, Integer> deviceOpenNumberMap = new TreeMap<>();

        // 获取当天的信息
        List<InfoOperationDevice> operationDevice = operationDeviceRepository.findByGmtCreateAfter(TimeStampUtils.getCurrentDayZeroLocalDateTime());
        int todayCount = (int) operationDevice.stream().map(InfoOperationDevice::getDeviceInfoId)
                .distinct().count();
        deviceOpenNumberMap.put(TimeStampUtils.getCurrentDayZeroLocalDateTime().toLocalDate(), todayCount);

        // 获取历史的信息
        for (int day = 0; day < historyDays - 1; day++) {
            // 获取前一天开始的时间戳
            LocalDateTime after = TimeStampUtils.getHistoryDayZeroLocalDateTimeBeforeNow(day + 1);
            // 获取前一天结束
            LocalDateTime before = TimeStampUtils.getHistoryDayZeroLocalDateTimeBeforeNow(day);
            // 获取历史一天的手术仪器信息
            List<InfoOperationDevice> operationDevices = operationDeviceRepository.findByGmtCreateAfterAndGmtCreateBefore(after, before);
            // 这里需要去重，因为有的仪器可能一天采集多次，所以只安装仪器信息ID进行统计
            int count = (int) operationDevices.stream()
                    .map(InfoOperationDevice::getDeviceInfoId)
                    .distinct().count();
            deviceOpenNumberMap.put(after.toLocalDate(), count);
        }

        return CommonResult.success(deviceOpenNumberMap);
    }
}
