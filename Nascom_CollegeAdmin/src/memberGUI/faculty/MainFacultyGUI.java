package memberGUI.faculty;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import swingGUIPack.MainFrame;

public class MainFacultyGUI
{
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 400;
	private static final int frameheigth = 350;
	private Color bgColor;
	
	String facid;
	public JFrame facultyFrame;
	private CustomRoundButton facViewButton;
	private CustomRoundButton addMarksButton;
	private CustomRoundButton timeTableButton;
	private JButton logoutButton;
	
	public MainFacultyGUI(String fid)
	{
		this.facid = fid;
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		initListeners();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		facultyFrame.getContentPane().add(logoutButton);
		facultyFrame.getContentPane().add(facViewButton);
		facultyFrame.getContentPane().add(addMarksButton);
		facultyFrame.getContentPane().add(timeTableButton);

		//logInFrame.getRootPane().setDefaultButton(LogIn);
	}
	
	private void initComponents()
	{
		logoutButton = new JButton("LogOut");
		logoutButton.setBounds(240, 10, 100, 20);
		
		facViewButton = new CustomRoundButton("View Details");
		facViewButton.setBounds(25, 45, 125, 125);
		
		addMarksButton = new CustomRoundButton("Add Marks");
		addMarksButton.setBounds(205, 45, 125, 125);
		
		timeTableButton = new CustomRoundButton("Time Table");
		timeTableButton.setBounds(125, 195, 125, 125);
	}
	
	private void initListeners()
	{
		facViewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				FacultyDetails facDetails = new FacultyDetails(facid, this.getClass().getName());
				facDetails.facultyDetailsFrame.setVisible(true);
				facultyFrame.dispose();
			}
		});
		
		logoutButton.addActionListener( new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				new MainFrame();	
				facultyFrame.dispose();
			}
		});
	}
	
	private void initializeFrame()
	{
		facultyFrame = new JFrame("Faculty");
		facultyFrame.setBounds(framex, framey, frameLength, frameheigth);
		facultyFrame.setBackground(bgColor);
		facultyFrame.getContentPane().setLayout(null);
		facultyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		facultyFrame.setResizable(false);
		
		facultyFrame.addWindowListener( new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent arg0)
			{
				new MainFrame();
				super.windowClosing(arg0);
			}
		});
	}
}
