package advance.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/autocomplete/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.switchTo().frame(0);
		
		WebElement enterTag = driver.findElement(By.id("tags"));
		enterTag.sendKeys("a");
		
		Thread.sleep(2000);
		
		List<WebElement> suggestList = driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]/li"));
		int listOfCount =suggestList.size();
		System.out.println(listOfCount);
		
		for (WebElement webElement : suggestList) {
			
			if (webElement.getText().contains("JavaS")) {
				System.out.println("Selected tags is: " + webElement.getText());
				webElement.click();
				break;
			}
		}
	}

}
