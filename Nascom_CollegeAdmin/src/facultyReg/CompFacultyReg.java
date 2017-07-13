package facultyReg;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;
import javax.swing.JFrame;

import java.sql.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import extendedClasses.DateLabelFormatter;
import extraClasses.CityReadFromFile;
import extraClasses.ImageFunctions;
import extraClasses.StatesReadFromFile;
import facultyReg.CompFacultyReg1;
import memberGUI.admin.MainGUI;

import javax.swing.JCheckBox;
//import java.awt.Font;
import java.awt.event.ActionListener;
//import java.text.NumberFormat;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import beanClasses.FacultyUser;
import beanClasses.User;


public class CompFacultyReg
{
	private final static int PIN_CODE_LENGTH = 6;
	private final static long PIN_CODE = 999999l;
	private final static long MOB_DIGIT = 9999999999l;
	private final static long Aadhar_Number = 999999999999l;
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 800;
	private static final int frameheigth = 500;
	private static final String[] defaultCity = {"Select State First"};
	private Color bgColor;
	
	private FacultyUser user;
	
	public JFrame compFacultyReg;
	
	// Components Declaration.
	// Section 1.
	private JTextPane section1Header;
	private JSeparator section1Separator;
	private JTextField facFirstName;
	private JTextField facMiddelName;
	private JTextField facLastName;
	private SqlDateModel facDOBDateModel;
	private JDatePanelImpl facDOBDatePickerPanel;
	private JDatePickerImpl facDOB;
	@SuppressWarnings("rawtypes")
	private JComboBox facGender;
	private JTextField facEmail;
	private JFormattedTextField facMobNo;
	private JFormattedTextField facAadharNumber;
	private JTextField facImagePathView;
	private JButton facImageBrowse;
	private JTextPane facFirstNameTextPane;
	private JTextPane facMiddleNameTextPane;
	private JTextPane facLastNameTextPane;
	private JTextPane facDOBTextPane;
	private JTextPane facGenderTextPane;
	private JTextPane facEmailTextPane;
	private JTextPane facMobNoTextPane;
	private JTextPane facAadhar_numberTextPane;
	private JTextPane facImageTextPane;
	// Section 2.
	private JTextPane section2Header;
	private JSeparator section2Separator;
	@SuppressWarnings("rawtypes")
	private JComboBox facAddState;
	@SuppressWarnings("rawtypes")
	private JComboBox facAddCity;
	private JFormattedTextField facAddPincode;
	private JTextField facAddHome;
	private JTextPane facAddStateTextPane;
	private JTextPane facAddCityTextPane;
	private JTextPane facAddPincodeTextPane;
	private JTextPane facAddHomeTextPane;
	// Section 3.
	private JTextPane section3Header;
	private JCheckBox facCorespChoice;
	private JSeparator section3Separator;
	@SuppressWarnings("rawtypes")
	private JComboBox facCorespAddState;
	@SuppressWarnings("rawtypes")
	private JComboBox facCorespAddCity;
	private JFormattedTextField facCorespAddPincode;
	private JTextField facCorespAddHome;
	private JTextPane facCorespAddStateTextPane;
	private JTextPane facCorespAddCityTextPane;
	private JTextPane facCorespAddPincodeTextPane;
	private JTextPane facCorespAddHomeTextPane;
	
