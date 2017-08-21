package com.ddr.excel.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ddr.excel.test.util.BigExcelReadHandle;

/**
 * 针对大文件读取做测试
 * BigExcelReadUtil
 * 
* @ClassName: BigExcelReadTest 
* @author daiderong
* @date 2017年8月15日 上午10:17:38 
*
 */
public class BigExcelReadTest {

	
	@Before
	public void testBefor() throws Exception {
		System.out.println("start:"+(System.currentTimeMillis()));
	}
	
	@Test
	public void testBig2() throws Exception {
		long start = System.currentTimeMillis();
		BigExcelReadHandle eu = new BigExcelReadHandle();
		try {
			eu.readOneSheet("/ddr/haitun/small.xlsx");
		} finally {
			System.out.println("row:"+eu.getRowlist());
		}
		
		System.out.println("row :"+eu.getRow());
		long usedTime = (System.currentTimeMillis()-start);
		System.out.println("used time:"+usedTime);
		System.out.println("avg :"+usedTime*1.0f/eu.getRow());
		
	}
	
	@After
	public void testAfter() throws Exception {
		System.out.println("last:"+(System.currentTimeMillis()));
	}
}
