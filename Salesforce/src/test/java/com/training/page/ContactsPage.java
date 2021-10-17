package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class ContactsPage extends BasePage
{
	public ContactsPage(WebDriver driver) 
	{
		super(driver);
	}


	
	@FindBy(xpath="//input[@title='New']")
	public WebElement NewButton;
	@FindBy(xpath="(//input[@id='name_lastcon2'])[1]")
	public WebElement LastNameTextbox;
	@FindBy(xpath="(//input[@id='con4'])[1]")
	public WebElement AccountNameTextbox;
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']")
	public WebElement SaveButtonOnNewPage;
	//tc26
	@FindBy(xpath="//a[normalize-space()='Create New View']")
	public WebElement CreateNewView;
	@FindBy(xpath="//input[@id='fname']")
	public WebElement ViewNameTextbox;
	@FindBy(xpath="//input[@id='devname']")
	public WebElement ViewUniqueNameTextbox;
	@FindBy(xpath="(//input[@title='Save'])[1]")
	public WebElement SaveButtonOnCreateNewViewPage;
	//tc27
	@FindBy(xpath="//select[@id='hotlist_mode']")
	public WebElement RecentlyCreatedDropdown;
	//tc28
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement ContactsDropdown;
	//tc29
	@FindBy(xpath="//a[contains(text(),'Name2')]")
	public WebElement NameInRecentContactFrame;
	//tc30
	@FindBy(xpath="//div[@class='requiredInput']//div[@class='errorMsg']")
	public WebElement ErrorMsg;
	//tc31
	@FindBy(xpath="(//input[@title='Cancel'])[1]")
	public WebElement CancelButtonOnCreateNewViewPage;
	//tc32
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save & New']")
	public WebElement SaveAndNewButton;
	
	
	
	
	
}
