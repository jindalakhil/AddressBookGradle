package com.capg.addressbook.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactValidator {
	private final String fname = "^[A-Z]{1}[a-z]{2,}$";
	private final String lname = "^[1-9]{1}[0-9]{9}$";
	private final String email = "^[a-z]+([-+-.]{0,1}[a-zA-z0-9]{1,})?@[a-z]{2,}\\.[a-z]{2,4}(\\.[a-z]{2})?$";
	private final String phoneNumer = "^[1-9]{1}[0-9]{9}$";
	private final String password = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%]).{8,16}$";
	
	private boolean validate(String string, String field) {
		boolean matched = false;
		Pattern pattern =Pattern.compile(field);
	    Matcher matcher = pattern.matcher(string);
	    matched = matcher.find();
	    return matched;
	}
	
	public boolean validateFirstName(String firstName) {
		return validate(firstName, fname);
	}
	
	public boolean validateLastName(String lastName) {
		return validate(lastName, lname);
	}
	
	public boolean validateaddress(String email) {
		return validate(email, this.email);
	}
	
	public boolean validatePhoneNumber(String phone) {
		return validate(phone, phoneNumer);
	}
	
	public boolean validatePassword(String password) {
		return validate(password, this.password);
	}
}
