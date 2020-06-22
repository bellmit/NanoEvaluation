package com.nano.msc.evaluation.devicedata.repository;


import com.nano.msc.evaluation.devicedata.entity.DataNuoHe9002s;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 诺和NW9002S
 * @author nano
 */
@Repository
public interface NuoHe9002sRepository extends JpaRepository<DataNuoHe9002s, Integer> {

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return Norwamd9002s实体
     */
    DataNuoHe9002s findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(Integer operationNumber, String serialNumber);



    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @param pageable        分页信息
     * @return Page<Norwamd9002s>
     */
    Page<DataNuoHe9002s> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber, Pageable pageable);

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器全部数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return Page<Norwamd9002s>
     */
    List<DataNuoHe9002s> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber);
}

