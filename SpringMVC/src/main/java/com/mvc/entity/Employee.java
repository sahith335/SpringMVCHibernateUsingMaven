package com.mvc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="Employee111")
public class Employee {

	@Id
	@Column(name="empid")
	private int empid;
	
	@Column(name="empName")
	private String empName;
	
	@Column(name="empDesg")
	private String empDesg;
	
	@Column(name="empSalary")
	private int empSalary;

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesg() {
		return empDesg;
	}

	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public Employee() {
		super();
	}

	@Autowired
	public Employee(@Value("1") int empid,@Value("Sai") String empName,@Value("HR") String empDesg,@Value("25000") int empSalary) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empDesg = empDesg;
		this.empSalary = empSalary;
	}

	public Employee(String empName, String empDesg, int empSalary) {
		super();
		this.empName = empName;
		this.empDesg = empDesg;
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return empid + " " + empName + " " + empDesg + " " + empSalary;
	}
	
	
}
