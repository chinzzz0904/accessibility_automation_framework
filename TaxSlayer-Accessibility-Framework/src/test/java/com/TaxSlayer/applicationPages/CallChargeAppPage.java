package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.ChargeSlayerLocators;
import com.Accessibility.pageObjects.HelpandSupportLocators;

public class CallChargeAppPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public void CallChargeAppMethod() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ChargeSlayerLocators.prioryearretlnk)));

		WebElement element = driver.findElement(By.cssSelector(ChargeSlayerLocators.prioryearretlnk));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Prior Year link works and call charge app page opens");

	}

}
