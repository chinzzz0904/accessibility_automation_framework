package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.UserConsoleLocators;

public class UserConsoleScreen extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	public void TestMethodUserConsole() throws InterruptedException

	{

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(UserConsoleLocators.myAccountelement)));
		
		Thread.sleep(5000);
	}

}
