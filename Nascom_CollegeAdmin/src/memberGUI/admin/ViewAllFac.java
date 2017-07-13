package memberGUI.admin;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import extraClasses.ViewEditStdFac;

public class ViewAllFac
{
	private static final int framex = 100;
	private static final int framey = 100;
	private static final int frameLength = 450;
	private static final int frameheigth = 300;
	private Color bgColor;
	
	public JFrame viewEditFac;
	private JTable facTable;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	
	public ViewAllFac()
	{
		bgColor = new Color(238, 238, 238);
		initializeFrame();
		initComponents();
		initListeners();
		associateFrameComponents();
	}
	
	private void associateFrameComponents()
	{
		viewEditFac.getContentPane().add(scroll);
	}
	
	private void initComponents()
	{
		facTable = new JTable();
		
		scroll = new JScrollPane(facTable);
		scroll.setBounds(1, 1, frameLength-1, frameheigth-1);
		
		Object[] columns = {"Faculty Id", "Faculty Name"};
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
		facTable.setModel(tableModel);
		facTable.setRowHeight(30);
		ViewEditStdFac.populateTable(tableModel, true);		
	}
	
	private void initListeners()
	{
		// Add Listeners here.
		facTable.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent event)
			{
				if( event.getClickCount() == 2 )
				{
					int i = facTable.getSelectedRow();
					JOptionPane.showMessageDialog(viewEditFac, "Doube Clicked "+tableModel.getValueAt(i, 0
							));
				}
			}
		});
	}
	
	private void initializeFrame()
	{
		viewEditFac = new JFrame("View Faculties");
		viewEditFac.setBounds(framex, framey, frameLength, frameheigth);
		viewEditFac.setBackground(bgColor);
		viewEditFac.getContentPane().setLayout(null);
		viewEditFac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewEditFac.setResizable(false);
		
		viewEditFac.addWindowListener( new WindowAdapter()
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
