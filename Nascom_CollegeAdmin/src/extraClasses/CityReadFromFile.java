package extraClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CityReadFromFile
{	
	public static String[] getStates(String stateName)
	{
		String filePath = "extras/"+stateName+".txt";
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> states = new ArrayList<>();
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
		
		String[] stateArray = new String[states.size()];
		stateArray = states.toArray(stateArray);
		return stateArray;
	}
}
