package testNG;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalenderwithDependency {

	private String formattedDate;
	private String formatCurrentDate;
	private WebDriver driver; // Define driver as a class-level variables

	@Test(enabled = true)
	public void loginDemoQAPlatform() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");

	}

	@Test(dependsOnMethods = "loginDemoQAPlatform")
	public void selectCalenderinsideTable() throws InterruptedException {
		// if we using POM
//      TestLeafSiteElements.selectTable(driver).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,375)", "");

		WebElement DateContains = driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
		String dateStr = DateContains.getAttribute("value");
		System.out.println(dateStr);
		DateContains.click();
		Thread.sleep(2000);

		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

		try {

			Date date = dateFormat.parse(dateStr);

			// Format the date to the desired format
			DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
			formattedDate = outputFormat.format(date);
			System.out.println(formattedDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Get the current date
		Date currentDate = new Date();

		DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");

		// Format the current date using the SimpleDateFormat object
		formatCurrentDate = dateFormat2.format(currentDate);

		WebElement clickPreviousButton = driver.findElement(By.xpath("//button[@aria-label='Previous Month']"));

		int timesOfClick = 3;

		if (formattedDate.equals(formatCurrentDate)) {

			System.out.println("changing the date to previous");
			for (int i = 0; i <= timesOfClick; i++) {

				clickPreviousButton.click();
			}

			int day = 1; // Example: Day number
			String xpath = "//*[@aria-label='Choose Monday, January " + day + "st, 2024']";
			WebElement dateElement = driver.findElement(By.xpath(xpath));
			dateElement.click();
			WebElement DateContains2 = driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
			String dateStr2 = DateContains2.getAttribute("value");
			System.out.println("this is the date after we select in the calender: " + dateStr2);

		} else {
			System.out.println("the date is past only: " + formatCurrentDate);
		}
	}

}
