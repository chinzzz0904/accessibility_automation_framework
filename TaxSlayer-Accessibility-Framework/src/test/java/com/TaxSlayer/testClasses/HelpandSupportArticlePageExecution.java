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
import com.TaxSlayer.applicationPages.HelpandSupportArticlePage;
import com.TaxSlayer.applicationPages.WelcomepageScreen;
import com.TaxSlayer.configPages.AxeCoreImplmnClass;
import com.TaxSlayer.configPages.CompareWorkItemsinADO;
import com.TaxSlayer.configPages.GetDetailsPOSTAPI;
import com.TaxSlayer.configPages.GetExistingworkitemsPOSTAPI;

public class HelpandSupportArticlePageExecution extends BaseClass {

	@Parameters({ "QAENVURL" })
	@Test
	public void HelpandSupportArticlePageMethod(String QAENVURL) throws InterruptedException, IOException

	{

		
		try {

			driver.get(QAENVURL);

			driver.manage().window().maximize();

//			WelcomepageScreen welcomepgobj = new WelcomepageScreen();

//			welcomepgobj.welcomepageTestmethod();

			ReadExcelLogin readobj = new ReadExcelLogin();

			ArrayList<String> creds = readobj.ReadExcelLoginMethod("federal Amended Sent");

			LoginFunction logfunction = new LoginFunction();

			logfunction.TestMethodLogin(creds.get(0), creds.get(1));

			logfunction.BypassMfaClick();

			HelpandSupportArticlePage helpandsuppartobj = new HelpandSupportArticlePage();

			helpandsuppartobj.HelpandSupportTaxMethod();

			AxeCoreImplmnClass logaxecoreobj = new AxeCoreImplmnClass();

			logaxecoreobj.AxeCoreImplmnmethod(pageNameVariables.helpandsuppartpage);

			GetExistingworkitemsPOSTAPI getworkitemobj = new GetExistingworkitemsPOSTAPI();

			getworkitemobj.ProcessADO(pageNameVariables.helpandsuppartpage);

			GetDetailsPOSTAPI getDetailsobj = new GetDetailsPOSTAPI();

			getDetailsobj.GetDetails();

			CompareWorkItemsinADO compworkitems = new CompareWorkItemsinADO(pageNameVariables.helpandsuppartpage);

			compworkitems.CompareMethod();

			myAccountredirection myAccredobj = new myAccountredirection();

			myAccredobj.myAccountredirectionMethod();

			System.out.println("Help and Support Execution has ended successfully");

		}

		catch (Throwable e) {
			e.printStackTrace();

		}

	}

}
