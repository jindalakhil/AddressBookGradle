import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.capg.addressbook.*;
import com.capg.addressbook.dto.*;
import com.capg.addressbook.exception.*;
import com.capg.addressbook.services.*;
import com.capg.addressbook.services.impl.*;
import com.capg.addressbook.validator.*;
import com.capg.io.*;

public class BookIOServiceTest {
	@Test
	public void writeContactsToFile() {
		BookIOService addressBookFileIOService = new BookIOService();
		List<Contact> contactList = new ArrayList<>();
		Contact contact1 = new Contact("Akhil", "Jindal", "Address", "city", "state", 123, "9988998899", "abc@abc.com");
		Contact contact2 = new Contact("Akhil1", "Jindal", "Address2", "city2", "state2", 123, "9988998999", "abc@abc.com");
		Contact contact3 = new Contact("Akhil2", "Jindal", "Address3", "city3", "state3", 123, "9988998899", "abc@abc.com");
		contactList.add(contact1);
		contactList.add(contact2);
		contactList.add(contact3);
		addressBookFileIOService.writeData(contactList);
		addressBookFileIOService.readData();
		Assert.assertEquals(3, addressBookFileIOService.countEntries());
	}
}