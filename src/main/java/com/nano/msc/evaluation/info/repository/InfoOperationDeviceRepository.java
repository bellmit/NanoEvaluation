package com.nano.msc.evaluation.info.repository;

import com.nano.msc.evaluation.info.entity.InfoOperation;
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


	/**
	 * 通过手术场次号找使用的仪器
	 *
	 * @param operationNumber 手术场次号
	 * @return 仪器信息
	 */
	List<InfoOperationDevice> findByOperationNumber(int operationNumber);


	/**
	 * 通过仪器号和序列号找手术使用仪器信息
	 *
	 * @param deviceInfoId 仪器信息ID
	 * @return 手术使用仪器信息
	 */
	List<InfoOperationDevice> findByDeviceInfoId(Integer deviceInfoId);


	/**
	 * 通过手术场次号找使用的仪器
	 *
	 * @param operationNumber 手术场次号
	 * @param deviceCode 仪器号
	 * @return 仪器信息
	 */
	InfoOperationDevice findByOperationNumberAndDeviceCode(int operationNumber, String deviceCode);

}
