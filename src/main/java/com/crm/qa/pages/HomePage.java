package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//page Objects
	
	@FindBy(xpath="//span[text()='Akshay Patel23']")
	WebElement usernameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
	
	//Initializing the page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//actions:-
	
	public boolean usernameValidate()
	{
		
		return usernameLabel.isDisplayed();
	}
	
	public String validateTitle2() 
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts() throws InterruptedException
	{
		contactsLabel.click();
		return new ContactsPage();
	}
	
	public void newContact() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLabel).build().perform();
	}
}
