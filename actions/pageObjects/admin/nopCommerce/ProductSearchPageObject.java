package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.ProductSearchPageUI;

public class ProductSearchPageObject extends BasePage {
	WebDriver driver;

	public ProductSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX);
		sendkeyToElement(driver, ProductSearchPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}

	public void clickToSearchtButton() {
		waitForElementClickable(driver, ProductSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, ProductSearchPageUI.SEARCH_BUTTON);
	}

	public ProductDetailPageObject clickToEditButtonByProductName(String productName) {
		waitForElementClickable(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME);
		clickToElement(driver, ProductSearchPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.getProductDetailhPage(driver);
	}

	public boolean isSuccessMessageDisplayed(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPictureImageUpdated(String string, String string2) {
		// TODO Auto-generated method stub
		return false;
	}

}
