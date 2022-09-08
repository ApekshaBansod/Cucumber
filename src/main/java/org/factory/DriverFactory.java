package org.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static DriverFactory obj = new DriverFactory();
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public WebDriver init_driver(String bName) {
		
		if(bName.equalsIgnoreCase("ch") || bName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","./DriverFiles/chromedriver.exe");
			ChromeOptions options= new ChromeOptions();
			options.addArguments("start-maximized");
			tlDriver.set(new ChromeDriver(options));

		}else if (bName.equalsIgnoreCase("ff") || bName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver","./DriverFiles/geckodriver.exe");
			
			tlDriver.set(new FirefoxDriver());

		}else  if (bName.equalsIgnoreCase("Edge") ){
			System.setProperty("webdriver.edge.driver","./DriverFiles/msedgedriver.exe");
			tlDriver.set(new EdgeDriver());

		}else {
			System.out.println("Invalid browser name!!!");
		}
		//getDriver.manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return getDriver();


	}

	// user defined synchronized method
	public synchronized static WebDriver getDriver() {
      System.out.println();
		return tlDriver.get();

	}
}