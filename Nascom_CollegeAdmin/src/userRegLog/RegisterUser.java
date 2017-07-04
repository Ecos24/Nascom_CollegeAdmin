package userRegLog;

import beanClasses.User;
import dbConnection.GetDBConnection;
import dbConnection.ReadProjectProperties;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUser
{
    private User user;

    public RegisterUser(User user)
    {
        this.user = user;
    }

    public boolean registerUser() throws SQLException, ClassNotFoundException
    {
    	Connection con = GetDBConnection.getConnection();
    	
    	String createQuery = "CREATE TABLE USERS( username varchar(50) primary key, usertype varchar(50) not null," +
                " password varchar(50) not null );";
        GetDBConnection.checkTableForReg(ReadProjectProperties.getProp("tableName") , createQuery);
        String insertQuesry = "INSERT INTO " + ReadProjectProperties.getProp("tableName") +" VAlUES( ? , ? , ?);";
        PreparedStatement prest = con.prepareStatement(insertQuesry);
        prest.setString(1, this.user.getUserName());
        prest.setString(2, this.user.getUserType());
        prest.setString(3, this.user.getPassword());

        return prest.executeUpdate()>0;
    }
}