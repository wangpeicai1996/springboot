package com.pcwang.entity;

public class Role {

    private Integer roleID;
    private String rname;
    private Integer isUse;

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleID=" + roleID +
                ", rname='" + rname + '\'' +
                ", isUse=" + isUse +
                '}';
    }
}
