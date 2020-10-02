package com.capg.addressbook.dto;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBookLibrary {
	private HashMap<String, AddressBook> hm = new HashMap<>();

	public HashMap<String, AddressBook> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, AddressBook> hm) {
		this.hm = hm;
	}
	
	public void addAddressBook(String name, AddressBook book) {
		hm.put(name, book);
	}
	
	public void removeAddressBook(String name) {
		hm.remove(name);
	}
	
}
