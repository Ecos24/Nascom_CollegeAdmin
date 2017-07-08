package swingGUIPack;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import beanClasses.User;
import facultyReg.CompFacultyReg;
import studentReg.CompStudentReg;
import javax.swing.JComboBox;
import java.awt.Color;

public class Register
{
	private JFrame regFrame;
	private JButton Register;
	private JPasswordField password;
	private JTextField userName;
	@SuppressWarnings("rawtypes")
	private JComboBox profileType;
	private JTextPane userNameTextPane;
	private JTextPane passwordTextPane;
	private JTextPane userTypeTextPane;
	private Color bgColor;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				Register window = new Register();
				window.regFrame.setVisible(true);
			}
		});
	}

	public Register()
	{
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		initListeners();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		//frame.setJMenuBar(menuBar);
		regFrame.getContentPane().add(Register);
		regFrame.getContentPane().add(userName);
		regFrame.getContentPane().add(password);
		regFrame.getContentPane().add(profileType);
		regFrame.getContentPane().add(userNameTextPane);
		regFrame.getContentPane().add(passwordTextPane);
		regFrame.getContentPane().add(userTypeTextPane);
		

		regFrame.getRootPane().setDefaultButton(Register);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents()
	{		
		userTypeTextPane = new JTextPane();
		userTypeTextPane.setBackground(bgColor);
		userTypeTextPane.setBounds(35, 50, 80, 20);
		userTypeTextPane.setText("Profile Type");
		userTypeTextPane.setEditable(false);
		userTypeTextPane.setFocusable(false);
		String[] profileTypeChoices = {"Select","Student","Faculty"};
		profileType = new JComboBox(profileTypeChoices);
		profileType.setSelectedIndex(0);
		profileType.setBounds(135, 50, 154, 20);

		userNameTextPane = new JTextPane();
		userNameTextPane.setBackground(bgColor);
		userNameTextPane.setBounds(35, 100, 80, 20);
		userNameTextPane.setText("User Name");
		userNameTextPane.setEditable(false);
		userNameTextPane.setFocusable(false);
		userName = new JTextField();
		userName.setBounds(135, 100, 154, 20);
		userName.setEnabled(false);

		passwordTextPane = new JTextPane();
		passwordTextPane.setBackground(bgColor);
		passwordTextPane.setBounds(35, 150, 80, 20);
		passwordTextPane.setText("Password");
		passwordTextPane.setEditable(false);
		passwordTextPane.setFocusable(false);
		password = new JPasswordField();
		password.setBounds(135, 150, 154, 20);
		
		Register = new JButton("Register");
		Register.setBounds(147, 198, 131, 20);
	}

	/////////////////////////////////////////////////////////////////////////
	///////////////////////////Listner's/////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////
	private void initListeners()
	{
		profileType.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (profileType.getItemAt(profileType.getSelectedIndex()).toString().toLowerCase().equals("student"))
				{
					// Code to fetch next ID from DB.
					userName.setText("STD2014bbs");
				}
				else if (profileType.getItemAt(profileType.getSelectedIndex()).toString().toLowerCase()
						.equals("faculty"))
				{
					userName.setText("FAC2014bbs");
				}
			}
		});
		Register.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String userN = userName.getText().toLowerCase();
				String pass = String.valueOf(password.getPassword());
				String userT = profileType.getItemAt(profileType.getSelectedIndex()).toString().toLowerCase();
				if(!userN.equals("") && !pass.equals(""))
				{
					User user = new User();
					user.setUserName(userN);
					user.setPassword(pass);
					user.setUserType(userT);

					if(user.getUserType().equals("student"))
					{
						CompStudentReg reg = new CompStudentReg(user);
						reg.compStudentReg.setVisible(true);
						regFrame.dispose();
					}
					else if(user.getUserType().equals("faculty"))
					{
						CompFacultyReg reg = new CompFacultyReg(user);
						reg.compFacultyReg.setVisible(true);
						regFrame.dispose();
					}
				}
				else if(userN.equals(""))
				{
					JOptionPane.showMessageDialog(regFrame, "Please provide Profile Type!!");
				}
				else if(pass.equals(""))
				{
					JOptionPane.showMessageDialog(regFrame, "Please provide Password!!");
				}
			}
		});
	}

	private void initializeFrame()
	{
		regFrame = new JFrame("Register User");
		regFrame.setBounds(100, 100, 450, 300);
		regFrame.setBackground(bgColor);
		regFrame.getContentPane().setLayout(null);
		regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regFrame.setVisible(true);
	}
}
