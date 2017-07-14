package memberGUI.faculty;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import beanClasses.FacultyUser;
import extraClasses.ImageFunctions;
import extraClasses.ReadFacStudentUser;

public class FacultyDetails 
{
	public JFrame facultyDetailsFrame;
	private String facid;
	@SuppressWarnings("unused")
	private String level;
	
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 750;
	private static final int frameheigth = 550;
	private Color bgColor;
	
	private JTextPane textName;
	private JTextPane textFatherName;
	private JTextPane textMobile;
	private JTextPane textEmail;
	private JTextPane textGender;
	private JTextPane textPermanentAddress;
	private JTextPane personalDetailsText;
	private JTextPane addressText;
	private JTextPane higherQualifText;
	private JTextPane textHighestqualif;
	private JTextPane textCollege;
	private JTextPane textScore;
	private JTextPane textPassingYear;
	private JTextPane textCity;
	private JTextPane textState;
	private JTextPane textPinCode;
	
	private JTextField stateField;
	private JTextField cityField;
	private JTextField pincodeField;
	private JTextField nameTextField;
	private JTextField fatherNameField;
	private JTextField genderField;
	private JTextField mobileField;
	private JTextField emailField;
	private JLabel facultyPhoto;
	private JTextField permanentAddressField;
	private JTextField highestQualifField;
	private JTextField collegeField;
	private JTextField scoreField;
	private JTextField passingYrField;
	
	private JSeparator persDetailsSeparator;
	private JSeparator addressSeparator;
	private JSeparator higherQualifSeparator;
	
	public FacultyDetails(String fid, String className)
	{
		this.facid = fid;
		if( className.equals("memberGUI.admin.ViewAllFac"))
			level = "admin";
		else if( className.equals("memberGUI.faculty.ViewStd"))
			level = "fac";
		bgColor = new Color(238, 238, 238);
		initialiseFrame();
		initComponents();
		componentsListeners();
		associateFrameComponents();
		populateFacDetailView();
	}
	
