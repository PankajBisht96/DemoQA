package demoQA.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSReader {
	public String path = null;
	public FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	public XLSReader(String path) {
		this.path = path;
		try {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1) {
			return 0;
		}else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}
	
	public int getColumnsCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1) {
			return 0;
		}else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getRow(1).getLastCellNum()+ 1;
			return number;
		}
	}
	
	public String getCellData(String sheetName, String columnName, int rowNum) {
		
		if(rowNum<=0)
		return "";
		int index = workbook.getSheetIndex(sheetName);
		int colNum = -1;
		
		if (index == -1)
			return "";
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(0);
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if((row.getCell(i).getStringCellValue().trim()).equals(columnName.trim()))
			{
				colNum=i;
			}
		}
		if (colNum == -1)
			return"";
		
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return"";
		
		cell = row.getCell(colNum);
		if(cell == null)
			return "";
//		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		return cell.getStringCellValue();
	}
	
//	String FilePath = ".\\TestData\\ElementsTab.xlsx";

}
