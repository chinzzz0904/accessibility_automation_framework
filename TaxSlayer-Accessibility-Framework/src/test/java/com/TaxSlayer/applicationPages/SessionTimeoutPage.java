package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.ChargeSlayerLocators;
import com.Accessibility.pageObjects.SessionTimeout;

public class SessionTimeoutPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public void SessionTimeoutMethod() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SessionTimeout.yesbtn)));

		System.out.println("Session Timeout Popup opens");

	}

}