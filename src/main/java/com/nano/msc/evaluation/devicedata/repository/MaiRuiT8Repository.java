package com.nano.msc.evaluation.devicedata.repository;

import com.nano.msc.evaluation.devicedata.entity.DataAiQin;
import com.nano.msc.evaluation.devicedata.entity.DataMaiRuiT8;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 迈瑞T8
 */
@Repository
public interface MaiRuiT8Repository extends JpaRepository<DataMaiRuiT8, Integer> {

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return MaiRuiT8实体
     */
    DataMaiRuiT8 findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(Integer operationNumber, String serialNumber);

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @param pageable        分页信息
     * @return Page<Norwamd9002s>
     */
    Page<DataMaiRuiT8> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber, Pageable pageable);


    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return 数据
     */
    List<DataMaiRuiT8> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber);
}
