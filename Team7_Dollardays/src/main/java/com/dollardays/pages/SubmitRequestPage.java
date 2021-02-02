package com.dollardays.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * ClassName : SubmitRequestPage 
 * Description : SubmitRequestPage Class locate the web elements of 'https://www.dollardays.com/case.aspx'
 * This class is called by SubmitRequestTest which validate 'https://www.dollardays.com/case.aspx' web page.
 * TesterName : Shachi Bhagwat
 * Date : Jan-22-2021
 */
public class SubmitRequestPage {
	
	// Constructor 
	public SubmitRequestPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
		
	
	// Home page Sign in Icon  - Start
	
	// Sign in icon -
	@FindBy(xpath="//a[@class='dropdown-toggle']//img[@class='header-user']")
	private WebElement User_Dropdown_Toggle;
	public WebElement getUserDropdownToggle() {
		return User_Dropdown_Toggle;
	}
	
	// 'Submit a Request' Link in User Menu list on home Page - 
	@FindBy(xpath="//a[contains(text(),'Submit A Request')] [@href='/case.aspx']")
	private WebElement User_Dropdown_Toggle_SubmitRequestLink;
	public WebElement getUserDropdownToggleSubmitRequestLink() {
		return User_Dropdown_Toggle_SubmitRequestLink;
	}
	
	// *****************Home page Sign in Icon Ends ******************
	
	// *********https://www.dollardays.com/case.aspx web page element ***********
	
	 // email 
	@FindBy(xpath="//input[@class ='form-control'][@placeholder='Email'][@Type='text']")
	private WebElement emailTextBox;
	public WebElement getEmailtxtBox() {
		return emailTextBox;
	}
	
	// phone 
	@FindBy(xpath="//input[@class ='form-control numerictxtbx'][@placeholder='Phone no.'][@Type='text']")
	private WebElement phoneTxtBox;
	public WebElement getPhonetxtBox() {
		return phoneTxtBox;
	}
	
	// select Request Type 
	@FindBy(xpath="//select[@class='form-control blg_cc_month']")
	private WebElement requestType_DropDown;
	public WebElement getRequestTypeDropDown() {
		return requestType_DropDown;
	}
	// Order no.
	@FindBy(xpath="//input[@class='form-control numerictxtbx'][@placeholder='OrderNo']")
	private WebElement ordernoTxtBox;
	public WebElement getOrderNotxtBox() {
		return ordernoTxtBox;
	}
	
	// messages 
	@FindBy(xpath="//textarea[@class='form-control']")
	private WebElement messageTxtBox;
	public WebElement getMessagetxtArea() {
		return messageTxtBox;
	}
	
	// captcha 
	@FindBy(xpath="//div[@id='dvCaptcha']/div")
	private WebElement captcha_Div;
	public WebElement getCaptchaDiv() {
		return captcha_Div;
	}
	// submit btn 
	@FindBy(xpath="//input[@type='submit'][@value='Submit']")
	private WebElement submitBtn;
	public WebElement getSubmitBtn()
	{
		return submitBtn;
	}
	
	// page header title
	@FindBy(xpath="//div[@class='col-lg-12']/h1")
	private WebElement pageHeaderTitle;
	public WebElement getpageHeaderTitle()
	{
		return pageHeaderTitle;
	}
	
	// page header message
	@FindBy(xpath="//div[@class='col-lg-12']/p")
	private WebElement pageHeaderMsg;
	public WebElement getpageHeaderMsg()
	{
		return pageHeaderMsg;
	}
	
	// Success Message 
	
	@FindBy(xpath="//div[@class='error']")
	private List<WebElement> errMsg;
	public List<WebElement> getErrorMsg()
	{
		return errMsg;
	}
	
	// Error Message 
	@FindBy(xpath="//div[@class='sucess']")
	private WebElement successMsg;
	public WebElement getSubmitRequestSuccessMsg()
	{
		return successMsg;
	}
	
	// Captcha Validation err Msg
	@FindBy(xpath="//span[contains(text(),'Captcha validation is required.')]")
	private WebElement captchaErrMsg;
	public WebElement getCaptchaErrorMsg()
	{
		return captchaErrMsg;
	}
	
	//************************ Web Locators Methods *****************************
	
}
