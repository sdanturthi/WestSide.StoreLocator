package com.Westside.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver lDriver;

	public HomePage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Store Locator']")
	WebElement storeLocator;

	public void storeLocatorClick() {		
		lDriver.manage().window().maximize();
		scrollToBottomOfPage();
		storeLocator.click();		
	}

	public void scrollToBottomOfPage() {
		JavascriptExecutor jse = (JavascriptExecutor) lDriver;
		
		while (true) {
			long old_Height = (long) jse.executeScript("return document.body.scrollHeight");
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			long new_Height = (long) jse.executeScript("return document.body.scrollHeight");

			if ((new_Height - old_Height) > 0) 
				continue;
			else
				break;
		}
	}

}
