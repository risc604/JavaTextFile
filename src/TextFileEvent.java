import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class TextFileEvent 
{
	//private final static String	fileName = "mlcDevices.txt";
	//private List<String>	deviceList = new ArrayList<>();	
	
	public TextFileEvent()
	{}
	
	public void createDefaultFile(String fileName)
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
	
	public boolean readTextFile(String fileName, List<String> deviceList)
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
	
	public List<String> getDeviceNameList(List<String> deviceList) 
	{
		List<String>	nameList = new ArrayList<>();
		List<Integer>	lengthList = new ArrayList<>();		
		String[]		tmpStr=null;

		if(deviceList.isEmpty())
			return null;
			
		for(int i=0; i<deviceList.size(); i++)
		{
			tmpStr = deviceList.get(i).split(",");
			nameList.add(tmpStr[0].replaceAll("\\s+", ""));
			lengthList.add(Integer.decode(tmpStr[1].replaceAll("\\s+", "")));
		}
		System.out.println("get Device name:  ");
		displayList(nameList);
		displayInt(lengthList);
		
		return(nameList);
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
	
	public void displayInt(List<Integer> listData) 
	{
		if(listData.isEmpty())
			return;
		
		for(int i=0; i<listData.size(); i++)
		{
			System.out.println("Int[" + i + "]= " + listData.get(i));
		}
	}
}
