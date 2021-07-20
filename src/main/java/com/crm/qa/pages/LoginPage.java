package com.crm.qa.pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.crm.qa.base.TestBase;
import com.google.common.base.Function;

public class LoginPage extends TestBase {
 
	//Page factory- Object repository
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement loginbtn1;
	
	@FindBy(xpath="//button[text()='Got It']")
	WebElement gotit;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn2;
	
	@FindBy(xpath="//div[@class='ui message']//a[text()='Sign Up']")
	WebElement signupBtn;
	
	//initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Actions:-
	
	public String validateLoginpageTitle()
	{
		return driver.getTitle();
	}
	
	
	
	
		
	
	public HomePage login(String un, String pwd)
	{
		//Fluent wait concept	
		/*Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

				WebElement element = wait.until(new Function<WebDriver, WebElement>() 
				{
						public WebElement apply(WebDriver driver)
						{
							return gotit;
						}
				});
		
		element.click();*/
		
		loginbtn1.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn2.click();
		
		return new HomePage();
	}
	
}
