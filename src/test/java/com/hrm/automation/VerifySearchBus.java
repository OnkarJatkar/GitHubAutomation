package com.hrm.automation;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.CyberSuccessAutomation.PropertyHandling;
import com.CyberSuccessAutomation.baseClass;
import com.OrangeHrmPages.RedbusPage;

public class VerifySearchBus extends baseClass {

	PropertyHandling prop;
	RedbusPage redbusPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws IOException {
		prop = new PropertyHandling();
		redbusPage = new RedbusPage();

		getBrowserInstance(browser);
//		getBrowserInstance(prop.getProperty("browser"));

		driver.navigate().to("https://www.redbus.in/");
	}

	@Test
	public void searchBusses() {

		driver.findElement(redbusPage.fromLocation)
		.sendKeys(prop.getProperty("redbusFromLocation"));

		driver.findElement(redbusPage.searchResult).click();

		driver.findElement(redbusPage.toLocation)
		.sendKeys(prop.getProperty("redbusToLocation"));

		driver.findElement(redbusPage.searchResult).click();

		int currentDay = LocalDateTime.now().getDayOfMonth();

		driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//tr/td"))
		.forEach(element -> {
			String attributeVal = element.getAttribute("class");

			if (attributeVal.equals("we day") || attributeVal.equals("wd day")) {

				if (!element.getText().isEmpty() &&
						(currentDay + 1) == Integer.parseInt(element.getText())) {

					element.click(); // break;
				}
			}

		});
		driver.findElement(redbusPage.searchButton).click();
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}

}
