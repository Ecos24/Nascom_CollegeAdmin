package extraClasses;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * This Class provides the utility functions for GUI Registration form.
 * @author ecos
 */
public class GUIRegisterUtilityFunctions
{
	private static String[] mediums = {"Select", "English", "Hindi"};
	private static String[] boards = {"Select", "CBSE", "ICSE", "State Board"};
	private ArrayList<String> errorMsg;
	
	public GUIRegisterUtilityFunctions()
	{
		errorMsg = new ArrayList<>();
	}
	
	public void storeError(String error)
	{
		errorMsg.add(error);
	}
	
	public String getErrors()
	{
		String error = "";
		for (String string : errorMsg)
		{
			error = error.concat(string);
			error = error.concat("\n");
		}
		return error;
	}
	
	public static String[] getPassingYr()
	{
		ArrayList<String> pasYr = new ArrayList<>();
		Calendar can = Calendar.getInstance();
		int curyr = can.get(Calendar.YEAR);
		int base = curyr - 8;
		pasYr.add("Select");
		
		for( int i = base ; i<= curyr ; i++ )
			pasYr.add(String.valueOf(i));
		
		String[] passingYr = new String[pasYr.size()];
		passingYr = pasYr.toArray(passingYr);
		return passingYr;
	}
	
	public static String[] getMedium()
	{
		return mediums;
	}
	
	public static String[] getBoard()
	{
		return boards;
	}
}
