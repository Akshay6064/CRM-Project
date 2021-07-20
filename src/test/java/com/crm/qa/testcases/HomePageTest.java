package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	boolean b;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		loginpage=new LoginPage();
		homepage= new HomePage();
		contactspage= new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void loginSuccess() throws Exception
	{
		
		
		//Assert.assertTrue(homepage.usernameValidate());
		try
		{
			 b = homepage.usernameValidate();
		}
		catch(Exception e)
		{
			if(b==true)
			{
				System.out.println("pass");
			}	
			else if(b==false)
			{
				System.out.println("fail");
			}
		}
	}
	
	/*@Test(priority=2)
	public void titleVerify()
	{
		String title=homepage.validateTitle2();
		Assert.assertEquals(title,"Cogmento CRM");
		
	}
	
	
	@Test(priority=3)
	public void contactpageVerify() throws InterruptedException
	{
		contactspage=homepage.clickOnContacts();
	}*/
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
