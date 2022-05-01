package com.OrangeHRMAutomation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.CyberSuccessAutomation.baseClass;

public class VerifyBrokenLinks extends baseClass {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
		getBrowserInstance(browser);
		driver.navigate().to("https://www.amazon.in/");
		}

	@Test
	public void findBrokenLinks() {
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));

		linkElements.forEach((element) -> {

			String link = element.getAttribute("href");

			if (Objects.nonNull(link) && link.startsWith("http")) {

//				System.out.println(link);

				try {
					URL url = new URL(link);

					URLConnection connection = url.openConnection();

					HttpURLConnection httpConnect = (HttpURLConnection) connection;

					httpConnect.connect();

					int statusCode = httpConnect.getResponseCode();

					if (statusCode != 200) {

						System.out.println("Broken Url: " + statusCode + " " + link);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
