package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.LicenseAgreementLocators;

public class PoliciesLicenseAgreement extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 50);

	public void TestMethodLicenseAgreement() throws InterruptedException

	{

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(LicenseAgreementLocators.settingsbtn)));

		WebElement element = driver.findElement(By.cssSelector(LicenseAgreementLocators.settingsbtn));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Settings button for Policies works");

		WebElement element1 = driver.findElement(By.cssSelector(LicenseAgreementLocators.licenseagreementbtn));

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;

		executor1.executeScript("arguments[0].click();", element1);

		System.out.println("License Agreement button works");

	}

}