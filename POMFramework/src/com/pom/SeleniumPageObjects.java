package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPageObjects {
	/*SeleniumPageObjects(){
		//empty constructor
	}*/
	SeleniumPageObjects(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id='menu_download']/a")
	WebElement download;
	@FindBy(linkText="Browser Automation")
	WebElement homepage;
	
	
	void clickDownload(){
		download.click();
		//return new SeleniumPageObjects();
	}
	void navigateHomepage(){
		homepage.click();
	}
}
