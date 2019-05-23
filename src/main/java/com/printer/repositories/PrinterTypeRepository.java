package com.printer.repositories;

import com.printer.classes.Printertype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PrinterTypeRepository extends JpaRepository<Printertype, Integer> {

    @Override
    ArrayList<Printertype> findAll();

    List<Printertype> findAllByPrinterName(String name);
}
