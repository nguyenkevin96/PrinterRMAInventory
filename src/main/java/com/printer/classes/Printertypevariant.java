package com.printer.classes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Printertypevariant {
    private int printertypevariantid;
    private String printertypevariant;

    @Id
    @Column(name = "printertypevariantid", nullable = false)
    public int getPrintertypevariantid() {
        return printertypevariantid;
    }

    public void setPrintertypevariantid(int printertypevariantid) {
        this.printertypevariantid = printertypevariantid;
    }

    @Basic()
    @Column(name = "printertypevariant", nullable = false, length = 255)
    public String getPrintertypevariant() {
        return printertypevariant;
    }

    public void setPrintertypevariant(String printertypevariant) {
        this.printertypevariant = printertypevariant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printertypevariant that = (Printertypevariant) o;
        return printertypevariantid == that.printertypevariantid &&
                Objects.equals(printertypevariant, that.printertypevariant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(printertypevariantid, printertypevariant);
    }
}
