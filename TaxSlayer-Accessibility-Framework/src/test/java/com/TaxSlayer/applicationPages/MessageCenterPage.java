package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.MessageCenterLocators;

public class MessageCenterPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public void MessageCenterMethod() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(MessageCenterLocators.Mailboxbtn)));

		WebElement element = driver.findElement(By.cssSelector(MessageCenterLocators.Mailboxbtn));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Mailbox page does open");

	}

}
