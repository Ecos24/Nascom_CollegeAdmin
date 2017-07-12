package extraClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This Class gives method to read City names from file of corresponding state.
 * @author ecos
 */
public class CityReadFromFile
{
	private static String filePath;
	private static FileReader fr = null;
	private static BufferedReader br = null;
	private static ArrayList<String> cities;
	
	/**
	 * Function is used to get String[] of cities corresponding to state Name provided in parameter.
	 * @param stateName
	 * @return cities
	 */
	public static String[] getCities(String stateName)
	{
		readFile(stateName);
		String[] stateArray = new String[cities.size()];
		stateArray = cities.toArray(stateArray);
		return stateArray;
	}
	
	/**
	 * This function Read the state file given in parameter & stores the cities in cities ArrayList
	 * @param fileName
	 */
	private static void readFile(String fileName)
	{
		cities = new ArrayList<>();
		cities.add("Select");
		try
		{
			filePath = "extras/"+fileName+".txt";
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String currentLine;
			
			while( (currentLine = br.readLine()) != null )
			{
				cities.add(currentLine);
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
}
