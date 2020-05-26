package com.nano.msc.evaluation.info.service;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoOperationDevice;

/**
 * 仪器使用信息服务接口
 * @author: nano
 */
public interface InfoOperationDeviceService {

    /**
     * 保存手术仪器信息
     * @param operationDevice 手术仪器信息
     */
    InfoOperationDevice save(InfoOperationDevice operationDevice);


    /**
     * 获取仪器历史开机信息
     * @return 开机信息
     */
    CommonResult getDeviceOpenNumberHistory(int historyDays);

}
