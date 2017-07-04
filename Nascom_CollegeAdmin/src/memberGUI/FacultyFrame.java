package memberGUI;

import java.awt.Color;

import javax.swing.JFrame;

public class FacultyFrame
{
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 450;
	private static final int frameheigth = 300;
	private Color bgColor;
	
	public JFrame facultyFrame;
	
	public FacultyFrame()
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
		facultyFrame = new JFrame("Faculty");
		facultyFrame.setBounds(framex, framey, frameLength, frameheigth);
		facultyFrame.setBackground(bgColor);
		facultyFrame.getContentPane().setLayout(null);
		facultyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//studentFrame.setVisible(true);
		facultyFrame.setResizable(false);
	}
}
