package org.POM_Pages;

import java.util.List;

import org.ApplicationHooks.AppHooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	@FindBy(id="username")
	private WebElement uNameField;

	@FindBy(css = ".textField.pwdfield")
	private WebElement pwdField;

	@FindBy(css = "#loginButton>div")
	private WebElement loginBtn;

	@FindBy(id = "keepLoggedInCheckBox")
	private WebElement keepMeLoginChkbox;

	@FindBy(css = "#logoContainer img")
	private List<WebElement> loginLogos;

	// 2.Constructor

	public LoginPage(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getLoginPageTitle() {
		return driver.getTitle().equals("actiTIME - Login");
	}
	public boolean getLoginPageUrl() {
		return driver.getCurrentUrl().equals("http://localhost/login.do");
	}

	public boolean isUserNameDisplayed() {
		return uNameField.isDisplayed();
	}

	public boolean isPasswordFieldDisplaed() {
		return pwdField.isDisplayed();
	}

	public boolean isLoginBtnDisplayed() {
		return loginBtn.isDisplayed();
	}

	public boolean isKeepMeLoginChkboxDisplayed() {
		return keepMeLoginChkbox.isDisplayed();
	}

	public boolean isloginLogosDisplayed() {
		boolean flag = false;
		for (int i = 0; i < loginLogos.size(); i++) {
			if (loginLogos.get(i).isDisplayed()) {
				flag = loginLogos.get(i).isDisplayed();
				continue;
			} else {
				break;
			}
		}
		return flag;
	}

	public void enterUserName(String userName) {
		uNameField.sendKeys(userName);
		//AppHooks.scn.log("User name'"+userName+"'entered successfully");

	}

	public void enterPassword(String password) {
		pwdField.sendKeys(password);
		AppHooks.scn.log("password entered successfully");

	}

	public void clickOnLoginBtn() {
		loginBtn.click();
	//	AppHooks.scn.log("click on login butoon");

	}

	public void doLogin(String userName, String password) {
		uNameField.sendKeys(userName);
		AppHooks.scn.log("User name "+userName+" entered successfully");

		pwdField.sendKeys(password);
		AppHooks.scn.log(" Password entered successfully");

		loginBtn.click();
		AppHooks.scn.log(" click on login button successfully");

	}
}

	
	