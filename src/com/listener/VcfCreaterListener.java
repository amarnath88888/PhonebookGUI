package com.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;

import com.constants.ApplicationConstants;
import com.contacts.Contacts;
import com.contacts.ContactsInitializer;
import com.reader.CsvReader;
import com.reader.DbReader;
import com.reader.ExcelReader;
import com.reader.IContactsReader;
import com.reader.PDFReader;
import com.reader.TextReader;
import com.vcf.VcfGenerator;
import com.view.HomePageLayout;

public class VcfCreaterListener implements ActionListener{
	private JLabel action_status;
	
	private ContactsInitializer contactsinitializer;
	private IContactsReader reader = null;
	
	private List<Contacts> list;
	
	public VcfCreaterListener(ContactsInitializer contactsinitializer, HomePageLayout frontend)	{
		this.contactsinitializer=contactsinitializer;
		action_status = frontend.getAction_status();  
	}
	
	public void actionPerformed(ActionEvent event) {
		VcfGenerator vcfgenerator = new VcfGenerator();
		String action_cmd = event.getActionCommand();
		if(action_cmd.equals("Convert from Text"))	{
			reader = new TextReader();
			action_status.setText(ApplicationConstants.VCF_TO_TEXT);
		}
		else if(action_cmd.equals("Convert from Csv"))	{
			reader = new CsvReader();
	    	action_status.setText(ApplicationConstants.VCF_TO_CSV);
	    }
	    else if(action_cmd.equals("Convert from Excel"))	{
			reader = new ExcelReader();
	    	action_status.setText(ApplicationConstants.VCF_TO_EXCEL); 
	    }
	    else if(action_cmd.equals("Convert from Pdf"))	{
			reader = new PDFReader();
	    	action_status.setText(ApplicationConstants.VCF_TO_PDF); 
	    }		
	    else if(action_cmd.equals("Convert from Db"))	{
			reader = new DbReader();
	    	action_status.setText(ApplicationConstants.VCF_TO_DB); 
	    }		
		list = reader.readContacts(contactsinitializer);
		vcfgenerator.vcfXmlReader(contactsinitializer);
		vcfgenerator.generateVcf(contactsinitializer,list,null);
	}
}