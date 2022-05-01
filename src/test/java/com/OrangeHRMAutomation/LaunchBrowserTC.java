package com.OrangeHRMAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowserTC {

	public static void main(String[] args) throws Exception {

		WebDriver driver = null;// initialization
		try {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Tools\\edgedriver_win64\\msedgedriver.exe");
		
		//launch the browser
//		driver=new ChromeDriver();
		
//		driver=new EdgeDriver();
		
		driver=new FirefoxDriver();
		
		//navigate to website
		
//		driver.get("https://google.com");
		driver.navigate().to("https://google.com");
		
		//move to back page
		driver.navigate().back();
		
		//get the title of the page
		System.out.println("Page 1 Title: "+driver.getTitle());
		
		//move to forward page
		driver.navigate().forward();
		
		System.out.println("Page 2 title :"+ driver.getTitle());

		//print the title
		
		 System.out.println("Tile of the google page is : "+driver.getTitle());
		  
		  if(driver.getTitle().equals("Google")) {
		  
		  System.out.println("Successfully validated the title of the google page.");
		  }else {
		  
		  throw new Exception("Failed to validate the title of google page..");
		  
		  }
		  
		  driver.navigate().refresh();
		  
		}catch(Exception e) {
			
			e.printStackTrace();
		
		} finally {
			driver.close();
			
		}
		
	}

}
