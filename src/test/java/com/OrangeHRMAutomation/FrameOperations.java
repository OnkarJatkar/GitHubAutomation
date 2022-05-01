package com.OrangeHRMAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.CyberSuccessAutomation.baseClass;

public class FrameOperations extends baseClass {

	public static void main(String[] args) throws AWTException {
		
		getBrowserInstance("Chrome");
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
//		String parentWindow=driver.getWindowHandle();
		
//		driver.switchTo().frame(driver.findElement(By.xpath("//div[@rel-title='Photo Manager']//iframe")));
		
		Actions act=new Actions(driver);
		
//		act.moveToElement(driver.findElement(By.id("btnLogin"))).click().build().perform();
		
//		act.contextClick().build().perform();
		
		act.contextClick(driver.findElement(By.linkText("Forgot your password?"))).build().perform();
		
		Robot robot=new Robot();
		
		robot.keyPress(KeyEvent.VK_DOWN);
		
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		//perform mouse right click using robot class
				robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
				
				robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
				
				
				//perform mouse left click using robot class
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				
				//perform wheel scroll using robot class
				robot.mouseWheel(80);
		
//		act.click(driver.findElement(By.linkText("Forgot your password?"))).build().perform();
		
		
		/*
		 * WebElement source=driver.findElement(By.xpath(
		 * "//img[@src='images/high_tatras3_min.jpg']"));
		 * 
		 * WebElement dst=driver.findElement(By.id("trash"));
		 * 
		 * 
		 * act.clickAndHold(source).moveToElement(dst).release().build().perform();
		 * 
		 * // act.dragAndDrop(source, dst).build().perform();
		 * 
		 * 
		 * driver.switchTo().window(parentWindow);
		 */
//		driver.switchTo().defaultContent();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
