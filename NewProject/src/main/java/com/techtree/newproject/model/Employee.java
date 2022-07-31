package com.techtree.newproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_Details")
public class Employee {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		@Column(name="first_name", nullable=false)
		private String fname=null;
		@Column(name="last_name", nullable=false)
		private String lname=null;
		@Column(name="email", nullable=false)
		private String email=null;
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
		
		
		
}
