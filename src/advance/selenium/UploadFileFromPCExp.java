package advance.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.object.model.TestLeafSiteElements;

public class UploadFileFromPCExp {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		TestLeafSiteElements.selectMisc(driver).click();
		TestLeafSiteElements.selectFile(driver).click();
		
		
		
		WebElement clickUpload = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt89\"]"));
		clickUpload.click();
		
		driver.switchTo().activeElement();
		
		String filePath = "C:\\Users\\AjayC\\Downloads\\TestLeaf Logo.png";
		
		StringSelection uploadPath = new StringSelection(filePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadPath, null);
		
		Thread.sleep(3000);
		
		Robot uploadAction = new Robot();
		uploadAction.keyPress(KeyEvent.VK_CONTROL);
		uploadAction.keyPress(KeyEvent.VK_V);
		uploadAction.keyRelease(KeyEvent.VK_V);
		uploadAction.keyRelease(KeyEvent.VK_CONTROL);
		uploadAction.keyPress(KeyEvent.VK_ENTER);
		uploadAction.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement checkFileName = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt89\"]/span[2]"));
		boolean fileNameCheck = checkFileName.getText().contains("TestLeaf Logo");
		System.out.println("YOur file has been uploaded in portal: " + fileNameCheck);
		
		
		
		
	}

}
