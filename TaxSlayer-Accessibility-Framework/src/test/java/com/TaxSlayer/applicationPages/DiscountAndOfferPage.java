package com.TaxSlayer.applicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageObjects.UserConsoleLocators;

public class DiscountAndOfferPage extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public void DiscountAndOfferMethod() {

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(UserConsoleLocators.myAccountelement)));

		// Using the URL for Local Environment

		driver.navigate().to("http://localhost:3000/myaccount?mcode=pyjanregnewpaid2021");

		System.out.println("Discount and Offer Page opens");

	}

}
