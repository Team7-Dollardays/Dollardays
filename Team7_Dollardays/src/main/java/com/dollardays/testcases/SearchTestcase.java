package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SearchPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class SearchTestcase extends BaseTest {

	private String actualResult = "true";
	private String expectedResult = "false";
	private int stepIndex = 1;

	
//	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search", testcaseID = "TC1", runmode = "No")
//	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
//	public void searchPageWithNavigationLinks(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
//	{
//
//		ExtentTestManager.startTest("Search_TestCase_" + datatable.get("TCID"));
//		ExtentTestManager.getTest().log(Status.PASS, "Testcase 3 : Validate Product Navigation Pages ");
//		LoginPage loginPage = new LoginPage(driver);
//		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
//
//		Base64.decrypt(datatable.get("Password"));
//		loginPage.invokeLogin();
//		Thread.sleep(1000);
//		SearchPage searchpage = new SearchPage(driver);
//		searchpage.getSearchBar().sendKeys(datatable.get("SearchItem").trim());
//		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar.");
//
//		searchpage.getsearchBtn().click();
//		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button.");
//		Thread.sleep(500);
//		try {
//
//			searchpage.getItemCount();
//			Thread.sleep(10000);
//
//		} catch (Exception e) {
//			searchpage.getItemCount();
//			Thread.sleep(10000);
//		}
//	}
	
//
//	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search", testcaseID = "TC2", runmode = "No")
//	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
//	public void searchWithInvalidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
//	{
//		ExtentTestManager.startTest("Search_TestCase_" + datatable.get("TCID"));
//		ExtentTestManager.getTest().log(Status.PASS, "Testcase 2 : Verify Search functionality with Invalid data");
//
//		LoginPage loginPage = new LoginPage(driver);
//		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
//		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
//		Thread.sleep(1000);
//
//		SearchPage searchpage = new SearchPage(driver);
//		searchpage.getSearchBar().sendKeys(datatable.get("SearchItem").trim());
//		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
//
//		searchpage.getsearchBtn().click();
//		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
//		Thread.sleep(500);
//
//		String nodatafound = searchpage.getnoDataFoundMsg().getText();
//		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '" + nodatafound + "'");
//
//	}
//	
//	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search", testcaseID = "TC3", runmode = "No")
//	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
//	public void searchWithValidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
//	{
//		ExtentTestManager.startTest("Search_TestCase_" + datatable.get("TCID"));
//
//		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
//
//		LoginPage loginPage = new LoginPage(driver);
//		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
//		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
//		Thread.sleep(1000);
//
//		SearchPage searchpage = new SearchPage(driver);
//		searchpage.getSearchBar().sendKeys(datatable.get("SearchItem").trim());
//		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
//
//		searchpage.getsearchBtn().click();
//		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
//		Thread.sleep(500);
//
//		String categoryCount = searchpage.getsearchCount().getText();
//		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '" + categoryCount + "'");
//	}
//
//	
//
//	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search", testcaseID = "TC4", runmode = "No")
//	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
//	public void verifyDefaultSearchResult(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
//	{
//		ExtentTestManager.startTest("Search_TestCase_" + datatable.get("TCID"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
//
//		ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex + ": Login into DollarDays.");
//		stepIndex += 1;
//
//		// login 
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.invokeLogin();
//		Thread.sleep(1000);
//
//		SearchPage searchpage = new SearchPage(driver);
//		searchpage.getSearchBar().click();
//		Thread.sleep(2000);
//		System.out.println("Clicked in Search bar");
//		ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex
//				+ ": Clicked in 'Search for items in bulk' field and 'Search Result' box is open. ");
//		stepIndex += 1;
//
//		WebElement firstDefaultItem = searchpage.getSearchResult_firstItem();
//		actualResult = firstDefaultItem.getText();
//		firstDefaultItem.click();
//		Thread.sleep(2000);
//
//		System.out.println("get Search result first item.");
//		ExtentTestManager.getTest().log(Status.PASS,
//				"Step " + stepIndex + ": Clicked on first item named " + actualResult);
//		stepIndex += 1;
//
//		ExtentTestManager.getTest().log(Status.PASS,
//				"Step " + stepIndex + ": Web page is navigated to " + driver.getCurrentUrl());
//		stepIndex += 1;
//
//		System.out.println("Web page is navigated to  " + driver.getCurrentUrl());
//		System.out.println("Clicked on item name = " + actualResult);
//
//		expectedResult = searchpage.getProduct_title();
//		System.out.println("item page product title=" + expectedResult);
//
//		if (actualResult.equalsIgnoreCase(expectedResult)) {
//			actualResult += " product detail web page is displayed.";
//			expectedResult = actualResult;
//		}
//
//		testResults(datatable.get("TestCase"));
//
//	}
//	
//	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search", testcaseID = "TC5", runmode = "yes")
//	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
//	public void verifyLeftPaneItemClick(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
//	{
//		ExtentTestManager.startTest("Search_TestCase_" + datatable.get("TCID"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
//
//		ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex + ": Login into DollarDays.");
//		stepIndex += 1;
//
//		// login
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.invokeLogin();
//		Thread.sleep(1000);
//
//		//
//		SearchPage searchpage = new SearchPage(driver);
//
//		// Step 1 : Click in 'Search Bar'
//		searchpage.getSearchBar().click();
//		Thread.sleep(1000);
//		ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex
//				+ ": Clicked in 'Search for items in bulk' field and 'Search Result' box is open. ");
//		stepIndex += 1;
//
//		String leftPaneitem = datatable.get("Leftpane Category").trim();
//		List<WebElement> leftPaneitems = searchpage.getSearchResult_leftPaneitems();
//
//		for (WebElement spanTag : leftPaneitems) {
//
//			if (spanTag.getText().equalsIgnoreCase(leftPaneitem)) {
//				ExtentTestManager.getTest().log(Status.PASS,
//						"Step " + stepIndex + ": Click on Item - " + leftPaneitem + " in 'search result' box.");
//				stepIndex += 1;
//				spanTag.click();
//				Thread.sleep(1000);
//				ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex + ": page is navigated to product "
//						+ leftPaneitem + " detail web page - " + driver.getCurrentUrl());
//				stepIndex += 1;
//				break;
//			}
//		}
//		String searchfieldValue = searchpage.getSearchBar().getAttribute("value");
//		System.out.println("searchfieldValue=" + searchfieldValue);
//		System.out.println("leftPaneitem=" + leftPaneitem);
//		System.out.println(StringUtils.containsIgnoreCase(driver.getCurrentUrl().trim(), leftPaneitem));
//		System.out.println(searchfieldValue.equalsIgnoreCase(leftPaneitem));
//		ExtentTestManager.getTest().log(Status.PASS,
//				"Step " + stepIndex + ": 'Search for item in bulk' text field value is " + searchfieldValue);
//		stepIndex += 1;
//		if ((StringUtils.containsIgnoreCase(searchpage.getItemSearchTerm().getText(), leftPaneitem))
//				&& (searchfieldValue.equalsIgnoreCase(leftPaneitem))) {
//			actualResult = "Clicked item is displayed in 'Search for item in bulk' text field and related product item list page is displayed.";
//			expectedResult = datatable.get("ExpectedResult").trim();
//		}
//
//		testResults(datatable.get("TestCase"));
//	}
//
//	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search", testcaseID = "TC6", runmode = "No")
//	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
//	public void verifyLeftPaneMouseHover(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
//	{
//		ExtentTestManager.startTest("Search_TestCase_" + datatable.get("TCID"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
//
//		ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex + ": Login into DollarDays.");
//		stepIndex += 1;
//
//	    // login
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.invokeLogin();
//		Thread.sleep(1000);
//
//		 SearchPage searchpage = new SearchPage(driver);
//
//		// Step 1 : Click in 'Search Bar' searchpage.getSearchBar().click();
//		Thread.sleep(1000);
//		ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex
//				+ ": Clicked in 'Search for items in bulk' field and 'Search Result' box is open. ");
//		stepIndex += 1;
//
//		String[] itemtoMouseOver = datatable.get("Leftpane Category").trim().split(";");
//		List<WebElement> leftPaneitems = searchpage.getSearchResult_leftPaneitems();
//
//		Actions action = new Actions(driver);
//		boolean itemfound = true;
//		for (WebElement spanTag : leftPaneitems) {
//			for (String item : itemtoMouseOver) {
//				if (spanTag.getText().equalsIgnoreCase(item)) {
//					ExtentTestManager.getTest().log(Status.PASS,
//							"Step " + stepIndex + ": mouse hover on item - " + item);
//					stepIndex += 1;
//					action.moveToElement(spanTag).build().perform();
//					Thread.sleep(1000);
//					ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex
//							+ ": right pane in 'Search Result' box is refreshed and displayed products related to  "
//							+ item);
//					stepIndex += 1;
//					for (String itemName : searchpage.getSearchResult_products()) {
//						if (!(StringUtils.containsIgnoreCase(itemName, item))) {
//							System.out.println("item not found" + item);
//							itemfound = false;
//							break;
//						}
//					}
//					if (!itemfound) {
//						break;
//					}
//					ExtentTestManager.getTest().log(Status.PASS,
//							"Step " + stepIndex + ": All products title contains text " + item);
//					stepIndex += 1;
//				}
//			}
//			if (!itemfound) {
//				break;
//			}
//		}
//		if (itemfound) {
//			actualResult = "Product item list getting updated in right pane in 'Search Result' box and product title contains text of Category name";
//			expectedResult = datatable.get("ExpectedResult").trim();
//		}
//		testResults(datatable.get("TestCase"));
//	}

//	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search", testcaseID = "TC7", runmode = "yes")
//	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
//	public void verifySearchbyleftPane(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
//	{
//		ExtentTestManager.startTest("Search_TestCase_" + datatable.get("TCID"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
//
//		ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex + ": Login into DollarDays.");
//		stepIndex += 1;
//
//		// login
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.invokeLogin();
//		Thread.sleep(1000);
//
//		SearchPage searchpage = new SearchPage(driver);
//		String searchitem = datatable.get("SearchItem").trim();
//		// Step 1 : Click in 'Search Bar'
//		searchpage.getSearchBar().sendKeys(searchitem);
//		Thread.sleep(1000);
//		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": Enter "+searchitem+" in 'search for items in bulk' input field.");
//		stepIndex += 1;
//		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": 'Search Result' box display right below 'Search for items in bulk' input field with listed product - "+ searchitem);
//		stepIndex += 1;
//		String leftPaneitem = datatable.get("Leftpane Category").trim();
//		
//		List<WebElement> leftPaneitems = searchpage.getSearchResult_leftPaneitems();
//
//		for (WebElement spanTag : leftPaneitems) 
//		{
//
//			if (spanTag.getText().equalsIgnoreCase(leftPaneitem))
//			{
//				ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": Click on Item - " + leftPaneitem + " in 'search result' box.");
//				stepIndex += 1;
//				spanTag.click();
//				Thread.sleep(1000);
//				ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex + ": page is navigated to product "+ leftPaneitem + " detail web page - " + driver.getCurrentUrl());
//				stepIndex += 1;
//				break;
//			}
//		}
//		String searchfieldValue = searchpage.getSearchBar().getAttribute("value");
//		System.out.println("searchfieldValue=" + searchfieldValue);
//		System.out.println("leftPaneitem=" + leftPaneitem);
//		System.out.println(searchfieldValue.equalsIgnoreCase(leftPaneitem));
//		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": 'Search for item in bulk' text field value is " + searchfieldValue);
//		stepIndex += 1;
//		
//		if ((StringUtils.containsIgnoreCase(searchpage.getItemSearchTerm().getText(), leftPaneitem))
//				&& (searchfieldValue.equalsIgnoreCase(leftPaneitem))) {
//			actualResult = "Clicked item is displayed in 'Search for item in bulk' text field and related product item list page is displayed.";
//			expectedResult = datatable.get("ExpectedResult").trim();
//		}
//		
//	    testResults(datatable.get("TestCase"));
//	}
//	
//	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search", testcaseID = "TC8", runmode = "yes")
//	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
//	public void verifySearchField(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
//	{
//		ExtentTestManager.startTest("Search_TestCase_" + datatable.get("TCID"));
//
//		ExtentTestManager.getTest().log(Status.INFO,
//				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
//
//		ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex + ": Login into DollarDays.");
//		stepIndex += 1;
//
//		// login
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.invokeLogin();
//		Thread.sleep(1000);
//
//		SearchPage searchpage = new SearchPage(driver);
//		String searchitem = datatable.get("SearchItem").trim();
//		// Step 1 : Click in 'Search Bar'
//		searchpage.getSearchBar().sendKeys(searchitem);
//		Thread.sleep(1000);
//		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": Enter "+searchitem+" in 'search for items in bulk' input field.");
//		stepIndex += 1;
//		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": 'Search Result' box display right below 'Search for items in bulk' input field with listed product - "+ searchitem);
//		stepIndex += 1;
//		searchpage.getSearchResult_firstItem().click();
//		Thread.sleep(2000);
//		
//		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": Clicked on product - "+ searchitem + " in 'search for items in bulk' input field.");
//		stepIndex += 1;
//
//		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": Web page is navigated to " + driver.getCurrentUrl());
//		stepIndex += 1;
//
//		if (searchpage.getProduct_title().equalsIgnoreCase(searchitem))
//		{
//			actualResult = "Product item is listed in 'Search Result' window and on clicking , it is navigated to 'Item detail' page";
//	    	expectedResult = datatable.get("ExpectedResult");
//		}
//		
//	    testResults(datatable.get("TestCase"));
//	}
//	
	//
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Search", testcaseID = "TC9", runmode = "yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void verifyShowMoreProductsClick(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException 
	{
		ExtentTestManager.startTest("Search_TestCase_" + datatable.get("TCID"));

		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));

		ExtentTestManager.getTest().log(Status.PASS, "Step " + stepIndex + ": Login into DollarDays.");
		stepIndex += 1;

		// login
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.invokeLogin();
//		Thread.sleep(1000);

		SearchPage searchpage = new SearchPage(driver);
		String searchitem = datatable.get("SearchItem").trim();
		// Step 1 : Click in 'Search Bar'
		Actions action = new Actions(driver);
		
		searchpage.getSearchBar().sendKeys(searchitem);
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": Enter "+searchitem+" in 'search for items in bulk' input field.");
		stepIndex += 1;
		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": 'Search Result' box display right below 'Search for items in bulk' input field with listed product - "+ searchitem);
		stepIndex += 1;
		
		WebElement moreBtn = searchpage.getSearchResult_ShopMoreBtn();
		System.out.println("Displaying shop more products.");
		System.out.println("Text="+moreBtn.getText());
		System.out.println("Enable="+moreBtn.isEnabled());
		System.out.println("Displayed="+moreBtn.isDisplayed());
		System.out.println("Selected="+moreBtn.isSelected());
		
		Thread.sleep(3000);
		
	//WebElement p = (WebElement)searchpage.getSearchResult_ShopMoreBtn().getRect();
