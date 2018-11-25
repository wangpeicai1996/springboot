package com.pcwang.entity;

import javax.persistence.*;

@Entity
@Table(name="dept")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptno")
    private Integer deptno;
    @Column(name = "dname")
    private String dname;
    @Column(name = "dlocal")
    private String dlocal;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDlocal() {
        return dlocal;
    }

    public void setDlocal(String dlocal) {
        this.dlocal = dlocal;
    }
}
