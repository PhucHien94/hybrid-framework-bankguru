package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.HomePageObject;
import pageObject.jQuery.PageGeneratorManager;

public class Level_09_DataTable extends BaseTest{
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	//@Test
	public void Table_01_Paging() {		
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActiveByNumber("15"));
		
		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isPageActiveByNumber("5"));

	}
	
	//@Test
	public void Table_02_Input_Header_Textbox() {
		//Input to textbox
		homePage.inputToHeaderTextboxByName("Females","434000");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);

		homePage.inputToHeaderTextboxByName("Males","45100");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);

		homePage.inputToHeaderTextboxByName("Country","Syrian Arab Rep");
		homePage.sleepInSecond(3);		
		homePage.refreshCurrentPage(driver);
	}
	
	//@Test
	public void Table_03_Click_Icon() {
		//Click to icon
		homePage.clickToIconByCountryName("Argentina","remove");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);

		homePage.clickToIconByCountryName("Algeria","remove");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);

		homePage.clickToIconByCountryName("Aruba","edit");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
	}
	
	//@Test
	public void Table_04_Verify_Row_Values() {
		homePage.inputToHeaderTextboxByName("Country","Algeria");
		Assert.assertTrue(homePage.isRowValueDisplayed("283821","Algeria","295140","578961"));
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);		
	}
	
	//@Test
	public void Table_05_Input_To_Row_Textbox() {
		System.out.println(homePage.getPageTitle(driver));
		
		homePage.inputToTextboxByRowNumber("Contact Person","3","John Kenedy");
		homePage.sleepInSecond(3);

		homePage.inputToTextboxByRowNumber("Order Placed","1","5");
		homePage.sleepInSecond(3);
	}
	
	@Test
	public void Table_06_Click_Icon_At_Row() {
		homePage.clickToIconByRowNumber("2","Move Up");
		homePage.sleepInSecond(3);

		homePage.clickToIconByRowNumber("3","Remove Current Row");
		homePage.sleepInSecond(3);
		
		homePage.clickToIconByRowNumber("2","Remove Current Row");
		homePage.sleepInSecond(3);
	}
	
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
