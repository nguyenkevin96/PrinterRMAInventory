package com.printer.repositories;

import com.printer.classes.Printer;
import com.printer.classes.Printertype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NeuraLabelRMARepository extends JpaRepository<Printer, Integer> {

    //Returns printers under the given printer type
    List<Printer> findAllByPrintertype(Printertype type);

    //Returns printers that are Label Printers
    @Query(value = "SELECT * " +
            "FROM printer " +
            "WHERE printertid = 1", nativeQuery = true)
    List<Printer> findAllNeuraLabel();

    //Returns printers that are label printers and are straight-throughs
}
