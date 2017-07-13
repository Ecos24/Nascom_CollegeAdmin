package userRegLog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import dbConnection.GetDBConnection;
import tableCreateQuery.CommonQuerys;

public class RegisterUtility
{
	public static String getNewFacId(String branch) throws ClassNotFoundException, SQLException
	{
		Statement st = GetDBConnection.getConnection().createStatement();
		ResultSet rs = st.executeQuery(CommonQuerys.getLatestFacIdQuery());
		Calendar cal = Calendar.getInstance();
		String id = null;
		rs.afterLast();
		while( rs.previous() )
		{
			id = rs.getString("userid").toLowerCase();
			if( id.substring(0,7).equals(cal.get(Calendar.YEAR)+branch.toLowerCase()) )
				return id.substring(0, 7)+String.format("%04d", (Integer.parseInt(id.substring(7,id.length()))+1));
		}
		return Calendar.getInstance().get(Calendar.YEAR)+branch+String.format("%04d", 1);
	}

	public static String getNewStdId(String branch) throws SQLException, ClassNotFoundException
	{
		Statement st = GetDBConnection.getConnection().createStatement();
		ResultSet rs = st.executeQuery(CommonQuerys.getLatestStdIdQuery());
		Calendar cal = Calendar.getInstance();
		String id = null;
		rs.afterLast();
		while( rs.previous() )
		{
			id = rs.getString("userid").toLowerCase();
			if( id.substring(0,7).equals(cal.get(Calendar.YEAR)+branch.toLowerCase()) )
				return id.substring(0, 7)+String.format("%04d", (Integer.parseInt(id.substring(7,id.length()))+1));
		}
		return Calendar.getInstance().get(Calendar.YEAR)+branch+String.format("%04d", 1);
	}
	
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
	public static int getFacHighQualSubId(String query, boolean highFlag)
	{
		Statement st = null;
		try
		{
			Connection con = GetDBConnection.getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while( rs.next() )
			{
				if( highFlag )
					return rs.getInt("fachighid");
				else
					return rs.getInt("facsubid");
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