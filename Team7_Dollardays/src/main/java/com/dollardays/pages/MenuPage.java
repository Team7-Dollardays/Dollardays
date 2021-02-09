package com.dollardays.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
	
	// Constructor 
	public MenuPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
		
	// Hamburger Menu - //div[@id='sm_menu_ham']
	@FindBy(id="sm_menu_ham")
	private WebElement hum_Menu;
	public WebElement getMobileMenu()
	{
		return hum_Menu;
	}
	
	// list of main categories Items : 'Now Trending,Categories,Programs,Help & Settings
	@FindBy(xpath="//ul[@class='mobile_menu mob-menu' and not(parent::li)]/li[@class='menu-header']/h3")
	private List<WebElement> lst_main_categories;
	public List<String> getMainCategories()
	{
		System.out.println("Total cat"+ lst_main_categories.size());
		List<String> list = new ArrayList<String>();
		String catName ="";
		for(WebElement ele: lst_main_categories)
		{
			catName = ele.getText();
			System.out.println(catName);
			list.add(catName);
		}
		return list;
	}
	
	// List of 1 page of menu panel items
	@FindBy(xpath = "//ul[@class='mobile_menu mob-menu' and not(parent::li)]/li[@class='menu-header']/ul/li/a |"
			+ "//ul[@class='mobile_menu mob-menu' and not(parent::li)]/li[@class='hasChild']/a")
	private List<WebElement> mainMenu_items;
	public List<WebElement> getMainMenuItems()
	{
 		return mainMenu_items;
	}
	
	// get sub Menu
	@FindBy(xpath="//li[@class='hasChild active' and not(parent::li)]/ul[@class='submenu']")
	private List<WebElement> subMenu_items;
	public List<WebElement> getsubMenuItems()
	{
 		return subMenu_items;
	}
	
	// Products title list on item list page - it will be 12 items if 12 is selected in view drop down to display per page
	@FindBy(xpath="//*[@class='box-product']")
	private List<WebElement> products_List;
	public List<WebElement> getProducts_List()
	{
		return products_List;
	}
	
	 // For Educator page,supporting-nonprofits,supporting-businesses, links :- (//div[@class='row ctr'])[4]
    // program and Help&Settings WebPage Link
    //(//div[@class='row ctr'])[4] | (//div[@class='mid-section'])
    @FindBy(xpath="((//div[@class='row ctr'])[4] | (//div[@class='mid-section']))")
    private List<WebElement> programMenu_WebpageLinks;
    public List<WebElement> getprogramMenu_WebpageLinks()
    {
    	return programMenu_WebpageLinks;
    }
    
    // 'Sort By' Drop-down for sorting
	@FindBy(css="select.ddlSortOption")
	private WebElement sort_dropdown;
	public WebElement getSortDropdown()
	{
		return sort_dropdown;
	}
	
	 // 'View' Drop-down to select no of product/page
	@FindBy(css="select.formlink")
	private WebElement view_dropdown;
	public WebElement getViewDropdown()
	{
		return view_dropdown;
	}
	
	 // 'Add to Cart' icon
    @FindBy(xpath="//a[contains(@href,'viewcart.aspx')]")
    private WebElement addtoCartIcon;
    public WebElement addtoCartIcon()
    {
    	return addtoCartIcon;
    }
    
    // Dropdown_menu popped up when an item is added to cart.
    @FindBy(xpath="//ul[@class ='hidden-xs hidden-sm dropdown-menu snapshot']")
    private WebElement addedItem_cartDDMenu;
    public WebElement addedItem_cartDDMenu()
    {
    	return addedItem_cartDDMenu;
    }
    
    // PAGING
    @FindBy(xpath="//div[@class='select-bar pagination-bar']/ul")
    private WebElement paging_container;
    public WebElement getPagingContainer()
    {
    	return paging_container;
    }
    
    public int getTotalPages(WebElement paging_container)
    {
    	int size = (paging_container.findElements(By.xpath(".//li"))).size();
    	List<WebElement> pagenolist = paging_container.findElements(By.xpath(".//li"));
    	WebElement link = pagenolist.get(size-3).findElement(By.xpath(".//a"));
    	System.out.println("Total Page "+link.getText());
    	int totalPages = Integer.valueOf(link.getText());
    	return totalPages;
    }
    
    // get Last Page 
    public WebElement getLastPage_Icon(WebElement paging_container)
    {
    	WebElement lastPage = paging_container.findElement(By.xpath(".//li/a[@title='Last Page']"));
    	return lastPage;
    }
    
    // get First Page 
    public WebElement getFirstPage_Icon(WebElement paging_container)
    {
    	WebElement firstPage = paging_container.findElement(By.xpath(".//li/a[@title='First Page']"));
    	
    	return firstPage;
    }
    
    // get Next Page 
    public WebElement getNextPage_Icon(WebElement paging_container)
    {
    	WebElement nextPage = paging_container.findElement(By.xpath(".//li/a[@title='Next Page']"));
    	return nextPage;
    }
    
    // get Previous Page 
    public WebElement getPreviousPage_Icon(WebElement paging_container)
    {
    	WebElement nextPage = paging_container.findElement(By.xpath(".//li/a[@title='Previous Page']"));
    	return nextPage;
    }
    
    // get on page no.
    public WebElement getPageByNumber(WebElement paging_container,String pageIndex)
    {
    	WebElement pageNoLink = paging_container.findElement(By.xpath(".//li/a[text()='"+pageIndex+"']"));
    	return pageNoLink;
    }
    
	// Return Menu Item from Menu Item List to open Item list page
	public WebElement getMenuItem(String menuItem,WebElement subMenuItemList)
	{
		List<WebElement> menuItemsLinks;
		//button 
		if(!(menuItem.equalsIgnoreCase("Shop All")))
		{
			// subMenuItemList is <ul> html tag,below will return all <a> links from <ul> webElement
			menuItemsLinks = subMenuItemList.findElements(By.xpath("./li/a"));
		
			System.out.println(menuItem +" and menuitemLinks found :"+ menuItemsLinks.size());
			for(WebElement ele:menuItemsLinks)
			{
				if(ele.getText().trim().equalsIgnoreCase(menuItem.trim()))
				{
					System.out.println("Item found:" + ele.getText());
					return ele;
				}
			}
			}else
			{
				System.out.println("menuItem is " + menuItem);
				menuItemsLinks = subMenuItemList.findElements(By.xpath(".//*[@type='button']"));
				if(menuItemsLinks.size() != 0)
					return menuItemsLinks.get(0);
			}
			return null;
	}
	
    // get Product Title's <div> tag which contains 'Add to Cart' button
    public int getProductTitleIndex(String productName,List<WebElement> productsList)
    {
    	List<WebElement> productTitle;
    	WebElement producttitlebox;
    	for(int i=0;i<productsList.size();i++)
    	{
    		productTitle = productsList.get(i).findElements(By.xpath(".//div[@class='product_titel']/a"));
    		if(productTitle.size() != 0)
    		{
    			if(productName.equalsIgnoreCase(productTitle.get(0).getText().trim()))
    				{
    					System.out.println("Product Found" + productName);
    					return i;
    				}
    			
    		}
    	}
    	return -1;
    }
    
    public String[] getProductTitles(List<WebElement> productsList)
    {
    	List<String> productTitles= new ArrayList<String>();
    	String[] productTitles_Array = new String[productsList.size()];
    	WebElement productTitle;
    	for(WebElement productBox : productsList)
    	{
    		productTitle = productBox.findElement(By.xpath(".//div[@class='product_titel']/a"));
    		productTitles.add(productTitle.getText());
    	}
    	productTitles_Array = productTitles.toArray(productTitles_Array);
    	return productTitles_Array;
    }
      
    // get item's Add to cart button inside Project Title's <div> tag
    public WebElement getAddtoCartbtn(List<WebElement> productList,int productBoxIndex)
    {
    	List<WebElement> addtoCartbtn = productList.get(productBoxIndex).findElements(By.xpath(".//input[@value='Add to Cart']"));
        if(addtoCartbtn.size() != 0)
    	    return addtoCartbtn.get(0);
    	return null;
    }
    
    // get item'sLogin to buy button inside Project Title's <div> tag
    // //a[text()='LOG IN TO  Buy']
    public WebElement getLogintoBuybtn(List<WebElement> productList,int productBoxIndex)
    {
    	List<WebElement> logintoBuybtn = productList.get(productBoxIndex).findElements(By.xpath(".//a[text()='LOG IN TO  Buy']"));
        if(logintoBuybtn.size() != 0)
    	    return logintoBuybtn.get(0);
    	return null;
    }
   
     // links on Web Page which open item Page 
    public WebElement getWebPageLink(String linkName,List<WebElement> linkList)
    {
    	String xpath = "//a[text()='"+linkName+"']";
    	WebElement itemLink = linkList.get(0).findElement(By.xpath(".//a[text()='"+linkName+"']"));
    	if(itemLink != null)
    		System.out.println(itemLink.getText());
    	System.out.println("itemLnik is :"+itemLink);
    	return itemLink;
    }
    
}
	

