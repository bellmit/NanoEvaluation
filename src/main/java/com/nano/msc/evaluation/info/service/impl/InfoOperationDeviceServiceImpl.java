package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.evaluation.info.entity.InfoOperationDevice;
import com.nano.msc.evaluation.info.repository.InfoOperationDeviceRepository;
import com.nano.msc.evaluation.info.service.InfoOperationDeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoOperationDeviceServiceImpl implements InfoOperationDeviceService {

    @Autowired
    private InfoOperationDeviceRepository operationDeviceRepository;


    @Override
    public InfoOperationDevice save(InfoOperationDevice operationDevice) {
        return operationDeviceRepository.save(operationDevice);
    }
}
