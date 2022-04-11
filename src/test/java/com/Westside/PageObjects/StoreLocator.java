package com.Westside.PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Westside.Utilities.XLUtils;

public class StoreLocator {

	WebDriver lDriver;

	String xlPath = System.getProperty("user.dir") + "/src/test/java/com/Westside/TestData/Book3.xlsx";
	XLUtils xl;

	public StoreLocator(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//span[@id='select2-store_state-container']")
	WebElement storeDropDown;

	public void clickOnStoreDropDown() throws InterruptedException, IOException {

		int lastRowNum = XLUtils.getLastRowNum(xlPath, "Sheet1");

		storeDropDown.click();

		WebElement stateContainer = lDriver.findElement(By.xpath("//div/select[@id='store_state']"));

		Select select = new Select(stateContainer);
		List<WebElement> stateOptions = select.getOptions();
		List<String> stateList = new ArrayList<String>();
		WebElement stateInputTextBox;

		for (WebElement stateOption : stateOptions) {
			String stateName = stateOption.getText();
			if (!stateName.equals("Jammu"))
				stateList.add(stateName);
		}

		for (int i = 1; i < stateList.size(); i++) {
			if (i > 1)
				lDriver.findElement(By.xpath("//span[@id='select2-store_state-container']")).click();
			stateInputTextBox = lDriver.findElement(By.xpath("//span/input[@role='searchbox']"));
			String stateName = stateList.get(i);
			lastRowNum = XLUtils.getLastRowNum(xlPath, "Sheet1");
			XLUtils.setCellValue(xlPath, "Sheet1", lastRowNum + 1, 0, stateName);
			stateInputTextBox.sendKeys(stateName);
			Thread.sleep(300);
			WebElement clickOnSelection = lDriver
					.findElement(By.xpath("//span/ul/li[text()=" + "'" + stateName + "'" + "]"));
			clickOnSelection.click();
			Thread.sleep(300);

			lDriver.findElement(By.xpath("//span[@id='select2-store_city-container']")).click();

			WebElement cityDropDown = lDriver.findElement(By.xpath("//select[@id='store_city']"));

			Select selectDropDown = new Select(cityDropDown);
			List<WebElement> cityElements = selectDropDown.getOptions();

			List<String> cities = new ArrayList<String>();

			for (WebElement cityElement : cityElements) {
				String cityName = cityElement.getText();
				cities.add(cityName);
			}

			for (int j = 1; j < cities.size(); j++) {

				String cityName = cities.get(j);

				lastRowNum = XLUtils.getLastRowNum(xlPath, "Sheet1");

				XLUtils.setCellValue(xlPath, "Sheet1", lastRowNum + 1, 1, cityName);

				if (j > 1)
					lDriver.findElement(By.xpath("//span[@id='select2-store_city-container']")).click();
				WebElement cityInputBox = lDriver.findElement(By.xpath("//input[@class='select2-search__field']"));
				cityInputBox.sendKeys(cityName);

				WebElement citySelection = lDriver
						.findElement(By.xpath("//span/ul/li[text()=" + "'" + cityName + "'" + "]"));
				citySelection.click();
				Thread.sleep(500);
				if (!cityName.equals("Jammu And Kashmir")) {
					WebElement storeDetailElement = lDriver
							.findElement(By.xpath("//header[@class='page-header centeralign']/h1/span"));
					String storeDetailText = storeDetailElement.getText();
					XLUtils.setCellValue(xlPath, "Sheet1", lastRowNum + 1, 2, storeDetailText);
				}
			}

		}

	}

}
