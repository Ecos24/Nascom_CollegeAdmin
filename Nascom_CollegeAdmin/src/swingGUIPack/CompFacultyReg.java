package swingGUIPack;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class CompFacultyReg
{
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 450;
	private static final int frameheigth = 300;
	private Color bgColor;
	
	private JFrame compFacultyReg;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				CompFacultyReg window = new CompFacultyReg();
				window.compFacultyReg.setVisible(true);
			}
		});
	}
	
	public CompFacultyReg()
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
