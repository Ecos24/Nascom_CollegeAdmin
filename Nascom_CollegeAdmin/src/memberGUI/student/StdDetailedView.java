package memberGUI.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import beanClasses.StudentUser;
import extraClasses.ImageFunctions;
import extraClasses.ReadStudentUser;

public class StdDetailedView
{
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 800;
	private static final int frameheigth = 550;
	private static String level;
	private Color bgColor;
	
	private String userid;
	
	public JFrame stdDetailedView;
	
	// Section 1.
	private JTextPane section1Header;
	private JSeparator section1Separator;
	private JTextField stdName;
	private JTextField stdFatherName;
	private JTextField stdMotherName;
	private JTextPane stdNameTextPane;
	private JTextPane stdFatherNameTextPane;
	private JTextPane stdMotherNameTextPane;
	private JTextPane stdDOBTextPane;
	private JTextField stdDOB;
	private JTextPane stdGenderTextPane;
	private JTextField stdGender;
	private JTextPane stdEmailTextPane;
	private JTextField stdEmail;
	private JTextPane stdMobNoTextPane;
	private JTextField stdMobNo;
	private JTextPane stdCategoryTextPane;
	private JTextField stdCategory;
	private JLabel imagePanel;
	// Section 2.
	private JTextPane section2Header;
	private JSeparator section2Seperator;
	private JTextPane stdAddHomeTextPane;
	private JTextField stdAddHome;
	private JTextPane stdAddStateTextPane;
	private JTextField stdAddState;
	private JTextPane stdAddCityTextPane;
	private JTextField stdAddCity;
	private JTextPane stdAddPincodeTextPane;
	private JTextField stdAddPincode;
	//Section 3.
	private JTextPane section3Header;
	private JSeparator section3Separator;
	private JTextPane stdClsXHeader;
	private JTextPane stdClsXPassingYrTextPane;
	private JTextField stdClsXPassingYr;
	private JTextPane stdClsXMediumTextPane;
	private JTextField stdClsXMedium;
	private JTextPane stdClsXPercentageTextPane;
	private JTextField stdClsXPercentage;
	private JTextPane stdClsXIIHeader;
	private JTextPane stdClsXIIPassingYrTextPane;
	private JTextField stdClsXIIPassingYr;
	private JTextPane stdClsXIIMediumTextPane;
	private JTextField stdClsXIIMedium;
	private JTextPane stdClsXIIPercentageTextPane;;
	private JTextField stdClsXIIPercentage;
	
	public StdDetailedView(String stdId, String className)
	{
		bgColor = new Color(238, 238, 238);
		userid = stdId; 
		initializeFrame();
		initComponents();
		initEditable();
		if( className.equals("memberGUI.student.MainStdGUI") )
			level = "student";
		else if( className.equals("memberGUI.admin.ViewAllStd"))
			level = "admin";
		else if( className.equals("memberGUI.faculty.ViewStd"))
			level = "faculty";
		initListeners();
		associateFrameComponents();
		populateView();
	}
	
