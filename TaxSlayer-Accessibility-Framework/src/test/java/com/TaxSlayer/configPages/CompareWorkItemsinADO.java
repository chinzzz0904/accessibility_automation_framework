package com.TaxSlayer.configPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONObject;
import com.Accessibility.commonClasses.ADOFieldPO;
import com.Accessibility.pageVariables.GetDetailsPOSTAPIvariables;
import com.Accessibility.staticVariables.axecorestaticVariables;

public class CompareWorkItemsinADO {

	private LinkedHashMap<String, ArrayList<ADOFieldPO>> runningViolations;
	private LinkedHashMap<String, JSONObject> dbViolations;
	ArrayList<String> remElements = new ArrayList<String>();
	public String pagename;

	public CompareWorkItemsinADO(String mobsettingsname) {

		this.pagename = mobsettingsname;

	}

	public void CompareMethod() throws IOException {

		runningViolations = axecorestaticVariables.runningViolations;

		dbViolations = GetDetailsPOSTAPIvariables.dbViolations;

		for (String string : runningViolations.keySet()) {

			if (!dbViolations.containsKey(string)) {

				System.out.println("One Work item needs to be created");

				remElements.add(string);

			}

			else {

				System.out.println("This Work item already exists");

			}
		}

		CreateJSONforADOWorkItemCreation createjsonobj = new CreateJSONforADOWorkItemCreation();

		createjsonobj.ProcessADO(remElements, pagename);

	}

}
