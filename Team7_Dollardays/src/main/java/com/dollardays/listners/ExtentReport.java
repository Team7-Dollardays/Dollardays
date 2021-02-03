package com.dollardays.listners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewStyle;


public class ExtentReport {

	//private static ExtentReports extentReport;
	private static CustomExtentSparkReporter extentSparkReporter;
	public static ExtentTest test;
	
	public static String getCurrentDateAnTime(){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMMdd_hhmmss");
		String formattedate = formatter.format(date);
		return formattedate;
	}
	
	
	private static ExtentReports extent;
    private static String reportFileName = "Dollardays-Automaton-Report_"+getCurrentDateAnTime()+".html";
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
    	 
    	extentSparkReporter = new CustomExtentSparkReporter("reports",ViewStyle.DEFAULT);
    	extentSparkReporter.SetHtmlFileName(reportFileName);
		extentSparkReporter.config().setReportName("Dollar Days Report - Feb13");	
		extent = new ExtentReports();
		extent.attachReporter(extentSparkReporter);
		
		extent.setSystemInfo("Tester", "Shachi Bhagwat");
 
         return extent;
    }
     
  /*  //Create the report path
    private static String getReportPath (String path) {
    	File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }
 */

}
