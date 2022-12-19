package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.baseclass.BaseClass;
import com.tutorialsninja.qa.pageobjects.AccountCreatedSuccessPage;
import com.tutorialsninja.qa.pageobjects.HomePage;
import com.tutorialsninja.qa.pageobjects.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;


public class RegisterTest extends BaseClass{
	
	RegisterPage registerPage;
	AccountCreatedSuccessPage accountCreatedSuccessPage;
	
	public RegisterTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.navigateToTheRegisterPage();
		
	}
	
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithManadatoryFields() {
		
		accountCreatedSuccessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmail_TimeAndDateStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		 
		Assert.assertEquals(accountCreatedSuccessPage.getAccountCreatedSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account is not created successfully");
		
	}
	
	@Test(priority=2)
	public void verifyRegisteringAnAccountWithAllfields() {
		
		accountCreatedSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateEmail_TimeAndDateStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
		Assert.assertEquals(accountCreatedSuccessPage.getAccountCreatedSuccessPageHeading(),dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account is not created successfully");
		
	}
	
	@Test(priority=3)
	public void verifyRegisteringAnAccountWithExistingEmailAddress() {
		
		accountCreatedSuccessPage = registerPage.registerWithAllFields(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
		Assert.assertTrue(registerPage.getDuplicateEmailAddressText().contains(dataProp.getProperty("duplicateEamilAddressWarning")),"Warning message regarding duplicate email address is not displyed");
		
	}
	
	@Test(priority=4)
	public void verifyRegisteringAnAccountWithoutProvidingAnyDetails() {
		
		registerPage.clickOnContinueButton();
		
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailAddressWarning"), dataProp.getProperty("telephoneNumberWarning"), dataProp.getProperty("passwordFieldWarning")));
	
	}

}
