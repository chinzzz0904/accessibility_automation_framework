package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.UserConsoleLocators;

public class ViewDetailsPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 50);

	public void ViewDetailsMethod() {

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(UserConsoleLocators.viewDetailsbtn)));

		WebElement element = driver.findElement(By.cssSelector(UserConsoleLocators.viewDetailsbtn));

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", element);

		System.out.println("View Details button on User Console page works");

	}

}
