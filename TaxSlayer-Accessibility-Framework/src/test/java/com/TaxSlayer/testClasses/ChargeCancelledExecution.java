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
import com.TaxSlayer.applicationPages.ChargeCancelledPage;
import com.TaxSlayer.applicationPages.PaymentInfoPage;
import com.TaxSlayer.configPages.AxeCoreImplmnClass;
import com.TaxSlayer.configPages.CompareWorkItemsinADO;
import com.TaxSlayer.configPages.GetDetailsPOSTAPI;
import com.TaxSlayer.configPages.GetExistingworkitemsPOSTAPI;

public class ChargeCancelledExecution extends BaseClass {

//Need to ensure that the user should have atleast one Start A New Tax Return link in Prior Year Sections	

	
	@Parameters({ "QAENVURL" })
	@Test
	public void ChargeCancelledMethod(String QAENVURL) throws InterruptedException, IOException

	{

		try {
			driver.get(QAENVURL);

			driver.manage().window().maximize();

//			WelcomepageScreen welcomepgobj = new WelcomepageScreen();

//			welcomepgobj.welcomepageTestmethod();

			ReadExcelLogin readobj = new ReadExcelLogin();

			ArrayList<String> creds = readobj.ReadExcelLoginMethod("basic My Account");

			LoginFunction logfunction = new LoginFunction();

			logfunction.TestMethodLogin("deactivatereturn", "My@ccountPw0!");

			logfunction.BypassMfaClick();

			ChargeCancelledPage chargecancelobj = new ChargeCancelledPage();

			chargecancelobj.ChargeCancelledMethod();

			AxeCoreImplmnClass logaxecoreobj = new AxeCoreImplmnClass();

			logaxecoreobj.AxeCoreImplmnmethod(pageNameVariables.chargesuccesspage);

			GetExistingworkitemsPOSTAPI getworkitemobj = new GetExistingworkitemsPOSTAPI();

			getworkitemobj.ProcessADO(pageNameVariables.chargesuccesspage);

			GetDetailsPOSTAPI getDetailsobj = new GetDetailsPOSTAPI();

			getDetailsobj.GetDetails();

			CompareWorkItemsinADO compworkitems = new CompareWorkItemsinADO(pageNameVariables.chargesuccesspage);

			compworkitems.CompareMethod();

			myAccountredirection myAccredobj = new myAccountredirection();

			myAccredobj.myAccountredirectionMethod();

			System.out.println("Payment Info Page Execution has ended successfully");

		}

		catch (Throwable e) {
			e.printStackTrace();

		}

	}
}