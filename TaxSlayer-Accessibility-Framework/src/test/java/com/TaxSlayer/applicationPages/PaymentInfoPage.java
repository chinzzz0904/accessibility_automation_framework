package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.ChargeSlayerLocators;

public class PaymentInfoPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public void PaymentInfoMethod() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ChargeSlayerLocators.prioryearretlnk)));

		WebElement element = driver.findElement(By.cssSelector(ChargeSlayerLocators.prioryearretlnk));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Prior Year link works and call charge app page opens");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ChargeSlayerLocators.checkbox)));

		WebElement element1 = driver.findElement(By.cssSelector(ChargeSlayerLocators.checkbox));

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element1);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ChargeSlayerLocators.continuebtn)));

		WebElement element2 = driver.findElement(By.cssSelector(ChargeSlayerLocators.continuebtn));

		JavascriptExecutor executor2 = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element2);

		System.out.println(" Payment Info page opens");

	}

}
