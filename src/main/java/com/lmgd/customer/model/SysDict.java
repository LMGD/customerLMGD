package com.lmgd.customer.model;

import java.io.Serializable;

public class SysDict implements Serializable {
    private Long dictId;

    private String dictName;

    private String text;

    private Integer value;

    private Long position;

    private String remark;

    public SysDict(Long dictId, String dictName, String text, Integer value, Long position, String remark) {
        this.dictId = dictId;
        this.dictName = dictName;
        this.text = text;
        this.value = value;
        this.position = position;
        this.remark = remark;
    }

    public SysDict() {
        super();
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}