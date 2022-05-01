package com.CyberSuccessAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling {
	
	Properties property;
	
	public PropertyHandling() throws IOException{
		
		String filePath="C:\\Users\\danghar\\eclipse-workspace\\CyberSuccessAutomation\\config.properties";
		
		property=new Properties();
		
		FileInputStream input=new FileInputStream(filePath);
		
		//load the input file into the properties class
		property.load(input);	
	}

	/**
	 * This method is to get the property value from config.properties file
	 * @param key
	 * @return value of key
	 */
	public String getProperty(String key) {		
		return property.getProperty(key);		
	}
	
	

}
