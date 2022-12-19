package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.baseclass.BaseClass;
import com.tutorialsninja.qa.pageobjects.AccountPage;
import com.tutorialsninja.qa.pageobjects.HomePage;
import com.tutorialsninja.qa.pageobjects.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends BaseClass {

	LoginPage loginPage;

	public LoginTest() {
		super();
	}

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);

		/*
		 * homePage.clickOnMyAccountDropMenu(); loginPage =
		 * homePage.clickOnLoginOption();
		 */

		loginPage = homePage.navigateToTheLoginPage();

	}

	@Test(priority = 1, dataProvider = "validCredentialDataSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {

		AccountPage accountPage = loginPage.login(email, password);

		Assert.assertTrue(accountPage.getDisplayStatusOfEEditYourAccountInformationOption(),
				"Modify your address book entries option is not displayed");

	}

	@DataProvider(name = "validCredentialDataSupplier")
	public Object[][] supplyTestData() {

		Object[][] data = Utilities.getTestDataFromExcelSheet("Login");

		return data;

	}

	@Test(priority = 2)
	public void verifyLoginWithInavlidCredentials() {

		loginPage.login(Utilities.generateEmail_TimeAndDateStamp(), dataProp.getProperty("invalidPassword"));

		Assert.assertTrue(
				loginPage.getEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNotMatchingWarning")),
				"Expected Warning Message is not Dispalyed");

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {

		loginPage.login(Utilities.generateEmail_TimeAndDateStamp(), prop.getProperty("validPassword"));

		Assert.assertTrue(
				loginPage.getEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNotMatchingWarning")),
				"Expected Warning Message is not Dispalyed");

	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {

		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));

		Assert.assertTrue(
				loginPage.getEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNotMatchingWarning")),
				"Expected Warning Message is not Dispalyed");

	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials() {

		loginPage.clickOnLogin();

		Assert.assertTrue(
				loginPage.getEmailPasswordNotMatchingWarningMessageText()
						.contains(dataProp.getProperty("emailPasswordNotMatchingWarning")),
				"Expected Warning Message is not Dispalyed");

	}

}
