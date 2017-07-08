package extraClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CityReadFromFile
{
	private static String filePath;
	private static FileReader fr = null;
	private static BufferedReader br = null;
	private static ArrayList<String> states;
	
	public static String[] getCities(String stateName)
	{
		readFile(stateName);
		String[] stateArray = new String[states.size()];
		stateArray = states.toArray(stateArray);
		return stateArray;
	}
	
	private static void readFile(String fileName)
	{
		states = new ArrayList<>();
		states.add("Select");
		try
		{
			filePath = "extras/"+fileName+".txt";
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
}
