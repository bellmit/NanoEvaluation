package com.nano.msc.evaluation.info.service;

import com.nano.msc.evaluation.info.entity.InfoOperation;

import java.util.List;

/**
 * 手术信息服务
 * @author nano
 */
public interface InfoOperationService {

    InfoOperation addOperationInfo(InfoOperation infoOperation);

    List<InfoOperation> findAllOperationInfo();
}
