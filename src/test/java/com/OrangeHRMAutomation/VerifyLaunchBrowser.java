package com.OrangeHRMAutomation;

import java.io.IOException;

import com.CyberSuccessAutomation.PropertyHandling;
import com.CyberSuccessAutomation.baseClass;

public class VerifyLaunchBrowser extends baseClass{

	public static void main(String[] args) throws IOException {
		
		
		PropertyHandling prop=new PropertyHandling();
		
		System.out.println(prop.getProperty("browser"));
		
		System.out.println(prop.getProperty("orangeHrmUrl"));
		
		getBrowserInstance(prop.getProperty("browser"));
		
		driver.navigate().to(prop.getProperty("orangeHrmUrl"));
		

		
	}

}
