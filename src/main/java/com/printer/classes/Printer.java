package com.printer.classes;

import javafx.application.Platform;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Printer {
    private int rmaid;
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
    private Printertype printertid;
    private Stage printer_stageid;

    public Printer() {
    }

    public Printer(int rmaid, String companyName, String closed, Date issueDate, String faultySn, String replacementSn, Date returnedDate, String notes, String diagnosis, Boolean bulkink, String issueCategory, String result, Boolean approved, Printertype printertid, Stage printer_stageid) {
        this.rmaid = rmaid;
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
        this.printertid = printertid;
        this.printer_stageid = printer_stageid;
    }

    @Id
    @Column(name = "rmaid")
    public int getRmaid() {
        return rmaid;
    }

    public void setRmaid(int rmaid) {
        this.rmaid = rmaid;
    }

    @Basic
    @Column(name = "company_name")
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
    @Column(name = "issue_date")
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Basic
    @Column(name = "faulty_sn")
    public String getFaultySn() {
        return faultySn;
    }

    public void setFaultySn(String faultySn) {
        this.faultySn = faultySn;
    }

    @Basic
    @Column(name = "replacement_sn")
    public String getReplacementSn() {
        return replacementSn;
    }

    public void setReplacementSn(String replacementSn) {
        this.replacementSn = replacementSn;
    }

    @Basic
    @Column(name = "returned_date")
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
    @Column(name = "issue_category")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "printertid", referencedColumnName = "printertypeid")
    public Printertype getPrintertid() {
        return printertid;
    }

    public void setPrintertid(Printertype printertid) {
        this.printertid = printertid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "printer_stageid", referencedColumnName = "stageid")
    public Stage getPrinter_stageid() {
        return printer_stageid;
    }

    public void setPrinter_stageid(Stage printer_stageid) {
        this.printer_stageid = printer_stageid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printer printer = (Printer) o;
        return rmaid == printer.rmaid &&
                Objects.equals(companyName, printer.companyName) &&
                Objects.equals(closed, printer.closed) &&
                Objects.equals(issueDate, printer.issueDate) &&
                Objects.equals(faultySn, printer.faultySn) &&
                Objects.equals(replacementSn, printer.replacementSn) &&
                Objects.equals(returnedDate, printer.returnedDate) &&
                Objects.equals(notes, printer.notes) &&
                Objects.equals(diagnosis, printer.diagnosis) &&
                Objects.equals(bulkink, printer.bulkink) &&
                Objects.equals(issueCategory, printer.issueCategory) &&
                Objects.equals(result, printer.result) &&
                Objects.equals(approved, printer.approved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rmaid, companyName, closed, issueDate, faultySn, replacementSn, returnedDate, notes, diagnosis, bulkink, issueCategory, result, approved);
    }

    @Override
    public String toString() {
        return "Printer{" +
                "rmaid=" + rmaid +
                ", companyName='" + companyName + '\'' +
                ", closed='" + closed + '\'' +
                ", issueDate=" + issueDate +
                ", faultySn='" + faultySn + '\'' +
                ", replacementSn='" + replacementSn + '\'' +
                ", returnedDate=" + returnedDate +
                ", notes='" + notes + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", bulkink=" + bulkink +
                ", issueCategory='" + issueCategory + '\'' +
                ", result='" + result + '\'' +
                ", approved=" + approved +
                '}';
    }
}
