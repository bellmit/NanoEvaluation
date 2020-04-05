package com.nano.msc.evaluation.devicedata.repository;


import com.nano.msc.evaluation.devicedata.entity.MaiRuiWatoex65;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 迈瑞 WATOEX65麻醉机
 */
@Repository
public interface MaiRuiWatoex65Repository extends JpaRepository<MaiRuiWatoex65, Integer> {

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return MaiRuiWatoex65实体
     */
    MaiRuiWatoex65 findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(Integer operationNumber, String serialNumber);

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @param pageable        分页信息
     * @return Page<BaoLaiTe>
     */
    Page<MaiRuiWatoex65> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber, Pageable pageable);
}
