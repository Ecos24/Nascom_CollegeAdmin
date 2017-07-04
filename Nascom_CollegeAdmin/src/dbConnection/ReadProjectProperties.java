package dbConnection;

import java.util.ResourceBundle;

/**
 *  Class to Read project Properties form .properties file.
 */
public class ReadProjectProperties
{
    private static ResourceBundle res;

    static
    {
         res = ResourceBundle.getBundle("dbProperties");
    }

    public static String getProp(String key)
    {
        return res.getString(key);
    }
}