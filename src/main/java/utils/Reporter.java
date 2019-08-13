package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public abstract  class Reporter  {
	
	public static ExtentReports report;
	public  ExtentTest test;
	public String testCaseName,testCaseDescription,category;
	
	public ExtentReports startReport() {
		report=new ExtentReports("./reports/report.html",false);
		return report;
	}
	public ExtentTest startTestCase(String testCaseName,String testCaseDescription)
	{
		test=report.startTest(testCaseName,testCaseDescription);
		return test;
	}
	public void reportStep(String status,String Description) {
		long snapNumber=10000001;
		try {
			snapNumber=takeSnap();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(status.toUpperCase().equals("PASS")) {
			test.log(LogStatus.PASS,Description+test.addScreenCapture("../../reports/images/"+snapNumber+".png"));
		}
		else if(status.toUpperCase().equals("FAILS")) {
			test.log(LogStatus.FAIL,Description+test.addScreenCapture("../../reports/images/"+snapNumber+".png"));
		}
		else if(status.toUpperCase().equals("SKIP")) {
			test.log(LogStatus.SKIP,Description+test.addScreenCapture("../../reports/images/"+snapNumber+".png"));
		}
	}
public void endTestCase()
{
	report.endTest(test);
}
public void endReport()
{
	report.flush();
}
public abstract long takeSnap();

}



