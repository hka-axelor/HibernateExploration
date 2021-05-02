package com.axelor.demo.hibernatedemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.*;

@Entity

@Table
public class Employee {
	@Id
	private int id;
	private String name;

	/*
	 * Adding OneToOne Relationship with Company
	 * 
	 * @OneToOne private Company company;
	 */

	/*
	 * public Company getCompany() { return company; } public void
	 * setCompany(Company company) { this.company = company; }
	 */

	/*
	 * Adding OneToMany Relationship with Phone
	 * 
	 * @OneToMany private List<Phone> phone=new ArrayList<Phone>();
	 * 
	 * 
	 * public List<Phone> getPhone() { return phone; } public void
	 * setPhone(List<Phone> phone) { this.phone = phone; }
	 */

	@ManyToMany
	private List<Meeting> meetingList = new ArrayList<Meeting>();

	public List<Meeting> getMeetingList() {
		return meetingList;
	}

	public void setMeetingList(List<Meeting> meetingList) {
		this.meetingList = meetingList;
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
