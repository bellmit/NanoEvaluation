package com.nano.msc.evaluation.devicedata.repository;


import com.nano.msc.evaluation.devicedata.entity.PuKeYy106;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 普可YY106
 * @author nano
 */
@Repository
public interface PuKeYy106Repository extends JpaRepository<PuKeYy106, Integer> {

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return PearlcareYy106实体
     */
    PuKeYy106 findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(Integer operationNumber, String serialNumber);

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @param pageable        分页信息
     * @return Page<PearlcareYy106>
     */
    Page<PuKeYy106> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber, Pageable pageable);



    /**
     * 通过operationNumber和serialNumber查询全部数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return Page<PearlcareYy106>
     */
    List<PuKeYy106> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber);
}
