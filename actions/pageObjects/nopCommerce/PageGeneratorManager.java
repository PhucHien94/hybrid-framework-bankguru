package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject homePage;
	public static LoginPageObject loginPage;
	public static RegisterPageObject registerPage;
	public static SearchPageObject searchPage;
	public static MyAccountPageObject myAccountPage;
	public static OrderPageObject orderPage;

	
	private PageGeneratorManager() {
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		if(homePage==null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage==null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		if(registerPage==null) {
			registerPage = new RegisterPageObject(driver);
		}
		return registerPage;
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		if(searchPage==null) {
			searchPage = new SearchPageObject(driver);
		}
		return searchPage;
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		if(myAccountPage==null) {
			myAccountPage = new MyAccountPageObject(driver);
		}
		return myAccountPage;
	}
	
	public static OrderPageObject getOrderPage(WebDriver driver) {
		if(orderPage==null) {
			orderPage = new OrderPageObject(driver);
		}
		return orderPage;
	}
}
