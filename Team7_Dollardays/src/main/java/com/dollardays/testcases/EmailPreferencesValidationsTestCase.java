package com.dollardays.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
import com.dollardays.pages.MyProfilePage;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

public class EmailPreferencesValidationsTestCase extends BaseTest {
	// private static final String EXCEL_OUTPUT_FILEPATH =
	// ".\\Results\\MyAccount-1-Reports.xlsx";
	private static MyProfilePage MyProfilePage = null;
	String ExpectedValue = null, ActualValue = null, Actual_Title = null, Expected_Title = null;
	boolean A1;
	String sheet = "EmailPreferences";

	// private Logger logger =
	// LoggerFactory.getLogger(EmailPreferencesValidations.class);

	private JavascriptExecutor js = null;

	@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "EmailPreferences", testcaseID = "TC1", runmode = "Yes")
	@Test(priority = 1, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void emailPreferences_UserEmailAddressValidation(Hashtable<String, String> datatable)
			throws IOException, InterruptedException, GeneralSecurityException {
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		MyProfilePage = new MyProfilePage(driver);
		// The Below code will navigate you to My Profile page
		MyProfilePage.click_User_Dropdown_Toggle();
		Thread.sleep(2000);
		MyProfilePage.click_User_Dropdown_Toggle_Accounts();
		Thread.sleep(2000);
		MyProfilePage.click_profileLink();
		js = (JavascriptExecutor) driver;
		String ActualUserName = MyProfilePage.Email_Username.getText();
		js.executeScript("window.scrollBy(0,1000)");

		// System.out.println(ActualUserName);
		String ExpectedUserName = datatable.get("ExpectedValue");

		// System.out.println(ExpectedUserName);
		try {
			Assert.assertEquals(ActualUserName, ExpectedUserName);
			// System.out.println("Assertion Pass");

			/*
			 * logger.info(
			 * "Test1 : The displayed email address is matching with the actual UserName/Emailaddress..As Expected"
			 * );
			 */
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 3, 0, sheet, "Test1");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 3, 1, sheet,
			 * " The displayed email address is matching with the actual UserName/Emailaddress."
			 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 3, 2, sheet, "PASS");
			 * CommonUtilities.captureScreenShot(BaseTest.driver,
			 * "Test1_UserEmailAddressValidation", "EmailPreferencesValidations");
			 */
			ExtentTestManager.getTest().log(Status.PASS,
					"Test1 : The displayed email address is matching with the actual UserName/Emailaddress..As Expected");

		} catch (AssertionError e) {
			// System.out.println("Assertion Fail :"+ e);
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 3, 0, sheet, "Test 1");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 3, 1, sheet,
			 * "The displayed email address is not matching with the actual Username/Emailaddress"
			 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 3, 2, sheet, "FAIL");
			 * /*logger.debug(
			 * "Test 1 :The displayed email address is not matching with the actual Username/Emailaddress..Not as Expected"
			 * ); logger.debug("Error Message  :" + e.getMessage()); //
			 * System.out.println("The displayed email address is not matching with the //
			 * actual Username/Emailaddress..Not as Expected");
			 */
			ExtentTestManager.getTest().log(Status.FAIL,
					"Test 1 :The displayed email address is not matching with the actual Username/Emailaddress..Not as Expected");
		}
		// logger.info("Test#1 Finish");

		MyProfilePage.click_User_Dropdown_Toggle();
		MyProfilePage.click_User_Dropdown_Toggle_Signout();
		ExtentTestManager.getTest().log(Status.INFO, "LoggedOut Succesfully from TC1");
	}

	@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "EmailPreferences", testcaseID = "TC2", runmode = "Yes")
	@Test(priority = 2, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void emailPreferences_Checkbox_Validation_AtPageLaunch(Hashtable<String, String> datatable)
			throws IOException, InterruptedException, GeneralSecurityException {
		// JavascriptExecutor js = (JavascriptExecutor)BaseTest.driver;
		// MyProfilePage= new MyProfilePage(BaseTest.driver);
		// js.executeScript("window.scrollBy(0,1000)");
		// logger.info("Test 2: WIndow scrolled by 1000 pixels vertically");

		// CommonUtilities.captureScreenShot(BaseTest.driver,
		// "Test2_emailPreferences_CheckBox_Verification_AtPageLaunch",
		// "EmailPreferencesValidations");
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		MyProfilePage = new MyProfilePage(driver);
		// The Below code will navigate you to My Profile page
		MyProfilePage.click_User_Dropdown_Toggle();
		Thread.sleep(2000);
		MyProfilePage.click_User_Dropdown_Toggle_Accounts();
		Thread.sleep(2000);
		MyProfilePage.click_profileLink();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		boolean A1 = Boolean.parseBoolean(datatable.get("ExpectedValue"));

		try {
			Assert.assertEquals(MyProfilePage.NewsLetter_CheckBox.isSelected(), A1);
			/*
			 * logger.info(
			 * "Test 2 :NewsLetter Subscription Check Box is Prechecked at the time of First page Launch as Expected"
			 * );
			 */
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 4, 0, sheet, "Test 2 ");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 4, 1, sheet,
			 * "NewsLetter Subscription Check Box is Prechecked at the time of First page Launch"
			 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 4, 2, sheet, "PASS");
			 */
			ExtentTestManager.getTest().log(Status.PASS,
					"Test 2 :NewsLetter Subscription Check Box is Prechecked at the time of First page Launch as Expected");
		} catch (AssertionError e) {
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 4, 0, sheet, "Test 2");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 4, 1, sheet,
			 * "NewsLetter Subscription Check Box is Not Prechecked at the time of First page Launch"
			 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 4, 2, sheet, "FAIL");
			 * logger.debug(
			 * "Test 2 :NewsLetter Subscription Check Box is Not Prechecked at the time of First page Launch.Not as Expected"
			 * ); logger.debug("Error Message  :" + e.getMessage());
			 */
			ExtentTestManager.getTest().log(Status.FAIL,
					"Test 2 :NewsLetter Subscription Check Box is Not Prechecked at the time of First page Launch.Not as Expected");
		}
		// logger.info("Test#2 Finish");
		MyProfilePage.click_User_Dropdown_Toggle();
		MyProfilePage.click_User_Dropdown_Toggle_Signout();
		ExtentTestManager.getTest().log(Status.INFO, "LoggedOut Succesfully from TC2");

	}

	@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "EmailPreferences", testcaseID = "TC3", runmode = "Yes")
	@Test(priority = 3, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void emailPreferences_checkbox_validation_AtClick(Hashtable<String, String> datatable)
			throws InterruptedException, IOException, GeneralSecurityException {
		// JavascriptExecutor js = (JavascriptExecutor)BaseTest.driver;
		// MyProfilePage= new MyProfilePage(BaseTest.driver);
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		MyProfilePage = new MyProfilePage(driver);
		// The Below code will navigate you to My Profile page
		MyProfilePage.click_User_Dropdown_Toggle();
		Thread.sleep(2000);
		MyProfilePage.click_User_Dropdown_Toggle_Accounts();
		Thread.sleep(2000);
		MyProfilePage.click_profileLink();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

		// logger.info("Test 3: WIndow scrolled by 1000 pixels vertically");
		if (MyProfilePage.NewsLetter_CheckBox.isSelected()) {

			MyProfilePage.click_NewsLetter_CheckBox();
			// logger.info("Test 3 :Unchecked the checkbox");
			MyProfilePage.click_EmailPreferences_SaveChanges();
			// logger.info("Test 3 :Clicked save changes button");
			MyProfilePage.click_User_Dropdown_Toggle();
			// logger.info("Test 3 :Clicked User toggle");
			Thread.sleep(2000);
			MyProfilePage.click_User_Dropdown_Toggle_Signout();
			// logger.info("Test 3 :Clicked singout");
			Thread.sleep(2000);
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			// logger.info("Test 3 :Called Signin method and logged back in");

			MyProfilePage.click_User_Dropdown_Toggle();

			// logger.info("Test 3: User Toggle clicked");
			Thread.sleep(2000);
			MyProfilePage.click_User_Dropdown_Toggle_Accounts();
			// logger.info("Test 3: Accounts link clicked");
			Thread.sleep(2000);
			MyProfilePage.click_profileLink();
			// logger.info("Test 3: My Profile link clicked");
			js.executeScript("window.scrollBy(0,1000)");
			// logger.info("Test 3: WIndow scrolled by 1000 pixels vertically");
			/*
			 * CommonUtilities.captureScreenShot(BaseTest.driver,
			 * "Test3_emailPreferences_CheckBox_Verification_AtClick",
			 * "EmailPreferencesValidations");
			 */
			try {
				A1 = Boolean.parseBoolean(datatable.get("ExpectedValue"));
				Assert.assertEquals(MyProfilePage.NewsLetter_CheckBox.isSelected(), A1);
				/*
				 * logger.info(
				 * "Test 3 :Once unchecked the Newsletter subscription checkbox remains unchanged until further changes to it:As Expected"
				 * );
				 */
				/*
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 5, 0, sheet, "Test 3 ");
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 5, 1, sheet,
				 * "Once unchecked the Newsletter subscription checkbox remains unchanged until further changes to it"
				 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 5, 2, sheet, "PASS");
				 */
				ExtentTestManager.getTest().log(Status.PASS,
						"Test 3 :Once unchecked the Newsletter subscription checkbox remains unchanged until further changes to it:As Expected");
			} catch (AssertionError e) {
				/*
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 5, 0, sheet, "Test 3 ");
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 5, 1, sheet,
				 * "The changes to the Newsletter checkbox is not remaining unchanged");
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 5, 2, sheet, "FAIL");
				 */
				/*
				 * logger.debug(
				 * "Test 3 :The changes to the Newsletter checkbox is not remaining unchanged:Not as expected"
				 * ); logger.debug("Error Message  :" + e.getMessage());
				 */
				ExtentTestManager.getTest().log(Status.FAIL,
						"Test 3 :The changes to the Newsletter checkbox is not remaining unchanged:Not as expected");
			}
		}

		MyProfilePage.click_NewsLetter_CheckBox();
		js.executeScript("window.scrollBy(0,500)");
		MyProfilePage.click_EmailPreferences_SaveChanges();
		MyProfilePage.click_User_Dropdown_Toggle();
		MyProfilePage.click_User_Dropdown_Toggle_Signout();
		ExtentTestManager.getTest().log(Status.INFO, "LoggedOut Succesfully from TC3");
		// logger.info("Test#3 Finish");

	}

	@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "EmailPreferences", testcaseID = "TC4", runmode = "Yes")
	@Test(priority = 4, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void EmailPreferences_LinksValidation(Hashtable<String, String> datatable)
			throws IOException, InterruptedException, GeneralSecurityException {

		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		MyProfilePage = new MyProfilePage(driver);
		// The Below code will navigate you to My Profile page
		MyProfilePage.click_User_Dropdown_Toggle();
		Thread.sleep(2000);
		MyProfilePage.click_User_Dropdown_Toggle_Accounts();
		Thread.sleep(2000);
		MyProfilePage.click_profileLink();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,6000)");
		// logger.info("Test 4: WIndow scrolled by 6000 pixels vertically");
		MyProfilePage.click_MyAccountTermsandConditions();
		// logger.info("Test 4: Terms and Conditions link clicked");
		// String Expected_Title = "Policies - DollarDays";
		Expected_Title = datatable.get("ExpectedValue");
		String Actual_Title = driver.getTitle();
		/*
		 * CommonUtilities.captureScreenShot(BaseTest.driver,
		 * "Test4_emailPreferences_TermsandConditionsLink_Validation_AtClick",
		 * "EmailPreferencesValidations");
		 */
		try {
			Assert.assertEquals(Actual_Title, Expected_Title);
			// System.out.println("Assertion Pass");
			// logger.info("Test 4 :Terms and Conditions link is directing to
			// 'Policies-DollarDays' page..As Expected");
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 6, 0, sheet, "Test 4 ");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 6, 1, sheet,
			 * "Terms and Conditions link is directing to 'Policies-DollarDays' page");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 6, 2, sheet, "PASS");
			 */
			ExtentTestManager.getTest().log(Status.PASS,
					"Test 4 :Terms and Conditions link is directing to 'Policies-DollarDays' page..As Expected");
		} catch (AssertionError e) {
			// System.out.println("Assertion Fail :"+ e);
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 6, 0, sheet, "Test 4");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 6, 1, sheet,
			 * "Terms and Conditions link is Not directing to 'Policies-DollarDays'page");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 6, 2, sheet, "FAIL");
			 */
			/*
			 * logger.debug(
			 * "Test 4:Terms and Conditions link is Not directing to 'Policies-DollarDays' page..Not as Expected"
			 * ); logger.debug("Error Message  : " + e.getMessage());
			 */
			ExtentTestManager.getTest().log(Status.FAIL,
					"Test 4:Terms and Conditions link is Not directing to 'Policies-DollarDays' page..Not as Expected");
		}

		driver.navigate().back();
		// logger.info("Test 4 :Navigated back to My profile page");
		js.executeScript("window.scrollBy(0,1000)");
		// logger.info("Test 4: WIndow scrolled by 1000 pixels vertically");
		MyProfilePage.click_PrivacyandSecurityStatement();
		// logger.info("Test 4: PrivacyandSecurityStatement link clicked");
		Actual_Title = driver.getTitle();
		Expected_Title = datatable.get("ExpectedValue");
		;
		/*
		 * CommonUtilities.captureScreenShot(BaseTest.driver,
		 * "Test4_emailPreferences_PrivacyandSecurityStatementLink_Validation_AtClick",
		 * "EmailPreferencesValidations");
		 */
		try {
			Assert.assertEquals(Actual_Title, Expected_Title);
			// System.out.println("Assertion Pass");
			/*
			 * logger.info(
			 * "Test 4:Privacy & Security Statement link is directing you to 'Policies-DollarDays'Page..As Expected"
			 * );
			 */
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 7, 0, sheet, "Test 4");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 7, 1, sheet,
			 * "Privacy & Security Statement link is directing you to 'Policies-DollarDays' Page"
			 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 7, 2, sheet, "PASS");
			 */
			ExtentTestManager.getTest().log(Status.PASS,
					"Test 4:Privacy & Security Statement link is directing you to 'Policies-DollarDays'Page..As Expected");
		} catch (AssertionError e) {
			// System.out.println("Assertion Fail :"+ e);
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 7, 0, sheet, "Test 4");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 7, 1, sheet,
			 * "Privacy & Security Statement link is Not directing to 'Policies-DollarDays' Page"
			 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 7, 2, sheet, "FAIL");
			 */
			/*
			 * logger.debug(
			 * "Test 4:Privacy & Security Statement link is Not directing to 'Policies-DollarDays'Page..Not as Expected"
			 * ); logger.debug("Error Message  : " + e.getMessage());
			 */
			ExtentTestManager.getTest().log(Status.FAIL,
					"Test 4:Privacy & Security Statement link is Not directing to 'Policies-DollarDays'Page..Not as Expected");
		}

		// logger.info("Test#4 Finish");
		MyProfilePage.click_User_Dropdown_Toggle();
		MyProfilePage.click_User_Dropdown_Toggle_Signout();
		ExtentTestManager.getTest().log(Status.INFO, "LoggedOut Succesfully from TC4");

	}

	@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "EmailPreferences", testcaseID = "TC5", runmode = "Yes")
	@Test(priority = 5, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)

	public void termAndConditionsPage_LinksValidation(Hashtable<String, String> datatable)
			throws InterruptedException, IOException, GeneralSecurityException {
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		MyProfilePage = new MyProfilePage(driver);
		// The Below code will navigate you to My Profile page
		MyProfilePage.click_User_Dropdown_Toggle();
		Thread.sleep(2000);
		MyProfilePage.click_User_Dropdown_Toggle_Accounts();
		Thread.sleep(2000);
		MyProfilePage.click_profileLink();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,6000)");
		// logger.info("Test 4: WIndow scrolled by 6000 pixels vertically");
		MyProfilePage.click_MyAccountTermsandConditions();
		// Validating "service@dollardays.com" link
		// logger.info("Test 5:Validating Services@dollardays.com");
		List<WebElement> linkElements = MyProfilePage.ServicesADDDotCom_links;
		int n = 8;
		for (int i = 0; i < linkElements.size(); i++, n++) { // ExpectedValue="mailto:service@dollardays.com";
			ExpectedValue = "mailto:service@dollardays.com";
			ActualValue = linkElements.get(i).getAttribute("href");
			try {
				Assert.assertEquals(ActualValue, ExpectedValue);
				// System.out.println("Assertion Pass");
				// logger.info("Test 5:" + i + "Services@dollardays.com link is directing to
				// outlook..As Expected");
				/*
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, n, 0, sheet, "Test 5");
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, n, 1, sheet, " Link Number" + i
				 * + "Services@dollardays.com link is directing to outlook");
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, n, 2, sheet, "PASS");
				 */
				ExtentTestManager.getTest().log(Status.PASS,
						"Test 5:" + i + "Services@dollardays.com link is directing to outlook..As Expected");
			} catch (AssertionError e) {
				// System.out.println("Assertion Fail :"+ e);
				/*
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, n, 0, sheet, "Test 5");
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, n, 1, sheet, " Link Number " + i
				 * + " Services@dollardays.com link is not directing to outlook");
				 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, n, 2, sheet, "FAIL");
				 * logger.debug( "Test 5: " + i +
				 * " Services@dollardays.com link is not directing to outlook..Not as Expected"
				 * ); logger.debug("Error Message  : " + e.getMessage());
				 */
				ExtentTestManager.getTest().log(Status.FAIL,
						"Test 5: " + i + " Services@dollardays.com link is not directing to outlook..Not as Expected");
			}
		}

		// Validating "Please review our full shipping terms here." link
		// logger.info("Test 5:Validating \"Please review our full shipping terms
		// here.\" link");
		MyProfilePage.PleaseReviewFullShippingTerms_link.click();
		// logger.info("Test 5:Clicked \"Please review our full shipping terms here.\"
		// link");
		Actual_Title = driver.getTitle();
		// Expected_Title="Shipping Policy - DollarDays";
		Expected_Title = "Shipping Policy - DollarDays";
		try {
			Assert.assertEquals(Actual_Title, Expected_Title);
			// System.out.println("Assertion Pass");
			/*
			 * logger.info(
			 * "Test 5 :'Please review our full shipping terms here.'link is directing to 'Shipping Policy - DollarDays' page..As Expected"
			 * );
			 */
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 11, 0, sheet, "Test 5");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 11, 1, sheet,
			 * "'Please review our full shipping terms here.'link is directing to 'Shipping Policy - DollarDays' page"
			 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 11, 2, sheet, "PASS");
			 */
			ExtentTestManager.getTest().log(Status.PASS,
					"Test 5 :'Please review our full shipping terms here.'link is directing to 'Shipping Policy - DollarDays' page..As Expected");
		} catch (AssertionError e) {
			// System.out.println("Assertion Fail :"+ e);
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 11, 0, sheet, "Test 5");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 11, 1, sheet,
			 * "'Please review our full shipping terms here.'link is not directing to 'Shipping Policy - DollarDays' Page"
			 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 11, 2, sheet, "FAIL");
			 */
			/*
			 * logger.debug(
			 * "Test 5:'Please review our full shipping terms here.'link is not directing to 'Shipping Policy - DollarDays' Page..Not as Expected"
			 * ); logger.debug("Error Message  : " + e.getMessage());
			 */
			ExtentTestManager.getTest().log(Status.FAIL,
					"Test 5:'Please review our full shipping terms here.'link is not directing to 'Shipping Policy - DollarDays' Page..Not as Expected");
		}
		driver.navigate().back();
		// logger.info("Test 5:Navigated back to Terms and Conditions page");

		// Validating "support@dollardays.com" link
		// logger.info("Test 5:Validating \"support@dollardays.com\" link");
		WebElement Element = MyProfilePage.SupportADDDotCom_link;
		ActualValue = Element.getAttribute("href");
		// ExpectedValue="mailto:support@dollardays.com";
		ExpectedValue = "mailto:support@dollardays.com";
		try {
			Assert.assertEquals(ActualValue, ExpectedValue);
			// System.out.println("Assertion Pass");
			// logger.info("Test 5:\"support@dollardays.com\" link is directing to
			// outlook..As Expected");
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 12, 0, sheet, "Test 5");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 12, 1, sheet,
			 * "\"support@dollardays.com\" link is directing to outlook");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 12, 2, sheet, "PASS");
			 */
			ExtentTestManager.getTest().log(Status.PASS,
					"Test 5:\"support@dollardays.com\" link is directing to outlook..As Expected");
		} catch (AssertionError e) {
			// System.out.println("Assertion Fail :"+ e);
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 12, 0, sheet, "Test 5");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 12, 1, sheet,
			 * "\"support@dollardays.com\" link is not directing to outlook");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 12, 2, sheet, "FAIL"); logger.
			 * debug("Test 5:\"support@dollardays.com\" link is not directing to outlook..Not as Expected"
			 * ); logger.debug("Error Message  : " + e.getMessage());
			 */
			ExtentTestManager.getTest().log(Status.FAIL,
					"Test 5:\"support@dollardays.com\" link is not directing to outlook..Not as Expected");
		}

		// Validating "www.adr.org." link
		// logger.info("Test 5:Validating \"www.adr.org.\" link");
		// System.out.println("Parent Title : " + BaseTest.driver.getTitle());

		MyProfilePage.click_WWWDotADRDotORG_link();
		// logger.info("Test 5:Clicked \"www.adr.org.\" link");
		Set<String> allwindows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<>(allwindows);

		driver.switchTo().window(tabs.get(1));
		// logger.info("Switched the focus to Child Tab");
		// System.out.println("New Tab Title : " + BaseTest.driver.getTitle());
		Actual_Title = driver.getTitle();
		// Expected_Title="American Arbitration Association | ADR.org";
		Expected_Title = "American Arbitration Association | ADR.org";
		try {
			Assert.assertEquals(Actual_Title, Expected_Title);
			// System.out.println("Assertion Pass");
			/*
			 * logger.info(
			 * "Test 5:'www.adr.org.'link is directing to 'American Arbitration Association | ADR.org' tab..As Expected"
			 * );
			 */
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 13, 0, sheet, "Test 5");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 13, 1, sheet,
			 * "'www.adr.org.'link is directing to 'American Arbitration Association | ADR.org' tab"
			 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 13, 2, sheet, "PASS");
			 */
			ExtentTestManager.getTest().log(Status.PASS,
					"Test 5:'www.adr.org.'link is directing to 'American Arbitration Association | ADR.org' tab..As Expected");
		} catch (AssertionError e) {
			// System.out.println("Assertion Fail :"+ e);
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 13, 0, sheet, "Test 5");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 13, 1, sheet,
			 * "'www.adr.org.'link is not directing to 'American Arbitration Association | ADR.org' tab"
			 * ); ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 13, 2, sheet, "FAIL");
			 * logger.debug(
			 * "Test 5:'www.adr.org.'link is not directing to 'American Arbitration Association | ADR.org' tab..Not as Expected"
			 * ); logger.debug("Error Message  : " + e.getMessage());
			 */
			ExtentTestManager.getTest().log(Status.FAIL,
					"Test 5:'www.adr.org.'link is not directing to 'American Arbitration Association | ADR.org' tab..Not as Expected");
		}

		driver.close();
		// logger.info("Closed the child Tab");
		driver.switchTo().window(tabs.get(0));
		// logger.info("Changed the focus to parent tab");
		// System.out.println("Parent Title : " + BaseTest.driver.getTitle());

		// Validating "contact@dollardays.com." link
		// logger.info("Validating \"contact@dollardays.com.\" link");
		Element = MyProfilePage.ContactADDDotCom_link;
		ActualValue = Element.getAttribute("href");
		// ExpectedValue="mailto:contact@dollardays.com";
		ExpectedValue = "mailto:contact@dollardays.com";
		try {
			Assert.assertEquals(ActualValue, ExpectedValue);
			// System.out.println("Assertion Pass");
			// logger.info("Test 5:\"contact@dollardays.com\" link is directing to
			// outlook..As Expected");
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 14, 0, sheet, "Test 5");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 14, 1, sheet,
			 * "\"contact@dollardays.com\" link is directing to outlook");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 14, 2, sheet, "PASS");
			 */
			ExtentTestManager.getTest().log(Status.PASS,
					"Test 5:\"contact@dollardays.com\" link is directing to outlook..As Expected");
		} catch (AssertionError e) {
			// System.out.println("Assertion Fail :"+ e);
			/*
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 14, 0, sheet, "Test 5");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 14, 0, sheet,
			 * "\"contact@dollardays.com\" link is not directing to outlook");
			 * ReadExcel.writeresult(EXCEL_OUTPUT_FILEPATH, 14, 0, sheet, "FAIL"); logger.
			 * debug("Test 5:\"contact@dollardays.com\" link is not directing to outlook..Not As Expected"
			 * ); logger.debug("Error Message  : " + e.getMessage());
			 */
			ExtentTestManager.getTest().log(Status.FAIL,
					"Test 5:\"contact@dollardays.com\" link is not directing to outlook..Not As Expected");
		}

		// logger.info("Test#5 Finish");
		MyProfilePage.click_User_Dropdown_Toggle();
		MyProfilePage.click_User_Dropdown_Toggle_Signout();
		ExtentTestManager.getTest().log(Status.INFO, "LoggedOut Succesfully from TC5");
	}

	// @BeforeTest

	/*
	 * public void beforeTest() throws InterruptedException, IOException {
	 * extentReport=BaseTest.extentReportInstance(); initialization();
	 * //logger.info("Driver instantiated"); signInMethod();
	 * //logger.info("singned in to DollarDays");
	 * 
	 * // The Below code will navigate you to My Profile page MyProfilePage = new
	 * MyProfilePage(BaseTest.driver); MyProfilePage.click_User_Dropdown_Toggle();
	 * //logger.info(" Main User Toggle clicked"); Thread.sleep(2000);
	 * MyProfilePage.click_User_Dropdown_Toggle_Accounts();
	 * //logger.info(" Accounts link clicked"); Thread.sleep(2000);
	 * MyProfilePage.click_profileLink(); //logger.info(" My Profile link clicked");
	 * js = (JavascriptExecutor) BaseTest.driver;
	 * 
	 * }
	 * 
	 * //@AfterTest public void afterTest() {
	 * MyProfilePage.click_User_Dropdown_Toggle();
	 * MyProfilePage.click_User_Dropdown_Toggle_Signout();
	 * //logger.info("Signed out from Dollardays"); extentReport.flush();
	 * termination();
	 * 
	 * }
	 */

}
