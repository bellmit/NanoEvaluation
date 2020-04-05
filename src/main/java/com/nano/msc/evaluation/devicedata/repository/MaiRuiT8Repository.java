package com.nano.msc.evaluation.devicedata.repository;

import com.nano.msc.evaluation.devicedata.entity.MaiRuiT8;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 迈瑞T8
 */
@Repository
public interface MaiRuiT8Repository extends JpaRepository<MaiRuiT8, Integer> {

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return MaiRuiT8实体
     */
    MaiRuiT8 findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(Integer operationNumber, String serialNumber);

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @param pageable        分页信息
     * @return Page<Norwamd9002s>
     */
    Page<MaiRuiT8> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber, Pageable pageable);
}
