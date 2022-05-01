package com.hrm.automation;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.CyberSuccessAutomation.PropertyHandling;
import com.CyberSuccessAutomation.baseClass;
import com.OrangeHrmPages.EmployeeListPage;
import com.OrangeHrmPages.LoginPage;

public class VerifyAddEmp extends baseClass{
	
	PropertyHandling prop;
	LoginPage loginPage;
	EmployeeListPage empPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws IOException {
		 prop=new PropertyHandling();
		  
//		  getBrowserInstance(prop.getProperty("browser"));		 
		 getBrowserInstance(browser);
	}
		
  @Parameters({"username", "password"})
  @Test(priority=1)
  public void loginOrangeHrm(String username, String password) throws IOException {
	  
	  System.out.println("Execution started for Login method.......");	  
	  loginPage=new LoginPage();
	  
	  driver.navigate().to(prop.getProperty("orangeHrmUrl"));
	  
//	  loginPage.login(prop.getProperty("orangeHrmUsername"), prop.getProperty("orangeHrmPassword"));	  
	  
	  loginPage.login(username, password);
	  
	  
//	  String unames=prop.getProperty("ornageHrmInvalidUN");
	  
//	  String [] usernames=unames.split(",");
//	  String [] password=prop.getProperty("ornageHrmInvalidPW").split(",");
	  
  }
  
  @Test(priority=2)
  public void addEmployee() {
	  
	  System.out.println("Execution started for Add Emp method.......");
	  
	  empPage=new EmployeeListPage();
	  
	  driver.findElement(empPage.pimModule).click();
	  
	  empPage.addButton.click();
	  
	  driver.findElement(empPage.firstName).sendKeys(generateRandomString(5));
	  
	  driver.findElement(empPage.lastName).sendKeys(generateRandomString(4));
	  
	  driver.findElement(empPage.saveButton).click();  
	  
  }
  
  @Test(priority=3)
  public void verifyAddEmp() {
	  
	  System.out.println("Execution started for verify Emp method.......");

	  
	  
	  
  }
  
  @Test(priority=4)
  public void logout() {
	  System.out.println("Execution started for LogOut method.......");
  
	  loginPage.logout();
	  
  }
  
  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
	  
  }
  
  
  
  
  
  
  
  
  
  
}
