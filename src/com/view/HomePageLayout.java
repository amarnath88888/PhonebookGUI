package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.contacts.ContactsInitializer;
import com.listener.FileSelectionListener;
import com.listener.VcfConverterListener;
import com.listener.VcfCreaterListener;

public class HomePageLayout  {
	private Dimension screensize;
	
	private final int HEIGHT = 500;
	private final int WIDTH = 500;
	
	private JFrame mainframe;
	
	private JPanel fileSelector;
	private JPanel vcfContainer;
	private JPanel exportContainer;
	
	private JButton browse;
	private JLabel select_path;
	private JLabel absolute_path;
	private JButton vcf_to_text;
	private JButton vcf_to_csv;
	private JButton vcf_to_excel;
	private JButton vcf_to_pdf;;
	private JButton vcf_to_db;
	private JButton text_to_vcf;
	private JButton csv_to_vcf;
	private JButton excel_to_vcf;
	private JButton pdf_to_vcf;
	private JButton db_to_vcf;
	
	private JLabel action_status;
	
	private HomePageLayout homepagelayout;
	private FileSelectionListener fileSelectionListener;
	private VcfConverterListener vcfConverterListener;
	private VcfCreaterListener vcfCreaterListener;
	
	public HomePageLayout()	{}
	
	public HomePageLayout(ContactsInitializer contactsinitializer)	{
		
		// Initialize the components
	    initializeComponents(contactsinitializer);
	    
	    // Set properties for components
	    setProperties();
	    
	    // Add components to containers
	    addComponents();
	    
	    // Add listeners to for the components
	    addListners();
	    
	    // Display the frame. 
	    mainframe.setVisible(true); 
	}
	
	private void initializeComponents(ContactsInitializer contactsinitializer)	{
		// Create the main frame
		mainframe = new JFrame("Phonebook"); 
		
		// Create the Panels.  
	    vcfContainer = new JPanel(); 
	    exportContainer = new JPanel();
	    fileSelector= new JPanel();
	     
	    // Create buttons and labels for File selection 
	    browse = new JButton("Browse");
	    select_path = new JLabel("Select the folder with vcf Files");
	    absolute_path = new JLabel("Path Selected :");
	    
	    // Create four buttons for Converting vcf format 
	    vcf_to_text = new JButton("Create TextFile"); 
	    vcf_to_csv = new JButton("Create CSVFile"); 
	    vcf_to_excel = new JButton("Create ExcelFile"); 
	    vcf_to_pdf = new JButton("Create PDFFile"); 
	    vcf_to_db = new JButton("Create Database"); 
		
	    // Create four buttons for Converting vcf format 
	    text_to_vcf = new JButton("Convert from Text"); 
	    csv_to_vcf = new JButton("Convert from Csv"); 
	    excel_to_vcf = new JButton("Convert from Excel"); 
	    pdf_to_vcf = new JButton("Convert from Pdf"); 
	    db_to_vcf = new JButton("Convert from Db"); 

	    // Set Tool Tips
	    vcf_to_text.setToolTipText("Creates text file from vcf files");
	    vcf_to_csv.setToolTipText("Creates csv file from vcf files");
	    vcf_to_excel.setToolTipText("Creates excel file from vcf files");
	    vcf_to_pdf.setToolTipText("Creates pdf file from vcf files");
	    vcf_to_db.setToolTipText("Creates Database table from vcf files");

	    text_to_vcf.setToolTipText("Converts text file to vcf files");
	    csv_to_vcf.setToolTipText("Converts csv file to vcf files");
	    excel_to_vcf.setToolTipText("Converts excel file to vcf files");
	    pdf_to_vcf.setToolTipText("Converts pdf file to vcf files");
	    db_to_vcf.setToolTipText("Converts DB table to vcf files");
	    
	    // Initialize action status
	    action_status = new JLabel("Press a Button");
		
		// Create the action class object to implement the listeners
	    homepagelayout = this;
	    fileSelectionListener = new FileSelectionListener(contactsinitializer, homepagelayout);
		vcfConverterListener = new VcfConverterListener(contactsinitializer, homepagelayout);
	    vcfCreaterListener = new VcfCreaterListener(contactsinitializer, homepagelayout);
	}
	
