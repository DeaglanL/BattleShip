package Battle.BattleShip;
import java.io.*;

public class Deaglan {
	
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static Boolean writeStringToFile(String toWrite,String filepath, Boolean appendToFile) throws IOException
	{
		FileWriter fw = new FileWriter(filepath, appendToFile);
		PrintWriter pw = new PrintWriter(fw); 
		
		pw.print(toWrite);
		
		
		pw.close();
		return false;
	}
	
	public static String readFileToString(String filePath) throws IOException
	{
		FileReader fr = new FileReader(filePath);
		
		BufferedReader bf = new BufferedReader(fr);
		 
		String output = ""; 
		String line;
		
		while((line = bf.readLine())!=null)
		{
			output = output + line + "\n";
		}
		
		bf.close();
		
		return output;
		
	}
	
	public static Boolean intTryParse(String v)
	{
		try {  
	         Integer.parseInt(v);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }
	}
	
}
