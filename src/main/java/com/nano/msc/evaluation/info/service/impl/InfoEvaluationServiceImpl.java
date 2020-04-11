package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.evaluation.info.entity.InfoEvaluation;
import com.nano.msc.evaluation.info.repository.InfoEvaluationRepository;
import com.nano.msc.evaluation.info.service.InfoEvaluationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoEvaluationServiceImpl implements InfoEvaluationService {


    @Autowired
    private InfoEvaluationRepository evaluationRepository;

    @Override
    public InfoEvaluation saveInfoEvaluation(InfoEvaluation infoEvaluation) {



        return null;
    }
}
