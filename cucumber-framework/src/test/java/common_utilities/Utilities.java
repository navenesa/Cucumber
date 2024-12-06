package common_utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

public class Utilities {
	
	//Singleton Design Pattern to avoid multiple object creation
	private static Utilities utilities_Instance = null;
	
	private Utilities() {
		
	}
	
	public static Utilities getUtilities() {
		if(utilities_Instance==null) {
			utilities_Instance = new Utilities();
		}
		return utilities_Instance;
	}
	
	
	//Global (or) Constant Variables
	public static String app_URL ="";
	public static String browser_Name ="";
	public static String chrome_Driver ="";
	public static String firefox_Driver="";
	public static String ie_Driver ="";
	public static String edge_Driver="";
	public static String chrome_Driver_Location ="";
	public static String firefox_Driver_Location ="";
	public static String ie_Driver_Location ="";
	public static String edge_Driver_Location ="";
	public static String properties_File_Path ="";
	
	//public static WebDriver driver;
	
	//Initializing logger 
	private static Logger LOGGER = LogManager.getLogger(Utilities.class);

	public Logger getLOGGER() {
		return LOGGER;
	}
	
	

}
