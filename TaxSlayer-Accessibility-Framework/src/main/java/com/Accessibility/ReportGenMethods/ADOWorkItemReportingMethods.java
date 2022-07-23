package com.Accessibility.ReportGenMethods;

import java.io.IOException;
import com.Accessibility.staticVariables.axecorestaticVariables;

public class ADOWorkItemReportingMethods {

	public void ADOCSVfileReportgeneration(String Name) throws IOException {

		System.out.println("Option works for ADO and BOTH choices");

		FrameworkMethods fm1 = new FrameworkMethods();

		fm1.writingMethodforCSVreport(axecorestaticVariables.data, Name);

	}

}
