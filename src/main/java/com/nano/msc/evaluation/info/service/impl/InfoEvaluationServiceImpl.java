package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.enums.evaluation.EvaluationReliabilityLevelEnum;
import com.nano.msc.evaluation.info.entity.InfoEvaluation;
import com.nano.msc.evaluation.info.repository.InfoEvaluationRepository;
import com.nano.msc.evaluation.info.service.InfoEvaluationService;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 术后仪器评价服务实现类
 * @author: nano
 */
@Service
public class InfoEvaluationServiceImpl implements InfoEvaluationService {

    @Autowired
    private InfoEvaluationRepository evaluationRepository;

    @Override
    public List<InfoEvaluation> saveAll(List<InfoEvaluation> infoEvaluation) {
        return evaluationRepository.saveAll(infoEvaluation);
    }


    /**
     * 获取全部的术后仪器评价的个数
     *
     * @return 个数
     */
    @Override
    public CommonResult<Integer> countAllEvaluationNumber(){
        return CommonResult.success((int)evaluationRepository.count());
    }


    /**
     * 分页获取仪器评价信息
     * @return 信息列表
     */
    @Override
    public CommonResult list(int page, int size) {
        return ServiceCrudCheckUtils.listObjectAndCheck(evaluationRepository, page, size);
    }

    /**
     * 得到一台具体仪器的评价统计信息
     *
     * @param deviceCode 仪器号
     * @param serialNumber 仪器序列号
     * @return 评价统计信息
     */
    @Override
    public CommonResult getOneDeviceEvaluationStatisticInfo(int deviceCode, String serialNumber) {
        List<InfoEvaluation> evaluationList = evaluationRepository.findByDeviceCodeAndSerialNumber(deviceCode, serialNumber);
        return CommonResult.success(getEvaluationStatisticInfo(evaluationList));
    }

    /**
     * 得到一种仪器的评价统计信息
     *
     * @param deviceCode 仪器号
     * @return 评价统计信息
     */
    @Override
    public CommonResult getTotalDeviceEvaluationStatisticInfo(int deviceCode) {
        List<InfoEvaluation> evaluationList = evaluationRepository.findByDeviceCode(deviceCode);
        return CommonResult.success(getEvaluationStatisticInfo(evaluationList));
    }

    /**
     * 统计评价信息
     *
     * @return 评价信息的Map
     */
    private Map<String, Map<String, Integer>> getEvaluationStatisticInfo(List<InfoEvaluation> evaluationList) {
        Map<String, Map<String, Integer>> resMap = new HashMap<>();
        Map<String, Integer> experienceLevelMap = new HashMap<>();
        Map<String, Integer> reliabilityLevelMap = new HashMap<>();
        Map<String, Integer> errorMap = new HashMap<>();
        int experienceLevel1 = 0;
        int experienceLevel2 = 0;
        int experienceLevel3 = 0;
        int experienceLevel4 = 0;
        int experienceLevel5 = 0;
        int reliabilityLevel1 = 0;
        int reliabilityLevel2 = 0;
        int reliabilityLevel3 = 0;
        int reliabilityLevel4 = 0;
        int reliabilityLevel5 = 0;
        int hasError = 0;
        int noError = 0;
        // 计算使用满意度个数
        for(InfoEvaluation evaluation : evaluationList) {
            // 得到有效的评价信息
            if(evaluation.getReliabilityLevel() != null) {
                if("1".equals(evaluation.getExperienceLevel())) {
                    experienceLevel1++;
                } else if ("2".equals(evaluation.getExperienceLevel())) {
                    experienceLevel2++;
                } else if ("3".equals(evaluation.getExperienceLevel())) {
                    experienceLevel3++;
                } else if ("4".equals(evaluation.getExperienceLevel())) {
                    experienceLevel4++;
                } else if ("5".equals(evaluation.getExperienceLevel())) {
                    experienceLevel5++;
                }
                if("1".equals(evaluation.getReliabilityLevel())) {
                    reliabilityLevel1++;
                } else if ("2".equals(evaluation.getReliabilityLevel())) {
                    reliabilityLevel2++;
                } else if ("3".equals(evaluation.getReliabilityLevel())) {
                    reliabilityLevel3++;
                } else if ("4".equals(evaluation.getReliabilityLevel())) {
                    reliabilityLevel4++;
                } else if ("5".equals(evaluation.getReliabilityLevel())) {
                    reliabilityLevel5++;
                }
                if(evaluation.getHasError()) {
                    hasError++;
                } else {
                    noError++;
                }
            }
        }
        // 满意度
        experienceLevelMap.put(EvaluationReliabilityLevelEnum.VERY_GOOD.getMsg(), experienceLevel1);
        experienceLevelMap.put(EvaluationReliabilityLevelEnum.GOOD.getMsg(), experienceLevel2);
        experienceLevelMap.put(EvaluationReliabilityLevelEnum.JUST_SO_SO.getMsg(), experienceLevel3);
        experienceLevelMap.put(EvaluationReliabilityLevelEnum.BAD.getMsg(), experienceLevel4);
        experienceLevelMap.put(EvaluationReliabilityLevelEnum.VERY_GOOD.getMsg(), experienceLevel5);
        // 可靠性
        reliabilityLevelMap.put(EvaluationReliabilityLevelEnum.VERY_GOOD.getMsg(), reliabilityLevel1);
        reliabilityLevelMap.put(EvaluationReliabilityLevelEnum.GOOD.getMsg(), reliabilityLevel2);
        reliabilityLevelMap.put(EvaluationReliabilityLevelEnum.JUST_SO_SO.getMsg(), reliabilityLevel3);
        reliabilityLevelMap.put(EvaluationReliabilityLevelEnum.BAD.getMsg(), reliabilityLevel4);
        reliabilityLevelMap.put(EvaluationReliabilityLevelEnum.VERY_BAD.getMsg(), reliabilityLevel5);
        // 是否有错误
        errorMap.put("hasError", hasError);
        errorMap.put("noError", noError);
        resMap.put("experienceLevel", experienceLevelMap);
        resMap.put("reliabilityLevel", reliabilityLevelMap);
        resMap.put("error", errorMap);
        return resMap;
    }

}
