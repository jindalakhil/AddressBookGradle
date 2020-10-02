package com.capg.addressbook;

import com.capg.addressbook.dto.Contact;
import com.capg.addressbook.services.impl.ContactImpl;

public class AddressBookExecutor {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Address Book Program");
		ContactImpl contact = new ContactImpl();
		contact.addContact();
		contact.showContact();
	}
}

