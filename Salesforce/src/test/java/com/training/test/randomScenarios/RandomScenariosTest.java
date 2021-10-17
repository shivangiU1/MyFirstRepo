package com.training.test.randomScenarios;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.base.BaseTest;

import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.page.RandomScenariosPage;
import com.training.utilities.CommonUtilities;

public class RandomScenariosTest  extends BaseTest
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	RandomScenariosPage randomScenarios;
	CommonUtilities common = new CommonUtilities();



	@BeforeMethod
	public void beforeTest() throws IOException
	{

		driver = getDriver();
		launchbrowser();
		login = new LoginPage(driver);
		home = new HomePage(driver);
		randomScenarios = new RandomScenariosPage(driver);
	}

	@AfterMethod
	public void teardown() throws IOException
	{
		// takescreenshot(driver);
		driver.close();
	}



	@Test(description = "Verify if the firstname and lastname of the loggedin user is displayed ")
	public void TestCase33() throws Exception
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
			System.out.println(" VALIDATION PASS-->SI N0 2.1: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 2.1: HOME PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(home.HomeTab,"'Home' Tab ");
		home.PopupClose();

		if(randomScenarios.UserNameLink.getText().equalsIgnoreCase("shivangi u"))
		{
			System.out.println(" VALIDATION PASS-->SI N0 2.2: FIRST NAME AND LAST NAME IS DISPLAYED");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 2.2: FIRST NAME AND LAST NAME IS NOT DISPLAYED");
		}
		waitForElementThenClick(randomScenarios.UserNameLink,"User Name link ");

		String actualTitle1 = driver.getTitle();
		String expectedTitle1 = "User: Shivangi u ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println(" VALIDATION PASS-->SI N0 3.1: USER:FIRSTNAME LASTNAME PAGE IS DISPLAYED");
		}
		else
		{
			System.out.println(" VALIDATION FAIL: USER-->SI N0 3.1:FIRSTNAME LASTNAME PAGE IS NOT LAUNCHED");
		}


		String MyProfilePageTittle = "User: Shivangi u ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(MyProfilePageTittle))
		{
			System.out.println(" VALIDATION PASS-->SI N0 3.2: THIS PAGE IS SAME AS MY PROFILE PAGE");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 3.2: THIS PAGE IS NOT SAME AS MY PROFILE PAGE");
		}

	}


	@Test(description = "Verify the edited lastname is updated at various places")
	public void TestCase34() throws Exception
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
			System.out.println(" VALIDATION PASS: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println(" VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(home.HomeTab,"'Home' Tab ");
		home.PopupClose();
		waitForElementThenClick(randomScenarios.UserNameLink,"User Name link ");
		waitForElementThenClick(randomScenarios.EditProfilePenImage,"Edit Profile' Image ");
		driver.switchTo().frame(randomScenarios.FrameEditProfilePopUp);
		waitForElementThenClick(randomScenarios.AboutTabOnEditProfilePopUp,"About Tab'On Edit Profile PopUp");
		waitForElementThenClick(randomScenarios.LastNameTextboxOnEditProfilePopUp,"'Last Name' Textbox ");
		randomScenarios.LastNameTextboxOnEditProfilePopUp.clear();
		enterText(randomScenarios.LastNameTextboxOnEditProfilePopUp,"Abcd","LAST NAME");
		waitForElementThenClick(randomScenarios.SaveAllButtonOnEditProfilePopUp,"'SaveAll' Button");

		String actual =randomScenarios.UserNameAfterEdit.getText();
		//Thread.sleep(1000);
		String expected = "Shivangi Abcd";
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println(" VALIDATION PASS-->SI N0 4.2: updated LastName of the account holder is displayed at the top left hand side of the page");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 4.2: updated LastName of the account holder is not displayed at the top left hand side of the page");
		}

		String actual1 =home.UserMenuDropdown.getText();
		String expected1 = "Shivangi Abcd";
		if(actual1.equalsIgnoreCase(expected1))
		{
			System.out.println(" VALIDATION PASS-->SI N0 4.3: 'User menu for FirstName LastName' menu button is showing the updated Last Name, at the top right hand side of the page");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 4.3: 'User menu for FirstName LastName' menu button is not showing the updated Last Name, at the top right hand side of the page");
		}
	}




	@Test(description = "Verify the tab customization")
	public void TestCase35() throws Exception
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
			System.out.println(" VALIDATION PASS: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println(" VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(home.AllTabs,"'All Tabs(+)' ");

		waitForElementThenClick(randomScenarios.CustomizeMyTabsButton,"'Customize My Tabs' Button ");
		selectByVisibleText(randomScenarios.SelectTabsSectionDropdown,"Select Tabs Section Dropdown","Chatter");
		waitForElementThenClick(randomScenarios.RemoveButton,"'Remove' Button ");
		waitForElementThenClick(randomScenarios.SaveButton,"'Save' Button ");
		String actualTitle1 = driver.getTitle();
		//Thread.sleep(1000);
		String expectedTitle1 = "All Tabs ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println(" VALIDATION PASS-->SI N0 4.1:'All TABS' PAGE IS DISPLAYED");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 4.1: 'All TABS' PAGE IS NOT LAUNCHED");
		}

		if(home.TabBar.getText().equalsIgnoreCase("HomeLibrariesContentSubscriptionsAccountsLeadsOpportunitiesContacts"))//'Chatter is not there
		{
			System.out.println(" VALIDATION PASS-->SI N0 4.2: Removed Tab 'Chatter' is not there in Tab Bar");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 4.2:Removed Tab 'Chatter' is there in Tab Bar");
		}

		waitForElement(home.UserMenuDropdown);
		clickObj(home.UserMenuDropdown,"User Menu Drop-down");
		waitForElementThenClick(home.LogoutButton,"logout button");
		String expectedTitle2 = "Login | Salesforce";
		Thread.sleep(1000);
		String actualTitle2 = driver.getTitle();
		if(actualTitle2.equalsIgnoreCase(expectedTitle2))
		{
			System.out.println("VALIDATION PASS: LOGIN PAGE IS DISPLAYED");
		}
		else
		{
			System.out.println("VALIDATION FAIL: LOGIN PAGE NOT DISPLAYED ");
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
			System.out.println(" VALIDATION PASS-->SI N0 6.1: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 6.1: HOME PAGE IS NOT LAUNCHED");
		}
		if(home.TabBar.getText().equalsIgnoreCase("HomeLibrariesContentSubscriptionsAccountsLeadsOpportunitiesContacts"))//'Chatter is not there
		{
			System.out.println(" VALIDATION PASS-->SI N0 6.2: Removed Tab 'Chatter' is not there in Tab Bar");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 6.2:Removed Tab 'Chatter' is there in Tab Bar");
		}
	}




	@Test(description = "Blocking an event in the calender")
	public void TestCase36() throws Exception
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
			System.out.println(" VALIDATION PASS: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println(" VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(home.HomeTab,"'Home' Tab ");
		Thread.sleep(1000);
		home.PopupClose();
		waitForElementThenClick(randomScenarios.CurrentDateLink,"'Current Date'Link ");
		waitForElementThenClick(randomScenarios.EightPMlink,"'8:00 PM' Link ");
		String parent = driver.getWindowHandle();
		waitForElementThenClick(randomScenarios.SubjectComboBoxLookUp,"'Subject ComboBox' LookUp Button ");
		Set<String> allwindows = driver.getWindowHandles();
		for(String child : allwindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				waitForElementThenClick(randomScenarios.otherFromComboBox,"'other' from combo box ");

			}
		}

		driver.switchTo().window(parent);
		if(driver.getWindowHandle().equalsIgnoreCase(parent))
		{
			System.out.println(" VALIDATION PASS-->SI N0 5.1: THE 'COMBOBOX' POP IS CLOSED" );
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 5.1: THE 'COMBOBOX' POP IS NOT CLOSED" );
		}
		if(randomScenarios.SubjectTexbox.getText().equalsIgnoreCase("other"))
		{
			System.out.println(" VALIDATION PASS-->SI N0 5.2: 'OTHER' IS ENTERED IN SUBJECT TEXTBOX");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 5.2: 'OTHER' IS NOT ENTERED IN SUBJECT TEXTBOX");
		}
		waitForElementThenClick(randomScenarios.EndTimeDropdown,"'End Time' Dropdown");
		waitForElementThenClick(randomScenarios.NinePMFromEndTImeDropdown,"'9:00 PM' From End Time Dropdown");
		waitForElementThenClick(randomScenarios.SaveButtonOnCalender,"'Save' Button On Calender");

	}



	@Test(description = "Blocking an event in the calender with weekly recurrance")
	public void TestCase37() throws Exception
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
			System.out.println(" VALIDATION PASS: USER IS ON HOME PAGE");
		}
		else
		{
			System.out.println(" VALIDATION FAIL: HOME PAGE IS NOT LAUNCHED");
		}

		waitForElementThenClick(home.HomeTab,"'Home' Tab ");
		Thread.sleep(1000);
		home.PopupClose();
		waitForElementThenClick(randomScenarios.CurrentDateLink,"'Current Date'Link ");
		waitForElementThenClick(randomScenarios.FourPMlink,"'4:00 PM' Link ");
		String parent = driver.getWindowHandle();
		waitForElementThenClick(randomScenarios.SubjectComboBoxLookUp,"'Subject ComboBox' LookUp Button ");
		Set<String> allwindows = driver.getWindowHandles();
		for(String child : allwindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				waitForElementThenClick(randomScenarios.otherFromComboBox,"'other' from combo box ");

			}
		}

		driver.switchTo().window(parent);
		if(driver.getWindowHandle().equalsIgnoreCase(parent))
		{
			System.out.println(" VALIDATION PASS-->SI N0 5.1: THE 'COMBOBOX' POP IS CLOSED" );
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 5.1: THE 'COMBOBOX' POP IS NOT CLOSED" );
		}
		if(randomScenarios.SubjectTexbox.getText().equalsIgnoreCase("other"))
		{
			System.out.println(" VALIDATION PASS-->SI N0 5.2: 'OTHER' IS ENTERED IN SUBJECT TEXTBOX");
		}
		else
		{
			System.out.println(" VALIDATION FAIL-->SI N0 5.2: 'OTHER' IS NOT ENTERED IN SUBJECT TEXTBOX");
		}


		waitForElementThenClick(randomScenarios.EndTimeDropdown,"'End Time' Dropdown");
		waitForElementThenClick(randomScenarios.SevenPMFromEndTImeDropdown,"'7:00 PM' From End Time Dropdown");
		waitForElementThenClick(randomScenarios.RecurrenceCheckbox,"'Recurrence' Checkbox");
		waitForElementThenClick(randomScenarios.WeeklyRadioButton,"'Weekly' Radio Button");
		waitForElementThenClick(randomScenarios.RecurrenceEndDateTextbox,"'Recurrence End Date' ");
		
		//Setting 2 weeks after date
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR,14);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date futureDate = calendar.getTime();
		String date1 = df.format(futureDate);
		System.out.println(date1);
		
		enterText(randomScenarios.RecurrenceEndDateTextbox,date1," Recurrence End Date Textbox which is two weeks date from today");
		waitForElementThenClick(randomScenarios.SaveButtonOnRecurrence,"'Save' Button On Recurrence");
		waitForElementThenClick(randomScenarios.MonthView,"'Month View' Button");
		String actualTitle1 = driver.getTitle();
		//Thread.sleep(1000);
		String expectedTitle1 = "Calendar for Shivangi u - Month View ~ Salesforce - Developer Edition";
		if(actualTitle1.equalsIgnoreCase(expectedTitle1))
		{
			System.out.println(" VALIDATION PASS: 'Calendar for Shivangi u - Month View' Page is displayed");
		}
		else
		{
			System.out.println(" VALIDATION FAIL: 'Calendar for Shivangi u - Month View' Page is not displayed");
		}


	}
}
