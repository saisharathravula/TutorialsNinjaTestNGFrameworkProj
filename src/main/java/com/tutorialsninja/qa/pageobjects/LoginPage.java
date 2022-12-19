package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="email")
	private WebElement emailAddressTextField;
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement  loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMatchingWarning;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterEmailAddress(String emailText) {
		
		emailAddressTextField.sendKeys(emailText);
		
	}

	public void enterPasswordField(String passwordText) {
		
		passwordTextField.sendKeys(passwordText);
		
	}
	
	public AccountPage clickOnLogin() {
		
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public AccountPage login(String emailText,String passwordText) {
		
		emailAddressTextField.sendKeys(emailText);
		passwordTextField.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public String getEmailPasswordNotMatchingWarningMessageText() {
		
		String warningText = emailPasswordNotMatchingWarning.getText();
		return warningText;
		
	}
	
}
