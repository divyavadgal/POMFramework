package com.pom;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.DDT.ExcelLib;
import com.DDT.XmlUtil;
import com.DDT.XmlUtil;

public class TestCaller {
	/*@BeforeClass
	void initiate() throws Exception{
	XmlUtil.createXml();	
	}*/
  @Test
  public void TestMethod1() throws InterruptedException, IOException {
	  WebDriver driver=new FirefoxDriver();
		String excelPath="C:/Users/Bachhi/myprojectworkspace/POMFramework/googleSearchData.xls";
		String sheetName="Sheet1";
		String searchData;
		// TODO Auto-generated method stub
		driver.get("https://www.google.com/");
		
		GooglePageObject google=new GooglePageObject(driver);
		ExcelLib excel=new ExcelLib(excelPath,sheetName);
		//reading search data from excel by using column header i.e. here searchterms
		searchData=excel.readDataXl(1,"searchterms");
		google.googleSearch(searchData);
		Thread.sleep(4000);
		google.seleniumSearch();
		SeleniumPageObjects seleniumPage=new SeleniumPageObjects(driver);
		Thread.sleep(4000);
		seleniumPage.clickDownload();
		seleniumPage.navigateHomepage();
		
		driver.quit();
  }
  
  @Test
  public void TestMethod2() {
	  System.out.println("hi2");
  }
}
