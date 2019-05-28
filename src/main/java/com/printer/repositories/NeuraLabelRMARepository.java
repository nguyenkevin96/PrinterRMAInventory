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
    //List<Printer> findAllByPrintertypeid(Integer index);

    //Returns printers that are Label Printers
    @Query(value = "SELECT * " +
            "FROM printer " +
            "WHERE printertid = 1 OR printertid = 2 OR printertid = 3", nativeQuery = true)
    List<Printer> findAllReplacedNeuraLabel();

    @Query(value = "SELECT * " +
            "FROM printer " +
            "WHERE printertid = 4 OR printertid = 5 OR printertid = 6", nativeQuery = true)
    List<Printer> findAllRMANeuraLabel();

    @Query(value = "SELECT * " +
            "FROM printer " +
            "WHERE printertid = 7 OR printertid = 8 OR printertid = 9", nativeQuery = true)
    List<Printer> findAllReplacedNeuraLog();

    @Query(value = "SELECT * " +
            "FROM printer " +
            "WHERE printertid = 10 OR printertid = 11 OR printertid = 12", nativeQuery = true)
    List<Printer> findAllRMANeuraLog();
}