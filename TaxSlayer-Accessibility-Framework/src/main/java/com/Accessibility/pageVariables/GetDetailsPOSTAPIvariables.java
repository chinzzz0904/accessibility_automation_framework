package com.Accessibility.pageVariables;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public interface GetDetailsPOSTAPIvariables {

	public ArrayList<String> keyIdentifierfromDBlist = new ArrayList<String>();
	public String keyIdentifierfromDB = "";
	public String[] keyIdentifierfromDBtotalarray = null;
	public static LinkedHashMap<String, JSONObject> dbViolations = new LinkedHashMap<String, JSONObject>();

}
