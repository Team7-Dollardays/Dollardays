package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SearchPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class SearchTestcase extends BaseTest{

	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search",  testcaseID = "TC3", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void searchWithValidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.startTest("Search_TestCase_" +datatable.get("TCID"));
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		SearchPage searchpage = new SearchPage(driver);
		
		searchpage.getSearchBar().sendKeys(datatable.get("SearchItem").trim());
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		
		String categoryCount = searchpage.getsearchCount().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+categoryCount+"'");
		
		
	}

	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search",  testcaseID = "TC2", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void searchWithInvalidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.startTest("Search_TestCase_" +datatable.get("TCID"));
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 2 : Verify Search functionality with Invalid data");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		SearchPage searchpage = new SearchPage(driver);
		
		searchpage.getSearchBar().sendKeys(datatable.get("SearchItem").trim());
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		
		String nodatafound = searchpage.getnoDataFoundMsg().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+nodatafound+"'");
		
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void searchPageWithNavigationLinks(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.startTest("Search_TestCase_" +datatable.get("TCID"));
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 3 : Validate Product Navigation Pages ");
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		//loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		loginPage.invokeLogin();
		Thread.sleep(1000);
		SearchPage searchpage = new SearchPage(driver);
		searchpage.getSearchBar().sendKeys(datatable.get("SearchItem").trim());
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar.");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button.");
		Thread.sleep(500);
		try {
			
			searchpage.getItemCount();
			Thread.sleep(10000);
			
		}catch (Exception e) {
			searchpage.getItemCount();
			Thread.sleep(10000);
		}
		
		
		
	}

	
	
	
	
	

}

