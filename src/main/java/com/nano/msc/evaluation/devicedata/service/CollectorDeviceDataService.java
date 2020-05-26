package com.nano.msc.evaluation.devicedata.service;

import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.param.ParamCollector;

/**
 * 仪器数据服务接口
 * @author nano
 */
public interface CollectorDeviceDataService {

    /**
     * 处理并解析采集器上传的数据
     *
     * @param paramCollector 数据参数
     * @return 是否成功
     */
    CommonResult<ResultVo> handleCollectorPostDeviceData(ParamCollector paramCollector);

    /**
     * 使用手术场次号+仪器号获取这个仪器最新的仪器数据
     * @param operationNumber 手术场次号
     * @param deviceCode 仪器号
     * @return 最新数据实体
     */
    CommonResult getNewestDeviceData(Integer operationNumber, Integer deviceCode);

    /**
     * 使用Kafka方式处理数据
     * @param paramCollector 采集器参数
     */
    CommonResult handleCollectorPostDeviceDataByKafka(ParamCollector paramCollector);

}
