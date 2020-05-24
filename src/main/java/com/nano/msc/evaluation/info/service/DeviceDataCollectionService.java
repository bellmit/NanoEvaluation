package com.nano.msc.evaluation.info.service;

import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.param.ParamCollector;

/**
 * 仪器数据采集的总服务类
 * @author nano
 */
public interface DeviceDataCollectionService {

    /**
     * 处理采集器上传的各种数据
     *
     * @param paramCollector 数据实体参数
     * @return 处理结果
     */
    CommonResult<ResultVo> handleCollectorPostedData(ParamCollector paramCollector);


}
