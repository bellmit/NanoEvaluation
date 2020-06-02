package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.exceptions.ExceptionAsserts;
import com.nano.msc.common.utils.TimeStampUtils;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.devicedata.service.PlatformDeviceDataService;
import com.nano.msc.evaluation.enums.OperationStateEnum;
import com.nano.msc.evaluation.info.entity.InfoEvaluation;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.entity.InfoOperationDevice;
import com.nano.msc.evaluation.info.repository.InfoEvaluationRepository;
import com.nano.msc.evaluation.info.repository.InfoOperationDeviceRepository;
import com.nano.msc.evaluation.info.repository.InfoOperationMarkRepository;
import com.nano.msc.evaluation.info.repository.InfoOperationRepository;
import com.nano.msc.evaluation.info.service.InfoOperationService;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;
import com.nano.msc.evaluation.platform.vo.InfoEvaluationVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 手术信息服务实现类
 * @author cz
 */
@Service
public class InfoOperationServiceImpl implements InfoOperationService {


    private static final Logger logger = LoggerFactory.getLogger("DeviceDataCollectionServiceImpl");

    /**
     * 手术信息仓库
     */
    @Autowired
    private InfoOperationRepository operationRepository;

    /**
     * 手术标记仓库
     */
    @Autowired
    private InfoOperationMarkRepository operationMarkRepository;

    /**
     * 术后仪器评价仓库
     */
    @Autowired
    private InfoEvaluationRepository evaluationRepository;

    /**
     * 使用仪器仓库
     */
    @Autowired
    private InfoOperationDeviceRepository operationDeviceRepository;


    @Autowired
    private PlatformDeviceDataService platformDeviceDataService;


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

    /**
     * 得到全部的手术信息数量
     *
     * @return 手术信息数量
     */
    @Override
    public CommonResult countAllOperationNumber() {
        return CommonResult.success(operationRepository.count());
    }


    /**
     * 手术信息分页查询 按照时间顺序降序排列
     *
     * @param page 页数
     * @param size 个数
     * @return 结果
     */
    @Override
    public CommonResult getOperationList(int page, int size) {
        return CommonResult.success(operationRepository.findByOperationNumberDesc(PageRequest.of(page, size)));
    }


    /**
     * 获取某一场手术的全部详细信息
     *
     * 这里详细信息包含手术基本信息，手术标记信息，手术评价信息等，数据统计信息等。
     *
     * @param operationNumber 手术场次号
     * @return 全部信息信息
     */
    @Override
    public CommonResult getDetailInfoOfOneOperation(int operationNumber) {

        // 存放详细手术信息的Map
        Map<String, Object> detailOperationInfoMap = new HashMap<>();

        // 获取手术信息
        InfoOperation infoOperation = operationRepository.findByOperationNumber(operationNumber);
        if (infoOperation == null) {
            return CommonResult.validateFailed("手术场次号不存在:" + operationNumber);
        } else {
            detailOperationInfoMap.put("operationInfo", infoOperation);
        }

        // 获取标记信息列表
        detailOperationInfoMap.put("operationMarks", operationMarkRepository.findByOperationNumber(operationNumber));
        // 获取并转化评价信息列表
        List<InfoEvaluation> evaluationList = evaluationRepository.findByOperationNumber(operationNumber);
        detailOperationInfoMap.put("evaluationInfo", InfoEvaluationVo.generateEvaluationVo(evaluationList));
        detailOperationInfoMap.put("deviceDataDetails", platformDeviceDataService.getDeviceDataStatisticData(operationNumber));
        return CommonResult.success(detailOperationInfoMap);
    }

}
