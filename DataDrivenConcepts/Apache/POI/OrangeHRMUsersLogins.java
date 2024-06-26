package Apache.POI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import POM.DataDriven.BrowserActivity;
import POM.DataDriven.OrangeHRMUsers;

public class OrangeHRMUsersLogins {

	WebDriver driver;
	static List<String> userNameList = new ArrayList<String>();
	static List<String> passWordList = new ArrayList<String>();
	static List<String> invalidUserNameList = new ArrayList<String>();
	static List<String> invalidPassWordList = new ArrayList<String>();
	private static final String FILE_PATH = "C:\\Users\\AjayC\\Desktop\\Automation codes\\Excelfiles\\orangeHRMUsers.xls";
    private static final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public static String location = "OrangeHRMUsersData.txt";
    
    
    
	public void getExcelData() throws IOException {

		FileInputStream file = new FileInputStream(
				FILE_PATH);
		try (Workbook workBooks = new HSSFWorkbook(file)) {
			Sheet sheet = workBooks.getSheet("ExternalLogins");

			Iterator<Row> rowsCount = sheet.iterator();
			while (rowsCount.hasNext()) {
				Row rowsValue = rowsCount.next();
				Iterator<Cell> columnCount = rowsValue.iterator();
				int i = 2;
				while (columnCount.hasNext()) {
					Cell cellValue = columnCount.next();
					if (i % 2 == 0) {
						userNameList.add(cellValue.getStringCellValue());
					} else {
						passWordList.add(cellValue.getStringCellValue());
					}
					i++;
				}

			}
		}

	}

	
	public void iteratorLogins() throws InterruptedException, IOException {
		for (int i = 1; i < userNameList.size(); i++) {
			loginAppPortal(userNameList.get(i), passWordList.get(i));
		}
	}


	public void loginAppPortal(String usName, String psWord) throws InterruptedException, IOException {
	    
		driver = BrowserActivity.startBrowser(URL);
		OrangeHRMUsers.userEmail(driver).sendKeys(usName);
		OrangeHRMUsers.userPassword(driver).sendKeys(psWord);
		OrangeHRMUsers.clickSubmit(driver).click();
		Thread.sleep(3000);
		String currentURL = driver.getCurrentUrl();
		boolean logindone = currentURL.contains("dashboard");
		if (logindone) {
			System.out.println("The user Name and password are Correct: " + usName + " " + psWord);
			Thread.sleep(1000);
			PageFactory.initElements(driver, OrangeHRMUsers.class);
			Thread.sleep(1000);
			OrangeHRMUsers.profileButton.click();
			Thread.sleep(500);
			OrangeHRMUsers.logOut.click();
			driver.quit();
		} else {
			System.out.println("Invalid users: " + usName + " " + psWord);
			invalidUserNameList.add(usName);
			invalidPassWordList.add(psWord);
			driver.quit();
		}



	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		OrangeHRMUsersLogins usingPOI = new OrangeHRMUsersLogins();
		usingPOI.getExcelData();
		System.out.println(userNameList);
		System.out.println(passWordList);
		usingPOI.iteratorLogins();
		System.out.println(invalidUserNameList);
		System.out.println(invalidPassWordList);

	}

}
