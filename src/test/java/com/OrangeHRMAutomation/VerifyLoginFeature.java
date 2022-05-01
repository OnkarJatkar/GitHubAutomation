package com.OrangeHRMAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.CyberSuccessAutomation.baseClass;

import junit.framework.Assert;

public class VerifyLoginFeature extends baseClass{

	public static void main(String[] args) throws Exception {

		getBrowserInstance("Chrome");
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		String pageTitle=driver.getTitle();
		
//		validate(pageTitle, "OrangeHRM");
		
		Assert.assertEquals("OrangeHRM", pageTitle);
				
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		/*
		 * WebElement username=driver.findElement(By.id("txtUsername"));
		 * 
		 * username.sendKeys("Admin");
		 * 
		 * 
		 */
		
		
		WebElement loginButton=driver.findElement(By.id("idvalue"));
		
		if(loginButton.isEnabled()) {
			
			System.out.println("Successfully verified that the element is enabled on the screen..");
			
		}
		
		
		
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.className("button")).click();
		
		String incorrectCredUrl="https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";
		
		if(driver.getCurrentUrl().equals(incorrectCredUrl)) {
			
			String errorMessage=driver.findElement(By.id("spanMessage")).getText();
			
			validate(errorMessage, "Invalid credentials");			
			
		}else {
			String currentUrl=driver.getCurrentUrl();
			
			System.out.println(currentUrl);
			
			validate(currentUrl, "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			
			
			if(driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).isEnabled()) {
				
				System.out.println("Successfully validated the admin module visibility after login");
			}else {
				
				throw new Exception("Failed to vlaidate Admin module");
			}
		}	
	}

}