	private void populateView()
	{
		StudentUser user;
		try
		{
			user = ReadStudentUser.readUser(userid);
			stdName.setText(user.getfName()+" "+user.getlName()+" "+user.getlName());
			stdFatherName.setText(user.getFatherName());
			stdMotherName.setText(user.getMotherName());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			stdGender.setText(user.getGender());
			stdEmail.setText(user.geteMail());
			stdDOB.setText(df.format(user.getDOB()));
			stdCategory.setText(user.getCategory());
			stdMobNo.setText(String.valueOf(user.getMobNo()));
			stdAddHome.setText(user.getAdd());
			stdAddCity.setText(user.getCity());
			stdAddPincode.setText(String.valueOf(user.getPinconde()));
			stdAddState.setText(user.getState());
			stdClsXMedium.setText(user.getClsXMedium());
			stdClsXPassingYr.setText(String.valueOf(user.getClsXPassingYr()));
			stdClsXPercentage.setText(String.valueOf(user.getClsXPercentage()));
			stdClsXIIMedium.setText(user.getClsXIIMedium());
			stdClsXIIPassingYr.setText(String.valueOf(user.getClsXIIPassingYr()));
			stdClsXIIPercentage.setText(String.valueOf(user.getClsXIIPercentage()));
			imagePanel.setIcon(ImageFunctions.resizeImage(user.getImagePath()));
		}
		catch(ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void associateFrameComponents()
	{
		// Section 1.
		stdDetailedView.getContentPane().add(section1Header);
		stdDetailedView.getContentPane().add(section1Separator);
		stdDetailedView.getContentPane().add(stdNameTextPane);
		stdDetailedView.getContentPane().add(stdName);
		stdDetailedView.getContentPane().add(stdFatherNameTextPane);
		stdDetailedView.getContentPane().add(stdFatherName);
		stdDetailedView.getContentPane().add(stdMotherNameTextPane);
		stdDetailedView.getContentPane().add(stdMotherName);
		stdDetailedView.getContentPane().add(stdDOBTextPane);
		stdDetailedView.getContentPane().add(stdDOB);
		stdDetailedView.getContentPane().add(stdGenderTextPane);
		stdDetailedView.getContentPane().add(stdGender);
		stdDetailedView.getContentPane().add(stdEmailTextPane);
		stdDetailedView.getContentPane().add(stdEmail);
		stdDetailedView.getContentPane().add(stdMobNoTextPane);
		stdDetailedView.getContentPane().add(stdMobNo);
		stdDetailedView.getContentPane().add(stdCategoryTextPane);
		stdDetailedView.getContentPane().add(stdCategory);
		stdDetailedView.getContentPane().add(imagePanel);

		// Section 2.
		stdDetailedView.getContentPane().add(section2Header);
		stdDetailedView.getContentPane().add(section2Seperator);
		stdDetailedView.getContentPane().add(stdAddStateTextPane);
		stdDetailedView.getContentPane().add(stdAddState);
		stdDetailedView.getContentPane().add(stdAddCityTextPane);
		stdDetailedView.getContentPane().add(stdAddCity);
		stdDetailedView.getContentPane().add(stdAddPincodeTextPane);
		stdDetailedView.getContentPane().add(stdAddPincode);
		stdDetailedView.getContentPane().add(stdAddHomeTextPane);
		stdDetailedView.getContentPane().add(stdAddHome);
		
		//Section 3.
		stdDetailedView.getContentPane().add(section3Header);
		stdDetailedView.getContentPane().add(section3Separator);
		stdDetailedView.getContentPane().add(stdClsXHeader);
		stdDetailedView.getContentPane().add(stdClsXPassingYrTextPane);
		stdDetailedView.getContentPane().add(stdClsXPassingYr);
		stdDetailedView.getContentPane().add(stdClsXMediumTextPane);
		stdDetailedView.getContentPane().add(stdClsXMedium);
		stdDetailedView.getContentPane().add(stdClsXPercentageTextPane);
		stdDetailedView.getContentPane().add(stdClsXPercentage);
		stdDetailedView.getContentPane().add(stdClsXIIHeader);
		stdDetailedView.getContentPane().add(stdClsXIIPassingYrTextPane);
		stdDetailedView.getContentPane().add(stdClsXIIPassingYr);
		stdDetailedView.getContentPane().add(stdClsXIIMediumTextPane);
		stdDetailedView.getContentPane().add(stdClsXIIMedium);
		stdDetailedView.getContentPane().add(stdClsXIIPercentageTextPane);
		stdDetailedView.getContentPane().add(stdClsXIIPercentage);


		stdDetailedView.setResizable(false);
	}
	
	private void initEditable()
	{
		stdName.setEditable(false);
		stdFatherName.setEditable(false);
		stdMotherName.setEditable(false);
		stdCategory.setEditable(false);
		stdDOB.setEditable(false);
		stdGender.setEditable(false);
		stdEmail.setEditable(false);
		stdMobNo.setEditable(false);
		//Section 2.
		stdAddHome.setEditable(false);
		stdAddState.setEditable(false);
		stdAddCity.setEditable(false);
		stdAddPincode.setEditable(false);
		//Section 3.
		stdClsXPassingYr.setEditable(false);
		stdClsXMedium.setEditable(false);
		stdClsXPercentage.setEditable(false);
		stdClsXIIPassingYr.setEditable(false);
		stdClsXIIMedium.setEditable(false);
		stdClsXIIPercentage.setEditable(false);
	}
	
	private void initComponents()
	{
		//////////////////////////////////////////////////////////////////
		////////////////////// FIRST SECTION///////////////////////////////
		//////////////////////////////////////////////////////////////////
		section1Header = new JTextPane();
		section1Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section1Header.setBounds(20, 30, 150, 20);
		section1Header.setBackground(bgColor);
		section1Header.setText("Personal Details");
		section1Header.setFocusable(false);
		section1Header.setEditable(false);
		section1Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section1Separator.setBounds(0, 40, frameLength, 2);
		// First Row
		stdNameTextPane = new JTextPane();
		stdNameTextPane.setBounds(20, 56, 40, 20);
		stdNameTextPane.setBackground(bgColor);
		stdNameTextPane.setText("Name");
		stdNameTextPane.setFocusable(false);
		stdNameTextPane.setEditable(false);
		stdName = new JTextField();
		stdName.setBounds(70, 56, 130, 20);

		stdFatherNameTextPane = new JTextPane();
		stdFatherNameTextPane.setBounds(210, 56, 75, 20);
		stdFatherNameTextPane.setBackground(bgColor);
		stdFatherNameTextPane.setText("Father's Name");
		stdFatherNameTextPane.setFocusable(false);
		stdFatherNameTextPane.setEditable(false);
		stdFatherName = new JTextField();
		stdFatherName.setBounds(295, 56, 130, 20);

		stdMotherNameTextPane = new JTextPane();
		stdMotherNameTextPane.setBounds(435, 56, 80, 20);
		stdMotherNameTextPane.setBackground(bgColor);
		stdMotherNameTextPane.setText("Mother's Name");
		stdMotherNameTextPane.setFocusable(false);
		stdMotherNameTextPane.setEditable(false);
		stdMotherName = new JTextField();
		stdMotherName.setBounds(525, 56, 129, 20);

		// Second Row
		stdDOBTextPane = new JTextPane();
		stdDOBTextPane.setBounds(20, 100, 34, 20);
		stdDOBTextPane.setBackground(bgColor);
		stdDOBTextPane.setText("DOB");
		stdDOBTextPane.setFocusable(false);
		stdDOBTextPane.setEditable(false);
		stdDOB = new JTextField();
		stdDOB.setBounds(70, 100, 86, 20);

		stdGenderTextPane = new JTextPane();
		stdGenderTextPane.setBounds(214, 100, 50, 20);
		stdGenderTextPane.setBackground(bgColor);
		stdGenderTextPane.setText("Gender");
		stdGenderTextPane.setFocusable(false);
		stdGenderTextPane.setEditable(false);
		stdGender = new JTextField();
		stdGender.setBounds(274, 100, 70, 20);

		stdEmailTextPane = new JTextPane();
		stdEmailTextPane.setBounds(371, 100, 40, 20);
		stdEmailTextPane.setBackground(bgColor);
		stdEmailTextPane.setText("E-Mail");
		stdEmailTextPane.setFocusable(false);
		stdEmailTextPane.setEditable(false);
		stdEmail = new JTextField();
		stdEmail.setBounds(435, 100, 223, 20);

		// Third Row.
		stdMobNoTextPane = new JTextPane();
		stdMobNoTextPane.setBounds(20, 140, 50, 20);
		stdMobNoTextPane.setBackground(bgColor);
		stdMobNoTextPane.setText("Moblie");
		stdMobNoTextPane.setFocusable(false);
		stdMobNoTextPane.setEditable(false);
		stdMobNo = new JTextField();
		stdMobNo.setBounds(70, 140, 106, 20);

		stdCategoryTextPane = new JTextPane();
		stdCategoryTextPane.setBounds(204, 140, 60, 20);
		stdCategoryTextPane.setBackground(bgColor);
		stdCategoryTextPane.setText("Category");
		stdCategoryTextPane.setFocusable(false);
		stdCategoryTextPane.setEditable(false);
		stdCategory = new JTextField();
		stdCategory.setBounds(269, 140, 75, 20);

		imagePanel = new JLabel();
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setBounds(678, 56, 106, 114);

		//////////////////////////////////////////////////////////////////
		////////////////////// SECOND SECTION//////////////////////////////
		//////////////////////////////////////////////////////////////////
		section2Header = new JTextPane();
		section2Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section2Header.setBounds(20, 180, 130, 20);
		section2Header.setBackground(bgColor);
		section2Header.setText("Postal Details");
		section2Header.setFocusable(false);
		section2Header.setEditable(false);
		section2Seperator = new JSeparator(SwingConstants.HORIZONTAL);
		section2Seperator.setBounds(0, 194, 935, 2);

		// First Row
		stdAddHomeTextPane = new JTextPane();
		stdAddHomeTextPane.setBounds(20, 211, 60, 20);
		stdAddHomeTextPane.setBackground(bgColor);
		stdAddHomeTextPane.setText("Address");
		stdAddHomeTextPane.setFocusable(false);
		stdAddHomeTextPane.setEditable(false);
		stdAddHome = new JTextField();
		stdAddHome.setBounds(121, 211, 365, 20);
		
		// Second Row
		stdAddStateTextPane = new JTextPane();
		stdAddStateTextPane.setBounds(20, 255, 50, 20);
		stdAddStateTextPane.setBackground(bgColor);
		stdAddStateTextPane.setText("City");
		stdAddStateTextPane.setFocusable(false);
		stdAddStateTextPane.setEditable(false);
		stdAddState = new JTextField();
		stdAddState.setBounds(274, 255, 161, 20);

		stdAddCityTextPane = new JTextPane();
		stdAddCityTextPane.setBounds(230, 255, 40, 20);
		stdAddCityTextPane.setBackground(bgColor);
		stdAddCityTextPane.setText("State");
		stdAddCityTextPane.setFocusable(false);
		stdAddCityTextPane.setEditable(false);
		stdAddCity = new JTextField();
		stdAddCity.setBounds(70, 255, 100, 20);

		stdAddPincodeTextPane = new JTextPane();
		stdAddPincodeTextPane.setBounds(445, 255, 70, 20);
		stdAddPincodeTextPane.setBackground(bgColor);
		stdAddPincodeTextPane.setText("Pin Code");
		stdAddPincodeTextPane.setFocusable(false);
		stdAddPincodeTextPane.setEditable(false);
		stdAddPincode = new JTextField();
		stdAddPincode.setBounds(525, 255, 100, 20);
		
		//////////////////////////////////////////////////////////////////
		///////////////////////THIRD SECTION//////////////////////////////
		//////////////////////////////////////////////////////////////////
		section3Header = new JTextPane();
		section3Header.setText("Educational Qualification");
		section3Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section3Header.setFocusable(false);
		section3Header.setBackground(new Color(238, 238, 238));
		section3Header.setBounds(20, 286, 230, 20);
		section3Separator = new JSeparator();
		section3Separator.setBounds(0, 300, 800, 2);

		//Row 1.
		stdClsXHeader = new JTextPane();
		stdClsXHeader.setText("Class X Details");
		stdClsXHeader.setFont(new Font("Dialog", Font.BOLD, 14));
		stdClsXHeader.setFocusable(false);
		stdClsXHeader.setEditable(false);
		stdClsXHeader.setBackground(new Color(238, 238, 238));
		stdClsXHeader.setBounds(20, 327, 130, 20);
		
		stdClsXPassingYrTextPane = new JTextPane();
		stdClsXPassingYrTextPane.setText("Passing Year");
		stdClsXPassingYrTextPane.setFocusable(false);
		stdClsXPassingYrTextPane.setEditable(false);
		stdClsXPassingYrTextPane.setBackground(new Color(238, 238, 238));
		stdClsXPassingYrTextPane.setBounds(20, 369, 90, 20);
		stdClsXPassingYr = new JTextField();
		stdClsXPassingYr.setBounds(110, 369, 75, 20);

		stdClsXMediumTextPane = new JTextPane();
		stdClsXMediumTextPane.setText("Medium ");
		stdClsXMediumTextPane.setFocusable(false);
		stdClsXMediumTextPane.setEditable(false);
		stdClsXMediumTextPane.setBackground(new Color(238, 238, 238));
		stdClsXMediumTextPane.setBounds(203, 369, 50, 20);
		stdClsXMedium = new JTextField();
		stdClsXMedium.setBounds(274, 369, 86, 20);
		
		stdClsXPercentageTextPane = new JTextPane();
		stdClsXPercentageTextPane.setText("Percentage");
		stdClsXPercentageTextPane.setFocusable(false);
		stdClsXPercentageTextPane.setEditable(false);
		stdClsXPercentageTextPane.setBackground(new Color(238, 238, 238));
		stdClsXPercentageTextPane.setBounds(398, 369, 80, 20);
		stdClsXPercentage = new JTextField();
		stdClsXPercentage.setBounds(488, 369, 86, 20);
		
		// Row 2.
		stdClsXIIHeader = new JTextPane();
		stdClsXIIHeader.setText("Class XII Details");
		stdClsXIIHeader.setFont(new Font("Dialog", Font.BOLD, 14));
		stdClsXIIHeader.setFocusable(false);
		stdClsXIIHeader.setEditable(false);
		stdClsXIIHeader.setBackground(new Color(238, 238, 238));
		stdClsXIIHeader.setBounds(20, 408, 135, 20);

		stdClsXIIPassingYrTextPane = new JTextPane();
		stdClsXIIPassingYrTextPane.setText("Passing Year");
		stdClsXIIPassingYrTextPane.setFocusable(false);
		stdClsXIIPassingYrTextPane.setEditable(false);
		stdClsXIIPassingYrTextPane.setBackground(new Color(238, 238, 238));
		stdClsXIIPassingYrTextPane.setBounds(20, 440, 90, 20);
		stdClsXIIPassingYr = new JTextField();
		stdClsXIIPassingYr.setBounds(110, 440, 75, 20);

		stdClsXIIMediumTextPane = new JTextPane();
		stdClsXIIMediumTextPane.setText("Medium");
		stdClsXIIMediumTextPane.setFocusable(false);
		stdClsXIIMediumTextPane.setEditable(false);
		stdClsXIIMediumTextPane.setBackground(new Color(238, 238, 238));
		stdClsXIIMediumTextPane.setBounds(203, 440, 67, 20);
		stdClsXIIMedium = new JTextField();
		stdClsXIIMedium.setBounds(274, 440, 86, 20);

		stdClsXIIPercentageTextPane = new JTextPane();
		stdClsXIIPercentageTextPane.setText("Percentage");
		stdClsXIIPercentageTextPane.setFocusable(false);
		stdClsXIIPercentageTextPane.setEditable(false);
		stdClsXIIPercentageTextPane.setBackground(new Color(238, 238, 238));
		stdClsXIIPercentageTextPane.setBounds(398, 440, 80, 20);
		stdClsXIIPercentage = new JTextField();
		stdClsXIIPercentage.setBounds(488, 440, 86, 20);
	}
	
	private void initListeners()
	{
		
	}
	
	private void initializeFrame()
	{
		stdDetailedView = new JFrame("Student Details");
		stdDetailedView.setBounds(framex, framey, frameLength, frameheigth);
		stdDetailedView.setBackground(bgColor);
		stdDetailedView.getContentPane().setLayout(null);
		stdDetailedView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		stdDetailedView.setResizable(false);
		
		stdDetailedView.addWindowListener( new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent arg0)
			{
				MainStdGUI std = new MainStdGUI(userid);
				std.stdMainGUI.setVisible(true);
				super.windowClosing(arg0);
			}
		});
	}
}
