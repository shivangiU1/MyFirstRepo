package com.training.test.createOpty;

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
import com.training.page.CreateOptyPage;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class CreateOptyTest extends BaseTest
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	CreateOptyPage createOpty;
	CommonUtilities common = new CommonUtilities();



	@BeforeMethod
	public void beforeTest() throws IOException
	{

		driver = getDriver();
		launchbrowser();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		createOpty = new CreateOptyPage(driver);
	}

	@AfterMethod
	public void teardown() throws IOException
	{
		// takescreenshot(driver);
		driver.close();
	}


	@Test(description = "opportunities drop down")
	public void TestCase_15 () throws IOException, InterruptedException
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

		waitForElementThenClick(home.OpportunitiesTab,"'Opportunities' Tab ");
		home.PopupClose();
		String[] ExpectedList = new String[]{"All Opportunities","Closing Next Month","Closing This Month",
				"My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private",
				"Recently Viewed Opportunities","Won"};


		Select dropdown = new Select(createOpty.OptyDropdown);   
		List<WebElement> dropdown_list = dropdown.getOptions();   

		for(int i=0; i<dropdown_list.size(); i++)
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
		for(int i=0; i<dropdown_list.size(); i++)
		{
			Assert.assertEquals(dropdown_list.get(i).getText(), ExpectedList[i]);
		}
	}

    //incomplete
	@Test(description = "Create a new Opty")
	public void TestCase_16 () throws Exception
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

		waitForElementThenClick(home.OpportunitiesTab,"'Opportunities' Tab ");
		home.PopupClose();
		waitForElementThenClick(createOpty.NewButton,"'New' Button ");
		String p = driver.getWindowHandle();
		waitForElementThenClick(createOpty.AccountNameLookupbutton,"'Account Name Lookup' Button ");
		waitForElementThenClick(createOpty.AccountNameInLookupWindow,"'SAVING'account name in Lookup Window ");
		driver.switchTo().window(p);
		enterText(createOpty.OptyNameTextbox,"opty1","Opportunity Name");
		
	}
	
	
	@Test(description = "Test Opportunity Pipeline Report")
	public void TestCase_17 () throws Exception
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

		waitForElementThenClick(home.OpportunitiesTab,"'Opportunities' Tab ");
		home.PopupClose();
		waitForElementThenClick(createOpty.OpportunityPipeline,"'Opportunity Pipeline' link under Reports area ");
		String expectedTitle1 ="Opportunity Pipeline ~ Salesforce - Developer Edition";
		String actualTitle1 = driver.getTitle();
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: REPORT PAGE WITH OPPORTUNITY PIPELINE IS DISPLAYED");
		}
		else
		{
			System.out.println("VALIDATION FAIL: REPORT PAGE WITH OPPORTUNITY PIPELINE IS NOT LAUNCHED");
		}

		
	}
	
	
	
	@Test(description = "Test Stuck Opportunities Report")
	public void TestCase_18 () throws Exception
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

		waitForElementThenClick(home.OpportunitiesTab,"'Opportunities' Tab ");
		home.PopupClose();
		waitForElementThenClick(createOpty.StuckOpportunities,"'Stuck Opportunities' link under Reports area ");
		String expectedTitle1 ="Stuck Opportunities ~ Salesforce - Developer Edition";
		String actualTitle1 = driver.getTitle();
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: REPORT PAGE WITH STUCK OPPORTUNITY IS DISPLAYED");
		}
		else
		{
			System.out.println("VALIDATION FAIL: REPORT PAGE WITH STUCK OPPORTUNITY IS NOT LAUNCHED");
		}

	}
	
	
	
	@Test(description = "Test Quarterly Summary Report")
	public void TestCase_19 () throws Exception
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

		waitForElementThenClick(home.OpportunitiesTab,"'Opportunities' Tab ");
		home.PopupClose();
		SelectbyText(createOpty.QuarterlySummaryInterval, "Next FQ");
		SelectbyText(createOpty.QuarterlySummaryInclude, "Open Opportunities");
		waitForElementThenClick(createOpty.RunReport,"'Run Report' Tab ");
		String expectedTitle1 ="Opportunity Report ~ Salesforce - Developer Edition";
		String actualTitle1 = driver.getTitle();
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: REPORT PAGE WITH STUCK OPPORTUNITY IS DISPLAYED");
		}
		else
		{
			System.out.println("VALIDATION FAIL: REPORT PAGE WITH STUCK OPPORTUNITY IS NOT LAUNCHED");
		}
		
	}
}



