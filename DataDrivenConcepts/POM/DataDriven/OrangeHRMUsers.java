package POM.DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRMUsers {

	public static WebElement userEmail(WebDriver driver) {
		return driver.findElement(By.name("username"));
		
	}
	public static WebElement userPassword(WebDriver driver) {
		return driver.findElement(By.name("password"));
		
	}
	public static WebElement clickSubmit(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		
	}
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")
	public static WebElement profileButton;
	
	@FindBy(linkText = "Logout")
	public static WebElement logOut;
	
}
