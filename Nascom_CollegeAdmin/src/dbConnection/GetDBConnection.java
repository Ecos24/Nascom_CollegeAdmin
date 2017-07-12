package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import tableCreateQuery.CommonQuerys;
import tableCreateQuery.StudentQuerys;

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
            System.out.println("Connected");
            
            //////// COMMON TABLES //////// 
            // Check Users Table.
            DBUtilityFunctions.checkTableForReg(con ,ReadProjectProperties.getProp("TNUSERS"), CommonQuerys.getUsersCreateQuery());
            // Check Address Table.
            DBUtilityFunctions.checkTableForReg(con ,ReadProjectProperties.getProp("TNADDRESS"), CommonQuerys.getAddressCreateQuery());
            // Check Guardian Table.
            DBUtilityFunctions.checkTableForReg(con ,ReadProjectProperties.getProp("TNGUARDIAN"), CommonQuerys.getGuardianCreateQuery());
            // Check Education Table.
            DBUtilityFunctions.checkTableForReg(con ,ReadProjectProperties.getProp("TNEDUCATION"), CommonQuerys.getEducationCreateQuery());
            //////// STUDENT TABLES ////////
            DBUtilityFunctions.checkTableForReg(con ,ReadProjectProperties.getProp("TNSTDPERSONALDETAILS"), StudentQuerys.getStudentPersonalCreateQuery());
            //////// FACULTY TABLES ////////
            
            System.out.println("All well with DB");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException Happened while establishing connection "+e.getMessage());
        }
        catch(SQLException e)
        {
            System.out.println("SQLException Happened while establishing connection !!"+e.getMessage());
        }
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

    /**
     * Function closes current Connection.
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException
    {
        con.close();
        System.out.println("Connection Closed.");
    }
}