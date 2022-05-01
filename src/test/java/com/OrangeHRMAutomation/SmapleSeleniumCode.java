package com.OrangeHRMAutomation;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CyberSuccessAutomation.baseClass;
import com.OrangeHrmPages.LoginPage;

public class SmapleSeleniumCode extends baseClass{
	
	public static void main(String[] args) throws Exception {

		LoginPage loginPage=new LoginPage();
		
		getBrowserInstance("Chrome");
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		loginPage.login("Admin", "admin123");
		
//		addEmployee();
		
//		driver.quit();
		
		
		
		
		
		
		
		
		
	}

}
