package com.training.test.leads;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.HomePage;
import com.training.page.LeadsPage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class LeadsTest extends BaseTest
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	LeadsPage leads;
	CommonUtilities common = new CommonUtilities();



	@BeforeMethod
	public void beforeTest() throws IOException
	{

		driver = getDriver();
		launchbrowser();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		leads = new LeadsPage(driver);
	}

	@AfterMethod
	public void teardown() throws IOException
	{
		// takescreenshot(driver);
		driver.close();
	}


	@Test(description = "check leads tab link ")
	public void TC20_leadsTab () throws Exception
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		clickObj(login.loginButton,"login button");
		String actualTitle = driver.getTitle();
		//Thread.sleep(1000);
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("VALIDATION PASS: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}
		waitForElementThenClick(home.LeadsTab,"'Leads' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Leads: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON LEADS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: LEADS PAGE IS NOT LAUNCHED");
		}

	}


	@Test(description = "Validate 'View' drop down list contents ")
	public void TC21_leadsSelectView() throws InterruptedException, IOException
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		clickObj(login.loginButton,"login button");
		String actualTitle = driver.getTitle();
		//Thread.sleep(1000);
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("VALIDATION PASS: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}
		waitForElementThenClick(home.LeadsTab,"'Leads' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Leads: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON LEADS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: LEADS PAGE IS NOT LAUNCHED");
		}

		String[] ExpectedList = new String[]{"All Open Leads","My Unread Leads","Recently Viewed Leads",
		"Today's Leads"};


		Select dropdown = new Select(leads.LeadsDropdown);   
		List<WebElement> dropdown_list = dropdown.getOptions();   

		for(int i=0; i<ExpectedList.length; i++)
		{
			if(dropdown_list.get(i).getText().equals(ExpectedList[i])) 

			{

				System.out.println("Pass:   Actual value: '"+dropdown_list.get(i).getText()+
						"' Expected value: '"+ExpectedList[i]+"'");

			}
			else
			{
				System.out.println("Fail:   Actual value: '"+dropdown_list.get(i).getText()+
						"' Expected value: '"+ExpectedList[i]+"'");

			}

		}
		for(int i=0; i<ExpectedList.length; i++)
		{
			Assert.assertEquals(dropdown_list.get(i).getText(), ExpectedList[i]);
		}
	}




	@Test(description = "Functionality of the Go Button ")
	public void TC22_defaultView() throws IOException, InterruptedException
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		clickObj(login.loginButton,"login button");
		String actualTitle = driver.getTitle();
		//Thread.sleep(1000);
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("VALIDATION PASS: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}
		waitForElementThenClick(home.LeadsTab,"'Leads' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Leads: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON LEADS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: LEADS PAGE IS NOT LAUNCHED");
		}

		SelectbyText(leads.LeadsDropdown, "My Unread Leads");

		waitForElementThenClick(home.UserMenuDropdown,"'User Menu' Dropdown ");
		waitForElementThenClick(home.LogoutButton,"'Logout' Button ");
		String actualTitle2 = driver.getTitle();
		String expectedTitle2 = "Login | Salesforce";
		if(actualTitle2.equalsIgnoreCase(expectedTitle2))
		{
			System.out.println("VALIDATION PASS: USER IS ON LOGIN PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: LOGIN PAGE IS NOT LAUNCHED");
		}


		String username1 = common.getApplicationProperty("username");
		login.enterIntoUsername(username1);
		String password1 = common.getApplicationProperty("password");
		login.enterIntoPassword(password1);
		clickObj(login.loginButton,"login button");
		String actualTitle3 = driver.getTitle();
		//Thread.sleep(1000);
		String expectedTitle3 = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle3.equalsIgnoreCase(expectedTitle3))
		{
			System.out.println("VALIDATION PASS: USER IS AGAIN ON HOME PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}
		waitForElementThenClick(home.LeadsTab,"'Leads' Tab ");
		home.PopupClose();
		String actualTitle4 = driver.getTitle();
		String expectedTitle4 = "Leads: Home ~ Salesforce - Developer Edition";
		if(actualTitle4.equalsIgnoreCase(expectedTitle4))
		{
			System.out.println("VALIDATION PASS: USER IS ON LEADS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: LEADS PAGE IS NOT LAUNCHED");
		}


		waitForElementThenClick(leads.GoButton,"'GO' Button ");
		if(leads.LeadsDropdown.getText().equalsIgnoreCase("My Unread Leads"))
		{
			System.out.println("'My Unread Leads' is displayed in dropdown");
		}


	}
	
	
	
	
	@Test(description = "List item <Todays Leads> work ")
	public void TestCase_23() throws IOException, InterruptedException
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		clickObj(login.loginButton,"login button");
		String actualTitle = driver.getTitle();
		//Thread.sleep(1000);
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("VALIDATION PASS: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}
		waitForElementThenClick(home.LeadsTab,"'Leads' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Leads: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON LEADS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: LEADS PAGE IS NOT LAUNCHED");
		}

		SelectbyText(leads.LeadsDropdown, "Today's Leads");
		waitForElementThenClick(leads.GoButton,"'GO' Button ");

	}
	
	
	@Test(description = "Check <New> button on Leads Home ")
	public void TestCase_24() throws Exception
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		clickObj(login.loginButton,"login button");
		String actualTitle = driver.getTitle();
		//Thread.sleep(1000);
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("VALIDATION PASS: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}
		waitForElementThenClick(home.LeadsTab,"'Leads' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Leads: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON LEADS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: LEADS PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(leads.NewButton,"'New' Button");
		enterText(leads.LastNameTextbox,"ABCD","LAST NAME"); 
		enterText(leads.CompanyTextbox,"ABCD","COMPANY");
		waitForElementThenClick(leads.SaveButton,"'Save' Button");
		
	}
}
