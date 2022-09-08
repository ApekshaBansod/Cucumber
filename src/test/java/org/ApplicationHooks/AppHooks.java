package org.ApplicationHooks;

import java.io.File;
import java.util.Properties;

import org.factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.propertiesFile.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	public static Properties prop;
	private WebDriver driver;
	public static Scenario scn;
	
	@Before(order=1)
	public void launchBrowser() {
		ConfigReader cr = new ConfigReader();
		AppHooks.prop = cr.init_Prop();
		DriverFactory df = new DriverFactory();
		driver = df.init_driver(AppHooks.prop.getProperty("browserName"));
	//	AppHooks.scn=scn;
	}
	@After(order=1)
	public void tearDown() {
		driver.quit();
	}
	@After(order=10)
   public void takeScreenshot(Scenario scn) {
		if(scn.isFailed()) {
			scn.log("**FailedScenario:"+scn.getName());

		String sreenshotname = scn.getName().replaceAll("", "_");
	    byte[] Sreenshot =	((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		//File   Sreenshot =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String Sreenshot =	((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			scn.attach(Sreenshot, "image/png", sreenshotname);
			
//			try {
//				//code for taking screenshot
//				File scn1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//				FileHandler.copy(scn1, new File(System.getProperty("user.dir")
//						));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		
			
		
		
		}
	}
}
