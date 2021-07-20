package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTestcase extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		loginpage= new LoginPage();
	}
		
	
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validateLoginpageTitle();
		Assert.assertEquals(title,"#1 Free CRM customer relationship management software cloud");
	}
	
	
	
	@Test(priority=2)
	public void loginTest()
	{
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
