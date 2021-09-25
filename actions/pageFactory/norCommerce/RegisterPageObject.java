package pageFactory.norCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory{
	private WebDriver driver;
	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement genderMaleRadio;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstNameTextbox;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastNameTextbox;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailTextbox;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement confirmPasswordTextbox;
	
	@FindBy(xpath="//button[@id='register-button']")
	WebElement registerButton;;
	
	@FindBy(xpath="//div[@class='result' and text()='Your registration completed']")
	WebElement successMessage;
	
	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement logoutLink;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void enterToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		senkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void enterToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		senkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, emailAddress);	
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, password);	
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		senkeyToElement(driver, confirmPasswordTextbox, confirmPassword);	
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);		
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, successMessage);
		return isElementDisplayed(driver, successMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);		
	}

}
