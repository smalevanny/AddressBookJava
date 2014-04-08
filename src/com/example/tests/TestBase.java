package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;
//import static com.example.tests.GroupDataGenerator.generateRandomGroups;
//import static com.example.tests.ContactDataGenerator.generateRandomContacts;


public class TestBase {
	
	protected static ApplicationManager app;
	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = new ApplicationManager(properties);    
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();	    
	  }
	
	/*	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupDataForDataProvider(generateRandomGroups(5)).iterator();
	}
	
	

	public List<Object[]> wrapGroupDataForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	protected static List<Object[]> wrapContactDataForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator () {
		return wrapContactDataForDataProvider(generateRandomContacts(5)).iterator();
	}

	private List<ContactData> generateRandomContacts(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	*/
}
