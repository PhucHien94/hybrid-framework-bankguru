package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;

public class Level_08_Register_Login_Page_Dynamic_Locator extends BaseTest{
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
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());	
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderMaleRadioButton();
		registerPage.enterToFirstnameTextbox("John");
		registerPage.enterToLastnameTextbox("Terry");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		homePage = registerPage.clickToLogoutLink();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_02_Login_To_System() {
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void Login_03_Open_Page_At_Footer() {
		// Home Page --> Search Page
		searchPage = (SearchPageObject) homePage.getFooterPageByPageName(driver, "Search");
		
		// Search Page --> My Account Page 
		myAccountPage = (MyAccountPageObject) searchPage.getFooterPageByPageName(driver, "My account");
		
		// My Accout Pate --> Order Page
		orderPage = (OrderPageObject) myAccountPage.getFooterPageByPageName(driver, "Orders");
		
		// Other Page --> My Account
		myAccountPage = (MyAccountPageObject) orderPage.getFooterPageByPageName(driver, "My account");
		
		// My Account --> Search
		searchPage = (SearchPageObject) myAccountPage.getFooterPageByPageName(driver, "Search");
	}
	
	@Test
	public void Login_04_Open_Page_At_Footer() {
		// Search Page --> My Account Page 
		searchPage.openFooterPageByPageName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		// My Accout Pate --> Order Page
		myAccountPage.openFooterPageByPageName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);
		
		// Other Page --> My Account
		orderPage.openFooterPageByPageName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
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
	SearchPageObject searchPage;
	MyAccountPageObject myAccountPage;
	OrderPageObject orderPage;
}
