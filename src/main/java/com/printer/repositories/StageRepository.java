package com.printer.repositories;

import com.printer.classes.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StageRepository extends JpaRepository<Stage, Integer> {

    @Override
    ArrayList<Stage> findAll();
}
