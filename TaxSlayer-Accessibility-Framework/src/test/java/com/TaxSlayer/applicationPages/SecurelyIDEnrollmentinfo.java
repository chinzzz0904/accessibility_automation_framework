package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.SecurelyIDLocators;

public class SecurelyIDEnrollmentinfo extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 50);

	public void SecurelyIDMethod() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SecurelyIDLocators.purchasebtn)));

		WebElement element = driver.findElement(By.cssSelector(SecurelyIDLocators.purchasebtn));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Purchase button works");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SecurelyIDLocators.startMyProtectionbtn)));

		WebElement element1 = driver.findElement(By.cssSelector(SecurelyIDLocators.startMyProtectionbtn));

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;

		executor1.executeScript("arguments[0].click();", element1);

		System.out.println("Start My Protection button works");


	}

}
