package extraClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This Class gives method to read States names from file.
 * @author ecos
 */
public class StatesReadFromFile
{
	private final static String filePath = "extras/states.txt";
	private static FileReader fr = null;
	private static BufferedReader br = null;
	private static ArrayList<String> states;
	
	static
	{
		states = new ArrayList<>();
		states.add("Select");
		try
		{
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String currentLine;
			
			while( (currentLine = br.readLine()) != null )
			{
				states.add(currentLine);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not Found.");
		}
		catch(IOException e)
		{
			System.out.println("Excetion occured while Reading States File.");
		}
		finally
		{
			try
			{
				if(fr != null)
					fr.close();
				if(br != null)
					br.close();
			}
			catch(IOException ex)
			{
				System.out.println("Exception occured "+ex.getMessage());
			}
		}
	}
	
	/**
	 * This function return all the states in country in a String array.
	 * @return String[] states
	 */
	public static String[] getStates()
	{		
		String[] stateArray = new String[states.size()];
		stateArray = states.toArray(stateArray);
		return stateArray;
	}
}
