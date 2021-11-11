package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.user.nopCommerce.HomePageObject;
import pageObjects.user.nopCommerce.LoginPageObject;
import pageObjects.user.nopCommerce.PageGeneratorManager;
import pageObjects.user.nopCommerce.RegisterPageObject;

public class Level_06_Register_Login_Page_Generator extends BaseTest{
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		emailAddress = getRandomEmail();
		password = "123456";	
	}
	
	@Test
	public void Login_01_Register_To_System() {		
		homePage = PageGeneratorManager.getHomePage(driver);

		// Step 2 : Verify Home Page slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		// Step 3 : Click to Register link --> Register Page				
		registerPage = homePage.clickToRegisterLink();
		
		// Step 4 : Click to Gender male radio
		registerPage.clickToGenderMaleRadioButton();
		
		// Step 5 : Input to Firstname textbox
		registerPage.enterToFirstnameTextbox("John");
		
		// Step 6 : Input to Lastname textbox
		registerPage.enterToLastnameTextbox("Terry");
		
		// Step 7 : Input to Email textbox
		registerPage.enterToEmailTextbox(emailAddress);
		
		// Step 8 : Input to Password textbox
		registerPage.enterToPasswordTextbox(password);

		// Step 9 : Input to Confirm Password textbox
		registerPage.enterToConfirmPasswordTextbox(password);
		
		// Step 10 : Click to Register button
		registerPage.clickToRegisterButton();

		// Step 11 : Verify Success message displayed
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		// Step 12 : Click to Logout link --> Home Page		
		homePage = registerPage.clickToLogoutLink();
		
		// Step 13 : Verify Home Page slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		// Step 1 : Click to Login link		
		loginPage = homePage.clickToLoginLink();

		// Step 2 : Input to Email textbox
		loginPage.enterToEmailTextbox(emailAddress);
		
		// Step 3 : Input to Password textbox
		loginPage.enterToPasswordTextbox(password);

		// Step 4 : Click to Login button 		
		homePage = loginPage.clickToLoginButton();
		
		// Step 5 : Verify Home Page slider displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
		
	public String getRandomEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@mail.vn";
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
