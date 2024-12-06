package webdriver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import common_methods.Methods;
import common_utilities.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver_Manager {
	
	//Singleton Design Pattern to avid multiple Object creation
	private static Driver_Manager driver_manager_instance = null;
	
	private Driver_Manager() {
		
	}
	
	public static Driver_Manager getDriverManager() {
		if(driver_manager_instance == null) {
			driver_manager_instance = new Driver_Manager();  //object creation for this Driver_Manager class
		}
		return driver_manager_instance;    
	}
	
	
	
	//Declaring WebDriver Instance
	private static WebDriver driver = null;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	//Method to set the browser
	public void set_Browser() {
		switch (Utilities.browser_Name) {
		case "Chrome":
			//WebDriverManager.chromedriver().setup();
			System.setProperty(Utilities.chrome_Driver, Utilities.chrome_Driver_Location);
			driver = new ChromeDriver();
			
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("--disable-web-security");
			 * options.addArguments("--allow-running-insecure-content"); driver = new
			 * ChromeDriver(options);
			 */
			break;
			
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
		//driver.get(Utilities.app_URL);
	}

}
