package com.printer.repositories;

import com.printer.classes.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeuraLabelRMARepository extends JpaRepository<Printer, Integer> {

}
