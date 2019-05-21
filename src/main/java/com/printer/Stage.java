package com.printer;

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
    @Column(name = "Stage_ID")
    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    @Basic
    @Column(name = "Stage_Name")
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
}
