package advance.selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.object.model.TestLeafSiteElements;

public class DownloadAndVerifyFileInPC {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		TestLeafSiteElements.selectMisc(driver).click();
		TestLeafSiteElements.selectFile(driver).click();

		WebElement clickDownload = driver.findElement(By.id("j_idt93:j_idt95"));
		clickDownload.click();
		Thread.sleep(3000);

		File verifyThePath = new File("C:\\Users\\AjayC\\Downloads");
		File[] listOfFiles = verifyThePath.listFiles();

		for (File file : listOfFiles) {

			if (file.getName().contains("TestLeaf Lo")) {
				
				System.out.println("The File is downloaded in the pc: " + file.getName());
				break;
			}
			
		}

	}

}
