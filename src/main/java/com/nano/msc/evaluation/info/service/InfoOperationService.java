package com.nano.msc.evaluation.info.service;

import com.nano.msc.common.vo.CommonResult;
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

    CommonResult list(Integer page, Integer size);

    /**
     * 获取历史采集时间
     * @param days 历史天数
     * @return 时间
     */
    CommonResult getHistoryCollectionTime(int days);


    /**
     * 获取正在进行的手术场次
     *
     * @return 手术信息
     */
    CommonResult getProcessingOperationList();

}
