package OpenBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Openchromebrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.broswer","C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.edureka.co");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
