package com.nano.msc.evaluation.devicedata.repository;


import com.nano.msc.evaluation.devicedata.entity.DataMaiRuiWatoex55Pro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 迈瑞WATOEX55Pro麻醉机
 * @author nano
 */
@Repository
public interface MaiRuiWatoex55ProRepository extends JpaRepository<DataMaiRuiWatoex55Pro, Integer> {

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return MaiRuiWatoex55Pro实体
     */
    DataMaiRuiWatoex55Pro findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(Integer operationNumber, String serialNumber);

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @param pageable        分页信息
     * @return Page<MaiRuiWatoex55Pro>
     */
    Page<DataMaiRuiWatoex55Pro> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber, Pageable pageable);
}
