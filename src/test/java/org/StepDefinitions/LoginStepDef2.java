package org.StepDefinitions;

import org.ApplicationHooks.AppHooks;
import org.POM_Pages.LoginPage;
import org.factory.DriverFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef2 {
	private LoginPage lpobj = new LoginPage(DriverFactory.getDriver());

	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.getDriver().get(AppHooks.prop.getProperty("url"));


	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	   
	}

	@Then("Title of login page should be {string}")
	public void title_of_login_page_should_be(String string) {
	    
	}

	@Then("Keep me logged in checkbox should be displayed")
	public void keep_me_logged_in_checkbox_should_be_displayed() {
	  
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
	 
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	    
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expTitle) {
		Assert.assertEquals(DriverFactory.getDriver().getTitle(), expTitle);

	}

	@When("User enters username as {string}")
	public void user_enters_username_as(String string) {
		lpobj.enterUserName(AppHooks.prop.getProperty("userName"));

	}

	@When("User enters passowrd as {string}")
	public void user_enters_passowrd_as(String string) {
		lpobj.enterUserName(AppHooks.prop.getProperty("password"));

	}


}
