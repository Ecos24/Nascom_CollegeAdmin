package beanClasses;

/**
 *  Bean Class for Storing User Details.
 */
public class User
{
    protected String userName;
    protected String password;
    protected String userType;

    public String getUserType()
    {
        return userType;
    }
    public void setUserType(String userType)
    {
        this.userType = userType;
    }
    public String getUserName()
    {
        return userName;
    }
    public String getPassword()
    {
        return password;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
}