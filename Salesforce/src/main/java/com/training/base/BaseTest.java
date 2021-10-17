package com.training.base;




import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.utilities.CommonUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{

	private static WebDriver driver;
	CommonUtilities common = new CommonUtilities();

	public WebDriver getDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public void launchbrowser() throws IOException
	{
		//driver = getDriver();
		String url = common.getApplicationProperty("url");
		driver.get(url);
		driver.manage().window().maximize(); 
	}


	//WAIT FOR ELEMENT
	public  void waitForElement(WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Element));
	} 

	//WAIT FOR CLICK
	public  void waitForElementThenClick(WebElement obj,String objName)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(obj));
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("pass :" +objName + " is clicked");

		}
		else
		{
			System.out.println("Fail:" +objName+" is not displayed");

		}

	} 

	//WAIT FOR ELEMENT TO DISAPPEAR
	public  void waitForElementToDisappear(WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	} 

	//WAIT FOR FRAME
	public  void waitForFrameThenSwitchToIt(WebElement obj)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(obj));
		if(obj.isDisplayed())
		{
			driver.switchTo().frame(obj);
			System.out.println("Pass: we can switch to the "+obj+ " frame");
		}
		else
		{
			System.out.println("fail: we can't switch to the "+obj+ " frame");
		}
	} 



	// CLICK BUTTON
	public static void clickObj(WebElement obj,String objName)
	{
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("pass :" +objName + " is clicked");

		}
		else
		{
			System.out.println("Fail:" +objName+" is not displayed");

		}
	}




	//ENTER TEXT(TEXT-BOX)
	public static void enterText(WebElement obj,String textval,String objName) throws Exception

	{
		if(obj.isDisplayed())
		{
			Thread.sleep(4000);
			obj.sendKeys(textval);
			System.out.println("pass: '"+textval+"' value is entered in "+objName+"field");
		}
		else
		{
			System.out.println("fail:" +objName+ "field does not exist");
		}
	}




	//CHECK-BOX
	public static void selectCheckBox(WebElement obj, String objName) 
	{

		if(obj.isDisplayed()) {

			if(obj.isSelected()) {
				System.out.println("Pass: "+objName+" is already selected");

			}else{
				obj.click();
				System.out.println("Pass: "+objName+" is selected");

			}}
		else {
			System.out.println("Fail:"+objName+" is not present"); 

		} 
	}


	


	


	//VARIFY DROP DOWN LIST THROUGH ARRAY
	public static void varifyDropdownList(WebElement obj, String[] ExpectedList)
	{
		String[] ActualList = obj.getText().split("\n");
		System.out.println("ACTUAL DROPDOWN LIST DISPLAYED:-");
		for(int i=0; i<ActualList.length; i++)
		{
			Assert.assertEquals(ActualList[i], ExpectedList[i]);
			System.out.println(ActualList[i]);
		}
	}


	//CHECK EXPECTED VALUE IN  DROP-DOWN LIST THROUGHT "LIST"
	public static void checkExpectedValueDropdownList(WebElement obj,String objName,String ExpectedValue)
	{
		Select dropdown = new Select(obj);   
		List<WebElement> dropdown_list = dropdown.getOptions();   

		for(int i=0; i<dropdown_list.size(); i++)
		{
			if(dropdown_list.get(i).getText().equals(ExpectedValue)) 
			{

				System.out.println("'ExpectedValue' is present in 'objName' list");

			}
			else
			{
				System.out.println("Fail:"+ExpectedValue+" is not present 'objName' list");
			}
		}
	}



	//  VALIDATE MESSAGE/TEXT
	public static void validatemsg(String actualmsg, String expectedmsg)
	{

		if(actualmsg.equals(expectedmsg))
		{
			System.out.println("TestCase is passed");
		}
		else
		{
			System.out.println("TestCase is failed");
		}
	}


	//SWITCH TO FRAME(WEB ELEMENT)
	public static void switchFrame( WebDriver driver,WebElement obj) {

		if(obj.isDisplayed())
		{
			driver.switchTo().frame(obj);
			System.out.println("Pass: we can switch to the "+obj+ " frame");
		}
		else
		{
			System.out.println("fail: we can't switch to the "+obj+ " frame");
		}
	}


	//SWITCH TO FRAME ID(STRING)
	public static void switchFrameid( WebDriver driver,String obj) {

		driver.switchTo().frame(obj);
		System.out.println("Pass: we can switch to the "+obj+ " frame");

	}



	//SWITCH TO DEFAULT(PARENT) FRAME
	public static void switchdefaultFrame( WebDriver driver)
	{
		driver.switchTo().defaultContent();
		System.out.println("Pass: we can switch to the "+ driver + " back to frame");
	}


	//MOUSE-OVER
	public static void mouseOver(WebDriver driver,WebElement obj) 
	{
		if(obj.isDisplayed()) 
		{
			Actions action=new Actions(driver);
			action.moveToElement(obj).build().perform();
			System.out.println("Pass: "+obj+" is present");
		}
		else 
		{
			System.out.println("Fail:"+obj+" is not present");
		}
	}




	//SELECT BY TEXT 
	public static void SelectbyText(WebElement obj, String VisibleText)
	{
		if(obj.isDisplayed())
		{
			Select selObj=new Select(obj);
			selObj.selectByVisibleText(VisibleText);
			System.out.println("Pass: "+VisibleText+ " is Selected from drop down" );
		} 
		else
		{
			System.out.println("Fail: "+VisibleText+ " is not available");
		}
	}

	//SELECT BY VALUE
	public static void SelectByValue(WebElement obj, String val)
	{
		if(obj.isDisplayed())
		{
			Select selObj=new Select(obj);

			selObj.selectByValue(val);
			System.out.println("pass:"+val + " is selected from drop down ");
		}
		else
		{
			System.out.println("Fail:"+val+"is not selected");
		}
	}   




	//SELECT BY INDEX
	public static void selectByIndex(WebElement obj, int index)
	{
		if(obj.isDisplayed()) 
		{
			Select selObj=new Select(obj);
			selObj.selectByIndex(index);

			System.out.println("pass:"+index + " is selected from drop down ");
		}
		else 
		{
			System.out.println("Fail:"+index+"is not selected");
		}
	}


	//SELECT BY VISIBLE TEXT
	public static void selectByVisibleText(WebElement obj,String objName, String Name)
	{
		if(obj.isDisplayed())
		{
			Select drop = new Select(obj);
			drop.selectByVisibleText(Name);
			System.out.println("Pass: "+Name+" is selected in "+objName);
		}
		else
		{
			System.out.println("Fail: dropdown is not available");
		}
	}



	//RADIO BUTTON
	public static void Radiobutton(WebElement obj, String objName)
	{
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("Pass: "+objName+" is clicked");
		}
		else 
		{
			System.out.println("Fail:"+objName+" is not displayed");   
		}
	}


	//SWITCH TO ALERT
	public static void switchtoAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		System.out.println("Pass: alert is present and accept");
	}











}
