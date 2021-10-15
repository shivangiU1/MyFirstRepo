package com.training.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.training.base.BasePage;

public class LoginPage extends BasePage
{



     //WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	@FindBy(xpath="//input[@id='Login']")
	public WebElement loginButton;
	@FindBy(xpath="//input[@id='rememberUn']")
	public WebElement RememberMe;
	@FindBy(xpath ="//a[normalize-space()='Forgot Your Password?']")
	public WebElement ForgetPwd;
	@FindBy(xpath = "//input[@id='un']")
	public WebElement FpwdPageUname;	
	@FindBy(xpath ="//input[@id='continue']")
	public WebElement FpwdPageContinueButton;
	@FindBy(xpath = "//div[@id='error']")
	public WebElement LoginErrorMessage;
	



	public void enterIntoUsername(String strUsername)
	{
		username.sendKeys(strUsername);
	}
	public void enterIntoPassword(String strPassword)
	{
		password.sendKeys(strPassword);
	}
	

	
	
}
