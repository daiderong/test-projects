package com.mytest.excel.impt.daor;

public class YbdbrsbmdzbDTO {

	
	
//	`YYYPDM_ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
//	  `XZQHDM` varchar(20) NOT NULL COMMENT '行政区划代码',
//	  `YYID` int(16) NOT NULL COMMENT '医院ID',
//	  `YYMC` varchar(100) NOT NULL COMMENT '医院名称',
//	  `YYYPDM` varchar(20) NOT NULL COMMENT '医院药品代码',
//	  `YYYPMC` varchar(100) NOT NULL COMMENT '医院药品名称',
//	  `DFYBYPBM` varchar(20) DEFAULT NULL COMMENT '医保药品代码',
	private Integer xh_1;
	private String lx_2;
	private String xmwybh_3;	
	private String lx2_4;
	private String dm_5;	
	private String ypmc_6;	//医院药品代码
	private String gg_7; //规格
	private String dw_8; //单位
	private String ypjx_9; //剂型
	private String yplx_10;
	private String ybzm_11;
	private String ybbm_12; //医保编码
	
//	类型	项目唯一编号	类型	代码	名称	规格	单位	剂型	药品类型	医保主码	医保编码
//	医院自行编码							剂型		医保编码
//药品	19652	A	A11AA01IA	(乙10%)脂溶性维生素注射剂(II)☆	10ML(锡华瑞)	支	输液剂	西成药		X00323740010010
	
	
	
	private String errorMsg;
	private Integer exportFlag = 0;
	
	
	
	
	
	
	
	
	
	
	public Integer getXh_1() {
		return xh_1;
	}
	public void setXh_1(Integer xh_1) {
		this.xh_1 = xh_1;
	}
	public String getLx_2() {
		return lx_2;
	}
	public void setLx_2(String lx_2) {
		this.lx_2 = lx_2;
	}
	public String getXmwybh_3() {
		return xmwybh_3;
	}
	public void setXmwybh_3(String xmwybh_3) {
		this.xmwybh_3 = xmwybh_3;
	}
	public String getLx2_4() {
		return lx2_4;
	}
	public void setLx2_4(String lx2_4) {
		this.lx2_4 = lx2_4;
	}
	public String getDm_5() {
		return dm_5;
	}
	public void setDm_5(String dm_5) {
		this.dm_5 = dm_5;
	}
	public String getYpmc_6() {
		return ypmc_6;
	}
	public void setYpmc_6(String ypmc_6) {
		this.ypmc_6 = ypmc_6;
	}
	public String getGg_7() {
		return gg_7;
	}
	public void setGg_7(String gg_7) {
		this.gg_7 = gg_7;
	}
	public String getDw_8() {
		return dw_8;
	}
	public void setDw_8(String dw_8) {
		this.dw_8 = dw_8;
	}
	public String getYpjx_9() {
		return ypjx_9;
	}
	public void setYpjx_9(String ypjx_9) {
		this.ypjx_9 = ypjx_9;
	}
	public String getYplx_10() {
		return yplx_10;
	}
	public void setYplx_10(String yplx_10) {
		this.yplx_10 = yplx_10;
	}
	public String getYbzm_11() {
		return ybzm_11;
	}
	public void setYbzm_11(String ybzm_11) {
		this.ybzm_11 = ybzm_11;
	}
	public String getYbbm_12() {
		return ybbm_12;
	}
	public void setYbbm_12(String ybbm_12) {
		this.ybbm_12 = ybbm_12;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Integer getExportFlag() {
		return exportFlag;
	}
	public void setExportFlag(Integer exportFlag) {
		this.exportFlag = exportFlag;
	}

	
	
	@Override
		public String toString() {
			return  xh_1
			+" | "+lx_2
			+" | "+xmwybh_3	
			+" | "+lx2_4
			+" | "+dm_5	
			+" | "+ypmc_6	//医院药品代码
			+" | "+gg_7 //规格
			+" | "+dw_8 //单位
			+" | "+ypjx_9 //剂型
			+" | "+yplx_10 //药品类型
			+" | "+ybzm_11
			+" | "+ybbm_12 //医保编码
			+" | "+exportFlag
			+" | "+errorMsg;
			
		}
	
	
	
	
	
	
	
}
