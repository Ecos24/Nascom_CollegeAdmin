package facultyReg;

import beanClasses.FacultyUser;
import extraClasses.GUIRegisterUtilityFunctions;
import memberGUI.admin.MainGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JCheckBox;
import javax.swing.text.NumberFormatter;

public class CompFacultyReg2
{
	private FacultyUser user;

	private final static long ROLL_MAX = 9999999l;
	private final static long PER_MAX = 100l;
	private final static long HIGH_QUAL_SCORE = 1000l;
	private static final int framex = 0;
	private static final int framey = 0;
	private static final int frameLength = 800;
	private static final int frameheigth = 700;
	private Color bgColor;

	public JFrame compFacultyReg2;

	// Section 5.
	private JTextPane section5Header;
	private JSeparator section5Separator;
	// Row 1.
	private JTextPane facClsXHeader;
	private JSeparator facClsXSeparator;
	private JTextField facClsXRollNo;
	@SuppressWarnings("rawtypes")
	private JComboBox facClsXPassingYr;
	@SuppressWarnings("rawtypes")
	private JComboBox facClsXBoard;
	private JTextPane facClsXRollNoTextPane;
	private JTextPane facClsXPassingYrTextPane;
	private JTextPane facClsXBoardTextPane;
	// Row 2
	private JTextPane facClsXIIHeader;
	private JSeparator facClsXIISeparator;
	private JFormattedTextField facClsXIIRollNo;
	@SuppressWarnings("rawtypes")
	private JComboBox facClsXIIPassingYr;
	@SuppressWarnings("rawtypes")
	private JComboBox facClsXIIBoard;
	@SuppressWarnings("rawtypes")
	private JComboBox facClsXIIMedium;
	private JFormattedTextField facClsXIIPercnetage;
	private JTextPane facClsXIIRollNoTextPane;
	private JTextPane facClsXIIPassingYrTextPane;
	private JTextPane facClsXIIBoardTextPane;
	private JTextPane facClsXIIMediumTextPane;
	private JTextPane facClsXIIPercnetageTextPane;
	//Row 3
	private JTextPane highestQualHeader;
	private JSeparator highestQualSeperator;
	private JTextPane facHighestQualTextPane;
	@SuppressWarnings("rawtypes")
	private JComboBox facHighestQual;
	private JTextPane facHighestQualFromTextPane;
	private JTextField facHighestQualFrom;
	private JTextPane facHighestQualScoreTextPane;
	private JFormattedTextField facHighestQualScore;
	private JTextPane facHighestQualYearTextPane;
	@SuppressWarnings("rawtypes")
	private JComboBox facHighestQualYear;
	//Row 4
	private JSeparator facTeachingSeparator;
	private JTextPane facTeachingSubjectHeader;
	private JTextPane facTeachingSubjects1TextPane;
	@SuppressWarnings("rawtypes")
	private JComboBox facTeachingSubjects1;
	private JTextPane facTeachingSubjects2TextPane;
	@SuppressWarnings("rawtypes")
	private JComboBox facTeachingSubjects2;
	private JTextPane facTeachingSubjects3TextPane;
	@SuppressWarnings("rawtypes")
	private JComboBox facTeachingSubjects3;
	private JTextPane facTeachingExperienceTextPane;
	@SuppressWarnings("rawtypes")
	private JComboBox facTeachingExperience;
	private JTextPane facPreviousInstituteTextPane;
	private JTextField facPreviousInstitute;
	//Row 5
	private JCheckBox facPrepareHigherEduCheck;
	private JTextPane facPrepareHigherEduTextPane;
	private JTextField facPrepareHigherEdu;

	private JButton facRegSubmit;

	/**
	 * @wbp.parser.entryPoint
	 */
	public CompFacultyReg2(FacultyUser facuser)
	{
		this.user = facuser;
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		initListeners();
		associateFrameComponents();
	}

