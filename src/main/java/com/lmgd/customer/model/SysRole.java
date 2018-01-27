package com.lmgd.customer.model;

import java.io.Serializable;

public class SysRole implements Serializable {
    private Long roleId;

    private String roleName;

    private String roleDesc;

    private Integer roleFlag;

    public SysRole(Long roleId, String roleName, String roleDesc, Integer roleFlag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.roleFlag = roleFlag;
    }

    public SysRole() {
        super();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(Integer roleFlag) {
        this.roleFlag = roleFlag;
    }
}