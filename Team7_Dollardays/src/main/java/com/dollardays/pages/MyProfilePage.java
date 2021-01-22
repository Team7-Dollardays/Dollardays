package com.dollardays.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	
//Home Page Locators
	
@FindBy(xpath="//a[@class='dropdown-toggle']//img[@class='header-user']")
private WebElement User_Dropdown_Toggle;

@FindBy(xpath="//a[@href='/logout.aspx'][@class='dropdown-item padditem margn-top']")
private WebElement User_Dropdown_Toggle_Signout;

@FindBy(xpath="//a[@class='dropdown-item'][@href='/myaccount/account.aspx']")
private WebElement User_Dropdown_Toggle_Accounts;


     
//My Profile Link in side menu Locators

@FindBy(xpath = "//span[text()='My Profile']")
private WebElement profileLink;
	
	
   
//Email Preferences Block Locators

@FindBy(xpath="//h5[text()='Manage the types of emails sent to ']/span")
public WebElement Email_Username;

	
@FindBy(xpath="//input[@id='ctl00_cphContent_chkOptinBox1']")
public WebElement NewsLetter_CheckBox;

@FindBy(xpath="//a[text()='My Account Terms & Conditions']")
private WebElement MyAccountTermsandConditions;

@FindBy(xpath="//a[text()='Privacy & Security Statement']")
private WebElement PrivacyandSecurityStatement;

@FindBy(xpath="//input[@id='ctl00_cphContent_btnUpdateNewsletter']")
private WebElement EmailPreferences_SaveChanges;



    
//WebLocators for links in the Terms and Conditions page

@FindBy(xpath="//a[text()='service@dollardays.com']")
public List<WebElement>  ServicesADDDotCom_links;

@FindBy(xpath="//*[text()='Please review our full shipping terms here.']")
public WebElement PleaseReviewFullShippingTerms_link;

@FindBy(xpath="//a[text()='support@dollardays.com']")
public WebElement SupportADDDotCom_link;

@FindBy(xpath="//*[text()='www.adr.org']")
public WebElement WWWDotADRDotORG_link;

@FindBy(xpath="//*[text()='contact@dollardays.com']")
public WebElement ContactADDDotCom_link;




public MyProfilePage(WebDriver driver) {
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


//My Profile Link in side menu click Method
public void click_profileLink() {
	profileLink.click();
	}



//Email Preferences Block Click Methods
public void click_NewsLetter_CheckBox() {
   NewsLetter_CheckBox.click();
}

public void click_MyAccountTermsandConditions() {
	MyAccountTermsandConditions.click();
}

public void click_PrivacyandSecurityStatement() {
	PrivacyandSecurityStatement.click();
}

public void click_EmailPreferences_SaveChanges() {
	EmailPreferences_SaveChanges.click();
}


// Terms and Conditions page links CLick Methods
public void click_ServicesADDDotCom_link() {
	
	System.out.println(ServicesADDDotCom_links.size());
    for(int i=0;i<ServicesADDDotCom_links.size();i++)
    	ServicesADDDotCom_links.get(i).click();
//System.out.println("Link name "+ i +linkElements.get(i).getText());
 }

public void click_PleaseReviewFullShippingTerms_link() {
	PleaseReviewFullShippingTerms_link.click();
}

public void click_SupportADDDotCom_link() {
	SupportADDDotCom_link.click();
}

public void click_WWWDotADRDotORG_link() {
	WWWDotADRDotORG_link.click();
}

public void click_ContactADDDotCom_link() {
	ContactADDDotCom_link.click();
}

}
