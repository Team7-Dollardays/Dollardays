package com.dollardays.testcases;

///import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
//import com.dollardays.utilities.PropertyUtil;
import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.MenuPage;
import com.dollardays.pages.TaxExemptPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class TaxExemptTestcase extends BaseTest 
{
	private String actualResult = "true";
	private String expectedResult = "false";
	private int stepIndex = 1;
	private static String filetype;

	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "TaxExempt", testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void taxExempt_ValidateTaxExemptRequiredFields(Hashtable<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
	{
		 actualResult = "";
		 expectedResult = datatable.get("ExpectedResult").trim();
		 TaxExemptPage taxExemptpage = new TaxExemptPage(driver);
		 
		 // open 'Tax Exempt Request Form' 
		 this.openTaxExemptUploadLink(datatable);
		 
		// sending document name from excel sheet.
		taxExemptpage.getAccount_TaxExemptdocumentName().sendKeys(datatable.get("DocumentName"));
		ExtentTestManager.getTest().log(Status.INFO, "User entered " + datatable.get("DocumentName") + " in 'Enter your Document Name' input field.");
		stepIndex += 1;
		
        // Click on 'Upload' button
		taxExemptpage.getAccount_TaxExemptUploadBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Upload' button.");
		stepIndex += 1;
		
		actualResult = taxExemptpage.returnErrormsg().getText();
		taxExemptpage.getAccount_TaxExemptCloseBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'close' icon to close the 'Tax Exempt Request Form'.");
		stepIndex += 1;
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"),actualResult,expectedResult);

		// Log out -
		logout();
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "TaxExempt", testcaseID = "TC2", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void taxExempt_ExcepTaxID_AllFields_Empty(Hashtable<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
	{
		actualResult = "";
		 expectedResult = datatable.get("ExpectedResult").trim();
		 TaxExemptPage taxExemptpage = new TaxExemptPage(driver);
		 
		 // open 'Tax Exempt Request Form' 
		 this.openTaxExemptUploadLink(datatable);
		 
		// sending document name from excel sheet.
		taxExemptpage.getAccount_TaxExemptdocumentName().sendKeys(datatable.get("DocumentName"));
		ExtentTestManager.getTest().log(Status.INFO, "User entered " + datatable.get("DocumentName") + " in 'Enter your Document Name' input field.");
		stepIndex += 1;
		
		// sending TaxID from excel sheet.
		if ((datatable.get("TaxID") != null && !(datatable.get("TaxID").equals("")))) {
			taxExemptpage.getAccount_TaxExemptTaxid().sendKeys((datatable.get("TaxID")));
			ExtentTestManager.getTest().log(Status.INFO, "User entered " + datatable.get("TaxID") + " in 'Enter your tax id' input field.");
			stepIndex += 1;
		}
		
       // Click on 'Upload' button
		taxExemptpage.getAccount_TaxExemptUploadBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Upload' button.");
		stepIndex += 1;
		
		actualResult = taxExemptpage.returnErrormsg().getText();
		taxExemptpage.getAccount_TaxExemptCloseBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'close' icon to close the 'Tax Exempt Request Form'.");
		stepIndex += 1;
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"),actualResult,expectedResult);

		// Log out -
		logout();	
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "TaxExempt", testcaseID = "TC3", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void taxExempt_ExcepState_AllFields_Empty(Hashtable<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
	{
		actualResult = "";
		 expectedResult = datatable.get("ExpectedResult").trim();
		 TaxExemptPage taxExemptpage = new TaxExemptPage(driver);
		 
		 // open 'Tax Exempt Request Form' 
		 this.openTaxExemptUploadLink(datatable);
		 
		// sending document name from excel sheet.
		taxExemptpage.getAccount_TaxExemptdocumentName().sendKeys(datatable.get("DocumentName"));
		ExtentTestManager.getTest().log(Status.INFO, "User entered " + datatable.get("DocumentName") + " in 'Enter your Document Name' input field.");
		stepIndex += 1;
		
		// Sending State from excel sheet.
		if ((datatable.get("State") != null && !(datatable.get("State").equals("")))) {
			taxExemptpage.getAccount_TaxExemptStatedpdown().sendKeys((datatable.get("State")));
			ExtentTestManager.getTest().log(Status.INFO, "User entered State. " + "State:" + datatable.get("State"));
		}
		
       // Click on 'Upload' button
		taxExemptpage.getAccount_TaxExemptUploadBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Upload' button.");
		stepIndex += 1;
		
		actualResult = taxExemptpage.returnErrormsg().getText();
		taxExemptpage.getAccount_TaxExemptCloseBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'close' icon to close the 'Tax Exempt Request Form'.");
		stepIndex += 1;
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"),actualResult,expectedResult);

		// Log out -
		logout();
		
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "TaxExempt", testcaseID = "TC4", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void taxExempt_ExcepTaxIDandState_AllFields_Empty(Hashtable<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
	{
		actualResult = "";
		 expectedResult = datatable.get("ExpectedResult").trim();
		 TaxExemptPage taxExemptpage = new TaxExemptPage(driver);
		 
		 // open 'Tax Exempt Request Form' 
		 this.openTaxExemptUploadLink(datatable);
		 
		// sending document name from excel sheet.
		taxExemptpage.getAccount_TaxExemptdocumentName().sendKeys(datatable.get("DocumentName"));
		ExtentTestManager.getTest().log(Status.INFO, "User entered " + datatable.get("DocumentName") + " in 'Enter your Document Name' input field.");
		stepIndex += 1;
		
		// sending TaxID from excel sheet.
		if ((datatable.get("TaxID") != null && !(datatable.get("TaxID").equals("")))) {
			taxExemptpage.getAccount_TaxExemptTaxid().sendKeys((datatable.get("TaxID")));
			ExtentTestManager.getTest().log(Status.INFO, "User entered " + datatable.get("TaxID") + " in 'Enter your tax id' input field.");
			stepIndex += 1;
		}
		
		// Sending State from excel sheet.
		if ((datatable.get("State") != null && !(datatable.get("State").equals("")))) {
			taxExemptpage.getAccount_TaxExemptStatedpdown().sendKeys((datatable.get("State")));
			ExtentTestManager.getTest().log(Status.INFO, "User entered State. " + "State:" + datatable.get("State"));
		}
		
       // Click on 'Upload' button
		taxExemptpage.getAccount_TaxExemptUploadBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Upload' button.");
		stepIndex += 1;
		
		actualResult = taxExemptpage.returnErrormsg().getText();
		taxExemptpage.getAccount_TaxExemptCloseBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'close' icon to close the 'Tax Exempt Request Form'.");
		stepIndex += 1;
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"),actualResult,expectedResult);

		// Log out -
		logout();	
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "TaxExempt", testcaseID = "TC5", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void taxExempt_ExcepExpiryDate_AllFields_Empty(Hashtable<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
	{
		actualResult = "";
		 expectedResult = datatable.get("ExpectedResult").trim();
		 TaxExemptPage taxExemptpage = new TaxExemptPage(driver);
		 
		 // open 'Tax Exempt Request Form' 
		 this.openTaxExemptUploadLink(datatable);
		 
		// sending document name from excel sheet.
		taxExemptpage.getAccount_TaxExemptdocumentName().sendKeys(datatable.get("DocumentName"));
		ExtentTestManager.getTest().log(Status.INFO, "Step "+stepIndex+": User entered " + datatable.get("DocumentName") + " in 'Enter your Document Name' input field.");
		stepIndex += 1;
		
		// sending expiry date from excel sheet.
		if ((datatable.get("ExpiryDate") != null && !(datatable.get("ExpiryDate").equals("")))) {
			taxExemptpage.getAccount_ExpiryDate().sendKeys(datatable.get("ExpiryDate"));
			ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User entered expiry date."+ "ExpiryDate:" + datatable.get("ExpiryDate"));
			stepIndex += 1;
			//clicking choosefile lable to prevent element click intercepted exception.
			taxExemptpage.getchooseFileLabel().click();

		}
		
       // Click on 'Upload' button
		taxExemptpage.getAccount_TaxExemptUploadBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Upload' button.");
		stepIndex += 1;
		
		actualResult = taxExemptpage.returnErrormsg().getText();
		taxExemptpage.getAccount_TaxExemptCloseBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'close' icon to close the 'Tax Exempt Request Form'.");
		stepIndex += 1;
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"),actualResult,expectedResult);

		// Log out -
		logout();	
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "TaxExempt", testcaseID = "TC6", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void taxExempt_StateandTaxID_Empty(Hashtable<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
	{
		actualResult = "";
		 expectedResult = datatable.get("ExpectedResult").trim();
		 TaxExemptPage taxExemptpage = new TaxExemptPage(driver);
		 
		 // open 'Tax Exempt Request Form' 
		 this.openTaxExemptUploadLink(datatable);
		 
		// sending document name from excel sheet.
		taxExemptpage.getAccount_TaxExemptdocumentName().sendKeys(datatable.get("DocumentName"));
		ExtentTestManager.getTest().log(Status.INFO, "Step "+stepIndex+": User entered " + datatable.get("DocumentName") + " in 'Enter your Document Name' input field.");
		stepIndex += 1;
		
		// sending expiry date from excel sheet.
		if ((datatable.get("ExpiryDate") != null && !(datatable.get("ExpiryDate").equals("")))) {
			taxExemptpage.getAccount_ExpiryDate().sendKeys(datatable.get("ExpiryDate"));
			ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User entered expiry date."+ "ExpiryDate:" + datatable.get("ExpiryDate"));
			stepIndex += 1;
			//clicking choosefile lable to prevent element click intercepted exception.
			taxExemptpage.getchooseFileLabel().click();

		}
		
		// Enter File in FilePath
		String uploadDatafolder = System.getProperty("user.dir") + "//testdata//";
		
		// Click on Choose File 
		taxExemptpage.getaccount_ChooseFileBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Choose File' button.");
		stepIndex += 1;
		ExtentTestManager.getTest().log(Status.INFO, "File Explorer is open to Choose file.");
		
		String filePath = datatable.get("filePath");
		//Appending file name from excel sheet to test data folder path
		if (uploadDatafolder != null) {
			if (filePath != null && !filePath.equals("")) {
				String path = uploadDatafolder + datatable.get("filePath");
				
				taxExemptpage.getAccount_TaxExemptfileUploadBtn().sendKeys(path);
				ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+":User choose a file to upload. file Name: " + datatable.get("filePath"));
				stepIndex += 1;
				ExtentTestManager.getTest().log(Status.INFO, "file is uploaded.");
			}
		}
		
       // Click on 'Upload' button
		taxExemptpage.getAccount_TaxExemptUploadBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Upload' button.");
		stepIndex += 1;
		
		actualResult = taxExemptpage.returnErrormsg().getText();
		taxExemptpage.getAccount_TaxExemptCloseBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'close' icon to close the 'Tax Exempt Request Form'.");
		stepIndex += 1;
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"),actualResult,expectedResult);

		// Log out -
		logout();	
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "TaxExempt", testcaseID = "TC7", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void taxExempt_ExpiryDateandState_Empty(Hashtable<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
	{
		actualResult = "";
		 expectedResult = datatable.get("ExpectedResult").trim();
		 TaxExemptPage taxExemptpage = new TaxExemptPage(driver);
		 
		 // open 'Tax Exempt Request Form' 
		 this.openTaxExemptUploadLink(datatable);
		 
		// sending document name from excel sheet.
		taxExemptpage.getAccount_TaxExemptdocumentName().sendKeys(datatable.get("DocumentName"));
		ExtentTestManager.getTest().log(Status.INFO, "Step "+stepIndex+": User entered " + datatable.get("DocumentName") + " in 'Enter your Document Name' input field.");
		stepIndex += 1;
		
		// sending TaxID from excel sheet.
		if ((datatable.get("TaxID") != null && !(datatable.get("TaxID").equals("")))) {
			taxExemptpage.getAccount_TaxExemptTaxid().sendKeys((datatable.get("TaxID")));
			ExtentTestManager.getTest().log(Status.INFO, "User entered " + datatable.get("TaxID") + " in 'Enter your tax id' input field.");
			stepIndex += 1;
		}
		
		// Enter File in FilePath
		String uploadDatafolder = System.getProperty("user.dir") + "//testdata//";
		
		// Click on Choose File 
		taxExemptpage.getaccount_ChooseFileBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Choose File' button.");
		stepIndex += 1;
		ExtentTestManager.getTest().log(Status.INFO, "File Explorer is open to Choose file.");
		
		String filePath = datatable.get("filePath");
		//Appending file name from excel sheet to test data folder path
		if (uploadDatafolder != null) {
			if (filePath != null && !filePath.equals("")) {
				String path = uploadDatafolder + datatable.get("filePath");
				
				taxExemptpage.getAccount_TaxExemptfileUploadBtn().sendKeys(path);
				ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+":User choose a file to upload. file Name: " + datatable.get("filePath"));
				stepIndex += 1;
				ExtentTestManager.getTest().log(Status.INFO, "file is uploaded.");
			}
		}
		
       // Click on 'Upload' button
		taxExemptpage.getAccount_TaxExemptUploadBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Upload' button.");
		stepIndex += 1;
		
		actualResult = taxExemptpage.returnErrormsg().getText();
		taxExemptpage.getAccount_TaxExemptCloseBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'close' icon to close the 'Tax Exempt Request Form'.");
		stepIndex += 1;
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"),actualResult,expectedResult);

		// Log out -
		logout();	
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "TaxExempt", testcaseID = "TC8", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void taxExempt_Validate_AllRequiredField(Hashtable<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
	{
		actualResult = "";
		 expectedResult = datatable.get("ExpectedResult").trim();
		 TaxExemptPage taxExemptpage = new TaxExemptPage(driver);
		 
		 // open 'Tax Exempt Request Form' 
		 this.openTaxExemptUploadLink(datatable);
		 
		// sending document name from excel sheet.
		taxExemptpage.getAccount_TaxExemptdocumentName().sendKeys(datatable.get("DocumentName"));
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User entered " + datatable.get("DocumentName") + " in 'Enter your Document Name' input field.");
		stepIndex += 1;
		
		// sending TaxID from excel sheet.
		if ((datatable.get("TaxID") != null && !(datatable.get("TaxID").equals("")))) {
			taxExemptpage.getAccount_TaxExemptTaxid().sendKeys((datatable.get("TaxID")));
			ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User entered " + datatable.get("TaxID") + " in 'Enter your tax id' input field.");
			stepIndex += 1;
		}
		
		// Sending State from excel sheet.
		if ((datatable.get("State") != null && !(datatable.get("State").equals("")))) {
			taxExemptpage.getAccount_TaxExemptStatedpdown().sendKeys((datatable.get("State")));
			ExtentTestManager.getTest().log(Status.PASS,"Step "+stepIndex+": User entered State. " + "State:" + datatable.get("State"));
			stepIndex+=1;
		}
		
		// sending expiry date from excel sheet.
		if ((datatable.get("ExpiryDate") != null && !(datatable.get("ExpiryDate").equals("")))) {
			taxExemptpage.getAccount_ExpiryDate().sendKeys(datatable.get("ExpiryDate"));
			ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User entered expiry date."+ "ExpiryDate:" + datatable.get("ExpiryDate"));
			stepIndex += 1;
			//clicking choosefile lable to prevent element click intercepted exception.
			taxExemptpage.getchooseFileLabel().click();

		}
		
		// Enter File in FilePath
		String uploadDatafolder = System.getProperty("user.dir") + "//testdata//";
		
		// Click on Choose File 
		taxExemptpage.getaccount_ChooseFileBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Choose File' button.");
		stepIndex += 1;
		ExtentTestManager.getTest().log(Status.INFO, "File Explorer is open to Choose file.");
		
		String filePath = datatable.get("filePath");
		//Appending file name from excel sheet to test data folder path
		if (uploadDatafolder != null) {
			if (filePath != null && !filePath.equals("")) {
				String path = uploadDatafolder + datatable.get("filePath");
				
				taxExemptpage.getAccount_TaxExemptfileUploadBtn().sendKeys(path);
				ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+":User choose a file to upload. file Name: " + datatable.get("filePath"));
				stepIndex += 1;
				ExtentTestManager.getTest().log(Status.INFO, "file is uploaded.");
			}
		}
		
      // Click on 'Upload' button
		taxExemptpage.getAccount_TaxExemptUploadBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Upload' button.");
		stepIndex += 1;
		
		
		Thread.sleep(5000);
		actualResult = taxExemptpage.tax_ExemptSucessMsg().getText();
		taxExemptpage.gethomePopup_Close().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked tax exempt success message close button.");
		stepIndex += 1;
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"),actualResult,expectedResult);

		// Log out -
		logout();	
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "TaxExempt", testcaseID = "TC9", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void taxExempt_Upload_WrongFileFormat(Hashtable<String, String> datatable)
			throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
	{
		 actualResult = "";
		 expectedResult = datatable.get("ExpectedResult").trim();
		 TaxExemptPage taxExemptpage = new TaxExemptPage(driver);
		 
		 // open 'Tax Exempt Request Form' 
		 this.openTaxExemptUploadLink(datatable);
		 
		// sending document name from excel sheet.
		taxExemptpage.getAccount_TaxExemptdocumentName().sendKeys(datatable.get("DocumentName"));
		ExtentTestManager.getTest().log(Status.INFO, "Step "+stepIndex+": User entered " + datatable.get("DocumentName") + " in 'Enter your Document Name' input field.");
		stepIndex += 1;
		
		// sending TaxID from excel sheet.
		if ((datatable.get("TaxID") != null && !(datatable.get("TaxID").equals("")))) {
			taxExemptpage.getAccount_TaxExemptTaxid().sendKeys((datatable.get("TaxID")));
			ExtentTestManager.getTest().log(Status.INFO, "User entered " + datatable.get("TaxID") + " in 'Enter your tax id' input field.");
			stepIndex += 1;
		}
		
		// Sending State from excel sheet.
		if ((datatable.get("State") != null && !(datatable.get("State").equals("")))) {
			taxExemptpage.getAccount_TaxExemptStatedpdown().sendKeys((datatable.get("State")));
			ExtentTestManager.getTest().log(Status.INFO, "User entered State. " + "State:" + datatable.get("State"));
		}
		
		// sending expiry date from excel sheet.
		if ((datatable.get("ExpiryDate") != null && !(datatable.get("ExpiryDate").equals("")))) {
			taxExemptpage.getAccount_ExpiryDate().sendKeys(datatable.get("ExpiryDate"));
			ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User entered expiry date."+ "ExpiryDate:" + datatable.get("ExpiryDate"));
			stepIndex += 1;
			//clicking choosefile lable to prevent element click intercepted exception.
			taxExemptpage.getchooseFileLabel().click();

		}
		
		// Enter File in FilePath
		String uploadDatafolder = System.getProperty("user.dir") + "//testdata//";
		
		// Click on Choose File 
		taxExemptpage.getaccount_ChooseFileBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Choose File' button.");
		stepIndex += 1;
		ExtentTestManager.getTest().log(Status.INFO, "File Explorer is open to Choose file.");
		
		String filePath = datatable.get("filePath");
		//Appending file name from excel sheet to test data folder path
		if (uploadDatafolder != null) {
			if (filePath != null && !filePath.equals("")) {
				String path = uploadDatafolder + datatable.get("filePath");
				
				taxExemptpage.getAccount_TaxExemptfileUploadBtn().sendKeys(path);
				ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+":User choose a file to upload. file Name: " + datatable.get("filePath"));
				stepIndex += 1;
				ExtentTestManager.getTest().log(Status.INFO, "file is uploaded.");
			}
		}
		
      // Click on 'Upload' button
		taxExemptpage.getAccount_TaxExemptUploadBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Upload' button.");
		stepIndex += 1;
		
		actualResult = taxExemptpage.returnErrormsg().getText();
		taxExemptpage.getAccount_TaxExemptCloseBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'close' icon to close the 'Tax Exempt Request Form'.");
		stepIndex += 1;
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"),actualResult,expectedResult);

		// Log out -
		logout();	
	}
	

	private void openTaxExemptUploadLink(Hashtable<String, String> datatable) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException 
	{
		stepIndex = 1;
		System.out.println(datatable.get("TestCase"));
		
		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		
	
		// Login 
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": Successfully Logged in with valid Credentials");
		stepIndex += 1;
		Thread.sleep(1000);

		TaxExemptPage taxExemptpage = new TaxExemptPage(driver);
		taxExemptpage.getsignInButton().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on Sign-in Toggle after signing in.");
		stepIndex += 1;
		
		// Click on 'Accounts' from Drop down Toggle menu
		taxExemptpage.getsignIn_accountBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Accounts' link in user dropdown toggle menu.");
		stepIndex += 1;
		Thread.sleep(3000);
		
		ExtentTestManager.getTest().log(Status.INFO, "Page is navigated to "+ driver.getCurrentUrl());
		
		
		taxExemptpage.getAccount_TaxExemptUploadLink().click();
		Thread.sleep(3000);
		
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Tax Exempt' upload link.");
		stepIndex += 1;
		
		ExtentTestManager.getTest().log(Status.INFO, "'Tax Exempt Request Form' is open.");
		
	}
	
	private void logout() throws InterruptedException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUserDropdown().click();
		Thread.sleep(1000);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step "+stepIndex+": User clicked on 'Log out'.");
		
	}

}
