package com.Accessibility.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() // constructor
	{
		File src = new File("./QAEnv_Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	// To read the values, we will create the method for every Variable

	public String getOperation() {
		String Operation = pro.getProperty("Operation");
		return Operation;
	}

	public String getAssignedTo() {
		String AssignedTo = pro.getProperty("AssignedTo");
		return AssignedTo;
	}

	public String getPathtitle() {
		String Pathtitle = pro.getProperty("Pathtitle");
		return Pathtitle;
	}

	public String getPathdescription() {
		String Pathdescription = pro.getProperty("Pathdescription");
		return Pathdescription;
	}

	public String getAssignedtopath() {
		String Assignedtopath = pro.getProperty("Assignedtopath");
		return Assignedtopath;
	}

	public String getPathpriority() {
		String Pathpriority = pro.getProperty("Pathpriority");
		return Pathpriority;
	}

	public String getpathScreens() {
		String pathScreens = pro.getProperty("pathScreens");
		return pathScreens;

	}

	public String getpathtargetElement() {
		String pathtargetElement = pro.getProperty("pathtargetElement");
		return pathtargetElement;

	}

	public String getServiceUrl() {
		String serviceUrl = pro.getProperty("ServiceUrl");
		return serviceUrl;
	}

	public String getTeamProjectName() {
		String teamProjectName = pro.getProperty("TeamProjectName");
		return teamProjectName;
	}

	public String getUrlEndCreateTask() {
		String urlEndCreateTask = pro.getProperty("UrlEndCreateTask");
		return urlEndCreateTask;
	}

	public String getPAT() {
		String PAT = pro.getProperty("PAT");
		return PAT;
	}

	public String getUrlEndRetrieveWorkItems() {
		String urlEndRetrieveWorkItems = pro.getProperty("UrlEndRetrieveWorkItems");
		return urlEndRetrieveWorkItems;
	}

	public String getReportType() {
		String reportType = pro.getProperty("ReportType");
		return reportType;
	}

	public String getType() {
		String type = pro.getProperty("type");
		return type;
	}

	public String getCommonQuery() {
		String type = pro.getProperty("commonquery");
		return type;
	}

	public String getUrlEndGetWorkItemById() {
		String UrlEndGetWorkItemById = pro.getProperty("UrlEndGetWorkItemById");
		return UrlEndGetWorkItemById;
	}

}
