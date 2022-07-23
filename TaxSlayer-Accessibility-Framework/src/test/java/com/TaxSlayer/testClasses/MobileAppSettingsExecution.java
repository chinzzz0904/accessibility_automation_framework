package com.TaxSlayer.testClasses;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Accessibility.Utilities.ReadExcelLogin;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.commonClasses.LoginFunction;
import com.Accessibility.commonClasses.myAccountredirection;
import com.Accessibility.pageVariables.pageNameVariables;
import com.TaxSlayer.applicationPages.MobileAppSettingsPage;
import com.TaxSlayer.applicationPages.WelcomepageScreen;
import com.TaxSlayer.configPages.AxeCoreImplmnClass;
import com.TaxSlayer.configPages.CompareWorkItemsinADO;
import com.TaxSlayer.configPages.GetDetailsPOSTAPI;
import com.TaxSlayer.configPages.GetExistingworkitemsPOSTAPI;

public class MobileAppSettingsExecution extends BaseClass {

	@Parameters({ "QAENVURL" })
	@Test
	public void MobileAppSettingsExecutionMethod(String QAENVURL) throws InterruptedException, IOException

	{

		driver.get(QAENVURL);

		driver.manage().window().maximize();

		try {

//			WelcomepageScreen welcomepgobj = new WelcomepageScreen();

//			welcomepgobj.welcomepageTestmethod();

			ReadExcelLogin readobj = new ReadExcelLogin();

			ArrayList<String> creds = readobj.ReadExcelLoginMethod("basic My Account");

			LoginFunction logfunction = new LoginFunction();

			logfunction.TestMethodLogin(creds.get(0), creds.get(1));

			logfunction.BypassMfaClick();

			MobileAppSettingsPage mobAppsetobj = new MobileAppSettingsPage();

			mobAppsetobj.TestMethodMobileAppSettings();

			AxeCoreImplmnClass logaxecoreobj = new AxeCoreImplmnClass();

			logaxecoreobj.AxeCoreImplmnmethod(pageNameVariables.mobsettingsname);

			GetExistingworkitemsPOSTAPI getworkitemobj = new GetExistingworkitemsPOSTAPI();

			getworkitemobj.ProcessADO(pageNameVariables.mobsettingsname);

			GetDetailsPOSTAPI getDetailsobj = new GetDetailsPOSTAPI();

			getDetailsobj.GetDetails();

			CompareWorkItemsinADO compworkitems = new CompareWorkItemsinADO(pageNameVariables.mobsettingsname);

			compworkitems.CompareMethod();

			myAccountredirection myAccredobj = new myAccountredirection();

			myAccredobj.myAccountredirectionMethod();

			System.out.println("Mobile App Settings Execution has ended successfully");

		} catch (Throwable e) {
			e.printStackTrace();

		}

	}

}
