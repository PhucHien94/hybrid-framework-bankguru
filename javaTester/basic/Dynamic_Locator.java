package basic;

public class Dynamic_Locator {
	
	public static void main(String[] args) {

		/*
		 * String SEARCH_PAGE_FOOTER = "//div[@class='footer']//a[text()='Search']";
		 * String ORDER_PAGE_FOOTER = "//div[@class='footer']//a[text()='Orders']";
		 * String MY_ACCOUNT_PAGE_FOOTER =
		 * "//div[@class='footer']//a[text()='My account']";
		 */
		
		String DYNAMIC_PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
		
		String DYNAMIC_SIDEBAR_TEXT = "//sidebar[@id='%s']//div[text()='%s']";
		
		clickToElement(DYNAMIC_PAGE_FOOTER,"Search");
		clickToElement(DYNAMIC_PAGE_FOOTER, "Orders");
		
		clickToElement(DYNAMIC_SIDEBAR_TEXT, "Top", "Login");
	}
	
	/*
	 * //Fix cung locator public static void clickToElement(String locator) {
	 * System.out.println(locator); }
	 * 
	 * //1 tham so dynamic public static void clickToElement(String locator,String
	 * pageName) { System.out.println(String.format(locator, pageName)); }
	 * 
	 * //2 tham so dynamic public static void clickToElement(String locator,String
	 * sidebarName,String text) { System.out.println(String.format(locator,
	 * sidebarName,text)); }
	 */
	
	//Rest parameter
	public static void clickToElement(String locator, String... params) {
		System.out.println(String.format(locator, (Object[])params));
	}
}
