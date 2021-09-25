package com.nopcommerce.login;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.norCommerce.HomePageObject;
import pageFactory.norCommerce.LoginPageObject;
import pageFactory.norCommerce.RegisterPageObject;

public class Level_05_Register_Login_Page_Factory extends BaseTest{
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
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		homePage.clickToRegisterLink();		
		registerPage = new RegisterPageObject(driver);
		
		registerPage.clickToGenderMaleRadioButton();
		
		registerPage.enterToFirstnameTextbox("John");
		
		registerPage.enterToLastnameTextbox("Terry");
		
		registerPage.enterToEmailTextbox(emailAddress);
		
		registerPage.enterToPasswordTextbox(password);

		registerPage.enterToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(emailAddress);	
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
