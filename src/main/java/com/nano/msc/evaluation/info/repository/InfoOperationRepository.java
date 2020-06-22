package com.nano.msc.evaluation.info.repository;

import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.info.entity.InfoOperation;
import com.nano.msc.evaluation.info.entity.InfoOperationDevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 手术信息Repository
 * @author: nano
 */
@Repository
public interface InfoOperationRepository extends JpaRepository<InfoOperation, Integer> {

    /**
     * 分页获取最新的手术信息
     *
     * @param of 分页查询
     * @return 结果
     */
    @Query("select e from InfoOperation e ORDER BY e.operationNumber DESC")
    Page<InfoOperation> findByOperationNumberDesc(PageRequest of);


    /**
     * 分页获取最新的手术信息
     *
     * @param of 分页查询
     * @return 结果
     */
    @Query("select e from InfoOperation e where e.operationState=?1 ORDER BY e.operationNumber DESC")
    Page<InfoOperation> findFinishedOperationListDesc(int operationState, PageRequest of);


    /**
     * 通过住院号和身份证查找手术信息
     *
     * @param admissionId 住院号
     * @param patientId 身份证号码
     * @return 手术信息
     */
    InfoOperation findByAdmissionIdAndPatientId(String admissionId, String patientId);


    /**
     * 通过手术场次号找手术信息
     *
     * @param operationNumber 手术场次号
     * @return 手术信息
     */
    InfoOperation findByOperationNumber(Integer operationNumber);


    /**
     * 找到某一天的记录
     *
     * @param localDateTimeAfter 当天开始时间戳
     * @param localDateTimeBefore 当天结束时间戳
     * @return 仪器使用记录
     */
    List<InfoOperation> findByGmtCreateAfterAndGmtCreateBefore(LocalDateTime localDateTimeAfter, LocalDateTime localDateTimeBefore);


    /**
     * 找到某时间之后的记录
     *
     * @param localDateTimeAfter 当天开始时间戳
     * @return 仪器使用记录
     */
    List<InfoOperation> findByGmtCreateAfter(LocalDateTime localDateTimeAfter);


    /**
     * 获取当前正在进行的手术信息列表
     * @param operationState 手术状态
     *
     * @return 信息列表
     */
    List<InfoOperation> findByOperationStateOrderByOperationNumberDesc(Integer operationState);



}
