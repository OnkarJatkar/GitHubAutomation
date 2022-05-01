package com.OrangeHRMAutomation;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CyberSuccessAutomation.baseClass;

public class JavaScriptImplementation extends baseClass{

	public static void main(String[] args) throws InterruptedException {

		getBrowserInstance("Chrome");
		
		driver.navigate().to("https://www.selenium.dev/documentation/webdriver/browser/alerts/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
//		js.executeScript("window.scrollBy(1000,0);");	
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
//		driver.findElement(By.xpath("//h2[@id='prompt']/following::a[1]")).click();
		
//		js.executeScript("arguments[0].click();", driver.findElement(By.id("btnLogin")));
		
//		js.executeScript("alert('This is sample alert in selenium!');");
		
		
		/*
		 * WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 * 
		 * wait.until(ExpectedConditions.alertIsPresent());
		 * 
		 * 
		 * // Thread.sleep(10000);
		 * 
		 * Alert alert=driver.switchTo().alert();
		 * 
		 * alert.sendKeys("This is a alert text");
		 */
		  
//		  alert.accept();
		 
		
//		js.executeScript("confirm('This is sample alert in selenium!');");
			
		
	}

}
