package swingGUIPack;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import beanClasses.User;
import userRegLog.RegisterUser;
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
		String[] profileTypeChoices = {"Student","Faculty"};
		profileType = new JComboBox(profileTypeChoices);
		profileType.setBounds(135, 50, 154, 20);

		userNameTextPane = new JTextPane();
		userNameTextPane.setBackground(bgColor);
		userNameTextPane.setBounds(35, 100, 80, 20);
		userNameTextPane.setText("User Name");
		userNameTextPane.setEditable(false);
		userNameTextPane.setFocusable(false);
		userName = new JTextField();
		userName.setBounds(135, 100, 154, 20);

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
		
		/////////////////////////////////////////////////////////////////////////
		//////////////////////////Listner's///////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		Register.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String userN = userName.getText().toLowerCase();
				String pass = String.valueOf(password.getPassword());
				String userT = profileType.getItemAt(profileType.getSelectedIndex()).toString().toLowerCase();
				if( !userN.equals("") &&  !pass.equals("") )
				{
					User user = new User();
	                user.setUserName(userN);
	                user.setPassword(pass);
	                user.setUserType( userT );
	                RegisterUser reg = new RegisterUser(user);
	                try
	                {
	                	if( reg.registerUser() )
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
	                	JOptionPane.showMessageDialog(regFrame, "User Not Registered Internal Application Error!!");
	                	System.out.println("JDBC connector Class Not Found.");
					}
	                catch(SQLException e)
	                {
	                	JOptionPane.showMessageDialog(regFrame, "User Not Registered Internal Application Error!!");
	                	System.out.println("Exception --> "+e.getMessage());
					}
				}
				else if( userN.equals("") )
				{
					JOptionPane.showMessageDialog(regFrame, "Please provide UserName!!");
				}
				else if( pass.equals("") )
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
