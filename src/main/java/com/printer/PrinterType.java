package com.printer;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "printer_type", schema = "public", catalog = "RMA_Printer")
public class PrinterType {
    private int printerTypeId;
    private String printerName;
    private int printerNameId;

    @Id
    @Column(name = "Printer_Type_ID")
    public int getPrinterTypeId() {
        return printerTypeId;
    }

    public void setPrinterTypeId(int printerTypeId) {
        this.printerTypeId = printerTypeId;
    }

    @Basic
    @Column(name = "Printer_Name")
    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    @Basic
    @Column(name = "Printer_Name_ID")
    public int getPrinterNameId() {
        return printerNameId;
    }

    public void setPrinterNameId(int printerNameId) {
        this.printerNameId = printerNameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrinterType that = (PrinterType) o;
        return printerTypeId == that.printerTypeId &&
                printerNameId == that.printerNameId &&
                Objects.equals(printerName, that.printerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printerTypeId, printerName, printerNameId);
    }

    @Override
    public String toString() {
        return printerName;
    }
}
