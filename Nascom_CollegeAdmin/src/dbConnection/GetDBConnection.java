package dbConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  Class to Create Connection to DataBase.
 */
public class GetDBConnection
{
    private static Connection con = null;

    //Static Block executes automatically when class in loaded. Hence creating connection before Hand.
    static
    {

        String url = ReadProjectProperties.getProp("url")+ReadProjectProperties.getProp("dbname")+ReadProjectProperties.getProp("dbresrictions");
        try
        {
            Class.forName(ReadProjectProperties.getProp("driver"));
            con = DriverManager.getConnection(url,ReadProjectProperties.getProp("username"),ReadProjectProperties.getProp("password"));
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException Happened while establishing connection "+e.getMessage());
        }
        catch(SQLException e)
        {
            System.out.println("SQLException Happened while establishing connection "+e.getMessage());
        }
        System.out.println("Connected");
    }

    /**
     * Function return reference of connection created.
     * @return Connection
     * @throws SQLException ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        return con;
    }

    public static void closeConnection() throws SQLException
    {
        con.close();
        System.out.println("Connection Closed.");
    }

    /**
     * Function Checks for given table Name in database. It drops & recreate the table if present
     * @param createTableQuery is used for creating table
     * @throws SQLException is thrown
     */
    public static void checkTable( String tableName, String createTableQuery) throws SQLException
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
     */
    public static boolean checkTableForLogIn( String tableName ) throws SQLException
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
     */
    public static void checkTableForReg( String tableName, String createTableQuery)
            throws SQLException
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
                        stmt.close();
                        return;
                    }
                }while (rs.next());
            }
            stmt.close();
        }
    }
}