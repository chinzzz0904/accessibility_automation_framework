package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.HelpandSupportLocators;

public class HelpandSupportTechQPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public void HelpandSupportTechQMethod() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(HelpandSupportLocators.helpsuppbtn)));

		WebElement element = driver.findElement(By.cssSelector(HelpandSupportLocators.helpsuppbtn));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Help and Support button works and menu opens");

//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(HelpandSupportLocators.techqueradiobtn)));

		WebElement element1 = driver.findElement(By.cssSelector(HelpandSupportLocators.techqueradiobtn));

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;

		executor1.executeScript("arguments[0].click();", element1);

		System.out.println("Tech Question Radio button works");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(HelpandSupportLocators.mytopnotlistlnk)));

		WebElement element2 = driver.findElement(By.cssSelector(HelpandSupportLocators.mytopnotlistlnk));

		JavascriptExecutor executor2 = (JavascriptExecutor) driver;

		executor2.executeScript("arguments[0].click();", element2);

		System.out.println("My Topic is not listed link works");

	}

}
