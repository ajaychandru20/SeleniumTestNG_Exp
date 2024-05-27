package advance.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SortableExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/sortable");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		List<WebElement> sortableList = driver.findElements(By.xpath("//*[@id=\"demo-tabpane-list\"]/div/div"));
		int totalSize = sortableList.size();
		System.out.println(totalSize);
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(sortableList.get(0));
		actions.moveToElement(sortableList.get(5));
		actions.release(sortableList.get(5));
		actions.build().perform();
		
	}

}
