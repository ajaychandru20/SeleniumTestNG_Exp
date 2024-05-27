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

import POM.DataDriven.BrowserActivity;
import POM.DataDriven.orangeHRMElements;

public class dataDrivenUsingPOI {

	static WebDriver driver;

	static List<String> userNameList = new ArrayList<String>();
	static List<String> passWordList = new ArrayList<String>();
	
	public void getDataFromExcel() throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\AjayC\\Desktop\\Automation codes\\Excelfiles\\orderProductPOI.xls");
		Workbook work = new HSSFWorkbook(file);
		Sheet sheet = work.getSheetAt(0);
		Iterator<Row> RowCount= sheet.iterator();
		
		while (RowCount.hasNext()) {
			Row rowsValue =RowCount.next();
			
			Iterator<Cell> columnIterate = rowsValue.iterator();
			int i=2;
			while(columnIterate.hasNext()) {
				Cell  CellValue = columnIterate.next();
				if(i%2==0) {
					userNameList.add(CellValue.toString());
				}else {
					passWordList.add(CellValue.getStringCellValue());
				}
				i++;
			}
			
		}
		
		
	}
	
	
	
	
	
	
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
	
	public void getDataFromList() throws InterruptedException {
		
		for (int i = 1; i < userNameList.size(); i++) {
			openChrome(userNameList.get(i),passWordList.get(i));	
		}
		
	};
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		dataDrivenUsingPOI usingPOI = new dataDrivenUsingPOI();
		usingPOI.getDataFromExcel();
		System.out.println("UserList: "+ userNameList);
		System.out.println("PAssword: "+ passWordList );
		usingPOI.getDataFromList();
	}



};
