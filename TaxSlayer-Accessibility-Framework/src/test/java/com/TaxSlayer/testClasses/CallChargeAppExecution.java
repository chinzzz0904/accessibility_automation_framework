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
import com.TaxSlayer.applicationPages.CallChargeAppPage;
import com.TaxSlayer.configPages.AxeCoreImplmnClass;
import com.TaxSlayer.configPages.CompareWorkItemsinADO;
import com.TaxSlayer.configPages.GetDetailsPOSTAPI;
import com.TaxSlayer.configPages.GetExistingworkitemsPOSTAPI;

public class CallChargeAppExecution extends BaseClass {

//Need to ensure that the user should have atleast one Start A New Tax Return link in Prior Year Sections	
	
	@Parameters({ "QAENVURL" })
	@Test
	public void CallChargeAppMethod(String QAENVURL) throws InterruptedException, IOException

	{

		try {

			driver.get(QAENVURL);

			driver.manage().window().maximize();

//			WelcomepageScreen welcomepgobj = new WelcomepageScreen();

//			welcomepgobj.welcomepageTestmethod();

			ReadExcelLogin readobj = new ReadExcelLogin();

			ArrayList<String> creds = readobj.ReadExcelLoginMethod("deactivate Return");

			LoginFunction logfunction = new LoginFunction();

			logfunction.TestMethodLogin(creds.get(0), creds.get(1));

			logfunction.BypassMfaClick();

			CallChargeAppPage callchargeappobj = new CallChargeAppPage();

			callchargeappobj.CallChargeAppMethod();

			AxeCoreImplmnClass logaxecoreobj = new AxeCoreImplmnClass();

			logaxecoreobj.AxeCoreImplmnmethod(pageNameVariables.callchargeapppage);

			GetExistingworkitemsPOSTAPI getworkitemobj = new GetExistingworkitemsPOSTAPI();

			getworkitemobj.ProcessADO(pageNameVariables.callchargeapppage);

			GetDetailsPOSTAPI getDetailsobj = new GetDetailsPOSTAPI();

			getDetailsobj.GetDetails();

			CompareWorkItemsinADO compworkitems = new CompareWorkItemsinADO(pageNameVariables.callchargeapppage);

			compworkitems.CompareMethod();

			myAccountredirection myAccredobj = new myAccountredirection();

			myAccredobj.myAccountredirectionMethod();

			System.out.println("Call Charge App Page Execution has ended successfully");

		}

		catch (Throwable e) {
			e.printStackTrace();

		}
	}

}