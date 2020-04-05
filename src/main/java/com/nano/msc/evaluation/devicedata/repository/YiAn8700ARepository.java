package com.nano.msc.evaluation.devicedata.repository;


import com.nano.msc.evaluation.devicedata.entity.YiAn8700A;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 宜安8700A麻醉机
 * @author nano
 */
@Repository
public interface YiAn8700ARepository extends JpaRepository<YiAn8700A, Integer> {

    /**
     * 查询指定operationNumber和serialNumber的最新的一条数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @return YiAn8700A实体
     */
    YiAn8700A findFirstByOperationNumberAndSerialNumberOrderByGmtCreateDesc(Integer operationNumber, String serialNumber);

    /**
     * 通过operationNumber和serialNumber查询指定手术的仪器输出数据
     *
     * @param operationNumber 手术顺序号
     * @param serialNumber    仪器序列号
     * @param pageable        分页信息
     * @return Page<YiAn8700A>
     */
    Page<YiAn8700A> findByOperationNumberAndSerialNumber(Integer operationNumber, String serialNumber, Pageable pageable);
}
