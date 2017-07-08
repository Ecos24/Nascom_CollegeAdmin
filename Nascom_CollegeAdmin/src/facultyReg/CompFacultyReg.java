package facultyReg;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import beanClasses.User;

public class CompFacultyReg
{
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 450;
	private static final int frameheigth = 300;
	private Color bgColor;
	
	public JFrame compFacultyReg;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				/*CompFacultyReg window = new CompFacultyReg();
				window.compFacultyReg.setVisible(true);*/
			}
		});
	}
	
	public CompFacultyReg(User user)
	{
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		//logInFrame.getContentPane().add(LogIn);		

		//logInFrame.getRootPane().setDefaultButton(LogIn);
	}
	
	private void initComponents()
	{
		
	}
	
	private void initializeFrame()
	{
		compFacultyReg = new JFrame("Faculty Registration");
		compFacultyReg.setBounds(framex, framey, frameLength, frameheigth);
		compFacultyReg.setBackground(bgColor);
		compFacultyReg.getContentPane().setLayout(null);
		compFacultyReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		compFacultyReg.setResizable(false);
	}
}
