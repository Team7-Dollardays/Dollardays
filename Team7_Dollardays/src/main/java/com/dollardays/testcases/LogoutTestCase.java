package com.dollardays.testcases;

import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
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
		String actualText = "";
		String expectedText = "";
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Step1: Login into DollarDays.");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		
		// Creating Object of SubmitPage to access Web Elements of 'https://www.dollardays.com/case.aspx'
		LogoutPage logoutPage = new LogoutPage(driver);
			
		ExtentTestManager.getTest().log(Status.INFO, "Step2: Click on User Icon to open User Dropdown Toggle.");
		logoutPage.getUserDropdownToggle().click();
		Thread.sleep(500);
		if(datatable.get("TCID").equals("TC1"))
		{
		ExtentTestManager.getTest().log(Status.INFO, "Step3: Click on logout link");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This  will scroll down the page by  1000 pixel vertical		
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(300);
		logoutPage.getSignOut().click();
		js.executeScript("window.scrollBy(0,0)");
		if(logoutPage.getsignIn() != null) {
			actualText = "Logged out from user toggle button.";
			expectedText = datatable.get("ExptectedResult").trim();
		}
			
		}else {
			ExtentTestManager.getTest().log(Status.INFO, "Step3: Click on Accounts link");
			logoutPage.getUserDropdownToggleAccountsLink().click();
			ExtentTestManager.getTest().log(Status.INFO, "Step3: Click on Log out link");
			logoutPage.getLogOut().click();
			Thread.sleep(300);
			if(logoutPage.getsignIn() != null) {
				actualText = "Logged out from Account web page.";
				expectedText = datatable.get("ExptectedResult").trim();
			}
		}
		
		try {
			System.out.println("Actual Text : " + actualText);
			System.out.println("Expected Text: " + expectedText);
			Assert.assertEquals(actualText, expectedText);
			ExtentTestManager.getTest().log(Status.PASS,"TestCase : "+ (datatable.get("TestCase")) + " executed successfully.");
			
		} catch (AssertionError e) {
			ExtentTestManager.getTest().log(Status.FAIL, " Actual and expected results mismatch");
			ExtentTestManager.getTest().log(Status.FAIL, "Error message: " + e.getMessage());
			Assert.assertEquals("true","false");
		}
		ExtentTestManager.getTest().log(Status.INFO, "Actual Result:" + actualText);
		ExtentTestManager.getTest().log(Status.INFO, "Expected Result:" + expectedText);
		
		
	}
}
