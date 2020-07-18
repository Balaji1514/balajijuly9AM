package org.maven.Maven11AM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
    static WebDriver driver;  
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		return driver;
	}
	public static void loadUrl(String url) {
	 driver.get(url);
	}
	public static String readFromExcel(int rowno, int coloumnno) throws IOException {
		File fl = new File("C:\\Users\\mass_\\eclipse-workspace\\first\\Maven11AM\\excel\\excel1.xlsx");
		FileInputStream file = new FileInputStream(fl);
	    Workbook book = new XSSFWorkbook(file);
		Sheet sheet = book.getSheet("Sheet2");
		Row trow = sheet.getRow(rowno);
		Cell cell = trow.getCell(coloumnno);
		String name ="";
		int type = cell.getCellType();
		if (type==1) {
			name = cell.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(cell)){
			 SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		     name = date.format(cell);
			}else {
				double d = cell.getNumericCellValue();
				Long lo= (long) d;
			    name = String.valueOf(lo);
			}
		}
		return name;	
	}
	public static void type(WebElement element,String value) {
		element.sendKeys(value);
	}
	public static void btnclick(WebElement element) {
		element.click();
	}
}
