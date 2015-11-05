package com.main;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.contacts.ContactsInitializer;
import com.view.HomePageLayout;

public class PhonebookGUI {
	public static final Logger logger = Logger.getLogger(PhonebookGUI.class);
	
	public static void main(String args[])	{
		DOMConfigurator.configure("log4j.xml");
		ContactsInitializer contactsinitializer = new ContactsInitializer();
		contactsinitializer.initProperty(null);
		contactsinitializer.initXmlHeader();
		contactsinitializer.initXmlBody();
		
		new HomePageLayout(contactsinitializer);
	}
}
