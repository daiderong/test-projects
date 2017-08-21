package com.ddr.excel.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 传统excel测试，不适合导入大文件，适合小文件，
 * 数据量大是会卡死，请注意！最好不要超过10万条以上的excel
* @ClassName: ReadExcelTest 
* @author daiderong
* @date 2017年8月15日 上午10:13:45 
*
 */
public class ReadExcelTest {

	
	@Before
	public void testBefor() throws Exception {
		System.out.println("start:"+(System.currentTimeMillis()));
	}
	
	@Test
	public void testBig1() throws Exception {
		long start = System.currentTimeMillis();
		File f = new File("/ddr/haitun/20w.xlsx");
		FileInputStream fin = new FileInputStream(f);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new BufferedInputStream(fin));
		XSSFSheet sheet  = xssfWorkbook.getSheetAt(0);
		int sheetRowLen  = sheet.getLastRowNum();
		for(int i=0;i<sheetRowLen;i++){
			XSSFRow row = sheet.getRow(i);
			int cellLen = row.getLastCellNum();
			System.out.print("第"+i+"行\t");
			for(int j=0;j<cellLen;j++){
				System.out.print(row.getCell(j).getStringCellValue()+"\t");
			}
			System.out.println();
		}
		
		fin.close();
		System.out.println("used time:"+(System.currentTimeMillis()-start));
		
	}
	
	@After
	public void testAfter() throws Exception {
		System.out.println("last:"+(System.currentTimeMillis()));
//		Thread.sleep(100000);
	}
}
