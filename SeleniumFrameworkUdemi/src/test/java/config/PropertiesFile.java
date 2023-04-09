package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


import tests.TestNG_Demo;

public class PropertiesFile {
	
	static Properties properties = new Properties();
	static String path = System.getProperty("user.dir");
	

	public static void main(String[] args) {
		getProperties();

	}

	public static void getProperties() {	
		try {			
			InputStream inputStream = new FileInputStream(path+"/src/test/java/config/configs.properties");
			properties.load(inputStream);
			String browser = properties.getProperty("browserName");			
			System.out.println("Browser is "+browser);	
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	
	
	public static void setProperties(String key, String value) {	
		try {			
			OutputStream outputStream = new FileOutputStream(path+"/src/test/java/config/configs.properties");
			properties.setProperty(key, value);
			properties.store(outputStream, null);		
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}