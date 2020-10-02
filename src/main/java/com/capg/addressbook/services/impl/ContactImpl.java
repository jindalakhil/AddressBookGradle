package com.capg.addressbook.services.impl;

import java.util.List;
import java.util.Scanner;

import com.capg.addressbook.dto.AddressBook;
import com.capg.addressbook.dto.Contact;
import com.capg.addressbook.exception.DataTypeException;
import com.capg.addressbook.services.ContactServices;
import com.capg.addressbook.validator.*;

public class ContactImpl implements ContactServices {
	Scanner sc = new Scanner(System.in);
	ContactValidator valid = new ContactValidator();
	Contact contact = new Contact();
	AddressBook book = new AddressBook();
	@Override
	public void addContact() throws DataTypeException {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter the FirstName");
			String fname = sc.nextLine();
			boolean isValid = valid.validateFirstName(fname);
			while(!isValid) {
				System.out.println("Invalid First Name, First Name Should have first capital letter and minimum of length 3. Enter the value again ");
				fname = sc.nextLine();
				isValid = valid.validateFirstName(fname);
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
				lname = sc.nextLine();
				isValid = valid.validatePhoneNumber(phone);
			}
			contact.setPhoneNumber(phone);
			
			System.out.println("Enter the Email");
			String email = sc.nextLine();
			isValid = valid.validateEmail(email);
			while(!isValid) {
				System.out.println("Invalid email ");
				lname = sc.nextLine();
				isValid = valid.validateEmail(email);
			}
			contact.setEmail(email);
			List<Contact> list = book.getList();
			list.add(contact);
			book.setList(list);
		} catch(Exception e) {
			throw new DataTypeException("Enter the valid datatype");
		}
	}
	@Override
	public void showContact() {
		// TODO Auto-generated method stub
		System.out.println(contact);
	}
	
	@Override
	public Contact getContact() {
		return contact;
	}
	
	@Override
	public void editContact(String fname) {
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
		 showContact();
	}

}
