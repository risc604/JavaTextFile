
import java.util.ArrayList;
import java.util.List;



public class TextFile
{
	private final static String	fileName = "mlcDevices.txt";
	private static List<String>	deviceList = new ArrayList<>();	
	private static List<String>	nameList = new ArrayList<>();	
	
	public static void main(String[] args)
	{
		//TextFile	textObj = new TextFile();
		TextFileEvent	textFileObj = new TextFileEvent();
		
		if(!textFileObj.readTextFile(fileName, deviceList))
		{
			textFileObj.createDefaultFile(fileName);
			textFileObj.readTextFile(fileName, deviceList);
		}
		
		textFileObj.displayList(deviceList);
		nameList = textFileObj.getDeviceNameList(deviceList);
		
		System.out.println("Hello, Java !!");
	}
}