package basics.testqa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement selectElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/form[2]/ul/li[3]"));
		selectElement.click();

		Thread.sleep(200);
		WebElement selectRadioButton = driver.findElement(By.linkText("Radio Button"));
		selectRadioButton.click();
		
		Thread.sleep(2000);
		
		// Select a radio button from a group where no radio button is initially selected
		List<WebElement> radioButtons = driver.findElements(By.xpath("//table[@id='j_idt87:console1']/tbody/tr/td/div"));

		for (WebElement radioButton : radioButtons) {
		    if (!radioButton.isSelected()) {
		        radioButton.click();
		        Thread.sleep(1000); // Assuming there's some action you're waiting for after clicking
		    }
		}

		List<WebElement> radioButtonsName = driver.findElements(By.xpath("//table[@id='j_idt87:console1']/tbody/tr/td/label"));
		for (WebElement radioButtonName : radioButtonsName) {
		    System.out.println("The browser " + radioButtonName.getText() + " is selected");
		}


		
		

		
		
	}

}
