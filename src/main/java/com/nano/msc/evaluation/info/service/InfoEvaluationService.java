package com.nano.msc.evaluation.info.service;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoEvaluation;

import java.util.List;

/**
 * 仪器术后评价的服务接口
 * @author: nano
 */
public interface InfoEvaluationService {

    /**
     * 保存所有评价信息列表
     * @param infoEvaluation 评价消息
     * @return 是否成功
     */
    List<InfoEvaluation> saveAll(List<InfoEvaluation> infoEvaluation);

    /**
     * 获取全部的术后仪器评价的个数
     *
     * @return 个数
     */
    CommonResult<Integer> countAllEvaluationNumber();

    /**
     * 分页获取仪器评价信息
     * @return 信息列表
     */
    CommonResult list(int page, int size);


    /**
     * 得到一台具体仪器的评价统计信息
     *
     * @param deviceCode 仪器号
     * @param deviceSerialNumber 仪器序列号
     * @return 评价统计信息
     */
    CommonResult getOneDeviceEvaluationStatisticInfo(int deviceCode, String deviceSerialNumber);


    /**
     * 得到一种仪器的评价统计信息
     *
     * @param deviceCode 仪器号
     * @return 评价统计信息
     */
    CommonResult getTotalDeviceEvaluationStatisticInfo(int deviceCode);
}