	// Continue Button.
	private JButton facRegNextFrame;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public CompFacultyReg(User registerUser)
	{
		user = new FacultyUser();
		user.setUserName(registerUser.getUserName());
		user.setUserType(registerUser.getUserType());
		user.setPassword(registerUser.getPassword());
		user.setBranch(registerUser.getBranch());
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		initListeners();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		//Section 1.
		compFacultyReg.getContentPane().add(section1Header);
		compFacultyReg.getContentPane().add(section1Separator);
		compFacultyReg.getContentPane().add(facFirstNameTextPane);
		compFacultyReg.getContentPane().add(facFirstName);
		compFacultyReg.getContentPane().add(facMiddleNameTextPane);
		compFacultyReg.getContentPane().add(facMiddelName);
		compFacultyReg.getContentPane().add(facLastNameTextPane);
		compFacultyReg.getContentPane().add(facLastName);
		compFacultyReg.getContentPane().add(facDOBTextPane);
		compFacultyReg.getContentPane().add(facDOB);
		compFacultyReg.getContentPane().add(facGenderTextPane);
		compFacultyReg.getContentPane().add(facGender);
		compFacultyReg.getContentPane().add(facEmailTextPane);
		compFacultyReg.getContentPane().add(facEmail);
		compFacultyReg.getContentPane().add(facMobNoTextPane);
		compFacultyReg.getContentPane().add(facMobNo);
		compFacultyReg.getContentPane().add(facAadharNumber);
		compFacultyReg.getContentPane().add(facAadhar_numberTextPane);
		compFacultyReg.getContentPane().add(facImageTextPane);
		compFacultyReg.getContentPane().add(facImagePathView);
		compFacultyReg.getContentPane().add(facImageBrowse);
		//Section 2.
		compFacultyReg.getContentPane().add(section2Header);
		compFacultyReg.getContentPane().add(section2Separator);
		compFacultyReg.getContentPane().add(facAddStateTextPane);
		compFacultyReg.getContentPane().add(facAddState);
		compFacultyReg.getContentPane().add(facAddCityTextPane);
		compFacultyReg.getContentPane().add(facAddCity);
		compFacultyReg.getContentPane().add(facAddPincodeTextPane);
		compFacultyReg.getContentPane().add(facAddPincode);
		compFacultyReg.getContentPane().add(facAddHomeTextPane);
		compFacultyReg.getContentPane().add(facAddHome);
		//Section 3.
		compFacultyReg.getContentPane().add(section3Header);
		compFacultyReg.getContentPane().add(facCorespChoice);
		compFacultyReg.getContentPane().add(section3Separator);
		compFacultyReg.getContentPane().add(facCorespAddStateTextPane);
		compFacultyReg.getContentPane().add(facCorespAddState);
		compFacultyReg.getContentPane().add(facCorespAddCityTextPane);
		compFacultyReg.getContentPane().add(facCorespAddCity);
		compFacultyReg.getContentPane().add(facCorespAddPincodeTextPane);
		compFacultyReg.getContentPane().add(facCorespAddPincode);
		compFacultyReg.getContentPane().add(facCorespAddHomeTextPane);
		compFacultyReg.getContentPane().add(facCorespAddHome);
		
		compFacultyReg.getContentPane().add(facRegNextFrame);
		compFacultyReg.getRootPane().setDefaultButton(facRegNextFrame);

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
		facFirstNameTextPane = new JTextPane();
		facFirstNameTextPane.setBounds(20, 60, 80, 20);
		facFirstNameTextPane.setBackground(bgColor);
		facFirstNameTextPane.setText("First Name");
		facFirstNameTextPane.setFocusable(false);
		facFirstNameTextPane.setEditable(false);
		facFirstName = new JTextField();
		facFirstName.setBounds(110, 60, 130, 20);
		
		facMiddleNameTextPane = new JTextPane();
		facMiddleNameTextPane.setBounds(270, 60, 90, 20);
		facMiddleNameTextPane.setBackground(bgColor);
		facMiddleNameTextPane.setText("Middle Name");
		facMiddleNameTextPane.setFocusable(false);
		facMiddleNameTextPane.setEditable(false);
		facMiddelName = new JTextField();
		facMiddelName.setBounds(360, 60, 130, 20);

		facLastNameTextPane = new JTextPane();
		facLastNameTextPane.setBounds(520, 60, 80, 20);
		facLastNameTextPane.setBackground(bgColor);
		facLastNameTextPane.setText("Last Name");
		facLastNameTextPane.setFocusable(false);
		facLastNameTextPane.setEditable(false);
		facLastName = new JTextField();
		facLastName.setBounds(610, 60, 130, 20);
		
		// Second Row
		facDOBTextPane = new JTextPane();
		facDOBTextPane.setBounds(20, 100, 80, 20);
		facDOBTextPane.setBackground(bgColor);
		facDOBTextPane.setText("DOB");
		facDOBTextPane.setFocusable(false);
		facDOBTextPane.setEditable(false);
		facDOBDateModel = new SqlDateModel();
		Properties datePanelProperties = new Properties();
		datePanelProperties.put("text.today", "Today");
		datePanelProperties.put("text.month", "Month");
		datePanelProperties.put("text.year", "Year");
		facDOBDatePickerPanel = new JDatePanelImpl(facDOBDateModel, datePanelProperties);
		facDOB = new JDatePickerImpl(facDOBDatePickerPanel, new DateLabelFormatter() );
		facDOB.setBounds(110, 100, 130, 25);
		
		facGenderTextPane = new JTextPane();
		facGenderTextPane.setBounds(270, 100, 80, 20);
		facGenderTextPane.setBackground(bgColor);
		facGenderTextPane.setText("Gender");
		facGenderTextPane.setFocusable(false);
		facGenderTextPane.setEditable(false);
		String[] facGenderChoices = {"Select","Female","Male", "Other"};
		facGender = new JComboBox(facGenderChoices);
		facGender.setBounds(360, 100, 130, 20);

		facEmailTextPane = new JTextPane();
		facEmailTextPane.setBounds(520, 100, 80, 20);
		facEmailTextPane.setBackground(bgColor);
		facEmailTextPane.setText("E-Mail");
		facEmailTextPane.setFocusable(false);
		facEmailTextPane.setEditable(false);
		facEmail = new JTextField();
		facEmail.setBounds(610, 100, 130, 20);
		
		// Third Row.
		facMobNoTextPane = new JTextPane();
		facMobNoTextPane.setBounds(20, 140, 80, 20);
		facMobNoTextPane.setBackground(bgColor);
		facMobNoTextPane.setText("Moblie");
		facMobNoTextPane.setFocusable(false);
		facMobNoTextPane.setEditable(false);
		facMobNo = new JFormattedTextField(returnFormatter(MOB_DIGIT));
		facMobNo.setBounds(110, 140, 130, 20);

		facAadhar_numberTextPane = new JTextPane();
		facAadhar_numberTextPane.setBounds(270, 140, 180, 20);
		facAadhar_numberTextPane.setBackground(bgColor);
		facAadhar_numberTextPane.setText("Aadhar No.");//set the size so as to accept 12 digits in aadhar 
		facAadhar_numberTextPane.setFocusable(false);
		facAadhar_numberTextPane.setEditable(false);
		facAadharNumber = new JFormattedTextField(returnFormatter(Aadhar_Number));
		facAadharNumber.setInheritsPopupMenu(true);
		facAadharNumber.setBounds(360, 140, 130, 20);
		
		facImageTextPane = new JTextPane();
		facImageTextPane.setBounds(520, 140, 80, 20);
		facImageTextPane.setBackground(bgColor);
		facImageTextPane.setText("Image");
		facImageTextPane.setFocusable(false);
		facImageTextPane.setEditable(false);
		facImagePathView = new JTextField();
		facImagePathView.setEditable(false);
		facImagePathView.setFocusable(false);
		facImagePathView.setBounds(610, 140, 110, 20);
		facImageBrowse = new JButton("...");
		facImageBrowse.setBounds(718, 140, 20, 20);
		
		
		//////////////////////////////////////////////////////////////////
		//////////////////////SECOND SECTION//////////////////////////////
		//////////////////////////////////////////////////////////////////
		section2Header = new JTextPane();
		section2Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section2Header.setBounds(20, 180, 250, 20);
		section2Header.setBackground(bgColor);
		section2Header.setText("Permanent Address Details");
		section2Header.setFocusable(false);
		section2Header.setEditable(false);
		section2Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section2Separator.setBounds(0, 192, frameLength, 2);
		// First Row
		facAddStateTextPane = new JTextPane();
		facAddStateTextPane.setBounds(20, 215, 80, 20);
		facAddStateTextPane.setBackground(bgColor);
		facAddStateTextPane.setText("State");
		facAddStateTextPane.setFocusable(false);
		facAddStateTextPane.setEditable(false);
		String[] facAddStatesChoices = StatesReadFromFile.getStates();
		facAddState = new JComboBox(facAddStatesChoices);
		facAddState.setBounds(110, 215, 130, 20);
		
		facAddCityTextPane = new JTextPane();
		facAddCityTextPane.setBounds(270, 215, 90, 20);
		facAddCityTextPane.setBackground(bgColor);
		facAddCityTextPane.setText("City");
		facAddCityTextPane.setFocusable(false);
		facAddCityTextPane.setEditable(false);
		facAddCity = new JComboBox(defaultCity);
		facAddCity.setBounds(360, 215, 130, 20);

		facAddPincodeTextPane = new JTextPane();
		facAddPincodeTextPane.setBounds(520, 215, 80, 20);
		facAddPincodeTextPane.setBackground(bgColor);
		facAddPincodeTextPane.setText("Pin Code");
		facAddPincodeTextPane.setFocusable(false);
		facAddPincodeTextPane.setEditable(false);
		facAddPincode = new JFormattedTextField(returnFormatter(PIN_CODE));
		facAddPincode.setBounds(610, 215, 130, 20);
		
		// Second Row
		facAddHomeTextPane = new JTextPane();
		facAddHomeTextPane.setBounds(20, 255, 80, 20);
		facAddHomeTextPane.setBackground(bgColor);
		facAddHomeTextPane.setText("Address");
		facAddHomeTextPane.setFocusable(false);
		facAddHomeTextPane.setEditable(false);
		facAddHome = new JTextField();
		facAddHome.setBounds(110, 255, 300, 20);
		
		//////////////////////////////////////////////////////////////////
		//////////////////////THIRD SECTION//////////////////////////////
		//////////////////////////////////////////////////////////////////
		section3Header = new JTextPane();
		section3Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section3Header.setBounds(20, 295, 300, 25);
		section3Header.setBackground(bgColor);
		section3Header.setText("Correspondence Address Details");
		section3Header.setFocusable(false);
		section3Header.setEditable(false);
		facCorespChoice = new JCheckBox("Same as Above");
		facCorespChoice.setBounds(500, 295, 140, 20);
		section3Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section3Separator.setBounds(0, 307, frameLength, 2);
		// First Row
		facCorespAddStateTextPane = new JTextPane();
		facCorespAddStateTextPane.setBounds(20, 330, 80, 20);
		facCorespAddStateTextPane.setBackground(bgColor);
		facCorespAddStateTextPane.setText("State");
		facCorespAddStateTextPane.setFocusable(false);
		facCorespAddStateTextPane.setEditable(false);
		facCorespAddState = new JComboBox(facAddStatesChoices);
		facCorespAddState.setBounds(110, 330, 130, 20);
		
		facCorespAddCityTextPane = new JTextPane();
		facCorespAddCityTextPane.setBounds(270, 330, 90, 20);
		facCorespAddCityTextPane.setBackground(bgColor);
		facCorespAddCityTextPane.setText("City");
		facCorespAddCityTextPane.setFocusable(false);
		facCorespAddCityTextPane.setEditable(false);
		facCorespAddCity = new JComboBox(defaultCity);
		facCorespAddCity.setBounds(360, 330, 130, 20);

		facCorespAddPincodeTextPane = new JTextPane();
		facCorespAddPincodeTextPane.setBounds(520, 330, 80, 20);
		facCorespAddPincodeTextPane.setBackground(bgColor);
		facCorespAddPincodeTextPane.setText("Pin Code");
		facCorespAddPincodeTextPane.setFocusable(false);
		facCorespAddPincodeTextPane.setEditable(false);
		facCorespAddPincode = new JFormattedTextField(returnFormatter(PIN_CODE));
		facCorespAddPincode.setBounds(610, 330, 130, 20);
		
		// Second Row
		facCorespAddHomeTextPane = new JTextPane();
		facCorespAddHomeTextPane.setBounds(20, 370, 80, 20);
		facCorespAddHomeTextPane.setBackground(bgColor);
		facCorespAddHomeTextPane.setText("Address");
		facCorespAddHomeTextPane.setFocusable(false);
		facCorespAddHomeTextPane.setEditable(false);
		facCorespAddHome = new JTextField();
		facCorespAddHome.setBounds(110, 370, 300, 20);
		
		
		facRegNextFrame = new JButton("Continue");
		facRegNextFrame.setBounds(((frameLength/2)-60), 432, 120, 25);
	}
	
