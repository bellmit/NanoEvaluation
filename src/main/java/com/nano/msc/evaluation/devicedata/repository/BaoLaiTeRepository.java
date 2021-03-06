package com.nano.msc.evaluation.devicedata.repository;


import com.nano.msc.evaluation.devicedata.entity.DataBaoLaiTeA8;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 宝莱特A8
 * @author cz
 */
@Repository
public interface BaoLaiTeRepository extends JpaRepository<DataBaoLaiTeA8, Integer> {

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return BaoLaiTe实体
     */
    DataBaoLaiTeA8 findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(Integer operationNumber, String serialNumber);

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @param pageable        分页信息
     * @return Page<BaoLaiTe>
     */
    Page<DataBaoLaiTeA8> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber, Pageable pageable);


    List<DataBaoLaiTeA8> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber);
}
