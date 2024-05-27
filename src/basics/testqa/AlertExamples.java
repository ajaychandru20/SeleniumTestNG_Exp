package basics.testqa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExamples {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement selectBrowser = driver.findElement(By.id("menuform:j_idt39"));
		selectBrowser.click();

		WebElement selectAlert = driver.findElement(By.linkText("Alert"));
		selectAlert.click();

		Thread.sleep(2000);
		// select the basic alert dialog box

		WebElement selectSimpleAlert = driver.findElement(By.id("j_idt88:j_idt91"));
		selectSimpleAlert.click();
		Alert spAlert = driver.switchTo().alert();
		spAlert.accept();

		Thread.sleep(2000);
		// select the conform alert
		WebElement selectConformAlert = driver.findElement(By.id("j_idt88:j_idt93"));
		selectConformAlert.click();
		Alert conAlert = driver.switchTo().alert();
		conAlert.dismiss();

		Thread.sleep(2000);
		// select prompt alert box

		WebElement selectPrompAlert = driver.findElement(By.id("j_idt88:j_idt104"));
		selectPrompAlert.click();
		Alert propAlert = driver.switchTo().alert();
		propAlert.sendKeys("This is ajay");
		propAlert.accept();

		Thread.sleep(2000);
		// select dismiss alert box
		WebElement sweetAlertDismiss = driver.findElement(By.id("j_idt88:j_idt95"));
		sweetAlertDismiss.click();
		String s = driver.findElement(By.className("ui-dialog-titlebar")).getText();
		System.out.println(s);
		driver.findElement(By.id("j_idt88:j_idt98")).click();

		Thread.sleep(2000);
		// select only close alert box

		WebElement closeAlert = driver.findElement(By.id("j_idt88:j_idt100"));
		closeAlert.click();
		Thread.sleep(2000);
		driver.findElement(By
				.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/a[1]/span[1]"))
				.click();
		driver.quit();
	}

}
