package com.axelor.demo.hibernatedemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.*;

@Entity

@Table
public class Meeting {
	@Id
	private int id;
	private String name;
	@ManyToMany
	private List<Employee> employeeList=new ArrayList<Employee>();
	
	
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
}
