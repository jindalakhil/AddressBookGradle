package com.capg.addressbook;

import com.capg.addressbook.dto.Contact;

public class AddressBookExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Address Book Program");
		Contact c = new Contact("first","last","address","city","state",123,"9878989898","as@aad.com");
		System.out.println(c);
	}
}

