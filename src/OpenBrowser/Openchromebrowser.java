package OpenBrowser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Openchromebrowser {

	public static void main(String[] args) throws IOException {
		

		FileInputStream stream = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(stream);
		
		String browser = properties.getProperty("browser");
		String filePath = properties.getProperty("DriverLocation");
		
		if (browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",filePath);
			
			
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",filePath);
		}
		
//		System.setProperty("webdriver.chrome.broswer","C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.edureka.co");
		System.out.println(driver.getTitle());
		driver.quit();
		
	}
}