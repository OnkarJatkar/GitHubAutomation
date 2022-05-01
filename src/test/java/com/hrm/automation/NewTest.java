
package com.hrm.automation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.annotation.Nonnull;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CyberSuccessAutomation.ExcelUtil;
import com.CyberSuccessAutomation.baseClass;
import com.OrangeHrmPages.LoginPage;

import junit.framework.Assert;

public class NewTest extends baseClass {
	
	@Test
	public void test1() {
		
		getBrowserInstance("Chrome");
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		logger.info("successfully able to navigate to orange hrm application");
		
		System.out.println("This is a test1 method..");
	}
	
	@Test
	public void test2() {
		System.out.println("This is a test2 method..");
		
		LoginPage loginPage=new LoginPage();
		
		loginPage.login("Admin", "admin123464");
		
		Assert.assertTrue(driver.findElement(By.id("menu_dashboard_index")).isDisplayed());
		
		logger.info("successfully able to login to application");

	}
	
	
	
	
	
	

	/*
	 * @Test(dataProvider = "GetExcelTestData") public void TestMethod2(Object
	 * username, Object password, Object email) {
	 * 
	 * System.out.println("This is a TestMethod2"); System.out.println("username : "
	 * + (username == null ? null : username.toString()));
	 * System.out.println("password : " + (password == null ? null :
	 * password.toString())); System.out.println("email : " + (email == null ? null
	 * : email.toString()));
	 * 
	 * }
	 */

	/*
	 * @DataProvider(name = "GetExcelTestData") public Object[][] TestMethod3()
	 * throws IOException {
	 * 
	 * 
	 * // String[] str = { "pune", "mumbai", "nagpur" };
	 * 
	 * return ExcelUtil.getExcelData();
	 * 
	 * 
	 * }
	 */

}
