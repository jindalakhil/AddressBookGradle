package com.capg.addressbook.services.impl;

import com.capg.addressbook.dto.*;
import java.util.*;
import java.util.stream.Stream;

import com.capg.addressbook.services.AddressBookServices;

public class AddressBookImpl implements AddressBookServices {
	
	AddressBookLibrary lib = new AddressBookLibrary();
	Scanner sc = new Scanner(System.in);
	ContactImpl contact = new ContactImpl();
	
	@Override
	public void createAddressBook(String name) {
		// TODO Auto-generated method stub
		if(checkExistance(name)) {
			System.out.println("AddressBook with this name already esists");
			return;
		}
		AddressBook book = new AddressBook(name);
		Map<String, AddressBook> map = lib.getHm();
		lib.addAddressBook(name, book);
		System.out.println("If you want to add contacts to " + name + " press y");
		if("y".equals(sc.nextLine())) {
			editAddressBook(name);
		}
		
	}

	@Override
	public void editAddressBook(String name) {
		// TODO Auto-generated method stub
		if(!checkExistance(name)) {
			System.out.println("AddressBook with this name don't esists");
			return;
		}
		AddressBook book = lib.getHm().get(name);
		System.out.println("You are currently in: " + book.getName());
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while (i != 0) {
			System.out.println("Enter 1 to add a contact");
			System.out.println("Enter 2 to edit the contact");
			System.out.println("Enter 3 to delete the contact");
			System.out.println("Enter 0 to exit");
			i = sc.nextInt();
			sc.nextLine();
			switch (i) {
			case 1:
				try {
					contact.addContact();
					contact.showContact();
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
		
			case 2:
				System.out.println("Update Contact:");
				System.out.println("Enter first name: ");
				String firstName = sc.nextLine();
				contact.editContact(firstName);
				break;
			case 3:
				System.out.println("Enter first name to delete: ");
				String fname = sc.nextLine();
				contact.deleteContact(fname);
			case 0:
				System.out.println("Exiting the process");
				break;
			default:
				System.out.println("Enter valid entry");
			}
		}

	}

	@Override
	public void deleteAddressBook(String name) {
		// TODO Auto-generated method stub
		if(checkExistance(name)) {
			lib.removeAddressBook(name);
			System.out.println("AddressBook with name " + name + " deleted.");
			return;
		}
		System.out.println("AddressBook with this name not esists");
		
	}

	@Override
	public boolean checkExistance(String name) {
		// TODO Auto-generated method stub
		boolean check = lib.getHm().entrySet().stream().anyMatch( (e) -> {
			if(e.getValue().equals(lib.getHm().get(name))) {
				return true;
				} 
			return false; 
			});
		//System.out.println(check);
		
		return check;
	
}
	
}
