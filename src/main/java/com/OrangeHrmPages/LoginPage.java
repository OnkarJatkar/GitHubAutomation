package com.OrangeHrmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CyberSuccessAutomation.baseClass;

public class LoginPage extends baseClass{
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
//	private By username=By.id("txtUsername");
	
	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement loginButton;
	
	@FindBy(id="welcome")
	private WebElement profile;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
//	private By password=By.id("txtPassword");
	
//	private By loginButton=By.id("btnLogin");
	
	private By forgotPassewordLink=By.partialLinkText("Forgot your password");
	
	public void login(String username,String password) {		
		
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		loginButton.click();	
	}
	
	public void logout() {		
		profile.click();
		logout.click();		
	}
	
	
	
	

}
