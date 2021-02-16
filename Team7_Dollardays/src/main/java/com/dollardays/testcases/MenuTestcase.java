package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.MenuPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class MenuTestcase extends BaseTest {
	
	private String actualResult = "true";
	private String expectedResult = "false";
	private int stepIndex = 4;
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Menu",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void menu_VerifyMenuItems(Hashtable<String, String> datatable) throws Exception{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 actualResult = "";
		 expectedResult = "";
		 MenuPage menuPage = new MenuPage(driver);
		 openMobileMenu(datatable);
	
		// get menu Categories 
			List<String> catList = menuPage.getMainCategories();
			actualResult ="Total 4 Categories-";
			if(catList.size() != 0)
			{
				for(int i=0;i<catList.size();i++)
				{
					actualResult += (catList.get(i)).trim();
					if(i<(catList.size()-1))
					{
						actualResult += ",";
					}
				}
			}		
			expectedResult = datatable.get("ExpectedResult").trim();
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"));
		
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Menu",  testcaseID = "TC2", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void menu_VerifyShopAllBtn(Hashtable<String, String> datatable) throws Exception{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 actualResult = "";
		 expectedResult = "";
		 stepIndex = 4;
		 MenuPage menuPage = new MenuPage(driver);
		 openMobileMenu(datatable);
	

		//****************** used by TC - 2,3,4,5,6,7,8 ********************//
		// Search and open Item Page 
		if(datatable.get("Item flow") != null && !(datatable.get("Item flow").equals("")))
		{
			searchAndOpen_ItemPage(datatable.get("Item flow"),menuPage);
			String url = driver.getCurrentUrl();
			System.out.println("Current URL is : " + url);
			if(url.equals(datatable.get("TargetURL").trim()))
			{
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Menu Item Page URL :" + url + " is displayed.");
				stepIndex += 1;
			}
		}
		
		// Search Product on Item page to click on 'Add to cart' button - TC2,TC3,TC4
		addtoCart(menuPage,datatable.get("ProductName"));
		Thread.sleep(1000);
		if(isItemAddedtoCart(datatable.get("ProductName").trim(),menuPage))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": product -" + datatable.get("ProductName").trim() + " is added to cart.");
			stepIndex += 1;
			actualResult = "Product is added to cart by clicking 'Shop All' button in menu";
		}
		else
		{
			actualResult = "Product is not added to cart";
		}
			expectedResult = datatable.get("ExpectedResult").trim();
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"));
		
	}
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Menu",  testcaseID = "TC3", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void menu_VerifySubCategories(Hashtable<String, String> datatable) throws Exception{
		stepIndex = 4;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 actualResult = "";
		 expectedResult = "";
		 MenuPage menuPage = new MenuPage(driver);
		 openMobileMenu(datatable);
		
		//****************** used by TC - 2,3,4,5,6,7,8 ********************//
		// Search and open Item Page 
		if(datatable.get("Item flow") != null && !(datatable.get("Item flow").equals("")))
		{
			searchAndOpen_ItemPage(datatable.get("Item flow"),menuPage);
			String url = driver.getCurrentUrl();
			System.out.println("Current URL is : " + url);
			if(url.equals(datatable.get("TargetURL").trim()))
			{
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Menu Item Page URL :" + url + " is displayed.");
				stepIndex += 1;
			}
		}
		
		// Search Product on Item page to click on 'Add to cart' button - TC2,TC3,TC4
		addtoCart(menuPage,datatable.get("ProductName"));
		Thread.sleep(1000);
		
		if(isItemAddedtoCart(datatable.get("ProductName").trim(),menuPage))
		{
			ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": product -" + datatable.get("ProductName").trim() + " is added to cart.");
			stepIndex += 1;
			actualResult = "Product is added to cart";
		}
		else
		{
			actualResult = "Product is not added to cart";
		}
			expectedResult = datatable.get("ExpectedResult").trim();
			
		// call assert() and return test output
		testResults(datatable.get("TestCase"));
		
	}

	//4
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Menu",  testcaseID = "TC4", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void menu_AddItemtoCart(Hashtable<String, String> datatable) throws Exception{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 actualResult = "";
		 expectedResult = "";
		 MenuPage menuPage = new MenuPage(driver);
		 openMobileMenu(datatable);
	
		
		//****************** used by TC - 2,3,4,5,6,7,8 ********************//
		// Search and open Item Page 
		if(datatable.get("Item flow") != null && !(datatable.get("Item flow").equals("")))
		{
			searchAndOpen_ItemPage(datatable.get("Item flow"),menuPage);
			String url = driver.getCurrentUrl();
			System.out.println("Current URL is : " + url);
			if(url.equals(datatable.get("TargetURL").trim()))
			{
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Menu Item Page URL :" + url + " is displayed.");
				stepIndex += 1;
			}
		}
		
		// Search Product on Item page to click on 'Add to cart' button - TC2,TC3,TC4
			addtoCart(menuPage,datatable.get("ProductName"));
			Thread.sleep(1000);
			if(isItemAddedtoCart(datatable.get("ProductName").trim(),menuPage))
			{
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": product -" + datatable.get("ProductName").trim() + " is added to cart.");
				stepIndex += 1;
				actualResult = "Product is added to cart";
			}
			else
			{
				actualResult = "Product is not added to cart";
			}
			expectedResult = datatable.get("ExpectedResult").trim();
				
		// call assert() and return test output
		testResults(datatable.get("TestCase"));
		
	}
	
	//5
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Menu",  testcaseID = "TC5", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void menu_ValidateSorting(Hashtable<String, String> datatable) throws Exception{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 actualResult = "";
		 expectedResult = "";
		 MenuPage menuPage = new MenuPage(driver);
		 openMobileMenu(datatable);
	
		
		//****************** used by TC - 2,3,4,5,6,7,8 ********************//
		// Search and open Item Page 
		if(datatable.get("Item flow") != null && !(datatable.get("Item flow").equals("")))
		{
			searchAndOpen_ItemPage(datatable.get("Item flow"),menuPage);
			String url = driver.getCurrentUrl();
			System.out.println("Current URL is : " + url);
			if(url.equals(datatable.get("TargetURL").trim()))
			{
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Menu Item Page URL :" + url + " is displayed.");
				stepIndex += 1;
			}
		}
		// TC5 - Sorting
		if((!(datatable.get("SortItem").equals(""))) && (datatable.get("SortItem") != null))
		{
			if(isItemSorted(menuPage,datatable.get("SortItem").trim()))
			{
				actualResult = "Items are sorted in Alphabetically order by name";
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Items are sorted in Alphabetically order by name ");
				stepIndex += 1;
			}
			else
			{
				actualResult = "Items are not sorted in Alphabetically order by name";
			}
			expectedResult = datatable.get("ExpectedResult").trim();
		}
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"));
		
	}
	
	//6
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Menu",  testcaseID = "TC6", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void menu_Verify_NoOfItemPerPage(Hashtable<String, String> datatable) throws Exception{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 actualResult = "";
		 expectedResult = "";
		 MenuPage menuPage = new MenuPage(driver);
		 openMobileMenu(datatable);
	
		//****************** used by TC - 2,3,4,5,6,7,8 ********************//
		// Search and open Item Page 
		if(datatable.get("Item flow") != null && !(datatable.get("Item flow").equals("")))
		{
			searchAndOpen_ItemPage(datatable.get("Item flow"),menuPage);
			String url = driver.getCurrentUrl();
			System.out.println("Current URL is : " + url);
			if(url.equals(datatable.get("TargetURL").trim()))
			{
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Menu Item Page URL :" + url + " is displayed.");
				stepIndex += 1;
			}
		}
		
		// TC6 - Verify no. of items/page is matched with number selected in 'View' drop down.
		if((!(datatable.get("NoOfItemPerPage").equals(""))) && (datatable.get("NoOfItemPerPage") != null))
		{
			// TC6 - Verify no. of items/page is matched with number selected in 'View' drop down.
			if(isViewDD_Selected(menuPage,datatable.get("NoOfItemPerPage").trim()))
			{
				actualResult = "Number of items displayed as per selected number in 'View' dropdown";
			}
			else
			{
				actualResult = "Number of items not displayed as per selected number in 'View' dropdown";
			}
			expectedResult = datatable.get("ExpectedResult").trim();	
		}
		// call assert() and return test output
		testResults(datatable.get("TestCase"));	
	}
	
	//7
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Menu",  testcaseID = "TC7", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void menu_Verify_Paging(Hashtable<String, String> datatable) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 actualResult = "";
		 expectedResult = "";
		 stepIndex =4;
		 MenuPage menuPage = new MenuPage(driver);
		 openMobileMenu(datatable);
		
		//****************** used by TC - 2,3,4,5,6,7,8 ********************//
		// Search and open Item Page 
		if(datatable.get("Item flow") != null && !(datatable.get("Item flow").equals("")))
		{
			searchAndOpen_ItemPage(datatable.get("Item flow"),menuPage);
			String url = driver.getCurrentUrl();
			System.out.println("Current URL is : " + url);
			if(url.equals(datatable.get("TargetURL").trim()))
			{
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Menu Item Page URL :" + url + " is displayed.");
				stepIndex += 1;
			}
		}
		
		
		//TC7 - Verify Paging is working
		if((!(datatable.get("NoOfItemPerPage").equals(""))) && (datatable.get("NoOfItemPerPage") != null))
		{
				
			String noOfItemPerPage =  (datatable.get("NoOfItemPerPage").trim()).substring(0,2);
			System.out.println("noOfItemPerPage =" + noOfItemPerPage);
			Select viewDD = new Select(menuPage.getViewDropdown());
			viewDD.selectByVisibleText(noOfItemPerPage);
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Select "+ noOfItemPerPage  + " in 'View' dropdown.");
			stepIndex += 1;
			if(isPage_Selected(menuPage))
			{
				actualResult = "Paging is working";
			}
				else
			{
				actualResult = "Paging is not working";
			}
			expectedResult = datatable.get("ExpectedResult").trim();	
		}
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"));
		
	}
	
	//8
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Menu",  testcaseID = "TC8", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void menu_AddItemToCart_withoutLogin(Hashtable<String, String> datatable) throws Exception{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 actualResult = "";
		 expectedResult = "";
		 stepIndex = 4;
		 MenuPage menuPage = new MenuPage(driver);
		 System.out.println(datatable.get("TestCase"));
			ExtentTestManager.getTest().log(Status.INFO,
					"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
			
			// Click on Menu  
			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Click on hamberger icon to open menu panel");
			menuPage.getMobileMenu().click();
			Thread.sleep(1000);
	
		
		//****************** used by TC - 2,3,4,5,6,7,8 ********************//
		// Search and open Item Page 
		if(datatable.get("Item flow") != null && !(datatable.get("Item flow").equals("")))
		{
			searchAndOpen_ItemPage(datatable.get("Item flow"),menuPage);
			String url = driver.getCurrentUrl();
			System.out.println("Current URL is : " + url);
			if(url.equals(datatable.get("TargetURL").trim()))
			{
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Menu Item Page URL :" + url + " is displayed.");
				stepIndex += 1;
			}
		}
		
		if(!(isItemaddedWithoutLogin(menuPage,datatable.get("ProductName").trim())))
		{
			actualResult = "navigated to Login page when click on 'Login to Buy' button below item name in item list page";
			ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": navigated to Login page when clicked on 'Login to Buy' button below item name in item list page ");
			stepIndex += 1;
		}
		else
		{
			actualResult = "It is not navigated to Login page when click on 'Login to Buy' button below item name in item list page";
		}
			expectedResult = datatable.get("ExpectedResult").trim();
		
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"));
		
	}
	
	// called by TC2,TC3,TC4,TC5,TC6,TC7,TC8 : this method search item and click on the item to open item page which has related item list to shop.
	public void searchAndOpen_ItemPage(String itemFlow,MenuPage menuPage) throws InterruptedException
	{
		String[] itemFlowArray = itemFlow.split("->");
		List<WebElement> mainMenuItems = menuPage.getMainMenuItems();
			
	    // Clicked on main menu
		for(WebElement mainMenuItem:mainMenuItems)
		{
			
			if(mainMenuItem.getText().trim().equalsIgnoreCase(itemFlowArray[0].trim()))
			{
				System.out.println("Item found:" + mainMenuItem.getText());
				System.out.println("Item to Click in Main Menu = "+ itemFlowArray[0].trim());
				mainMenuItem.click();
				ExtentTestManager.getTest().log(Status.PASS, "Step 3: Clicked on Main Menu Item -" + itemFlowArray[0].trim() + " in Main Menu Panel.");
				Thread.sleep(1000);
				break;
			}
		}
		
		// Click on sub menu items - sub menu items can go to multiple layer 
		//like - petSupplies(one of main menu Item)-> click on 'Pet Supplies' it will open sub menu panel : Cat Supplies,Dog Supplies
		//Dog Supplies(sub menu item- layer1) - > click on 'Dog Supplies' it will open list of all item of 'Dog' Supplies 
		//Dog collar(sub menu item- Layer 2) -> clicking on this will open Menu item page.            
		int i = 1;
		while (i < itemFlowArray.length) 
		{
			if(!(itemFlowArray[i].contains("link on web page"))) {
			  List<WebElement> subMenuItemList = menuPage.getsubMenuItems();
			  WebElement subMenuItem = menuPage.getMenuItem(itemFlowArray[i],subMenuItemList.get(i-1));
			  if(subMenuItem != null)
			  {
				  System.out.println("Sub Menu Item found:" + subMenuItem.getText());
				  System.out.println("Menu Item to click in Sub-Menu = "+ itemFlowArray[i].trim());
				  subMenuItem.click();
				  ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Clicked on Sub Menu Item - " + itemFlowArray[i].trim() + " in Sub Menu Panel.");
				  stepIndex += 1;
				  Thread.sleep(1000);
			  }
			}
			else  // item link is available on web page. itemFlowArray[i] = Backpacks-link on web page : here 'Backpacks' is link(<a>) on web page.
			{
				String linkName = ((itemFlowArray[i].split("-"))[0]).trim();
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": It is navigated to " + driver.getCurrentUrl() + " to click on link" + "'"+ linkName+"'.");
				stepIndex += 1;
				WebElement itemLink=menuPage.getWebPageLink(linkName,menuPage.getprogramMenu_WebpageLinks());
				if(itemLink != null)
				{
					itemLink.click();
					Thread.sleep(1000);
					ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Clicked on link " + linkName);
					stepIndex += 1;
				}		
			}
			  i++;
		}
	}
	
	public boolean isItemAddedtoCart(String productName,MenuPage menuPage)
	{
		WebElement dropdownMenu = menuPage.addedItem_cartDDMenu();
		if(dropdownMenu != null)
		{
			String div_style=dropdownMenu.getAttribute("style");
			if(div_style.contains("block"))  // cart drop-down menu will display if Style = ....display:block is there else it will display:none
			{
				System.out.println("Product is added to cart.");
				return true;
			}
		}
      return false;
		
	}
	
	public void addtoCart(MenuPage menuPage,String ProductName )
	{
		System.out.println("Search for Product : " + ProductName.trim());
		List<WebElement> productList = menuPage.getProducts_List();
		int productTitleIndex = menuPage.getProductTitleIndex(ProductName.trim(),productList);
		WebElement addtocartBtn = menuPage.getAddtoCartbtn(productList,productTitleIndex);
		ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Clicked on 'Add to Cart' button to add product" + ProductName + " to cart.");
		stepIndex += 1;
		// Add to cart 
		addtocartBtn.click();
	}
	
	public boolean isItemSorted(MenuPage menuPage,String sortBy) throws InterruptedException
	{
		Select sortDD = new Select(menuPage.getSortDropdown());
		String[] productlist = menuPage.getProductTitles(menuPage.getProducts_List());
		Arrays.sort(productlist);
		System.out.println("Sorted by Code:" + Arrays.toString(productlist));
		ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex +": Select 'Alphabetically order by name' option in 'Sort By' dropdown. ");
		stepIndex += 1;
		sortDD.selectByVisibleText(sortBy);
		Thread.sleep(1000);
		String[] sortedproductlist = menuPage.getProductTitles(menuPage.getProducts_List());
		System.out.println("Sorted Product List by Page:" + Arrays.toString(sortedproductlist));
		if((Arrays.toString(productlist)).equals(Arrays.toString(sortedproductlist)))
		{
			System.out.println("Items are sorted Alphabatically.");
			return true;
		}
				
		return false;
	}
	
	public boolean isViewDD_Selected(MenuPage menuPage,String noOfItemPerPage) throws InterruptedException
	{
		List<String> noOfItemPerPageList = Arrays.asList(noOfItemPerPage.split(","));
		Select viewDD = new Select(menuPage.getViewDropdown());
		boolean isSelected=false;
		String productPerPage="";
		for(String no: noOfItemPerPageList)
		{
			
			viewDD.selectByVisibleText(no);
			Thread.sleep(1500);
			
			
			 ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Select '"+ no +"' in 'View' Drop Down.");
			 stepIndex += 1;
			 productPerPage = Integer.toString(menuPage.getProducts_List().size());
			 System.out.println("Number-"+no);
			 System.out.println("productPerPage-"+productPerPage);
			 if((no.equals(productPerPage)))
			 {
				 ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Number of product displayed per page is "+ productPerPage);
				 stepIndex += 1;
				 isSelected= true;
			 }
			 else
			 {
				 return false;
			 }
		 
		}
		return isSelected;
	}
	
	//TC 7 - paging 
	public boolean isPage_Selected(MenuPage menuPage) throws InterruptedException
	{
		try
		{
			
			WebElement lastPageIcon = menuPage.getLastPage_Icon(menuPage.getPagingContainer());
			if(lastPageIcon !=null)
			{
				// click on Last Page
				lastPageIcon.click();
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Clicked on 'Last Page' Icon.");
				stepIndex += 1;
				int totalPages = menuPage.getTotalPages(menuPage.getPagingContainer());
				
				// Click on First Page
				WebElement firstPageIcon = menuPage.getFirstPage_Icon(menuPage.getPagingContainer());
				firstPageIcon.click();
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Clicked on 'First Page' Icon.");
				stepIndex += 1;
				System.out.println("Page Size="+ totalPages);
				
				// click on 'NextPage'
				WebElement pagelink;
				for(int i=1;i<totalPages;i++)
				{
					pagelink = menuPage.getNextPage_Icon(menuPage.getPagingContainer());
					pagelink.click();
				}
				System.out.println("Next Page link is clicked " + totalPages + " times.");
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Clicked on 'Next Page' Icon " + totalPages + " times.");
				stepIndex += 1;
				
				// Click on Previous page link
				System.out.println("Click on previous Page link");
				for(int i=1;i<totalPages;i++)
				{
					pagelink = menuPage.getPreviousPage_Icon(menuPage.getPagingContainer());
					pagelink.click();
				}
				System.out.println("Previous Page link is clicked " + totalPages + " times.");
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Clicked on 'Previous Page' Icon " + totalPages + " times.");
				stepIndex += 1;
				// Click on every page number
				for(int i=2;i<=totalPages;i++)
				{
					pagelink = menuPage.getPageByNumber(menuPage.getPagingContainer(),Integer.toString(i));
					pagelink.click();
				}
				System.out.println("Clicked on each page number.");
				ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Clicked on each page number.");
				stepIndex += 1;
			}
		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(Status.FAIL, "Step "+ stepIndex+": Error occured. Error :" + e.getMessage());
			stepIndex += 1;
			return false;
		}
		return true;
	}
	
	public void openMobileMenu(Hashtable<String, String> datatable) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException 
	{
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.INFO,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		
		// Creating Object of Login Page to login into dollar days
		LoginPage loginPage = new LoginPage(driver);

		ExtentTestManager.getTest().log(Status.PASS, "Step1: Login into DollarDays.");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
	
		// Click on Menu  
		ExtentTestManager.getTest().log(Status.PASS, "Step 2: Click on hamberger icon to open menu panel");
		MenuPage menuPage = new MenuPage(driver);
		menuPage.getMobileMenu().click();
		Thread.sleep(1000);
		
	}
	
	public boolean isItemaddedWithoutLogin(MenuPage menuPage,String ProductName ) throws InterruptedException
	{
		System.out.println("Search for Product : " + ProductName.trim());
		ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Search for Product - " + ProductName + " to add to the cart.");
		stepIndex += 1;
		List<WebElement> productList = menuPage.getProducts_List();
		int productTitleIndex = menuPage.getProductTitleIndex(ProductName.trim(),productList);
		WebElement logintoBuyBtn = menuPage.getLogintoBuybtn(productList,productTitleIndex);
		if(logintoBuyBtn != null)
		{
		ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Clicked on 'LOGIN to BUY' button to add product " + ProductName + " to cart.");
		stepIndex += 1;
		
		// login to buy button
		logintoBuyBtn.click();
		Thread.sleep(1000);
		if(driver.getCurrentUrl().trim().equals("https://www.dollardays.com/sitelogin.aspx"))
		{
			return false;
		}
		return true;
		}else
		{
			ExtentTestManager.getTest().log(Status.PASS, "Step "+ stepIndex+": Product - " + ProductName + " is not found in the list.Please select other product.");
			stepIndex += 1;
			return true;
		}
	}

	public void testResults(String testCase)
	{
		try
		{
			System.out.println("Actual Result : " + actualResult);
			System.out.println("Expected Result: " + expectedResult);
			Assert.assertEquals(actualResult, expectedResult);
			ExtentTestManager.getTest().log(Status.PASS,"TestCase : "+ testCase + " executed successfully.");
			
		} catch (AssertionError e) {
			ExtentTestManager.getTest().log(Status.FAIL, " Actual and Expected results mismatch");
			ExtentTestManager.getTest().log(Status.FAIL, "Error message: " + e.getMessage());
			Assert.assertEquals("true","false");
		}
		ExtentTestManager.getTest().log(Status.INFO, "Expected Result:" + expectedResult);
		ExtentTestManager.getTest().log(Status.INFO, "Actual Result:" + actualResult);
	}
	
}
