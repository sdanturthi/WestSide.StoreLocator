package com.Westside.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Westside.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rc = new ReadConfig();
	WebDriver driver;
	String urlPath = rc.getWestSideHomePageUrl();
	String cdPath = rc.getChromeDriverPath();
	
	@BeforeClass
	public void SetUp() {		
		System.setProperty("webdriver.chrome.driver", cdPath);
		driver = new ChromeDriver();		
	}
	
	@AfterClass
	protected void TearDown() {
		//driver.quit();
	}

}
