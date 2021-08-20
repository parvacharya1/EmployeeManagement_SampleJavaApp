package com.employee.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@Column(name = "departmentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;
	private String shortName;
	private String departmentName;

	public Department() {

	}

	public Department(int departmentId, String shortName, String departmentName) {
		this.departmentId = departmentId;
		this.shortName = shortName;
		this.departmentName = departmentName;
	}

	public Department(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
