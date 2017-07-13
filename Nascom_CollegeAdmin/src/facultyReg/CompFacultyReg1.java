package facultyReg;

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
import facultyReg.CompFacultyReg2;
import memberGUI.admin.MainGUI;
import beanClasses.FacultyUser;

public class CompFacultyReg1
{
	private FacultyUser user;
		
	private static final long MOB_LIMIT = 9999999999l;
	private static final int MOB_DIGIT_LENGTH = 10;
	private static final int framex = 0;
	private static final int framey = 0;
	private static final int frameLength = 500;
	private static final int frameheigth = 300;
	private Color bgColor;
		
	public JFrame compFacultyReg1;
		
	// Section 4.
	private JTextPane section4Header;
	private JSeparator section4Separator;
	@SuppressWarnings("rawtypes")
	private JComboBox guardianSalutation;
	private JTextField facGuardianName;
	private JFormattedTextField facGuardianMobNo;
	@SuppressWarnings("rawtypes")
	private JComboBox facGuardianOccupation;
	private JTextField facGuardianEmail;
	private JTextPane facGuardianNameTextPane;
	private JTextPane facGuardianMobNoTextPane;
	private JTextPane facGuardianOccupationTextPane;
	private JTextPane facGuardianEmailTextPane;
		
	private JButton facRegNextFrame;
		
	/**
	 * @wbp.parser.entryPoint
	*/
	public CompFacultyReg1(FacultyUser user)
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
		compFacultyReg1.getContentPane().add(section4Header);
		compFacultyReg1.getContentPane().add(section4Separator);
		compFacultyReg1.getContentPane().add(facGuardianNameTextPane);
		compFacultyReg1.getContentPane().add(facGuardianName);
		compFacultyReg1.getContentPane().add(guardianSalutation);
		compFacultyReg1.getContentPane().add(facGuardianMobNoTextPane);
		compFacultyReg1.getContentPane().add(facGuardianMobNo);
		compFacultyReg1.getContentPane().add(facGuardianOccupationTextPane);
		compFacultyReg1.getContentPane().add(facGuardianOccupation);
		compFacultyReg1.getContentPane().add(facGuardianEmailTextPane);
		compFacultyReg1.getContentPane().add(facGuardianEmail);
			
		compFacultyReg1.getContentPane().add(facRegNextFrame);
		compFacultyReg1.getRootPane().setDefaultButton(facRegNextFrame);
	}
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents()
	{
		//////////////////////////////////////////////////////////////////
		////////////////////// FOURTH SECTION/////////////////////////////
		//////////////////////////////////////////////////////////////////
		section4Header = new JTextPane();
		section4Header.setFont(new Font("Dialog", Font.BOLD, 16));
		section4Header.setBounds(20, 30, 170, 20);
		section4Header.setBackground(bgColor);
		section4Header.setText("Guardian's Details");
		section4Header.setFocusable(false);
		section4Header.setEditable(false);
		section4Separator = new JSeparator(SwingConstants.HORIZONTAL);
		section4Separator.setBounds(0, 42, frameLength, 2);

		// First Row
		facGuardianNameTextPane = new JTextPane();
		facGuardianNameTextPane.setBounds(20, 90, 80, 20);
		facGuardianNameTextPane.setBackground(bgColor);
		facGuardianNameTextPane.setText("Name");
		facGuardianNameTextPane.setFocusable(false);
		facGuardianNameTextPane.setEditable(false);
		String[] salutationChoices = { "Select", "Mr.", "Mrs.", "Ms.", "Dr." };
		guardianSalutation = new JComboBox(salutationChoices);
		guardianSalutation.setBounds(110, 90, 60, 20);
		facGuardianName = new JTextField();
		facGuardianName.setBounds(180, 90, 291, 20);
		facGuardianName.setColumns(10);

		// Second Row
		facGuardianMobNoTextPane = new JTextPane();
		facGuardianMobNoTextPane.setBounds(20, 130, 80, 20);
		facGuardianMobNoTextPane.setBackground(bgColor);
		facGuardianMobNoTextPane.setText("Mobile");
		facGuardianMobNoTextPane.setFocusable(false);
		facGuardianMobNoTextPane.setEditable(false);
		facGuardianMobNo = new JFormattedTextField(returnFormatter(MOB_LIMIT));
		facGuardianMobNo.setBounds(110, 130, 130, 20);

		facGuardianOccupationTextPane = new JTextPane();
		facGuardianOccupationTextPane.setBounds(250, 130, 80, 20);
		facGuardianOccupationTextPane.setBackground(bgColor);
		facGuardianOccupationTextPane.setText("Occupation");
		facGuardianOccupationTextPane.setFocusable(false);
		facGuardianOccupationTextPane.setEditable(false);
		String[] occupationChoices = { "Select", "Engineer", "Doctor", "Armed Forces",
				"Government Employed","Self Employed" };
		facGuardianOccupation = new JComboBox(occupationChoices);
		facGuardianOccupation.setBounds(340, 130, 130, 20);

		facGuardianEmailTextPane = new JTextPane();
		facGuardianEmailTextPane.setBounds(20, 170, 80, 20);
		facGuardianEmailTextPane.setBackground(bgColor);
		facGuardianEmailTextPane.setText("E-Mail");
		facGuardianEmailTextPane.setFocusable(false);
		facGuardianEmailTextPane.setEditable(false);
		facGuardianEmail = new JTextField();
		facGuardianEmail.setBounds(110, 170, 250, 20);

		facRegNextFrame = new JButton("Continue");
		facRegNextFrame.setBounds((frameLength/2 - 60), (frameheigth - 80), 120, 30);
	}

	//////////////////////////////////////////////////////////////////////
	////////////////////////////// Listener///////////////////////////////
	//////////////////////////////////////////////////////////////////////
	private void initListneres()
	{
		// Button Registration Listener.
		facRegNextFrame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (!checkGuardian())
				{
					return;
				}
				
				user.setGuardianName(facGuardianName.getText());
				user.setGuardianMobNo(Long.parseLong(facGuardianMobNo.getText()));
				user.setGuardianEMail(facGuardianEmail.getText());

				CompFacultyReg2 reg = new CompFacultyReg2(user);
				reg.compFacultyReg2.setVisible(true);
				compFacultyReg1.dispose();
			}
		});

		facGuardianMobNo.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyReleased(KeyEvent arg0)
			{
				if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE || arg0.getKeyCode() == KeyEvent.VK_DELETE)
				{
					if (facGuardianMobNo.getText().length() == 1)
					{
						facGuardianMobNo.setText("0");
					}
				}
			}
		});
	}

	private void initializeFrame()
	{
		compFacultyReg1 = new JFrame("Faculty Registration Continued");
		compFacultyReg1.setBounds(framex, framey, frameLength, frameheigth);
		compFacultyReg1.setBackground(bgColor);
		compFacultyReg1.getContentPane().setLayout(null);
		compFacultyReg1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		compFacultyReg1.setResizable(false);
		
		compFacultyReg1.addWindowListener(new WindowAdapter()
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
	private boolean checkGuardian()
	{
		if (facGuardianName.getText().equals("") || facGuardianMobNo.getText().equals("")
				|| facGuardianEmail.getText().equals("") || facGuardianOccupation.getSelectedIndex() == 0)
		{
			JOptionPane.showMessageDialog(null, "Complete Guardian's Details");
			return false;
		}
		if (facGuardianMobNo.getText().length() != MOB_DIGIT_LENGTH)
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