package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.ChargeSlayerLocators;

public class ChargeSuccessPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 50);

	public void ChargeSuccessMethod() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ChargeSlayerLocators.prioryearretlnk)));

		WebElement element = driver.findElement(By.cssSelector(ChargeSlayerLocators.prioryearretlnk));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("Prior Year link works and call charge app page opens");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ChargeSlayerLocators.checkbox)));

		WebElement element1 = driver.findElement(By.cssSelector(ChargeSlayerLocators.checkbox));

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element1);

		WebElement element2 = driver.findElement(By.cssSelector(ChargeSlayerLocators.continuebtn));

		JavascriptExecutor executor2 = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element2);

		System.out.println("Payment Info page opens");

		Thread.sleep(7000);

		WebElement element3 = driver.findElement(By.name(ChargeSlayerLocators.info_checkbox));

		element3.click();

		System.out.println("Info checkbox is clicked");

		WebElement element4 = driver.findElement(By.cssSelector(ChargeSlayerLocators.ziptxtbox));

		element4.sendKeys("19406");

		System.out.println("Zip number is updated ");

		WebElement element5 = driver.findElement(By.cssSelector(ChargeSlayerLocators.phoneno));

		element5.sendKeys("(111) 111-1111");

		System.out.println("Phone number is entered ");

		Thread.sleep(5000);

		WebElement element6 = driver.findElement(By.cssSelector(ChargeSlayerLocators.namebox));

		element6.sendKeys("Rakshit Ogra");

		System.out.println("Name is entered ");

		WebElement element7 = driver.findElement(By.cssSelector(ChargeSlayerLocators.cardnobox));

		element7.sendKeys("4788 2500 0012 1443");

		System.out.println("Card number is entered ");

		WebElement element8 = driver.findElement(By.cssSelector(ChargeSlayerLocators.expdatebox));

		element8.sendKeys("12/22");

		System.out.println("Exp Date is entered ");

		WebElement element9 = driver.findElement(By.cssSelector(ChargeSlayerLocators.CVVbox));

		element9.sendKeys("112");

		System.out.println("CVC is entered ");

		WebElement element10 = driver.findElement(By.cssSelector(ChargeSlayerLocators.submitbtn));

		JavascriptExecutor executor10 = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element10);

		System.out.println(" Charge Success page opens");

	}

}
