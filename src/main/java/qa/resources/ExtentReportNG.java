package qa.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static  ExtentReports getReportObjectt() {
		//ExtentReports, ExtentSparkReports
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Har Har Mahandeva");
		reporter.config().setDocumentTitle("Jai Bolenath");
		ExtentReports extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Mahadeva");
	return extent;
		
		
	}

}
