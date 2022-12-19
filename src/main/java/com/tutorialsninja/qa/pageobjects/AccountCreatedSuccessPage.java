package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedSuccessPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement accountCreatedSuccessfullyPage;
	
	
	public AccountCreatedSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getAccountCreatedSuccessPageHeading() {
		
		String accountCreatedSuccessPageHeadingText = accountCreatedSuccessfullyPage.getText();
		return accountCreatedSuccessPageHeadingText;
		
	}

}
