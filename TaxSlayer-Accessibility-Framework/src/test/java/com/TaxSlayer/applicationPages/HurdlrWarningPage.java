package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.HurdlrWarningLocators;

public class HurdlrWarningPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public void GetStartedClickMethod() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(HurdlrWarningLocators.getstartedtbtn)));

		WebElement element = driver.findElement(By.cssSelector(HurdlrWarningLocators.getstartedtbtn));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Get Started button works");

	}

}
