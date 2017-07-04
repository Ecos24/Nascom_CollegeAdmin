package memberGUI;

import java.awt.Color;

import javax.swing.JFrame;

public class StudentFrame 
{
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 450;
	private static final int frameheigth = 300;
	private Color bgColor;
	
	public JFrame studentFrame;
	
	public StudentFrame()
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
		studentFrame = new JFrame("Student");
		studentFrame.setBounds(framex, framey, frameLength, frameheigth);
		studentFrame.setBackground(bgColor);
		studentFrame.getContentPane().setLayout(null);
		studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//studentFrame.setVisible(true);
		studentFrame.setResizable(false);
	}
}
