package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	ExtentReports extent;
	
	String sheetName="contacts";
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		loginpage=new LoginPage();
		homepage= new HomePage();
		contactspage= new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnContacts();
		
	}

	
	/*@Test
	public void checkboxTest()
	{
		contactspage.clickOnCheckbox();
	}*/
	
	/*@Test
	public void addContacts() throws InterruptedException {
		homepage.newContact();
	}*/
	
	
	@DataProvider
	public Object[][] getCRMTestdata() throws InvalidFormatException
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMTestdata")
	public void createContacts(String fn, String ln) throws InterruptedException
	{
		contactspage.clickOnCreateContacts(fn,ln);
	}
	
	 
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			TestUtil.takeScreenshotAtEndOfTest();
			
			//logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		extent.flush();
		driver.quit();
	}
}
