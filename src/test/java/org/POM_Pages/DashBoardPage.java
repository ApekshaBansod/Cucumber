package org.POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	
	 private WebDriver driver;
	//1. WebElement
	
	 @FindBy(xpath="//div[text()='TIME-TRACK']")
		private WebElement timeTrack;
		
		@FindBy(xpath="//a[@class='content tasks']")
		private WebElement taskTab;
		
		@FindBy(xpath="//a[@class='content reports']")
		private WebElement reportTab;
		
		@FindBy(xpath="//a[@class='content users']")
		private WebElement userTab;

	// 2. Constructor
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	//Page Action Methods
	
	public boolean verifyDashboardTitle() {
		return driver.getTitle().equals("actiTime - Enter Time-Track");
	}
	public boolean verifyDashboardUrl() {
		return driver.getCurrentUrl().equals("http://localhost/user/submit_tt.do");
	}
	
	public boolean isTimetrackTabDispalyed() {
		return timeTrack.isDisplayed();
	}
	public boolean isTaskTabDispalyed() {
		return taskTab.isDisplayed();
	}
	public boolean isReportTabDispalyed() {
		return reportTab.isDisplayed();
	}
	public boolean isUserTabDispalyed() {
		return userTab.isDisplayed();
	}
}
	
