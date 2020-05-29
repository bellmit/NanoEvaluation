package com.nano.msc.evaluation.info.service;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoOperation;

import org.springframework.data.domain.Pageable;

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


    /**
     * 获取历史的手术场次数
     *
     * @param days 历史天数
     * @return 手术场次数
     */
    CommonResult getHistoryOperationNumber(int days);


    /**
     * 得到全部的手术信息数量
     *
     * @return 手术信息数量
     */
    CommonResult countAllOperationNumber();


    /**
     * 手术信息分页查询 按照时间顺序降序排列
     *
     * @param page 页数
     * @param size 个数
     * @return 结果
     */
    CommonResult getOperationList(int page, int size);

    /**
     * 获取某一场手术的全部详细信息
     *
     * @param operationNumber 手术场次号
     * @return 全部信息信息
     */
    CommonResult getDetailInfoOfOneOperation(int operationNumber);
}
