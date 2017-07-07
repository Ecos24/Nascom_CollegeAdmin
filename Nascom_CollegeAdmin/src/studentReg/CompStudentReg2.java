package studentReg;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import extraClasses.RegisterUtilityFunctions;

public class CompStudentReg2
{
	private final static int DIGITS_ROLL = 10;
	private final static int DIGITS_PER = 10;
	private static final int framex = 0;
	private static final int framey = 0;
	private static final int frameLength = 800;
	private static final int frameheigth = 500;
	private Color bgColor;
	
	public JFrame compStudentReg2;
	
	// Section 5.
	private JTextPane section5Header;
	private JSeparator section5Separator;
	private JTextPane stdClsXHeader;
	private JSeparator stdClsXSeparator;
	private JTextField stdClsXRollNo;
	@SuppressWarnings("rawtypes")
	private JComboBox stdClsXPassingYr;
	private JTextField stdClsXSchoolName;
	@SuppressWarnings("rawtypes")
	private JComboBox stdClsXBoard;
	@SuppressWarnings("rawtypes")
	private JComboBox stdClsXMediumStudy;
	private JFormattedTextField stdClsXPercnetage;
	private JTextPane stdClsXRollNoTextPane;
	private JTextPane stdClsXPassingYrTextPane;
	private JTextPane stdClsXSchoolNameTextPane;
	private JTextPane stdClsXBoardTextPane;
	private JTextPane stdClsXMediumStudyTextPane;
	private JTextPane stdClsXPercnetageTextPane;
	private JTextPane stdClsXIIHeader;
	private JSeparator stdClsXIISeparator;
	private JFormattedTextField stdClsXIIRollNo;
	@SuppressWarnings("rawtypes")
	private JComboBox stdClsXIIPassingYr;
	private JTextField stdClsXIISchoolName;
	@SuppressWarnings("rawtypes")
	private JComboBox stdClsXIIBoard;
	@SuppressWarnings("rawtypes")
	private JComboBox stdClsXIIMedium;
	private JFormattedTextField stdClsXIIPercnetage;
	private JTextPane stdClsXIIRollNoTextPane;
	private JTextPane stdClsXIIPassingYrTextPane;
	private JTextPane stdClsXIISchoolNameTextPane;
	private JTextPane stdClsXIIBoardTextPane;
	private JTextPane stdClsXIIMediumTextPane;
	private JTextPane stdClsXIIPercnetageTextPane;
	
