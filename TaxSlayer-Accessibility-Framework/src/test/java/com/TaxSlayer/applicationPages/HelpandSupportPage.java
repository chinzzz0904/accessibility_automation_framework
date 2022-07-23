package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.HelpandSupportLocators;

public class HelpandSupportPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 50);

	public void HelpandSupportMethod() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(HelpandSupportLocators.helpsuppbtn)));

		WebElement element = driver.findElement(By.cssSelector(HelpandSupportLocators.helpsuppbtn));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Help and Support button works and menu opens");

	}

}
