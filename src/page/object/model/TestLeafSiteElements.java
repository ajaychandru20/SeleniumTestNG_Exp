package page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestLeafSiteElements {

	public WebElement navBar(WebDriver driver) {
		return driver.findElement(By.id("menu-button"));
		
	}
	
	// without static so we have to create class in the respective script file
	public WebElement selectBrowserWithoutStatic(WebDriver driver) {
		return driver.findElement(By.id("menuform:j_idt39"));
	}
	public static WebElement selectBrowser(WebDriver driver) {
		return driver.findElement(By.id("menuform:j_idt39"));
	}
	public static WebElement selectFrame(WebDriver driver) {
		return driver.findElement(By.linkText("Frame"));
	}
	public static WebElement selectDrag(WebDriver driver) {
		return driver.findElement(By.linkText("Drag"));
	}
	
	
	public static WebElement selectElement(WebDriver driver) {
		return driver.findElement(By.id("menuform:j_idt40"));
	}
	
	public static WebElement selectTable(WebDriver driver) {
		return driver.findElement(By.id("menuform:j_idt41"));	
	}
	
		public static WebElement selectTheTable(WebDriver driver) {
			return driver.findElement(By.xpath("//*[@id=\"menuform:m_table\"]"));	
		}
		
	
	public static WebElement selectList(WebDriver driver) {
		return driver.findElement(By.id("menuform:j_idt42"));
	}
	
	public static WebElement selectMisc(WebDriver driver) {
		return driver.findElement(By.id("menuform:j_idt43"));
	}
	public static WebElement selectFile(WebDriver driver) {
		return driver.findElement(By.linkText("File"));
	}
	
	
}
