package com.techtree.newproject.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employeeNew")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name", nullable=false)
	private String fname;
	@Column(name="last_name", nullable=false)
	private String lname;
	@Column(name="email", nullable=false)
	private String email;

	@OneToMany(mappedBy="emp")
	private List<laptop> laptop;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<laptop> laptop) {
		this.laptop = laptop;
	}



}
