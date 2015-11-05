package com.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import com.constants.ApplicationConstants;
import com.contacts.ContactsInitializer;
import com.view.HomePageLayout;
import com.writer.DbWriter;
import com.writer.IContactsWriter;
import com.writer.CsvWriter;
import com.writer.ExcelWriter;
import com.writer.PDFWriter;
import com.writer.TextWriter;

public class VcfConverterListener implements ActionListener{
	private JLabel action_status;
	
	private ContactsInitializer contactsinitializer;
	private IContactsWriter writer = null;
	
	public VcfConverterListener(ContactsInitializer contactsinitializer, HomePageLayout frontend)	{
		this.contactsinitializer=contactsinitializer;
		action_status = frontend.getAction_status(); 
	}
	
	public void actionPerformed(ActionEvent event) {
		
		String action_cmd = event.getActionCommand();
		
		if(action_cmd.equals("Create TextFile"))  {
			writer = new TextWriter();
			action_status.setText(ApplicationConstants.TEXT_CREATED);
		}
	    else if(action_cmd.equals("Create CSVFile"))	{
	    	writer = new CsvWriter();
	    	action_status.setText(ApplicationConstants.CSV_CREATED);
	    }
	    else if(action_cmd.equals("Create ExcelFile"))	{
	    	writer = new ExcelWriter();
	    	action_status.setText(ApplicationConstants.EXCEL_CREATED); 
	    }
	    else if(action_cmd.equals("Create PDFFile"))	{
	    	writer = new PDFWriter();
	    	action_status.setText(ApplicationConstants.PDF_CREATED); 
	    }
	    else if(action_cmd.equals("Create Database"))	{
	    	writer = new DbWriter();
	    	action_status.setText(ApplicationConstants.DB_CREATED); 
	    }
		writer.writeContacts(contactsinitializer);
	}
}
