package com.printer.repositories;

import com.printer.classes.PrintertypePrintervariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrinterTypeAndVariantRepository extends JpaRepository<PrintertypePrintervariant, Integer> {

}