	private void populateFacDetailView()
	{
		FacultyUser user;
		try
		{
			user = ReadFacStudentUser.readFacUser(facid);
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void associateFrameComponents()
	{
		facultyDetailsFrame.getContentPane().add(personalDetailsText);
		facultyDetailsFrame.getContentPane().add(persDetailsSeparator);
		facultyDetailsFrame.getContentPane().add(nameTextField);
		facultyDetailsFrame.getContentPane().add(textName);
		facultyDetailsFrame.getContentPane().add(pincodeField);
		facultyDetailsFrame.getContentPane().add(textPinCode);
		facultyDetailsFrame.getContentPane().add(stateField);
		facultyDetailsFrame.getContentPane().add(textState);
		facultyDetailsFrame.getContentPane().add(cityField);
		facultyDetailsFrame.getContentPane().add(textCity);
		facultyDetailsFrame.getContentPane().add(permanentAddressField);
		facultyDetailsFrame.getContentPane().add(textPermanentAddress);
		facultyDetailsFrame.getContentPane().add(addressText);
		facultyDetailsFrame.getContentPane().add(addressSeparator);
		facultyDetailsFrame.getContentPane().add(emailField);
		facultyDetailsFrame.getContentPane().add(textEmail);
		facultyDetailsFrame.getContentPane().add(mobileField);
		facultyDetailsFrame.getContentPane().add(textMobile);
		facultyDetailsFrame.getContentPane().add(genderField);
		facultyDetailsFrame.getContentPane().add(textGender);
		facultyDetailsFrame.getContentPane().add(facultyPhoto);
		facultyDetailsFrame.getContentPane().add(fatherNameField);
		facultyDetailsFrame.getContentPane().add(textFatherName);
		facultyDetailsFrame.getContentPane().add(passingYrField);
		facultyDetailsFrame.getContentPane().add(textPassingYear);
		facultyDetailsFrame.getContentPane().add(scoreField);
		facultyDetailsFrame.getContentPane().add(textScore);
		facultyDetailsFrame.getContentPane().add(collegeField);
		facultyDetailsFrame.getContentPane().add(textCollege);
		facultyDetailsFrame.getContentPane().add(highestQualifField);
		facultyDetailsFrame.getContentPane().add(textHighestqualif);
		facultyDetailsFrame.getContentPane().add(higherQualifText);
		facultyDetailsFrame.getContentPane().add(higherQualifSeparator);
	}
		
	public void initComponents()
	{
		persDetailsSeparator = new JSeparator();
		persDetailsSeparator.setBounds(0, 30, 600, 5);
		personalDetailsText = new JTextPane();
		personalDetailsText.setText("Personal Details");
		personalDetailsText.setBounds(15, 20, 120, 20);
		personalDetailsText.setBackground(bgColor);
		
		//      FIRST ROW      \\
		textName = new JTextPane();
		textName.setBounds(25, 55, 50, 20);
		textName.setText("Name");
		textName.setBackground(bgColor);
		textName.setEditable(false);
		textName.setFocusable(false);
		nameTextField = new JTextField();
		nameTextField.setBounds(75, 55, 170, 20);
		nameTextField.setEditable(false);
		
		
		textFatherName = new JTextPane();
		//textName.setFont();
		textFatherName.setBounds(260, 55, 100, 20);
		textFatherName.setText("Guardian Name");
		textFatherName.setBackground(bgColor);
		textFatherName.setEditable(false);
		textFatherName.setFocusable(false);
		fatherNameField = new JTextField();
		fatherNameField.setBounds(360, 55, 170, 20);
		fatherNameField.setEditable(false);
		
		facultyPhoto = new JLabel();
		facultyPhoto.setBounds(630, 25, 100, 150);
		facultyPhoto.setIcon( new ImageIcon("images/creed.jpg"));
		
		//       SECOND ROW          \\      
		
		textGender = new JTextPane();
		textGender.setBounds(25, 105, 50, 20);
		textGender.setText("Gender");
		textGender.setBackground(bgColor);
		textGender.setEditable(false);
		textGender.setFocusable(false);
		genderField = new JTextField();
	    genderField.setBounds(80, 105, 20, 20);
	    genderField.setEditable(false);
		
		textMobile = new JTextPane();
		textMobile.setBounds(115, 105, 70, 20);
		textMobile.setText("Mobile No");
		textMobile.setBackground(bgColor);
		textMobile.setEditable(false);
		textMobile.setFocusable(false);
		mobileField = new JTextField();
		mobileField.setBounds(185, 105, 90, 20);
	    mobileField.setEditable(false);
	    mobileField.setHorizontalAlignment(JTextField.CENTER);
		
		textEmail = new JTextPane();
		textEmail.setBounds(290, 105, 40, 20);
		textEmail.setText("Email");
		textEmail.setBackground(bgColor);
		textEmail.setEditable(false);
		textEmail.setFocusable(false);
		emailField = new JTextField();
		emailField.setBounds(340, 105, 200, 20);
		emailField.setEditable(false);
		emailField.setHorizontalAlignment(JTextField.CENTER);
		
		
		//      THIRD ROW       \\
		
		addressSeparator = new JSeparator();
		addressSeparator.setBounds(0, 155, 600, 5);
		addressText = new JTextPane();
		addressText.setText("Address Details");
		addressText.setBounds(15, 145, 120, 20);
		addressText.setBackground(bgColor);
		
		textPermanentAddress = new JTextPane();
		textPermanentAddress.setBounds(25, 180, 130, 20);
		textPermanentAddress.setText("Address");
		textPermanentAddress.setBackground(bgColor);
		textPermanentAddress.setEditable(false);
		textPermanentAddress.setFocusable(false);
		permanentAddressField = new JTextField();
		permanentAddressField.setBounds(185, 180, 250, 20);
		permanentAddressField.setEditable(false);
		permanentAddressField.setHorizontalAlignment(JTextField.CENTER);
		
		textCity = new JTextPane();
		textCity.setBounds(25, 230, 30, 20);
		textCity.setText("City");
		textCity.setBackground(bgColor);
		textCity.setEditable(false);
		textCity.setFocusable(false);
		cityField = new JTextField();
		cityField.setBounds(55, 230, 120, 20);
		cityField.setEditable(false);
		cityField.setHorizontalAlignment(JTextField.CENTER);
		
		textState = new JTextPane();
		textState.setBounds(200, 230, 40, 20);
		textState.setText("State");
		textState.setBackground(bgColor);
		textState.setEditable(false);
		textState.setFocusable(false);
		stateField = new JTextField();
		stateField.setBounds(240, 230, 150, 20);
		stateField.setEditable(false);
		stateField.setHorizontalAlignment(JTextField.CENTER);
		
		textPinCode = new JTextPane();
		textPinCode.setBounds(405, 230, 60, 20);
		textPinCode.setText("Pincode");
		textPinCode.setBackground(bgColor);
		textPinCode.setEditable(false);
		textPinCode.setFocusable(false);
		pincodeField = new JTextField();
		pincodeField.setBounds(465, 230, 80, 20);
		pincodeField.setEditable(false);
		pincodeField.setHorizontalAlignment(JTextField.CENTER);
		
		
		/*
		textCorrespondenceAddress = new JTextPane();
		textCorrespondenceAddress.setBounds(25, 205, 160, 20);
		textCorrespondenceAddress.setText("Correspondence  Address");
		textCorrespondenceAddress.setBackground(bgColor);
		textCorrespondenceAddress.setEditable(false);
		textCorrespondenceAddress.setFocusable(false);
		facultyDetailsFrame.add(textCorrespondenceAddress);
		correspondenceAddressField = new JTextField();
		correspondenceAddressField.setBounds(185, 205, 400, 20);
		correspondenceAddressField.setEditable(false);
		correspondenceAddressField.setText("H.No.-112 Type-1 41 Bn PAC Ghaziabad UttarPradesh - 201010");
		correspondenceAddressField.setHorizontalAlignment(JTextField.CENTER);
		facultyDetailsFrame.add(correspondenceAddressField);*/
		
		//       FOURTH ROW       \\
		
		higherQualifSeparator = new JSeparator();
		higherQualifSeparator.setBounds(0, 285, 600, 5);
		higherQualifText = new JTextPane();
		higherQualifText.setBounds(15, 275, 180, 20);
		higherQualifText.setText("Higher Qualification Details");
		higherQualifText.setBackground(bgColor);
		
		textHighestqualif = new JTextPane();
		textHighestqualif.setBounds(25, 335, 150, 20);
		textHighestqualif.setText("Highest Qualification");
		textHighestqualif.setBackground(bgColor);
		textHighestqualif.setEditable(false);
		textHighestqualif.setFocusable(false);
		highestQualifField = new JTextField();
		highestQualifField.setBounds(175, 335, 90, 20);
		highestQualifField.setEditable(false);
		highestQualifField.setHorizontalAlignment(JTextField.CENTER);
		
		textCollege = new JTextPane();
		textCollege.setBounds(280, 335, 60, 20);
		textCollege.setText("College");
		textCollege.setBackground(bgColor);
		textCollege.setEditable(false);
		textCollege.setFocusable(false);
        collegeField = new JTextField();
        collegeField.setBounds(340, 335, 200, 20);
        collegeField.setEditable(false);
        collegeField.setHorizontalAlignment(JTextField.CENTER);
		
		textScore = new JTextPane();
		textScore.setBounds(25, 385, 90, 20);
		textScore.setText("Total Score");
		textScore.setBackground(bgColor);
		textScore.setEditable(false);
		textScore.setFocusable(false);
		scoreField = new JTextField();
		scoreField.setBounds(115, 385, 80, 20);
		scoreField.setEditable(false);
		scoreField.setHorizontalAlignment(JTextField.CENTER);
		
		textPassingYear = new JTextPane();
		textPassingYear.setBounds(260, 385, 90, 20);
		textPassingYear.setText("Passing Year");
		textPassingYear.setBackground(bgColor);
		textPassingYear.setEditable(false);
		textPassingYear.setFocusable(false);
		passingYrField = new JTextField();
		passingYrField.setBounds(350, 385, 115, 20);
		passingYrField.setEditable(false);
		passingYrField.setHorizontalAlignment(JTextField.CENTER);
		
		
		JButton editButton = new JButton();
		editButton.setBounds(300, 480, 80, 20);
		editButton.setBackground(bgColor);
		editButton.setText("Edit");
		facultyDetailsFrame.getContentPane().add(editButton);
	}
	
	public void componentsListeners()
	{
		
	}

	private void initialiseFrame()
	{
		facultyDetailsFrame = new JFrame();
		facultyDetailsFrame.setBounds(framex, framey, frameLength, frameheigth);
		facultyDetailsFrame.setBackground(bgColor);
		facultyDetailsFrame.getContentPane().setLayout(null);
		facultyDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		facultyDetailsFrame.setResizable(false);
		
		facultyDetailsFrame.addWindowListener( new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent arg0)
			{
				MainFacultyGUI fac = new MainFacultyGUI(facid);
				fac.facultyFrame.setVisible(true);
				super.windowClosing(arg0);
			}
		});
	}
}
