package com.lmgd.customer.model;

import java.io.Serializable;

public class SysUser implements Serializable {
    private Long usrId;

    private String usrName;

    private String usrPassword;

    private Long usrRoleId;

    private Integer usrFlag;

    public SysUser(Long usrId, String usrName, String usrPassword, Long usrRoleId, Integer usrFlag) {
        this.usrId = usrId;
        this.usrName = usrName;
        this.usrPassword = usrPassword;
        this.usrRoleId = usrRoleId;
        this.usrFlag = usrFlag;
    }

    public SysUser() {
        super();
    }

    public Long getUsrId() {
        return usrId;
    }

    public void setUsrId(Long usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public Long getUsrRoleId() {
        return usrRoleId;
    }

    public void setUsrRoleId(Long usrRoleId) {
        this.usrRoleId = usrRoleId;
    }

    public Integer getUsrFlag() {
        return usrFlag;
    }

    public void setUsrFlag(Integer usrFlag) {
        this.usrFlag = usrFlag;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "usrId=" + usrId +
                ", usrName='" + usrName + '\'' +
                ", usrPassword='" + usrPassword + '\'' +
                ", usrRoleId=" + usrRoleId +
                '}';
    }
}