package com.mytest.excel.impt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.mytest.excel.impt.utils.StringUtils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Read_YYYBYPDZB_Excel {

	public static void main(String[] args) {

		try {
			String fileName = "标准库药品导入_线上购药_0630";//不用后缀，必须是xls
			String outFile1 = "/Users/ddr/Desktop/abc/"+fileName+".sql";
			if (!new File(outFile1).exists()) {
				new File(outFile1).createNewFile();
			}
			BufferedWriter writer1 = new BufferedWriter(new FileWriter(outFile1));

			// YPDMRSBBMDZ_ID,
			
			
			String cloumnNameStr = "XZQHDM,YYID,YYMC,YYYPDM,YYYPMC,DFYBYPBM";
			String[] cloumnName = cloumnNameStr.split(",");
			int columnSize = cloumnName.length;
			System.out.println("columnSize:" + columnSize);
			Workbook book = Workbook.getWorkbook(new File("/Users/ddr/Desktop/abc/"+fileName+".xls"));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 从第二行开始
			int rowIndexFrom1 = 1;

			int start = rowIndexFrom1;
			int end = sheet.getRows();

			// 导入渠道
			for (int i = start; i < end; i++) {
				String insertSQL = "INSERT INTO temp_YYYBYPDZB(" + cloumnNameStr + ") VALUES(";
				for (int j = 0; j < columnSize; j++) {
					if (j > 0) {
						insertSQL += ",";
					}
					String cell0 = sheet.getCell(j, i).getContents();
					insertSQL += (StringUtils.isEmpty(cell0)) ? "NULL" : ("'" + cell0.trim() + "'");
				}
				insertSQL += ");";
				System.out.println(insertSQL);
				writer1.write(insertSQL);
			}

			book.close();
			writer1.flush();
			writer1.close();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
