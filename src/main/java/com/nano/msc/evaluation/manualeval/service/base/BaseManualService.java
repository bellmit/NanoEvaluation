package com.nano.msc.evaluation.manualeval.service.base;

import com.nano.msc.common.vo.CommonResult;

/**
 * 人工评价基础服务接口
 * @author nano
 */
public interface BaseManualService {

    /**
     * 解析并存储人工问卷数据
     *
     * @param rawData 原始数据
     * @return 是否成功
     */
    CommonResult parseAndSave(String rawData);
}

