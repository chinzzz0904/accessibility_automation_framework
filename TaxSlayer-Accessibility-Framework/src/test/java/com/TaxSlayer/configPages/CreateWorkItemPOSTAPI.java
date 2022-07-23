package com.TaxSlayer.configPages;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;
import com.Accessibility.Utilities.ReadConfig;

public class CreateWorkItemPOSTAPI {

	private String jsonfromArray;

	ReadConfig readconfig = new ReadConfig();

	public CreateWorkItemPOSTAPI(String jsonfromArray) {

		this.jsonfromArray = jsonfromArray;

	}

	public void ProcessADO() throws IOException {

		String AuthStr = ":" + readconfig.getPAT();

		Base64 base64 = new Base64();

		String encodedPAT = new String(base64.encode(AuthStr.getBytes()));

		URL url = new URL(
				readconfig.getServiceUrl() + readconfig.getTeamProjectName() + readconfig.getUrlEndCreateTask());

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		con.setRequestProperty("Authorization", "Basic " + encodedPAT);

		con.setRequestProperty("Content-Type", "application/json-patch+json");

		con.setRequestMethod("POST");

		con.setDoOutput(true);

		OutputStream outStream = con.getOutputStream();

		OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");

		outStreamWriter.write(jsonfromArray);

		outStreamWriter.flush();

		outStreamWriter.close();

		int status = con.getResponseCode();

		String r;

		if (status == 200) {

			r = "Work Items has been created successfully";

			con.disconnect();

		} else {

			r = "Failed to create Work Items since POST API did not work properly" + status;

			con.disconnect();

		}

		System.out.println(r);

	}

}