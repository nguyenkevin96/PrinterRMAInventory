package com.printer;

import com.printer.PrinterType;
import javafx.print.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Repository
public interface PrinterTypeRepository extends JpaRepository<PrinterType, Integer> {

    @Override
    ArrayList<PrinterType> findAll();

    PrinterType findAllByPrinterNameId(Integer i);

    PrinterType findAllByPrinterTypeId(Integer i);
}
