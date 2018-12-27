package namegen;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.Scanner;

/*
 * 		Purpose	:	Takes a csv text file and converts it to 
 * 					a file with single item per line.
 */

public class ParseCSV 
{
	private static final String DEFAULT_ENCODING = "utf-8";
	
	private String newFileContent, newFileName, filePath;
	private String encoding;
	
	public ParseCSV(String filePath, String newFileName)
	{
		this.filePath = filePath;
		this.newFileName = newFileName;
		this.newFileContent = "";
		this.encoding = DEFAULT_ENCODING;
	}
	
	public void parseFieldToNewFile(int fieldNum)
	{
		String line = "", field = "";
		String[] fields;	
	
		try(Scanner fileScan = new Scanner(new File(filePath), encoding))
		{
			while(fileScan.hasNextLine())
			{
				line = fileScan.nextLine();
				fields = line.split(",");
				field = fields[fieldNum]; // gets field from specified field num
				field = field.replaceAll("\"", "");
				field += "\n";
				newFileContent += field;
			}
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
        try (Writer writer = new BufferedWriter(new OutputStreamWriter
        		(new FileOutputStream(newFileName), encoding)))
        {
            writer.write(newFileContent);
            writer.close();
        } catch (UnsupportedEncodingException e) 
        {
            e.printStackTrace();
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
	}
	public void changeEncoding(String encoding)
	{
		this.encoding = encoding;
	}
	
}
