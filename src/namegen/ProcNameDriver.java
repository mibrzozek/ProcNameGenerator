package namegen;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProcNameDriver 
{
	private static final String FILE_PATH = 
			"C:\\Users\\Michal\\Desktop\\git\\firstNames.txt";
	private static final String FILE_PATH_TEST = 
			"C:\\Users\\Michal\\Desktop\\git\\firstNames_short.txt";
	private static final String LOTR = 
			"C:\\Users\\Michal\\Desktop\\git\\lotr-names-classification\\characters_no_surnames.txt";
	private static final String FILE_BABY =
			"C:\\Users\\Michal\\Desktop\\git\\data-baby-names\\baby_test.txt";
	
	static NameGenerator g = new NameGenerator();
	static Random r = new Random();
	
	public static void main(String ... args)
	{
		//ParseCSV parser = new ParseCSV(LOTR, "parsed_lotr_names.txt");
		//parser.parseFieldToNewFile(0);
		
		g.setFileToUse("parsed_lotr_names.txt");
		
		for(int i = 0; i < 500; i++)
		{
			System.out.println(g.getRandomName());
		}
	}
}
