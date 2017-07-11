package extraClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import dbConnection.GetDBConnection;

public class ViewEditStdFac
{
	public static void populateTable(DefaultTableModel model)
	{
		Object[] row = new Object[2];
		
        ResultSet userResultSet;
		try
		{
			Connection con = GetDBConnection.getConnection();
	    	String getQuery = "SELECT username, password FROM USERS;";
	    	Statement st = con.createStatement();
			userResultSet = st.executeQuery(getQuery);
			
	        while( userResultSet.next() )
	        {
	        	row[0] = userResultSet.getString("username");
	        	row[1] = userResultSet.getString("password");
				model.addRow(row);
	        }
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println("Exception Occured --> "+e.getMessage());
		}
	}
}
