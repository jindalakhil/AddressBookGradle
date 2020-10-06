package com.capg.addressbook;

import java.util.Scanner;
import java.io.*;
import java.util.*;

import com.capg.addressbook.dto.AddressBook;
import com.capg.addressbook.dto.AddressBookLibrary;
import com.capg.addressbook.dto.Contact;
import com.capg.addressbook.services.impl.AddressBookImpl;

public class AddressBookExecutor {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Address Book Program");
		AddressBookImpl ex = new AddressBookImpl();
		AddressBookLibrary lib = new AddressBookLibrary();
		
		Scanner sc = new Scanner(System.in);
		int i =1;
		while(i!=0) {
			System.out.println("Enter 1 to create new address book");
			System.out.println("Enter 2 to edit existing address book");
			System.out.println("Enter 3 to delete addressbook");
			System.out.println("Enter 4 to search by city or state");
			System.out.println("Enter 0 to exit");
			String name = null;
			i = sc.nextInt();
			sc.nextLine();
			switch(i) {
			case 1:
				System.out.println("Enter the name for address book you want to create");
				name = sc.nextLine();
				ex.createAddressBook(name);
				break;
			case 2:
				System.out.println("Enter the name for address book you want to edit");
				Set set = lib.getHm().entrySet();
			    Iterator it = set.iterator();
			 
			    // Display elements
			    while(it.hasNext()) {
			      Map.Entry me = (Map.Entry)it.next();
			      System.out.print("AddressBook is: "+me.getKey() );
			    } 
				name = sc.nextLine();
				ex.editAddressBook(name);
				break;
			case 3:
				System.out.println("Enter the name for address book you want to delete");
				name = sc.nextLine();
				ex.deleteAddressBook(name);
				break;
			case 4:
				System.out.println("Enter the city");
				String city = sc.nextLine();
				System.out.println("Enter the state");
				String state = sc.nextLine();
				ex.personCount(city, state);
				break;
			case 0:
				System.out.println("Exiting the process");
				break;
			default:
				System.out.println("Enter valid entry");
			}
		}

	}
}

