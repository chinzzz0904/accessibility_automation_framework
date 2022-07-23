package com.TaxSlayer.configPages;

import com.Accessibility.staticVariables.axecorestaticVariables;

public class CSVReportGenerationLogic {

	private String helpFieldMod;
	private String descriptionField;
	private String projName = "TaxSlayer";
	int len = AxeCorePluginLogic.HTMLstringarray.length;
	private String wcagContent;
	private String contentType;

	public CSVReportGenerationLogic(String helpFieldMod, String descriptionField,String wcagContent,String contentType) {

		this.helpFieldMod = helpFieldMod;

		this.descriptionField = descriptionField;
		
		this.wcagContent = wcagContent;
		
		this.contentType = contentType;

	}

	public void ReportMethod(String name) {

		for (int m = 0; m < len; m++) {

			axecorestaticVariables.data
					.add(new String[] { helpFieldMod, projName + "-" + name, AxeCorePluginLogic.failureSummaryarray[m],
							AxeCorePluginLogic.HTMLstringarray[m], axecorestaticVariables.ImpactField, descriptionField,
							axecorestaticVariables.HelpUrl,wcagContent,contentType});

		}

	}

}
