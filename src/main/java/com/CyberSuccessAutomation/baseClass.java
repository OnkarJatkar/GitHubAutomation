package com.CyberSuccessAutomation;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public static WebDriver driver = null;
	public static ExtentTest logger;

	public static void getBrowserInstance(String browser) {

		switch (browser) {

		//Case to launch chrome browser
		case "Chrome":
			
//			System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver(setChromeOptions());
			break;
		
		//case to launch edge browser
		case "Edge":			
//			System.setProperty("webdriver.edge.driver", "C:\\Tools\\edgedriver_win64\\msedgedriver.exe");
			
			WebDriverManager.edgedriver().setup();
			
			driver = new EdgeDriver();
			break;
			
		// if no case match then default will launch chrome browser
		default:
			
			System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

		}
	}
	
	/**
	 * method to validate expected result with actual	 * 
	 * @param actual
	 * @param expected
	 * @throws Exception
	 */
	public static void validate(String actual,String expected) throws Exception {
		
		if(actual.equals(expected)) {
			
			System.out.println("Successfully validated "+ actual+" in the screen");
			
		}else {
			
			throw new Exception("Faild to validate the"+ actual+ " with "+ expected);
			
		}  		
		
	}
	
	public static String generateRandomString(int count) {
		
		Random random=new Random();		
		
		return  random.ints(65, 90)
				.limit(count).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static void fluientWait(By by) {
		
		Wait wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
				
		wait.until(new Function<WebDriver, WebElement>(){
			@Override
			public WebElement apply(WebDriver driver) {

				System.out.println("Applying fluent wait....");
				return driver.findElement(by);
			}
		});
	}
	
	public static ChromeOptions setChromeOptions() {		
		ChromeOptions option=new ChromeOptions();
//		option.addArguments("--headless");
		option.setHeadless(false);
		option.setImplicitWaitTimeout(Duration.ofSeconds(10));
		option.addArguments("--incognito");
		option.setAcceptInsecureCerts(true);		
		Map<String,Object> map=new HashMap<>();
//		map.put("download.default_directory", "C://");
		map.put("profile.password_manager_enabled", false);
		option.setExperimentalOption("prefs", map);		
			
		return option;
	}
	
	public void createFolder(String filePath) {
		
		File file=new File(filePath);
		if(!file.exists()) {
			file.mkdir();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
