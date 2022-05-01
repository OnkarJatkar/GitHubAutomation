package com.OrangeHrmPages;

import org.openqa.selenium.By;

public class RedbusPage {
	
	public By fromLocation=By.id("src");
	
	public By toLocation=By.id("dest");
	
	public By searchResult=By.xpath("//ul[@class='autoFill homeSearch']/li[1]");
	
	public By searchButton=By.id("search_btn");
	

}
