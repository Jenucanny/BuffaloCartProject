package com.buffalocart.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public XSSFSheet sheet;
	public ExcelUtility() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\HI\\eclipse-workspace\\BuffaloCartProject\\src\\main\\resources\\excel.xlsx");	
		XSSFWorkbook book=new XSSFWorkbook(fis);
		sheet=book.getSheet("Sheet1");
			
	}	
	public String readData(int row,int column)
	{
		Row r=sheet.getRow(row);
		Cell c=r.getCell(column);
		int cellType=c.getCellType();
		switch(cellType) {
		case Cell.CELL_TYPE_NUMERIC:
		{
			double data1=c.getNumericCellValue();
			int data=(int)data1;
			return String.valueOf(data); //convert to string
		}
		case Cell.CELL_TYPE_STRING:{
			return c.getStringCellValue();
		}	
		}
		return null;
		
	}


}
