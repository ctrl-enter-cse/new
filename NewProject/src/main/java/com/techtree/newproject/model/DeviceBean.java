package com.techtree.newproject.model;

import java.util.List;

public class DeviceBean {

	private long id;
	
	private List<AccesoriesBean>  accessories;
	
	private laptop lap;

	public laptop getLap() {
		return lap;
	}

	public void setLap(laptop lap) {
		this.lap = lap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<AccesoriesBean> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<AccesoriesBean> accessories) {
		this.accessories = accessories;
	}

	
	
	
}