	private void setProperties() {
		screensize = Toolkit.getDefaultToolkit().getScreenSize();
		
		// Specify FlowLayout for the layout manager. 
	    mainframe.getContentPane().setLayout(new FlowLayout()); 
	 
	    // Give the frame an initial size. 
	    mainframe.setBounds(((screensize.width / 2) - (WIDTH / 2)),	((screensize.height / 2) - (HEIGHT / 2)), WIDTH, HEIGHT); 
	 
	    // Terminate the program when the user closes the application. 
	    mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 
	    // Set the preferred size of the browser panel. 
	    fileSelector.setPreferredSize(new Dimension(400, 100)); 
	 
	    // Set Layout for panel
	    fileSelector.setLayout(new GridLayout(2, 2)); 
	    
	    // Make the panel opaque. 
	    fileSelector.setOpaque(true); 
	 
	    // Add a blue border to the panel. 
	    fileSelector.setBorder(BorderFactory.createLineBorder(Color.RED)); 
	 
	    // Set the preferred size of the first panel. 
	    vcfContainer.setPreferredSize(new Dimension(200, 150)); 
	 
	    // Set Layout for panel
	    vcfContainer.setLayout(new GridLayout(5, 1)); 
	    
	    // Make the panel opaque. 
	    vcfContainer.setOpaque(true); 
	 
	    // Add a blue border to the panel. 
	    vcfContainer.setBorder(BorderFactory.createLineBorder(Color.BLUE)); 
	 
	    // Set the preferred size of the second panel. 
	    exportContainer.setPreferredSize(new Dimension(200, 150)); 
	 
	    // Set Layout for panel
	    exportContainer.setLayout(new GridLayout(5, 1)); 
	    
	    // Make the panel opaque. 
	    exportContainer.setOpaque(true); 
	 
	    // Add a red border to the panel. 
	    exportContainer.setBorder(BorderFactory.createLineBorder(Color.BLUE)); 

	}

	private void addComponents()	{		
		// Add components to FileSelector Panel
		fileSelector.add(select_path);
		fileSelector.add(browse);
		fileSelector.add(absolute_path);
		
		// Add the buttons to the content pane. 
	    vcfContainer.add(vcf_to_text);  
	    vcfContainer.add(vcf_to_csv);   
	    vcfContainer.add(vcf_to_excel);   
	    vcfContainer.add(vcf_to_pdf);
	    vcfContainer.add(vcf_to_db);
	    
	    exportContainer.add(text_to_vcf);
	    exportContainer.add(csv_to_vcf);
	    exportContainer.add(excel_to_vcf);
	    exportContainer.add(pdf_to_vcf);
	    exportContainer.add(db_to_vcf);
	    
	    mainframe.getContentPane().add(fileSelector);
	    mainframe.getContentPane().add(vcfContainer);
	    mainframe.getContentPane().add(exportContainer);
	    mainframe.getContentPane().add(action_status);	    
	}
	
	private void addListners() {		
		// Add action listeners. 
	    browse.addActionListener(fileSelectionListener);
		
		vcf_to_text.addActionListener(vcfConverterListener); 
	    vcf_to_csv.addActionListener(vcfConverterListener); 
	    vcf_to_excel.addActionListener(vcfConverterListener); 
	    vcf_to_pdf.addActionListener(vcfConverterListener); 
	    vcf_to_db.addActionListener(vcfConverterListener);	    
	    
	    text_to_vcf.addActionListener(vcfCreaterListener);
	    csv_to_vcf.addActionListener(vcfCreaterListener);
	    excel_to_vcf.addActionListener(vcfCreaterListener);
	    pdf_to_vcf.addActionListener(vcfCreaterListener);
	    db_to_vcf.addActionListener(vcfCreaterListener);
	}
	public JLabel getAction_status() {
		return action_status;
	}
	public void setAction_status(JLabel action_status) {
		this.action_status = action_status;
	}
	public JLabel getAbsolutePath() {
		return absolute_path;
	}
	public JButton getBrowse() {
		return browse;
	}
}
