package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {
	public static ExtentReports report;
	public static ExtentTest test;
	public void begin_report() {
		String timeFrame = new SimpleDateFormat("yyyyMMddhhss").format(new Date()); 
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./HTML Reports/Report_"+timeFrame+"_HTML.html");
		reporter.setAppendExisting(true);
		report = new ExtentReports();
		report.attachReporter(reporter);
	}
	
	public void create_report(String testName) {
		begin_report();
		test = report.createTest(testName);
		
	}
	
	public void add_to_report(String status, String description) {
		if(status.equalsIgnoreCase("pass")) {
			test.pass(description);				
		}else if(status.equalsIgnoreCase("fail")) {
			test.fail(description);
		}else if (status.equalsIgnoreCase("info")) {
			test.info(description);
		}
		
	}
	
	public void add_snapshot_to_report(String status, String description, String filepath) throws IOException {
		if(status.equalsIgnoreCase("pass")) {		
				test.log(Status.PASS, description,MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());						
		}else if(status.equalsIgnoreCase("fail")) {
			test.log(Status.FAIL, description,MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());
		}else if (status.equalsIgnoreCase("info")) {
			test.log(Status.INFO, description,MediaEntityBuilder.createScreenCaptureFromPath(filepath).build());
		}
		
		
	}
	
	/*
	 * public void add_snapshot(String path) throws IOException {
	 * test.addScreenCaptureFromPath(path); }
	 */
	public void end_report() {
		report.flush();
	}

}
