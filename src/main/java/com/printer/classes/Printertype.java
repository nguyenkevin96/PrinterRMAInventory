package com.printer.classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "printertype")
public class Printertype {
    private int printerTypeId;
    private String printerName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PrinterTypeID")
    public int getPrinterTypeId() {
        return printerTypeId;
    }

    public void setPrinterTypeId(int printerTypeId) {
        this.printerTypeId = printerTypeId;
    }

    @Basic
    @Column(name = "PrinterName")
    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printertype that = (Printertype) o;
        return printerTypeId == that.printerTypeId &&
                Objects.equals(printerName, that.printerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printerTypeId, printerName);
    }

    @Override
    public String toString() {
        return printerName;
    }
}
