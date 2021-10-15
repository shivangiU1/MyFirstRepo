package com.training.test.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.base.BaseTest;
import com.training.page.HomePage;
import com.training.page.LoginPage;
import com.training.utilities.CommonUtilities;




public class LoginTest extends BaseTest
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	CommonUtilities common = new CommonUtilities();



	@BeforeMethod
	public void beforeTest() throws IOException
	{

		driver = getDriver();
		launchbrowser();
		login = new LoginPage(driver);
		home = new HomePage(driver);
	}

	@AfterMethod
	public void teardown() throws IOException
	{
		// takescreenshot(driver);
		driver.close();
	}



	@Test(description = "Navigate to SFDC")
	public void Login_Error_Message_1() throws IOException
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		login.enterIntoPassword("");   //password field empty
		clickObj(login.loginButton,"login button");
		String errorMessage = driver.findElement(By.xpath("//div[@id='error']")).getText();
		if(errorMessage.equals("Please enter your password."))
		{
			System.out.println("VALIDATION PASS: ERROR MESSAGE IS DISPLAYED");
		}
		else
		{
			System.out.println("VALIDATION FAIL: ERROR MESSAGE IS NOT DISPLAYED");
		}


	}



	@Test(description = "Login to SFDC")
	public void Login_To_SalesForce_2() throws IOException, InterruptedException
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

	}


	@Test(description = "Test the remember username check box ")
	public void Check_Remeber_Me_3() throws IOException, InterruptedException
	{
		String username = common.getApplicationProperty("username");
		login.enterIntoUsername(username);
		String password = common.getApplicationProperty("password");
		login.enterIntoPassword(password);
		waitForElement(login.RememberMe);
		selectCheckBox(login.RememberMe, "RememberMe");
		clickObj(login.loginButton,"login button");
		waitForElement(home.UserMenuDropdown);
		clickObj(home.UserMenuDropdown,"User Menu Drop-down");
		clickObj(home.LogoutButton,"logout button");
		Thread.sleep(1000);
		//waitForElement(driver.findElement(By.xpath("//span[@id='idcard-identity']")));
		String actualUsername = driver.findElement(By.xpath("//span[@id='idcard-identity']")).getText();
		String expectedUsername = common.getApplicationProperty("username");
		if(actualUsername.equals(expectedUsername))
		{
			System.out.println("VALIDATION PASS: VALID USER NAME IS DISPLAYED");
		}
		else
		{
			System.out.println("VALIDATION FAIL: VALID USER NAME IS NOT DISPLAYED");
		}

	}


	@Test(description = "Test forgot password")
	public void Forgot_Password_4A() throws Exception
	{
		clickObj(login.ForgetPwd,"Forget Your Possword? Text");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Forgot Your Password | Salesforce";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("VALIDATION PASS: USER IS ON FORGOT PASSWORD PAGE");
		}
		else
		{
			System.out.println("FORGOT PASSWORD PAGE IS NOT LAUNCHED");
		}
		enterText(login.FpwdPageUname,"umar.shivangi20@gmail.com ","Forget Password's Username ");
		clickObj(login.FpwdPageContinueButton, "Forget Password Page's Continue Button");
		String NextpageActualTitle = driver.getTitle();
		String NextPageExpectedTitle = "Check Your Email | Salesforce";
		if(NextpageActualTitle.equalsIgnoreCase(NextPageExpectedTitle))
		{
			System.out.println("VALIDATION PASS: PASSWORD RESET MESSAGE SENT TO ASSOCIATE EMAIL ADDRESS");
		}
		else
		{
			System.out.println("VALIDATION FAIL: NEXT PAGE IS NOT LAUNCHED");
		}

	}

	@Test(description ="Validate Login Error Message")
	public void Forgot_Password_4B()
	{
		login.enterIntoUsername("123");
		login.enterIntoPassword("22131");
		clickObj(login.loginButton,"login button");
		String ActualErrorMessage = login.LoginErrorMessage.getText();
		String ExpectedErrrorMessage ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		if(ActualErrorMessage.equalsIgnoreCase(ExpectedErrrorMessage))
		{
			System.out.println("VALIDATION PASS: ERROR MESSAGE IS DISPLAYED");
		}
		else
		{
			System.out.println("VALIDATION FAIL: ERROR MESSAGE IS NOT DISPLAYED");
		}
		
	}
}
