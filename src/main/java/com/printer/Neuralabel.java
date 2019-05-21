package com.printer;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Neuralabel {
    private int rmaId;
    private String companyName;
    private String closed;
    private Date issuedDate;
    private String faultySn;
    private String replacementSn;
    private Date returnedDate;
    private String notes;
    private String diagnosis;
    private boolean bulkink;
    private String issueCategory;
    private String result;
    private boolean approved;
    private PrinterType printerType;
    private Stage stageId;

    @Id
    @Column(name = "RMA_ID")
    public int getRmaId() {
        return rmaId;
    }

    public void setRmaId(int rmaId) {
        this.rmaId = rmaId;
    }

    @Basic
    @Column(name = "COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "CLOSED")
    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    @Basic
    @Column(name = "ISSUED_DATE")
    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    @Basic
    @Column(name = "FAULTY_SN")
    public String getFaultySn() {
        return faultySn;
    }

    public void setFaultySn(String faultySn) {
        this.faultySn = faultySn;
    }

    @Basic
    @Column(name = "REPLACEMENT_SN")
    public String getReplacementSn() {
        return replacementSn;
    }

    public void setReplacementSn(String replacementSn) {
        this.replacementSn = replacementSn;
    }

    @Basic
    @Column(name = "RETURNED_DATE")
    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    @Basic
    @Column(name = "NOTES")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "DIAGNOSIS")
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Basic
    @Column(name = "BULKINK")
    public boolean isBulkink() {
        return bulkink;
    }

    public void setBulkink(boolean bulkink) {
        this.bulkink = bulkink;
    }

    @Basic
    @Column(name = "ISSUE_CATEGORY")
    public String getIssueCategory() {
        return issueCategory;
    }

    public void setIssueCategory(String issueCategory) {
        this.issueCategory = issueCategory;
    }

    @Basic
    @Column(name = "RESULT")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "APPROVED")
    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @ManyToOne
    @JoinColumn(name = "Printer_Type_ID", referencedColumnName = "Printer_Type_ID")
    public PrinterType getPrinterType() {
        return printerType;
    }

    public void setPrinterType(PrinterType printerType) {
        this.printerType = printerType;
    }

    @ManyToOne
    @JoinColumn(name = "Stage_ID", referencedColumnName = "Stage_ID")
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
        Neuralabel that = (Neuralabel) o;
        return rmaId == that.rmaId &&
                bulkink == that.bulkink &&
                approved == that.approved &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(closed, that.closed) &&
                Objects.equals(issuedDate, that.issuedDate) &&
                Objects.equals(faultySn, that.faultySn) &&
                Objects.equals(replacementSn, that.replacementSn) &&
                Objects.equals(returnedDate, that.returnedDate) &&
                Objects.equals(notes, that.notes) &&
                Objects.equals(diagnosis, that.diagnosis) &&
                Objects.equals(issueCategory, that.issueCategory) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rmaId, companyName, closed, issuedDate, faultySn, replacementSn, returnedDate, notes, diagnosis, bulkink, issueCategory, result, approved);
    }

    @Override
    public String toString() {
        return "Neuralabel{" +
                "rmaId=" + rmaId +
                ", companyName='" + companyName + '\'' +
                ", closed='" + closed + '\'' +
                ", issuedDate=" + issuedDate +
                ", faultySn='" + faultySn + '\'' +
                ", replacementSn='" + replacementSn + '\'' +
                ", returnedDate=" + returnedDate +
                ", notes='" + notes + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", bulkink=" + bulkink +
                ", issueCategory='" + issueCategory + '\'' +
                ", result='" + result + '\'' +
                ", approved=" + approved +
                ", printerType=" + printerType +
                ", stageId=" + stageId +
                '}';
    }
}
