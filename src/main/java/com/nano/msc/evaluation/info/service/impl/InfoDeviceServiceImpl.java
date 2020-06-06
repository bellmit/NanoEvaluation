package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoDevice;
import com.nano.msc.evaluation.info.entity.InfoOperationDevice;
import com.nano.msc.evaluation.info.repository.InfoDeviceRepository;
import com.nano.msc.evaluation.info.repository.InfoOperationDeviceRepository;
import com.nano.msc.evaluation.info.service.InfoDeviceService;
import com.nano.msc.evaluation.platform.vo.DeviceCardStatisticVo;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;

import static java.util.stream.Collectors.toList;

/**
 * 仪器信息服务实现类
 * @author: nano
 */
@Slf4j
@Service
public class InfoDeviceServiceImpl implements InfoDeviceService {

    @Autowired
    private InfoDeviceRepository infoDeviceRepository;


    @Autowired
    private InfoOperationDeviceRepository operationDeviceRepository;


    @Override
    public InfoDevice save(InfoDevice infoDevice) {
        return infoDeviceRepository.save(infoDevice);
    }


    @Override
    public InfoDevice findByDeviceCodeAndDeviceSerialNumber(String deviceCode, String deviceSerialNumber) {
        return infoDeviceRepository.findByDeviceCodeAndDeviceSerialNumber(deviceCode, deviceSerialNumber);
    }

    @Override
    public CommonResult getAll() {
        return CommonResult.success(infoDeviceRepository.findAll());
    }


    /**
     * 请求列表
     *
     * @param page 页数
     * @param size 大小
     * @return 分页结果
     */
    @Override
    public CommonResult list(Integer page, Integer size) {
        return ServiceCrudCheckUtils.listObjectAndCheck(infoDeviceRepository, page, size);
    }


    /**
     * 获取接入仪器总数量
     * @return 数量
     */
    @Override
    public CommonResult getDeviceNumber() {
        return CommonResult.success(infoDeviceRepository.count());
    }


    /**
     * 通过仪器号查询对应拥有的仪器列表
     * @param deviceCode 仪器号
     * @return 序列号列表
     */
    @Override
    public CommonResult getSerialNumberListByDeviceCode(String deviceCode) {

        // 获取序列号列表
        return CommonResult.success(infoDeviceRepository
                .findByDeviceCode(deviceCode).stream()
                .map(InfoDevice::getDeviceSerialNumber).collect(toList()));
    }


    /**
     * 通过仪器号与序列号获取仪器信息卡片内容
     *
     * @param deviceCode 仪器号
     * @param deviceSerialNumber 序列号
     * @return 信息卡片内容包含：这个仪器的全部信息
     * +这台仪器的采集信息统计（总共多少场手术、总共的采集时长、总共数据条数、平均掉线率）（这些信息从InfoOperationDevice表获取）
     * +这台仪器的总评价条数
     * +这台仪器参与的手术列表前十
     */
    @Override
    public CommonResult getDeviceCardDetailInfo(String deviceCode, String deviceSerialNumber) {

        InfoDevice infoDevice = infoDeviceRepository.findByDeviceCodeAndDeviceSerialNumber(deviceCode, deviceSerialNumber);
        if (infoDevice == null) {
            return CommonResult.validateFailed("没有相关信息:" + deviceCode + "," + deviceSerialNumber);
        }
        // 构造返回的信息
        DeviceCardStatisticVo cardStatisticVo = new DeviceCardStatisticVo();
        // Copy基本信息
        BeanUtil.copyProperties(infoDevice, cardStatisticVo);
        // 统计其他统计信息
        List<InfoOperationDevice> operationDeviceList = operationDeviceRepository.findByDeviceInfoId(infoDevice.getId());
        log.info("operationDeviceList" + operationDeviceList.size());
        int totalDataNumber = 0;
        long totalOperationTime = 0;
        double totalDropRate = 0;
        for (InfoOperationDevice operationDevice : operationDeviceList) {
            if (operationDevice.getDataNumber() != null) {
                totalDataNumber = totalDataNumber + operationDevice.getDataNumber();
                totalOperationTime = totalOperationTime + operationDevice.getOperationDurationTime();
                totalDropRate = totalDropRate + operationDevice.getDropRate();
            }
        }
        cardStatisticVo.setDataNumberAll(totalDataNumber);
        cardStatisticVo.setOperationDurationTimeAll(totalOperationTime);

        if (operationDeviceList.size() == 0) {
            cardStatisticVo.setAverageDropRate(0D);
        } else {
            cardStatisticVo.setAverageDropRate(totalDropRate / operationDeviceList.size());
        }

        return CommonResult.success(cardStatisticVo);
    }


}
