package userRegLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beanClasses.User;
import dbConnection.GetDBConnection;

/**
 * Class for Authenticating user for LogIn.
 */
public class Authenticate
{
    private User user;

    public Authenticate(User user)
    {
        this.user = user;
    }

    public ResultSet authenticateUser() throws SQLException, ClassNotFoundException
    {
    	Connection con = GetDBConnection.getConnection();
    	
    	String insertQuesry = "SELECT * FROM USERS WHERE username = ?;";
        PreparedStatement prest = con.prepareStatement(insertQuesry);
        prest.setString(1, this.user.getUserName());
        ResultSet userResultSet = prest.executeQuery();
        if( !userResultSet.next() )
        {
            return null;
        }
        else
        {
            String pass = userResultSet.getString("password");
            if( pass.equals(this.user.getPassword()) )
            	return userResultSet;
            else
            	return null;
        }
    }
}