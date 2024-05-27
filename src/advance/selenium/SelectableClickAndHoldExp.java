package advance.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SelectableClickAndHoldExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.switchTo().frame(0);
		
		List<WebElement> selectableList = driver.findElements(By.xpath("//*[@id=\"selectable\"]/li"));
		int numberOfList = selectableList.size();
		System.out.println("number of selectable in the list: "+numberOfList);
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL)
		.click(selectableList.get(0))
		.click(selectableList.get(1))
		.click(selectableList.get(2)).build().perform();
		
		
		action.clickAndHold(selectableList.get(3)).release().build().perform();
		
		
		
		
		
	}

}
