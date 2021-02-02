package com.dollardays.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Sign in user toggle dropdown 
	@FindBy(xpath="//a[@class='dropdown-toggle']//img[@class='header-user']")
	private WebElement User_Dropdown_Toggle;
	public WebElement getUserDropdownToggle() {
		return User_Dropdown_Toggle;
	}

	// Sign out link in drop down options
	@FindBy(xpath = "//a[normalize-space(.)='Sign Out']")
	private WebElement signOut;
	public WebElement getSignOut() {
		return signOut;
	}
	
	// Sign out from Account page 
	// 'Accounts' Link in User Menu list on home Page - 
	@FindBy(xpath="//a[contains(text(),'Accounts')] [@href='/myaccount/account.aspx']")
	private WebElement User_Dropdown_Toggle_AccountsLink;
	public WebElement getUserDropdownToggleAccountsLink() {
		return User_Dropdown_Toggle_AccountsLink;
	}
	
	// Log out link from 'Accounts Page'
	@FindBy(xpath = "//a[normalize-space(.)='Log Out']")
	private WebElement logOut;
	public WebElement getLogOut() {
		return logOut;
	}
	
	// Sign in button after log out 
	@FindBy(xpath = "//span[normalize-space(.)='Sign in']")
	private WebElement signIn;
	public WebElement getsignIn() {
		return signIn;
	}
}
