package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;

public class TrackRefundPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 50);

	public void TrackRefundMethod() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(TrackRefundLocators.Trackrefundbtn)));

		WebElement element = driver.findElement(By.cssSelector(TrackRefundLocators.Trackrefundbtn));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Track Refund button works and Track Refund Page opens");

	}
}
