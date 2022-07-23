package com.Accessibility.commonClasses;

import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFunction extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 50);

	public void TestMethodLogin(String username, String password) throws InterruptedException

	{

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-text-field")));

		driver.findElement(By.cssSelector("#user-text-field")).sendKeys(username);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password-text-field")));

		driver.findElement(By.cssSelector("#password-text-field")).sendKeys(password);

		Thread.sleep(5000);

		driver.findElement(By.id("login")).click();
		
	}

	public void BypassMfaClick() throws FileNotFoundException, InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.custom-radio:last-child > label")));

		driver.findElement(By.cssSelector("div.custom-radio:last-child > label")).click();

		WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-plain']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

	}

}
