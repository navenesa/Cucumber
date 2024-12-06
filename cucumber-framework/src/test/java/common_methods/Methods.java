package common_methods;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import common_utilities.Utilities;
import webdriver_manager.Driver_Manager;

public class Methods {

	// Singleton Design Pattern to avid multiple Object creation
	private static Methods methods_instance = null;

	private Methods() {

	}

	public static Methods getMethods() {
		if (methods_instance == null) {
			methods_instance = new Methods();
		}
		return methods_instance;
	}

	// static Driver_Manager driver_manager = new Driver_Manager();

	public void load_Properties() throws IOException {
		Utilities.properties_File_Path = "src/test/resources/config.properties";
		Properties config = new Properties();
		FileReader file = new FileReader(Utilities.properties_File_Path);
		config.load(file);

		Utilities.app_URL = config.getProperty("Url");
		Utilities.browser_Name = config.getProperty("Browser");
		Utilities.chrome_Driver = config.getProperty("Chrome_Driver");
		Utilities.edge_Driver = config.getProperty("Edge_Driver");
		Utilities.firefox_Driver = config.getProperty("Firefox_Driver");
		Utilities.ie_Driver = config.getProperty("IE_Driver");
		Utilities.chrome_Driver_Location = config.getProperty("Chrome_Driver_Location");
		Utilities.edge_Driver_Location = config.getProperty("Edge_Driver_Location");
		Utilities.firefox_Driver_Location = config.getProperty("Firefox_Driver_Location");
		Utilities.ie_Driver_Location = config.getProperty("IE_Driver_Location");
	}

	/*
	 * public Methods(Driver_Manager) { this.driver = driver; }
	 */

	public void SendKeys(By locator, String text) {
		// driver_manager.getDriver().findElement(locator).sendKeys(text);
		Methods.getMethods().highlight_Element(locator);
		Driver_Manager.getDriverManager().getDriver().findElement(locator).sendKeys(text);
		
		Utilities.getUtilities().getLOGGER().info("Value "+text+" entered in the field");
	}

	public void Click(By locator) {
		// driver_manager.getDriver().findElement(locator).click();
		Methods.getMethods().highlight_Element(locator);
		Driver_Manager.getDriverManager().getDriver().findElement(locator).click();
		
		Utilities.getUtilities().getLOGGER().info("The element has be clicked");
	}

	public void Clear(By locator) {
		// driver_manager.getDriver().findElement(locator).clear();
		Methods.getMethods().highlight_Element(locator);
		Driver_Manager.getDriverManager().getDriver().findElement(locator).clear();
		
		Utilities.getUtilities().getLOGGER().info("Value in the field has been cleared");
	}

	public String Get_Text(By locator) {
		// String text = driver_manager.getDriver().findElement(locator).getText();
		Methods.getMethods().highlight_Element(locator);
		String text = Driver_Manager.getDriverManager().getDriver().findElement(locator).getText();
		
		Utilities.getUtilities().getLOGGER().info("Value "+text+" has been retrieved from the field");

		return text;
		
	}

	public void LaunchUrl() {
		// driver_manager.getDriver().get(Utilities.app_URL);
		Driver_Manager.getDriverManager().getDriver().get(Utilities.app_URL);
		
		Utilities.getUtilities().getLOGGER().info("URL launched sucessfully");

	}

	public void Maximize_Window() {
		// driver_manager.getDriver().manage().window().maximize();
		Driver_Manager.getDriverManager().getDriver().manage().window().maximize();
		
		Utilities.getUtilities().getLOGGER().info("Window maximized sucessfully");

	}

	
	public boolean IsDisplayed(By locator) {
	  Methods.getMethods().highlight_Element(locator);
	  if(Driver_Manager.getDriverManager().getDriver().findElement(locator).isDisplayed()) { 
		  Utilities.getUtilities().getLOGGER().info("Element is displayed");
		  return true; 
	  }else { 
		  Utilities.getUtilities().getLOGGER().info("Element is not displayed");
		  return false;
	  }
	}
	
	public void highlight_Element(By locator) {
		WebElement ele = Driver_Manager.getDriverManager().getDriver().findElement(locator);
		JavascriptExecutor jse = (JavascriptExecutor)Driver_Manager.getDriverManager().getDriver();
		jse.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", ele);
	}
	 

}
