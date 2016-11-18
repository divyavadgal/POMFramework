package com.DDT;
//github.............https://github.com/divyavadgal/POMFramework.git
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Workbook;
//one more

public class ExcelLib {
	
	HSSFWorkbook workbook=null;
	static HSSFSheet sheet=null;
	static Hashtable flaggedMethod=new Hashtable();
	static Map m=null;
	
	public ExcelLib(String path, String sheetName) throws IOException {
		FileInputStream fio=new FileInputStream(new File(path));
		workbook=new HSSFWorkbook(fio);
		sheet=workbook.getSheet(sheetName);
		
	}
	
	public static int getRowCount(){
		return sheet.getLastRowNum()+1;
	}
	
	public static String[][] columnDictionary(){
		int trow=sheet.getLastRowNum()+1;
		int tcol=sheet.getRow(0).getLastCellNum();
		String[][] s = new String[trow][tcol];
		for(int i=0;i<trow;i++){
			for(int j=0;j<tcol;j++){
				s[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();	
		
			}
		}
		return s;
	}
	
	public static String readDataXl(int row,String colHeader){
		String[][] s=columnDictionary();
		int col=getCell(colHeader);
		String data= s[row][col];
		System.out.println("data="+data);
		return data;
	}
	
	public static void readHeaderData(){
		m=new HashMap();
		for(int col=0;col<sheet.getRow(0).getLastCellNum();col++){
			m.put(sheet.getRow(0).getCell(col).getStringCellValue(), col);
		}
	}
	//get map value using key where key is xlsheet column header
	public static int getCell(String columnHeaderData){
		readHeaderData();
		return (Integer) m.get(columnHeaderData);
	}
	
	public static Hashtable GetFlaggedMethods(String ColumnName) {
		
		try {
			// Load all the dictionary
			readHeaderData();
			
			int methodcount = 1; // keycount flag will track of
									// method count
			for (int row = 0; row < getRowCount(); row++) {
				if (readDataXl(row,ColumnName).equals("y")) {
					// put method keycount and the method name
					flaggedMethod.put(methodcount, readDataXl( row,"MethodName")+ ";" + readDataXl(row,"ExcelName"));
					methodcount++;
				}
					}
 
		} catch (Exception e) {
 
		}

		return flaggedMethod;
	}
	
}
