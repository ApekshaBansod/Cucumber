package org.propertiesFile;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public String getConfigData(String key) {
		try {
			FileInputStream fis = new FileInputStream(
					"./propertiesFiles/Config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(key);
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public Properties init_Prop() {
		try {

			FileInputStream fis = new FileInputStream(
					"./propertiesFiles/Config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}
