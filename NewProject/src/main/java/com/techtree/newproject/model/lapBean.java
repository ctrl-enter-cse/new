package com.techtree.newproject.model;

public class lapBean {

	private long id;
	private String laptopName;
	
	private EmpBean emp;
	
	private DeviceBean device;
	
	public DeviceBean getDevice() {
		return device;
	}
	public void setDevice(DeviceBean device) {
		this.device = device;
	}
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
	public EmpBean getEmp() {
		return emp;
	}
	public void setEmp(EmpBean emp) {
		this.emp = emp;
	}
	
	
}
