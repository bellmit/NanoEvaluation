package com.nano.msc.evaluation.info.repository;

import com.nano.msc.evaluation.info.entity.InfoOperation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoOperationRepository extends JpaRepository<InfoOperation, Integer> {

    /**
     * 通过住院号和身份证查找手术信息
     *
     * @param admissionId 住院号
     * @param patientId 身份证号码
     * @return 手术信息
     */
    InfoOperation findByAdmissionIdAndPatientId(String admissionId, String patientId);


    InfoOperation findByOperationNumber(Integer operationNumber);

}
