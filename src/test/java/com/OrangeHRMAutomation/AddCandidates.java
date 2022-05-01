package com.OrangeHRMAutomation;

import java.io.IOException;

import com.CyberSuccessAutomation.PropertyHandling;
import com.CyberSuccessAutomation.baseClass;
import com.OrangeHrmPages.EmployeeListPage;
import com.OrangeHrmPages.LoginPage;
import com.OrangeHrmPages.RecruitementPage;

public class AddCandidates extends baseClass {

	public static void main(String[] args) throws IOException {
		
		PropertyHandling prop=new PropertyHandling();
		
		LoginPage loginPage=new LoginPage();
		
		EmployeeListPage empListPage=new EmployeeListPage();
		
		RecruitementPage recruitementPage=new RecruitementPage();
		
		getBrowserInstance(prop.getProperty("browser"));
		
		driver.navigate().to(prop.getProperty("orangeHrmUrl"));
		
		loginPage.login(prop.getProperty("orangeHrmUsername"), prop.getProperty("orangeHrmPassword"));
		
		recruitementPage.recruitementMdoule.click();
		
//		driver.findElement(empListPage.addButton).click();
		
		driver.findElement(recruitementPage.firstName).sendKeys(generateRandomString(5));
		
		driver.findElement(recruitementPage.lastName).sendKeys(generateRandomString(5));
		
		driver.findElement(recruitementPage.email).sendKeys(generateRandomString(4)+"@gmail.com");
		
		driver.findElement(empListPage.saveButton).click();
		
		
		

	}

}
