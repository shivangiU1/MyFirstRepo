package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class CreateOptyPage extends BasePage
{
	public CreateOptyPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//select[@id='fcf']")
	public WebElement OptyDropdown;
	//tc16
	@FindBy(xpath="//input[@title='New']")
	public WebElement NewButton;
	@FindBy(xpath="(//input[@id='opp3'])[1]")
	public WebElement OptyNameTextbox;
	@FindBy(xpath="//img[@title='Account Name Lookup (New Window)']")
	public WebElement AccountNameLookupbutton;
	@FindBy(xpath="//tr[@class='dataRow even']//th[@scope='row']")
	public WebElement AccountNameInLookupWindow;
	@FindBy(xpath="(//select[@id='opp6'])[1]")
	public WebElement LeadSourceDropdown;
	@FindBy(xpath="(//input[@id='opp9'])[1]")
	public WebElement CloseDate;
	@FindBy(xpath="//a[normalize-space()='Today']")
	public WebElement TodayDate;
	@FindBy(xpath="(//select[@id='opp11'])[1]")
	public WebElement StageDropdown;
	@FindBy(xpath="(//input[@id='opp12'])[1]")
	public WebElement ProbibilityTextbox;
	@FindBy(xpath="(//input[@id='opp17'])[1]")
	public WebElement PrimaryCampaignSourceTextbox;
    //tc17
	@FindBy(xpath="//a[normalize-space()='Opportunity Pipeline']")
	public WebElement OpportunityPipeline;
	//tC18
	@FindBy(xpath="//a[normalize-space()='Stuck Opportunities']")
	public WebElement StuckOpportunities;
	//tc19
	@FindBy(xpath="//select[@id='quarter_q']")
	public WebElement QuarterlySummaryInterval;
	@FindBy(xpath="//select[@id='open']")
	public WebElement QuarterlySummaryInclude;
	@FindBy(xpath="//input[@title='Run Report']")
	public WebElement RunReport;
	
	
	
	
	
	
	

}
