package com.OrangeHRMAutomation;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.CyberSuccessAutomation.baseClass;

public class Amazon extends baseClass{

	public static void main(String[] args) {
		
		getBrowserInstance("Chrome");
		
		driver.navigate().to("https://www.amazon.in/");

		Select select=new Select(driver.findElement(By.id("searchDropdownBox")));
		
		select.selectByVisibleText("Electronics");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//wait 10 sec for visibility of webelements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//click on first mobile result
		driver.findElement(By.xpath("//div[@data-cel-widget='search_result_2']/descendant::h2")).click();
		
		//get parent window id		
		String parentWindow=driver.getWindowHandle();
		
		System.out.println(parentWindow);
		
		//get set of all windows id
		Set<String> allWondows=driver.getWindowHandles();
		
		//iterate all window ids and filter child window id
		for(String windowId:allWondows) {
			
			if(!windowId.equals(parentWindow)) {	
				
				//swtich control from parent window to child window
				driver.switchTo().window(windowId);	
				
				//print title of second window
				System.out.println(driver.getTitle());
				
				//print id of second window
				System.out.println(windowId);	
				
				driver.close();	
				
				driver.switchTo().window(parentWindow);	
				
			}	
		}		
		
		System.out.println(driver.getTitle());
		
	}

}
