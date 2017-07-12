package userRegLog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbConnection.GetDBConnection;

public class RegisterUtility
{
	public static int getAddressGuardianId(String query, boolean addFlag)
	{
		Statement st = null;
		try
		{
			Connection con = GetDBConnection.getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while( rs.next() )
			{
				if( addFlag )
					return rs.getInt("addid");
				else
					return rs.getInt("gid");
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println("Exception occured while getting Address Id for Registration.");
		}
		finally
		{
			try
			{
				if( st != null )
					st.close();
			}
			catch(SQLException e)
			{
				System.out.println("Exception occured while closing statement for getting Address Id for Registration.");
			}
		}
		
		return 0;
	}
}
