
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import	java.lang.*;
import	java.util.*;


@SuppressWarnings("unused")
public class TextFile
{
	final static String	fileName = "mlcDevices.txt";
	static List<String>	deviceList = new ArrayList<>();	
	
	public TextFile()
	{
	}
	
	//public static void createDefaultFile(String fileName)
	private void createDefaultFile(String fileName)
	{
		try
		{
			BufferedWriter outputText = new BufferedWriter(new FileWriter(fileName));
			outputText.write("3MW1-4B,11 ");
			outputText.newLine();
			outputText.write("A6 BT, 12");
			outputText.newLine();
			outputText.write("BP3GT1-6B, 12 ");
			outputText.newLine();
					
			outputText.close();
		}
		catch (IOException ioError)
		{
			ioError.printStackTrace();
		}
	}
	
	public boolean readTextFile(String fileName)
	{
		try
		{
			BufferedReader	inputText = new BufferedReader(new FileReader(fileName));
			String	tmpInfo = null;
			
			while((tmpInfo = inputText.readLine()) != null )
			{
				deviceList.add(tmpInfo);
			}
			inputText.close();
			return true;
		}
		catch(IOException ioError)
		{
			System.out.println("file not exist. to create default mlcDevice.txt by default devices !!");
			//createDefaultFile(fileName);
			return false;
		}
	}
	
	public void displayList(List<String> listData) 
	{
		if(listData.isEmpty())
			return;
		
		for(int i=0; i<listData.size(); i++)
		{
			System.out.println("Data[" + i + "]= " + listData.get(i));
		}
	}
	
	
	
	public static void main(String[] args)
	{
		TextFile	textObj = new TextFile();
		
		if(!textObj.readTextFile(fileName))
		{
			TextFile.createDefaultFile(fileName);
			TextFile.readTextFile(fileName);
		}
		
		displayList(deviceList);
		
		System.out.println("Hello, Java !!");
	}
}