	private JButton stdRegSubmit;
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public CompStudentReg2()
	{
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		initListeners();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		// Section 5.
		compStudentReg2.getContentPane().add(section5Header);
		compStudentReg2.getContentPane().add(section5Separator);
		compStudentReg2.getContentPane().add(stdClsXHeader);
		compStudentReg2.getContentPane().add(stdClsXSeparator);
		compStudentReg2.getContentPane().add(stdClsXRollNoTextPane);
		compStudentReg2.getContentPane().add(stdClsXRollNo);
		compStudentReg2.getContentPane().add(stdClsXPassingYrTextPane);
		compStudentReg2.getContentPane().add(stdClsXPassingYr);
		compStudentReg2.getContentPane().add(stdClsXSchoolNameTextPane);
		compStudentReg2.getContentPane().add(stdClsXSchoolName);
		compStudentReg2.getContentPane().add(stdClsXBoardTextPane);
		compStudentReg2.getContentPane().add(stdClsXBoard);
		compStudentReg2.getContentPane().add(stdClsXMediumStudyTextPane);
		compStudentReg2.getContentPane().add(stdClsXMediumStudy);
		compStudentReg2.getContentPane().add(stdClsXPercnetageTextPane);
		compStudentReg2.getContentPane().add(stdClsXPercnetage);
		compStudentReg2.getContentPane().add(stdClsXIIHeader);
		compStudentReg2.getContentPane().add(stdClsXIISeparator);
		compStudentReg2.getContentPane().add(stdClsXIIRollNoTextPane);
		compStudentReg2.getContentPane().add(stdClsXIIRollNo);
		compStudentReg2.getContentPane().add(stdClsXIIPassingYrTextPane);
		compStudentReg2.getContentPane().add(stdClsXIIPassingYr);
		compStudentReg2.getContentPane().add(stdClsXIISchoolNameTextPane);
		compStudentReg2.getContentPane().add(stdClsXIISchoolName);
		compStudentReg2.getContentPane().add(stdClsXIIBoardTextPane);
		compStudentReg2.getContentPane().add(stdClsXIIBoard);
		compStudentReg2.getContentPane().add(stdClsXIIMediumTextPane);
		compStudentReg2.getContentPane().add(stdClsXIIMedium);
		compStudentReg2.getContentPane().add(stdClsXIIPercnetageTextPane);
		compStudentReg2.getContentPane().add(stdClsXIIPercnetage);
		
		compStudentReg2.getContentPane().add(stdRegSubmit);
		compStudentReg2.getRootPane().setDefaultButton(stdRegSubmit);

		compStudentReg2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		compStudentReg2.setResizable(false);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents()
	{
		String[] passingYrChoice = RegisterUtilityFunctions.getPassingYr();
		
		//////////////////////////////////////////////////////////////////
		////////////////////// FOURTH SECTION/////////////////////////////
		//////////////////////////////////////////////////////////////////
		section5Header = new JTextPane();
		section5Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section5Header.setBounds(20, 30, 150, 20);
		section5Header.setBackground(bgColor);
		section5Header.setText("Parental Details");
		section5Header.setFocusable(false);
		section5Header.setEditable(false);
		section5Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section5Separator.setBounds(0, 42, frameLength, 2);

		// Father's Section.
		stdClsXHeader = new JTextPane();
		stdClsXHeader.setFont(new Font("Dialog", Font.BOLD, 14));
		stdClsXHeader.setBounds(300, 58, 130, 20);
		stdClsXHeader.setBackground(bgColor);
		stdClsXHeader.setText("Class X Details");
		stdClsXHeader.setFocusable(false);
		stdClsXHeader.setEditable(false);
		stdClsXSeparator = new JSeparator(SwingConstants.HORIZONTAL);
		stdClsXSeparator.setBounds(22, 70, 715, 2);
		// First Row
		stdClsXRollNoTextPane = new JTextPane();
		stdClsXRollNoTextPane.setBounds(20, 93, 80, 20);
		stdClsXRollNoTextPane.setBackground(bgColor);
		stdClsXRollNoTextPane.setText("First Name");
		stdClsXRollNoTextPane.setFocusable(false);
		stdClsXRollNoTextPane.setEditable(false);
		stdClsXRollNo = new JTextField();
		stdClsXRollNo.setBounds(110, 93, 130, 20);
		stdClsXRollNo.setColumns(10);

		stdClsXPassingYrTextPane = new JTextPane();
		stdClsXPassingYrTextPane.setBounds(270, 93, 90, 20);
		stdClsXPassingYrTextPane.setBackground(bgColor);
		stdClsXPassingYrTextPane.setText("Middle Name");
		stdClsXPassingYrTextPane.setFocusable(false);
		stdClsXPassingYrTextPane.setEditable(false);
		stdClsXPassingYr = new JComboBox(passingYrChoice);
		stdClsXPassingYr.setBounds(360, 93, 130, 20);

		stdClsXSchoolNameTextPane = new JTextPane();
		stdClsXSchoolNameTextPane.setBounds(520, 93, 80, 20);
		stdClsXSchoolNameTextPane.setBackground(bgColor);
		stdClsXSchoolNameTextPane.setText("Last Name");
		stdClsXSchoolNameTextPane.setFocusable(false);
		stdClsXSchoolNameTextPane.setEditable(false);
		stdClsXSchoolName = new JTextField();
		stdClsXSchoolName.setColumns(10);
		stdClsXSchoolName.setBounds(610, 93, 130, 20);

		// Second Row
		stdClsXBoardTextPane = new JTextPane();
		stdClsXBoardTextPane.setBounds(20, 133, 80, 20);
		stdClsXBoardTextPane.setBackground(bgColor);
		stdClsXBoardTextPane.setText("Mobile");
		stdClsXBoardTextPane.setFocusable(false);
		stdClsXBoardTextPane.setEditable(false);
		stdClsXBoard = new JComboBox(RegisterUtilityFunctions.getBoard());
		stdClsXBoard.setBounds(110, 133, 130, 20);

		stdClsXMediumStudyTextPane = new JTextPane();
		stdClsXMediumStudyTextPane.setBounds(270, 133, 80, 20);
		stdClsXMediumStudyTextPane.setBackground(bgColor);
		stdClsXMediumStudyTextPane.setText("Occupation");
		stdClsXMediumStudyTextPane.setFocusable(false);
		stdClsXMediumStudyTextPane.setEditable(false);
		stdClsXMediumStudy = new JComboBox(RegisterUtilityFunctions.getMedium());
		stdClsXMediumStudy.setBounds(360, 133, 130, 20);

		stdClsXPercnetageTextPane = new JTextPane();
		stdClsXPercnetageTextPane.setBounds(520, 133, 80, 20);
		stdClsXPercnetageTextPane.setBackground(bgColor);
		stdClsXPercnetageTextPane.setText("E-Mail");
		stdClsXPercnetageTextPane.setFocusable(false);
		stdClsXPercnetageTextPane.setEditable(false);
		stdClsXPercnetage = new JFormattedTextField(DIGITS_PER);
		stdClsXPercnetage.setColumns(10);
		stdClsXPercnetage.setBounds(610, 133, 130, 20);

		// Class XII Section.
		stdClsXIIHeader = new JTextPane();
		stdClsXIIHeader.setFont(new Font("Dialog", Font.BOLD, 14));
		stdClsXIIHeader.setBounds(300, 170, 135, 20);
		stdClsXIIHeader.setBackground(bgColor);
		stdClsXIIHeader.setText("Class XII Details");
		stdClsXIIHeader.setFocusable(false);
		stdClsXIIHeader.setEditable(false);
		stdClsXIISeparator = new JSeparator(SwingConstants.HORIZONTAL);
		stdClsXIISeparator.setBounds(22, 182, 715, 2);
		// First Row
		stdClsXIIRollNoTextPane = new JTextPane();
		stdClsXIIRollNoTextPane.setBounds(20, 205, 80, 20);
		stdClsXIIRollNoTextPane.setBackground(bgColor);
		stdClsXIIRollNoTextPane.setText("First Name");
		stdClsXIIRollNoTextPane.setFocusable(false);
		stdClsXIIRollNoTextPane.setEditable(false);
		stdClsXIIRollNo = new JFormattedTextField(DIGITS_ROLL);
		stdClsXIIRollNo.setBounds(110, 205, 130, 20);
		stdClsXIIRollNo.setColumns(10);

		stdClsXIIPassingYrTextPane = new JTextPane();
		stdClsXIIPassingYrTextPane.setBounds(270, 205, 90, 20);
		stdClsXIIPassingYrTextPane.setBackground(bgColor);
		stdClsXIIPassingYrTextPane.setText("Middle Name");
		stdClsXIIPassingYrTextPane.setFocusable(false);
		stdClsXIIPassingYrTextPane.setEditable(false);
		stdClsXIIPassingYr = new JComboBox(passingYrChoice);
		stdClsXIIPassingYr.setBounds(360, 205, 130, 20);

		stdClsXIISchoolNameTextPane = new JTextPane();
		stdClsXIISchoolNameTextPane.setBounds(520, 205, 80, 20);
		stdClsXIISchoolNameTextPane.setBackground(bgColor);
		stdClsXIISchoolNameTextPane.setText("Last Name");
		stdClsXIISchoolNameTextPane.setFocusable(false);
		stdClsXIISchoolNameTextPane.setEditable(false);
		stdClsXIISchoolName = new JTextField();
		stdClsXIISchoolName.setColumns(10);
		stdClsXIISchoolName.setBounds(610, 205, 130, 20);

		// Second Row
		stdClsXIIBoardTextPane = new JTextPane();
		stdClsXIIBoardTextPane.setBounds(20, 245, 80, 20);
		stdClsXIIBoardTextPane.setBackground(bgColor);
		stdClsXIIBoardTextPane.setText("Mobile");
		stdClsXIIBoardTextPane.setFocusable(false);
		stdClsXIIBoardTextPane.setEditable(false);
		stdClsXIIBoard = new JComboBox(RegisterUtilityFunctions.getBoard());
		stdClsXIIBoard.setBounds(110, 245, 130, 20);

		stdClsXIIMediumTextPane = new JTextPane();
		stdClsXIIMediumTextPane.setBounds(270, 245, 80, 20);
		stdClsXIIMediumTextPane.setBackground(bgColor);
		stdClsXIIMediumTextPane.setText("Occupation");
		stdClsXIIMediumTextPane.setFocusable(false);
		stdClsXIIMediumTextPane.setEditable(false);
		stdClsXIIMedium = new JComboBox(RegisterUtilityFunctions.getMedium());
		stdClsXIIMedium.setBounds(360, 245, 130, 20);

		stdClsXIIPercnetageTextPane = new JTextPane();
		stdClsXIIPercnetageTextPane.setBounds(520, 245, 80, 20);
		stdClsXIIPercnetageTextPane.setBackground(bgColor);
		stdClsXIIPercnetageTextPane.setText("E-Mail");
		stdClsXIIPercnetageTextPane.setFocusable(false);
		stdClsXIIPercnetageTextPane.setEditable(false);
		stdClsXIIPercnetage = new JFormattedTextField(returnFormatter(DIGITS_PER));
		stdClsXIIPercnetage.setColumns(10);
		stdClsXIIPercnetage.setBounds(610, 245, 130, 20);
	}
	
	private void initListeners()
	{
		
	}
	
	private void initializeFrame()
	{
		compStudentReg2 = new JFrame("Student Registration Finalize");
		compStudentReg2.setBounds(framex, framey, frameLength, frameheigth);
		compStudentReg2.setBackground(bgColor);
		compStudentReg2.getContentPane().setLayout(null);
	}
	
	private NumberFormatter returnFormatter(int maxallowed)
	{
		NumberFormat longFormat = NumberFormat.getIntegerInstance(Locale.getDefault());
		longFormat.setGroupingUsed(false);
		longFormat.setMaximumFractionDigits(0);
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setMaximum(9999999999l);
		numberFormatter.setAllowsInvalid(false);
		
		return numberFormatter;
	}
}
