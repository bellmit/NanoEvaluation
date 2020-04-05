package com.nano.msc.evaluation.info.repository;

import com.nano.msc.evaluation.info.entity.InfoOperation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoOperationRepository extends JpaRepository<InfoOperation, Long> {
}
