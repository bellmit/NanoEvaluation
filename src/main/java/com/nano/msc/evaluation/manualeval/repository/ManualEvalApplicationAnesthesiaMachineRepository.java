package com.nano.msc.evaluation.manualeval.repository;


import com.nano.msc.evaluation.manualeval.entity.ManualEvalApplicationAnesthesiaMachine;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 问卷评价之仪器评价之麻醉机
 * @author nano
 */
public interface ManualEvalApplicationAnesthesiaMachineRepository extends JpaRepository<ManualEvalApplicationAnesthesiaMachine, Integer> {
}
