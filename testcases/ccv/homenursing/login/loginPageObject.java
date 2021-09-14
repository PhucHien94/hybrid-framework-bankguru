package ccv.homenursing.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.homeNursing.LoginPageObject;
import pageObjects.homeNursing.SchedulePageObject;
import pageObjects.nopCommerce.HomePageObject;

public class loginPageObject {
	WebDriver driver;
	String username, password;
	String projectLocation = System.getProperty("user.dir");	
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void Login_02_Login_To_System() {
		// Step 1: Open url		
		driver.get("https://d3j48wpdkz6sqj.cloudfront.net/000186/auth");
		loginPage = new LoginPageObject();
	
		// Step 2: Enter username		
		loginPage.enterToUsernameTextbox("");
	
		// Step 3: Enter password
		loginPage.enterToPasswordTextbox("");
		
		// Step 4: Click to Login button
		loginPage.clickToLoginButton();
		
		// Step 5: Switch to choose unit dialog
		loginPage.switchToUnitDialog();
		
		// Step 6: Choose unit 
		loginPage.clickToTestUnit();
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}
	
	SchedulePageObject schedulePage;
	LoginPageObject loginPage;
}
