package advance.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.object.model.TestLeafSiteElements;

public class FrameHandelExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		// POM object
		TestLeafSiteElements.selectBrowser(driver).click();
		TestLeafSiteElements.selectFrame(driver).click();
		
		
		// inside 1 frame 
		driver.switchTo().frame(0);
		WebElement clickFirstButton = driver.findElement(By.id("Click"));
		clickFirstButton.click();
		
		String text = driver.findElement(By.id("Click")).getText();
		System.out.println(text);
		
		driver.switchTo().defaultContent();
		
		// inside multiple frame 
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		
		WebElement clickSecondButton = driver.findElement(By.id("Click"));
		clickSecondButton.click();
		
		
		String text2 = driver.findElement(By.id("Click")).getText();
		System.out.println(text2);
		
		driver.switchTo().defaultContent();
		
		
		// get the number of frame counts 
		
		List<WebElement> numbeOfFrames = driver.findElements(By.tagName("iframe"));
		int numberOfFrameCount = numbeOfFrames.size();
		System.out.println(numberOfFrameCount);
		
		
		
		
		
		
		
		

	}

}
