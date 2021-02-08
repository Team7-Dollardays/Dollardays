package com.dollardays.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Hashtable;
import java.util.List;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.SubmitRequestPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;

///*
// * ClassName : SubmitRequestTest 
// * Description : SubmitRequestTestcase Class runs all test cases from 'testdata/testdata1.xls':SheetName - 'submitRequest'. 
// * This class runs all test cases to validate 'https://www.dollardays.com/case.aspx' web page.
// * This class use loginPage to login then use SubmitRequestPage to get page web elements.
// * TesterName : Shachi Bhagwat
// * Date : Jan-22-2021
// */
public class SubmitRequestTest extends BaseTest{

	@DDDataProvider(datafile = "testdata/testdata.xlsx", sheetName = "SubmitRequest",  testcaseID = "", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void validate_SubmitRequest_WebPage(Hashtable<String, String> datatable) throws Exception{
		ExtentTestManager.startTest("SubmitRequest-" +datatable.get("TCID") + ":" + datatable.get("TestCase"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if((datatable.get("TestScenario").equalsIgnoreCase("nonCaptcha")))
		{
		String emailErrMs = "Email should not be blank !";
		String requestTypeErrMsg = "Please select reason.";
		String messagesErrMsg = "Message should not be blank !";
		String captchaErrMsg = "Captcha validation is required.";
		String successMsg = "Case created successfully.";
		String actualText = "";
		String expectedText = "";
		
		System.out.println(datatable.get("TestCase"));
		ExtentTestManager.getTest().log(Status.PASS,
				"Testcase: " + (datatable.get("TCID")) + "-----" + (datatable.get("TestCase")));
		
		// Creating Object of Login Page  to login into dollar days
		LoginPage loginPage = new LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step1: Login into DollarDays.");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));	

		// Creating Object of SubmitPage to access Web Elements of 'https://www.dollardays.com/case.aspx'
		SubmitRequestPage submitPage = new SubmitRequestPage(driver);
	
		ExtentTestManager.getTest().log(Status.PASS, "Step2: Click on User Icon to open User Dropdown Toggle.");
		submitPage.getUserDropdownToggle().click();
		
		// Navigate to 'Submit a Request' page
		ExtentTestManager.getTest().log(Status.PASS, "Step3: Click on 'Submit a Request' Link.");
		submitPage.getUserDropdownToggleSubmitRequestLink().click();;
		
		// Verify if page is loaded successfully 
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step4: Page is Navigated to " + driver.getCurrentUrl());
		
		if ((datatable.get("PageURL") != null && !(datatable.get("PageURL").equals("")))) {
			actualText = driver.getCurrentUrl();
			expectedText = "https://www.dollardays.com/case.aspx";
			ExtentTestManager.getTest().log(Status.PASS, "User entered Email. " + "Email ID:" + datatable.get("Email"));
		}
		
		if ((datatable.get("CaptchaValidationMsg") != null && !(datatable.get("CaptchaValidationMsg").equals("")))) {
			expectedText = captchaErrMsg;
			ExtentTestManager.getTest().log(Status.PASS, "User entered Email. " + "Email ID:" + datatable.get("CaptchaValidationMsg"));
		}
		
		// Clear Email Id Field then Enter Email id
		if ((datatable.get("Email") != null && !(datatable.get("Email").equals("")))) {
			if((datatable.get("TestScenario").equalsIgnoreCase("Captcha")))
			{
				submitPage.getEmailtxtBox().clear();
				submitPage.getEmailtxtBox().sendKeys(datatable.get("Email").trim());
				ExtentTestManager.getTest().log(Status.PASS, "User entered Email. " + "Email ID:" + datatable.get("Email"));
			}
			else
			{
				actualText = submitPage.getEmailtxtBox().getAttribute("value").trim();
				expectedText = (datatable.get("Email")).trim();
				ExtentTestManager.getTest().log(Status.PASS, "Verify Email Textbox. " + "Given Email ID:" + datatable.get("Email"));
			}
		}
		
		// Clear Email field to validate all required Field empty Test Case
		if ((datatable.get("ClearEmailField") != null && !(datatable.get("ClearEmailField").equals(""))))
			submitPage.getEmailtxtBox().clear();
		
		// enter phone no.
		if ((datatable.get("Phone") != null && !(datatable.get("Phone").equals("")))) {
			submitPage.getPhonetxtBox().sendKeys(datatable.get("Phone").trim());
			ExtentTestManager.getTest().log(Status.PASS, "User entered Phone. " + "Phone:" + datatable.get("Phone"));
		}
		
		// Set Request Type drop down value
		if ((datatable.get("RequestType") != null && !(datatable.get("RequestType").equals("")))) {
			Select requestTypedropDown = new Select(submitPage.getRequestTypeDropDown());
			requestTypedropDown.selectByVisibleText(datatable.get("RequestType").trim());
			ExtentTestManager.getTest().log(Status.PASS, "User entered RequestType. " + "RequestType:" + datatable.get("RequestType"));
		}
		
		// Enter Order No.
		if ((datatable.get("OrderNo") != null && !(datatable.get("OrderNo").equals("")))) {
			submitPage.getOrderNotxtBox().sendKeys(datatable.get("OrderNo").trim());
			ExtentTestManager.getTest().log(Status.PASS, "User entered OrderNo. " + "OrderNo:" + datatable.get("OrderNo"));
		}
		
		// Enter Message Text area
		if ((datatable.get("Message") != null && !(datatable.get("Message").equals("")))) {
			submitPage.getMessagetxtArea().sendKeys(datatable.get("Message").trim());
			ExtentTestManager.getTest().log(Status.PASS, "User entered Message. " + "Message:" + datatable.get("Message"));
		}
		
		//Verify page header title
		if ((datatable.get("HeaderTitle") != null && !(datatable.get("HeaderTitle").equals("")))) {
			actualText = submitPage.getpageHeaderTitle().getText().trim();
			expectedText = datatable.get("HeaderTitle").trim();
			ExtentTestManager.getTest().log(Status.PASS, "Get Page header Title" + "Title:" + datatable.get("HeaderTitle"));
		}
		
		//Verify page header message
		if ((datatable.get("PageDescription") != null && !(datatable.get("PageDescription").equals("")))) {
			actualText = submitPage.getpageHeaderMsg().getText().trim();
			expectedText = datatable.get("PageDescription").trim();
			ExtentTestManager.getTest().log(Status.PASS, "Get Page Header Message. " + "Message:" + datatable.get("PageDescription"));
		}
		
		// Set Captcha
		if((datatable.get("TestScenario").equalsIgnoreCase("Captcha")))
		{
			Thread.sleep(1000);
			
			// This  will scroll down the page by  1000 pixel vertical		
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1000);
			// Click on 'Captcha' and then manually enter captcha
			submitPage.getCaptchaDiv().click();
		//	js.executeScript("arguments[0].setAttribute('style', 'background: grey; border: 2px solid black;');", submitPage.getCaptchaDiv());
			Thread.sleep(80000);
			ExtentTestManager.getTest().log(Status.PASS, "Checked Captcha");
			// Click on Submit
			submitPage.getSubmitBtn().click();
			ExtentTestManager.getTest().log(Status.PASS, "Clicked on Submit.");
			
			Thread.sleep(3000);
			if ((datatable.get("TestCaseType").equals("Negative"))) {
				List<WebElement> errList = submitPage.getErrorMsg();
				for(WebElement errMsg : errList)
				{
					if(!("".equals(actualText)))
						actualText += "\n";
					actualText += errMsg.getText();
				}
				
				ExtentTestManager.getTest().log(Status.PASS, "Step 6: User gets error messages for required fields.");
			} else {
				actualText = submitPage.getSubmitRequestSuccessMsg().getText();
				expectedText = successMsg;
				ExtentTestManager.getTest().log(Status.PASS, "Step 6: User clicked 'Submit' button and gets Success Message");
			}		
			
			
			// appending expected text based on input.
			if ("".equals((datatable.get("Email")))) {

				expectedText += emailErrMs;
			}
			if ((datatable.get("RequestType") == null || (datatable.get("RequestType").equals("")))) {
				if (!"".equals(expectedText)) {
					expectedText += "\n";}
					expectedText += requestTypeErrMsg;
				
			}
			if ((datatable.get("Message") == null || (datatable.get("Message").equals("")))) {
				if (!"".equals(expectedText)) {
					expectedText += "\n";}
					expectedText += messagesErrMsg;
			}
			
		}
		if (!("".equals((datatable.get("CaptchaValidationMsg"))))) {

			submitPage.getSubmitBtn().click();
			actualText = submitPage.getCaptchaErrorMsg().getText().trim();
		}
		
		try {
			System.out.println("Actual Text : " + actualText);
			System.out.println("Expected Text: " + expectedText);
			Assert.assertEquals(actualText.trim(), expectedText.trim());
			ExtentTestManager.getTest().log(Status.PASS,"Test Case : " + (datatable.get("TestCase")) +" is executed successfully.");
			
		} catch (AssertionError e) {
			ExtentTestManager.getTest().log(Status.FAIL, " Actual and expected messages mis match");
			ExtentTestManager.getTest().log(Status.FAIL, "Error message: " + e.getMessage());
			Assert.assertEquals("true","false");
		}
		ExtentTestManager.getTest().log(Status.INFO, "Actual Result:" + actualText);
		ExtentTestManager.getTest().log(Status.INFO, "Expected Result:" + expectedText);
		
		

		// Log out
		loginPage.getUserDrodown().click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 7: Clicked on LogOut");
		
		}
	}
}



/* Wallet Setting Default Card Test Case 
 * List<WebElement> cards = driver.findElements(By.xpath("//*[@class='address-box default_address']"));
		List<WebElement> cardTextHolder = null;
		List<WebElement> setAsDefaultLink = null;
		//WebElement defaultCard = null;
		String cardNo ="Test";
		if(cards.size() != 0)
		{
			for(WebElement card : cards)
			{
				cardTextHolder = card.findElements(By.tagName("p"));
				if(cardTextHolder.size() != 0)
				{;
					String currentCardNo = cardTextHolder.get(0).getText();
					
					System.out.println(currentCardNo);
					if(currentCardNo.trim().equalsIgnoreCase(cardNo))
					{
					  System.out.println("Card No Found" + currentCardNo);
					  setAsDefaultLink = card.findElements(By.xpath(".//a[text()=' Set as default']"));
					Thread.sleep(1000);
					if(setAsDefaultLink.size() != 0)
					{					   
							Actions action = new Actions(driver);
							WebElement we = setAsDefaultLink.get(0);
							action.moveToElement(we).perform();
							Thread.sleep(5000);
							we.click();
							Thread.sleep(1000);
						WebElement defaultCard = driver.findElement(By.xpath("//*[@class='address-box fixed_address']"));
						if(defaultCard.findElement(By.tagName("p")).getText().trim().equalsIgnoreCase(cardNo))
							System.out.println("Card set as Default.");
						
					     break;
						
					}
					}
					
				}
			}
			}*/

/* Wallet add new card 
 * submitPage.getwallet().click();
		
		List<WebElement> cards = driver.findElements(By.xpath("//*[@class='address-box default_address']"));
		WebElement cardTextHolder = null;
		WebElement setAsDefaultLink = null;
		WebElement defaultCard = null;
		String currentCardNo = null;
		String cardNo ="Test";
		Boolean cardFound = false;
		if(cards.size() != 0)
		{
			for(WebElement card : cards)
			{
				cardTextHolder = card.findElement(By.tagName("p"));
				currentCardNo = cardTextHolder.getText();
				System.out.println(currentCardNo);
				if(currentCardNo.trim().equalsIgnoreCase(cardNo))
				{
					System.out.println("Card No Found" + currentCardNo);
					setAsDefaultLink = card.findElement(By.xpath(".//a[text()=' Set as default']"));
					Thread.sleep(1000);
					setAsDefaultLink.click();
					Thread.sleep(1000);
					defaultCard = driver.findElement(By.xpath("//*[@class='address-box fixed_address']"));
					if(defaultCard.findElement(By.tagName("p")).getText().trim().equalsIgnoreCase(cardNo))
						System.out.println(cardNo + "Card set as Default.");	
					cardFound = true;
					     break;
				}			
			}
			if(!cardFound)
				System.out.println("Card no not Found.Either it is already 'set as default' or not has been added.");	
		}
		
 */
