package BaseUtil;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtility {

	public boolean isAlertPresent(WebDriver driver,int time) {
		try {
			WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(2));
			wt.until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	//how to disable notification website
	public void ChromOptions(WebDriver driver,String ele) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("==disable-notification");
		driver = new ChromeDriver(options);
	}
	//Drag and  method Droppable

	public void dragdrop1 (WebDriver driver,String dragdrop) {
		Actions act = new Actions(driver);
		WebElement src = driver.findElement(By.id("draggable"));
		act.dragAndDrop(src, src).perform();
	}

	//drag and drop method 
	public void location(WebDriver driver,String locate) {
		Actions act = new Actions(driver);
		WebElement src = driver.findElement(By.id("draggable"));
		act.dragAndDrop(src, src).perform();

		Point pt = src.getLocation();
		int x = pt.getX();
		int y = pt.getY();

		System.out.println("X ="+x);
		System.out.println("Y ="+y);
	}



	public void waitForVisibilityOfWebElement(WebDriver driver,int time,WebElement ele) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForVisibilityOfwebElement(WebDriver driver,int time,String locType,String locator) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		switch(locType){
		case "id" : wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locator))));
		break;

		case "xpath" : wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
		break;

		case "css" : wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(locator))));
		break;

		case "class" : wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locator))));
		break;
		}
	}


	public void waitForInVisibilityOfwebElement(WebDriver driver,int time,String locType,String locator) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		switch(locType){
		case "id" : wt.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id(locator))));
		break;

		case "xpath" : wt.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(locator))));
		break;

		case "css" : wt.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(locator))));
		break;

		case "class" : wt.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className(locator))));
		break;
		}
	}



	public  WebDriver startUp(String bName, String url) {
		WebDriver driver = null;
		if(bName.equalsIgnoreCase("ch") || bName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","./DriverFiles/chromedriver.exe");
			ChromeOptions options= new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(options);

		}else if (bName.equalsIgnoreCase("ff") || bName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver","./DriverFiles/geckodriver.exe");
			driver = new FirefoxDriver();

		}else  if (bName.equalsIgnoreCase("Edge") ){
			System.setProperty("webdriver.edge.driver","./DriverFiles/msedgedriver.exe");
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid browser name!!!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);
		return driver;


	}
	public void scrollByJS( WebDriver driver, WebElement ele){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",ele);
	} 

	public void MouseHoverAndClickElement(WebElement element,WebDriver  driver) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	public String getcurrentWindowID(WebDriver driver) {
		return driver.getWindowHandle();
	}
	public ArrayList <String>getAllStringCellValues(String fileName,String sheetName) throws EncryptedDocumentException, IOException {
		ArrayList<String> ar= new ArrayList<String>();
		try {

			FileInputStream fis = new FileInputStream(fileName);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s1 =wb.getSheet(sheetName);
			for(int k=1;k<=s1.getLastRowNum();k++) {
				Row r1 = s1.getRow(k);
				for(int i=0;i<=r1.getLastCellNum();i++) {
					ar.add(r1.getCell(i).getStringCellValue());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return  ar;

	}

	public String getValue(String fileName,String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new  FileInputStream("./DataFiles/Assignment.xlsx");
		Workbook wb = WorkbookFactory.create(fis);   
		Sheet s1 = wb.getSheet("TestData");

		for(int k=1; k<=s1.getLastRowNum();k++) {
			Row r1 = s1.getRow(k);
			for(int i=0;i<r1.getLastCellNum();i++) {
				CellType ct = r1.getCell(i).getCellType();
				//System.out.println(ct);
				switch(ct) {
				case STRING : System.out.println(r1.getCell(i).getStringCellValue());
				break;

				case NUMERIC : System.out.println((long)r1.getCell(i).getNumericCellValue());
				break;
				case BOOLEAN : System.out.println(r1.getCell(i).getBooleanCellValue());
				break;
				case FORMULA : System.out.println(r1.getCell(i).getCellFormula());
				break;
				case BLANK : System.out.println("Cell is Blank");
				break;



				}	

			}
		}
		return sheetName;

	}

	public WebDriver startUpWM(String bName, String url) {
		WebDriver driver = null;
		if(bName.equalsIgnoreCase("ch") || bName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("Start-maximized");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);  // opens browser


		}
		else if(bName.equalsIgnoreCase("ff") || bName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver  = new FirefoxDriver();  // opens browser


		}
		else if(bName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();  // opens browser


		}
		else {
			System.out.println("Invalid Browser name !!!");
		}
		//implicite
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//		driver.get(url);
		return driver;	
	}
	public void waitForVisibilityOfWebElementByType(WebDriver driver,int time,WebElement ele) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForVisibilityOfWebElementByType(WebDriver driver,int time,String locType,String locator) {
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(time));

		switch(locType) {
		case "id"   : wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(locator))));
		break;
		case "xpath": wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
		break;
		case "cssSelector"  : wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(locator))));
		break;
		case "class": wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(locator))));
		break;
		case "linkText": wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(locator))));
		break;
		case "partialLinkText": wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText(locator))));
		break;
		case "tagName": wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName(locator))));
		break;
		case "name": wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(locator))));
		break;
		}
	}

}


