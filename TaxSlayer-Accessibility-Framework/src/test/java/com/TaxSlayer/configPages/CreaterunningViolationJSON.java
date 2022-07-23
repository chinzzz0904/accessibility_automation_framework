package com.TaxSlayer.configPages;

import java.io.IOException;
import java.util.ArrayList;
import com.Accessibility.Utilities.ReadConfig;
import com.Accessibility.commonClasses.ADOFieldPO;
import com.Accessibility.pageVariables.CreaterunningViolationsJSONvariables;
import com.Accessibility.pageVariables.pageNameVariables;
import com.Accessibility.staticVariables.axecorestaticVariables;

public class CreaterunningViolationJSON {

	public String helpFieldMod;
	public String descriptionField;
	int len = AxeCorePluginLogic.HTMLstringarray.length;

	ReadConfig readconfig = new ReadConfig();

	public CreaterunningViolationJSON(String helpFieldMod, String descriptionField) {

		this.helpFieldMod = helpFieldMod;

		this.descriptionField = descriptionField;

	}

	public void ADOMethod() throws InterruptedException, IOException {

		
		for (int m = 0; m < len; m++) {

			ADOFieldPO SetObj1 = new ADOFieldPO();

			ADOFieldPO SetObj2 = new ADOFieldPO();

			ADOFieldPO SetObj3 = new ADOFieldPO();

			ADOFieldPO SetObj4 = new ADOFieldPO();

			ADOFieldPO SetObj5 = new ADOFieldPO();

			ADOFieldPO SetObj6 = new ADOFieldPO();

			SetObj1.setOp(readconfig.getOperation());

			SetObj1.setPathTitle(readconfig.getPathtitle());

			SetObj1.setValueTitle(helpFieldMod);

			SetObj2.setOp(readconfig.getOperation());

			SetObj2.setPathDescription(readconfig.getPathdescription());

			SetObj2.setValueDescription(descriptionField);

			SetObj3.setOp(readconfig.getOperation());

			SetObj3.setPathAssignedTo(readconfig.getAssignedtopath());

			SetObj3.setValueAssignedTo(readconfig.getAssignedTo());

			SetObj4.setOp(readconfig.getOperation());

			SetObj4.setPathPriority(readconfig.getPathpriority());

			SetObj4.setValuePriority("3");

			SetObj5.setOp(readconfig.getOperation());

			SetObj5.setpathScreens(readconfig.getpathScreens());

			SetObj5.setValueScreens(pageNameVariables.loginpagename);

			SetObj6.setOp(readconfig.getOperation());

			SetObj6.setpathtarget(readconfig.getpathtargetElement());

			SetObj6.setvaluetarget(AxeCorePluginLogic.targetElementarray[m]);

			ArrayList<ADOFieldPO> Arrayobj = new ArrayList<ADOFieldPO>();

			Arrayobj.add(SetObj1);

			Arrayobj.add(SetObj2);

			Arrayobj.add(SetObj3);

			Arrayobj.add(SetObj4);

			Arrayobj.add(SetObj5);

			Arrayobj.add(SetObj6);

			axecorestaticVariables.runningViolations.put(AxeCorePluginLogic.targetElementarray[m], Arrayobj);

			CreaterunningViolationsJSONvariables.helpfieldmap.put(AxeCorePluginLogic.targetElementarray[m],
					helpFieldMod);

			CreaterunningViolationsJSONvariables.descriptionFieldmap.put(AxeCorePluginLogic.targetElementarray[m],
					descriptionField);

		}

	}

}
