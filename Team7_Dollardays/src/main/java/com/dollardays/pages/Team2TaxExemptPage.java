package com.dollardays.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Team2TaxExemptPage {
	WebDriver driver;

	public Team2TaxExemptPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//li[@class='dropdown']//a[@class='dropdown-toggle']")
	private WebElement signInButton;
	
	public WebElement getsignInButton() {
		return signInButton;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Accounts')] [@href='/myaccount/account.aspx']")
	private WebElement signIn_accountBtn;
	
	public WebElement getsignIn_accountBtn() {
		return signIn_accountBtn;
	}
	
	@FindBy(xpath = "//*[contains(@class,'cookie-bar-btn')]")
	private WebElement cookiepopup;
	
	public WebElement getCookiepopup() {
		return cookiepopup;
	}
	@FindBy(xpath = "//a[@href='myaccount/account.aspx'] | //i[@class='fa fa-home']")
	private WebElement account_AccountOverViewLink;
	
	public WebElement getaccount_AccountOverViewLink() {
		return account_AccountOverViewLink;
	}
	
	@FindBy(xpath = "//a[@href='myaccount/profile.aspx'] | //i[@class='fa fa-pencil']")
	private WebElement account_ProfileLink;
	
	public WebElement getAccount_ProfileLink() {
		return account_ProfileLink;
	}
	
	@FindBy(xpath = "//a[@href='myaccount/addressbook.aspx'] | //i[@class='fa fa-book']")
	private WebElement account_AddressBookLink;
	
	public WebElement getAccount_AddressBookLink() {
		return account_AddressBookLink;
	}
	
	
	@FindBy(xpath = "//a[@href='myaccount/wallet.aspx'] | //i[@class='fa fa-credit-card-alt']")
	private WebElement account_MyWalletLink;
	
	public WebElement getAccount_MyWalletLink() {
		return account_MyWalletLink;
	}
	
	
	@FindBy(xpath = "//span[text()='Tax Exempt '] | //i[@class='fa fa-certificate']")
	private WebElement account_TaxExemptLink;
	
	public WebElement getAccount_TaxExemptLink() {
		return account_TaxExemptLink;
	}
	
	@FindBy(xpath = "//li[@class=' boder-bot mar-top ']//a[@href='/myaccount/favorites.aspx']")
	private WebElement account_MyFavoritesLink;
	
	public WebElement getAccount_MyFavoritesLink() {
		return account_TaxExemptLink;
	}
	
	@FindBy(xpath = "//li[@class=' boder-bot ']//a[@href='/myaccount/order-history.aspx']")
	private WebElement account_OrderHistory;
	
	public WebElement getAccount_OrderHistory() {
		return account_OrderHistory;
	}
	
	@FindBy(xpath = "//span[text()='Log Out '] | //i[@class='fa fa-sign-out']")
	private WebElement account_LogOut;
	
	public WebElement getAccount_LogOut() {
		return account_LogOut;
	}
	
	@FindBy(xpath = "//a[text()='Edit'][@href='profile.aspx']")
	private WebElement account_LoginInfoEditLink;
	
	public WebElement getAccount_LoginInfoEditLink() {
		return account_LoginInfoEditLink;
	}
	
	@FindBy(xpath = "//a[@href='profile.aspx#anchor-personal']")
	private WebElement account_PersonalInfoEditLink;
	
	public WebElement getAccount_PersonalInfoEditLink() {
		return account_PersonalInfoEditLink;
	}
	
	@FindBy(xpath = "//a[@href='addressbook.aspx']")
	private WebElement account_DefaultToShipEditLink;
	
	public WebElement getAccount_DefaultToShipEditLink() {
		return account_DefaultToShipEditLink;
	}
	
	@FindBy(xpath = "//a[@href='wallet.aspx']")
	private WebElement account_PaymentMethodEditLink;
	public WebElement getAccount_PaymentMethodEditLink() {
		return account_PaymentMethodEditLink;
	}
	
	@FindBy(xpath = "//a[@href='profile.aspx#anchor-organization']")
	private WebElement account_TaxExemptEditLink;
	public WebElement getAccount_TaxExemptEditLink() {
		return account_TaxExemptEditLink;
	}

	@FindBy(xpath = "//a[contains(text(),'Upload')]")
	private WebElement account_TaxExemptUploadLink;
	public WebElement getAccount_TaxExemptUploadLink() {
		return account_TaxExemptUploadLink;
	}
	
	@FindBy(xpath = "//a[contains(text(),' compliance@dollardays.com')] [@href='mailto:?subject=Tax exempt certificate!']") 
	private WebElement account_TaxExemptComplianceLink;
	public WebElement getAccount_TaxExemptComplianceLink() {
		return account_TaxExemptComplianceLink;
	}
	
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtdocument']")
	private WebElement account_TaxExemptdocumentName;
	public WebElement getAccount_TaxExemptdocumentName() {
		return account_TaxExemptdocumentName;
	}
	
	@FindBy(xpath = "//input[@name='txttaxid']")
	private WebElement account_TaxExemptTaxid;
	public WebElement getAccount_TaxExemptTaxid() {
		return account_TaxExemptTaxid;
	}
	
	@FindBy(xpath ="//input[@name='ctl00$cphContent$txtEndDate']")
	private WebElement account_ExpiryDate;
	
	public WebElement getAccount_ExpiryDate() {
		return account_ExpiryDate;
	}
	
	@FindBy(xpath = "//select[@id='ddlstate']")
	private WebElement account_TaxExemptStatedpdown;
	public WebElement getAccount_TaxExemptStatedpdown() {
		return account_TaxExemptStatedpdown;
	}
	
	@FindBy(xpath = "//input[@id='ctl00_cphContent_fUpLoad']")
	private WebElement account_TaxExemptfileUploadBtn;
	public WebElement getAccount_TaxExemptfileUploadBtn() {
		return account_TaxExemptfileUploadBtn;
	}
	
	@FindBy(xpath ="//input[@value='Upload']")
	private WebElement account_TaxExemptUploadBtn;
	public WebElement getAccount_TaxExemptUploadBtn() {
		return account_TaxExemptUploadBtn;
	}
	
	@FindBy(xpath = "//button[@class ='close']")
	private WebElement account_TaxExemptCloseBtn;
	public WebElement getAccount_TaxExemptCloseBtn() {
		return account_TaxExemptCloseBtn;
	}
	@FindBy(xpath = "//label[text()='Choose file']")
	private WebElement account_ChooseFileBtn;
	public WebElement getaccount_ChooseFileBtn() {
		return account_ChooseFileBtn;
	}
	@FindBy(xpath="//*[@id=\"tax_te_modal\"]/div/div/div[1]/button")
	
	
	private WebElement homePopup_Close;
	public WebElement gethomePopup_Close() {
		return homePopup_Close;
	}
	public WebElement tax_ExemptSucessMsg()
	{
		WebElement tax_ExemptSucessMsg = driver.findElement(By.cssSelector("p.success-msg"));
		return tax_ExemptSucessMsg;
	}
	
	
	public WebElement returnErrormsg() {
	 WebElement errormsg = driver.findElement(By.cssSelector("p.notify_error"));
	 return errormsg;
	}
	@FindBy(xpath="//label[text()='Choose file']")
	private WebElement chooseFileLabel;

	public WebElement getchooseFileLabel() {
		return chooseFileLabel;
	}


}
	
