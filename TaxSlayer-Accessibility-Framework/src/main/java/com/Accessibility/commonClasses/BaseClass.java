package com.Accessibility.commonClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public static WebDriver driver;

	@BeforeClass
	public void setup() {

		FirefoxOptions ffOptions = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.cookie.sameSite.laxByDefault", false); // Setting laxByDefault
		profile.setPreference("network.cookie.sameSite.noneRequiresSecure", false); // Setting noneRequiresSecure
		ffOptions.setProfile(profile);
		driver = new FirefoxDriver(ffOptions);
	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}

}