	private void initListeners()
	{
		//////////////////////////////////////////////////////////////////////
		//////////////////////////////Listner's///////////////////////////////
		//////////////////////////////////////////////////////////////////////
		facCorespChoice.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if( facCorespChoice.isSelected() )
				{
					facCorespAddState.setEnabled(false);
					facCorespAddCity.setEnabled(false);
					facCorespAddHome.setEnabled(false);
					facCorespAddPincode.setEnabled(false);
					
					facCorespAddState.setSelectedIndex(facAddState.getSelectedIndex());
					facCorespAddCity.setSelectedIndex(facAddCity.getSelectedIndex());
					facCorespAddHome.setText(facAddHome.getText());
					facCorespAddPincode.setText(facAddPincode.getText());
				}
				else
				{
					facCorespAddState.setSelectedIndex(0);
					facCorespAddCity.setSelectedItem(0);
					facCorespAddHome.setText(null);
					facCorespAddPincode.setText(null);
					
					facCorespAddCity.setEnabled(true);
					facCorespAddHome.setEnabled(true);
					facCorespAddPincode.setEnabled(true);
					facCorespAddState.setEnabled(true);
				}
			}
		});
		
		facMobNo.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE )
				{
					if( facMobNo.getText().length() == 1 )
					{
						facMobNo.setText("0");
					}
				}
			}
		});
		facAddPincode.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE )
				{
					if( facAddPincode.getText().length() == 1 )
					{
						facAddPincode.setText("0");
					}
				}
			}
		});
		facCorespAddPincode.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE )
				{
					if( facCorespAddPincode.getText().length() == 1 )
					{
						facCorespAddPincode.setText("0");
					}
				}
			}
		});

		facAddState.addActionListener(new ActionListener()
		{
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent arg0)
			{
				if( facAddState.getSelectedIndex() != 0 )
				{
					facAddCity.setModel( new DefaultComboBoxModel( 
							CityReadFromFile.getCities((String)facAddState.getSelectedItem()) ));
				}
				else
				{
					facAddCity.setModel( new DefaultComboBoxModel(defaultCity) );
				}
			}
		});
		facCorespAddState.addActionListener(new ActionListener()
		{
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public void actionPerformed(ActionEvent arg0)
			{
				if( facCorespAddState.getSelectedIndex() != 0 )
				{
					facCorespAddCity.setModel( new DefaultComboBoxModel( 
							CityReadFromFile.getCities((String)facCorespAddState.getSelectedItem()) ));
				}
				else
				{
					facCorespAddCity.setModel( new DefaultComboBoxModel(defaultCity) );
				}
			}
		});
		
		// Browse Image.
		facImageBrowse.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (e.getClickCount() == 1)
				{
					String imagePath = ImageFunctions.selectImage();
					if (ImageFunctions.validateSelectedImage(imagePath))
					{
						imagePath = ImageFunctions.saveImage(imagePath,user.getUserName());
						facImagePathView.setText(imagePath);
					}
					else
					{
						facImagePathView.setText(null);
						JOptionPane.showMessageDialog(compFacultyReg, "Invalid File.");
					}
				}
			}
		});

		// Button Registration Listener.
		facRegNextFrame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if( !checkFac() )
				{
					return;
				}
				if( !checkFacAdd() )
				{
					return;
				}
				if( !checkFacCorespAdd() )
				{
					return;
				}
				
				user.setfName(facFirstName.getText());
				user.setmName(facMiddelName.getText());
				user.setlName(facLastName.getText());
				user.setDob((Date)facDOB.getModel().getValue());
				user.setImgPath(facImagePathView.getText());
				user.setGender((String)facGender.getSelectedItem());
				user.seteMail(facEmail.getText());
				user.setMobNo(Long.parseLong(facMobNo.getText()));
				user.setAadhar(Long.parseLong(facAadharNumber.getText()));
				user.setState((String)facAddState.getSelectedItem());
				user.setCity((String)facAddCity.getSelectedItem());
				user.setPinCode(Integer.parseInt(facAddPincode.getText()));
				user.setAdd(facAddHome.getText());
				user.setCorespAddFlag(facCorespChoice.isSelected());
				user.setCorespState((String)facCorespAddState.getSelectedItem());
				user.setCorespCity((String)facCorespAddCity.getSelectedItem());
				user.setCorespPinCode(Integer.parseInt(facCorespAddPincode.getText()));
				user.setCorespAdd(facCorespAddHome.getText());
				
				CompFacultyReg1 reg = new CompFacultyReg1(user);
				reg.compFacultyReg1.setVisible(true);
				compFacultyReg.dispose();
			}
		});

	}
	
	private void initializeFrame()
	{
		compFacultyReg = new JFrame("Faculty Registration");
		compFacultyReg.setBounds(framex, framey, frameLength, frameheigth);
		compFacultyReg.setBackground(bgColor);
		compFacultyReg.getContentPane().setLayout(null);
		compFacultyReg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		compFacultyReg.setResizable(false);
		
		compFacultyReg.addWindowListener(new WindowAdapter()
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
		longFormat.setMaximumFractionDigits(0);
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setMaximum(maxallowed);
		numberFormatter.setAllowsInvalid(false);
		
		return numberFormatter;
	}

	private boolean checkFac()
	{
		Date selectedDate = (Date) facDOB.getModel().getValue();
		if( facFirstName.getText().equals("") || facLastName.getText().equals("") || 
				facGender.getSelectedIndex() == 0 || selectedDate == null ||
				facEmail.getText().equals("") || facMobNo.getText().equals("") )
		{
			JOptionPane.showMessageDialog(null, "Complete Personal Details");
			return false;
		}
		if( facMobNo.getText().length() != 10 )
		{
			JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
			return false;
		}
		return true;
	}
	
	private boolean checkFacAdd()
	{
		if( facAddState.getSelectedIndex() == 0 || facAddCity.getSelectedIndex() == 0 ||
				facAddHome.getText().equals("") || facAddPincode.getText().equals("") )
		{
			JOptionPane.showMessageDialog(null, "Complete Postal Details");
			return false;
		}
		if( facAddPincode.getText().length() != PIN_CODE_LENGTH )
		{
			JOptionPane.showMessageDialog(null, "Invalid Pin Code");
			return false;
		}
		return true;
	}
	
	private boolean checkFacCorespAdd()
	{
		if( facCorespAddState.getSelectedIndex() == 0 || facCorespAddCity.getSelectedIndex() == 0 ||
				facCorespAddHome.getText().equals("") || facCorespAddPincode.getText().equals("") )
		{
			JOptionPane.showMessageDialog(null, "Complete Correspondence Postal Details");
			return false;
		}
		if( facCorespAddPincode.getText().length() != PIN_CODE_LENGTH )
		{
			JOptionPane.showMessageDialog(null, "Invalid Pin Code");
			return false;
		}
		return true;
	}
}
