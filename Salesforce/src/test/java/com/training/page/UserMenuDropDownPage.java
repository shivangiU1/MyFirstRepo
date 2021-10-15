package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class UserMenuDropDownPage extends BasePage
{
WebDriver driver;
	
	public UserMenuDropDownPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath ="//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	public WebElement EditProfile;
	@FindBy(xpath = "//a[normalize-space()='About']")
	public WebElement AboutTabEditProfile;
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement LastNameTextboxEditProfile;
	@FindBy(xpath = "//iframe[@id='contactInfoContentId']")
	public WebElement FrameEditProfile;
	@FindBy(xpath = "//input[@value='Save All']")
	public WebElement SaveAllTabEditProfile;
	@FindBy(xpath = "//span[normalize-space()='Post']")
    public WebElement PostTab;	
	@FindBy(xpath ="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	public WebElement FramePost;
	@FindBy(xpath ="//html//body[contains(text(),'Share an update,')]")
	public WebElement PostTabTextArea;
	@FindBy(xpath ="//input[@id='publishersharebutton']")
	public WebElement ShareButtoninPostTab;
	@FindBy(xpath ="//div[@class='cxfeeditem feeditem']//p")
	public WebElement RecentFeedInPost;

}
