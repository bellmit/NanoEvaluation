package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoEvaluation;
import com.nano.msc.evaluation.info.repository.InfoEvaluationRepository;
import com.nano.msc.evaluation.info.service.InfoEvaluationService;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
