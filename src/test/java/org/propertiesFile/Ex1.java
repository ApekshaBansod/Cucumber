package org.propertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Ex1 {

	public static void main(String[] args) throws IOException {
		
	System.out.println("********STARTS********");	
	
	FileInputStream fis = new FileInputStream(
			"./propertiesFiles/Confg.properties");
		
	Properties prop = new Properties();
	prop.load(fis);
	System.out.println(prop.getProperty("browserName"));
	System.out.println(prop.getProperty("url"));
	System.out.println(prop.getProperty("userName"));
	System.out.println(prop.getProperty("password"));

	System.out.println("********ENDS********");	
		
	}
	

}
