package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports generatereports () {
		
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter ("ProjectReport.html");
		ExtentReports reports = new ExtentReports ();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Suite", "Regression");
		reports.setSystemInfo("TestedBy", "Shubham");
		return reports;
	}

}
