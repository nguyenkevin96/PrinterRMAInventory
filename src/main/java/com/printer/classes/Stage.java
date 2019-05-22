package com.printer.classes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Stage {
    private int stageId;
    private String stageName;

    @Id
    @Column(name = "stageid")
    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    @Basic
    @Column(name = "stagename")
    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return stageId == stage.stageId &&
                Objects.equals(stageName, stage.stageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stageId, stageName);
    }

    @Override
    public String toString() {
        return stageName;
    }
}
