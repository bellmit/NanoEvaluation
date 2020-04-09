package com.nano.msc.evaluation.info.repository;

import com.nano.msc.evaluation.info.entity.InfoEvaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoEvaluationRepository extends JpaRepository<InfoEvaluation, Integer> {
}
