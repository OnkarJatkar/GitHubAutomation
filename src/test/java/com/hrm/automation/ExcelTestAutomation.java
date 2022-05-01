package com.hrm.automation;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.CyberSuccessAutomation.ExcelUtil;
import com.OrangeHrmPages.LoginPage;


public class ExcelTestAutomation {
	
	@Test
	public void Assertion() {
		
		String actualMsg="Pune";
		
		String expectedMsg="Mumbai";
		
//		Assert.assertEquals("expectedResult", "actualResult");
		
//		Assert.assertTrue(condition);
//		Assert.assertTrue("message", condition);
		
//		Assert.assertFalse("message", condition);
		
		
		Assert.assertTrue(actualMsg.equals(expectedMsg));
		
		/*
		 * SoftAssert assertion=new SoftAssert();
		 * 
		 * assertion.assertEquals(actualMsg, expectedMsg);
		 * 
		 * assertion.assertTrue(1==0);
		 * 
		 * assertion.assertFalse(1==0); //pass
		 */		
	}
	
	
	@Test
	public void test1() throws IOException {

		String filePath = "C:\\Users\\danghar\\OneDrive - Hilti\\Documents\\AutomationTestData.xlsx";
		
		List.of("username1", "usernam2", "username3").forEach(val->{
			
			try {
				ExcelUtil.setExcelData(filePath, "TestData", 0, 0, val);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		});
//	  
		ExcelUtil.setExcelData(filePath, "TestData", 0, 0, "username1");

		ExcelUtil.setExcelData(filePath, "TestData", 0, 1, "password1");

		Object[][] excelData = ExcelUtil.getExcelData(filePath, "Sheet1");

		for (int i = 1; i < excelData.length; i++) {

			for (int j = 0; j < excelData[0].length; j++) {

				System.out.println(excelData[i][j]);

			}
		}

	}

	@Test(dataProvider = "ExcelDataProvider")
	public void login(Object username, Object password) {

		System.out.println("username: "+ username + " password: "+ password);
		LoginPage loginPage=new LoginPage();
		loginPage.login(username.toString(), password.toString());
		
	}

	@DataProvider(name = "ExcelDataProvider")
	public Object[][] getData() throws IOException {

		String filePath = "C:\\Users\\danghar\\OneDrive - Hilti\\Documents\\AutomationTestData.xlsx";

		
		return ExcelUtil.getExcelData(filePath, "Sheet1");
	}

}
