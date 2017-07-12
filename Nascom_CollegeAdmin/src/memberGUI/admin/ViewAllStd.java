package memberGUI.admin;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import extraClasses.ViewEditStdFac;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewAllStd
{
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 450;
	private static final int frameheigth = 300;
	private Color bgColor;
	
	public JFrame viewEditStd;
	private JTable stdTable;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	
	public ViewAllStd()
	{
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		initListeners();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		viewEditStd.getContentPane().add(scroll);
	}
	
	private void initComponents()
	{
		stdTable = new JTable();
		
		scroll = new JScrollPane(stdTable);
		scroll.setBounds(1, 1, frameLength-1, frameheigth-1);
		
		Object[] columns = {"Student Id", "Student Name"};
		tableModel = new DefaultTableModel()
				{
					private static final long serialVersionUID = 1L;

					@Override
					public boolean isCellEditable(int arg0, int arg1)
					{
						return false;
						//return super.isCellEditable(arg0, arg1);
					}
				};
		tableModel.setColumnIdentifiers(columns);
		stdTable.setModel(tableModel);
		stdTable.setRowHeight(30);
		ViewEditStdFac.populateTable(tableModel, false);		
	}
	
	private void initListeners()
	{
		// Add Listeners here.
		stdTable.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent event)
			{
				if( event.getClickCount() == 2 )
				{
					int i = stdTable.getSelectedRow();
					JOptionPane.showMessageDialog(viewEditStd, "Doube Clicked "+tableModel.getValueAt(i, 0
							));
				}
			}
		});
	}
	
	private void initializeFrame()
	{
		viewEditStd = new JFrame("View Student");
		viewEditStd.setBounds(framex, framey, frameLength, frameheigth);
		viewEditStd.setBackground(bgColor);
		viewEditStd.getContentPane().setLayout(null);
		viewEditStd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewEditStd.setResizable(false);
		
		viewEditStd.addWindowListener( new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent arg0)
				{
					MainGUI admin = new MainGUI();
					admin.adminMainGUI.setVisible(true);
					super.windowClosing(arg0);
				}
			});
	}
}