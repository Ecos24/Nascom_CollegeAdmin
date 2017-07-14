package memberGUI.student;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import swingGUIPack.MainFrame;

public class MainStdGUI
{
	private String stdId;
	
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
	
	public JFrame stdMainGUI;
	
	private JButton viewTimetable;
	private JButton viewMarks;
	private JButton viewDetails;
	private JButton logOut;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				MainStdGUI window = new MainStdGUI("101");
				window.stdMainGUI.setVisible(true);
			}
		});
	}
	
	public MainStdGUI(String stdId)
	{  
		this.stdId = stdId;
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		initListeners();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		stdMainGUI.getContentPane().add(viewTimetable);
		stdMainGUI.getContentPane().add(viewMarks);
		stdMainGUI.getContentPane().add(viewDetails);
		stdMainGUI.getContentPane().add(logOut);

		//logInFrame.getRootPane().setDefaultButton(LogIn);
	}
	
	private void initComponents()
	{
		viewTimetable = new JButton("View Timetable");
		viewTimetable.setBounds(30, 70, Button_Length, Button_Height);
		
		viewMarks = new JButton("View Marks");
		viewMarks.setBounds(30, 110, Button_Length, Button_Height);
		
		viewDetails = new JButton("View Details");
		viewDetails.setBounds(30, 150, Button_Length, Button_Height);
		
		logOut = new JButton("LogOut");
		logOut.setBounds( logOutX , LogOut_Padding,
				LogOut_Button_Length, LogOut_Button_Height);
	}
	
	private void initListeners()
	{		
		viewDetails.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				StdDetailedView reg = new StdDetailedView(stdId, MainStdGUI.class.getName());
				reg.stdDetailedView.setVisible(true);
				stdMainGUI.dispose();
			}
		});
		
		logOut.addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				new MainFrame();
				stdMainGUI.dispose();
			}
		});
	}
	
	private void initializeFrame()
	{
		stdMainGUI = new JFrame("Student");
		stdMainGUI.setBounds(framex, framey, frameLength, frameheigth);
		stdMainGUI.setBackground(bgColor);
		stdMainGUI.getContentPane().setLayout(null);
		stdMainGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		stdMainGUI.setResizable(false);
		
		stdMainGUI.addWindowListener( new WindowAdapter()
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
