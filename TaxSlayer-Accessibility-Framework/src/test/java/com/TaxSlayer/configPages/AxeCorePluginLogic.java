package com.TaxSlayer.configPages;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Accessibility.ReportGenMethods.ADOWorkItemReportingMethods;
import com.Accessibility.ReportGenMethods.FrameworkMethods;
import com.Accessibility.Utilities.ReadConfig;
import com.Accessibility.Utilities.ReadWCAGExcel;
import com.Accessibility.commonClasses.BaseClass;
import com.Accessibility.pageVariables.axecoreVariables;
import com.Accessibility.staticVariables.axecorestaticVariables;
import com.deque.axe.AXE;

public class AxeCorePluginLogic extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 10);

	final URL scriptURL = AxeCorePluginLogic.class.getResource("/axe.min.js");

	ReadConfig readconfig = new ReadConfig();

	public static String[] targetElementarray;

	public static String[] HTMLstringarray;

	public static String[] failureSummaryarray;

	public void AxeCoreLogicImplmnMethod(String Name) throws InterruptedException, IOException {

		if (axecoreVariables.isEnabled) {

			System.out.println("Accesssibility testing has been started");

		} else {

			System.out.println("Accesssibility testing has been disabled");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JSONObject responseJson = new AXE.Builder(driver, scriptURL).analyze();

		JSONArray violations = responseJson.getJSONArray("violations");

		String failureSummaryStringtotal = "";

		String targetElementstringtotal = "";

		String HTMLstringtotal = "";

		String DescriptionField;

		JSONArray TagsList = null;

		String HelpField = null;

		String HelpFieldMod;

		String failureSummary = null;

		String failureSummaryString = null;

		String HTMLstring = null;

		JSONArray targetElementjson = null;

		String targetElementstring = null;

		if (violations.length() == 0) {

			System.out.println("No errors found");

		}

		else {

			for (int i = 0; i < violations.length(); i++) {

				JSONObject violationobj = violations.getJSONObject(i);

				TagsList = violationobj.getJSONArray("tags");

				FrameworkMethods fm5 = new FrameworkMethods();

				axecorestaticVariables.tagsArrayList = fm5.TagsListMethod(TagsList);

				String[] TagsJson = new String[axecorestaticVariables.tagsArrayList.size()];

				axecorestaticVariables.tagsArrayList.toArray(TagsJson);

				// Logic for Help Key value

				HelpField = violationobj.getString("help");

				HelpFieldMod = HelpField.replaceAll("<html>", "HTML");

				// Logic for Nodes Key value

				JSONArray nodes = violationobj.getJSONArray("nodes");

				for (int k = 0; k < nodes.length(); k++) {

					JSONObject nodesobj = nodes.getJSONObject(k);

					if (axecorestaticVariables.tagsArrayList.contains("wcag2a")
							|| axecorestaticVariables.tagsArrayList.contains("wcag2aa")) {

						// Logic for failureSummary Key

						failureSummary = nodesobj.getString("failureSummary");

						FrameworkMethods fm4 = new FrameworkMethods();

						failureSummaryString = fm4.FailureListMethod(failureSummary);

						failureSummaryStringtotal = failureSummaryStringtotal.concat(failureSummaryString) + "\n\n";

						failureSummaryarray = failureSummaryStringtotal.split("\n\n");

						// Logic for HTML Key value

						HTMLstring = nodesobj.getString("html");

						HTMLstringtotal = HTMLstringtotal.concat(HTMLstring) + "\n\n";

						HTMLstringarray = HTMLstringtotal.split("\n\n");

						// Logic for Target Element

						targetElementjson = nodesobj.getJSONArray("target");

						FrameworkMethods fm3 = new FrameworkMethods();

						targetElementstring = fm3.targetListMethod(targetElementjson);

						targetElementstringtotal = targetElementstringtotal.concat(targetElementstring) + "\n\n";

						targetElementarray = targetElementstringtotal.split("\n\n");

						ArrayList<String> tagsArrayList1 = new ArrayList<String>();

						for (int p = 0; p < axecorestaticVariables.tagsArrayList.size(); p++) {

							if (axecorestaticVariables.tagsArrayList.get(p).startsWith("wcag")
									&& !(axecorestaticVariables.tagsArrayList.get(p).endsWith("2a"))) {

								tagsArrayList1.add(axecorestaticVariables.tagsArrayList.get(p));

							}

						}

						ReadWCAGExcel obj = new ReadWCAGExcel();

						ArrayList<String> wcagContentArray = obj.ReadExcelMethod(tagsArrayList1);

						// Logic for Impact key value

						axecorestaticVariables.ImpactField = violationobj.getString("impact");

						// Logic for Description key value

						DescriptionField = violationobj.getString("description");

						// Logic for HelpUrl Key value

						axecorestaticVariables.HelpUrl = violationobj.getString("helpUrl");

						// Logic to filter out the data according to tags

						if (axecorestaticVariables.tagsArrayList.contains("wcag2a")
								|| axecorestaticVariables.tagsArrayList.contains("wcag2aa")) {

							CSVReportGenerationLogic csvreportgenobj = new CSVReportGenerationLogic(HelpFieldMod,
									DescriptionField, wcagContentArray.get(0) ,wcagContentArray.get(1));

							csvreportgenobj.ReportMethod(Name);

							if (readconfig.getReportType().equals("ADO") || readconfig.getReportType().equals("BOTH")) {

								CreaterunningViolationJSON obj2 = new CreaterunningViolationJSON(HelpFieldMod,
										DescriptionField);

								obj2.ADOMethod();

							}

							else {

								System.out.println("Incorrect Report Type");

							}

						}

						else {

							continue;
						}

						failureSummaryStringtotal = "";

						HTMLstringtotal = "";

						targetElementstringtotal = "";

					}

					if (readconfig.getReportType().equals("CSV") || readconfig.getReportType().equals("BOTH")) {

						ADOWorkItemReportingMethods obj = new ADOWorkItemReportingMethods();

						obj.ADOCSVfileReportgeneration(Name);

					} else {

						System.out.println("Incorrect Report Type");
					}

				}

			}

		}

	}

}