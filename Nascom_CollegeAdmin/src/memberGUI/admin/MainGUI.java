package memberGUI.admin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import swingGUIPack.MainFrame;
import swingGUIPack.Register;

public class MainGUI
{
	private static final int Button_Height = 30;
	private static final int Button_Length = 230;
	private static final int LogOut_Button_Height = 20;
	private static final int LogOut_Button_Length = 100;
	private static final int LogOut_Padding = 10;
	
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 450;
	private static final int frameheigth = 300;
	private Color bgColor;
	
	private static final int logOutX = frameLength-LogOut_Button_Length-LogOut_Padding;
	
	public JFrame adminMainGUI;
	
	private JButton regStdFac;
	private JButton viewEditStd;
	private JButton viewEditFac;
	private JButton logOut;
	
	public MainGUI()
	{  
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		initListeners();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		adminMainGUI.getContentPane().add(regStdFac);
		adminMainGUI.getContentPane().add(viewEditStd);
		adminMainGUI.getContentPane().add(viewEditFac);
		adminMainGUI.getContentPane().add(logOut);

		//logInFrame.getRootPane().setDefaultButton(LogIn);
	}
	
	private void initComponents()
	{
		regStdFac = new JButton("Rgister Student/Faculty");
		regStdFac.setBounds(30, 70, Button_Length, Button_Height);
		
		viewEditStd = new JButton("View/Edit Student");
		viewEditStd.setBounds(30, 110, Button_Length, Button_Height);
		
		viewEditFac = new JButton("View/Edit Faculty");
		viewEditFac.setBounds(30, 150, Button_Length, Button_Height);
		
		logOut = new JButton("LogOut");
		logOut.setBounds( logOutX , LogOut_Padding,
				LogOut_Button_Length, LogOut_Button_Height);
	}
	
	private void initListeners()
	{
		viewEditStd.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				ViewAllStd viewStd = new ViewAllStd();
				viewStd.viewEditStd.setVisible(true);
				adminMainGUI.dispose();
			}
		});
		
		regStdFac.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				Register reg = new Register();
				reg.regFrame.setVisible(true);
				adminMainGUI.dispose();
			}
		});
		
		logOut.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				new MainFrame();
				adminMainGUI.dispose();
			}
		});
	}
	
	private void initializeFrame()
	{
		adminMainGUI = new JFrame("Admin");
		adminMainGUI.setBounds(framex, framey, frameLength, frameheigth);
		adminMainGUI.setBackground(bgColor);
		adminMainGUI.getContentPane().setLayout(null);
		adminMainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminMainGUI.setResizable(false);
	}
}