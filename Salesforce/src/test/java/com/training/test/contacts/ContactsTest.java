package com.training.test.contacts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.page.ContactsPage;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;

public class ContactsTest extends BaseTest
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	ContactsPage contacts;
	CommonUtilities common = new CommonUtilities();



	@BeforeMethod
	public void beforeTest() throws IOException
	{

		driver = getDriver();
		launchbrowser();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		contacts = new ContactsPage(driver);
	}

	@AfterMethod
	public void teardown() throws IOException
	{
		// takescreenshot(driver);
		driver.close();
	}



	@Test(description = "Create new contact ")
	public void TestCase25() throws Exception
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

		waitForElementThenClick(home.ContactsTab,"'Contacts' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Contacts: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON CONTACTS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: CONTACTS PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(contacts.NewButton,"'New' Button ");
		enterText(contacts.LastNameTextbox,"Name2","LAST NAME");
		enterText(contacts.AccountNameTextbox,"CURRENT","ACCOUNT NAME");
		waitForElementThenClick(contacts.SaveButtonOnNewPage,"'Save' Button ");

	}





	@Test(description = "Create new view in the Contact Page ")
	public void TestCase26() throws Exception
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

		waitForElementThenClick(home.ContactsTab,"'Contacts' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Contacts: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON CONTACTS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: CONTACTS PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(contacts.CreateNewView,"'Create New View' hyperlink ");
		enterText(contacts.ViewNameTextbox,"Name2","VIEW NAME ");
		waitForElementThenClick(contacts.ViewUniqueNameTextbox," View Unique Name Textbox");
		contacts.ViewUniqueNameTextbox.clear();
		enterText(contacts.ViewUniqueNameTextbox,"UniqueName2","VIEW UNIQUE NAME");
		waitForElementThenClick(contacts.SaveButtonOnCreateNewViewPage,"'Save'Button");

	}




	@Test(description = "Check recently created contact in the Contact Page ")
	public void TestCase27() throws Exception
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

		waitForElementThenClick(home.ContactsTab,"'Contacts' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Contacts: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON CONTACTS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: CONTACTS PAGE IS NOT LAUNCHED");
		}

		SelectbyText(contacts.RecentlyCreatedDropdown,"Recently Created");
	}





	@Test(description = "Check 'My contacts' view in the Contact Page ")
	public void TestCase28() throws Exception
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

		waitForElementThenClick(home.ContactsTab,"'Contacts' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Contacts: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON CONTACTS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: CONTACTS PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(contacts.ContactsDropdown,"'Contacts' dropdown");
		SelectbyText(contacts.ContactsDropdown,"My Contacts");


	}




	@Test(description = "View a contact in the contact Page ")
	public void TestCase29() throws Exception
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

		waitForElementThenClick(home.ContactsTab,"'Contacts' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Contacts: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON CONTACTS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: CONTACTS PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(contacts.NameInRecentContactFrame,"'Name' In Recent Contact Frame");
	}




	@Test(description = "Check the Error message if, the required information "
			+ "is not entered while creating a New view in Contacts")
	public void TestCase30() throws Exception
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

		waitForElementThenClick(home.ContactsTab,"'Contacts' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Contacts: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON CONTACTS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: CONTACTS PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(contacts.CreateNewView,"'Create New View' hyperlink ");
		waitForElementThenClick(contacts.ViewUniqueNameTextbox," View Unique Name Textbox");
		contacts.ViewUniqueNameTextbox.clear();
		enterText(contacts.ViewUniqueNameTextbox,"EFGH","VIEW UNIQUE NAME");
		waitForElementThenClick(contacts.SaveButtonOnCreateNewViewPage,"'Save'Button");
		if(contacts.ErrorMsg.getText().equalsIgnoreCase("Error: You must enter a value"))
		{
			System.out.println("Pass: Valid error message is displayed");
		}
		else
		{
			System.out.println("Fail: Valid error message is not displayed ");
		}

	}




	@Test(description = "Check the Cancel button works fine in Create New View")
	public void TestCase31() throws Exception
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

		waitForElementThenClick(home.ContactsTab,"'Contacts' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Contacts: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON CONTACTS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: CONTACTS PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(contacts.CreateNewView,"'Create New View' hyperlink ");
		enterText(contacts.ViewNameTextbox,"ABCD","VIEW NAME ");
		waitForElementThenClick(contacts.ViewUniqueNameTextbox," View Unique Name Textbox");
		contacts.ViewUniqueNameTextbox.clear();
		enterText(contacts.ViewUniqueNameTextbox,"EFGH","VIEW UNIQUE NAME");
		waitForElementThenClick(contacts.CancelButtonOnCreateNewViewPage,"'Cancel'Button");
		String actualTitle2 = driver.getTitle();
		String expectedTitle2 = "Contacts: Home ~ Salesforce - Developer Edition";
		if(actualTitle2.equalsIgnoreCase(expectedTitle2))
		{
			System.out.println("VALIDATION PASS: USER IS AGAIN ON CONTACTS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: CONTACTS PAGE IS NOT LAUNCHED");
		}

	}


	@Test(description = "Check the Save and New button works in New Contact page")
	public void TestCase32() throws Exception
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		clickObj(login.loginButton,"login button");
		String actualTitle = driver.getTitle();
		Thread.sleep(1000);
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("VALIDATION PASS: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(home.ContactsTab,"'Contacts' Tab ");
		home.PopupClose();
		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "Contacts: Home ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println("VALIDATION PASS: USER IS ON CONTACTS PAGE");
		}
		else
		{
			System.out.println("VALIDATION FAIL: CONTACTS PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(contacts.NewButton,"'New' Button ");
		Thread.sleep(1000);
		enterText(contacts.LastNameTextbox,"Indian","LAST NAME");
		Thread.sleep(1000);
		enterText(contacts.AccountNameTextbox,"CURRENT","ACCOUNT NAME");
		waitForElementThenClick(contacts.SaveAndNewButton,"'Save & New' Button ");
		String actualTitle2 = driver.getTitle();
		String expectedTitle2 = "Contact Edit: New Contact ~ Salesforce - Developer Edition";
		if(actualTitle2.equalsIgnoreCase(expectedTitle2))
		{
			System.out.println("VALIDATION PASS: CONTACT EDIT: NEW CONTACT PAGE IS DISPLAYED");
		}
		else
		{
			System.out.println("VALIDATION FAIL: CONTACT EDIT: NEW CONTACT PAGE IS NOT LAUNCHED");
		}



	}
}


