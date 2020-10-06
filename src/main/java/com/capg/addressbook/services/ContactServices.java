package com.capg.addressbook.services;

import com.capg.addressbook.exception.DataTypeException;
import com.capg.addressbook.dto.AddressBook;
import com.capg.addressbook.dto.Contact;

public interface ContactServices {
	
	public void addContact(AddressBook book) throws DataTypeException;
	public void showContact(AddressBook book);
	//public Contact getContact();
	public void editContact(String fname, AddressBook book);
	public void deleteContact(String firstName, AddressBook book);
}
