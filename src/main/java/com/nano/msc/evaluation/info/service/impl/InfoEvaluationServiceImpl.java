package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.evaluation.info.entity.InfoEvaluation;
import com.nano.msc.evaluation.info.repository.InfoEvaluationRepository;
import com.nano.msc.evaluation.info.service.InfoEvaluationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoEvaluationServiceImpl implements InfoEvaluationService {


    @Autowired
    private InfoEvaluationRepository evaluationRepository;

    @Override
    public List<InfoEvaluation> saveAll(List<InfoEvaluation> infoEvaluation) {
        return evaluationRepository.saveAll(infoEvaluation);
    }
}
