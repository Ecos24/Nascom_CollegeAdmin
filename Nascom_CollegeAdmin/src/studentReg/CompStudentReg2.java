package studentReg;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import beanClasses.StudentUser;
import extraClasses.GUIRegisterUtilityFunctions;
import memberGUI.admin.MainGUI;
import userRegLog.RegisterUser;

public class CompStudentReg2
{
	private StudentUser user;
	
	private final static long DIGITS_ROLL = 9999999l;
	private final static long DIGITS_PER = 100l;
	private static final int framex = 0;
	private static final int framey = 0;
	private static final int frameLength = 800;
	private static final int frameheigth = 400;
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
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				CompStudentReg2 window = new CompStudentReg2(null);
				window.compStudentReg2.setVisible(true);
			}
		});
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public CompStudentReg2( StudentUser user)
	{
		this.user = user;
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

		compStudentReg2.setResizable(false);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents()
	{
		//////////////////////////////////////////////////////////////////
		////////////////////// FOURTH SECTION/////////////////////////////
		//////////////////////////////////////////////////////////////////
		section5Header = new JTextPane();
		section5Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section5Header.setBounds(20, 30, 180, 20);
		section5Header.setBackground(bgColor);
		section5Header.setText("Educational Details");
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
		stdClsXRollNoTextPane.setText("Roll No.");
		stdClsXRollNoTextPane.setFocusable(false);
		stdClsXRollNoTextPane.setEditable(false);
		stdClsXRollNo = new JTextField();
		stdClsXRollNo.setBounds(110, 93, 130, 20);

		stdClsXPassingYrTextPane = new JTextPane();
		stdClsXPassingYrTextPane.setBounds(270, 93, 90, 20);
		stdClsXPassingYrTextPane.setBackground(bgColor);
		stdClsXPassingYrTextPane.setText("Passing Year");
		stdClsXPassingYrTextPane.setFocusable(false);
		stdClsXPassingYrTextPane.setEditable(false);
		stdClsXPassingYr = new JComboBox(GUIRegisterUtilityFunctions.getPassingYr());
		stdClsXPassingYr.setBounds(360, 93, 130, 20);

		stdClsXSchoolNameTextPane = new JTextPane();
		stdClsXSchoolNameTextPane.setBounds(520, 93, 80, 20);
		stdClsXSchoolNameTextPane.setBackground(bgColor);
		stdClsXSchoolNameTextPane.setText("School Name");
		stdClsXSchoolNameTextPane.setFocusable(false);
		stdClsXSchoolNameTextPane.setEditable(false);
		stdClsXSchoolName = new JTextField();
		stdClsXSchoolName.setColumns(10);
		stdClsXSchoolName.setBounds(610, 93, 130, 20);

		// Second Row
		stdClsXBoardTextPane = new JTextPane();
		stdClsXBoardTextPane.setBounds(20, 133, 80, 20);
		stdClsXBoardTextPane.setBackground(bgColor);
		stdClsXBoardTextPane.setText("Board");
		stdClsXBoardTextPane.setFocusable(false);
		stdClsXBoardTextPane.setEditable(false);
		stdClsXBoard = new JComboBox(GUIRegisterUtilityFunctions.getBoard());
		stdClsXBoard.setBounds(110, 133, 130, 20);

		stdClsXMediumStudyTextPane = new JTextPane();
		stdClsXMediumStudyTextPane.setBounds(270, 133, 80, 20);
		stdClsXMediumStudyTextPane.setBackground(bgColor);
		stdClsXMediumStudyTextPane.setText("Medium");
		stdClsXMediumStudyTextPane.setFocusable(false);
		stdClsXMediumStudyTextPane.setEditable(false);
		stdClsXMediumStudy = new JComboBox(GUIRegisterUtilityFunctions.getMedium());
		stdClsXMediumStudy.setBounds(360, 133, 130, 20);

		stdClsXPercnetageTextPane = new JTextPane();
		stdClsXPercnetageTextPane.setBounds(520, 133, 80, 20);
		stdClsXPercnetageTextPane.setBackground(bgColor);
		stdClsXPercnetageTextPane.setText("Percentage");
		stdClsXPercnetageTextPane.setFocusable(false);
		stdClsXPercnetageTextPane.setEditable(false);
		stdClsXPercnetage = new JFormattedTextField(returnFormatter(DIGITS_PER));
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
		stdClsXIIRollNoTextPane.setText("Roll No.");
		stdClsXIIRollNoTextPane.setFocusable(false);
		stdClsXIIRollNoTextPane.setEditable(false);
		stdClsXIIRollNo = new JFormattedTextField(returnFormatter(DIGITS_ROLL));
		stdClsXIIRollNo.setBounds(110, 205, 130, 20);

		stdClsXIIPassingYrTextPane = new JTextPane();
		stdClsXIIPassingYrTextPane.setBounds(270, 205, 90, 20);
		stdClsXIIPassingYrTextPane.setBackground(bgColor);
		stdClsXIIPassingYrTextPane.setText("Passing Year");
		stdClsXIIPassingYrTextPane.setFocusable(false);
		stdClsXIIPassingYrTextPane.setEditable(false);
		stdClsXIIPassingYr = new JComboBox(GUIRegisterUtilityFunctions.getPassingYr());
		stdClsXIIPassingYr.setBounds(360, 205, 130, 20);

		stdClsXIISchoolNameTextPane = new JTextPane();
		stdClsXIISchoolNameTextPane.setBounds(520, 205, 80, 20);
		stdClsXIISchoolNameTextPane.setBackground(bgColor);
		stdClsXIISchoolNameTextPane.setText("School Name");
		stdClsXIISchoolNameTextPane.setFocusable(false);
		stdClsXIISchoolNameTextPane.setEditable(false);
		stdClsXIISchoolName = new JTextField();
		stdClsXIISchoolName.setBounds(610, 205, 130, 20);

		// Second Row
		stdClsXIIBoardTextPane = new JTextPane();
		stdClsXIIBoardTextPane.setBounds(20, 245, 80, 20);
		stdClsXIIBoardTextPane.setBackground(bgColor);
		stdClsXIIBoardTextPane.setText("Board");
		stdClsXIIBoardTextPane.setFocusable(false);
		stdClsXIIBoardTextPane.setEditable(false);
		stdClsXIIBoard = new JComboBox(GUIRegisterUtilityFunctions.getBoard());
		stdClsXIIBoard.setBounds(110, 245, 130, 20);

		stdClsXIIMediumTextPane = new JTextPane();
		stdClsXIIMediumTextPane.setBounds(270, 245, 80, 20);
		stdClsXIIMediumTextPane.setBackground(bgColor);
		stdClsXIIMediumTextPane.setText("Medium Of Study");
		stdClsXIIMediumTextPane.setFocusable(false);
		stdClsXIIMediumTextPane.setEditable(false);
		stdClsXIIMedium = new JComboBox(GUIRegisterUtilityFunctions.getMedium());
		stdClsXIIMedium.setBounds(360, 245, 130, 20);

		stdClsXIIPercnetageTextPane = new JTextPane();
		stdClsXIIPercnetageTextPane.setBounds(520, 245, 80, 20);
		stdClsXIIPercnetageTextPane.setBackground(bgColor);
		stdClsXIIPercnetageTextPane.setText("Percentage");
		stdClsXIIPercnetageTextPane.setFocusable(false);
		stdClsXIIPercnetageTextPane.setEditable(false);
		stdClsXIIPercnetage = new JFormattedTextField(returnFormatter(DIGITS_PER));
		stdClsXIIPercnetage.setBounds(610, 245, 130, 20);
		
		
		stdRegSubmit = new JButton("Register");
		stdRegSubmit.setBounds(((frameLength/2)-60), frameheigth - 70, 120, 25);
	}
	
	private void initListeners()
	{
		// Main Button Listener.
		stdRegSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if( !checkX() )
				{
					return;
				}
				if( !checkXII() )
				{
					return;
				}
				
				user.setClsXRollNo(stdClsXRollNo.getText());
				user.setClsXPassingYr(Integer.parseInt((String)stdClsXPassingYr.getSelectedItem()));
				user.setClsXSchool(stdClsXSchoolName.getText());
				user.setClsXBoard( (String)stdClsXBoard.getSelectedItem());
				user.setClsXMedium((String)stdClsXMediumStudy.getSelectedItem());
				user.setClsXPercentage(Float.parseFloat(stdClsXPercnetage.getText()));
				user.setClsXIIRollNo(Long.parseLong(stdClsXIIRollNo.getText()));
				user.setClsXIIPassingYr(Integer.parseInt((String)stdClsXIIPassingYr.getSelectedItem()));
				user.setClsXIISchool(stdClsXIISchoolName.getText());
				user.setClsXIIBoard( (String)stdClsXIIBoard.getSelectedItem());
				user.setClsXIIMedium((String)stdClsXIIMedium.getSelectedItem());
				user.setClsXIIPercentage(Float.parseFloat(stdClsXIIPercnetage.getText()));
				// Entry to DB Logic
                try
                {
                	if( RegisterUser.registerStudentUser(user) )
                	{
	                    System.out.println("User Registered");
	                	JOptionPane.showMessageDialog(null, "User Registered");
	                }
	                else
	                {
	                	JOptionPane.showMessageDialog(null, "User Not Registered");
	                }
                }
                catch(ClassNotFoundException e)
                {
                	System.out.println("JDBC connector Class Not Found.");
                	JOptionPane.showMessageDialog(compStudentReg2, "User Not Registered Internal Application Error!!");
				}
                catch(SQLException e)
                {                	
                	System.out.println("Exception --> "+e.getMessage());
                	JOptionPane.showMessageDialog(compStudentReg2, "User Not Registered Internal Application Error!!");
				}
                
                // Redirect to Admin UI.
                MainGUI admin = new MainGUI();
                admin.adminMainGUI.setVisible(true);
                compStudentReg2.dispose();
			}
		});
		
		stdClsXIIRollNo.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE )
				{
					if( stdClsXIIRollNo.getText().length() == 1 )
					{
						stdClsXIIRollNo.setText("0");
					}
				}
			}
		});
		stdClsXIIPercnetage.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE )
				{
					if( stdClsXIIPercnetage.getText().length() == 1 )
					{
						stdClsXIIPercnetage.setText("0");
					}
				}
			}
		});
		stdClsXPercnetage.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE )
				{
					if( stdClsXPercnetage.getText().length() == 1 )
					{
						stdClsXPercnetage.setText("0");
					}
				}
			}
		});
	}

	private void initializeFrame()
	{
		compStudentReg2 = new JFrame("Student Registration Finalize");
		compStudentReg2.setBounds(framex, framey, frameLength, frameheigth);
		compStudentReg2.setBackground(bgColor);
		compStudentReg2.getContentPane().setLayout(null);
		compStudentReg2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		compStudentReg2.addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e)
				{
					MainGUI admin = new MainGUI();
					admin.adminMainGUI.setVisible(true);
					super.windowClosing(e);
				}
				
			});
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////Utility Function's//////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	private NumberFormatter returnFormatter(long maxallowed)
	{
		NumberFormat longFormat = NumberFormat.getIntegerInstance(Locale.getDefault());
		longFormat.setGroupingUsed(false);
		longFormat.setMaximumFractionDigits(2);
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		//numberFormatter.setValueClass(Integer.class);
		numberFormatter.setMaximum(maxallowed);
		numberFormatter.setAllowsInvalid(false);
		
		return numberFormatter;
	}

	private boolean checkX()
	{
		boolean checkFlag = true;
		GUIRegisterUtilityFunctions errorUtility = new GUIRegisterUtilityFunctions();
		
		if( stdClsXRollNo.getText().equals("") || stdClsXPassingYr.getSelectedIndex() == 0 ||
				stdClsXSchoolName.getText().equals("") || stdClsXBoard.getSelectedIndex() == 0 ||
				stdClsXMediumStudy.getSelectedIndex() == 0 || stdClsXPercnetage.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Complete Class X Details.");
			return false;
		}
		if( stdClsXRollNo.getText().length() < 7 )
		{
			errorUtility.storeError("Invalid Class X Roll Number.");
			checkFlag = false;
		}
		if( Integer.parseInt(stdClsXPercnetage.getText()) > 100 || Integer.parseInt(stdClsXPercnetage.getText()) < 30 )
		{
			errorUtility.storeError("Invalid Class X percentage.");
			checkFlag = false;
		}
		if( checkFlag == false )
		{
			JOptionPane.showMessageDialog(null, errorUtility.getErrors());
			return false;
		}
		return true;
	}
	private boolean checkXII()
	{
		boolean checkFlag = true;
		GUIRegisterUtilityFunctions errorUtility = new GUIRegisterUtilityFunctions();
		
		if( stdClsXIIRollNo.getText().equals("") || stdClsXIIPassingYr.getSelectedIndex() == 0 ||
				stdClsXIISchoolName.getText().equals("") || stdClsXIIBoard.getSelectedIndex() == 0 ||
				stdClsXIIMedium.getSelectedIndex() == 0 || stdClsXIIPercnetage.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Complete Class XII Details");
			return false;
		}
		if( stdClsXIIRollNo.getText().length() != 7 )
		{
			errorUtility.storeError("Invalid Class XII Roll Number.");
			checkFlag = false;
		}
		if( stdClsXIIPassingYr.getSelectedIndex() < stdClsXPassingYr.getSelectedIndex()+2 )
		{
			errorUtility.storeError("Class XII passing year has to be greater then Class X's passing year.");
			checkFlag = false;
		}
		if( Integer.parseInt(stdClsXIIPercnetage.getText()) > 100 || Integer.parseInt(stdClsXIIPercnetage.getText()) < 30 )
		{
			errorUtility.storeError("Invalid Class XII percentage.");
			checkFlag = false;
		}
		if( checkFlag == false )
		{
			JOptionPane.showMessageDialog(null, errorUtility.getErrors());
			return false;
		}
		return true;
	}
}
