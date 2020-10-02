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
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == null) {
			return false;
		}
		
		if(obj.getClass()!=this.getClass()) {
			return false;
		}
		
		AddressBook book = (AddressBook) obj;
		if(this.name == book.getName()) {
			return true;
		}
		
		return false;
	}
	
}
