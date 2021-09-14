package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Address {

	private String vanMieu;

	private String getVanMieu() {
		return vanMieu;
	}

	private void setVanMieu(String vanMieu) {
		this.vanMieu = vanMieu;
	}

	public static void main(String[] args) {
		Address address = new Address();
		System.out.println(address.getVanMieu());
		
		address.setVanMieu("string1");
		System.out.println(address.getVanMieu());

		address.vanMieu = "string 2";
		System.out.println(address.getVanMieu());
		
		address.vanMieu = "string 3";
		System.out.println(address.vanMieu);

		
		
	}
}
