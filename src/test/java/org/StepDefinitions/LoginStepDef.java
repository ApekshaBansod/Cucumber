package org.StepDefinitions;

import org.ApplicationHooks.AppHooks;
import org.POM_Pages.LoginPage;
import org.factory.DriverFactory;
import org.testng.Assert;

import BaseUtil.BaseUtility;
import io.cucumber.java.en.*;

public class LoginStepDef {
	private LoginPage lpobj = new LoginPage(DriverFactory.getDriver());

	@Given("User is on login Page")
	public void User_is_on_login_page() {
		DriverFactory.getDriver().get(AppHooks.prop.getProperty("url"));
	}

	@Then("User name field is displayed")
	public void user_name_field_is_displayed() {
		Assert.assertTrue(lpobj.isUserNameDisplayed());
	}

	@Then("Password field is displayed")
	public void password_field_is_displayed() {
		Assert.assertTrue(lpobj.isPasswordFieldDisplaed());

	}

	@Then("Keep me login check box is displayed")
	public void keep_me_login_check_box_is_displayed() {
		Assert.assertTrue(lpobj.isKeepMeLoginChkboxDisplayed());
		// AppHooks.scn.log("Keep me login check box displayed successfully");

	}

	@Then("Login button is displayed")
	public void login_button_is_displayed() {
		Assert.assertTrue(lpobj.isLoginBtnDisplayed());

	}

	@Then("Login logos are displayed")
	public void login_logos_are_displayed() {
		Assert.assertTrue(lpobj.isloginLogosDisplayed());

	}


	@When("User enters username")
	public void user_enters_username() {
	lpobj.enterUserName(AppHooks.prop.getProperty("userName"));

	}

	@When("user enters password")
	public void user_enters_password() {
		lpobj.enterUserName(AppHooks.prop.getProperty("password"));

	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		lpobj.clickOnLoginBtn();
		BaseUtility bu = new BaseUtility();
		//bu.waitForVisibilityOfWebElementByType(DriverFactory.getDriver(), 10, "id", "logoutLink");
	}

	@Then("Dashboard Ttile is {string}")
	public void dashboard_ttile_is(String expTitle) {
		Assert.assertEquals(DriverFactory.getDriver().getTitle(), expTitle);
	}

}