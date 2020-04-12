package com.nano.msc.evaluation.info.service.impl;

import com.nano.msc.evaluation.info.entity.InfoDevice;
import com.nano.msc.evaluation.info.repository.InfoDeviceRepository;
import com.nano.msc.evaluation.info.service.InfoDeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InfoDeviceServiceImpl implements InfoDeviceService {

    @Autowired
    private InfoDeviceRepository infoDeviceRepository;

    @Override
    public InfoDevice save(InfoDevice infoDevice) {
        return infoDeviceRepository.save(infoDevice);
    }


    @Override
    public InfoDevice findByDeviceCodeAndDeviceSerialNumber(String deviceCode, String deviceSerialNumber) {
        return infoDeviceRepository.findByDeviceCodeAndDeviceSerialNumber(deviceCode, deviceSerialNumber);
    }

}
