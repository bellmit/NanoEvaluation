package com.nano.msc.evaluation.devicedata.service;

import com.nano.msc.common.vo.CollectionVo;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.param.ParamCollector;

/**
 * 仪器数据服务接口
 * @author nano
 */
public interface DeviceDataService {

    CommonResult<CollectionVo> handleCollectorPostDeviceData(ParamCollector paramCollector);


}
