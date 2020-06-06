package com.nano.msc.evaluation.info.repository;

import com.nano.msc.evaluation.info.entity.InfoDevice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoDeviceRepository extends JpaRepository<InfoDevice, Integer> {

    InfoDevice findByDeviceCodeAndDeviceSerialNumber(String deviceCode, String deviceSerialNumber);


    InfoDevice findByDeviceSerialNumber(String deviceSerialNumber);

    /**
     * 通过仪器号查询仪器信息
     *
     * @param deviceCode 仪器号
     * @return 仪器信息列表
     */
    List<InfoDevice> findByDeviceCode(String deviceCode);

}
