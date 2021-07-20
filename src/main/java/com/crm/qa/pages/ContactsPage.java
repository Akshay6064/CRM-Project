package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//input[@name=id]")
	WebElement checkbox;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement createContacts;
	
	@FindBy(xpath="//input[@name='first_name12']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//i[@class='save icon']")
	WebElement saveButton;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}

	
	public void clickOnCheckbox() {
		checkbox.click();
	}
	
	public void clickOnCreateContacts(String fn, String ln) throws InterruptedException {
		
		createContacts.click();
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		saveButton.click();
		
		
	}
}
