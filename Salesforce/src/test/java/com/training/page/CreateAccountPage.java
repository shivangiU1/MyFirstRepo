package com.training.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class CreateAccountPage extends BasePage
{

	public CreateAccountPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath ="//input[@title='New']")
	public WebElement NewButton;
	@FindBy(xpath ="//input[@id='acc2']")
	public WebElement AccountNameTextbox;
	@FindBy(xpath ="//select[@id='acc6']")
	public WebElement TypeDropdown;
	@FindBy(xpath ="//select[@id='00N5f000007O3Xf']")
	public WebElement CustomerPriorityDropdown;
	@FindBy(xpath ="//td[@id='bottomButtonRow']//input[@title='Save']")
	public WebElement SaveButtonOnEditAccount;
	//tc11
	@FindBy(xpath ="//a[normalize-space()='Create New View']")
	public WebElement CreateNewView;
	@FindBy(xpath ="//input[@id='fname']")
	public WebElement ViewNameTextbox;
	@FindBy(xpath ="//input[@id='devname']")
	public WebElement ViewUniqueNameTextbox;
	@FindBy(xpath ="(//input[@title='Save'])[1]")
	public WebElement SaveButtonOnCreateNewView;
	@FindBy(className ="title")
	public WebElement AccountViewList;
	//tc12
	@FindBy(xpath ="(//a[contains(text(),'Edit')])[1]")
	public WebElement Edit;
	@FindBy(xpath ="(//select[@id='fcol1'])[1]")
	public WebElement Field;
	@FindBy(xpath ="(//select[@id='fop1'])[1]")
	public WebElement operator;
	@FindBy(xpath ="//input[@id='fval1']")
	public WebElement Value;
	@FindBy(xpath ="(//select[@id='colselector_select_0'])[1]")
	public WebElement AvailableField;
	@FindBy(xpath ="(//img[@title='Add'])[1]")
	public WebElement Add;
	@FindBy(xpath ="(//select[@id='colselector_select_1'])[1]")
	public WebElement SelectedField;
	@FindBy(xpath ="(//input[@title='Save'])[2]")
	public WebElement SaveButtonOnEditView;
	//tc13
	@FindBy(xpath ="//a[text()='Merge Accounts']")
	public WebElement MergeAccounts;
	@FindBy(xpath ="//input[@id='srch']")
	public WebElement FindAccountsTextbox;
	@FindBy(xpath ="//input[@name='srchbutton']")
	public WebElement FindAccountsButton;
	@FindAll({@FindBy(xpath = "//input[@type='checkbox']")})  //findElements @FindAll
	public List<WebElement> AllCheckBoxes;
	@FindBy(xpath ="//input[@id='cid0']")
	public WebElement FirstAccountNameCheckbox;
	@FindBy(xpath ="//input[@id='cid1']")
	public WebElement SecondAccountNameCheckbox;
	@FindBy(xpath ="//div[contains(@class,'pbBottomButtons')]//input[contains(@title,'Next')]")
	public WebElement NextButtonMergeAccount;
	@FindBy(xpath ="//div[@class='pbTopButtons']//input[@title='Merge']")
	public WebElement MergeButton;
	//tc14
	@FindBy(xpath ="//a[normalize-space()='Accounts with last activity > 30 days']")
	public WebElement AccountsWithLastActivity;
	@FindBy(xpath ="(//input[@id='ext-gen20'])[1]")
	public WebElement DateFieldDropDown;
	@FindBy(xpath ="//div[contains(text(),'Created Date')]")
	public WebElement CreatedDateInDateField;
	@FindBy(xpath ="(//img[@id='ext-gen152'])[1]")
	public WebElement FromDate;
	@FindBy(xpath ="(//button[normalize-space()='Today'])[1]")
	public WebElement TodayInFromDate;
	@FindBy(xpath ="(//button[normalize-space()='Save'])[1]")
	public WebElement SaveButtonInLastActivity;
	@FindBy(xpath ="//input[@id='saveReportDlg_reportNameField']")
	public WebElement ReportNameOnPopUp;
	@FindBy(xpath ="//input[@id='saveReportDlg_DeveloperName']")
	public WebElement ReportUniqueNameOnPopUp;
	@FindBy(xpath ="//table[@id='dlgSaveAndRun']")
	public WebElement SaveAndRunButtonOnPopUp;
	
	
	
	
	
	
	


















}
