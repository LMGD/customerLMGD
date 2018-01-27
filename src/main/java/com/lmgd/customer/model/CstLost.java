package com.lmgd.customer.model;

import java.io.Serializable;
import java.util.Date;

public class CstLost implements Serializable {
    private Long lstId;

    private String lstCustNo;

    private String lstCustName;

    private Long lstCustManagerId;

    private String lstCustManagerName;

    private Date lstLastOrderDate;

    private Date lstLostDate;

    private String lstDelay;

    private String lstReason;

    private String lstStatus;

    public CstLost(Long lstId, String lstCustNo, String lstCustName, Long lstCustManagerId, String lstCustManagerName, Date lstLastOrderDate, Date lstLostDate, String lstDelay, String lstReason, String lstStatus) {
        this.lstId = lstId;
        this.lstCustNo = lstCustNo;
        this.lstCustName = lstCustName;
        this.lstCustManagerId = lstCustManagerId;
        this.lstCustManagerName = lstCustManagerName;
        this.lstLastOrderDate = lstLastOrderDate;
        this.lstLostDate = lstLostDate;
        this.lstDelay = lstDelay;
        this.lstReason = lstReason;
        this.lstStatus = lstStatus;
    }

    public CstLost() {
        super();
    }

    public Long getLstId() {
        return lstId;
    }

    public void setLstId(Long lstId) {
        this.lstId = lstId;
    }

    public String getLstCustNo() {
        return lstCustNo;
    }

    public void setLstCustNo(String lstCustNo) {
        this.lstCustNo = lstCustNo;
    }

    public String getLstCustName() {
        return lstCustName;
    }

    public void setLstCustName(String lstCustName) {
        this.lstCustName = lstCustName;
    }

    public Long getLstCustManagerId() {
        return lstCustManagerId;
    }

    public void setLstCustManagerId(Long lstCustManagerId) {
        this.lstCustManagerId = lstCustManagerId;
    }

    public String getLstCustManagerName() {
        return lstCustManagerName;
    }

    public void setLstCustManagerName(String lstCustManagerName) {
        this.lstCustManagerName = lstCustManagerName;
    }

    public Date getLstLastOrderDate() {
        return lstLastOrderDate;
    }

    public void setLstLastOrderDate(Date lstLastOrderDate) {
        this.lstLastOrderDate = lstLastOrderDate;
    }

    public Date getLstLostDate() {
        return lstLostDate;
    }

    public void setLstLostDate(Date lstLostDate) {
        this.lstLostDate = lstLostDate;
    }

    public String getLstDelay() {
        return lstDelay;
    }

    public void setLstDelay(String lstDelay) {
        this.lstDelay = lstDelay;
    }

    public String getLstReason() {
        return lstReason;
    }

    public void setLstReason(String lstReason) {
        this.lstReason = lstReason;
    }

    public String getLstStatus() {
        return lstStatus;
    }

    public void setLstStatus(String lstStatus) {
        this.lstStatus = lstStatus;
    }
}