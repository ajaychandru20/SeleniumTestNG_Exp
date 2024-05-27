package POM.DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RaiseElements {

	public static WebElement userEmail(WebDriver driver) {
		return driver.findElement(By.id("auth_login_email"));
		
	}
	public static WebElement userPassword(WebDriver driver) {
		return driver.findElement(By.id("auth_login_password"));
		
	}
	public static WebElement clickSubmit(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div/div/form/button"));
		
	}
	public static WebElement profileTab(WebDriver driver) {
		return driver.findElement(By.className("Simple_popup__BLiMa"));
	}
	
	@FindBy(xpath = "//*[@id=\"headlessui-popover-panel-2\"]/div/button")
	public static WebElement logOutButton;
	
	
}
