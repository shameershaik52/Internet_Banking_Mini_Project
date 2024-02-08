package com.tcs.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLLoginData {

	public static FileInputStream fileSheet;
	public static FileOutputStream  outputStream;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
	{
		fileSheet=new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fileSheet);
		ws=wb.getSheet(xlsheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fileSheet.close();
	 return rowcount;
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException 
	{
		fileSheet=new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fileSheet);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fileSheet.close();
	 return cellCount;
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException 
	{
		fileSheet=new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fileSheet);
		ws=wb.getSheet(xlsheet);
		
		row=ws.getRow(rownum);
		String cellData=row.getCell(colnum).getStringCellValue();
		
		wb.close();
		fileSheet.close();
	 return cellData;
	}
	
}
