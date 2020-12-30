package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	static ExtentReports extent;
	public static ExtentReports  getReportObject() {
		
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reports=new ExtentSparkReporter(path);
		reports.config().setReportName("Web Automation Results");
		reports.config().setDocumentTitle("Test Results");
		
		 extent =new ExtentReports();
			extent.attachReporter(reports);
			extent.setSystemInfo("Tester", "Akshatha");
		return extent;
	}
}
