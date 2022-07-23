package com.TaxSlayer.applicationPages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.TransactionHistoryLocators;

public class TransactionHistoryPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 50);

	public void TestMethodTransactionHistory() throws InterruptedException, IOException

	{

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(TransactionHistoryLocators.settingsbtn)));

		WebElement element = driver.findElement(By.cssSelector(TransactionHistoryLocators.settingsbtn));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Settings button for Transaction History page works");

		WebElement element1 = driver.findElement(By.cssSelector(TransactionHistoryLocators.transhistbtn));

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;

		executor1.executeScript("arguments[0].click();", element1);

		System.out.println("Transaction History button works");

	}

}
