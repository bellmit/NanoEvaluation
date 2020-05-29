package com.nano.msc.evaluation.info.repository;

import com.nano.msc.evaluation.info.entity.InfoOperationMark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 手术标记信息
 * @author cz
 */
@Repository
public interface InfoOperationMarkRepository extends JpaRepository<InfoOperationMark, Integer> {

	/**
	 * 查询全部记录并按时间降序
	 *
	 * @param operationNumber 手术场次号
	 * @return 全部标记信息
	 */
	List<InfoOperationMark> findByOperationNumber(int operationNumber);


}
