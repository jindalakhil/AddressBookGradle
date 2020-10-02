package com.capg.addressbook.dto;

import java.util.*;

public class AddressBook {
	private List<Contact> list = new ArrayList<>();
	
	public void addContact(Contact contact) {
		list.add(contact);
	}

	public List<Contact> getList() {
		return list;
	}

	public void setList(List<Contact> list) {
		this.list = list;
	}

}
