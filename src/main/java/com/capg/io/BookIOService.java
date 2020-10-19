package com.capg.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.*;

import com.capg.addressbook.dto.*;
import com.capg.addressbook.exception.*;
import com.capg.addressbook.services.*;
import com.capg.addressbook.services.impl.*;
import com.capg.addressbook.validator.*;


public class BookIOService {

	private static final String SAMPLE_CSV_FILE_PATH = "addressBookfile.csv";
	private static final String CONTACT_FILE_NAME_GSON = "book.json";
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
		
		public List<Contact> readCSVData() {
			List<Contact> contactsList = new ArrayList<>();
			try {
				Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
				CsvToBean<Contact> csvToBean = new CsvToBeanBuilder<Contact>(reader).withType(Contact.class)
						.withIgnoreLeadingWhiteSpace(true).build();

				contactsList = csvToBean.parse();
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			return contactsList;
		}

		public boolean writeCSVData(List<Contact> contactList) {
			try (Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH))){
				StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder<Contact>(writer)
						.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

				beanToCsv.write(contactList);
			} catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		public boolean writeJsonData(List<Contact> contactList) {
			Gson gson = new Gson();
			String json = gson.toJson(contactList);
			try {
				FileWriter fileWriter = new FileWriter(CONTACT_FILE_NAME_GSON);
				fileWriter.write(json);
				fileWriter.close();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		public boolean readJsonFile(){
			try {
				Reader reader = Files.newBufferedReader(Paths.get(CONTACT_FILE_NAME_GSON));
				JsonParser jsonParser = new JsonParser();
				JsonElement obj = jsonParser.parse(reader);
				JsonArray contactList = (JsonArray) obj;
				System.out.println(contactList);

				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}

}
