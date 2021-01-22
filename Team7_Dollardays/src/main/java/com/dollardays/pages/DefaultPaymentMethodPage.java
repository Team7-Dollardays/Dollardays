package com.dollardays.pages;
//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

public class DefaultPaymentMethodPage {
	
	//Home Page Locators
	
	@FindBy(xpath="//a[@class='dropdown-toggle']//img[@class='header-user']")
	private WebElement User_Dropdown_Toggle;

	@FindBy(xpath="//a[@href='/logout.aspx'][@class='dropdown-item padditem margn-top']")
	private WebElement User_Dropdown_Toggle_Signout;

	@FindBy(xpath="//a[@class='dropdown-item'][@href='/myaccount/account.aspx']")
	private WebElement User_Dropdown_Toggle_Accounts;

	
	@FindBy(xpath = "//a[@href='myaccount/wallet.aspx'] | //i[@class='fa fa-credit-card-alt']")
	private WebElement account_PaymentMethodEditLink;
	
	@FindBy(xpath = "//a[@href='myaccount/wallet.aspx'] | //i[@class='fa fa-credit-card-alt']")
	private WebElement account_MyWalletLink;
	
	
	
		@FindBy(xpath ="//*[@id=\"loginDropdownMenu\"]/li[2]/a")
		private WebElement MyProfileAccounts;

		@FindBy(xpath = "//*[contains(@class,'cookie-bar-btn')]")
		private WebElement Cookiepopup;
		
		@FindBy(xpath = "//*[text()='+ Add a new card']")
		private WebElement ClickAddNewCard;
		
		@FindBy(xpath = "//input[@id='ctl00_cphContent_btnUpdateCard']")
		private WebElement SaveCardDetails;
	 
		@FindBy(xpath ="//*[contains(@class,'btn btnCancel')]")
		private WebElement CancelAddNewCard;		
		
		//This is marked default card 
		@FindBy(xpath ="//*[contains(@class,'address-box fixed_address')]")
		private WebElement FixedDefaultCard;
		
		//This is marked default card 
		@FindBy(xpath ="//*[contains(@class,'address-box default_address')]")
		private WebElement DefaultCard;
		
		@FindBy(xpath = "//*[text()=' Edit']")
		private WebElement EditExistingcard;
		
		@FindBy(xpath = "//*[text()=' Delete']")	
		private WebElement DeleteExistingCard;
		
		@FindBy(xpath = "//button[@class='btn btn-primary confirmDeleteAddr']")
		private WebElement YesConfirmationOnDelete;
		
		@FindBy(xpath = "//button[@class='btn btn-secondary closeolap']")
		private WebElement NoConfirmationOnDelete;
				
		@FindBy(xpath = "//*[@id=\"confirmationBox\"]/div/div/div[1]/button/span")
		private WebElement CloseConfirmation;
		
		@FindBy(xpath = "//*[text()=' Set as default']")
		private WebElement SetDefaultcard;
				
		@FindBy(xpath = "//input[@id='ctl00_cphContent_txtCCHolder']")
		public WebElement CCHolder;
		
		@FindBy(xpath = "//input[@id='ctl00_cphContent_txtCCNumber']")
		public WebElement CCNumber;
		
		@FindBy(xpath = "//select[@id='ctl00_cphContent_ddlCCExpireMnth']")
		public WebElement ExpiryMonth;
		
		@FindBy(xpath = "//select[@id='ctl00_cphContent_ddlCCExpireYear']")
		public WebElement ExpiryYear;
		
		@FindBy(xpath = "//input[@id='ctl00_cphContent_txtCCCVV2ID']")
		public WebElement CCV;
		
		@FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrBillingaddr1']")
		public WebElement Address1;
		
		@FindBy(xpath = "//input[@id='ctl00_cphContent_txtAddrBillingcity']")
		public WebElement City;
		
		@FindBy(xpath = "//select[@id='ctl00_cphContent_ddlBillingstate']")
		public WebElement State;
		
		@FindBy(xpath = "//input[@id='txtAddrBillingzip']")
		public WebElement Zipcode;	
								
		public DefaultPaymentMethodPage(WebDriver driver) {
			// super(driver);
			PageFactory.initElements(driver, this);
		}
		
		//Home Page click Methods
		public void click_User_Dropdown_Toggle() {
			User_Dropdown_Toggle.click();
			}

		public void click_User_Dropdown_Toggle_Signout() {
			User_Dropdown_Toggle_Signout.click();
			}

		public void click_User_Dropdown_Toggle_Accounts() {
			User_Dropdown_Toggle_Accounts.click();
			}

		public void getAccount_MyWalletLink() {
			 account_MyWalletLink.click();;
		}
		
		public void getAccount_PaymentMethodEditLink() {
			 account_PaymentMethodEditLink.click();
		}
		
		public void clickMyprofileAccounts()
		{
			MyProfileAccounts.click();
		}
		
			public void closeCookiepopup()
			{
				Cookiepopup.click();
			}
					
		   public void ClickAddNewCard()
		   {
			   ClickAddNewCard.click();
		   }
		   
		   public void DefaultCard()
		   {
			   DefaultCard.isDisplayed();
		   }
		   
		   public void FixedDefaultCard()
		   {
			   FixedDefaultCard.isDisplayed();
		   }
		   
		   public void SaveCardDetails()
		   {
			   SaveCardDetails.click();
		   }
		   
		   public void CancelAddNewCard()
		   {
			   CancelAddNewCard.click();
		   }
		   public void EditExistingCard()
		   {
			   EditExistingcard.click();
		   }
		  
		   public void DeleteExistingcard()
		   {
			   DeleteExistingCard.click();
		   }
		   
		   public void YesConfirmationOnDelete()
		   {
			   YesConfirmationOnDelete.click();
		   }
		   
		   public void NoConfirmationOnDelete()
		   {
			   NoConfirmationOnDelete.click();
		   }
		   
		   public void CloseConfirmation()
		   {
			   CloseConfirmation.click();
		   }
		   		   
		   public void SetDefaultCard()
		   {
			   SetDefaultcard.click();
		   }	  
		  
	  }