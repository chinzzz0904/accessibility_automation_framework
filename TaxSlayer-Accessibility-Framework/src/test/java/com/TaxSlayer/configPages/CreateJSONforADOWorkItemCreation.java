package com.TaxSlayer.configPages;

import java.io.IOException;
import java.util.ArrayList;
import com.Accessibility.Utilities.ReadConfig;
import com.Accessibility.commonClasses.ADOFieldPO;
import com.Accessibility.pageVariables.CreaterunningViolationsJSONvariables;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CreateJSONforADOWorkItemCreation {

	public static String jsonfromArray;

	ReadConfig readconfig = new ReadConfig();

	public void ProcessADO(ArrayList<String> remElements, String pagename) throws IOException {

		int len = remElements.size();

		for (int m = 0; m < len; m++) {

			Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

			ADOFieldPO SetObj1 = new ADOFieldPO();

			ADOFieldPO SetObj2 = new ADOFieldPO();

			ADOFieldPO SetObj3 = new ADOFieldPO();

			ADOFieldPO SetObj4 = new ADOFieldPO();

			ADOFieldPO SetObj5 = new ADOFieldPO();

			ADOFieldPO SetObj6 = new ADOFieldPO();

			SetObj1.setOp(readconfig.getOperation());

			SetObj1.setPathTitle(readconfig.getPathtitle());

			SetObj1.setValueTitle(CreaterunningViolationsJSONvariables.helpfieldmap.get(remElements.get(m)));

			SetObj2.setOp(readconfig.getOperation());

			SetObj2.setPathDescription(readconfig.getPathdescription());

			SetObj2.setValueDescription(
					CreaterunningViolationsJSONvariables.descriptionFieldmap.get(remElements.get(m)));

			SetObj3.setOp(readconfig.getOperation());

			SetObj3.setPathAssignedTo(readconfig.getAssignedtopath());

			SetObj3.setValueAssignedTo(readconfig.getAssignedTo());

			SetObj4.setOp(readconfig.getOperation());

			SetObj4.setPathPriority(readconfig.getPathpriority());

			SetObj4.setValuePriority("3");

			SetObj5.setOp(readconfig.getOperation());

			SetObj5.setpathScreens(readconfig.getpathScreens());

			SetObj5.setValueScreens(pagename);

			SetObj6.setOp(readconfig.getOperation());

			SetObj6.setpathtarget(readconfig.getpathtargetElement());

			SetObj6.setvaluetarget(remElements.get(m));

			ArrayList<ADOFieldPO> Arrayobj1 = new ArrayList<ADOFieldPO>();

			Arrayobj1.add(SetObj1);

			Arrayobj1.add(SetObj2);

			Arrayobj1.add(SetObj3);

			Arrayobj1.add(SetObj4);

			Arrayobj1.add(SetObj5);

			Arrayobj1.add(SetObj6);

			jsonfromArray = gson.toJson(Arrayobj1);

			CreateWorkItemPOSTAPI obj = new CreateWorkItemPOSTAPI(jsonfromArray);

			obj.ProcessADO();

		}

	}

}
