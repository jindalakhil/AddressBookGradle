package com.capg.addressbook.services.impl;

import java.util.Scanner;

import com.capg.addressbook.dto.Contact;
import com.capg.addressbook.exception.DataTypeException;
import com.capg.addressbook.services.ContactServices;
import com.capg.addressbook.validator.*;

public class ContactImpl implements ContactServices {
	Scanner sc = new Scanner(System.in);
	ContactValidator valid = new ContactValidator();
	Contact contact = new Contact();
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
		} catch(Exception e) {
			throw new DataTypeException("Enter the valid datatype");
		}
	}
	@Override
	public void showContact() {
		// TODO Auto-generated method stub
		System.out.println(contact);
	}

}
