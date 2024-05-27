package basics.testqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownWithoutSelectExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        
        
        WebElement selectBox = driver.findElement(By.id("account_dd"));
        selectBox.click();
        
        List<WebElement> countryOptions = driver.findElements(By.xpath("//li[@id=\"account_dd\"]/div[2]/ul/li"));
        
        for (WebElement element:countryOptions) {
			if(element.getText().equalsIgnoreCase("Show my ticket")) {
				Thread.sleep(3000);
				System.out.println(element.getText());
				element.click();
			}
		}
        
        

        
        
        
		
		
	}

}
