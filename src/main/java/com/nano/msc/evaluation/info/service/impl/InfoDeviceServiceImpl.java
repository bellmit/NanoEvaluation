package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.evaluation.info.entity.InfoDevice;
import com.nano.msc.evaluation.info.repository.InfoDeviceRepository;
import com.nano.msc.evaluation.info.service.InfoDeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoDeviceServiceImpl implements InfoDeviceService {

    @Autowired
    private InfoDeviceRepository infoDeviceRepository;

    @Override
    public InfoDevice saveInfoDevice(InfoDevice infoDevice) {

        return infoDeviceRepository.save(infoDevice);
    }
}
