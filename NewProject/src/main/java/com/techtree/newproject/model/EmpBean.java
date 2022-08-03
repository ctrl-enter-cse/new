package com.techtree.newproject.model;

public class EmpBean {

	private long Id;
	private String Fname;
	private String Lname;
	private String Email;
	private laptop Laptop;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public laptop getLaptop() {
		return Laptop;
	}
	public void setLaptop(laptop laptop) {
		Laptop = laptop;
	}
	
}
