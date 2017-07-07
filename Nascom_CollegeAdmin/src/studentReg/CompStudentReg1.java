package studentReg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class CompStudentReg1
{
	private static final int MOB_DIGIT = 10;
	private static final int framex = 0;
	private static final int framey = 0;
	private static final int frameLength = 800;
	private static final int frameheigth = 400;
	private Color bgColor;
	
	public JFrame compStudentReg1;
	
	// Section 4.
	private JTextPane section4Header;
	private JSeparator section4Separator;
	private JTextPane stdFatherHeader;
	private JSeparator stdFatherSeparator;
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
	private JTextPane stdMotherHeader;
	private JSeparator stdMotherSeparator;
	private JTextField stdMotherFirstName;
	private JTextField stdMotherMiddleName;
	private JTextField stdMotherLastName;
	private JFormattedTextField stdMotherMobNo;
	@SuppressWarnings("rawtypes")
	private JComboBox stdMotherOccupation;
	private JTextField stdMotherEmail;
	private JTextPane stdMotherFirstNameTextPane;
	private JTextPane stdMotherMiddleNameTextPane;
	private JTextPane stdMotherLastNameTextPane;
	private JTextPane stdMotherMobNoTextPane;
	private JTextPane stdMotherOccupationTextPane;
	private JTextPane stdMotherEmailTextPane;
	
	private JButton stdRegNextFrame;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public CompStudentReg1()
	{
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		initListneres();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		//Section 4.
		compStudentReg1.getContentPane().add(section4Header);
		compStudentReg1.getContentPane().add(section4Separator);
		compStudentReg1.getContentPane().add(stdFatherHeader);
		compStudentReg1.getContentPane().add(stdFatherSeparator);
		compStudentReg1.getContentPane().add(stdFatherFirstNameTextPane);
		compStudentReg1.getContentPane().add(stdFatherFirstName);
		compStudentReg1.getContentPane().add(stdFatherMiddleNameTextPane);
		compStudentReg1.getContentPane().add(stdFatherMiddelName);
		compStudentReg1.getContentPane().add(stdFatherLastNameTextPane);
		compStudentReg1.getContentPane().add(stdFatherLastName);
		compStudentReg1.getContentPane().add(stdFatherMobNoTextPane);
		compStudentReg1.getContentPane().add(stdFatherMobNo);
		compStudentReg1.getContentPane().add(stdFatherOccupationTextPane);
		compStudentReg1.getContentPane().add(stdFatherOccupation);
		compStudentReg1.getContentPane().add(stdFatherEmailTextPane);
		compStudentReg1.getContentPane().add(stdFatherEmail);
		compStudentReg1.getContentPane().add(stdMotherHeader);
		compStudentReg1.getContentPane().add(stdMotherSeparator);
		compStudentReg1.getContentPane().add(stdMotherFirstNameTextPane);
		compStudentReg1.getContentPane().add(stdMotherFirstName);
		compStudentReg1.getContentPane().add(stdMotherMiddleNameTextPane);
		compStudentReg1.getContentPane().add(stdMotherMiddleName);
		compStudentReg1.getContentPane().add(stdMotherLastNameTextPane);
		compStudentReg1.getContentPane().add(stdMotherLastName);
		compStudentReg1.getContentPane().add(stdMotherMobNoTextPane);
		compStudentReg1.getContentPane().add(stdMotherMobNo);
		compStudentReg1.getContentPane().add(stdMotherOccupationTextPane);
		compStudentReg1.getContentPane().add(stdMotherOccupation);
		compStudentReg1.getContentPane().add(stdMotherEmailTextPane);
		compStudentReg1.getContentPane().add(stdMotherEmail);
		
		compStudentReg1.getContentPane().add(stdRegNextFrame);
		compStudentReg1.getRootPane().setDefaultButton(stdRegNextFrame);
		
		compStudentReg1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		compStudentReg1.setResizable(false);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents()
	{
		//////////////////////////////////////////////////////////////////
		////////////////////// FOURTH SECTION/////////////////////////////
		//////////////////////////////////////////////////////////////////
		section4Header = new JTextPane();
		section4Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section4Header.setBounds(20, 30, 150, 20);
		section4Header.setBackground(bgColor);
		section4Header.setText("Parental Details");
		section4Header.setFocusable(false);
		section4Header.setEditable(false);
		section4Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section4Separator.setBounds(0, 42, frameLength, 2);
		
		// Father's Section.
		stdFatherHeader = new JTextPane();
		stdFatherHeader.setFont(new Font("Dialog", Font.BOLD, 14));
		stdFatherHeader.setBounds(300, 58, 130, 20);
		stdFatherHeader.setBackground(bgColor);
		stdFatherHeader.setText("Father's Details");
		stdFatherHeader.setFocusable(false);
		stdFatherHeader.setEditable(false);
		stdFatherSeparator = new JSeparator(SwingConstants.HORIZONTAL);
		stdFatherSeparator.setBounds(22, 70, 715, 2);
		// First Row
		stdFatherFirstNameTextPane = new JTextPane();
		stdFatherFirstNameTextPane.setBounds(20, 93, 80, 20);
		stdFatherFirstNameTextPane.setBackground(bgColor);
		stdFatherFirstNameTextPane.setText("First Name");
		stdFatherFirstNameTextPane.setFocusable(false);
		stdFatherFirstNameTextPane.setEditable(false);
		stdFatherFirstName = new JTextField();
		stdFatherFirstName.setBounds(110, 93, 130, 20);
		stdFatherFirstName.setColumns(10);

		stdFatherMiddleNameTextPane = new JTextPane();
		stdFatherMiddleNameTextPane.setBounds(270, 93, 90, 20);
		stdFatherMiddleNameTextPane.setBackground(bgColor);
		stdFatherMiddleNameTextPane.setText("Middle Name");
		stdFatherMiddleNameTextPane.setFocusable(false);
		stdFatherMiddleNameTextPane.setEditable(false);
		stdFatherMiddelName = new JTextField();
		stdFatherMiddelName.setBounds(360, 93, 130, 20);
		stdFatherMiddelName.setColumns(10);

		stdFatherLastNameTextPane = new JTextPane();
		stdFatherLastNameTextPane.setBounds(520, 93, 80, 20);
		stdFatherLastNameTextPane.setBackground(bgColor);
		stdFatherLastNameTextPane.setText("Last Name");
		stdFatherLastNameTextPane.setFocusable(false);
		stdFatherLastNameTextPane.setEditable(false);
		stdFatherLastName = new JTextField();
		stdFatherLastName.setColumns(10);
		stdFatherLastName.setBounds(610, 93, 130, 20);

		// Second Row
		stdFatherMobNoTextPane = new JTextPane();
		stdFatherMobNoTextPane.setBounds(20, 133, 80, 20);
		stdFatherMobNoTextPane.setBackground(bgColor);
		stdFatherMobNoTextPane.setText("Mobile");
		stdFatherMobNoTextPane.setFocusable(false);
		stdFatherMobNoTextPane.setEditable(false);
		stdFatherMobNo = new JFormattedTextField(returnFormatter(MOB_DIGIT));
		stdFatherMobNo.setBounds(110, 133, 130, 20);

		stdFatherOccupationTextPane = new JTextPane();
		stdFatherOccupationTextPane.setBounds(270, 133, 80, 20);
		stdFatherOccupationTextPane.setBackground(bgColor);
		stdFatherOccupationTextPane.setText("Occupation");
		stdFatherOccupationTextPane.setFocusable(false);
		stdFatherOccupationTextPane.setEditable(false);
		String[] occupationChoices = { "Select", "Engineer", "Doctor", "Armed Forces", "Government Employed", "Self Employed" };
		stdFatherOccupation = new JComboBox(occupationChoices);
		stdFatherOccupation.setBounds(360, 133, 130, 20);

		stdFatherEmailTextPane = new JTextPane();
		stdFatherEmailTextPane.setBounds(520, 133, 80, 20);
		stdFatherEmailTextPane.setBackground(bgColor);
		stdFatherEmailTextPane.setText("E-Mail");
		stdFatherEmailTextPane.setFocusable(false);
		stdFatherEmailTextPane.setEditable(false);
		stdFatherEmail = new JTextField();
		stdFatherEmail.setColumns(10);
		stdFatherEmail.setBounds(610, 133, 130, 20);
		
		// Mother's Section.
		stdMotherHeader = new JTextPane();
		stdMotherHeader.setFont(new Font("Dialog", Font.BOLD, 14));
		stdMotherHeader.setBounds(300, 170, 135, 20);
		stdMotherHeader.setBackground(bgColor);
		stdMotherHeader.setText("Mother's Details");
		stdMotherHeader.setFocusable(false);
		stdMotherHeader.setEditable(false);
		stdMotherSeparator = new JSeparator(SwingConstants.HORIZONTAL);
		stdMotherSeparator.setBounds(22, 182, 715, 2);
		// First Row
		stdMotherFirstNameTextPane = new JTextPane();
		stdMotherFirstNameTextPane.setBounds(20, 205, 80, 20);
		stdMotherFirstNameTextPane.setBackground(bgColor);
		stdMotherFirstNameTextPane.setText("First Name");
		stdMotherFirstNameTextPane.setFocusable(false);
		stdMotherFirstNameTextPane.setEditable(false);
		stdMotherFirstName = new JTextField();
		stdMotherFirstName.setBounds(110, 205, 130, 20);
		stdMotherFirstName.setColumns(10);

		stdMotherMiddleNameTextPane = new JTextPane();
		stdMotherMiddleNameTextPane.setBounds(270, 205, 90, 20);
		stdMotherMiddleNameTextPane.setBackground(bgColor);
		stdMotherMiddleNameTextPane.setText("Middle Name");
		stdMotherMiddleNameTextPane.setFocusable(false);
		stdMotherMiddleNameTextPane.setEditable(false);
		stdMotherMiddleName = new JTextField();
		stdMotherMiddleName.setBounds(360, 205, 130, 20);
		stdMotherMiddleName.setColumns(10);

		stdMotherLastNameTextPane = new JTextPane();
		stdMotherLastNameTextPane.setBounds(520, 205, 80, 20);
		stdMotherLastNameTextPane.setBackground(bgColor);
		stdMotherLastNameTextPane.setText("Last Name");
		stdMotherLastNameTextPane.setFocusable(false);
		stdMotherLastNameTextPane.setEditable(false);
		stdMotherLastName = new JTextField();
		stdMotherLastName.setColumns(10);
		stdMotherLastName.setBounds(610, 205, 130, 20);

		// Second Row
		stdMotherMobNoTextPane = new JTextPane();
		stdMotherMobNoTextPane.setBounds(20, 245, 80, 20);
		stdMotherMobNoTextPane.setBackground(bgColor);
		stdMotherMobNoTextPane.setText("Mobile");
		stdMotherMobNoTextPane.setFocusable(false);
		stdMotherMobNoTextPane.setEditable(false);
		stdMotherMobNo = new JFormattedTextField(returnFormatter(MOB_DIGIT));
		stdMotherMobNo.setBounds(110, 245, 130, 20);

		stdMotherOccupationTextPane = new JTextPane();
		stdMotherOccupationTextPane.setBounds(270, 245, 80, 20);
		stdMotherOccupationTextPane.setBackground(bgColor);
		stdMotherOccupationTextPane.setText("Occupation");
		stdMotherOccupationTextPane.setFocusable(false);
		stdMotherOccupationTextPane.setEditable(false);
		stdMotherOccupation = new JComboBox(occupationChoices);
		stdMotherOccupation.setBounds(360, 245, 130, 20);

		stdMotherEmailTextPane = new JTextPane();
		stdMotherEmailTextPane.setBounds(520, 245, 80, 20);
		stdMotherEmailTextPane.setBackground(bgColor);
		stdMotherEmailTextPane.setText("E-Mail");
		stdMotherEmailTextPane.setFocusable(false);
		stdMotherEmailTextPane.setEditable(false);
		stdMotherEmail = new JTextField();
		stdMotherEmail.setColumns(10);
		stdMotherEmail.setBounds(610, 245, 130, 20);
		
		
		stdRegNextFrame = new JButton("Continue");
		stdRegNextFrame.setBounds(((frameLength/2)-60), frameheigth - 100, 120, 25);
	}
	
	private void initListneres()
	{
		//////////////////////////////////////////////////////////////////////
		//////////////////////////////Listener///////////////////////////////
		//////////////////////////////////////////////////////////////////////
		
		// Button Registration Listener.
		stdRegNextFrame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if( !checkFather() )
				{
					return;
				}
				if( !checkMother() )
				{
					return;
				}
				
				CompStudentReg2 reg = new CompStudentReg2();
				reg.compStudentReg2.setVisible(true);
				compStudentReg1.dispose();
			}
		});
		
		stdFatherMobNo.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE )
				{
					if( stdFatherMobNo.getText().length() == 1 )
					{
						stdFatherMobNo.setText("0");
					}
				}
			}
		});
		stdMotherMobNo.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE )
				{
					if( stdMotherMobNo.getText().length() == 1 )
					{
						stdMotherMobNo.setText("0");
					}
				}
			}
		});
	}
	
	private void initializeFrame()
	{
		compStudentReg1 = new JFrame("Student Registration Continued");
		compStudentReg1.setBounds(framex, framey, frameLength, frameheigth);
		compStudentReg1.setBackground(bgColor);
		compStudentReg1.getContentPane().setLayout(null);
	}
	
	private boolean checkFather()
	{
		if( stdFatherFirstName.getText().equals("") || stdFatherLastName.getText().equals("") ||
				stdFatherMobNo.getText().equals("") || stdFatherEmail.getText().equals("") ||
				stdFatherOccupation.getSelectedIndex() == 0 )
		{
			JOptionPane.showMessageDialog(null, "Complete Father's Details");
			return false;
		}
		if( stdFatherMobNo.getText().length() != 10 )
		{
			JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
			return false;
		}
		return true;
	}
	private boolean checkMother()
	{
		if( stdMotherFirstName.getText().equals("") || stdMotherLastName.getText().equals("") ||
				stdMotherMobNo.getText().equals("") || stdMotherEmail.getText().equals("") ||
				stdMotherOccupation.getSelectedIndex() == 0 )
		{
			JOptionPane.showMessageDialog(null, "Complete Father's Details");
			return false;
		}
		if( stdMotherMobNo.getText().length() != 10 )
		{
			JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
			return false;
		}
		return true;
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
