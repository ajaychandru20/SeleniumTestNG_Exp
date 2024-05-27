package advance.selenium;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.object.model.TestLeafSiteElements;


public class WindowsHandlerExp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// in the TestLeafSite we used, without static so that we need to specify the class 
		TestLeafSiteElements testLeafClass = new TestLeafSiteElements();
		testLeafClass.selectBrowserWithoutStatic(driver).click();
		
		

		WebElement selectWindows = driver.findElement(By.linkText("Window"));
		selectWindows.click();

		String oldWindow = driver.getWindowHandle();

		// handel single window
		WebElement selectSingleWindow = driver.findElement(By.id("j_idt88:new"));
		selectSingleWindow.click();

		Set<String> handler = driver.getWindowHandles();

		for (String newWindow : handler) {

			driver.switchTo().window(newWindow);
			// Check if this is the new window/tab by comparing its title or URL
			if (driver.getTitle().equals("Dashboard")) {
				// Perform actions on the new window/tab
				// For example, you can assert that the new dashboard is opened
				if (driver.getTitle().equals("Dashboard")) {
					System.out.println("Dashboard is opened in a new tab");
				} else {
					System.out.println("Dashboard is not opened in a new tab");
				}
				// Close the new window/tab
				driver.close();
				// Switch back to the original window/tab
				driver.switchTo().window(oldWindow);
				break;
			}

		} // for each

		// open multiple windows and close all windows except parent

		WebElement openMultipleWin = driver.findElement(By.id("j_idt88:j_idt91"));
		openMultipleWin.click();

		int numberOfWindowsSize = driver.getWindowHandles().size();
		System.out.println("number of windows opened: " + numberOfWindowsSize);

		Set<String> multipleWindows = driver.getWindowHandles();

		for (String multiWin : multipleWindows) {
			if (!oldWindow.equals(multiWin)) {
				driver.switchTo().window(multiWin);
				System.out.println("your are currentlty on this window: " + driver.getTitle());
				driver.close();
			}

		}//for each

		driver.switchTo().window(oldWindow);

	}

}