//		action.moveToElement(searchpage.getSearchResult_ShopMoreBtn(), p.getX(), p.getY()).build().perform();;
//		Mouse mouse = ((HasInputDevices) driver).getMouse();
//        System.out.println(mouse.toString());
//        WebElement element1=searchpage.getSearchResult_ShopMoreBtn();
//        Coordinates  elementLocation = ((Locatable) element1).getCoordinates();
//        mouse.mouseMove(elementLocation);
	//	action.doubleClick(searchpage.getSearchResult_ShopMoreBtn()).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// This  will scroll down the page by  1000 pixel vertical		
//		if (driver instanceof JavascriptExecutor) {
//			((JavascriptExecutor) driver).executeScript("el = document.elementFromPoint("+p.+","+p.y+"); el.click();");
//		}
		
		searchpage.getSearchResult_ShopMoreBtn().sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		
		

		
		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": Clicked on 'Show More Products' button in 'Search Result' box.");
		stepIndex += 1;

		ExtentTestManager.getTest().log(Status.PASS,"Step " + stepIndex + ": Web page is navigated to " + driver.getCurrentUrl());
		stepIndex += 1;
        
		// 'Search for items in bulk' field value -
		String searchfieldValue = searchpage.getSearchBar().getAttribute("value");
//		if((StringUtils.containsIgnoreCase(searchpage.getItemSearchTerm().getText(), searchitem)) 
//				&& (searchfieldValue.equalsIgnoreCase(searchitem)))
//		{
//			actualResult = "Clicking on 'Show More Products', it is navigated to 'Item detail' page and 'Search for items in bulk' field has item name.";
//	    	expectedResult = datatable.get("ExpectedResult");
//		}
		
	   // testResults(datatable.get("TestCase"));
	}
	

	public void testResults(String testCase) {
		try {
			System.out.println("Actual Result : " + actualResult);
			System.out.println("Expected Result: " + expectedResult);
			Assert.assertEquals(actualResult, expectedResult);
			ExtentTestManager.getTest().log(Status.PASS, "TestCase : " + testCase + " executed successfully.");

		} catch (AssertionError e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Actual and Expected results mismatch");
			ExtentTestManager.getTest().log(Status.FAIL, "Error message: " + e.getMessage());
			Assert.assertEquals("true", "false");
		}
		ExtentTestManager.getTest().log(Status.INFO, "Expected Result:" + expectedResult);
		ExtentTestManager.getTest().log(Status.INFO, "Actual Result:" + actualResult);
	}
}
