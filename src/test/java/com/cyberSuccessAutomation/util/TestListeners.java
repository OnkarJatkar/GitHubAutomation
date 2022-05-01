package com.cyberSuccessAutomation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.CyberSuccessAutomation.baseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListeners extends baseClass implements ISuiteListener, ITestListener{
	private ExtentSparkReporter htmlReporter; //create html report
	private ExtentReports extentReport; 

	public void onStart(ISuite suite) {
		
		String  reportFolderPath=System.getProperty("user.dir")+"\\ExtentReports";
		createFolder(System.getProperty("user.dir")+"\\ScreenShots");
		createFolder(reportFolderPath);		
		
		String time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yy-hh-mm-ss"));

		htmlReporter=new ExtentSparkReporter(reportFolderPath+"\\AutomationReport"+time+".html");
		
		extentReport=new ExtentReports();
		
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("browser", "chrome");
		
		extentReport.setSystemInfo("user", "system");
		
		System.out.println("Suite Execution started........");
	}
	   
	public  void onStart(ITestContext context) {
		
		System.out.println("Test Execution started........for test: "+ context.getName());
	}
	
	public void onFinish(ISuite suite) {
		
		extentReport.flush();
		System.out.println("Suite Execution completed........");
		driver.quit();

	}
	
	public void onFinish(ITestContext context) {
		System.out.println("Test Execution completed........for test: "+ context.getName());

	}
	
	public void onTestStart(ITestResult result) {
		
		logger= extentReport.createTest(result.getMethod().getMethodName());
		
		System.out.println("This is a onTestStart method....");
	}
	
	public  void onTestSuccess(ITestResult result) {

		logger.info("method "+ result.getMethod().getMethodName()+" executed succeffuly...");
		System.out.println("This is a onTestSuccess method.... and execution completed for "+result.getMethod().getMethodName());

	}
	public void onTestFailure(ITestResult result) {

		String time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yy-hh-mm-ss"));
		
		String filePath=System.getProperty("user.dir")+"\\ScreenShots\\"+result.getMethod().getMethodName()+time+".png";
		
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		
		File srcFile=screenShot.getScreenshotAs(OutputType.FILE); //file extension will be .png
		
		try {
			File dstFile=new File(filePath);
			
			FileUtils.copyFile(srcFile, dstFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.fail("Method failed due to the reason: "+ result.getThrowable());
		logger.addScreenCaptureFromPath(filePath);
		
	}
	
	public void onTestSkipped(ITestResult result) {

		System.out.println("This is a onTestSkipped method....");

	}

	
}
