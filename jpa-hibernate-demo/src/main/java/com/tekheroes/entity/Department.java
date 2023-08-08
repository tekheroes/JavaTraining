package com.tekheroes.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "depts")
public class Department {
	@Id
	@Column(name = "dept_no")
	private int deptNo;
	@Column(name = "dname", length = 12)
	private String deptName;
	
	@OneToMany(mappedBy = "dept", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Employee> emps;
	
	// Constructors
	public Department() {
	}

	public Department(int deptNo, String deptName) {
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	// Getters and Setters
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + "]";
	}
}
