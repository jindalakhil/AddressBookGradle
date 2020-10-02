package com.capg.addressbook.dto;

import java.util.*;

public class AddressBook {
	private String name;
	private List<Contact> list = new ArrayList<>();
	
	public AddressBook() {
	}
	public AddressBook(String name) {
		this.name = name;
	}
	
	public void addContact(Contact contact) {
		list.add(contact);
	}

	public List<Contact> getList() {
		return list;
	}

	public void setList(List<Contact> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
