package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.repository.InfoOperationRepository;
import com.nano.msc.evaluation.info.service.InfoOperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoOperationImpl implements InfoOperationService {

    @Autowired
    private InfoOperationRepository infoOperationRepository;

    @Override
    public InfoOperation addOperationInfo(InfoOperation infoOperation) {
        return infoOperationRepository.save(infoOperation);
    }

    @Override
    public List<InfoOperation> findAllOperationInfo() {
        return infoOperationRepository.findAll();
    }
}
