package common_methods;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import common_utilities.Utilities;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import webdriver_manager.Driver_Manager;
import common_methods.Methods;

public class Hooks_File {

	@Before
	public static void before_Test() throws IOException {
		Methods.getMethods().load_Properties();
		Driver_Manager.getDriverManager().set_Browser();
		Methods.getMethods().LaunchUrl();
		Methods.getMethods().Maximize_Window();
	}
	
	@After
	public static void after_Test() {
		Driver_Manager.getDriverManager().getDriver().quit();
	}
	
	@AfterStep
	public static void attach_Screenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot_taken = ((TakesScreenshot)Driver_Manager.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot_taken, "image/png", "fail_scenario"+scenario);
		}
	}
}
