package userRegLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beanClasses.User;
import dbConnection.GetDBConnection;
import dbConnection.ReadProjectProperties;

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
    	
    	String insertQuesry = "SELECT userid, password, usertype FROM "+
    							ReadProjectProperties.getProp("TNUSERS")+" WHERE userid = ? AND password = ?;";
        PreparedStatement prest = con.prepareStatement(insertQuesry);
        prest.setString(1, this.user.getUserName());
        prest.setString(2, this.user.getPassword());
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