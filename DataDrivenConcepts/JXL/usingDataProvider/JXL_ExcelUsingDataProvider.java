package JXL.usingDataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class JXL_ExcelUsingDataProvider {

	public WebDriver driver ;
	@BeforeMethod
	public void visitPortal() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
