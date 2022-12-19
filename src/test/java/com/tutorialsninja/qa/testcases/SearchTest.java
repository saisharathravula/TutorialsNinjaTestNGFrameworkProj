package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.baseclass.BaseClass;
import com.tutorialsninja.qa.pageobjects.HomePage;
import com.tutorialsninja.qa.pageobjects.SearchSuccessPage;

public class SearchTest extends BaseClass {
	
	SearchSuccessPage SearchSuccessPage;
	HomePage homePage;
	
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
		
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		SearchSuccessPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		
		Assert.assertTrue(SearchSuccessPage.getDisplayStatusOfHPProduct(),"Valid HP Product is Not Displayed In The Search Result");
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		SearchSuccessPage = homePage.searchForAProduct(dataProp.getProperty("invalidProduct"));
		
		Assert.assertEquals(SearchSuccessPage.getNoProductResultMessage(), "abcdefghi","NO product message in search results is displayed");
		
	}
	
	@Test(priority=3,dependsOnMethods= {"verifySearchWithValidProduct","verifySearchWithInvalidProduct"})
	public void verifyySearchWithouAnyProduct() {
		
		SearchSuccessPage = homePage.clickOnSearchButton();
	
		Assert.assertEquals(SearchSuccessPage.getNoProductResultMessage(), dataProp.getProperty("noProducTextInSearchResults"),"NO product message in search results is displayed");
		
	}

}
