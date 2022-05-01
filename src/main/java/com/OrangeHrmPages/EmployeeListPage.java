package com.OrangeHrmPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CyberSuccessAutomation.baseClass;

public class EmployeeListPage extends baseClass {
	
	public EmployeeListPage() {
		
		PageFactory.initElements(driver, this);
	}

	public By pimModule = By.id("menu_pim_viewPimModule");

	@CacheLookup
	@FindBy(id="btnAdd")
	public WebElement addButton;
	
//	public By addButton = By.id("btnAdd");

	public By deleteButton = By.id("btnDelete");

	public By searchButton = By.id("searchBtn");

	public By resetButton = By.id("resetBtn");

	private By selectAllCheckBox = By.id("ohrmList_chkSelectAll");

	private By empStatusDropDown = By.id("empsearch_employee_status");
	
	public By saveButton=By.id("btnSave");
	
	public By firstName=By.id("firstName");
	
	public By lastName=By.id("lastName");


	public void addEmployee() {

		driver.findElement(pimModule).click();

		WebElement selectAllCheckBox = driver.findElement(this.selectAllCheckBox);

		boolean checkBox = selectAllCheckBox.isSelected();

		System.out.println("Select All check box is checked :" + checkBox);

		Select select = new Select(driver.findElement(empStatusDropDown));

//		select.selectByIndex(2);

//		select.selectByVisibleText("Full-Time Probation");

		/*
		 * select.selectByValue("6");
		 * 
		 * validate(select.getFirstSelectedOption().getText(), "Part-Time Internship");
		 */

		List<WebElement> dropDownValues = select.getAllSelectedOptions();

		for (WebElement element : dropDownValues) {

			String value = element.getText();

			System.out.println(value);
		}

		// Iterate list values using forEach method
		dropDownValues.forEach((val) -> System.out.println(val.getText()));

		/*
		 * driver.findElement(By.name("btnAdd")).click();
		 * 
		 * String firstName=generateRandomString(10);
		 * 
		 * String lastName=generateRandomString(12);
		 * 
		 * driver.findElement(By.id("firstName")).sendKeys(firstName);
		 * 
		 * driver.findElement(By.id("lastName")).sendKeys(lastName);
		 * 
		 * driver.findElement(By.id("chkLogin")).click();
		 * 
		 * driver.findElement(By.id("user_name")).sendKeys(firstName);
		 * 
		 * String password="Password@123";
		 * 
		 * driver.findElement(By.id("user_password")).sendKeys(password);
		 * 
		 * driver.findElement(By.id("re_password")).sendKeys(password);
		 * 
		 * driver.findElement(By.id("btnSave")).click();
		 * 
		 * // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 * 
		 * // driver.get(
		 * "https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList");
		 * 
		 * fluientWait(By.id("menu_pim_viewEmployeeList"));
		 * 
		 * 
		 * // WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10)); // //
		 * wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(
		 * "menu_pim_viewPimModule"))));
		 * 
		 * Thread.sleep(1000);
		 * 
		 * driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		 * 
		 * Thread.sleep(1000);
		 * 
		 * driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(
		 * firstName);
		 * 
		 * driver.findElement(By.id("searchBtn")).click();
		 */
	}

}
