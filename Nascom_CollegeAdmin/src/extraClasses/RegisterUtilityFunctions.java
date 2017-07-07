package extraClasses;

import java.util.ArrayList;
import java.util.Calendar;

public class RegisterUtilityFunctions
{
	private static String[] mediums = {"English", "Hindi"};
	private static String[] boards = {"CBSE", "ICSE", "State Board"};
	
	public static String[] getPassingYr()
	{
		ArrayList<String> pasYr = new ArrayList<>();
		Calendar can = Calendar.getInstance();
		int curyr = can.get(Calendar.YEAR);
		int base = curyr - 8;
		
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
