package dbConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtilityFunctions
{	
    /**
     * Function Checks for given table Name in database. It drops & recreate the table if present
     * @param createTableQuery is used for creating table
     * @throws SQLException is thrown
     * @throws ClassNotFoundException 
     */
    public static void checkTable( Connection con, String tableName, String createTableQuery)
    		throws SQLException, ClassNotFoundException
    {
    	if(con.isValid(0))
        {
            Statement stmt = con.createStatement();
            DatabaseMetaData md = con.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            if( !rs.next() )
            {
                stmt.executeUpdate(createTableQuery);
                stmt.close();
                return;
            }
            else
            {
                do
                {
                    if( tableName.equals(rs.getString(3)) )
                    {
                        String query = "drop table "+ tableName +";";
                        stmt.executeUpdate(query);
                        stmt.executeUpdate(createTableQuery);
                    }
                }while (rs.next());
            }
            stmt.close();
        }
    }

    /**
     * Function Checks for given table Name in database.
     * @return boolean (true/false)
     * @throws SQLException is thrown
     * @throws ClassNotFoundException 
     */
    public static boolean checkTableForLogIn( Connection con, String tableName )
    		throws SQLException
    {
        if(con.isValid(0))
        {
            DatabaseMetaData md = con.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            if( !rs.next() )
            {
                return false;
            }
            else
            {
                do
                {
                    if( tableName.equals(rs.getString(3)) )
                    {
                        return true;
                    }
                }while (rs.next());
            }
        }
        return false;
    }

    /**
     * This function check for the table & create's if not present.
     * @param createTableQuery query to create table
     * @throws SQLException is thrown
     * @throws ClassNotFoundException 
     */
    public static void checkTableForReg(Connection con, String tableName, String createTableQuery)
            throws SQLException
    {
    	System.out.println("Checking for table "+tableName);
        if(con.isValid(0))
        {
            Statement stmt = con.createStatement();
            DatabaseMetaData md = con.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            if( !rs.next() )
            {
            	System.out.println("Creating Table --> +"+tableName);
                stmt.executeUpdate(createTableQuery);
            }
            else
            {
                do
                {
                    if( tableName.equals(rs.getString(3)) )
                    {
                    	System.out.println("Table "+tableName+" already present");
                        stmt.close();
                        return;
                    }
                }while (rs.next());
                System.out.println("Creating Table --> +"+tableName);
                stmt.executeUpdate(createTableQuery);
            }
            stmt.close();
            System.out.println("Checking "+tableName+" done!!");
        }
    }
}
