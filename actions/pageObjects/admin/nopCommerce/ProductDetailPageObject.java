package pageObjects.admin.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.nopCommerce.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage {
	WebDriver driver;

	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpendPanelByName(String panelName) {
		waitForElementVisible(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, panelName);
		String toggleIconStatus = getElementAttribute(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, "class", panelName);
		if (toggleIconStatus.contains("fa-plus")) {
			waitForElementClickable(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, panelName);
			clickToElement(driver, ProductDetailPageUI.TOGGLE_ICON_BY_CARD_NAME, panelName);
		}
		// 1. get tag i attribute
		// 2. if not contains (fa-plus)
		// 3. click i if contains (fa-plus)

	}


	public boolean isPictureUploadedSuccessByFileName(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void enterToAltTextbox(String string) {
		// TODO Auto-generated method stub

	}

	public void enterToTitleTextbox(String string) {
		// TODO Auto-generated method stub

	}

	public void enterToDisplayOrderTextbox(String string) {
		// TODO Auto-generated method stub

	}

	public void clickToAddProductPictureButton() {
		// TODO Auto-generated method stub

	}

	public boolean isPictureImageDisplayed(String string, String string2, String string3, String string4) {
		// TODO Auto-generated method stub
		return false;
	}

	public ProductSearchPageObject clickToSaveButton() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickToDeleteButtonAtPictureName(String string) {
		// TODO Auto-generated method stub

	}

	public boolean isMessageDisplayedInTable(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
