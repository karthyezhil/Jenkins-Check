package zero.security.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadData {

	@DataProvider(name = "logInTestData")
	public String[][] getData() throws EncryptedDocumentException, IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\TestDataLogIn.xlsx";
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);

		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("loginTest");
		int totalRow = sheet.getLastRowNum();
		Row row = sheet.getRow(0);
		int totalColumn = row.getLastCellNum();
		String testData[][] = new String[totalRow][totalColumn];
		DataFormatter dataFormatter = new DataFormatter();
		for (int i = 1; i <= totalRow; i++) {
			for (int j = 0; j < totalColumn; j++) {
				testData[i - 1][j] = dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return testData;
	}

	@DataProvider(name = "logOutTestData")
	public Object[][] testdata() {
		return new Object[][] { { "username", "password" }};
	}
	
	@DataProvider(name = "loginCredentials")
	public Object[][] loginCredentials() {
		return new Object[][] { { "username", "password" }};
	}

}
