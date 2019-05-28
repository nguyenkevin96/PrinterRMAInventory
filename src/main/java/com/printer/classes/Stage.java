package com.printer.classes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Stage {
    private int stageid;
    private String stagename;

    @Id
    @Column(name = "stageid")
    public int getStageid() {
        return stageid;
    }

    public void setStageid(int stageid) {
        this.stageid = stageid;
    }

    @Basic
    @Column(name = "stagename")
    public String getStagename() {
        return stagename;
    }

    public void setStagename(String stagename) {
        this.stagename = stagename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return stageid == stage.stageid &&
                Objects.equals(stagename, stage.stagename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stageid, stagename);
    }

    @Override
    public String toString() {
        return stagename;
    }
}
