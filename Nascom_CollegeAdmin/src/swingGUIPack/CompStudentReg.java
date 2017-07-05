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

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;

public class CompStudentReg
{
	private static final int framex = 0;
	private static final int framey = 0;
	private static final int frameLength = 800;
	private static final int frameheigth = 400;
	private Color bgColor;
	
	public JFrame compStudentReg;
	
	// Components Declaration.
	// Section 1.
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
	private JSeparator seonction1Separator;
	// Section 2.
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
	private JSeparator seonction2Separator;
	
	
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
		
		compStudentReg.getContentPane().add(seonction1Separator);

		//Section 2.
		compStudentReg.getContentPane().add(stdAddStateTextPane);
		compStudentReg.getContentPane().add(stdAddState);
		compStudentReg.getContentPane().add(stdAddCityTextPane);
		compStudentReg.getContentPane().add(stdAddCity);
		compStudentReg.getContentPane().add(stdAddPincodeTextPane);
		compStudentReg.getContentPane().add(stdAddPincode);
		compStudentReg.getContentPane().add(stdAddHomeTextPane);
		compStudentReg.getContentPane().add(stdAddHome);
		
		compStudentReg.getContentPane().add(seonction2Separator);
		

		//logInFrame.getRootPane().setDefaultButton(LogIn);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents()
	{
		//////////////////////////////////////////////////////////////////
		//////////////////////FIRST SECTION///////////////////////////////
		//////////////////////////////////////////////////////////////////
		seonction1Separator = new JSeparator(SwingConstants.HORIZONTAL);
		seonction1Separator.setBounds(0, 37, frameLength, 2);
		// First Row
		stdFirstNameTextPane = new JTextPane();
		stdFirstNameTextPane.setBounds(20, 50, 80, 20);
		stdFirstNameTextPane.setBackground(bgColor);
		stdFirstNameTextPane.setText("First Name");
		stdFirstNameTextPane.setFocusable(false);
		stdFirstNameTextPane.setEditable(false);
		stdFirstName = new JTextField();
		stdFirstName.setBounds(110, 50, 130, 20);
		stdFirstName.setColumns(10);
		
		stdMiddleNameTextPane = new JTextPane();
		stdMiddleNameTextPane.setBounds(270, 50, 90, 20);
		stdMiddleNameTextPane.setBackground(bgColor);
		stdMiddleNameTextPane.setText("Middle Name");
		stdMiddleNameTextPane.setFocusable(false);
		stdMiddleNameTextPane.setEditable(false);
		stdMiddelName = new JTextField();
		stdMiddelName.setBounds(360, 50, 130, 20);
		stdMiddelName.setColumns(10);

		stdLastNameTextPane = new JTextPane();
		stdLastNameTextPane.setBounds(520, 50, 80, 20);
		stdLastNameTextPane.setBackground(bgColor);
		stdLastNameTextPane.setText("Last Name");
		stdLastNameTextPane.setFocusable(false);
		stdLastNameTextPane.setEditable(false);
		stdLastName = new JTextField();
		stdLastName.setColumns(10);
		stdLastName.setBounds(610, 50, 130, 20);
		
		// Second Row
		stdDOBTextPane = new JTextPane();
		stdDOBTextPane.setBounds(20, 90, 80, 20);
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
		stdDOB.setBounds(110, 90, 130, 25);
		
		stdGenderTextPane = new JTextPane();
		stdGenderTextPane.setBounds(270, 90, 80, 20);
		stdGenderTextPane.setBackground(bgColor);
		stdGenderTextPane.setText("Gender");
		stdGenderTextPane.setFocusable(false);
		stdGenderTextPane.setEditable(false);
		String[] stdGenderChoices = {"Select","Female","Male", "Trangender"};
		stdGender = new JComboBox(stdGenderChoices);
		stdGender.setBounds(360, 90, 130, 20);

		stdEmailTextPane = new JTextPane();
		stdEmailTextPane.setBounds(520, 90, 80, 20);
		stdEmailTextPane.setBackground(bgColor);
		stdEmailTextPane.setText("E-Mail");
		stdEmailTextPane.setFocusable(false);
		stdEmailTextPane.setEditable(false);
		stdEmail = new JTextField();
		stdEmail.setColumns(10);
		stdEmail.setBounds(610, 90, 130, 20);
		
		// Third Row.
		stdMobNoTextPane = new JTextPane();
		stdMobNoTextPane.setBounds(20, 130, 80, 20);
		stdMobNoTextPane.setBackground(bgColor);
		stdMobNoTextPane.setText("Moblie");
		stdMobNoTextPane.setFocusable(false);
		stdMobNoTextPane.setEditable(false);
		stdMobNo = new JFormattedTextField();
		stdMobNo.setBounds(110, 130, 130, 20);

		stdCategoryTextPane = new JTextPane();
		stdCategoryTextPane.setBounds(270, 130, 80, 20);
		stdCategoryTextPane.setBackground(bgColor);
		stdCategoryTextPane.setText("Category");
		stdCategoryTextPane.setFocusable(false);
		stdCategoryTextPane.setEditable(false);
		String[] stdCategoryChoices = {"Select","GEN","OBC(Creamy)", "OBC(Non-Creamy)", "SC", "ST"};
		stdCategory = new JComboBox(stdCategoryChoices);
		stdCategory.setBounds(360, 130, 130, 20);
		
		//////////////////////////////////////////////////////////////////
		//////////////////////SECOND SECTION//////////////////////////////
		//////////////////////////////////////////////////////////////////
		seonction2Separator = new JSeparator(SwingConstants.HORIZONTAL);
		seonction2Separator.setBounds(0, 192, frameLength, 2);
		// First Row
		stdAddStateTextPane = new JTextPane();
		stdAddStateTextPane.setBounds(20, 205, 80, 20);
		stdAddStateTextPane.setBackground(bgColor);
		stdAddStateTextPane.setText("State");
		stdAddStateTextPane.setFocusable(false);
		stdAddStateTextPane.setEditable(false);
		String[] stdAddStatesChoices = StatesReadFromFile.states();
		stdAddState = new JComboBox(stdAddStatesChoices);
		stdAddState.setBounds(110, 205, 130, 20);
		
		stdAddCityTextPane = new JTextPane();
		stdAddCityTextPane.setBounds(270, 205, 90, 20);
		stdAddCityTextPane.setBackground(bgColor);
		stdAddCityTextPane.setText("City");
		stdAddCityTextPane.setFocusable(false);
		stdAddCityTextPane.setEditable(false);
		stdAddCity = new JComboBox();
		stdAddCity.setBounds(360, 205, 130, 20);

		stdAddPincodeTextPane = new JTextPane();
		stdAddPincodeTextPane.setBounds(520, 205, 80, 20);
		stdAddPincodeTextPane.setBackground(bgColor);
		stdAddPincodeTextPane.setText("Pin Code");
		stdAddPincodeTextPane.setFocusable(false);
		stdAddPincodeTextPane.setEditable(false);
		stdAddPincode = new JFormattedTextField();
		stdAddPincode.setColumns(10);
		stdAddPincode.setBounds(610, 205, 130, 20);
		
		// Second Row
		stdAddHomeTextPane = new JTextPane();
		stdAddHomeTextPane.setBounds(20, 245, 80, 20);
		stdAddHomeTextPane.setBackground(bgColor);
		stdAddHomeTextPane.setText("DOB");
		stdAddHomeTextPane.setFocusable(false);
		stdAddHomeTextPane.setEditable(false);
		stdAddHome = new JTextField();
		stdAddHome.setBounds(110, 245, 130, 25);
		
		compStudentReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		compStudentReg.setResizable(false);
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
