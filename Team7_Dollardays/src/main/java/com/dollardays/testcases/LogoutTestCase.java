package com.dollardays.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.LogoutPage;
import com.dollardays.pages.SubmitRequestPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;

public class LogoutTestCase  extends BaseTest{

	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Logout",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void invokeLogout(Hashtable<String, String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step1: Login into DollarDays.");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		
		// Creating Object of SubmitPage to access Web Elements of 'https://www.dollardays.com/case.aspx'
		LogoutPage logOutPage = new LogoutPage(driver);
			
		ExtentTestManager.getTest().log(Status.INFO, "Step2: Click on User Icon to open User Dropdown Toggle.");
		logOutPage.getUserDropdownToggle().click();
		
		
		
		VideoRecorder_utlity.stopRecord();//End point of video recording
		
	}
}
