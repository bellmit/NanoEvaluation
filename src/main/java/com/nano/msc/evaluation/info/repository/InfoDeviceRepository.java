package com.nano.msc.evaluation.info.repository;

import com.nano.msc.evaluation.info.entity.InfoDevice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoDeviceRepository extends JpaRepository<InfoDevice, Integer> {

    InfoDevice findByDeviceCodeAndDeviceSerialNumber(String deviceCode, String deviceSerialNumber);


}
