
package com.TaxSlayer.testClasses;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Accessibility.Utilities.ReadExcelLogin;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.commonClasses.LoginFunction;
import com.Accessibility.pageVariables.pageNameVariables;
import com.TaxSlayer.applicationPages.PoliciesLicenseAgreement;
import com.TaxSlayer.applicationPages.WelcomepageScreen;
import com.TaxSlayer.configPages.AxeCoreImplmnClass;
import com.TaxSlayer.configPages.CompareWorkItemsinADO;
import com.TaxSlayer.configPages.GetDetailsPOSTAPI;
import com.TaxSlayer.configPages.GetExistingworkitemsPOSTAPI;

public class PoliciesLicenseAgreementExecution extends BaseClass {

	@Parameters({ "QAENVURL" })
	@Test
	public void PoliciesLicenseAgreementExecutionMethod(String QAENVURL) throws InterruptedException, IOException

	{

		driver.get(QAENVURL);

		driver.manage().window().maximize();

		try {

			WelcomepageScreen welcomepgobj = new WelcomepageScreen();

			welcomepgobj.welcomepageTestmethod();

			ReadExcelLogin readobj = new ReadExcelLogin();

			ArrayList<String> creds = readobj.ReadExcelLoginMethod("basic My Account");

			LoginFunction logfunction = new LoginFunction();

			logfunction.TestMethodLogin(creds.get(0), creds.get(1));

			logfunction.BypassMfaClick();

			PoliciesLicenseAgreement pollicAgreementobj = new PoliciesLicenseAgreement();

			pollicAgreementobj.TestMethodLicenseAgreement();

			AxeCoreImplmnClass logaxecoreobj = new AxeCoreImplmnClass();

			logaxecoreobj.AxeCoreImplmnmethod(pageNameVariables.polLicenseName);

			GetExistingworkitemsPOSTAPI getworkitemobj = new GetExistingworkitemsPOSTAPI();

			getworkitemobj.ProcessADO(pageNameVariables.polLicenseName);

			GetDetailsPOSTAPI obj1 = new GetDetailsPOSTAPI();

			obj1.GetDetails();

			CompareWorkItemsinADO obj2 = new CompareWorkItemsinADO(pageNameVariables.polLicenseName);

			obj2.CompareMethod();

			System.out.println("License Agreement Execution has ended successfully");
		
		} catch (Throwable e) {
			e.printStackTrace();

		}

	}

}
