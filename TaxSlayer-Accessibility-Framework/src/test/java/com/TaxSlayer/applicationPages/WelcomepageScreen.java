package com.TaxSlayer.applicationPages;

import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.WelcomePageLocators;

public class WelcomepageScreen extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public void welcomepageTestmethod() throws InterruptedException, FileNotFoundException {

		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(WelcomePageLocators.loginbtn)));

		driver.findElement(By.cssSelector(WelcomePageLocators.loginbtn)).click();

	}

}
