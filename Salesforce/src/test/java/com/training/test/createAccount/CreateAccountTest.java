package com.training.test.createAccount;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.CreateAccountPage;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class CreateAccountTest extends BaseTest
{

	WebDriver driver;
	LoginPage login;
	HomePage home;
	CreateAccountPage createAccount;
	CommonUtilities common = new CommonUtilities();



	@BeforeMethod
	public void beforeTest() throws IOException
	{

		driver = getDriver();
		launchbrowser();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		createAccount = new CreateAccountPage(driver);
	}

	@AfterMethod
	public void teardown() throws IOException
	{
		// takescreenshot(driver);
		driver.close();
	}
	
	@Test(description = "Create an Account")
	public void TC10_CreateAccount() throws Exception
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
		waitForElementThenClick(home.AccountsTab,"'Accounts' Tab");
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//input[@class='btn btn-brand noThanksBtn']")).click(); //popup 
		
		waitForElementThenClick(createAccount.NewButton,"'New' button");
		waitForElement(createAccount.AccountNameTextbox);
		createAccount.AccountNameTextbox.clear();
		enterText(createAccount.AccountNameTextbox,"SAVING","ACCOUNT NAME "); 
		
		selectByVisibleText(createAccount.TypeDropdown,"'Type' Dropdown","Technology Partner");  //dropdown select
		selectByVisibleText(createAccount.CustomerPriorityDropdown,"'Customer Priority' Dropdown","High");
		waitForElementThenClick(createAccount.SaveButtonOnEditAccount,"'SAVE' button");
		String Expected = "Account: SAVING ~ Salesforce - Developer Edition";
		String actual = driver.getTitle();
		if(actual.equalsIgnoreCase(Expected))
		{
			System.out.println("VALIDATION PASS: NEW ACCOUNT NAME IS DISPLAYED");
		}
		else
		{
			System.out.println("VALIDATION FAIL: NEW ACCOUNT NAME NOT DISPLAYED ");
		}

		
	}
	
	

	@Test(description = "Create new view")
	public void TC11_Createnewview() throws Exception
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
		
		
		waitForElementThenClick(home.AccountsTab,"'Accounts' Tab");
		Thread.sleep(10000);
		waitForElementThenClick(createAccount.CreateNewView,"'Create New View' Link");
		waitForElement(createAccount.ViewNameTextbox);
		createAccount.ViewNameTextbox.clear();
		enterText(createAccount.ViewNameTextbox,"Name5","VIEW NAME "); 
		waitForElement(createAccount.ViewUniqueNameTextbox);
		createAccount.ViewUniqueNameTextbox.clear();
		enterText(createAccount.ViewUniqueNameTextbox,"UniqueNAME3","VIEW UNIQUE NAME"); 
		waitForElementThenClick(createAccount.SaveButtonOnCreateNewView,"'Save' button");
		Thread.sleep(1000);
		waitForElementThenClick(createAccount.AccountViewList,"'Account New List' Dropdown ");
		Select dropdown_options = new Select(createAccount.AccountViewList);
		List<WebElement> options = dropdown_options.getOptions();   //name check in dropdown 
		
		for(int i=0; i<options.size(); i++)
		{
			if(options.get(i).getText().equals("Name5")) 
			{
				System.out.println("Account name is displayed in the dropdown");
			}
		}
	}
	
	
	@Test(description = "Edit view")
	public void TC12_Editview () throws Exception
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
		
		
		waitForElementThenClick(home.AccountsTab,"'Accounts' Tab");
		Thread.sleep(10000);
		waitForElementThenClick(createAccount.Edit,"'EDIT' Tab");
		waitForElement(createAccount.ViewNameTextbox);
		createAccount.ViewNameTextbox.clear();
		enterText(createAccount.ViewNameTextbox,"NewName5","VIEW NAME "); 
		selectByVisibleText(createAccount.Field,"'Field' Dropdown","Account Name"); 
		selectByVisibleText(createAccount.operator,"'Operator' Dropdown","contains"); 
		waitForElement(createAccount.Value);
		createAccount.Value.clear();
		enterText(createAccount.Value,"a","View Textbox "); 
		
		Select dropdown_options = new Select(createAccount.AvailableField);   // check in dropdown 
		List<WebElement> options = dropdown_options.getOptions();   
		
		for(int i=0; i<options.size(); i++)
		{
			if(options.get(i).getText().equals("Last Activity")) 
			{
				
				options.get(i).click();
				createAccount.Add.click();
				System.out.println("'Last Activity' is moved from 'Available Field'");
				break;
			}
		}
		
		Select dropdown_options1 = new Select(createAccount.SelectedField);   // check in dropdown 
		List<WebElement> options1 = dropdown_options1.getOptions();   
		
		for(int i=0; i<options1.size(); i++)
		{
			if(options1.get(i).getText().equals("Last Activity")) 
			{
				
				
				System.out.println("'Last Activity' is in 'Selected Field'");
				break;
			}
		}
		
		waitForElementThenClick(createAccount.SaveButtonOnEditAccount,"'Save' button on edit account");
	}
}
