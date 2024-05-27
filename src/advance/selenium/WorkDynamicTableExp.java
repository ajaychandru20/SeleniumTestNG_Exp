package advance.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.object.model.TestLeafSiteElements;

public class WorkDynamicTableExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		Thread.sleep(2000);
		
		TestLeafSiteElements.selectTable(driver).click();
		TestLeafSiteElements.selectTheTable(driver).click();
		
		// table - header: //div[@ id="form:j_idt89"]/div/div/table/thead/tr/th[5]
		// table- body:  //table/tbody[@id="form:j_idt89_data"]/tr/td[5]
		
		// get the total number of header names 
		
		List<WebElement> listOfHeaders = driver.findElements(By.xpath("//div[@ id=\"form:j_idt89\"]/div/div/table/thead/tr/th"));
		int countOfHeaders = listOfHeaders.size(); 
		System.out.println(countOfHeaders);
		
		for (WebElement webElement : listOfHeaders) {
			
			System.out.println(webElement.getText());
		}
		
		
		// get the status in the tbody
		
		List<WebElement> listOfStatus=driver.findElements(By.xpath("//table/tbody[@id=\"form:j_idt89_data\"]/tr/td[5]"));
		int countOfList = listOfStatus.size();
		System.out.println(countOfList);
		
		for (WebElement webElement : listOfStatus) {
			
			System.out.println(webElement.getText());
			
		}
		
		
		
		

	}

}
