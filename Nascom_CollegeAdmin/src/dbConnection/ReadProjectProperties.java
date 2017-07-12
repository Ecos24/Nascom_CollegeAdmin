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

    /**
     * Gives the value corresponding to parameter key in dbProperties File.
     * @param key
     * @return
     */
    public static String getProp(String key)
    {
        return res.getString(key);
    }
}