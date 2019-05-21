package com.printer;

import com.printer.Neuralabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeuraLabelRMARepository extends JpaRepository<Neuralabel, Integer> {

}
