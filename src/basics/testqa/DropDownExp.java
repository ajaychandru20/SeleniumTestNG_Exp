package basics.testqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DropDownExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080"); // Maximize the window
        // Alternatively, set a custom window size
        // options.addArguments("--window-size=1920,1080");
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.leafground.com/dashboard.xhtml");
        
        
        WebElement selectNavBar = driver.findElement(By.id("menu-button"));
        selectNavBar.click();
        Thread.sleep(200);
        
        WebElement selectLinkElement = driver.findElement(By.linkText("Element"));
        selectLinkElement.click();
        
        Thread.sleep(200);
        WebElement selectLinkDropdown = driver.findElement(By.linkText("Dropdown"));
        selectLinkDropdown.click();

        Thread.sleep(200);
        WebElement selectAutomationToolDropDown = driver.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[1]/div[1]/div/div/select"));
        Select select = new Select(selectAutomationToolDropDown);
        select.selectByIndex(1);
        Thread.sleep(200);
        select.selectByVisibleText("Cypress");
        
        
        // get the list size of options in the dropdown
        
        WebElement getDropDownSize = driver.findElement(By.id("j_idt87:country_input"));
        
        Select selectSize = new Select(getDropDownSize);
        List<WebElement> countryListOptions = selectSize.getOptions();
        int sizeOfList = countryListOptions.size();
        System.out.println("the list of country is: " + sizeOfList);
        
        
     
        
        // select the dropdown using sendkeys 
        
        WebElement enterDetails = driver.findElement(By.id("j_idt87:auto-complete"));
        enterDetails.click();
        Thread.sleep(1000);
        enterDetails.sendKeys("AWS");
        enterDetails.sendKeys(Keys.ENTER);

        // multiple select the dropdown, we can use this if the tag is multiple 
        WebElement selectAllOptions = driver.findElement(By.xpath("//*[@id=\"j_idt87:lang_input\"]"));
        
        Select selectAllOpp = new Select(selectAllOptions);
        selectAllOpp.selectByIndex(0);
        selectAllOpp.selectByIndex(1);
        selectAllOpp.selectByIndex(2);
        selectAllOpp.selectByIndex(3);
        Thread.sleep(2000);
        selectAllOpp.deselectAll();
        
	}

}
