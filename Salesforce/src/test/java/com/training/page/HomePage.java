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
	@FindBy(xpath = "//a[normalize-space()='Accounts']")
	public WebElement AccountsTab;
	
	
}
