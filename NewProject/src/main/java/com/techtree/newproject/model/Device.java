package com.techtree.newproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="device")
public class Device {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="div_id")
	private long div_id;
	
	@Column(name="acces")
	@ManyToMany(cascade = CascadeType.ALL )
	@JoinTable(name="device_accsories" ,
		joinColumns = {@JoinColumn(name="div_id")},inverseJoinColumns = {@JoinColumn(name= "acc_id")}
			)
	private List<Accessories>  accessories;

	
	public List<Accessories> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<Accessories> accessories) {
		this.accessories = accessories;
	}

	@OneToOne
	@JoinColumn(name="lap_id")
	private laptop lap;

	

	public long getDiv_id() {
		return div_id;
	}

	public void setDiv_id(long div_id) {
		this.div_id = div_id;
	}

	public laptop getLap() {
		return lap;
	}

	public void setLap(laptop lap) {
		this.lap = lap;
	}
	

}
