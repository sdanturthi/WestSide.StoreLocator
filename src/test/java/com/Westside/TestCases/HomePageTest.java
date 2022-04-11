package com.Westside.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Westside.PageObjects.HomePage;
import com.Westside.PageObjects.StoreLocator;

public class HomePageTest extends BaseClass{
	
	@Test
	private void TestHomePage_TC001() throws InterruptedException, IOException{
		driver.get(urlPath);
		HomePage hp = new HomePage(driver);
		hp.storeLocatorClick();
		StoreLocator sl = new StoreLocator(driver);
		sl.clickOnStoreDropDown();
	}	
}
