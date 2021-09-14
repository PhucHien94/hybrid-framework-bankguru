package com.bankguru.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_And_Login_Repeat_Yourself {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	// repeat findelement (DRY: Don't repeat yourself)
	
	@Test
	public void Login_01_Register_To_System() {
		
	}
	
	@Test
	public void Login_02_Login_To_System() {
		
	}
	
	@AfterClass
	public void cleanBrowser() {
		
	}

}
