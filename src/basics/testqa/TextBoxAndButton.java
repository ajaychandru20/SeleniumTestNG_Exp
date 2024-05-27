package basics.testqa;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxAndButton {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]"));
        selectElement.click();

        WebElement selectTextBox = driver.findElement(By.xpath("//*[@id=\"item-0\"]"));
        selectTextBox.click();

        // enter the details in the textbox

        WebElement getFirstNameLable = driver.findElement(By.id("userName-label"));
        String firstLable = getFirstNameLable.getText();
        System.out.println(firstLable);

        WebElement enterFirstName = driver.findElement(By.id("userName"));
        enterFirstName.sendKeys("Ajay");

        // clear the text and enter again

        WebElement clearFirstName = driver.findElement(By.id("userName"));
        clearFirstName.clear();

        WebElement enterFirstName2 = driver.findElement(By.id("userName"));
        enterFirstName2.sendKeys("Ajay");

        WebElement enterEmail = driver.findElement(By.id("userEmail"));
        enterEmail.sendKeys("ajaytest@gmail.com");

        WebElement enterCurrentAddress = driver.findElement(By.id("currentAddress"));
        enterCurrentAddress.sendKeys("No: 01, Chennai, Pattabiram");

        WebElement enterPermAddress = driver.findElement(By.id("permanentAddress"));
        enterPermAddress.sendKeys("Same as Current address");

        WebElement selectSubmit = (driver.findElement(By.id("submit")));

        // Add a 2-second wait
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        selectSubmit.click();

        // Get textbox value
        WebElement getFirstName = driver.findElement(By.id("userName"));
        String firstValue = getFirstName.getAttribute("value");
        System.out.println(firstValue);

        // check textbox is editable

        WebElement checkPreviewBox = driver.findElement(By.id("output"));
        boolean checkOutput = checkPreviewBox.isEnabled();
        System.out.println(checkOutput);

        // button color

        WebElement getButtonColor = driver.findElement(By.id("submit"));
        String buttonColor = getButtonColor.getCssValue("background-color");
        System.out.println(buttonColor);

        // button position

        WebElement getButtonPosition = driver.findElement(By.id("submit"));
        Point xypoint = getButtonPosition.getLocation();
        int xValue = xypoint.getX();
        int yValue = xypoint.getY();
        System.out.println(xValue);
        System.out.println(yValue);

        // button size

        WebElement getButtonSize = driver.findElement(By.id("submit"));
        int heightSize = getButtonSize.getSize().getHeight();
        int widthSize = getButtonSize.getSize().getWidth();

        System.out.println(heightSize + "_" + widthSize);

        driver.quit();

    }

}
