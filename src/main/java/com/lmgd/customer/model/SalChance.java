package com.lmgd.customer.model;

import java.io.Serializable;
import java.sql.Date;

public class SalChance implements Serializable {
    private Long chcId;

    private String chcSource;

    private String chcCustName;

    private String chcTitle;

    private Integer chcRate;

    private String chcLinkman;

    private String chcTel;

    private String chcDesc;

    private Long chcCreateId;

    private String chcCreateBy;

    private java.sql.Date chcCreateDate;

    private Long chcDueId;

    private String chcDueTo;

    private java.sql.Timestamp chcDueDate;

    private Integer chcStatus;


    public SalChance(Long chcId, String chcSource, String chcCustName, String chcTitle, Integer chcRate, String chcLinkman, String chcTel, String chcDesc, Long chcCreateId, String chcCreateBy, java.sql.Date chcCreateDate, Long chcDueId, String chcDueTo, java.sql.Timestamp chcDueDate, Integer chcStatus) {
        this.chcId = chcId;
        this.chcSource = chcSource;
        this.chcCustName = chcCustName;
        this.chcTitle = chcTitle;
        this.chcRate = chcRate;
        this.chcLinkman = chcLinkman;
        this.chcTel = chcTel;
        this.chcDesc = chcDesc;
        this.chcCreateId = chcCreateId;
        this.chcCreateBy = chcCreateBy;
        this.chcCreateDate = chcCreateDate;
        this.chcDueId = chcDueId;
        this.chcDueTo = chcDueTo;
        this.chcDueDate = chcDueDate;
        this.chcStatus = chcStatus;
    }

    public SalChance() {
        super();
    }

    public Long getChcId() {
        return chcId;
    }

    public void setChcId(Long chcId) {
        this.chcId = chcId;
    }

    public String getChcSource() {
        return chcSource;
    }

    public void setChcSource(String chcSource) {
        this.chcSource = chcSource;
    }

    public String getChcCustName() {
        return chcCustName;
    }

    public void setChcCustName(String chcCustName) {
        this.chcCustName = chcCustName;
    }

    public String getChcTitle() {
        return chcTitle;
    }

    public void setChcTitle(String chcTitle) {
        this.chcTitle = chcTitle;
    }

    public Integer getChcRate() {
        return chcRate;
    }

    public void setChcRate(Integer chcRate) {
        this.chcRate = chcRate;
    }

    public String getChcLinkman() {
        return chcLinkman;
    }

    public void setChcLinkman(String chcLinkman) {
        this.chcLinkman = chcLinkman;
    }

    public String getChcTel() {
        return chcTel;
    }

    public void setChcTel(String chcTel) {
        this.chcTel = chcTel;
    }

    public String getChcDesc() {
        return chcDesc;
    }

    public void setChcDesc(String chcDesc) {
        this.chcDesc = chcDesc;
    }

    public Long getChcCreateId() {
        return chcCreateId;
    }

    public void setChcCreateId(Long chcCreateId) {
        this.chcCreateId = chcCreateId;
    }

    public String getChcCreateBy() {
        return chcCreateBy;
    }

    public void setChcCreateBy(String chcCreateBy) {
        this.chcCreateBy = chcCreateBy;
    }

    public java.sql.Date getChcCreateDate() {
        return chcCreateDate;
    }

    public void setChcCreateDate(java.sql.Date chcCreateDate) {
        this.chcCreateDate = chcCreateDate;
    }

    public Long getChcDueId() {
        return chcDueId;
    }

    public void setChcDueId(Long chcDueId) {
        this.chcDueId = chcDueId;
    }

    public String getChcDueTo() {
        return chcDueTo;
    }

    public void setChcDueTo(String chcDueTo) {
        this.chcDueTo = chcDueTo;
    }

    public java.sql.Timestamp getChcDueDate() {
        return chcDueDate;
    }

    public void setChcDueDate(java.sql.Timestamp chcDueDate) {
        this.chcDueDate = chcDueDate;
    }

    public Integer getChcStatus() {
        return chcStatus;
    }

    public void setChcStatus(Integer  chcStatus) {
        this.chcStatus = chcStatus;
    }


    //chcSource、chcCustName、chcRate、chcTitle、chcLinkman、chcTel、chcDesc、chcCreateId、chcCreateBy
    @Override
    public String toString() {
        return "SalChance{" +
                "chcId=" + chcId +
                ", chcSource='" + chcSource + '\'' +
                ", chcRate='" + chcRate + '\'' +
                ", chcCustName='" + chcCustName + '\'' +
                ", chcTitle='" + chcTitle + '\'' +
                ", chcLinkman='" + chcLinkman + '\'' +
                ", chcTel='" + chcTel + '\'' +
                ", chcDesc='" + chcDesc + '\'' +
                ", chcCreateId=" + chcCreateId +
                ", chcCreateBy='" + chcCreateBy + '\'' +
                '}';
    }
}