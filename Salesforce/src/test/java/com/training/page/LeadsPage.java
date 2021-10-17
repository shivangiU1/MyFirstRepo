package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LeadsPage  extends BasePage
{
	public LeadsPage(WebDriver driver) 
	{
		super(driver);
	}

	
	//tc21
	@FindBy(xpath="//select[@id='fcf']")
	public WebElement LeadsDropdown;
	//tc22
	@FindBy(xpath="//input[@title='Go!']")
	public WebElement GoButton;
	//tc24
	@FindBy(xpath="//input[@title='New']")
	public WebElement NewButton;
	@FindBy(xpath="(//input[@id='name_lastlea2'])[1]")
	public WebElement LastNameTextbox;
	@FindBy(xpath="(//input[@id='lea3'])[1]")
	public WebElement CompanyTextbox;
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']")
	public WebElement SaveButton;
	
	
	
	
	
	
	
}
