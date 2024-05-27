package POM.DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNG {

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
		
	String [][]	data = {
				{"Admin","admin123"},
				{"Ajay","admin123"},
				{"Admins","admins"},
				{"Admin", "12345"}
		};
	
	
	@DataProvider(name="DataContains")
	public String[][] getUsersData() {
		return data;
		
	}
	
	@Test(dataProvider = "DataContains")
	public void loginHMRCPortal(String uName, String pWord) throws InterruptedException {
		
		
		orangeHRMElements.user_name(driver).sendKeys(uName);
		orangeHRMElements.pass_word(driver).sendKeys(pWord);
		orangeHRMElements.loginButton(driver).click();
		Thread.sleep(3000);
		
		
		
		if (isDashboardDisplayed()) {
			System.out.println("Login sucessfull!!!");
		}else {
			
			WebElement containMessage = driver.findElement(By.xpath("// div[@class=\"orangehrm-login-error\"]/div/div/p"));
			String errorMess = containMessage.getText();
			Assert.assertNotNull(errorMess);
			System.out.println(errorMess);
			
		}
			
	}

	private boolean isDashboardDisplayed() {
		// TODO Auto-generated method stub
		try {
			WebElement pageDashboard = driver.findElement(By.linkText("Dashboard"));
            return pageDashboard.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
}
