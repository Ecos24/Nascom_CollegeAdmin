package swingGUIPack;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import beanClasses.User;
import dbConnection.GetDBConnection;
import memberGUI.admin.MainGUI;
import memberGUI.faculty.MainFacultyGUI;
import memberGUI.student.MainStdGUI;
import userRegLog.Authenticate;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MainFrame
{
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 450;
	private static final int frameheigth = 300;
	private Color bgColor;
	
	private JFrame logInFrame;
	private JButton LogIn;
	private JPasswordField password;
	private JTextField userName;
	private JTextPane userNameTextPane;
	private JTextPane passwordTextPane;
	private JLabel bgLabel;

	public static void main(String[] args)
	{
		try
		{
			GetDBConnection.getConnection();
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println("Exception Handeled initialy.");
		}
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				MainFrame window = new MainFrame();
				window.logInFrame.setVisible(true);
			}
		});
	}

	public MainFrame()
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
		logInFrame.getContentPane().add(LogIn);
		logInFrame.getContentPane().add(userName);
		logInFrame.getContentPane().add(password);
		logInFrame.getContentPane().add(userNameTextPane);
		logInFrame.getContentPane().add(passwordTextPane);
		logInFrame.getContentPane().add(bgLabel);		

		logInFrame.getRootPane().setDefaultButton(LogIn);
	}
	
	private void initComponents()
	{
		userNameTextPane = new JTextPane();
		userNameTextPane.setBackground(bgColor);
		userNameTextPane.setBounds(45, 120, 80, 20);
		userNameTextPane.setText("User Name");
		userNameTextPane.setEditable(false);
		userNameTextPane.setFocusable(false);
		userName = new JTextField();
		userName.setBounds(145, 120, 154, 20);

		passwordTextPane = new JTextPane();
		passwordTextPane.setBackground(bgColor);
		passwordTextPane.setBounds(45, 170, 80, 20);
		passwordTextPane.setText("Password");
		passwordTextPane.setEditable(false);
		passwordTextPane.setFocusable(false);
		password = new JPasswordField();
		password.setBounds(145, 170, 154, 20);
		
		LogIn = new JButton("LogIn");
		LogIn.setBounds(157, 218, 131, 20);
		
		// Background Label.
		bgLabel = new JLabel();
		bgLabel.setBounds(190, 20, 61, 85);
		bgLabel.setIcon(new ImageIcon("images/logo.png"));
	}
	

	/////////////////////////////////////////////////////////////////////////
	//////////////////////////Listeners//////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////
	private void initListeners()
	{
		LogIn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String userN = userName.getText().toLowerCase();
				String pass = String.valueOf(password.getPassword());
				if( !userN.equals("") &&  !pass.equals("") )
				{
					User user = new User();
					user.setUserName(userN);
	                user.setPassword(pass);
	                Authenticate auth = new Authenticate(user);
	                try
	                {
	                	ResultSet authUser = auth.authenticateUser();
		                if( authUser != null )
		                {
		                    System.out.println("User Authenticated");
		                    if( authUser.getString("usertype").equals("admin") )
		                    {
		                    	MainGUI admin = new MainGUI();
		                    	admin.adminMainGUI.setVisible(true);
		                    	logInFrame.dispose();
		                    }
		                    else if( authUser.getString("usertype").toLowerCase().equals("student") )
		                	{
		                		MainStdGUI student = new MainStdGUI(authUser.getString("userid"));
		                		student.stdMainGUI.setVisible(true);
		                		logInFrame.dispose();
		                	}
		                	else if( authUser.getString("usertype").equals("faculty") )
		                	{
		                		MainFacultyGUI faculty = new MainFacultyGUI();
		                		faculty.facultyFrame.setVisible(true);
		                		logInFrame.dispose();
		                	}
		                }
		                else
		                {
		                    System.out.println("User Invalid");
		                    JOptionPane.showMessageDialog(logInFrame, "Invalid UserName/Password");
		                }
	                }
	                catch(ClassNotFoundException e)
	                {
	                	JOptionPane.showMessageDialog(logInFrame, "User Can't Be Authenticated Internal Application Error!!");
	                	System.out.println("JDBC connector Class Not Found.");
					}
	                catch(SQLException e)
	                {
	                	JOptionPane.showMessageDialog(logInFrame, "User Can't Be Authenticated Internal Application Error!!");
	                	System.out.println("Exception --> "+e.getMessage());
					}
				}
				else if( userN.equals("") )
				{
					JOptionPane.showMessageDialog(logInFrame, "Please provide UserName!!");
				}
				else if( pass.equals("") )
				{
					JOptionPane.showMessageDialog(logInFrame, "Please provide Password!!");
				}
			}
		});
	}
	
	private void initializeFrame()
	{
		logInFrame = new JFrame("College Administration");
		logInFrame.setBounds(framex, framey, frameLength, frameheigth);
		logInFrame.setBackground(bgColor);
		logInFrame.getContentPane().setLayout(null);
		logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logInFrame.setVisible(true);
		logInFrame.setResizable(false);
	}
}