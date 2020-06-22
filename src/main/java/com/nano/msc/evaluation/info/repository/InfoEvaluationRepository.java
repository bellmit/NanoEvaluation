package com.nano.msc.evaluation.info.repository;

import com.nano.msc.evaluation.info.entity.InfoEvaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 术后仪器评价仓库
 * @author cz
 */
@Repository
public interface InfoEvaluationRepository extends JpaRepository<InfoEvaluation, Integer> {

	/**
	 * 通过手术场次号查找术后评价信息
	 *
	 * @param operationNumber 手术场次号
	 * @return 评价信息
	 */
	List<InfoEvaluation> findByOperationNumber(int operationNumber);


	/**
	 * 通过手术场次号和仪器号查找评价信息
	 *
	 * @param operationNumber 手术场次号
	 * @param deviceCode 仪器号
	 * @return 评价信息
	 */
	InfoEvaluation findByOperationNumberAndDeviceCode(Integer operationNumber, Integer deviceCode);

	/**
	 * 通过仪器号和序列号找
	 *
	 * @param deviceCode 仪器号
	 * @param serialNumber 序列号
	 * @return 信息
	 */
	List<InfoEvaluation> findByDeviceCodeAndSerialNumber(int deviceCode, String serialNumber);


	/**
	 * 通过仪器号和序列号找
	 *
	 * @param deviceCode 仪器号
	 * @param serialNumber 序列号
	 * @param experienceLevel 使用体验度
	 * @return 信息
	 */
	List<InfoEvaluation> findByDeviceCodeAndSerialNumberAndExperienceLevel(int deviceCode, String serialNumber, String experienceLevel);


	/**
	 * 通过仪器号找全部信息
	 *
	 * @param deviceCode 仪器号
	 * @return 评价信息
	 */
	List<InfoEvaluation> findByDeviceCode(int deviceCode);
}
