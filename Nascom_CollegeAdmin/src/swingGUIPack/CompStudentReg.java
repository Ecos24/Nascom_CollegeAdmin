package swingGUIPack;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import extendedClasses.DateLabelFormatter;
import extraClasses.StatesReadFromFile;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompStudentReg
{
	private static final int framex = 0;
	private static final int framey = 0;
	private static final int frameLength = 800;
	private static final int frameheigth = 800;
	private Color bgColor;
	
	private JFrame compStudentReg;
	
	// Components Declaration.
	// Section 1.
	private JTextPane section1Header;
	private JSeparator section1Separator;
	private JTextField stdFirstName;
	private JTextField stdMiddelName;
	private JTextField stdLastName;
	private SqlDateModel stdDOBDateModel;
	private JDatePanelImpl stdDOBDatePickerPanel;
	private JDatePickerImpl stdDOB;
	@SuppressWarnings("rawtypes")
	private JComboBox stdGender;
	private JTextField stdEmail;
	private JFormattedTextField stdMobNo;
	@SuppressWarnings("rawtypes")
	private JComboBox stdCategory;
	private JTextPane stdFirstNameTextPane;
	private JTextPane stdMiddleNameTextPane;
	private JTextPane stdLastNameTextPane;
	private JTextPane stdDOBTextPane;
	private JTextPane stdGenderTextPane;
	private JTextPane stdEmailTextPane;
	private JTextPane stdMobNoTextPane;
	private JTextPane stdCategoryTextPane;
	// Section 2.
	private JTextPane section2Header;
	private JSeparator section2Separator;
	@SuppressWarnings("rawtypes")
	private JComboBox stdAddState;
	@SuppressWarnings("rawtypes")
	private JComboBox stdAddCity;
	private JFormattedTextField stdAddPincode;
	private JTextField stdAddHome;
	private JTextPane stdAddStateTextPane;
	private JTextPane stdAddCityTextPane;
	private JTextPane stdAddPincodeTextPane;
	private JTextPane stdAddHomeTextPane;
	// Section 3.
	private JTextPane section3Header;
	private JCheckBox stdCorespChoice;
	private JSeparator section3Separator;
	@SuppressWarnings("rawtypes")
	private JComboBox stdCorespAddState;
	@SuppressWarnings("rawtypes")
	private JComboBox stdCorespAddCity;
	private JFormattedTextField stdCorespAddPincode;
	private JTextField stdCorespAddHome;
	private JTextPane stdCorespAddStateTextPane;
	private JTextPane stdCorespAddCityTextPane;
	private JTextPane stdCorespAddPincodeTextPane;
	private JTextPane stdCorespAddHomeTextPane;
	//Section 4.
	private JTextPane section4Header;
	private JSeparator section4Separator;
	private JTextField stdFatherFirstName;
	private JTextField stdFatherMiddelName;
	private JTextField stdFatherLastName;
	private JFormattedTextField stdFatherMobNo;
	@SuppressWarnings("rawtypes")
	private JComboBox stdFatherOccupation;
	private JTextField stdFatherEmail;
	private JTextPane stdFatherFirstNameTextPane;
	private JTextPane stdFatherMiddleNameTextPane;
	private JTextPane stdFatherLastNameTextPane;
	private JTextPane stdFatherMobNoTextPane;
	private JTextPane stdFatherOccupationTextPane;
	private JTextPane stdFatherEmailTextPane;
	private JTextField stdMotherFirstName;
	private JTextField stdMotherMiddelName;
	private JTextField stdMotherLastName;
	private JFormattedTextField stdMotherMobNo;
	@SuppressWarnings("rawtypes")
	private JComboBox stdMotherOccupation;
	private JTextField stdMotherEmail;
	private JTextPane stdMotherFirstNameTextPane;
	private JTextPane stdMotherMiddelNameTextPane;
	private JTextPane stdMotherLastNameTextPane;
	private JTextPane stdMotherMobNoTextPane;
	private JTextPane stdMotherOccupationTextPane;
	private JTextPane stdMotherEmailTextPane;
	
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				CompStudentReg window = new CompStudentReg();
				window.compStudentReg.setVisible(true);
			}
		});
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public CompStudentReg()
	{
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{		
		//Section 1.
		compStudentReg.getContentPane().add(section1Header);
		compStudentReg.getContentPane().add(section1Separator);
		compStudentReg.getContentPane().add(stdFirstNameTextPane);
		compStudentReg.getContentPane().add(stdFirstName);
		compStudentReg.getContentPane().add(stdMiddleNameTextPane);
		compStudentReg.getContentPane().add(stdMiddelName);
		compStudentReg.getContentPane().add(stdLastNameTextPane);
		compStudentReg.getContentPane().add(stdLastName);
		compStudentReg.getContentPane().add(stdDOBTextPane);
		compStudentReg.getContentPane().add(stdDOB);
		compStudentReg.getContentPane().add(stdGenderTextPane);
		compStudentReg.getContentPane().add(stdGender);
		compStudentReg.getContentPane().add(stdEmailTextPane);
		compStudentReg.getContentPane().add(stdEmail);
		compStudentReg.getContentPane().add(stdCategoryTextPane);
		compStudentReg.getContentPane().add(stdCategory);
		compStudentReg.getContentPane().add(stdMobNoTextPane);
		compStudentReg.getContentPane().add(stdMobNo);

		//Section 2.
		compStudentReg.getContentPane().add(section2Header);
		compStudentReg.getContentPane().add(section2Separator);
		compStudentReg.getContentPane().add(stdAddStateTextPane);
		compStudentReg.getContentPane().add(stdAddState);
		compStudentReg.getContentPane().add(stdAddCityTextPane);
		compStudentReg.getContentPane().add(stdAddCity);
		compStudentReg.getContentPane().add(stdAddPincodeTextPane);
		compStudentReg.getContentPane().add(stdAddPincode);
		compStudentReg.getContentPane().add(stdAddHomeTextPane);
		compStudentReg.getContentPane().add(stdAddHome);

		//Section 3.
		compStudentReg.getContentPane().add(section3Header);
		compStudentReg.getContentPane().add(stdCorespChoice);
		compStudentReg.getContentPane().add(section3Separator);
		compStudentReg.getContentPane().add(stdCorespAddStateTextPane);
		compStudentReg.getContentPane().add(stdCorespAddState);
		compStudentReg.getContentPane().add(stdCorespAddCityTextPane);
		compStudentReg.getContentPane().add(stdCorespAddCity);
		compStudentReg.getContentPane().add(stdCorespAddPincodeTextPane);
		compStudentReg.getContentPane().add(stdCorespAddPincode);
		compStudentReg.getContentPane().add(stdCorespAddHomeTextPane);
		compStudentReg.getContentPane().add(stdCorespAddHome);
		
		//Section 4.
		compStudentReg.getContentPane().add(section4Header);
		compStudentReg.getContentPane().add(section4Separator);
		compStudentReg.getContentPane().add(stdFatherFirstNameTextPane);
		compStudentReg.getContentPane().add(stdFatherFirstName);
		compStudentReg.getContentPane().add(stdFatherMiddleNameTextPane);
		compStudentReg.getContentPane().add(stdFatherMiddelName);
		compStudentReg.getContentPane().add(stdFatherLastNameTextPane);
		compStudentReg.getContentPane().add(stdFatherLastName);
		compStudentReg.getContentPane().add(stdFatherMobNoTextPane);
		compStudentReg.getContentPane().add(stdFatherMobNo);
		compStudentReg.getContentPane().add(stdFatherOccupationTextPane);
		compStudentReg.getContentPane().add(stdFatherOccupation);
		compStudentReg.getContentPane().add(stdFatherEmailTextPane);
		compStudentReg.getContentPane().add(stdFatherEmail);
		
		compStudentReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		compStudentReg.setResizable(false);
		//compStudentReg.getRootPane().setDefaultButton(LogIn);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents()
	{
		//////////////////////////////////////////////////////////////////
		//////////////////////FIRST SECTION///////////////////////////////
		//////////////////////////////////////////////////////////////////
		section1Header = new JTextPane();
		section1Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section1Header.setBounds(20, 25, 150, 20);
		section1Header.setBackground(bgColor);
		section1Header.setText("Personal Details");
		section1Header.setFocusable(false);
		section1Header.setEditable(false);
		section1Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section1Separator.setBounds(0, 37, frameLength, 2);
		// First Row
		stdFirstNameTextPane = new JTextPane();
		stdFirstNameTextPane.setBounds(20, 60, 80, 20);
		stdFirstNameTextPane.setBackground(bgColor);
		stdFirstNameTextPane.setText("First Name");
		stdFirstNameTextPane.setFocusable(false);
		stdFirstNameTextPane.setEditable(false);
		stdFirstName = new JTextField();
		stdFirstName.setBounds(110, 60, 130, 20);
		stdFirstName.setColumns(10);
		
		stdMiddleNameTextPane = new JTextPane();
		stdMiddleNameTextPane.setBounds(270, 60, 90, 20);
		stdMiddleNameTextPane.setBackground(bgColor);
		stdMiddleNameTextPane.setText("Middle Name");
		stdMiddleNameTextPane.setFocusable(false);
		stdMiddleNameTextPane.setEditable(false);
		stdMiddelName = new JTextField();
		stdMiddelName.setBounds(360, 60, 130, 20);
		stdMiddelName.setColumns(10);

		stdLastNameTextPane = new JTextPane();
		stdLastNameTextPane.setBounds(520, 60, 80, 20);
		stdLastNameTextPane.setBackground(bgColor);
		stdLastNameTextPane.setText("Last Name");
		stdLastNameTextPane.setFocusable(false);
		stdLastNameTextPane.setEditable(false);
		stdLastName = new JTextField();
		stdLastName.setColumns(10);
		stdLastName.setBounds(610, 60, 130, 20);
		
		// Second Row
		stdDOBTextPane = new JTextPane();
		stdDOBTextPane.setBounds(20, 100, 80, 20);
		stdDOBTextPane.setBackground(bgColor);
		stdDOBTextPane.setText("DOB");
		stdDOBTextPane.setFocusable(false);
		stdDOBTextPane.setEditable(false);
		stdDOBDateModel = new SqlDateModel();
		Properties datePanelProperties = new Properties();
		datePanelProperties.put("text.today", "Today");
		datePanelProperties.put("text.month", "Month");
		datePanelProperties.put("text.year", "Year");
		stdDOBDatePickerPanel = new JDatePanelImpl(stdDOBDateModel, datePanelProperties);
		stdDOB = new JDatePickerImpl(stdDOBDatePickerPanel, new DateLabelFormatter() );
		stdDOB.setBounds(110, 100, 130, 25);
		
		stdGenderTextPane = new JTextPane();
		stdGenderTextPane.setBounds(270, 100, 80, 20);
		stdGenderTextPane.setBackground(bgColor);
		stdGenderTextPane.setText("Gender");
		stdGenderTextPane.setFocusable(false);
		stdGenderTextPane.setEditable(false);
		String[] stdGenderChoices = {"Select","Female","Male", "Transgender"};
		stdGender = new JComboBox(stdGenderChoices);
		stdGender.setBounds(360, 100, 130, 20);

		stdEmailTextPane = new JTextPane();
		stdEmailTextPane.setBounds(520, 100, 80, 20);
		stdEmailTextPane.setBackground(bgColor);
		stdEmailTextPane.setText("E-Mail");
		stdEmailTextPane.setFocusable(false);
		stdEmailTextPane.setEditable(false);
		stdEmail = new JTextField();
		stdEmail.setColumns(10);
		stdEmail.setBounds(610, 100, 130, 20);
		
		// Third Row.
		stdMobNoTextPane = new JTextPane();
		stdMobNoTextPane.setBounds(20, 140, 80, 20);
		stdMobNoTextPane.setBackground(bgColor);
		stdMobNoTextPane.setText("Moblie");
		stdMobNoTextPane.setFocusable(false);
		stdMobNoTextPane.setEditable(false);
		stdMobNo = new JFormattedTextField();
		stdMobNo.setBounds(110, 140, 130, 20);

		stdCategoryTextPane = new JTextPane();
		stdCategoryTextPane.setBounds(270, 140, 80, 20);
		stdCategoryTextPane.setBackground(bgColor);
		stdCategoryTextPane.setText("Category");
		stdCategoryTextPane.setFocusable(false);
		stdCategoryTextPane.setEditable(false);
		String[] stdCategoryChoices = {"Select","GEN","OBC(Creamy)", "OBC(Non-Creamy)", "SC", "ST"};
		stdCategory = new JComboBox(stdCategoryChoices);
		stdCategory.setBounds(360, 140, 130, 20);
		
		//////////////////////////////////////////////////////////////////
		//////////////////////SECOND SECTION//////////////////////////////
		//////////////////////////////////////////////////////////////////
		section2Header = new JTextPane();
		section2Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section2Header.setBounds(20, 180, 130, 20);
		section2Header.setBackground(bgColor);
		section2Header.setText("Postal Details");
		section2Header.setFocusable(false);
		section2Header.setEditable(false);
		section2Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section2Separator.setBounds(0, 192, frameLength, 2);
		// First Row
		stdAddStateTextPane = new JTextPane();
		stdAddStateTextPane.setBounds(20, 215, 80, 20);
		stdAddStateTextPane.setBackground(bgColor);
		stdAddStateTextPane.setText("State");
		stdAddStateTextPane.setFocusable(false);
		stdAddStateTextPane.setEditable(false);
		String[] stdAddStatesChoices = StatesReadFromFile.getStates();
		stdAddState = new JComboBox(stdAddStatesChoices);
		stdAddState.setBounds(110, 215, 130, 20);
		
		stdAddCityTextPane = new JTextPane();
		stdAddCityTextPane.setBounds(270, 215, 90, 20);
		stdAddCityTextPane.setBackground(bgColor);
		stdAddCityTextPane.setText("City");
		stdAddCityTextPane.setFocusable(false);
		stdAddCityTextPane.setEditable(false);
		stdAddCity = new JComboBox();
		stdAddCity.setBounds(360, 215, 130, 20);

		stdAddPincodeTextPane = new JTextPane();
		stdAddPincodeTextPane.setBounds(520, 215, 80, 20);
		stdAddPincodeTextPane.setBackground(bgColor);
		stdAddPincodeTextPane.setText("Pin Code");
		stdAddPincodeTextPane.setFocusable(false);
		stdAddPincodeTextPane.setEditable(false);
		stdAddPincode = new JFormattedTextField();
		stdAddPincode.setColumns(10);
		stdAddPincode.setBounds(610, 215, 130, 20);
		
		// Second Row
		stdAddHomeTextPane = new JTextPane();
		stdAddHomeTextPane.setBounds(20, 255, 80, 20);
		stdAddHomeTextPane.setBackground(bgColor);
		stdAddHomeTextPane.setText("Address");
		stdAddHomeTextPane.setFocusable(false);
		stdAddHomeTextPane.setEditable(false);
		stdAddHome = new JTextField();
		stdAddHome.setBounds(110, 255, 300, 20);
		
		//////////////////////////////////////////////////////////////////
		//////////////////////THIRD SECTION//////////////////////////////
		//////////////////////////////////////////////////////////////////
		section3Header = new JTextPane();
		section3Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section3Header.setBounds(20, 295, 280, 20);
		section3Header.setBackground(bgColor);
		section3Header.setText("Correspondence Postal Details");
		section3Header.setFocusable(false);
		section3Header.setEditable(false);
		stdCorespChoice = new JCheckBox("Same as Above");
		stdCorespChoice.setBounds(500, 295, 140, 20);
		section3Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section3Separator.setBounds(0, 307, frameLength, 2);
		// First Row
		stdCorespAddStateTextPane = new JTextPane();
		stdCorespAddStateTextPane.setBounds(20, 330, 80, 20);
		stdCorespAddStateTextPane.setBackground(bgColor);
		stdCorespAddStateTextPane.setText("State");
		stdCorespAddStateTextPane.setFocusable(false);
		stdCorespAddStateTextPane.setEditable(false);
		stdCorespAddState = new JComboBox(stdAddStatesChoices);
		stdCorespAddState.setBounds(110, 330, 130, 20);
		
		stdCorespAddCityTextPane = new JTextPane();
		stdCorespAddCityTextPane.setBounds(270, 330, 90, 20);
		stdCorespAddCityTextPane.setBackground(bgColor);
		stdCorespAddCityTextPane.setText("City");
		stdCorespAddCityTextPane.setFocusable(false);
		stdCorespAddCityTextPane.setEditable(false);
		stdCorespAddCity = new JComboBox();
		stdCorespAddCity.setBounds(360, 330, 130, 20);

		stdCorespAddPincodeTextPane = new JTextPane();
		stdCorespAddPincodeTextPane.setBounds(520, 330, 80, 20);
		stdCorespAddPincodeTextPane.setBackground(bgColor);
		stdCorespAddPincodeTextPane.setText("Pin Code");
		stdCorespAddPincodeTextPane.setFocusable(false);
		stdCorespAddPincodeTextPane.setEditable(false);
		stdCorespAddPincode = new JFormattedTextField();
		stdCorespAddPincode.setColumns(10);
		stdCorespAddPincode.setBounds(610, 330, 130, 20);
		
		// Second Row
		stdCorespAddHomeTextPane = new JTextPane();
		stdCorespAddHomeTextPane.setBounds(20, 370, 80, 20);
		stdCorespAddHomeTextPane.setBackground(bgColor);
		stdCorespAddHomeTextPane.setText("Address");
		stdCorespAddHomeTextPane.setFocusable(false);
		stdCorespAddHomeTextPane.setEditable(false);
		stdCorespAddHome = new JTextField();
		stdCorespAddHome.setBounds(110, 370, 300, 20);
		
		//////////////////////////////////////////////////////////////////
		////////////////////// FOURTH SECTION/////////////////////////////
		//////////////////////////////////////////////////////////////////
		section4Header = new JTextPane();
		section4Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section4Header.setBounds(20, 410, 150, 20);
		section4Header.setBackground(bgColor);
		section4Header.setText("Parental Details");
		section4Header.setFocusable(false);
		section4Header.setEditable(false);
		section4Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section4Separator.setBounds(0, 422, frameLength, 2);
		// First Row
		stdFatherFirstNameTextPane = new JTextPane();
		stdFatherFirstNameTextPane.setBounds(20, 445, 80, 20);
		stdFatherFirstNameTextPane.setBackground(bgColor);
		stdFatherFirstNameTextPane.setText("Father's First Name");
		stdFatherFirstNameTextPane.setFocusable(false);
		stdFatherFirstNameTextPane.setEditable(false);
		stdFatherFirstName = new JTextField();
		stdFatherFirstName.setBounds(110, 445, 130, 20);
		stdFatherFirstName.setColumns(10);

		stdFatherMiddleNameTextPane = new JTextPane();
		stdFatherMiddleNameTextPane.setBounds(270, 445, 90, 20);
		stdFatherMiddleNameTextPane.setBackground(bgColor);
		stdFatherMiddleNameTextPane.setText("Father's Middle Name");
		stdFatherMiddleNameTextPane.setFocusable(false);
		stdFatherMiddleNameTextPane.setEditable(false);
		stdFatherMiddelName = new JTextField();
		stdFatherMiddelName.setBounds(360, 445, 130, 20);
		stdFatherMiddelName.setColumns(10);

		stdFatherLastNameTextPane = new JTextPane();
		stdFatherLastNameTextPane.setBounds(520, 445, 80, 20);
		stdFatherLastNameTextPane.setBackground(bgColor);
		stdFatherLastNameTextPane.setText("Father's Last Name");
		stdFatherLastNameTextPane.setFocusable(false);
		stdFatherLastNameTextPane.setEditable(false);
		stdFatherLastName = new JTextField();
		stdFatherLastName.setColumns(10);
		stdFatherLastName.setBounds(610, 445, 130, 20);

		// Second Row
		stdFatherMobNoTextPane = new JTextPane();
		stdFatherMobNoTextPane.setBounds(20, 485, 80, 20);
		stdFatherMobNoTextPane.setBackground(bgColor);
		stdFatherMobNoTextPane.setText("Father's Mobile");
		stdFatherMobNoTextPane.setFocusable(false);
		stdFatherMobNoTextPane.setEditable(false);
		stdFatherMobNo = new JFormattedTextField();
		stdFatherMobNo.setBounds(110, 485, 130, 20);

		stdFatherOccupationTextPane = new JTextPane();
		stdFatherOccupationTextPane.setBounds(270, 485, 80, 20);
		stdFatherOccupationTextPane.setBackground(bgColor);
		stdFatherOccupationTextPane.setText("Father's Occupation");
		stdFatherOccupationTextPane.setFocusable(false);
		stdFatherOccupationTextPane.setEditable(false);
		String[] occupationChoices = { "Select", "Enginner", "Doctor", "Armed Forces", "Government Employeed", "Self Employeed" };
		stdFatherOccupation = new JComboBox(occupationChoices);
		stdFatherOccupation.setBounds(360, 485, 130, 20);

		stdFatherEmailTextPane = new JTextPane();
		stdFatherEmailTextPane.setBounds(520, 485, 80, 20);
		stdFatherEmailTextPane.setBackground(bgColor);
		stdFatherEmailTextPane.setText("Father's E-Mail");
		stdFatherEmailTextPane.setFocusable(false);
		stdFatherEmailTextPane.setEditable(false);
		stdFatherEmail = new JTextField();
		stdFatherEmail.setColumns(10);
		stdFatherEmail.setBounds(610, 485, 130, 20);
		
		//////////////////////////////////////////////////////////////////////
		//////////////////////////////Listner's///////////////////////////////
		//////////////////////////////////////////////////////////////////////
		stdCorespChoice.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if( stdCorespChoice.isSelected() )
				{
					stdCorespAddState.setEnabled(false);
					stdCorespAddCity.setEnabled(false);
					stdCorespAddHome.setEnabled(false);
					stdCorespAddPincode.setEnabled(false);

					stdCorespAddState.setSelectedIndex(stdAddState.getSelectedIndex());
					stdCorespAddCity.setSelectedIndex(stdAddCity.getSelectedIndex());
					stdCorespAddHome.setText(stdAddHome.getText());
					stdCorespAddPincode.setText(stdAddPincode.getText());
				}
				else
				{
					stdCorespAddState.setSelectedIndex(0);
					stdCorespAddHome.setText(null);
					stdCorespAddPincode.setText(null);
					
					stdCorespAddCity.setEnabled(true);
					stdCorespAddHome.setEnabled(true);
					stdCorespAddPincode.setEnabled(true);
					stdCorespAddState.setEnabled(true);
				}
			}
		});
	}
	
	private void initializeFrame()
	{
		compStudentReg = new JFrame("Student Registration");
		compStudentReg.setBounds(framex, framey, frameLength, frameheigth);
		compStudentReg.setBackground(bgColor);
		compStudentReg.getContentPane().setLayout(null);
		compStudentReg.setVisible(true);
	}
}
