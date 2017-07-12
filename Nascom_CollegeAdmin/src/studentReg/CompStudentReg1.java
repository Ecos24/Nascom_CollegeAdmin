package studentReg;

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
import javax.swing.text.NumberFormatter;

import beanClasses.StudentUser;
import memberGUI.admin.MainGUI;

public class CompStudentReg1
{
	private StudentUser user;
	
	
	private static final long MOB_DIGIT = 9999999999l;
	private static final int MOB_DIGIT_LENGTH = 10;
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
	private JTextField stdFatherName;
	private JFormattedTextField stdFatherMobNo;
	@SuppressWarnings("rawtypes")
	private JComboBox stdFatherOccupation;
	private JTextField stdFatherEmail;
	private JTextPane stdFatherNameTextPane;
	private JTextPane stdFatherMobNoTextPane;
	private JTextPane stdFatherOccupationTextPane;
	private JTextPane stdFatherEmailTextPane;
	private JTextPane stdMotherHeader;
	private JSeparator stdMotherSeparator;
	private JTextField stdMotherName;
	private JFormattedTextField stdMotherMobNo;
	@SuppressWarnings("rawtypes")
	private JComboBox stdMotherOccupation;
	private JTextField stdMotherEmail;
	private JTextPane stdMotherNameTextPane;
	private JTextPane stdMotherMobNoTextPane;
	private JTextPane stdMotherOccupationTextPane;
	private JTextPane stdMotherEmailTextPane;
	
	private JButton stdRegNextFrame;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public CompStudentReg1(StudentUser user)
	{
		this.user = user;
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
		compStudentReg1.getContentPane().add(stdFatherNameTextPane);
		compStudentReg1.getContentPane().add(stdFatherName);
		compStudentReg1.getContentPane().add(stdFatherMobNoTextPane);
		compStudentReg1.getContentPane().add(stdFatherMobNo);
		compStudentReg1.getContentPane().add(stdFatherOccupationTextPane);
		compStudentReg1.getContentPane().add(stdFatherOccupation);
		compStudentReg1.getContentPane().add(stdFatherEmailTextPane);
		compStudentReg1.getContentPane().add(stdFatherEmail);
		compStudentReg1.getContentPane().add(stdMotherHeader);
		compStudentReg1.getContentPane().add(stdMotherSeparator);
		compStudentReg1.getContentPane().add(stdMotherNameTextPane);
		compStudentReg1.getContentPane().add(stdMotherName);
		compStudentReg1.getContentPane().add(stdMotherMobNoTextPane);
		compStudentReg1.getContentPane().add(stdMotherMobNo);
		compStudentReg1.getContentPane().add(stdMotherOccupationTextPane);
		compStudentReg1.getContentPane().add(stdMotherOccupation);
		compStudentReg1.getContentPane().add(stdMotherEmailTextPane);
		compStudentReg1.getContentPane().add(stdMotherEmail);
		
		compStudentReg1.getContentPane().add(stdRegNextFrame);
		compStudentReg1.getRootPane().setDefaultButton(stdRegNextFrame);
		
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
		stdFatherNameTextPane = new JTextPane();
		stdFatherNameTextPane.setBounds(20, 93, 80, 20);
		stdFatherNameTextPane.setBackground(bgColor);
		stdFatherNameTextPane.setText("Name");
		stdFatherNameTextPane.setFocusable(false);
		stdFatherNameTextPane.setEditable(false);
		stdFatherName = new JTextField();
		stdFatherName.setBounds(110, 93, 380, 20);
		stdFatherName.setColumns(10);

		stdFatherEmailTextPane = new JTextPane();
		stdFatherEmailTextPane.setBounds(520, 93, 80, 20);
		stdFatherEmailTextPane.setBackground(bgColor);
		stdFatherEmailTextPane.setText("E-Mail");
		stdFatherEmailTextPane.setFocusable(false);
		stdFatherEmailTextPane.setEditable(false);
		stdFatherEmail = new JTextField();
		stdFatherEmail.setBounds(610, 93, 130, 20);

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
		stdMotherNameTextPane = new JTextPane();
		stdMotherNameTextPane.setBounds(20, 205, 80, 20);
		stdMotherNameTextPane.setBackground(bgColor);
		stdMotherNameTextPane.setText("Name");
		stdMotherNameTextPane.setFocusable(false);
		stdMotherNameTextPane.setEditable(false);
		stdMotherName = new JTextField();
		stdMotherName.setBounds(110, 205, 380, 20);



		stdMotherEmailTextPane = new JTextPane();
		stdMotherEmailTextPane.setBounds(520, 205, 80, 20);
		stdMotherEmailTextPane.setBackground(bgColor);
		stdMotherEmailTextPane.setText("E-Mail");
		stdMotherEmailTextPane.setFocusable(false);
		stdMotherEmailTextPane.setEditable(false);
		stdMotherEmail = new JTextField();
		stdMotherEmail.setBounds(610, 205, 130, 20);

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
				
				user.setFatherName(stdFatherName.getText());
				user.setFatherMobNo(Long.parseLong(stdFatherMobNo.getText()));
				user.setFatherOccupation((String)stdFatherOccupation.getSelectedItem());
				user.setFatherEMail(stdFatherEmail.getText());
				user.setMotherName(stdMotherName.getText());
				user.setMotherMobNo(Long.parseLong(stdMotherMobNo.getText()));
				user.setMotherOccupation((String)stdMotherOccupation.getSelectedItem());
				user.setMotherEMail(stdMotherEmail.getText());
				CompStudentReg2 reg = new CompStudentReg2(user);
				reg.compStudentReg2.setVisible(true);
				compStudentReg1.dispose();
			}
		});
		
		stdFatherMobNo.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE )
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
				if( arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE )
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
		compStudentReg1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		compStudentReg1.addWindowListener(new WindowAdapter()
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
	private boolean checkFather()
	{
		if( stdFatherName.getText().equals("") || stdFatherMobNo.getText().equals("") || 
				stdFatherEmail.getText().equals("") || stdFatherOccupation.getSelectedIndex() == 0 )
		{
			JOptionPane.showMessageDialog(null, "Complete Father's Details");
			return false;
		}
		if( stdFatherMobNo.getText().length() != MOB_DIGIT_LENGTH )
		{
			JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
			return false;
		}
		return true;
	}
	private boolean checkMother()
	{
		if( stdMotherName.getText().equals("") || stdMotherMobNo.getText().equals("") ||
				stdMotherEmail.getText().equals("") || stdMotherOccupation.getSelectedIndex() == 0 )
		{
			JOptionPane.showMessageDialog(null, "Complete Mother's Details");
			return false;
		}
		if( stdMotherMobNo.getText().length() != MOB_DIGIT_LENGTH )
		{
			JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
			return false;
		}
		return true;
	}
	
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
}
