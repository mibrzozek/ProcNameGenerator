package markov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MarkovTextGenerator
{
	private Random r;
	private String filePath, masterTxt;
	public MarkovTextGenerator()
	{
		this.r = new Random();
	}
	public void constructChains()
	{
		try(Scanner scan = new Scanner(new File(filePath)))
		{
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				line.replaceAll("\n", "");
				line.replaceAll("\t", "");
				line.replaceAll("\\#", "");
				line = line.trim();
				
				masterTxt += line;
			}
			
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		String [] sentences =  masterTxt.split("\\.");
		List<String> sList = Arrays.asList(sentences);
		for(String s : sList)
		{
			String[] words = s.split(" ");
			List<String> wList = Arrays.asList(words);
			for(String w : wList)
			{
				System.out.println(w);
			}
			
			
		}
	}
	public void setFile(String path)
	{
		this.filePath = path;
		constructChains();
		
	}

}
