package com.TaxSlayer.configPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;

import com.Accessibility.Utilities.ReadConfig;
import com.Accessibility.pageVariables.GetDetailsPOSTAPIvariables;

public class GetDetailsPOSTAPI {

	JSONObject WorkItemList;
	String targetelement;
	StringBuffer response;
	private static Integer WorkItemId;

	ReadConfig readconfig = new ReadConfig();

	public void GetDetails() throws IOException, JSONException {

		if (!GetExistingworkitemsPOSTAPI.IDlist.isEmpty()) {

			String AuthStr = ":" + readconfig.getPAT();

			Base64 base64 = new Base64();

			String encodedPAT = new String(base64.encode(AuthStr.getBytes()));

			for (int i = 0; i < GetExistingworkitemsPOSTAPI.IDlist.size(); i++) {

				WorkItemId = GetExistingworkitemsPOSTAPI.IDlist.get(i);

				URL url = new URL(readconfig.getServiceUrl() + readconfig.getTeamProjectName()
						+ readconfig.getUrlEndGetWorkItemById() + WorkItemId);

				HttpURLConnection con = (HttpURLConnection) url.openConnection();

				con.setRequestProperty("Authorization", "Basic " + encodedPAT);

				con.setRequestProperty("Content-Type", "application/json");

				con.setRequestMethod("GET");

				int status = con.getResponseCode(); // get response code of API

				if (status == 200) {

					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

					String inputLine;

					response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {

						response.append(inputLine);

					}

					in.close();

					con.disconnect();

					String responsestr = response.toString();

					JSONObject jsonObj = new JSONObject(responsestr);

					WorkItemList = jsonObj.getJSONObject("fields");

					targetelement = WorkItemList.getString("Custom.ElementTarget");

					GetDetailsPOSTAPIvariables.dbViolations.put(targetelement, WorkItemList);

				}
			}

		}

		else {

			System.out.println("No existing work item details can be retrieved");

		}

	}

}
