package com.nano.msc.evaluation.info.service;

import com.nano.msc.evaluation.info.entity.InfoOperation;

import java.util.List;

/**
 * 手术信息服务
 * @author nano
 */
public interface InfoOperationService {

    /**
     * 处理新的手术信息请求
     *
     * @param infoOperation 手术信息
     * @return 是否成功
     */
    InfoOperation handleNewOperationInfoRequestAndSave(InfoOperation infoOperation);

    List<InfoOperation> findAllOperationInfo();

    InfoOperation findByOperationNumber(Integer operationNumber);

    InfoOperation update(InfoOperation infoOperation);
}
