package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.exceptions.ExceptionAsserts;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.repository.InfoOperationRepository;
import com.nano.msc.evaluation.info.service.InfoOperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoOperationServiceImpl implements InfoOperationService {

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


    @Override
    public InfoOperation findByOperationNumber(Integer operationNumber) {
        return operationRepository.findByOperationNumber(operationNumber);
    }


}
