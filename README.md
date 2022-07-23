# Introduction 
This project is built to automate Accessibility test cases using Selenium with axe-core framework for TaxSlayer MyAccount project
# Getting Started
1.  Installation process:
Steps for Java installation:
a. Download Java using link: https://jdk.java.net/17/ and download for Windows/x64
b. Create environment variable as JAVA_HOME with the location where you have downloaded Java (e.g. in windows JAVA_HOME= C:\Program Files\Java\jdk1.8.0_92)
c. Add %JAVA_HOME%\bin into Path variable 
Steps for Maven installation:
a. download Maven using link:  https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.zip
b. Unzip downloaded files at appropriate location (e.g. C:\softwares\apache-maven-3.8.5 )
c. Create environment variable as MAVEN_HOME with the location where you unzipped the downloaded files (e.g. in windows MAVEN_HOME= C:\softwares\apache-maven-3.8.5)
d. Add %MAVEN_HOME%\bin into Path variable 

2.  Other dependencies: Application uses below dependencies internally
    Java (version jdk 1.8.0_92)
    Maven (version 3.8.4)
	Axe-Core (version 4.3.0)
    Surefire plugin to configure and execute the tests along with facilitating report generation
# Run Test Cases
To run the testcases on QA environment, run below command 
    mvn test 
# Test cases result
Once all testcases gets execute, report will get generated into below directory
.\qa-ui-accessibility-automation\TaxSlayer-Accessibility-Framework\Report_Folder