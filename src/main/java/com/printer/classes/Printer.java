package com.printer.classes;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "printer")
public class Printer {
    private int rmaId;
    private String companyName;
    private String closed;
    private Date issueDate;
    private String faultySn;
    private String replacementSn;
    private Date returnedDate;
    private String notes;
    private String diagnosis;
    private Boolean bulkink;
    private String issueCategory;
    private String result;
    private Boolean approved;
    private Printertype printertype;
    private Stage stageId;

    public Printer() {
    }

    public Printer(int rmaId, String companyName, String closed, Date issueDate, String faultySn, String replacementSn, Date returnedDate,
                   String notes, String diagnosis, Boolean bulkink, String issueCategory, String result, Boolean approved, Printertype printertype, Stage stageId) {
        this.rmaId = rmaId;
        this.companyName = companyName;
        this.closed = closed;
        this.issueDate = issueDate;
        this.faultySn = faultySn;
        this.replacementSn = replacementSn;
        this.returnedDate = returnedDate;
        this.notes = notes;
        this.diagnosis = diagnosis;
        this.bulkink = bulkink;
        this.issueCategory = issueCategory;
        this.result = result;
        this.approved = approved;
        this.printertype = printertype;
        this.stageId = stageId;
    }

    @Id
    @Column(name = "rmaID")
    public int getRmaId() {
        return rmaId;
    }

    public void setRmaId(int rmaId) {
        this.rmaId = rmaId;
    }

    @Basic
    @Column(name = "companyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "closed")
    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    @Basic
    @Column(name = "issueDate")
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Basic
    @Column(name = "faultySn")
    public String getFaultySn() {
        return faultySn;
    }

    public void setFaultySn(String faultySn) {
        this.faultySn = faultySn;
    }

    @Basic
    @Column(name = "replacementSn")
    public String getReplacementSn() {
        return replacementSn;
    }

    public void setReplacementSn(String replacementSn) {
        this.replacementSn = replacementSn;
    }

    @Basic
    @Column(name = "returnedDate")
    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "diagnosis")
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Basic
    @Column(name = "bulkink")
    public Boolean getBulkink() {
        return bulkink;
    }

    public void setBulkink(Boolean bulkink) {
        this.bulkink = bulkink;
    }

    @Basic
    @Column(name = "issueCategory")
    public String getIssueCategory() {
        return issueCategory;
    }

    public void setIssueCategory(String issueCategory) {
        this.issueCategory = issueCategory;
    }

    @Basic
    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "approved")
    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "printerTID", referencedColumnName = "PrinterTypeID")
    public Printertype getPrintertype() {
        return printertype;
    }

    public void setPrintertype(Printertype printerType) {
        this.printertype = printerType;
    }


    @ManyToOne
    @JoinColumn(name = "printerStageID", referencedColumnName = "StageID")
    public Stage getStageId() {
        return stageId;
    }

    public void setStageId(Stage stageId) {
        this.stageId = stageId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printer printer = (Printer) o;
        return rmaId == printer.rmaId &&
                bulkink == printer.bulkink &&
                Objects.equals(companyName, printer.companyName) &&
                Objects.equals(closed, printer.closed) &&
                Objects.equals(issueDate, printer.issueDate) &&
                Objects.equals(faultySn, printer.faultySn) &&
                Objects.equals(replacementSn, printer.replacementSn) &&
                Objects.equals(returnedDate, printer.returnedDate) &&
                Objects.equals(notes, printer.notes) &&
                Objects.equals(diagnosis, printer.diagnosis) &&
                Objects.equals(issueCategory, printer.issueCategory) &&
                Objects.equals(result, printer.result) &&
                Objects.equals(approved, printer.approved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rmaId, companyName, closed, issueDate, faultySn, replacementSn, returnedDate, notes, diagnosis, bulkink, issueCategory, result, approved);
    }

    @Override
    public String toString() {
        return bulkink + " " + approved;
    }
}
