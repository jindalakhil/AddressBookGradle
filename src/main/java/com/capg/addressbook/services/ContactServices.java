package com.capg.addressbook.services;

import com.capg.addressbook.exception.DataTypeException;
import com.capg.addressbook.dto.Contact;

public interface ContactServices {
	
	public void addContact() throws DataTypeException;
	public void showContact();
	public Contact getContact();
}
