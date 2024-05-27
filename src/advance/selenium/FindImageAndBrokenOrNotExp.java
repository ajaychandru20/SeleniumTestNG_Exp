package advance.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindImageAndBrokenOrNotExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/broken");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		System.out.println("Your first image");
		WebElement firstImage = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/img[1]"));
		boolean imgStatus = firstImage.getAttribute("naturalWidth").equals("0");
		
		if (imgStatus) {
			System.out.println("Your image is broken");
		}else {
			System.out.println("Your image is not broken");
		}
		
		
		System.out.println("Your second image");
		WebElement secondImage = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/img[2]"));
		boolean imgStatus2 = secondImage.getAttribute("naturalWidth").equals("0");
		
		if (imgStatus2) {
			System.out.println("Your image is broken");
		}else {
			System.out.println("Your image is not broken");
		}
		
		
		
		
	}

}
