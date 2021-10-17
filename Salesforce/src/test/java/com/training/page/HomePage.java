package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class HomePage extends BasePage
{

WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[@id='userNavLabel']")
	public WebElement UserMenuDropdown;
	@FindBy(xpath ="//a[normalize-space()='Logout']")
	public WebElement LogoutButton;
	@FindBy(xpath = "//div[@id = 'userNavMenu']")
	public WebElement UserMenuDropdownList;
	@FindBy(xpath ="//a[normalize-space()='My Profile']")
	public WebElement MyProfileUserMenu;
	@FindBy(xpath = "//a[normalize-space()='Developer Console']")
	public WebElement DeveloperConsoleUserMenu;
	
	@FindBy(xpath = "//a[@class='dialogClose']")    //popup after clicking each tab
	public WebElement TabPopup;
	@FindBy(xpath="//ul[@id='tabBar']")             //Tab bar
	public WebElement TabBar;
	
	@FindBy(xpath = "//a[normalize-space()='Accounts']")
	public WebElement AccountsTab;
	@FindBy(xpath = "//a[@title='Opportunities Tab']")
	public WebElement OpportunitiesTab;
	@FindBy(xpath = "//a[normalize-space()='Leads']")
	public WebElement LeadsTab;
	@FindBy(xpath = "//a[@title='Contacts Tab']")
	public WebElement ContactsTab;
	@FindBy(xpath = "//a[normalize-space()='Home']")
	public WebElement HomeTab;
	@FindBy(xpath = "//img[@title='All Tabs']")
	public WebElement AllTabs;
	
	
	
	
	
	
	
	
	public void PopupClose() throws InterruptedException
	{
		Thread.sleep(1000);
		TabPopup.click();
	}
	
}
