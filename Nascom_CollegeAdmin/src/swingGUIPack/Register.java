package swingGUIPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import beanClasses.User;
import facultyReg.CompFacultyReg;
import memberGUI.admin.MainGUI;
import studentReg.CompStudentReg;
import userRegLog.RegisterUtility;

import javax.swing.JComboBox;
import java.awt.Color;

public class Register
{
	public JFrame regFrame;
	private JButton Register;
	private JPasswordField password;
	private JTextField userName;
	@SuppressWarnings("rawtypes")
	private JComboBox profileType;
	@SuppressWarnings("rawtypes")
	private JComboBox userBranch;
	private JTextPane userBranchTextPane;
	private JTextPane userNameTextPane;
	private JTextPane passwordTextPane;
	private JTextPane userTypeTextPane;
	private Color bgColor;

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
		regFrame.getContentPane().add(userBranch);
		regFrame.getContentPane().add(userBranchTextPane);
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
		userTypeTextPane.setBounds(35, 30, 80, 20);
		userTypeTextPane.setText("Profile Type");
		userTypeTextPane.setEditable(false);
		userTypeTextPane.setFocusable(false);
		String[] profileTypeChoices = {"Select","Student","Faculty"};
		profileType = new JComboBox(profileTypeChoices);
		profileType.setSelectedIndex(0);
		profileType.setBounds(135, 30, 154, 20);
		
		userBranchTextPane = new JTextPane();
		userBranchTextPane.setBackground(bgColor);
		userBranchTextPane.setBounds(35, 70, 80, 20);
		userBranchTextPane.setText("Branch");
		userBranchTextPane.setEditable(false);
		userBranchTextPane.setFocusable(false);
		String[] userBranchChoices = { "Select", "BCS", "BIT", "BCE", "BME", "BEC", "BEE" };
		userBranch = new JComboBox(userBranchChoices);
		userBranch.setSelectedIndex(0);
		userBranch.setBounds(135, 70, 154, 20);

		userNameTextPane = new JTextPane();
		userNameTextPane.setBackground(bgColor);
		userNameTextPane.setBounds(35, 110, 80, 20);
		userNameTextPane.setText("User Name");
		userNameTextPane.setEditable(false);
		userNameTextPane.setFocusable(false);
		userName = new JTextField();
		userName.setBounds(135, 110, 154, 20);
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
		Register.setBounds(147, 200, 131, 20);
	}

	/////////////////////////////////////////////////////////////////////////
	///////////////////////////Listner's/////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////
	private void initListeners()
	{
		profileType.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( userBranch.getSelectedIndex() != 0 )
				{
					if (profileType.getItemAt(profileType.getSelectedIndex()).toString().toLowerCase()
							.equals("student"))
					{
						try
						{
							String id = RegisterUtility.getNewStdId((String)userBranch.getSelectedItem());
							userName.setText(id);
						}
						catch(ClassNotFoundException | SQLException err)
						{
							System.out.println(err.getClass().getName()+" Exception Occured while getting new Id --> "+err.getMessage());
						}
					}
					else if (profileType.getItemAt(profileType.getSelectedIndex()).toString().toLowerCase()
							.equals("faculty"))
					{
						try
						{
							String id = RegisterUtility.getNewFacId((String)userBranch.getSelectedItem());
							userName.setText(id);
						}
						catch(ClassNotFoundException | SQLException err)
						{
							System.out.println(err.getClass().getName()+" Exception Occured while getting new Id --> "+err.getMessage());
						}
					}
				}
			}
		});
		userBranch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if( userBranch.getSelectedIndex() == 0 )
				{
					userName.setText(null);
					return;
				}
				if (profileType.getItemAt(profileType.getSelectedIndex()).toString().toLowerCase().equals("student"))
				{
					try
					{
						String id = RegisterUtility.getNewStdId((String)userBranch.getSelectedItem());
						userName.setText(id);
					}
					catch(ClassNotFoundException | SQLException err)
					{
						System.out.println(err.getClass().getName()+" Exception Occured while getting new Id --> "+err.getMessage());
					}
					
				}
				else if (profileType.getItemAt(profileType.getSelectedIndex()).toString().toLowerCase()
						.equals("faculty"))
				{
					try
					{
						String id = RegisterUtility.getNewFacId((String)userBranch.getSelectedItem());
						userName.setText(id);
					}
					catch(ClassNotFoundException | SQLException e)
					{
						System.out.println(e.getClass().getName()+" Exception Occured while getting new Id --> "+e.getMessage());
					}
				}
			}
		});
		Register.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String userN = userName.getText().toLowerCase();
				String userB = (String)userBranch.getSelectedItem();
				String pass = String.valueOf(password.getPassword());
				String userT = profileType.getItemAt(profileType.getSelectedIndex()).toString().toLowerCase();
				if(!userN.equals("") && !pass.equals(""))
				{
					User user = new User();
					user.setUserName(userN);
					user.setBranch(userB);
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
					JOptionPane.showMessageDialog(regFrame, "Please provide Profile Type & Branch Both!!");
				}
				else if( userB.equals("Select"))
				{
					JOptionPane.showMessageDialog(regFrame, "Please provide Branch!!");
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
		regFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		regFrame.addWindowListener(new WindowAdapter()
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
}
