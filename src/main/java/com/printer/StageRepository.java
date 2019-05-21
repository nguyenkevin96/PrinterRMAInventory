package com.printer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepository extends JpaRepository<Stage, Integer> {

    Stage findAllByStageId(Integer i);
}
