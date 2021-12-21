package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject loginPage;
	public static DashboardPageObject dashboardPage;
	public static ProductSearchPageObject productSearchPage;
	public static ProductDetailPageObject productDetailPage;
	
	private PageGeneratorManager() {
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		if(loginPage==null) {
			loginPage = new LoginPageObject(driver);
		}
		return loginPage;
	}
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		if(dashboardPage==null) {
			dashboardPage = new DashboardPageObject(driver);
		}
		return dashboardPage;
	}
	
	public static ProductSearchPageObject getProductSearchPage(WebDriver driver) {
		if(productSearchPage==null) {
			productSearchPage = new ProductSearchPageObject(driver);
		}
		return productSearchPage;
	}
	
	public static ProductDetailPageObject getProductDetailhPage(WebDriver driver) {
		if(productDetailPage==null) {
			productDetailPage = new ProductDetailPageObject(driver);
		}
		return productDetailPage;
	}
}
