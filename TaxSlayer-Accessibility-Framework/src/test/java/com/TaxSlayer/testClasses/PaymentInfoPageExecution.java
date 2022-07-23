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
import com.TaxSlayer.applicationPages.PaymentInfoPage;
import com.TaxSlayer.configPages.AxeCoreImplmnClass;
import com.TaxSlayer.configPages.CompareWorkItemsinADO;
import com.TaxSlayer.configPages.GetDetailsPOSTAPI;
import com.TaxSlayer.configPages.GetExistingworkitemsPOSTAPI;

public class PaymentInfoPageExecution extends BaseClass {

	@Parameters({ "QAENVURL" })
	@Test
	public void PaymentInfoPageMethod(String QAENVURL) throws InterruptedException, IOException

	{

		/*
		 * String serverUrl = System.getenv("QAENVURL");
		 * 
		 * if (serverUrl.isEmpty()) {
		 * 
		 * serverUrl = QAENVURL; }
		 */

		driver.get(QAENVURL);

		driver.manage().window().maximize();

		try {

//			WelcomepageScreen welcomepgobj = new WelcomepageScreen();

//			welcomepgobj.welcomepageTestmethod();

			ReadExcelLogin readobj = new ReadExcelLogin();

			ArrayList<String> creds = readobj.ReadExcelLoginMethod("basic My Account");

			LoginFunction logfunction = new LoginFunction();

			logfunction.TestMethodLogin("deactivatereturn", "My@ccountPw0!");

			logfunction.BypassMfaClick();

			PaymentInfoPage payinfoobj = new PaymentInfoPage();

			payinfoobj.PaymentInfoMethod();

			AxeCoreImplmnClass logaxecoreobj = new AxeCoreImplmnClass();

			logaxecoreobj.AxeCoreImplmnmethod(pageNameVariables.paymentinfopage);

			GetExistingworkitemsPOSTAPI getworkitemobj = new GetExistingworkitemsPOSTAPI();

			getworkitemobj.ProcessADO(pageNameVariables.paymentinfopage);

			GetDetailsPOSTAPI getDetailsobj = new GetDetailsPOSTAPI();

			getDetailsobj.GetDetails();

			CompareWorkItemsinADO compworkitems = new CompareWorkItemsinADO(pageNameVariables.paymentinfopage);

			compworkitems.CompareMethod();

			myAccountredirection myAccredobj = new myAccountredirection();

			myAccredobj.myAccountredirectionMethod();

			System.out.println("Payment Info Page Execution has ended successfully");
		
		} catch (Throwable e) {
			e.printStackTrace();

		}

	}
}
