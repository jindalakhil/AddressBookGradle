package com.capg.addressbook;

import java.util.Scanner;

import com.capg.addressbook.dto.AddressBook;
import com.capg.addressbook.dto.Contact;
import com.capg.addressbook.services.impl.ContactImpl;

public class AddressBookExecutor {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Address Book Program");
		ContactImpl contact = new ContactImpl();
		//contact.addContact();
		AddressBook book = new AddressBook();
		//book.addContact(contact.getContact());
		//book.getList().stream().forEach(System.out :: println);
		
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
				contact.addContact();
				contact.showContact();
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
}

