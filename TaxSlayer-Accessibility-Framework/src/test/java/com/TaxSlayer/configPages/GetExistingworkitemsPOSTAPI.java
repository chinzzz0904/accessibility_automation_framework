package com.TaxSlayer.configPages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import com.Accessibility.Utilities.ReadConfig;

import net.minidev.json.JSONValue;

public class GetExistingworkitemsPOSTAPI {

	String r;

	public static ArrayList<Integer> IDlist = new ArrayList<Integer>();

	ReadConfig readconfig = new ReadConfig();

	HashMap<String, String> map = new HashMap<String, String>();

	String jsonStr;

	public void ProcessADO(String pageName) throws IOException {

		String AuthStr = ":" + readconfig.getPAT();

		Base64 base64 = new Base64();

		String encodedPAT = new String(base64.encode(AuthStr.getBytes()));

		URL url = new URL(
				readconfig.getServiceUrl() + readconfig.getTeamProjectName() + readconfig.getUrlEndRetrieveWorkItems());

		String querydata = readconfig.getCommonQuery() + "AND [Custom.ImpactedScreenName] = '" + pageName + "'";

		map.put(readconfig.getType(), querydata);

		jsonStr = JSONValue.toJSONString(map);

//		System.out.println(jsonStr);

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestProperty("Authorization", "Basic " + encodedPAT);

		con.setRequestProperty("Content-Type", "application/json; charset=utf-8; api-version=6.0");

		con.setRequestMethod("POST");

		con.setDoOutput(true);

		OutputStream outStream = con.getOutputStream();

		OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");

		outStreamWriter.write(jsonStr);

		outStreamWriter.flush();

		outStreamWriter.close();

		int status = con.getResponseCode();

		if (status == 200) {

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;

			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {

				response.append(inputLine);

			}

			in.close();

			String responsestr = response.toString();

			JSONObject jsonObj = new JSONObject(responsestr);

			JSONArray WorkItemList = jsonObj.getJSONArray("workItems");

			if (!WorkItemList.isEmpty()) {

				r = "Work Items can be retrived successfully";

				for (int j = 0; j < WorkItemList.length(); j++) {

					JSONObject jsonObj1 = WorkItemList.getJSONObject(j);

					int IDs = jsonObj1.getInt("id");

					IDlist.add(IDs);

				}
			} else {

				r = "No existing Work Items are present";

			}

			con.disconnect();

		} else {

			r = "Failed to retrieve Work Items due to POST API error" + status;

			con.disconnect();

		}

		System.out.println(r);

	}

}