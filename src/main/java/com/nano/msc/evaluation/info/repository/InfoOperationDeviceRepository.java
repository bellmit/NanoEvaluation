package com.nano.msc.evaluation.info.repository;

import com.nano.msc.evaluation.info.entity.InfoOperationDevice;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 使用仪器信息的repository
 * @author: nano
 */
@Repository
public interface InfoOperationDeviceRepository extends JpaRepository<InfoOperationDevice, Integer> {


	/**
	 * 找到某一天的记录
	 *
	 * @param localDateTimeAfter 当天开始时间戳
	 * @param localDateTimeBefore 当天结束时间戳
	 * @return 仪器使用记录
	 */
	List<InfoOperationDevice> findByGmtCreateAfterAndGmtCreateBefore(LocalDateTime localDateTimeAfter, LocalDateTime localDateTimeBefore);


	/**
	 * 找到某时间之后的记录
	 *
	 * @param localDateTimeAfter 当天开始时间戳
	 * @return 仪器使用记录
	 */
	List<InfoOperationDevice> findByGmtCreateAfter(LocalDateTime localDateTimeAfter);


}
