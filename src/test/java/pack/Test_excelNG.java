package pack;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_excelNG extends Base {
	
	DataFormatter formatter = new DataFormatter();

	@Test(dataProvider = "driveTest")
	public void testCaseData(String log, String mdp) throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(log);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(mdp);

	}

	@DataProvider(name = "driveTest")
	public Object[][] getData() throws IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\21653\\Desktop\\selenium_formation\\login.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheetAt(0);
	int rowCount = sheet.getPhysicalNumberOfRows();
	XSSFRow row = sheet.getRow(0);
	int colCount = row.getLastCellNum();
	Object data[][] = new Object[rowCount -1][colCount];
	for (int i = 0; i < rowCount  -1 ; i++) {
	row = sheet.getRow(i);
	for (int j = 0; j < colCount; j++) {
	XSSFCell cell = row.getCell(j);

	data[i][j] = formatter.formatCellValue(cell);

	}
	}
	return data;

	}

}
