package com.printer.classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Printertype {
    private int printertypeid;
    private String printername;
    private Printertypevariant printertypevariant;

    @Id
    @Column(name = "printertypeid", nullable = false)
    public int getPrintertypeid() {
        return printertypeid;
    }

    public void setPrintertypeid(int printertypeid) {
        this.printertypeid = printertypeid;
    }

    @Basic
    @Column(name = "printername", nullable = false, length = 255)
    public String getPrintername() {
        return printername;
    }

    public void setPrintername(String printername) {
        this.printername = printername;
    }

    @OneToMany
    @JoinColumn

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printertype that = (Printertype) o;
        return printertypeid == that.printertypeid &&
                Objects.equals(printername, that.printername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printertypeid, printername);
    }
}
