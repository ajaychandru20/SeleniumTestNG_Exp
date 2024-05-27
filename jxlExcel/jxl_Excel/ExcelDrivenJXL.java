package jxl_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.DataDriven.BrowserActivity;
import POM.DataDriven.orangeHRMElements;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelDrivenJXL {

	WebDriver driver;
	
	String[][] data=null; // we not set the dimensional here, we set only the value
	
	@DataProvider(name="loginDatas")
	public String[][] loginDatas() throws BiffException, IOException {
		
		data = getExcelData();
		
		return data;
		
	}
	
	@Test
	public String[][] getExcelData() throws BiffException, IOException {
		
		FileInputStream file =  new FileInputStream("C:\\Users\\AjayC\\Desktop\\Automation codes\\Excelfiles\\orderProduct.xls");
		Workbook workbook = Workbook.getWorkbook(file);
		Sheet sheets = workbook.getSheet(0);
		int RowsCount = sheets.getRows();
		int ColumnsCount = sheets.getColumns();
		String testData[][] = new String[RowsCount-1][ColumnsCount]; //we set the dimensional here, for tell the code how to store the cells
		
		// iteration 
		for (int i = 1; i < RowsCount; i++) {
			for (int j = 0; j < ColumnsCount; j++) {
				
				testData[i-1][j] = sheets.getCell(j, i).getContents();
			}
		}
		
		return testData;
		
		
	}
	
	
	@Test(dataProvider = "loginDatas")
	public void openChrome(String usName, String psWord) throws InterruptedException {
	
		// TODO Auto-generated method stub
		// Initialize the driver
		driver = BrowserActivity.startBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		orangeHRMElements.user_name(driver).sendKeys(usName);
		orangeHRMElements.pass_word(driver).sendKeys(psWord);
		orangeHRMElements.loginButton(driver).click();
		Thread.sleep(3000);
		driver.quit();
		
		
	}
	
}
