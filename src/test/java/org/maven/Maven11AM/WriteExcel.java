package org.maven.Maven11AM;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
      File f= new File("C:\\Users\\mass_\\eclipse-workspace\\first\\Maven11AM\\excel\\excel2.xlsx");
      Workbook book = new XSSFWorkbook();
      Sheet sheet = book.createSheet("balaji");
      Row r = sheet.createRow(0);
      Cell c = r.createCell(0);
      c.setCellValue("balaji");
      FileOutputStream fo = new FileOutputStream(f);
      book.write(fo);
      System.out.println("done");
	}

}
