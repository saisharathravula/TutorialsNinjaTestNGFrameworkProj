package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchSuccessPage {
	
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criteria.')]")
	private WebElement noProductResultMessage;
	
	public SearchSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean getDisplayStatusOfHPProduct() {
		
		boolean displayStatusOfHPProduct = validHPProduct.isDisplayed();
		return displayStatusOfHPProduct;
	}
	
	public String getNoProductResultMessage( ) {
		
		String noProductResultMessageText = noProductResultMessage.getText();
		return noProductResultMessageText;
		
	}

}
