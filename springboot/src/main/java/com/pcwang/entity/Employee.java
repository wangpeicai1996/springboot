package com.pcwang.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {

	
	@Id//主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)//设置主键自增
	//oracle没有主键自增，使用@SequenceGenerator生成主键序列值
	@Column(name = "empno")	//字段名
	private Integer empno;
	
	@Column(name="ename")
	private String ename;
	
	@Column(name="sal")
	private String sal;
	
	@Column(name="hiredate")
	private Date hiredate;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	
}
