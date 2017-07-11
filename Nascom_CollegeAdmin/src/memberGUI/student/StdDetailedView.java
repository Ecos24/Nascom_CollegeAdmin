package memberGUI.student;

import java.awt.Color;

import javax.swing.JFrame;

public class StdDetailedView
{
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 450;
	private static final int frameheigth = 300;
	private Color bgColor;
	
	public JFrame stdDetailedView;
	
	public StdDetailedView(String stdId, String className)
	{
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		if( className.equals("memberGUI.student.MainStdGUI") )
			initEditable(1);
		else
			initEditable(0);
		initListeners();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		
	}
	
	private void initEditable(int which)
	{
		
	}
	
	private void initComponents()
	{
		
	}
	
	private void initListeners()
	{
		
	}
	
	private void initializeFrame()
	{
		stdDetailedView = new JFrame("Student Details");
		stdDetailedView.setBounds(framex, framey, frameLength, frameheigth);
		stdDetailedView.setBackground(bgColor);
		stdDetailedView.getContentPane().setLayout(null);
		stdDetailedView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		stdDetailedView.setResizable(false);
	}
}
