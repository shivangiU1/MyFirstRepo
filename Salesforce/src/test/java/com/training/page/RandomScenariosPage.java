package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class RandomScenariosPage extends BasePage
{
	public RandomScenariosPage(WebDriver driver) 
	{
		super(driver);
	}


	@FindBy(css="h1[class='currentStatusUserName'] a")
	public WebElement UserNameLink;
	//tc34
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	public WebElement EditProfilePenImage;
	@FindBy(xpath="//iframe[@id='contactInfoContentId']")
	public WebElement FrameEditProfilePopUp;
	@FindBy(xpath="//a[normalize-space()='About']")
	public WebElement AboutTabOnEditProfilePopUp;
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement LastNameTextboxOnEditProfilePopUp;
	@FindBy(xpath="//input[@class =\"zen-btn zen-primaryBtn zen-pas\"]")
	public WebElement SaveAllButtonOnEditProfilePopUp;
	@FindBy(xpath="//span[@id='tailBreadcrumbNode']")
	public WebElement UserNameAfterEdit;
	//tc35
	@FindBy(xpath="//input[@title='Customize My Tabs']")
	public WebElement CustomizeMyTabsButton;
	@FindBy(xpath="(//select[@id='duel_select_1'])[1]")
	public WebElement SelectTabsSectionDropdown;
	@FindBy(xpath="//img[@title='Remove']")
	public WebElement RemoveButton;
	@FindBy(xpath="//input[@title='Save']")
	public WebElement SaveButton;
	//tc36
	@FindBy(css="a[href='/00U/c?md3=290&md0=2021']")
	public WebElement CurrentDateLink;
	@FindBy(xpath="//a[normalize-space()='8:00 PM']")
	public WebElement EightPMlink;
	@FindBy(xpath="//img[@title='Subject Combo (New Window)']")
	public WebElement SubjectComboBoxLookUp;
	@FindBy(css="a[href='javascript:pickValue(4);']")
	public WebElement otherFromComboBox;
	@FindBy(xpath="(//input[@id='evt5'])[1]")
	public WebElement SubjectTexbox;
	@FindBy(xpath="//input[@id='EndDateTime_time']")
	public WebElement EndTimeDropdown;
	@FindBy(xpath="(//div[@id='timePickerItem_42'])[1]")
	public WebElement NinePMFromEndTImeDropdown;
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']")
	public WebElement SaveButtonOnCalender;
	//tc37
	@FindBy(xpath="//a[normalize-space()='4:00 PM']")
	public WebElement FourPMlink;
	@FindBy(xpath="(//div[@id='timePickerItem_38'])[1]")
	public WebElement SevenPMFromEndTImeDropdown;
	@FindBy(xpath="//input[@id='IsRecurrence']")
	public WebElement RecurrenceCheckbox;
	@FindBy(xpath="//input[@id='rectypeftw']")
	public WebElement WeeklyRadioButton;
	@FindBy(xpath="//input[@id='RecurrenceEndDateOnly']")
	public WebElement RecurrenceEndDateTextbox;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']")
	public WebElement SaveButtonOnRecurrence;
	@FindBy(xpath="//img[@title='Month View - Selected']")
	public WebElement MonthView;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
