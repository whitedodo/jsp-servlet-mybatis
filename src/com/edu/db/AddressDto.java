package com.edu.db;

import java.sql.Timestamp;

public class AddressDto {
	
	private int num;
	private String name;
	private String address;
	private Timestamp birthdate;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Timestamp getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Timestamp birthdate) {
		this.birthdate = birthdate;
	}
	
}
