package com.capg.addressbook.services.impl;

import com.capg.addressbook.dto.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



import com.capg.addressbook.services.AddressBookServices;

public class AddressBookImpl implements AddressBookServices {
	
	AddressBookLibrary lib = new AddressBookLibrary();
	Scanner sc = new Scanner(System.in);
	ContactImpl contact = new ContactImpl();
	Map<String,ArrayList<String>> city = new HashMap<>();
	Map<String,ArrayList<String>> state = new HashMap<>();
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
					contact.addContact(book);
					contact.showContact(book);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				break;
		
			case 2:
				System.out.println("Update Contact:");
				System.out.println("Enter first name: ");
				String firstName = sc.nextLine();
				contact.editContact(firstName, book);
				break;
			case 3:
				System.out.println("Enter first name to delete: ");
				String fname = sc.nextLine();
				contact.deleteContact(fname, book);
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
	
	public void searchPeople(String city, String state) {
//		System.out.println("Entered into searchPeople");
//		for(Map.Entry<String, AddressBook> entry : lib.getHm().entrySet()) {
//			for(Contact contact : entry.getValue().getList()) {
//				System.out.println(contact);
//			}
//		}
//		lib.getHm().entrySet().stream().forEach(e -> {
//			e.getValue().getList().stream().forEach(x -> System.out.println(x.toString()));
//		});
//		lib.getHm().entrySet().stream().forEach(e -> {
//			e.getValue().getList().stream().forEach(x -> {
//				if(x.getCity().equalsIgnoreCase(city) || x.getState().equalsIgnoreCase(state)) {
//					System.out.println(x.getFname() + " " + x.getLname());
//				}
//			});
//		});
		
		lib.getHm().entrySet().stream().forEach(e -> 
			e.getValue().getList().stream().filter(x -> {
				if(x.getCity().equalsIgnoreCase(city) || x.getState().equalsIgnoreCase(state)) {
					return true;
				}
				return false;
			}).forEach(x -> System.out.println(x.getFname() + " " + x.getLname()))
			);
		
//		lib.getHm().entrySet().stream().map(e -> 
//		e.getValue().getList().stream().filter(x -> {
//			if(x.getCity().equalsIgnoreCase(city)) {
//				return true;
//			}
//			return false;
//		})).forEach(x -> System.out.println(x.anyMatch(n -> n.getCity().equalsIgnoreCase(city))));
	}
	
	public void searchPeopleWithDictionary(String city, String state) {
		Map<String,ArrayList<String>> c = new HashMap<>();
		Map<String,ArrayList<String>> s = new HashMap<>();
		
										
		
//		lib.getHm().entrySet().stream().forEach(e -> {
//			e.getValue().getList().stream().forEach(x -> {
//				if(c.containsKey(x.getCity()))  {
//					ArrayList<String> list = c.get(x.getCity());
//					list.add(x.getFname() + " "+ x.getLname());
//					c.replace(x.getCity(),list );
//				} else if (!c.containsKey(x.getCity())) {
//					ArrayList<String> list = new ArrayList<>();
//					list.add(x.getFname() + " "+ x.getLname());
//					c.put(x.getCity(), list );
//				} else if (s.containsKey(x.getState())) {
//					ArrayList<String> list = c.get(x.getState());
//					list.add(x.getFname() + " "+ x.getLname());
//					c.replace(x.getState(),list );
//				} else if (!s.containsKey(x.getState())) {
//					ArrayList<String> list =new ArrayList<>();
//					list.add(x.getFname() + " "+ x.getLname());
//					c.put(x.getState(),list );
//				}
//			});
//		});
			lib.getHm().entrySet().stream()
								  .map(x -> x.getValue().getList())
								  .forEach(x -> x.stream().forEach(n -> {
									  if(c.containsKey(n.getCity())) {
										  ArrayList<String> list = c.get(n.getCity());
											list.add(n.getFname() + " "+ n.getLname());
											c.replace(n.getCity(),list );
									  } else if (!c.containsKey(n.getCity())) {
										  ArrayList<String> list = new ArrayList<>();
											list.add(n.getFname() + " "+ n.getLname());
											c.put(n.getCity(), list );
									  }
									  if (s.containsKey(n.getState())) {
											ArrayList<String> list = s.get(n.getState());
											list.add(n.getFname() + " "+ n.getLname());
											s.replace(n.getState(),list );
										} else if (!s.containsKey(n.getState())) {
											ArrayList<String> list =new ArrayList<>();
											list.add(n.getFname() + " "+ n.getLname());
											s.put(n.getState(),list );
										}
								  }));
								  
								  
								 
//							
//								  
//			
//		
//		c.entrySet().stream().forEach(x -> {
//			x.getValue().stream().forEach(n -> System.out.println(n));
//		});
			c.entrySet().stream().filter(n -> {
				if(n.getKey().equalsIgnoreCase(city)) {
					return true;
				}
				return false;
			}).forEach(n -> System.out.println("City: "+n));
		
		s.entrySet().stream().filter(n -> {
			if(n.getKey().equalsIgnoreCase(state)) {
				return true;
			}
			return false;
		}).forEach(n -> System.out.println("state: "+n));
	}
	

}
