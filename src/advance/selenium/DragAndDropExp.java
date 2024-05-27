package advance.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import page.object.model.TestLeafSiteElements;

public class DragAndDropExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		// POM object
		TestLeafSiteElements.selectBrowser(driver).click();
		TestLeafSiteElements.selectDrag(driver).click();
		
		
		WebElement selectFromDrag = driver.findElement(By.id("form:drag_content"));
		WebElement placeToDrop = driver.findElement(By.id("form:drop_content"));
		
		Actions action = new Actions(driver);
		
		// more detail 
//		action.clickAndHold(selectFromDrag).moveToElement(placeToDrop).release().build().perform();
		
		// pre build method 
		action.dragAndDrop(selectFromDrag, placeToDrop).build().perform();
		
		WebElement getActionAfterDrop = driver.findElement(By.id("form:drop_content"));
		String text = getActionAfterDrop.getText();
		System.out.println(text);
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,275)", "");
		
		
		WebElement imageElement = driver.findElement(By.xpath("//img[@id='form:logo']"));
		
		int widthImg = imageElement.getSize().getWidth();
		int heightImg = imageElement.getSize().getHeight();
		
		// Width:428,Height:139
		// Width:277,Height:139
		
		System.out.println(widthImg + " " + heightImg);
		
		action.dragAndDropBy(imageElement, 200, 0).build().perform();

		
		
		
	}

}
