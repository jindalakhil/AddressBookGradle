package com.capg.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.capg.addressbook.dto.*;
import com.capg.addressbook.exception.*;
import com.capg.addressbook.services.*;
import com.capg.addressbook.services.impl.*;
import com.capg.addressbook.validator.*;


public class BookIOService {

	public static String CONTACT_FILE_NAME= "addressBook.txt";

	public void readData() {
		try {
			Files.lines(new File(CONTACT_FILE_NAME).toPath()).map(line -> line.trim()).forEach(line -> {
				String[] words = line.split("[\\s,:]+");
				for(String word:words) {
					System.out.print(word+ " ");
				}
				System.out.println();
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(CONTACT_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
	public void writeData(List<Contact> contactList) {
		StringBuffer empBuffer = new StringBuffer();
		contactList.forEach(contact -> {
			String employeeDataString = contact.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(CONTACT_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
