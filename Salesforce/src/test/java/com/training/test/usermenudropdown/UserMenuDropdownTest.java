package com.training.test.usermenudropdown;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.base.BaseTest;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.page.UserMenuDropDownPage;
import com.training.utilities.CommonUtilities;

public class UserMenuDropdownTest extends BaseTest
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	UserMenuDropDownPage myProfile;
	CommonUtilities common = new CommonUtilities();



	@BeforeMethod
	public void beforeTest() throws IOException
	{

		driver = getDriver();
		launchbrowser();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		myProfile = new UserMenuDropDownPage(driver);
	}

	@AfterMethod
	public void teardown() throws IOException
	{
		// takescreenshot(driver);
		driver.close();
	}


	@Test(description = "Select user menu for <username> drop down")
	public void testcase5() throws IOException
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		clickObj(login.loginButton,"login button");
		waitForElement(home.UserMenuDropdown);
		clickObj(home.UserMenuDropdown,"User Menu Drop-down");
		String[] ExpectedList = new String[]{"My Profile","My Settings","Developer Console",
				"Switch to Lightning Experience","Logout"};
		varifyDropdownList(home.UserMenuDropdownList, ExpectedList);

	}


	//Notcomplete
	@Test(description = "Select <My Profile> option from user menu for <username> drop down")
	public void testcase6() throws Exception
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		waitForElementThenClick(login.loginButton,"login button");
		waitForElementThenClick(home.UserMenuDropdown,"User Menu Drop-down");
		waitForElementThenClick(home.MyProfileUserMenu,"'My profile'");

		//EDIT PROFILE 
		waitForElementThenClick(myProfile.EditProfile,"'Edit Profile'");
		waitForElement(myProfile.FrameEditProfile);
		switchFrame(driver,myProfile.FrameEditProfile);
		// waitForFrameThenSwitchToIt(myProfile.FrameEditProfile);
		waitForElementThenClick(myProfile.AboutTabEditProfile,"'About Tab' in Edit Profile");
		waitForElement(myProfile.LastNameTextboxEditProfile);
		myProfile.LastNameTextboxEditProfile.clear();
		enterText(myProfile.LastNameTextboxEditProfile,"u","LAST NAME ");   //Update last name
		waitForElementThenClick(myProfile.SaveAllTabEditProfile,"'Save All' button in Edit Profile");

		//click on post
		waitForElementThenClick(myProfile.PostTab,"'POST' in My profile ");
		Thread.sleep(2000);
		//waitForElement(myProfile.FramePost);
		switchFrame(driver,myProfile.FramePost);
		enterText(myProfile.PostTabTextArea,"hi"," POST TEXT AREA ");
		driver.switchTo().defaultContent();
		waitForElementThenClick(myProfile.ShareButtoninPostTab,"'Share Button' in POST TAB");
		System.out.println(myProfile.RecentFeedInPost.getText());



	}



	@Test(description = "Select <Developers Console>option from user menu for <username> drop down")
	public void testcase8() throws Exception
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		clickObj(login.loginButton,"login button");
		waitForElement(home.UserMenuDropdown);
		clickObj(home.UserMenuDropdown,"User Menu Drop-down");
		String[] ExpectedList = new String[]{"My Profile","My Settings","Developer Console",
				"Switch to Lightning Experience","Logout"};
		varifyDropdownList(home.UserMenuDropdownList, ExpectedList);

		//window switch
		String ParentWindowHandle = driver.getWindowHandle();
		waitForElementThenClick(home.DeveloperConsoleUserMenu,"'Developer console' in user menu dropdown list ");
		for(String currentWindowHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(currentWindowHandle);
		}
		driver.close();
		driver.switchTo().window(ParentWindowHandle);

	}


	@Test(description = "Select <Logout> option from user menu for <username> drop down")
	public void testcase9() throws Exception
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		clickObj(login.loginButton,"login button");
		waitForElement(home.UserMenuDropdown);
		clickObj(home.UserMenuDropdown,"User Menu Drop-down");
		String[] ExpectedList = new String[]{"My Profile","My Settings","Developer Console",
				"Switch to Lightning Experience","Logout"};
		varifyDropdownList(home.UserMenuDropdownList, ExpectedList);
		waitForElementThenClick(home.LogoutButton,"logout button");
		String expectedTitle = "Login | Salesforce";
		Thread.sleep(1000);
		String actualTitle = driver.getTitle();
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("VALIDATION PASS: LOGIN PAGE IS DISPLAYED");
		}
		else
		{
			System.out.println("VALIDATION FAIL: LOGIN PAGE NOT DISPLAYED ");
		}

	}



}
