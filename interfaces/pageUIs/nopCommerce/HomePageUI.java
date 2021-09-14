package pageUIs.nopCommerce;

public class HomePageUI {

	// public : pham vi rong ngôai package
	// static : biến tĩnh - cho phép 1 class khác truy cập đến biến của class này mà không cần khởi tạo đối tượng của class này lên
	// HomePageUI.HOME_PAGE_SLIDER
	// final : ngăn cản việc gán lại giá trị cho biến này
	// static final : hằng số (constant) - phải viết hoa và phân cách bởi dấu gạch nối
	// String : kiểu dữ liệu đại diện cho xpath
	public static final String HOME_PAGE_SLIDER = "//div[@id='nivo-slider']";
	public static final String REGISTER_LINK = "//a[contains(text(),'Register')]";
	public static final String LOGIN_LINK = "//a[contains(text(),'Log in')]";	
}
