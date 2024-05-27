package loginTest.withoutDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.DataDriven.orangeHRMElements;

public class BothCorrectLogin {

	@Test
	public void bothCorrectLogin() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		orangeHRMElements.user_name(driver).sendKeys("Admin");
		
		orangeHRMElements.pass_word(driver).sendKeys("admin123");
		orangeHRMElements.loginButton(driver).click();
		
		Thread.sleep(2000);
		WebElement containDashboard = driver.findElement(By.linkText("Dashboard"));
		
		Assert.assertNotNull(containDashboard); 
		
		driver.quit();
		
		
	}
	
}
