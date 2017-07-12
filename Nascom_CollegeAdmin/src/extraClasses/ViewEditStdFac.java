package extraClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import dbConnection.GetDBConnection;
import dbConnection.ReadProjectProperties;

/**
 * This Class provides Helper method for listing Faculties & Students in Tabular Form.
 * @author ecos
 */
public class ViewEditStdFac
{
	/**
	 * Funciton populates the given model with the data from DataBase.
	 * @param model
	 * @param facFlag
	 */
	public static void populateTable(DefaultTableModel model, boolean facFlag)
	{
		String[] row = new String[2];
		
        ResultSet userResultSet;
		try
		{
			Connection con = GetDBConnection.getConnection();
	    	String getQuery = "SELECT userid, usertype, password FROM "+ReadProjectProperties.getProp("TNUSERS")+";";
	    	Statement st = con.createStatement();
	    	Statement stfacstd = con.createStatement();
			userResultSet = st.executeQuery(getQuery);
			ResultSet facstdResultSet;
	        while( userResultSet.next() )
	        {
	        	if( facFlag )
	        	{
	        		if( userResultSet.getString("usertype").equals("faculty") )
	        		{
	        			row[0] = userResultSet.getString("userid");
	        			String query = "SELECT fname, mname, lname FROM "+
	        					ReadProjectProperties.getProp("TNSTDPERSONALDETAILS")+ " WHERE stdid = '"+
	        					row[0]+ "';";
	        			facstdResultSet = stfacstd.executeQuery(query);
	        			while( facstdResultSet.next() )
	        			{
	        				String name = facstdResultSet.getString("fname")+facstdResultSet.getString("mname")+facstdResultSet.getString("lname");
	        				row[1] = name;
	        			}
	        		}
	        	}
	        	else
	        	{
	        		if( userResultSet.getString("usertype").toLowerCase().equals("student") )
	        		{
	        			row[0] = userResultSet.getString("userid");
	        			String query = "SELECT fname, mname, lname FROM "+
	        					ReadProjectProperties.getProp("TNSTDPERSONALDETAILS")+ " WHERE stdid = '"+
	        					row[0]+ "';";
	        			facstdResultSet = stfacstd.executeQuery(query);
	        			while( facstdResultSet.next() )
	        			{
	        				String name;
	        				if(facstdResultSet.getString("mname") == null)
	        					name = facstdResultSet.getString("fname")+" "+facstdResultSet.getString("lname");
	        				else
	        					name = facstdResultSet.getString("fname")+" "+facstdResultSet.getString("mname")+" "+facstdResultSet.getString("lname");
	        				row[1] = name;
	        			}
	        		}
	        	}
				model.addRow(row);
	        }
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println(e.getClass().getName()+" Exception Occured --> "+e.getMessage());
		}
	}
}
