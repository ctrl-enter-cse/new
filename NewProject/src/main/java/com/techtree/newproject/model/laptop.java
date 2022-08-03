package com.techtree.newproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="laptopNew")
public class laptop {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lid")
	private long id;

	@Column(name="lname")
	private String laptopName;

	@ManyToOne
	@JoinColumn(name="emp_id", nullable=false)
	private Employee emp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