	private void associateFrameComponents()
	{
		// Section 5.
		compFacultyReg2.getContentPane().add(section5Header);
		compFacultyReg2.getContentPane().add(section5Separator);
		//Row 1
		compFacultyReg2.getContentPane().add(facClsXHeader);
		compFacultyReg2.getContentPane().add(facClsXSeparator);
		compFacultyReg2.getContentPane().add(facClsXRollNoTextPane);
		compFacultyReg2.getContentPane().add(facClsXRollNo);
		compFacultyReg2.getContentPane().add(facClsXPassingYrTextPane);
		compFacultyReg2.getContentPane().add(facClsXPassingYr);
		compFacultyReg2.getContentPane().add(facClsXBoardTextPane);
		compFacultyReg2.getContentPane().add(facClsXBoard);
		//Row 2
		compFacultyReg2.getContentPane().add(facClsXIIHeader);
		compFacultyReg2.getContentPane().add(facClsXIISeparator);
		compFacultyReg2.getContentPane().add(facClsXIIRollNoTextPane);
		compFacultyReg2.getContentPane().add(facClsXIIRollNo);
		compFacultyReg2.getContentPane().add(facClsXIIPassingYrTextPane);
		compFacultyReg2.getContentPane().add(facClsXIIPassingYr);
		compFacultyReg2.getContentPane().add(facClsXIIBoardTextPane);
		compFacultyReg2.getContentPane().add(facClsXIIBoard);
		compFacultyReg2.getContentPane().add(facClsXIIMediumTextPane);
		compFacultyReg2.getContentPane().add(facClsXIIMedium);
		compFacultyReg2.getContentPane().add(facClsXIIPercnetageTextPane);
		compFacultyReg2.getContentPane().add(facClsXIIPercnetage);
		//Row 3
		compFacultyReg2.getContentPane().add(highestQualHeader);
		compFacultyReg2.getContentPane().add(highestQualSeperator);
		compFacultyReg2.getContentPane().add(facHighestQualTextPane);
		compFacultyReg2.getContentPane().add(facHighestQual);
		compFacultyReg2.getContentPane().add(facHighestQualFrom);
		compFacultyReg2.getContentPane().add(facHighestQualFromTextPane);
		compFacultyReg2.getContentPane().add(facHighestQualScore);
		compFacultyReg2.getContentPane().add(facHighestQualScoreTextPane);
		compFacultyReg2.getContentPane().add(facHighestQualYear);
		compFacultyReg2.getContentPane().add(facHighestQualYearTextPane);
		//Row 4
		compFacultyReg2.getContentPane().add(facTeachingSubjectHeader);
		compFacultyReg2.getContentPane().add(facTeachingSeparator);
		compFacultyReg2.getContentPane().add(facTeachingSubjects1TextPane);
		compFacultyReg2.getContentPane().add(facTeachingSubjects1);
		compFacultyReg2.getContentPane().add(facTeachingSubjects2TextPane);
		compFacultyReg2.getContentPane().add(facTeachingSubjects2);
		compFacultyReg2.getContentPane().add(facTeachingSubjects3TextPane);
		compFacultyReg2.getContentPane().add(facTeachingSubjects3);
		compFacultyReg2.getContentPane().add(facTeachingExperience);
		compFacultyReg2.getContentPane().add(facTeachingExperienceTextPane);
		compFacultyReg2.getContentPane().add(facPreviousInstitute);
		compFacultyReg2.getContentPane().add(facPreviousInstituteTextPane);
		//Row 5
		compFacultyReg2.getContentPane().add(facPrepareHigherEduTextPane);
		compFacultyReg2.getContentPane().add(facPrepareHigherEduCheck);
		compFacultyReg2.getContentPane().add(facPrepareHigherEdu);

		compFacultyReg2.getContentPane().add(facRegSubmit);
		compFacultyReg2.getRootPane().setDefaultButton(facRegSubmit);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents()
	{
		//////////////////////////////////////////////////////////////////
		////////////////////// FOURTH SECTION/////////////////////////////
		//////////////////////////////////////////////////////////////////
		section5Header = new JTextPane();
		section5Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section5Header.setBounds(20, 10, 340, 20);
		section5Header.setBackground(bgColor);
		section5Header.setText("Educational Details and Experience");
		section5Header.setFocusable(false);
		section5Header.setEditable(false);
		section5Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section5Separator.setBounds(0, 20, frameLength, 2);

		// Class 10th details.
		facClsXHeader = new JTextPane();
		facClsXHeader.setFont(new Font("Dialog", Font.BOLD, 14));
		facClsXHeader.setBounds(40, 40, 130, 20);
		facClsXHeader.setBackground(bgColor);
		facClsXHeader.setText("Class X Details");
		facClsXHeader.setFocusable(false);
		facClsXHeader.setEditable(false);
		facClsXSeparator = new JSeparator(SwingConstants.HORIZONTAL);
		facClsXSeparator.setBounds(20, 50, frameLength-100, 2);
		// First Row
		facClsXRollNoTextPane = new JTextPane();
		facClsXRollNoTextPane.setBounds(20, 90, 80, 20);
		facClsXRollNoTextPane.setBackground(bgColor);
		facClsXRollNoTextPane.setText("Roll No.");
		facClsXRollNoTextPane.setFocusable(false);
		facClsXRollNoTextPane.setEditable(false);
		facClsXRollNo = new JTextField();
		facClsXRollNo.setBounds(110, 90, 130, 20);

		facClsXPassingYrTextPane = new JTextPane();
		facClsXPassingYrTextPane.setBounds(270, 90, 80, 20);
		facClsXPassingYrTextPane.setBackground(bgColor);
		facClsXPassingYrTextPane.setText("Passing Year");
		facClsXPassingYrTextPane.setFocusable(false);
		facClsXPassingYrTextPane.setEditable(false);
		facClsXPassingYr = new JComboBox(GUIRegisterUtilityFunctions.getPassingYr());
		facClsXPassingYr.setBounds(360, 90, 130, 20);

		facClsXBoardTextPane = new JTextPane();
		facClsXBoardTextPane.setBounds(520, 90, 80, 20);
		facClsXBoardTextPane.setBackground(bgColor);
		facClsXBoardTextPane.setText("Board");
		facClsXBoardTextPane.setFocusable(false);
		facClsXBoardTextPane.setEditable(false);
		facClsXBoard = new JComboBox(GUIRegisterUtilityFunctions.getBoard());
		facClsXBoard.setBounds(610, 90, 130, 20);

		// Class XII Section.
		facClsXIIHeader = new JTextPane();
		facClsXIIHeader.setFont(new Font("Dialog", Font.BOLD, 14));
		facClsXIIHeader.setBounds(40, 130, 130, 20);
		facClsXIIHeader.setBackground(bgColor);
		facClsXIIHeader.setText("Class XII Details");
		facClsXIIHeader.setFocusable(false);
		facClsXIIHeader.setEditable(false);
		facClsXIISeparator = new JSeparator(SwingConstants.HORIZONTAL);
		facClsXIISeparator.setBounds(20, 140, frameLength-100, 2);
		// First Row
		facClsXIIRollNoTextPane = new JTextPane();
		facClsXIIRollNoTextPane.setBounds(20, 180, 80, 20);
		facClsXIIRollNoTextPane.setBackground(bgColor);
		facClsXIIRollNoTextPane.setText("Roll No.");
		facClsXIIRollNoTextPane.setFocusable(false);
		facClsXIIRollNoTextPane.setEditable(false);
		facClsXIIRollNo = new JFormattedTextField(returnFormatter(ROLL_MAX));
		facClsXIIRollNo.setBounds(110, 180, 130, 20);

		facClsXIIPassingYrTextPane = new JTextPane();
		facClsXIIPassingYrTextPane.setBounds(270, 180, 80, 20);
		facClsXIIPassingYrTextPane.setBackground(bgColor);
		facClsXIIPassingYrTextPane.setText("Passing Year");
		facClsXIIPassingYrTextPane.setFocusable(false);
		facClsXIIPassingYrTextPane.setEditable(false);
		facClsXIIPassingYr = new JComboBox(GUIRegisterUtilityFunctions.getPassingYr());
		facClsXIIPassingYr.setBounds(360, 180, 130, 20);
		
		facClsXIIBoardTextPane = new JTextPane();
		facClsXIIBoardTextPane.setBounds(520, 180, 80, 20);
		facClsXIIBoardTextPane.setBackground(bgColor);
		facClsXIIBoardTextPane.setText("Board");
		facClsXIIBoardTextPane.setFocusable(false);
		facClsXIIBoardTextPane.setEditable(false);
		facClsXIIBoard = new JComboBox(GUIRegisterUtilityFunctions.getBoard());
		facClsXIIBoard.setBounds(610, 180, 130, 20);

		// Second Row
		facClsXIIMediumTextPane = new JTextPane();
		facClsXIIMediumTextPane.setBounds(20, 220, 80, 20);
		facClsXIIMediumTextPane.setBackground(bgColor);
		facClsXIIMediumTextPane.setText("Medium");
		facClsXIIMediumTextPane.setFocusable(false);
		facClsXIIMediumTextPane.setEditable(false);
		facClsXIIMedium = new JComboBox(GUIRegisterUtilityFunctions.getMedium());
		facClsXIIMedium.setBounds(110, 220, 130, 20);

		facClsXIIPercnetageTextPane = new JTextPane();
		facClsXIIPercnetageTextPane.setBounds(270, 220, 80, 20);
		facClsXIIPercnetageTextPane.setBackground(bgColor);
		facClsXIIPercnetageTextPane.setText("Percentage");
		facClsXIIPercnetageTextPane.setFocusable(false);
		facClsXIIPercnetageTextPane.setEditable(false);
		facClsXIIPercnetage = new JFormattedTextField(returnFormatter(PER_MAX));
		facClsXIIPercnetage.setBounds(360, 220, 130, 20);

		// Highest Qualification
		highestQualHeader = new JTextPane();
		highestQualHeader.setForeground(Color.BLACK);
		highestQualHeader.setFont(new Font("Dialog", Font.BOLD, 14));
		highestQualHeader.setBounds(40, 260, 175, 20);
		highestQualHeader.setBackground(bgColor);
		highestQualHeader.setText("Highest Qualification");
		highestQualHeader.setFocusable(false);
		highestQualHeader.setEditable(false);
		highestQualSeperator = new JSeparator(SwingConstants.HORIZONTAL);
		highestQualSeperator.setBounds(20, 270, frameLength-100, 2);

		facHighestQualTextPane = new JTextPane();
		facHighestQualTextPane.setBounds(20, 310, 80, 20);
		facHighestQualTextPane.setBackground(bgColor);
		facHighestQualTextPane.setText("Qualification");
		facHighestQualTextPane.setFocusable(false);
		facHighestQualTextPane.setEditable(false);
		String[] qualifications_possible = { "Select", "B.Tech", "M.Tech", "BCA", "MCA", "Ph.D" };
		facHighestQual = new JComboBox(qualifications_possible);
		facHighestQual.setBounds(110, 310, 130, 20);

		facHighestQualFromTextPane = new JTextPane();
		facHighestQualFromTextPane.setBounds(270, 310, 160, 20);
		facHighestQualFromTextPane.setBackground(bgColor);
		facHighestQualFromTextPane.setText("From College/University");
		facHighestQualFromTextPane.setFocusable(false);
		facHighestQualFromTextPane.setEditable(false);
		facHighestQualFrom = new JTextField();
		facHighestQualFrom.setBounds(460, 310, 280, 20);
		facHighestQualFrom.setColumns(30);

		// Second Row.
		facHighestQualScoreTextPane = new JTextPane();
		facHighestQualScoreTextPane.setBounds(20, 350, 80, 20);
		facHighestQualScoreTextPane.setBackground(bgColor);
		facHighestQualScoreTextPane.setText("Total Score");
		facHighestQualScoreTextPane.setFocusable(false);
		facHighestQualScoreTextPane.setEditable(false);
		facHighestQualScore = new JFormattedTextField(returnFormatter(HIGH_QUAL_SCORE));
		facHighestQualScore.setBounds(110, 350, 130, 20);

		facHighestQualYearTextPane = new JTextPane();
		facHighestQualYearTextPane.setBounds(270, 350, 90, 20);
		facHighestQualYearTextPane.setBackground(bgColor);
		facHighestQualYearTextPane.setText("Passing Year");
		facHighestQualYearTextPane.setFocusable(false);
		facHighestQualYearTextPane.setEditable(false);
		facHighestQualYear = new JComboBox(GUIRegisterUtilityFunctions.getPassingYr());
		facHighestQualYear.setBounds(360, 350, 130, 20);

		// Teaching Experience and Subjects.
		facTeachingSubjectHeader = new JTextPane();
		facTeachingSubjectHeader.setForeground(Color.BLACK);
		facTeachingSubjectHeader.setFont(new Font("Dialog", Font.BOLD, 14));
		facTeachingSubjectHeader.setBounds(40, 390, 80, 20);
		facTeachingSubjectHeader.setBackground(bgColor);
		facTeachingSubjectHeader.setText("Teaching");
		facTeachingSubjectHeader.setFocusable(false);
		facTeachingSubjectHeader.setEditable(false);
		facTeachingSeparator = new JSeparator();
		facTeachingSeparator.setBounds(20, 400, frameLength-80, 2);

		// Row 1.
		facTeachingSubjects1TextPane = new JTextPane();
		facTeachingSubjects1TextPane.setBounds(20, 440, 80, 20);
		facTeachingSubjects1TextPane.setBackground(bgColor);
		facTeachingSubjects1TextPane.setText("Subject 1");
		facTeachingSubjects1TextPane.setFocusable(false);
		facTeachingSubjects1TextPane.setEditable(false);
		String[] Teaching_Subject_1 = { "Select", "B.Tech", "M.Tech", "BCA", "MCA", "Ph.D" };
		facTeachingSubjects1 = new JComboBox(Teaching_Subject_1);
		facTeachingSubjects1.setBounds(110, 440, 130, 20);

		facTeachingSubjects2TextPane = new JTextPane();
		facTeachingSubjects2TextPane.setBounds(270, 440, 80, 20);
		facTeachingSubjects2TextPane.setBackground(bgColor);
		facTeachingSubjects2TextPane.setText("Subject 2");
		facTeachingSubjects2TextPane.setFocusable(false);
		facTeachingSubjects2TextPane.setEditable(false);
		String[] Teaching_Subject_2 = { "Select", "B.Tech", "M.Tech", "BCA", "MCA", "Ph.D" };
		facTeachingSubjects2 = new JComboBox(Teaching_Subject_2);
		facTeachingSubjects2.setBounds(360, 440, 130, 20);

		facTeachingSubjects3TextPane = new JTextPane();
		facTeachingSubjects3TextPane.setBounds(530, 440, 80, 20);
		facTeachingSubjects3TextPane.setBackground(bgColor);
		facTeachingSubjects3TextPane.setText("Subject 3");
		facTeachingSubjects3TextPane.setFocusable(false);
		facTeachingSubjects3TextPane.setEditable(false);
		String[] Teaching_Subject_3 = { "Select", "B.Tech", "M.Tech", "BCA", "MCA", "Ph.D" };
		facTeachingSubjects3 = new JComboBox(Teaching_Subject_3);
		facTeachingSubjects3.setBounds(620, 440, 130, 20);
		
		// Row 2.
		facTeachingExperienceTextPane = new JTextPane();
		facTeachingExperienceTextPane.setBounds(20, 480, 130, 20);
		facTeachingExperienceTextPane.setBackground(bgColor);
		facTeachingExperienceTextPane.setText("Experience (in yrs)");
		facTeachingExperienceTextPane.setFocusable(false);
		facTeachingExperienceTextPane.setEditable(false);
		String[] yrs_experience = { "Select", "< 1yr", "1 yr", "2-4 yrs", "5yrs", "6-10 yrs", "10+ yrs" };
		facTeachingExperience = new JComboBox(yrs_experience);
		facTeachingExperience.setBounds(150, 480, 130, 20);

		facPreviousInstituteTextPane = new JTextPane();
		facPreviousInstituteTextPane.setBounds(320, 480, 250, 20);
		facPreviousInstituteTextPane.setBackground(bgColor);
		facPreviousInstituteTextPane.setText("Last taught at (full name of institute)");
		facPreviousInstituteTextPane.setFocusable(false);
		facPreviousInstituteTextPane.setEditable(false);
		facPreviousInstitute = new JTextField();
		facPreviousInstitute.setBounds(580, 480, 170, 20);

		facPrepareHigherEduCheck = new JCheckBox("Continuing furthur studies?");
		facPrepareHigherEduCheck.setBounds(20, 520, 250, 20);
		facPrepareHigherEduTextPane = new JTextPane();
		facPrepareHigherEduTextPane.setBounds(20, 560, 240, 20);
		facPrepareHigherEduTextPane.setBackground(bgColor);
		facPrepareHigherEduTextPane.setText("NAME OF EXAM/COURSE PREPARING FOR...");
		facPrepareHigherEduTextPane.setFocusable(false);
		facPrepareHigherEduTextPane.setEditable(false);
		facPrepareHigherEdu = new JTextField();
		facPrepareHigherEdu.setBounds(270, 560, 250, 20);
		facPrepareHigherEdu.setEnabled(false);

		facRegSubmit = new JButton("Register");
		facRegSubmit.setBounds((frameLength/2 - 60), (frameheigth - 80), 120, 30);
	}

	private void initListeners()
	{
		// Register Button.
		facRegSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(!checkX())
				{
					return;
				}
				if(!checkXII())
				{
					return;
				}
				if( !checkHighestQual() )
				{
					return;
				}
				if( !checkTeaching() )
				{
					return;
				}

				// Entry to DB Logic
				user.setClsXRollNo(facClsXRollNo.getText());
				user.setClsXPassingYr((String)facClsXPassingYr.getSelectedItem());
				user.setClsXBoard((String)facClsXBoard.getSelectedItem());
				user.setClsXIIRollNo(facClsXIIRollNo.getText());
				user.setClsXIIPassingYr((String)facClsXIIPassingYr.getSelectedItem());
				user.setClsXIIBoard((String)facClsXIIBoard.getSelectedItem());
				user.setClsXIIMedium((String)facClsXIIMedium.getSelectedItem());
				user.setClsXIIPercentage(facClsXIIPercnetage.getText());
				user.setHighestQual((String)facHighestQual.getSelectedItem());
				user.setHighestQualFrom(facHighestQualFrom.getText());
				user.setSubject1((String)facTeachingSubjects1.getSelectedItem());
				user.setSubject2((String)facTeachingSubjects2.getSelectedItem());
				user.setSubject3((String)facTeachingSubjects3.getSelectedItem());
				user.setPersuingCourse(facPrepareHigherEduCheck.isSelected());
				user.setNameOfPersuingCourse(facPrepareHigherEdu.getText());
			}
		});
		
		facPrepareHigherEduCheck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if(facPrepareHigherEduCheck.isSelected())
				{
					facPrepareHigherEdu.setEnabled(true);
					facPrepareHigherEdu.setFocusable(true);
				}
				else
				{
					facPrepareHigherEdu.setText(null);
					facPrepareHigherEdu.setEnabled(false);
					facPrepareHigherEdu.setFocusable(false);
				}
			}
		});

		facClsXIIRollNo.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if(arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE)
				{
					if(facClsXIIRollNo.getText().length() == 1)
					{
						facClsXIIRollNo.setText("0");
					}
				}
			}
		});
		facClsXIIPercnetage.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE)
				{
					if (facClsXIIPercnetage.getText().length() == 1)
					{
						facClsXIIPercnetage.setText("0");
					}
				}
			}
		});
		facHighestQualScore.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE)
				{
					if (facHighestQualScore.getText().length() == 1)
					{
						facHighestQualScore.setText("0");
					}
				}
			}
		});
	}

	private void initializeFrame()
	{
		compFacultyReg2 = new JFrame("Faculty Registration Finalize");
		compFacultyReg2.setBounds(framex, framey, frameLength, frameheigth);
		compFacultyReg2.setBackground(bgColor);
		compFacultyReg2.getContentPane().setLayout(null);
		compFacultyReg2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		compFacultyReg2.setResizable(false);
		
		compFacultyReg2.addWindowListener(new WindowAdapter()
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

	private boolean checkHighestQual()
	{
		boolean checkFlag = true;
		GUIRegisterUtilityFunctions errorUtility = new GUIRegisterUtilityFunctions();
		
		if( facHighestQual.getSelectedIndex() == 0 || facHighestQualFrom.getText().equals("") ||
				facHighestQualScore.getText().equals("") || facHighestQualYear.getSelectedIndex() == 0 || 
				facClsXIIPercnetage.getText().equals("") )
		{
			JOptionPane.showMessageDialog(null, "Complete Highest Education Details");
			return false;
		}
		if( facHighestQualYear.getSelectedIndex() < facClsXIIPassingYr.getSelectedIndex()+3 )
		{
			errorUtility.storeError("Higher Education passing year should be atleast 3 yrs greater than Class XII passing year.");
			checkFlag = false;
		}
		if( Integer.parseInt(facHighestQualScore.getText()) > 1000 )
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
	private boolean checkTeaching()
	{
		if( facTeachingExperience.getSelectedIndex() == 0 || facPreviousInstitute.getText().equals("") ||
			facTeachingSubjects1.getSelectedIndex() == 0 || facTeachingSubjects2.getSelectedIndex() == 0 || 
			facTeachingSubjects3.getSelectedIndex() == 0 )
		{
			JOptionPane.showMessageDialog(null, "Complete Teaching Details");
			return false;
		}
		if( facPrepareHigherEduCheck.isSelected() )
		{
			if( facPrepareHigherEdu.getText().equals("") )
			{
				JOptionPane.showMessageDialog(null, "Complete Teaching Details");
				return false;
			}
		}
		return true;
	}
	private boolean checkX()
	{
		if( facClsXRollNo.getText().equals("") || facClsXPassingYr.getSelectedIndex() == 0 ||
				facClsXBoard.getSelectedIndex() == 0 )
		{
			JOptionPane.showMessageDialog(compFacultyReg2, "Complete Class X Details.");
			return false;
		}
		if( facClsXRollNo.getText().length() < 7 )
		{
			JOptionPane.showMessageDialog(compFacultyReg2, "Invalid Class X Roll Number.");
			return false;
		}
		return true;
	}
	private boolean checkXII()
	{
		boolean checkFlag = true;
		GUIRegisterUtilityFunctions errorUtility = new GUIRegisterUtilityFunctions();
		
		if( facClsXIIRollNo.getText().equals("") || facClsXIIPassingYr.getSelectedIndex() == 0 ||
				facClsXIIBoard.getSelectedIndex() == 0 || facClsXIIMedium.getSelectedIndex() == 0 || 
				facClsXIIPercnetage.getText().equals("") )
		{
			JOptionPane.showMessageDialog(null, "Complete Class XII Details");
			return false;
		}
		if( facClsXIIRollNo.getText().length() != 7 )
		{
			errorUtility.storeError("Invalid Class XII Roll Number.");
			checkFlag = false;
		}
		if( facClsXIIPassingYr.getSelectedIndex() < facClsXPassingYr.getSelectedIndex()+2 )
		{
			errorUtility.storeError("Class XII passing year has to be greater then Class X's passing year.");
			checkFlag = false;
		}
		if( Integer.parseInt(facClsXIIPercnetage.getText()) > 100 || Integer.parseInt(facClsXIIPercnetage.getText()) < 30 )
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