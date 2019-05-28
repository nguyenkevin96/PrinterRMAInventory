package com.printer.classes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Printertype {
    private int printertypeid;
    private String printername;
    private String printervariant;
    private String printerrmatype;

    @Id
    @Column(name = "printertypeid")
    public int getPrintertypeid() {
        return printertypeid;
    }

    public void setPrintertypeid(int printertypeid) {
        this.printertypeid = printertypeid;
    }

    @Basic
    @Column(name = "printername")
    public String getPrintername() {
        return printername;
    }

    public void setPrintername(String printername) {
        this.printername = printername;
    }

    @Basic
    @Column(name = "printervariant")
    public String getPrintervariant() {
        return printervariant;
    }

    public void setPrintervariant(String printervariant) {
        this.printervariant = printervariant;
    }

    @Basic
    @Column(name = "printerrmatype")
    public String getPrinterrmatype() {
        return printerrmatype;
    }

    public void setPrinterrmatype(String printerrmatype) {
        this.printerrmatype = printerrmatype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printertype that = (Printertype) o;
        return printertypeid == that.printertypeid &&
                Objects.equals(printername, that.printername) &&
                Objects.equals(printervariant, that.printervariant) &&
                Objects.equals(printerrmatype, that.printerrmatype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printertypeid, printername, printervariant, printerrmatype);
    }

    @Override
    public String toString() {
        return printername + " (" + printerrmatype + ") - " + printervariant;
    }
}
