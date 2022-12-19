package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	private WebElement searchButton;
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnMyAccountDropMenu() {
		
		myAccountDropMenu.click();
		
	}
	
	public LoginPage clickOnLoginOption() {
		
		loginOption.click();
		return new LoginPage(driver);
		
	}
	
	public LoginPage navigateToTheLoginPage() {
		
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
		
	}
	
	public RegisterPage clickOnRegisterOption() {
		
		registerOption.click();
		return new RegisterPage(driver);
		
	}
	
	public RegisterPage navigateToTheRegisterPage() {
		
		myAccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
		
	}
	
	public void enterProductNameIntoTheSearchBoxField(String productNameText) {
		
		searchBoxField.sendKeys(productNameText);
		
	}
	
	public SearchSuccessPage clickOnSearchButton() {
		
		searchButton.click();
		return new SearchSuccessPage(driver);
		
	}
	
	public SearchSuccessPage searchForAProduct(String productNameText) {
		
		searchBoxField.sendKeys(productNameText);
		searchButton.click();
		return new SearchSuccessPage(driver);
		
	}

}
