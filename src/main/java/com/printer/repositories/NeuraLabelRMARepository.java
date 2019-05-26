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
            "WHERE printertid = 1 OR printertid = 2 OR printertid = 3", nativeQuery = true)
    List<Printer> findAllNeuraLabelStandard();

    @Query(value = "SELECT * " +
            "FROM printer " +
            "WHERE printertid = 2", nativeQuery = true)
    List<Printer> findAllNeuraLabelStraightThrough();

    @Query(value = "SELECT * " +
            "FROM printer " +
            "WHERE printertid = 3", nativeQuery = true)
    List<Printer> findAllNeuraLabelCPath();

    @Query(value = "SELECT * " +
            "FROM printer " +
            "WHERE printertid = 4", nativeQuery = true)
    List<Printer> findAllNeuraLogSCPath();

    @Query(value = "SELECT * " +
            "FROM printer " +
            "WHERE printertid = 5", nativeQuery = true)
    List<Printer> findAllNeuraLogStraightThrough();

    @Query(value = "SELECT * " +
            "FROM printer " +
            "WHERE printertid = 6", nativeQuery = true)
    List<Printer> findAllNeuraLogCPath();
}
