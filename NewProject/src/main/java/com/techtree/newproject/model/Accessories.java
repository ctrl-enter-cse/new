package com.techtree.newproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="accessories")
public class Accessories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="acc_id")
	private Long acc_id;
	
	@Column(name="item1")
	private String item1;
	
	@Column(name="item2")
	private String item2;
	
	@ManyToMany(mappedBy = "accessories",cascade =CascadeType.ALL)
//	@JoinTable(name="device_accsories")
	private List<Device> device ;

	public Long getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Long acc_id) {
		this.acc_id = acc_id;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public List<Device> getDevice() {
		return device;
	}

	public void setDevice(List<Device> device) {
		this.device = device;
	}
	
	
}
