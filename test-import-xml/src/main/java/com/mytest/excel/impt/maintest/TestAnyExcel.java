package com.mytest.excel.impt.maintest;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mytest.excel.impt.daor.OptAndAnalysis;
import com.mytest.excel.impt.daor.YbdbrsbmdzbDTO;
import com.mytest.excel.impt.jdbc.JdbcConnectUtils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestAnyExcel {

	
	public static void main(String[] args) throws SQLException {
		OptAndAnalysis optAndAnalysis = new OptAndAnalysis();
		optAndAnalysis.setAutoCommit(false);
		try {
			String outFile1 = "/Users/ddr/Desktop/import_d/收费项目.xls";

			// YPDMRSBBMDZ_ID,
			String cloumnNameStr = "序号,类型,项目唯一编号,类型,代码,名称,规格,单位,剂型,药品类型,医保主码,医保编码";
			String[] cloumnName = cloumnNameStr.split(",");
			int columnSize = cloumnName.length;
			System.out.println("columnSize:" + columnSize);
			Workbook book = Workbook.getWorkbook(new File(outFile1));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			// 从第二行开始
			int rowIndexFrom1 = 1;

			int start = rowIndexFrom1;
			int end = sheet.getRows();

			// 导入渠道
			List<YbdbrsbmdzbDTO> listData = new ArrayList<YbdbrsbmdzbDTO>();
			for (int i = start; i < end; i++) {
				YbdbrsbmdzbDTO dto = new YbdbrsbmdzbDTO();
					int j=0;
					String cell0 = sheet.getCell(j++, i).getContents();
					String cell1 = sheet.getCell(j++, i).getContents();
					String cell2 = sheet.getCell(j++, i).getContents();
					String cell3 = sheet.getCell(j++, i).getContents();
					String cell4 = sheet.getCell(j++, i).getContents();
					String cell5 = sheet.getCell(j++, i).getContents();
					String cell6 = sheet.getCell(j++, i).getContents();
					String cell7 = sheet.getCell(j++, i).getContents();
					String cell8 = sheet.getCell(j++, i).getContents();
					String cell9 = sheet.getCell(j++, i).getContents();
					String cell10 = sheet.getCell(j++, i).getContents();
					String cell11 = sheet.getCell(j++, i).getContents();
					
					dto.setXh_1(Integer.parseInt(cell0));
					dto.setLx_2(cell1);
					dto.setXmwybh_3(cell2);
					dto.setLx2_4(cell3);
					dto.setDm_5(cell4);
					dto.setYpmc_6(cell5);
					dto.setGg_7(cell6);
					dto.setDw_8(cell7);
					dto.setYpjx_9(cell8);
					dto.setYplx_10(cell9);
					dto.setYbzm_11(cell10);
					dto.setYbbm_12(cell11);
					
				   	//xh,类型	项目唯一编号	类型	代码	名称	规格	单位	剂型	药品类型	医保主码	医保编码
//					private Integer xh;
//					private String lx;
//					private String xmwybh;	
//					private String lx2;	
//					private String dm;	
//					private String ypmc;	//医院药品代码
//					private String gg; //规格
//					private String dw; //单位
//					private String ypjx; //剂型
//					private String ybzm;
//					private String ybbm; //医保编码
//					listData.add(dto);
				
					optAndAnalysis.analysis(dto);
					
					if(dto.getExportFlag()==1){
						System.out.println(dto);
					}
					if(i>0&& i%100 == 0){
						optAndAnalysis.commit();
					}
					
					
					if(i==10000){
						break;
					}
					
			}
				optAndAnalysis.commit();
			book.close();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			JdbcConnectUtils.close();
		}
	}
}
