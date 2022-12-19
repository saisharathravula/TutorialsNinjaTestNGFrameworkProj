package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	@FindBy(linkText="Modify your address book entries")
	private WebElement editYourAccountInformationOption;
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean getDisplayStatusOfEEditYourAccountInformationOption() {
		
		boolean displayStatus = editYourAccountInformationOption.isDisplayed();
		return displayStatus;
		
	}

}
