package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.evaluation.info.entity.InfoOperationMark;
import com.nano.msc.evaluation.info.repository.InfoOperationMarkRepository;
import com.nano.msc.evaluation.info.service.InfoOperationMarkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoOperationMarkServiceImpl implements InfoOperationMarkService {

    @Autowired
    private InfoOperationMarkRepository markRepository;

    @Override
    public List<InfoOperationMark> saveAll(List<InfoOperationMark> markList) {
        return markRepository.saveAll(markList);
    }

}
