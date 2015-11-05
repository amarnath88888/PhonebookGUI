package com.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import com.constants.ApplicationConstants;
import com.contacts.ContactsInitializer;
import com.view.HomePageLayout;

public class FileSelectionListener implements ActionListener {

	private JLabel action_status;
	private JFileChooser chooser;
	private JButton browse;
	private JLabel absolute_path;
	private int value;
	private File field;
	private String path;
	private ContactsInitializer contactsinitializer;
	
	public FileSelectionListener(ContactsInitializer contactsinitializer, HomePageLayout frontend) {
		this.contactsinitializer=contactsinitializer;
		action_status = frontend.getAction_status(); 
		browse=frontend.getBrowse();
		absolute_path = frontend.getAbsolutePath();
		chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("Browse"))	{
			value = chooser.showOpenDialog(browse);
			if (value == JFileChooser.APPROVE_OPTION)	{
				field = chooser.getSelectedFile();
              	path = field.getAbsolutePath();
        		action_status.setText(ApplicationConstants.PATH_SELECTED);
        		absolute_path.setText(path);
              	contactsinitializer.initContacts(path);
			}
		}
	}
}
