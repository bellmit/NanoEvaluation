package com.nano.msc.evaluation.devicedata.repository;

import com.nano.msc.evaluation.devicedata.entity.DataAiQin;
import com.nano.msc.evaluation.devicedata.entity.DataYiAn8700A;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 爱琴数据访问实体
 *
 * @author: nano
 * @time: 2020/6/13 15:02
 */
public interface AiQinRepository extends JpaRepository<DataAiQin, Integer> {

	/**
	 * 查询指定operationNumber和serialNumber的最新的一条数据
	 *
	 * @param operationNumber 手术顺序号
	 * @param serialNumber    仪器序列号
	 * @return YiAn8700A实体
	 */
	DataAiQin findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(Integer operationNumber, String serialNumber);

	/**
	 * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
	 *
	 * @param operationNumber 手术顺序号
	 * @param serialNumber    仪器序列号
	 * @param pageable        分页信息
	 * @return Page<YiAn8700A>
	 */
	Page<DataAiQin> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber, Pageable pageable);

	/**
	 * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
	 *
	 * @param operationNumber 手术顺序号
	 * @param serialNumber    仪器序列号
	 * @return 数据
	 */
	List<DataAiQin> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber);

}
