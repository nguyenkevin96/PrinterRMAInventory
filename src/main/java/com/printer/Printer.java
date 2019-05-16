package com.printer;

import java.util.Date;

public class Printer {
    private int RMA_NUMBER;
    private String COMPANY;
    private String CLOSED;
    private Date ISSUED_DATE;
    private int FAULTY_SN;
    private int REPLACEMENT_SN;
    private Date RETURN_DATE;
    private String NOTES;
    private String DIAGNOSIS;
    private boolean BULK_INK;
    private String ISSUE;
    private String RESULT;
    private Boolean APPROVED;

    public Printer(int RMA_NUMBER, String COMPANY, String CLOSED, Date ISSUED_DATE, int FAULTY_SN, int REPLACEMENT_SN,
                   Date RETURN_DATE, String NOTES, String DIAGNOSIS, boolean BULK_INK, String ISSUE, String RESULT, Boolean APPROVED) {
        this.RMA_NUMBER = RMA_NUMBER;
        this.COMPANY = COMPANY;
        this.CLOSED = CLOSED;
        this.ISSUED_DATE = ISSUED_DATE;
        this.FAULTY_SN = FAULTY_SN;
        this.REPLACEMENT_SN = REPLACEMENT_SN;
        this.RETURN_DATE = RETURN_DATE;
        this.NOTES = NOTES;
        this.DIAGNOSIS = DIAGNOSIS;
        this.BULK_INK = BULK_INK;
        this.ISSUE = ISSUE;
        this.RESULT = RESULT;
        this.APPROVED = APPROVED;
    }

    public int getRMA_NUMBER() {
        return RMA_NUMBER;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public String getCLOSED() {
        return CLOSED;
    }

    public Date getISSUED_DATE() {
        return ISSUED_DATE;
    }

    public int getFAULTY_SN() {
        return FAULTY_SN;
    }

    public int getREPLACEMENT_SN() {
        return REPLACEMENT_SN;
    }

    public Date getRETURN_DATE() {
        return RETURN_DATE;
    }

    public String getNOTES() {
        return NOTES;
    }

    public String getDIAGNOSIS() {
        return DIAGNOSIS;
    }

    public boolean isBULK_INK() {
        return BULK_INK;
    }

    public String getISSUE() {
        return ISSUE;
    }

    public String getRESULT() {
        return RESULT;
    }

    public Boolean getAPPROVED() {
        return APPROVED;
    }
}
