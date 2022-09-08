package org.propertiesFile;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginActiTimeEx2 {

	
		public static void main(String[] args) {
			System.out.println("* Program Starts *");
			
			ConfigReader cr = new ConfigReader();
			String bName = cr.getConfigData("browserName");
			String url = cr.getConfigData("url");
			String uName = cr.getConfigData("userName");
			String pwd = cr.getConfigData("password");
			
			BaseUtil.BaseUtility bu = new BaseUtil.BaseUtility();
			WebDriver driver = bu.startUpWM(bName, url);
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.name("pwd")).sendKeys(pwd);
			
//			WebDriver driver = bu.startUp(cr.getConfigData("browserName"),cr.getConfigData("url"));
//		    driver.findElement(By.id("username")).sendKeys(cr.getConfigData("userName"));
//		    driver.findElement(By.cssSelector(".textField.pwdfield")).sendKeys(cr.getConfigData("password"));
//			
			driver.findElement(By.cssSelector("#loginButton>div")).click();
			
			
			System.out.println("* Program Ends **");
		
			
		}
	}