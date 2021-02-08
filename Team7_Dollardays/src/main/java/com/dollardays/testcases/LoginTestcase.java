package com.dollardays.testcases;

import java.util.Hashtable;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
//import com.dollardays.utilities.VideoRecorder_utlity;

public class LoginTestcase extends BaseTest{

	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Login",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void invokeLogin(Hashtable<String, String> datatable) throws Exception{
    //	VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.startTest("Login-" +datatable.get("TCID") + ":" + datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		Thread.sleep(1000);
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step1: Login into DollarDays.");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));		
   	//	VideoRecorder_utlity.stopRecord();//End point of video recording	
	}
}

