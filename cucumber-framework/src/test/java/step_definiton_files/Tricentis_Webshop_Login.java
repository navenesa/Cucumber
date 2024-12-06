package step_definiton_files;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import common_methods.Methods;
import common_utilities.Object_Repository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Tricentis_Webshop_Login {

	@Given("The user is on the login page")
	public void the_user_is_on_the_login_page() {
		Methods.getMethods().LaunchUrl();
		Methods.getMethods().Maximize_Window();
		Methods.getMethods().Click(Object_Repository.signIn_Button);
	    //cm.Click(Locators.signIn);
		
	}
	@When("The user enters the credentials")
	public void the_user_enters_the_credentials(DataTable datatable) {
		List<Map<String,String>> lst = datatable.asMaps(String.class,String.class);
		String username = lst.get(0).get("Username");
		String password = lst.get(0).get("Password");
		
		Methods.getMethods().SendKeys(Object_Repository.userName,username);
		Methods.getMethods().SendKeys(Object_Repository.password,password);
	    
	}
	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
		Methods.getMethods().Click(Object_Repository.loginButton);
	    
	}
	@Then("the user should be logged in")
	public void the_user_should_be_logged_in() {
		Assert.assertTrue(Methods.getMethods().IsDisplayed(Object_Repository.logoutButton));
	    
	}



}
