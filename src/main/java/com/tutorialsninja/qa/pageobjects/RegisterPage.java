package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstNameTextField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameTextField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressTextField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneNumberTextField;
	
	@FindBy(id="input-password")
	private WebElement passwordTextField;

	@FindBy(id="input-confirm")
	private WebElement passwordConfirmTextField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyButton;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="(//div[contains(@class,'alert-dismissible')])")
	private WebElement duplicateEmailAddressWarningHeading;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	WebElement emailAddressWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	WebElement telephoneNumberWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	WebElement passwordFiledWarning;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterFirstName(String firstNameText) {
		
		firstNameTextField.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {

		lastNameTextField.sendKeys(lastNameText);

	}

	public void enterEmailAddress(String emailText) {

		emailAddressTextField.sendKeys(emailText);

	}

	public void enterTelephoneNumber(String telephoneNumberText) {

		telephoneNumberTextField.sendKeys(telephoneNumberText);

	}

	public void enterPassword(String passwordText) {

		passwordTextField.sendKeys(passwordText);

	}

	public void enterConfirmPassword(String confirmPasswordText) {

		passwordConfirmTextField.sendKeys(confirmPasswordText);

	}

	public void clickOnPrivacyPolicy() {

		privacyPolicyButton.click();

	}

	public AccountCreatedSuccessPage clickOnContinueButton() {

		continueButton.click();
		return new AccountCreatedSuccessPage(driver);

	}
	
	public void clickYesNewsLetterOption() {
		
		yesNewsLetterOption.click();
		
	}

	public String getDuplicateEmailAddressText() {
		
		String duplicateEmailWarningText = duplicateEmailAddressWarningHeading.getText();
		return duplicateEmailWarningText;
		
	}
	
	public String getPrivacyPolicyWarning() {
		
		String privacyPolicyWarningText = privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	public String getFirstNameWarning() {
			
			String firstNameWarningText = firstNameWarning.getText();
			return firstNameWarningText;
		}
	
	public String getLastNameWarning() {
		
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String getEmailAddressWarning() {
		
		String emailAddressWarningText = emailAddressWarning.getText();
		return emailAddressWarningText;
	}
	
	public String getTelephoneNumberWarning() {
		
		String telephoneNumberWarningText = telephoneNumberWarning.getText();
		return telephoneNumberWarningText;
	}
	
	public String getPasswordFieldWarning() {
		
		String passwordFieldWarningText = passwordFiledWarning.getText();
		return passwordFieldWarningText;
	}
	
	public AccountCreatedSuccessPage registerWithMandatoryFields(String firstNameText,String lastNameText,String emailText,String telephoneNumberText,String passwordText,
						 String confirmPasswordText) {
		
		firstNameTextField.sendKeys(firstNameText);
		lastNameTextField.sendKeys(lastNameText);
		emailAddressTextField.sendKeys(emailText);
		telephoneNumberTextField.sendKeys(telephoneNumberText);
		passwordTextField.sendKeys(passwordText);
		passwordConfirmTextField.sendKeys(confirmPasswordText);
		privacyPolicyButton.click();
		continueButton.click();
		return new AccountCreatedSuccessPage(driver);
		
	}
	
	public AccountCreatedSuccessPage registerWithAllFields(String firstNameText, String lastNameText,
			String emailText, String telephoneNumberText, String passwordText, String confirmPasswordText) {

		firstNameTextField.sendKeys(firstNameText);
		lastNameTextField.sendKeys(lastNameText);
		emailAddressTextField.sendKeys(emailText);
		telephoneNumberTextField.sendKeys(telephoneNumberText);
		passwordTextField.sendKeys(passwordText);
		passwordConfirmTextField.sendKeys(confirmPasswordText);
		yesNewsLetterOption.click();
		privacyPolicyButton.click();
		continueButton.click();
		return new AccountCreatedSuccessPage(driver);

	}
	
	public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarningMessage,String expectedFirstNameWarningMessage,String expectedLastNameWarningMessage,String expectedEmailAddressWarningMessage,String expectedTelephoneWarningMessage,String expectedPasswordWarningMessage) {
		
		boolean privacyPolicyWarningStatus = privacyPolicyWarning.getText().contains(expectedPrivacyPolicyWarningMessage);
		
		boolean firstNameWarningStatus = firstNameWarning.getText().equals(expectedFirstNameWarningMessage);
		
		boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarningMessage);

		boolean emailAddressWarningStatus = emailAddressWarning.getText().equals(expectedEmailAddressWarningMessage);

		boolean telephoneNumberWarningStatus = telephoneNumberWarning.getText().equals(expectedTelephoneWarningMessage);

		boolean passwordWarningStatus = passwordFiledWarning.getText().equals(expectedPasswordWarningMessage);

		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailAddressWarningStatus && telephoneNumberWarningStatus && passwordWarningStatus;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
