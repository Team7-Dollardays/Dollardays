package com.dollardays.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//********* Search input field**************
	// xpath = //input[@placeholder='Search for items in bulk']
	// Abs xpath  = //*[@id=\"aspnetForm\"]/header/div/div/div/div[2]/div[1]/div[1]/input
	@FindBy(css="input[placeholder='Search for items in bulk']")
	private WebElement searchBar;
	public WebElement getSearchBar() {
		return searchBar;
	}
	
	//************** Search button icon ************
	// Xpath -//div[@class='btn-group']/button
	// Css Selector = div[class='btn-group'] button
	//Abs Xpath = //*[@id='header-main']/div/div/div[2]/div[1]/div[1]/div/div/button"
	@FindBy(css="div[class='btn-group'] button")
	private WebElement searchBtn;

	public WebElement getsearchBtn() {
		return searchBtn;
	}
	
	// abs path =  //*[@id='facetrefinements']/aside[1]/div/h3/span[@class='sku-count']
	@FindBy(xpath = "//h3[text()='CATEGORY ']/span")
	private WebElement searchCount;

	public WebElement getsearchCount() {
		return searchCount;
	}
	
	@FindBy(xpath = "//*[@id='aspnetForm']/div[7]/div[@class='failed-search-results bd']")
	private WebElement noDataFoundMsg;

	public WebElement getnoDataFoundMsg() {
		return noDataFoundMsg;
	}
	
	
	@FindAll(@FindBy(xpath = "//div[@class='select-bar pagination-bar']//a[contains(@class,'page-link')]"))
	private List<WebElement> pageCount;

	public List<WebElement> getPageCount() {
		return pageCount;
	}
	
	@FindBy(xpath = "//a[@title='Next Page']")
	private WebElement nextBtn;

	public WebElement getNextBtn() {
		return nextBtn;
	}
	
	@FindBy(xpath = "//a[@title='Last Page']")
	private WebElement lastPageBtn;

	public WebElement getLastPageBtn() {
		return lastPageBtn;
	}
	
	@FindBy(xpath = "//a[@title='First Page']")
	private WebElement firstPageBtn;

	public WebElement getfirstPageBtn() {
		return firstPageBtn;
	}
	
	@FindBy(xpath = "//li[@class='active page-item']")
	private WebElement lastBtntext;

	public WebElement getLastBtntext() {
		return lastBtntext;
	}
	
	@FindAll(@FindBy(xpath = "//div[contains(@class,'prod-tile')]"))
	private List<WebElement> pageItemsCount;

	public List<WebElement> getPageItemsCount() {
		return pageItemsCount;
	}
	
	// first product item from 'Search Results' box 
	// ul[class='rfk_products'] li:first-child a
	@FindBy(css="ul[class='rfk_products'] li:first-child a div[class='rfk_name']")
	private WebElement firstitem;
	public WebElement getSearchResult_firstItem()
	{
		return firstitem;
	}
	
	// get left pane from 'Search Result' box
	@FindBy(css="ul[class='rfk_list'] span")
	private List<WebElement> searchResult_leftPaneitems;
	public List<WebElement> getSearchResult_leftPaneitems()
	{
		return searchResult_leftPaneitems;
	}
	
	// get Product name from 'Search Result' box - right pane
	@FindBy(css="[class='rfk_name']")
	private List<WebElement> searchResult_products;
	public List<String> getSearchResult_products()
	{
		List<String> itemName = new ArrayList<String>();
		for(WebElement product : searchResult_products)
		{
			itemName.add(product.getText().trim());
		}
		return itemName;
	}
		
	// get 'Show more Products' in 'Search Result' box
	//a[text()='Shop More Products']
	@FindBy(xpath="//a[text()='Shop More Products']")
	private WebElement shopmoreBtn;
	public WebElement getSearchResult_ShopMoreBtn()
	{
		return shopmoreBtn;
	}
			
	// get product title from product detail page 
	@FindBy(css="div[class='product_info'] h2")
	private WebElement product_title;
	public String getProduct_title()
	{
		return product_title.getText();
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb col-sm-12']/li[2]/a")
	private WebElement item_searchterm;
	public WebElement getItemSearchTerm()
	{
		return item_searchterm;
	}
	
	public String getSearchWithValue() throws InterruptedException {
		
		String msg=null;
		String result = getnoDataFoundMsg().getText();
		System.out.println("-->"+result);
		
		if(result.contains("No Results Found")) {
			msg = getnoDataFoundMsg().getText();
			
		}else {
			msg = getsearchCount().getText();
		}
		
		return msg;
	}
	
	public void getItemCount() throws InterruptedException {
		getLastPageBtn().click();
		Thread.sleep(1000);
		String valueount = getLastBtntext().getText();
		getfirstPageBtn().click();
		Thread.sleep(1000);
    	
		for(int i=1;i<Integer.parseInt(valueount);i++) {
		    getNextBtn().click();
			Thread.sleep(1000);
			System.out.println("Page "+ i + "  contains " + getPageItemsCount().size() + " rows");
			ExtentTestManager.getTest().log(Status.PASS, "Page Number "+ i + "  contains " + getPageItemsCount().size() + " rows");
		    Thread.sleep(1000);
		}
	}

}
