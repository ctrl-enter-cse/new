package com.techtree.newproject.model;

import java.util.List;

public class AccesoriesBean {

	private Long acc_id;
	private String item1;
	private String item2;
	private List<DeviceBean> device ;
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
	public List<DeviceBean> getDevice() {
		return device;
	}
	public void setDevice(List<DeviceBean> device) {
		this.device = device;
	}
	
	
}
