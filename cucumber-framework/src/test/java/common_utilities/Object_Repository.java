package common_utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Object_Repository {

	//Registration Page (or) Home Page
	public static final By signIn_Button = By.xpath("//*[@class='ico-login']");
	public static final By userName = By.xpath("//*[@id='Email']");
	public static final By password = By.xpath("//*[@id='Password']");
	public static final By loginButton = By.xpath("//*[@class='button-1 login-button']");
	public static final By logoutButton = By.className("ico-logout");//ico-logout
}
