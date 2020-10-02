package com.capg.addressbook.services;

public interface AddressBookServices {
	public void createAddressBook(String name);
	public void editAddressBook(String name);
	public void deleteAddressBook(String name);
	public boolean checkExistance(String name);
}
