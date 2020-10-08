package com.capg.addressbook.services.impl;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.capg.addressbook.dto.AddressBook;
import com.capg.addressbook.dto.Contact;
import com.capg.addressbook.exception.DataTypeException;
import com.capg.addressbook.services.ContactServices;
import com.capg.addressbook.validator.*;

public class ContactImpl implements ContactServices {
	Scanner sc = new Scanner(System.in);
	ContactValidator valid = new ContactValidator();
	//AddressBook book = new AddressBook();
	@Override
	public void addContact(AddressBook book) throws DataTypeException {
		// TODO Auto-generated method stub
		Contact contact = new Contact();
		try {
			System.out.println("Enter the FirstName");
			String fname = sc.nextLine();
			boolean isValid = false;
			while(!isValid) {
				isValid = valid.validateFirstName(fname);
				if(existance(fname, book) || !isValid) {
					System.out.println("Fname Already exists or Invalid First Name");
					fname = sc.nextLine();
					isValid = valid.validateFirstName(fname);
				}
			}
				contact.setFname(fname);
			
			
			System.out.println("Enter the Last Name");
			String lname = sc.nextLine();
			isValid = valid.validateLastName(lname);
			while(!isValid) {
				System.out.println("Invalid Last Name, Last Name Should have first capital letter and minimum of length 3. Enter the value again ");
				lname = sc.nextLine();
				isValid = valid.validateLastName(lname);
			}
			contact.setLname(lname);
			
			System.out.println("Enter the Address");
			String address = sc.nextLine();
			contact.setAddress(address);
			
			System.out.println("Enter the City");
			String city = sc.nextLine();
			contact.setCity(city);
			
			System.out.println("Enter the State");
			String state = sc.nextLine();
			contact.setState(state);
			
			System.out.println("Enter the Zip code");
			int zip = sc.nextInt();
			isValid = valid.validateZip(zip);
			while(!isValid) {
				System.out.println("Invalid Zip Code");
				zip = sc.nextInt();
				isValid = valid.validateZip(zip);
			}
			sc.nextLine();
			contact.setZip(zip);
			
			System.out.println("Enter the PHONE NUMBER");
			//sc.nextLine();
			String phone = sc.nextLine();
			isValid = valid.validatePhoneNumber(phone);
			while(!isValid) {
				System.out.println("Invalid phone number ");
				phone = sc.nextLine();
				isValid = valid.validatePhoneNumber(phone);
			}
			contact.setPhoneNumber(phone);
			
			System.out.println("Enter the Email");
			String email = sc.nextLine();
			isValid = valid.validateEmail(email);
			while(!isValid) {
				System.out.println("Invalid email ");
				email = sc.nextLine();
				isValid = valid.validateEmail(email);
			}
			contact.setEmail(email);
			List<Contact> list = book.getList();
			//list.stream().forEach(n -> System.out.println(n.toString()));
			list.add(contact);
		//	list.stream().forEach(n -> System.out.println(n.toString()));
			book.setList(list);
		} catch(Exception e) {
			throw new DataTypeException("Enter the valid datatype");
		}
	}
	@Override
	public void showContact(AddressBook book) {
		// TODO Auto-generated method stub
		//System.out.println(contact);
		book.getList().stream().forEach(n -> System.out.println(n.toString()));
	}
	
	public List<Contact> showContactSortedByName(AddressBook book) {
		// TODO Auto-generated method stub
		return book.getList().stream().sorted((n1, n2) -> n1.getFname().compareTo(n2.getFname())).collect(Collectors.toList());
	}
	
	public List<Contact> showContactSortedByState(AddressBook book) {
		// TODO Auto-generated method stub
		return book.getList().stream().sorted((n1, n2) -> n1.getState().compareTo(n2.getState())).collect(Collectors.toList());
	}
	
	public List<Contact> showContactSortedByCity(AddressBook book) {
		// TODO Auto-generated method stub
		return book.getList().stream().sorted((n1, n2) -> n1.getCity().compareTo(n2.getCity())).collect(Collectors.toList());
	}
	
	public List<Contact> showContactSortedByZip(AddressBook book) {
		// TODO Auto-generated method stub
		return book.getList().stream().sorted((n1, n2) -> ((Integer)n1.getZip()).compareTo((Integer)n2.getZip())).collect(Collectors.toList());
	}
//	@Override
//	public Contact getContact() {
//		return contact;
//	}
	
	@Override
	public void editContact(String fname, AddressBook book) {
		 for(Contact x: book.getList()) {
			 if(x.getFname().equalsIgnoreCase(fname)) {
			 int i =1;
			 while(i!=0) {
				 System.out.println("Enter 1 to update th last name");
				 System.out.println("Enter 2 to update the address");
				 System.out.println("Enter 3 to update the city");
				 System.out.println("Enter 4 to update the state");
				 System.out.println("Enter 5 to update the zipcode");
				 System.out.println("Enter 6 to update the phone number");
				 System.out.println("Enter 7 to update the email");
				 System.out.println("Enter 0 to exit");
				 i = sc.nextInt();
				 sc.nextLine();
				 switch(i) {
				 case 1:
					 System.out.println("Enter the new last name");
					 x.setLname(sc.nextLine());
					 System.out.println("last name updated");
					 break;
				 case 2:
					 System.out.println("Enter the new address");
					 x.setAddress(sc.nextLine());
					 System.out.println("address updated");
					 break;
				 case 3:
					 System.out.println("Enter the new city");
					 x.setCity(sc.nextLine());
					 System.out.println("city updated");
					 break;
				 case 4:
					 System.out.println("Enter the new state");
					 x.setState(sc.nextLine()); 
					 System.out.println("state updated");
					 break;
				 case 5:
					 System.out.println("Enter the new zipcode");
					 x.setZip( sc.nextInt()); 
					 System.out.println("zipcode updated");
					 break;
				 case 6:
					 System.out.println("Enter the new phonenumber");
					 x.setPhoneNumber(sc.nextLine()); 
					 System.out.println("phonenumber updated");
					 break;
				 case 7:
					 System.out.println("Enter the new email");
					 x.setEmail(sc.nextLine());
					 System.out.println("email updated");
					 break;
				 case 0:
					 System.out.println("Exiting the updation process");
					 break;
				 default:
					 System.out.println("Invalid Entry! Enter a new one");
				 }	 
			 }
			 }
			 }
		 showContact(book);
	}
	
	@Override
	public void deleteContact(String firstName, AddressBook book) {
		for(Contact x : book.getList()) {
			if(x.getFname().equalsIgnoreCase(firstName)) {
				List<Contact> list = book.getList();
				list.remove(x);
				System.out.println("Contact deleted");
				return;
			}
		}
		System.out.println("Contact not found");
	}
	
	public boolean existance(String fname, AddressBook book) {
		return book.getList().stream().anyMatch(n -> n.getFname().equalsIgnoreCase(fname));
	}

}
