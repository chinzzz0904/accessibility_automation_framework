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
import com.TaxSlayer.applicationPages.ChargeSuccessPage;
import com.TaxSlayer.applicationPages.SessionTimeoutPage;
import com.TaxSlayer.configPages.AxeCoreImplmnClass;
import com.TaxSlayer.configPages.CompareWorkItemsinADO;
import com.TaxSlayer.configPages.GetDetailsPOSTAPI;
import com.TaxSlayer.configPages.GetExistingworkitemsPOSTAPI;

public class SessionTimeoutPopupExecution extends BaseClass {

	@Parameters({ "LOCALENVURL" })
	@Test
	public void SessionTimeoutPopupMethod(String LOCALENVURL) throws InterruptedException, IOException

	{

		driver.get(LOCALENVURL);

		driver.manage().window().maximize();

		try {

//		WelcomepageScreen welcomepgobj = new WelcomepageScreen();

//		welcomepgobj.welcomepageTestmethod();

			ReadExcelLogin readobj = new ReadExcelLogin();

			ArrayList<String> creds = readobj.ReadExcelLoginMethod("basic My Account");

			LoginFunction logfunction = new LoginFunction();

			logfunction.TestMethodLogin(creds.get(0), creds.get(1));

			logfunction.BypassMfaClick();

			SessionTimeoutPage sesstimeobj = new SessionTimeoutPage();

			sesstimeobj.SessionTimeoutMethod();

			AxeCoreImplmnClass logaxecoreobj = new AxeCoreImplmnClass();

			logaxecoreobj.AxeCoreImplmnmethod(pageNameVariables.sessiontimeoutpopup);

			GetExistingworkitemsPOSTAPI getworkitemobj = new GetExistingworkitemsPOSTAPI();

			getworkitemobj.ProcessADO(pageNameVariables.sessiontimeoutpopup);

			GetDetailsPOSTAPI getDetailsobj = new GetDetailsPOSTAPI();

			getDetailsobj.GetDetails();

			CompareWorkItemsinADO compworkitems = new CompareWorkItemsinADO(pageNameVariables.sessiontimeoutpopup);

			compworkitems.CompareMethod();

			myAccountredirection myAccredobj = new myAccountredirection();

			myAccredobj.myAccountredirectionMethod();

			System.out.println("Payment Info Page Execution has ended successfully");
		} catch (Throwable e) {
			e.printStackTrace();

		}

	}
}
