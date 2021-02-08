package com.dollardays.testcases;

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

public class MenuTestCase extends BaseTest {
	
	private String actualResult = "true";
	private String expectedResult = "false";
	private int stepIndex = 4;
	
	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "Menu",  testcaseID = "TC6", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void validate_Mobile_Menu(Hashtable<String, String> datatable) throws Exception{
		
		ExtentTestManager.startTest("Menu_TestCase_" +datatable.get("TCID"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 actualResult = "";
		 expectedResult = "";
		
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
		
		//************************ TC1 start *************************//
		if(datatable.get("Verify Categories").equals("Yes"))
        {
			validateMainCategories(menuPage);
			expectedResult = datatable.get("ExpectedResult").trim();
		}
		//****************** TC1 End ***************************//
		
		
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
		if(datatable.get("isItemAddedtoCart").trim().equals("Yes"))
		{
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
		
		// TC6 - Verify no. of items/page is matched with number selected in 'View' drop down.
		if((!(datatable.get("No of Item per Page").equals(""))) && (datatable.get("No of Item per Page") != null))
		{
			// TC 7 - Paging
			if((!(datatable.get("Paging").equals(""))) && (datatable.get("Paging") != null))
			{
				
			}
			else  // TC6
			{
				if(isViewDD_Selected(menuPage,datatable.get("No of Item per Page").trim()))
				{
					actualResult = "Number of items displayed as per selected number in 'View' dropdown";
				}
				else
				{
					actualResult = "Number of items not displayed as per selected number in 'View' dropdown";
				}
				expectedResult = datatable.get("ExpectedResult").trim();
			}
			
		}
		
		// call assert() and return test output
		testResults(datatable.get("TestCase"));	
	}
	
	// TC1 
	public void validateMainCategories(MenuPage menuPage)
	{
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
	}
	
	// called by TC2,TC3,TC4,TC5
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
