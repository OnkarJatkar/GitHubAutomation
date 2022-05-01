package com.OrangeHrmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CyberSuccessAutomation.baseClass;

public class RecruitementPage extends baseClass{
	
	
	public RecruitementPage() {
		PageFactory.initElements(driver, this);	
	}
		
	public By firstName=By.id("addCandidate_firstName");
	
	public By lastName=By.id("addCandidate_lastName");
	
	public By email=By.id("addCandidate_email");	
	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	public WebElement recruitementMdoule;
	
	
	
	

}
