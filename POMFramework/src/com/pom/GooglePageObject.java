package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePageObject {
	GooglePageObject(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="q")
	WebElement enterText;
	@FindBy(name="btnG")
	WebElement searchButton;
	@FindBy(linkText="Selenium - Web Browser Automation")
	WebElement seleniumLink;
	
	public void googleSearch(String text){
		enterText.sendKeys(text);
		searchButton.click();
	}
	//to link different pages returning next page object instead of void
	public void/*SeleniumPageObjects*/ seleniumSearch(){
		seleniumLink.click();
		//return new SeleniumPageObjects(driver1);
		
	}

}
