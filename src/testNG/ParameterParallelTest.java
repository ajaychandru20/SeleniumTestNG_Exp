package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterParallelTest {

	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	public String chromeDriver = "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe";
	public String fireFoxDriver = "C:\\selenium webdriver\\FireFoxDriver\\geckodriver.exe";
	public String edgeDriver = "C:\\selenium webdriver\\EdgeBrowserDriver\\msedgedriver.exe";
	public WebDriver driver;

	@Test
	@Parameters("Name")
//	@Test(priority = 1)
	public void openChrome(@Optional String name) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.get(baseUrl);
		Thread.sleep(2000);
		System.out.println("The chrome browser open and quit you: " + (name != null ? name : "No Name Provided"));
		driver.quit();
	}

	@Test
//	@Test(priority = 2, enabled =true)
	public void openEdge() throws InterruptedException {

		System.setProperty("webdriver.edge.driver", edgeDriver);
		driver = new EdgeDriver();
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.quit();

	}

	@Test
//	@Test(priority = 3)
	public void openFireFox() throws InterruptedException {

		try {
			System.setProperty("webdriver.gecko.driver", fireFoxDriver);
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); // Path to Firefox binary
			driver = new FirefoxDriver(options);
			driver.get(baseUrl);
			Thread.sleep(2000);
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}

}
