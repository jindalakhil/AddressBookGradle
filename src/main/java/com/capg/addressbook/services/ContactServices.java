package com.capg.addressbook.services;

import com.capg.addressbook.exception.DataTypeException;

public interface ContactServices {
	
	public void addContact() throws DataTypeException;
	public void showContact();
}
