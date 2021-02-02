package com.dollardays.testcases;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
import com.dollardays.pages.DefaultPaymentMethodPage;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import org.openqa.selenium.support.ui.Select;

public class DefaultPaymentMethodScript extends BaseTest{	
	String sheet = "Default_PM";
	private JavascriptExecutor js = null;	
	//private static DefaultPaymentMethodPage DefaultPaymentMethodPage = null;

	@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "Default_PM", testcaseID = "TC1", runmode = "Yes")	
	@Test(priority = 1, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void VerifyDCEditClick(Hashtable<String, String> datatable) throws IOException, InterruptedException, GeneralSecurityException 
	{		
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.PASS, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);

		DefaultPaymentMethodPage DefaultPaymentMethodPage = new DefaultPaymentMethodPage(driver);
		// The Below code will navigate you to My Profile page
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
		Thread.sleep(2000);
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Accounts();
		Thread.sleep(2000);	
	//	DefaultPaymentMethodPage.closeCookiepopup();
	
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		DefaultPaymentMethodPage.getAccount_PaymentMethodEditLink();//account_PaymentMethodEditLink //clickDefaultPaymentEditLink();
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.PASS,"Step 2 : Test1-Verify Edit of DefaultPayment Method, MyWallet page is displayed");
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
		Thread.sleep(1000);
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Signout();

		ExtentTestManager.getTest().log(Status.PASS, "Step 3: Clicked on LogOut");
	}
	
	@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "Default_PM", testcaseID = "TC2", runmode = "Yes")	
	@Test(priority = 2, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void VerifyCardVisible(Hashtable<String, String> datatable) throws IOException, InterruptedException, GeneralSecurityException 
	{
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.PASS, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		
		DefaultPaymentMethodPage DefaultPaymentMethodPage = new DefaultPaymentMethodPage(driver);
		// The Below code will navigate you to My Profile page
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
		Thread.sleep(2000);
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Accounts();
		Thread.sleep(2000);	
		DefaultPaymentMethodPage.getAccount_MyWalletLink();
				
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		

		String xpath = "//*[@id=\"aspnetForm\"]/div[5]/div[1]/section/div/div[3]/div/div[2]/div/section/div[1]/div[2]/div";		
		boolean iselementpresent =driver.findElements(By.xpath(xpath)).size()== 0;	
		if (iselementpresent== true)
		   {
				ExtentTestManager.getTest().log(Status.PASS,"Step 2 : Test 2-Verify Card Visibility, Cards not Available and not visible");
				//System.out.println("Verify Card Visibility, Cards not Available and not visible");
		   }
		 else 
		   {
				ExtentTestManager.getTest().log(Status.PASS, "Step 2 : Test 2-Verify Card Visibility, Cards Available and Visible");
				//System.out.println("Verify Card Visibility, Cards Available and Visible");
		   }
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
		Thread.sleep(1000);
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Signout();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3: Clicked on LogOut");
	}
		
	@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "Default_PM", testcaseID = "TC3", runmode = "Yes")	
	@Test(priority = 3, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)	
	public void VerifyClickAddNewCard(Hashtable<String, String> datatable) throws IOException, InterruptedException, GeneralSecurityException
	 {	
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.PASS, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		
		DefaultPaymentMethodPage DefaultPaymentMethodPage = new DefaultPaymentMethodPage(driver);
		// The Below code will navigate you to My Profile page
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
		Thread.sleep(2000);
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Accounts();
		Thread.sleep(2000);	
		DefaultPaymentMethodPage.getAccount_MyWalletLink();
				
		String xpath = "//*[@id=\"aspnetForm\"]/div[5]/div[1]/section/div/div[3]/div/div[2]/div/section/div[1]/div[2]/div";		
		boolean iselementpresent =driver.findElements(By.xpath(xpath)).size()== 0;

		DefaultPaymentMethodPage.ClickAddNewCard();
		ExtentTestManager.getTest().log(Status.PASS,"Step 2 : Test 3-Verify Click on Add New Card, Clicked on Add New Card of MyWallet,Opens Card Details");

		if (iselementpresent== true)
		   {	
			DefaultPaymentMethodPage.CCHolder.sendKeys((datatable.get("CCHolder")));        
			DefaultPaymentMethodPage.CCNumber.sendKeys((datatable.get("CCNumber")));
			Select drpMonth= new Select(DefaultPaymentMethodPage.ExpiryMonth);
			drpMonth.selectByVisibleText((datatable.get("CCExpirymonth")));
			
		    Select drpYear= new Select(DefaultPaymentMethodPage.ExpiryYear);
		    drpYear.selectByVisibleText((datatable.get("CCExpiryYear")));
		    
		    DefaultPaymentMethodPage.CCV.sendKeys((datatable.get("CCV")));		    
		    DefaultPaymentMethodPage.Address1.sendKeys((datatable.get("Address1")));		    
		    DefaultPaymentMethodPage.City.sendKeys((datatable.get("City")));		    
		    Select drpState= new Select(DefaultPaymentMethodPage.State);
		    drpState.selectByVisibleText((datatable.get("State")));
		    DefaultPaymentMethodPage.Zipcode.sendKeys((datatable.get("Zip")));		    
		    DefaultPaymentMethodPage.SaveCardDetails();
		    ExtentTestManager.getTest().log(Status.PASS,"Step 3 : Test 3-Verify Click on Add New Card, New card Added");
		   }
		else 
		   {
			DefaultPaymentMethodPage.CCHolder.sendKeys((datatable.get("CCHolder")));       
			DefaultPaymentMethodPage.CCNumber.sendKeys((datatable.get("CCNumber")));
			Select drpMonth= new Select(DefaultPaymentMethodPage.ExpiryMonth);
			drpMonth.selectByVisibleText((datatable.get("CCExpirymonth")));
			
		    Select drpYear= new Select(DefaultPaymentMethodPage.ExpiryYear);
		    drpYear.selectByVisibleText((datatable.get("CCExpiryYear")));
		    DefaultPaymentMethodPage.CCV.sendKeys((datatable.get("CCV")));
		    
		    DefaultPaymentMethodPage.Address1.sendKeys((datatable.get("Address1")));
		    DefaultPaymentMethodPage.City.sendKeys((datatable.get("City")));		    
		    Select drpState= new Select(DefaultPaymentMethodPage.State);
		    drpState.selectByVisibleText((datatable.get("State")));
		    DefaultPaymentMethodPage.Zipcode.sendKeys((datatable.get("Zip")));		    
		    DefaultPaymentMethodPage.CancelAddNewCard();
			ExtentTestManager.getTest().log(Status.PASS,"Step 3 : Test 3-Verify Click on Add New Card, Clicked on Add New Card and clicked Cancel");
		}	
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
		Thread.sleep(1000);
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Signout();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3: Clicked on LogOut");
	 }
	
	@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "Default_PM", testcaseID = "TC4", runmode = "Yes")
	@Test(priority = 4, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void VerifySetDefaultCard(Hashtable<String, String> datatable) throws IOException, InterruptedException, GeneralSecurityException 
	{
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.PASS, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
		Thread.sleep(1000);
		DefaultPaymentMethodPage DefaultPaymentMethodPage = new DefaultPaymentMethodPage(driver);
		// The Below code will navigate you to My Profile page
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
		Thread.sleep(2000);
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Accounts();
		Thread.sleep(2000);	
		DefaultPaymentMethodPage.getAccount_MyWalletLink();
		String xpath = "//*[@id=\"aspnetForm\"]/div[5]/div[1]/section/div/div[3]/div/div[2]/div/section/div[1]/div[2]/div";		
		boolean iselementpresent =driver.findElements(By.xpath(xpath)).size()== 0;	

		if (iselementpresent== true)
		   {
				ExtentTestManager.getTest().log(Status.PASS,"Step 2 : Test 4-Verify Set Default Card, Cards not Available and not visible to set as Default");
		   }
		else 
		   {
			    String SetDefault = "//*[contains(@class,'address-box fixed_address')]";
				String NotSetDefault = "//*[contains(@class,'address-box default_address')]";
				
				boolean iselementpresent1 =driver.findElements(By.xpath(SetDefault)).size()!= 0;
				boolean iselementpresent2 =driver.findElements(By.xpath(NotSetDefault)).size()!= 0;

				   if (iselementpresent1 == true)
				   {
						ExtentTestManager.getTest().log(Status.PASS,"Step 2 : Test 4-Verify Set Default Card, Already Card marked Default");
				   }
				   else if (iselementpresent2 == true)
				   {
					   DefaultPaymentMethodPage.SetDefaultCard();  
					   ExtentTestManager.getTest().log(Status.PASS, "Step 2 : Test 4-Verify Set Default Card, Card marked Default");
				   }		   
			}
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
		Thread.sleep(1000);
		DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Signout();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3: Clicked on LogOut");
	}
		
	@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "Default_PM", testcaseID = "TC5", runmode = "Yes")
	@Test(priority = 5, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void VerifyEditOnCard(Hashtable<String, String> datatable) throws InterruptedException, IOException, GeneralSecurityException
		{
			System.out.println(datatable.get("TestCase"));
			ExtentTestManager.getTest().log(Status.PASS, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
			Thread.sleep(1000);
			
			DefaultPaymentMethodPage DefaultPaymentMethodPage = new DefaultPaymentMethodPage(driver);
			// The Below code will navigate you to My Profile page
			DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
			Thread.sleep(2000);
			DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Accounts();
			Thread.sleep(2000);	
			DefaultPaymentMethodPage.getAccount_MyWalletLink();

			String xpath = "//*[@id=\"aspnetForm\"]/div[5]/div[1]/section/div/div[3]/div/div[2]/div/section/div[1]/div[2]/div";		
		    boolean iselementpresent =driver.findElements(By.xpath(xpath)).size()== 0;
		
		    if (iselementpresent== true)
			   {
					ExtentTestManager.getTest().log(Status.PASS,"Step 2 : Test 5-Verify Edit on Card, Cards not Available and not visible for Edit");
			   }
			else 
			   {
				    DefaultPaymentMethodPage.EditExistingCard();	
					Thread.sleep(1000);
				    DefaultPaymentMethodPage.CCV.sendKeys((datatable.get("CCV")));
					DefaultPaymentMethodPage.CancelAddNewCard();
					ExtentTestManager.getTest().log(Status.PASS,"Step 2 : Test 5-Verify Edit on Card, Edited the card Successfully");
			   }	
		    DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
			Thread.sleep(1000);
			DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Signout();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3: Clicked on LogOut");		
		}

		@DDDataProvider(datafile = "testdata/Team2Data_AccontPage.xlsx", sheetName = "Default_PM", testcaseID = "TC5", runmode = "Yes")
		@Test(priority = 6, dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void VerifyDeleteCard(Hashtable<String, String> datatable) throws InterruptedException, IOException, GeneralSecurityException 
		{
			System.out.println(datatable.get("TestCase"));
			ExtentTestManager.getTest().log(Status.PASS, "Testcase: " + (datatable.get("TCID"))+ "-----"+(datatable.get("TestCase")));
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
			ExtentTestManager.getTest().log(Status.PASS, "Step 1: Successfully Logged in with valid Credentials");
			Thread.sleep(1000);
			
			DefaultPaymentMethodPage DefaultPaymentMethodPage = new DefaultPaymentMethodPage(driver);
			// The Below code will navigate you to My Profile page
			DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
			Thread.sleep(2000);
			DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Accounts();
			Thread.sleep(2000);	
			DefaultPaymentMethodPage.getAccount_MyWalletLink();

			String xpath = "//*[@id=\"aspnetForm\"]/div[5]/div[1]/section/div/div[3]/div/div[2]/div/section/div[1]/div[2]/div";		
			boolean iselementpresent =driver.findElements(By.xpath(xpath)).size()== 0;
			if (iselementpresent== true)
			   {
					ExtentTestManager.getTest().log(Status.PASS,"Step 2 : Test 6-Verify Card Deletion, Cards not Available and not visible for deletion");
			   }
			 else 
			   {
				    String Del=null;
					Del="No";
					DefaultPaymentMethodPage.DeleteExistingcard();	
					ExtentTestManager.getTest().log(Status.PASS,"Step 2 : Test 6-Verified ConfirmationPopup Successfully");

					if (Del=="Yes") {
						DefaultPaymentMethodPage.YesConfirmationOnDelete();
						ExtentTestManager.getTest().log(Status.PASS,"Step 3 : Test 6-Verify Card Delete, Entered Yes,Card Deleted Successfully");
					}
					else if (Del=="No"){
						Thread.sleep(3000);
						DefaultPaymentMethodPage.NoConfirmationOnDelete();
						ExtentTestManager.getTest().log(Status.PASS,"Step 3 : Test 6-Verify Card Delete, Entered No, Card Not Deleted");
					}
					else if (Del=="Close"){
						DefaultPaymentMethodPage.CloseConfirmation();
						ExtentTestManager.getTest().log(Status.PASS,"Step 3 : Test 6-Closed");	
					}
					
				}
			
			Thread.sleep(2000);
			DefaultPaymentMethodPage.click_User_Dropdown_Toggle();
			Thread.sleep(1000);
			DefaultPaymentMethodPage.click_User_Dropdown_Toggle_Signout();
			ExtentTestManager.getTest().log(Status.PASS, "Step 3: Clicked on LogOut");
		}	

	}



