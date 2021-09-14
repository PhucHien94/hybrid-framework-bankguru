package com.liveguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;

public class Level_03_Register_Login_Page_Object {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		emailAddress = getRandomEmail();
		password = "123456";
	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		// Open url --> Home Page
		driver.get("http://live.demoguru99.com/index.php/");
		homePage = new HomePageObject(driver);

		// Click to My Account --> Login page
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);

		/*
		 * loginPage.enterToEmailTextbox(""); 
		 * loginPage.enterToPasswordTextbox("");
		 * loginPage.clickToLoginButton();
		 */
		loginPage.loginToSystem("","");

		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);

		/*
		 * loginPage.enterToEmailTextbox("123@456.789");
		 * loginPage.enterToPasswordTextbox("123456"); 
		 * loginPage.clickToLoginButton();
		 */

		loginPage.loginToSystem("123@456.789", "123456");

		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test(description = "Password less than 6 chars")
	public void Login_03_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);

		/*
		 * loginPage.enterToEmailTextbox("hien@gmail.com");
		 * loginPage.enterToPasswordTextbox("123"); 
		 * loginPage.clickToLoginButton();
		 */

		loginPage.loginToSystem("hien@gmail.com", "123");

		Assert.assertEquals(loginPage.getInvalidPaswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test(description = "Email not exits in system")
	public void Login_04_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);

		/*
		 * loginPage.enterToEmailTextbox(getRandomEmail());
		 * loginPage.enterToPasswordTextbox("123456"); 
		 * loginPage.clickToLoginButton();
		 */

		loginPage.loginToSystem(getRandomEmail(), "123456");

		Assert.assertEquals(loginPage.getInvalidEmailOrPaswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_05_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);

		/*
		 * loginPage.enterToEmailTextbox("dam@gmail.com");
		 * loginPage.enterToPasswordTextbox("123456"); 
		 * loginPage.clickToLoginButton();
		 */

		loginPage.loginToSystem("dam@gmail.com", "123456");

		Assert.assertEquals(loginPage.getInvalidEmailOrPaswordErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_And_Password() {
		loginPage.refreshCurrentPage(driver);

		/*
		 * loginPage.enterToEmailTextbox("dam@gmail.com");
		 * loginPage.enterToPasswordTextbox("123123"); 
		 * loginPage.clickToLoginButton();
		 */

		loginPage.loginToSystem("dam@gmail.com", "123123");

		// Login Page --> MyDashboar Page
		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isMyDashboardHeaderDisplayed());
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
	MyDashboardPageObject myDashboardPage;

}
