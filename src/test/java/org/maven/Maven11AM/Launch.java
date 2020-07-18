 package org.maven.Maven11AM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Launch {

	public static void main(String[] args) throws IOException {
		File fl = new File("C:\\Users\\mass_\\eclipse-workspace\\first\\Maven11AM\\excel\\excel1.xlsx");
		FileInputStream file = new FileInputStream(fl);
	    Workbook book = new XSSFWorkbook(file);
		Sheet sheet = book.getSheet("Sheet2");
		Row trow = sheet.getRow(0);
		Cell cell = trow.getCell(0);
		System.out.println(cell);
		int cells = trow.getPhysicalNumberOfCells();
		System.out.println(cells);
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
		    Row x= sheet.getRow(i); 
		for (int j = 0; j <x.getPhysicalNumberOfCells() ; j++) {
		    Cell z = x.getCell(j); 
			System.out.println(z);
		}
		}
	    int type = cell.getCellType();
	    if (type==1) {
	    	System.out.println(type);
	    	String str = cell.getStringCellValue();
	    	System.out.println(str);
	    }
	    else {
	    	System.out.println(type);
	    	double d = cell.getNumericCellValue();
		    System.out.println(d);
		    String a= String.valueOf(d);
		    System.out.println(a);
		    Long lo = (long) d;
		    System.out.println(lo);
	    }
	    Cell cell2 = trow.getCell(5);
	    if (DateUtil.isCellDateFormatted(cell2)) {
	    	Date dt = cell2.getDateCellValue();
			System.out.println(dt);
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
			String format = s.format(dt);
			System.out.println(format);
		}
	    String s = cell.getStringCellValue();
	    if(s.equals("balaji")) {
	    	cell.setCellValue("bala");
	    	System.out.println("done");
	    }
	    FileOutputStream fo = new FileOutputStream(fl);
	    book.write(fo);
	}

}
