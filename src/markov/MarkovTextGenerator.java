package markov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class MarkovTextGenerator
{
	private Random r;
	private String filePath, masterTxt;
	
	private Map<String, List<String>> stateMap;
	private Set<String> keySet;
	private List<String> keyList;
	
	public MarkovTextGenerator()
	{
		this.r = new Random();
		this.stateMap = new HashMap<String, List<String>>();
	}
	public String genSentence(int length)
	{
		String key = keyList.get(r.nextInt(keyList.size()));
		String sent = key;
		for(int i = 0; i < length; i++)
		{	
			List<String> values = new ArrayList<>();
			values = stateMap.get(key);	
			
			sent += " " + values.get(r.nextInt(values.size()));
			
			String[] temp = sent.split(" ");
			key = temp[temp.length-1];
			
			if(!stateMap.containsKey(key))
			{
				boolean search = true;
				while(search)
				{
					int index = r.nextInt(keyList.size());
					if(keyList.get(index).contains(temp[temp.length-1]))
							search =  false;
					key = keyList.get(index);
				}
			}
		}
		return sent;
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
			for(int i = 0; i < words.length; i++)
			{	
				String wKey = "";

				if(i < words.length && i+1 < words.length)
				{
					wKey = words[i];
							
					//+ " " +  words[i+1];
						List<String> temp = stateMap.get(wKey);
						if(temp != null)
							temp.add(words[i+1]);
						else
						{
							temp = new ArrayList<>();
							temp.add(words[i+1]);
						}
						stateMap.put(wKey, temp);
			
				}
				/*
				else if(i < words.length && i+1 < words.length && i+3 == words.length)
				{
					List<String> temp = stateMap.get(wKey);
					temp.add(words[i+2]+ ".");
					stateMap.put(wKey, temp);
				}
				*/
			}
		}
		System.out.println(stateMap.size());
		keySet = stateMap.keySet();
		String[] temp = keySet.toArray(new String[0]);
		keyList = Arrays.asList(temp);
		
		System.out.println(temp.length);
		System.out.println(keyList.size());
		
		
		String key = keyList.get(r.nextInt(keyList.size()));
		String sent = key;
		
		List<String> values = stateMap.get(key);
		
		sent += " " + values.get(r.nextInt(values.size()));
		
		System.out.println(sent);
		
		
		System.out.println(values.size());
	}
	public void setFile(String path)
	{
		this.filePath = path;
		constructChains();
		
	}

}
