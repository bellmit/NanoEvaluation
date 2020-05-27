package com.nano.msc.evaluation.info.service.impl;

import com.alibaba.fastjson.JSON;
import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.exceptions.ExceptionAsserts;
import com.nano.msc.common.service.BaseService;
import com.nano.msc.common.utils.TimeStampUtils;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.enums.OperationStateEnum;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.entity.InfoOperationDevice;
import com.nano.msc.evaluation.info.repository.InfoOperationRepository;
import com.nano.msc.evaluation.info.service.InfoOperationService;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.hutool.core.map.MapUtil;

/**
 * 手术信息服务实现类
 * @author cz
 */
@Service
public class InfoOperationServiceImpl implements InfoOperationService {


    private static final Logger logger = LoggerFactory.getLogger("DeviceDataCollectionServiceImpl");


    @Autowired
    private InfoOperationRepository operationRepository;


    /**
     * 处理新的手术信息请求 返回手术场次号
     *
     * @param infoOperation 手术信息
     * @return 返回手术场次号
     */
    @Override
    public InfoOperation handleNewOperationInfoRequestAndSave(InfoOperation infoOperation) {

        if (operationRepository.findByAdmissionIdAndPatientId(infoOperation.getAdmissionId(), infoOperation.getPatientId()) != null) {
            // 数据已存在
            ExceptionAsserts.fail(ExceptionEnum.DATA_EXISTED);
        }
        InfoOperation operation = operationRepository.save(infoOperation);
        if(operation == null) {
            ExceptionAsserts.fail(ExceptionEnum.DATA_SAVE_ERROR);
        }
        // 返回手术场次号
        return operation;
    }


    @Override
    public List<InfoOperation> findAllOperationInfo() {
        return operationRepository.findAll();
    }


    @Override
    public InfoOperation update(InfoOperation infoOperation) {
        return operationRepository.save(infoOperation);
    }

    /**
     * 分页查询
     *
     * @param page 页数
     * @param size 个数
     * @return 结果
     */
    @Override
    public CommonResult list(Integer page, Integer size) {
        return ServiceCrudCheckUtils.listObjectAndCheck(operationRepository, page, size);
    }

    /**
     * 通过手术场次号找手术信息
     *
     * @param operationNumber 手术场次号
     * @return 手术信息
     */
    @Override
    public InfoOperation findByOperationNumber(Integer operationNumber) {
        return operationRepository.findByOperationNumber(operationNumber);
    }


    /**
     * 获取历史采集时间
     * @param historyDays 历史天数
     * @return 时间
     */
    @Override
    public CommonResult getHistoryCollectionTime(int historyDays) {

        // 历史采集时长的Map，key日期，value是当天开机的仪器数
        Map<LocalDate, Long> collectionTimeMap = new TreeMap<>();

        // 获取当天的信息
        List<InfoOperation> operations = operationRepository.findByGmtCreateAfter(TimeStampUtils.getCurrentDayZeroLocalDateTime());
        long durationToday = 0;
        // 计算所有场次的时间
        for (InfoOperation operation : operations) {
            LocalDateTime startTime = operation.getOperationStartTime();
            LocalDateTime endTime = operation.getOperationEndTime();
            if(startTime.isBefore(endTime)) {
                // 持续添加时间
                durationToday = durationToday + Duration.between(startTime, endTime).getSeconds();
            }
        }

        collectionTimeMap.put(TimeStampUtils.getCurrentDayZeroLocalDateTime().toLocalDate(), durationToday);

        // 获取历史的信息
        for (int day = 0; day < historyDays - 1; day++) {
            // 获取前一天开始的时间戳
            LocalDateTime after = TimeStampUtils.getHistoryDayZeroLocalDateTimeBeforeNow(day + 1);
            // 获取前一天结束
            LocalDateTime before = TimeStampUtils.getHistoryDayZeroLocalDateTimeBeforeNow(day);
            // 获取历史一天的手术仪器信息
            List<InfoOperation> operationList = operationRepository.findByGmtCreateAfterAndGmtCreateBefore(after, before);

            long durationHistory = 0;
            // 计算所有场次的时间
            for (InfoOperation operation : operationList) {
                LocalDateTime startTime = operation.getOperationStartTime();
                LocalDateTime endTime = operation.getOperationEndTime();
                if(startTime.isBefore(endTime)) {
                    // 持续添加时间
                    durationHistory = durationHistory + Duration.between(startTime, endTime).getSeconds();
                }
            }
            collectionTimeMap.put(after.toLocalDate(), durationHistory);
        }
        return CommonResult.success(collectionTimeMap);
    }

    /**
     * 获取正在进行的手术场次
     *
     * @return 手术信息
     */
    @Override
    public CommonResult getProcessingOperationList() {
        // 返回正在进行的手术信息
        return CommonResult.success(operationRepository.findByOperationState(OperationStateEnum.PROGRESSING.getCode()));
    }


    /**
     * 获取历史的手术场次数
     *
     * @param historyDays 历史天数
     * @return 手术场次数
     */
    @Override
    public CommonResult getHistoryOperationNumber(int historyDays) {

        // 历史采集时长的Map，key日期，value是当天开机的仪器数
        Map<LocalDate, Integer> collectionNumberMap = new TreeMap<>();

        // 获取当天的信息
        collectionNumberMap.put(TimeStampUtils.getCurrentDayZeroLocalDateTime().toLocalDate(),
                operationRepository.findByGmtCreateAfter(TimeStampUtils.getCurrentDayZeroLocalDateTime()).size());

        // 获取历史的信息
        for (int day = 0; day < historyDays - 1; day++) {
            // 获取前一天开始的时间戳
            LocalDateTime after = TimeStampUtils.getHistoryDayZeroLocalDateTimeBeforeNow(day + 1);
            // 获取前一天结束
            LocalDateTime before = TimeStampUtils.getHistoryDayZeroLocalDateTimeBeforeNow(day);
            // 获取历史一天的手术仪器信息
            collectionNumberMap.put(after.toLocalDate(),
                    operationRepository.findByGmtCreateAfterAndGmtCreateBefore(after, before).size());
        }
        return CommonResult.success(collectionNumberMap);
    }

}
