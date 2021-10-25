package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	// Hàm khởi tạo (Constructor)
	public HomePageObject(WebDriver driver) {
		// Khi new 1 class lên thì nó sẽ nhảy vào hàm khởi tạo đầu tiên
		// Hàm khởi tạo có tên trùng với tên của class
		// không có kiểu trả về
		// 1 class có thể có nhiều hàm khởi tạo --> Tính Đa hình (OOP) : có thể khởi tạo
		// hàm có tham số
		this.driver = driver;
	}

	public boolean isHomePageSliderDisplayed() {
		waitForElementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

}
