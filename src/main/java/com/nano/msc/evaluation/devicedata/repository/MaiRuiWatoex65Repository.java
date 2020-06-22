package com.nano.msc.evaluation.devicedata.repository;


import com.nano.msc.evaluation.devicedata.entity.DataMaiRuiT8;
import com.nano.msc.evaluation.devicedata.entity.DataMaiRuiWatoex65;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 迈瑞 WATOEX65麻醉机
 */
@Repository
public interface MaiRuiWatoex65Repository extends JpaRepository<DataMaiRuiWatoex65, Integer> {

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return MaiRuiWatoex65实体
     */
    DataMaiRuiWatoex65 findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(Integer operationNumber, String serialNumber);

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @param pageable        分页信息
     * @return Page<BaoLaiTe>
     */
    Page<DataMaiRuiWatoex65> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber, Pageable pageable);

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return 数据
     */
    List<DataMaiRuiWatoex65> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber);
}
