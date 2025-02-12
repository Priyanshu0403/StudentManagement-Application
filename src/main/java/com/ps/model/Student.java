package com.ps.model;

public class Student {
	private String name;
	private String email;
	private String phone;
	
	
	
	//we cann use constructor instead of setter method but getter method is compulsory
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone=phone;
	}

	
}
