package com.Accessibility.ReportGenMethods;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import com.opencsv.CSVWriter;

public class FrameworkMethods {


	public void writingMethodforCSVreport(List<String[]> data, String name) throws IOException {

		List<String[]> data1 = new ArrayList<String[]>();

		data1.add(new String[] { "Summary", "Project Name", "Description", "Issue Code", "Severity",
				"Remediation Guidance", "Reference(s)", "WCAG Success Criteria","Content-Type" });

		FileWriter outputgeneratedfile = new FileWriter("Report_Folder/" + name + ".csv");

		CSVWriter writer = new CSVWriter(outputgeneratedfile);

		writer.writeAll(data1);

		writer.writeAll(data);

		writer.close();

	}

	public String targetListMethod(JSONArray targetJSON) {

		String targetString1 = targetJSON.toString();

		String targetString2 = targetString1.replaceAll("\"", "").replace("\\", "").replace("/", "")
				.replaceAll("\\[", "").replaceAll("\\]", "");

		return targetString2;

	}

	public String FailureListMethod(String failureString) {

		String failureString1 = failureString.replaceAll("Fix any of the following:", "")
				.replaceAll("Fix all of the following:", "").replaceAll("(?m)^[ \t]*\r?\n", "");

		return failureString1;

	}

	public ArrayList<String> TagsListMethod(JSONArray tagsJSON) {

		ArrayList<String> Tagsarrays = new ArrayList<String>();

		for (int j = 0; j < tagsJSON.length(); j++) {

			String tagsObj = tagsJSON.getString(j);

			Tagsarrays.add(tagsObj);

		}
		return Tagsarrays;

	}

}
