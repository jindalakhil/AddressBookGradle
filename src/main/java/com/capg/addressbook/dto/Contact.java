package com.capg.addressbook.dto;

import com.opencsv.bean.CsvBindByName;


public class Contact {
	@CsvBindByName
	private String fname;
	
	@CsvBindByName
	private String lname;
	
	@CsvBindByName
	private String address;
	
	@CsvBindByName
	private String city;
	
	@CsvBindByName
	private String state;
	
	@CsvBindByName
	private int zip;
	
	@CsvBindByName
	private String phoneNumber;
	
	@CsvBindByName
	private String email;
	
	public Contact() {
		
	}
	
	public Contact(String fname, String lname, String address, String city, String state, int zip, String phoneNumber,
			String email) {
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "fname " + fname + " lname " + lname + " address " + address + " city " + city + " state "
				+ state + " zip " + zip + " phoneNumber " + phoneNumber + " email "  + email;
	}
	
}
