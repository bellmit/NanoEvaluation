package com.nano.msc.gps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: nano
 * @time: 2020/5/16 13:31
 */
@Repository
public interface GpsDataRepository extends JpaRepository<GpsDataEntity, Integer> {




}
