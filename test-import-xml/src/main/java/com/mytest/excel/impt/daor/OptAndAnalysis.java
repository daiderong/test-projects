/**   
* @Title: OptAndAnalysis.java 
* @Package com.mytest.excel.impt.daor 
* @Description: TODO(用一句话描述该文件做什么) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年6月29日 下午4:54:49 
* @version V1.0   
*/
package com.mytest.excel.impt.daor;

import java.sql.SQLException;

import com.mytest.excel.impt.jdbc.DataBaseType;
import com.mytest.excel.impt.jdbc.JdbcConnectUtils;
import com.mytest.excel.impt.jdbc.JdbcStatmentAndResult;
import com.mytest.excel.impt.utils.StringUtils;

/** 
* @ClassName: OptAndAnalysis 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年6月29日 下午4:54:49 
*  
*/
public class OptAndAnalysis {
	
	
	private String XZQHDM = "310000";
	private String YYID = "13390";
	private String YYMC = "长海医院";
	private DataBaseType dbtype = DataBaseType.MYSQL;
//分页
	/*
	 
	 SELECT * FROM ( SELECT A.*, ROWNUM RN 
	FROM (SELECT * FROM TABLE_NAME) A ) WHERE RN BETWEEN 21 AND 40
	*/
	
	
	private String removeInvalidChars(String str){
		 str = WordUtils.removeParenthese(str);
		 str = WordUtils.removeInvalidChar(str);
		return str;
	}
	
	
	
	public void analysis(YbdbrsbmdzbDTO dto){
		//取得医保编码
		String ybdm = dto.getYbbm_12();
		
		//判断医保代码是否为空
		if(StringUtils.isEmpty( ybdm)){
			//过滤字符中的特殊字符
			dto.setYpmc_6(removeInvalidChars(dto.getYpmc_6()));
			//从关键字中取医保你号码
			ybdm = getZSK_DFYBYPBM(dto.getYpmc_6(),dto.getYpjx_9());
			System.out.println(dto.getYpmc_6()+"找YBBM:="+ybdm);
			//如果 医保编码依然为空，直接导出到文件
			if(StringUtils.isEmpty( ybdm)){
				dto.setExportFlag(1);
				dto.setErrorMsg(OptErrors.EXPROT_NO_MATCH_YBDM.getErrorMsg());
				return ;
			}
		}
		boolean  existCunDB =  existsYBDM(ybdm);
		if(existCunDB){
			dto.setExportFlag(0);
			dto.setErrorMsg(OptErrors.EXISTS_CURR_DB.getErrorMsg());
			return ;
		}
		
		
		if(ybdm.startsWith("Y1")){
//			//get bwm
			ybdm = "ZZZZZZZZZZZZZZZ";
			int insertC =  insert_into_TB_YYYBYPDZB_IF_NOT_EXIST( dto,ybdm);
			if(insertC >0 ){
				dto.setErrorMsg("已将DFYBYPBM设置为"+ybdm+"并入库TB_YYYBYPDZB:"+insertC);
			}
			return ;
		}else{
			int insertC = insert_into_TB_YYYBYPDZB_IF_NOT_EXIST(dto,ybdm);
			if(insertC >0 ){
				dto.setErrorMsg("入库TB_YYYBYPDZB:"+insertC);
			}
		}
		
		if(! ybdm.startsWith("YP")){
			String bwm = getZSK_BWM(ybdm);
			if(bwm == null){
				dto.setErrorMsg(OptErrors.EXPROT_NO_MATCH_BWM.getErrorMsg());
				dto.setExportFlag(1);
				return ;
			}
			String ypmlbm = getZSK_YPLMBM_by_BWM(bwm);
			if(ypmlbm == null){
				dto.setErrorMsg(OptErrors.EXPROT_NO_MATCH_YPMLBM.getErrorMsg());
				dto.setExportFlag(1);
				return ;
			}
			
			insert_into_TB_YBDMRSBBMDZB(bwm, ybdm, ypmlbm, dto);
			dto.setExportFlag(0);
			dto.setErrorMsg("OK");
			return ;
		}
		
	
			
			

		
	}
	

	/**
	 * 是否存在当前数据库中
	* @Title: existsYBDM 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ybdm 
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public boolean existsYBDM (String ybdm ){
		
		///药品名称与 YPML_DFYBYPSP.DFYBYPMC AND ybjx=DFYBJXMC 取得医保编码
		//
		String sql = "select 1 from TB_YBDMRSBBMDZB WHERE DFYBYPBM = ? ";
		String [] objs = {ybdm};
		JdbcStatmentAndResult jsr = JdbcConnectUtils.query(JdbcConnectUtils.getConn(dbtype), sql, objs);
		
			try {
				if(jsr.getResultSet().next()){
					String obj =  jsr.getResultSet().getString(1);
					if(obj!=null){
						return true;
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				jsr.close();
			}
			return false;
		
	}
	
	
	
	/**
	 * 通过刘
	* @Title: getZSK_DFYBYPBM 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ypmc
	* @param @param ypjx
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public String getZSK_DFYBYPBM (String ypmc,String ypjx){
		
		///药品名称与 YPML_DFYBYPSP.DFYBYPMC AND ybjx=DFYBJXMC 取得医保编码
		//
		
		
		String sql = "SELECT DFYBYPBM FROM YPML_DFYBYPSP where DFYBYPMC =  ? AND DFYBJXMC = ? ";
		String [] objs = {ypmc,ypjx};
		System.out.println("ypmc:"+ypmc+",ypjx:"+ypjx);
		JdbcStatmentAndResult jsr = JdbcConnectUtils.query(JdbcConnectUtils.getConn(DataBaseType.SQLSERVER), sql, objs);
		
			try {
				if(jsr.getResultSet().next()){
					String obj =  jsr.getResultSet().getString(1);
					if(obj!=null){
						return obj;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				jsr.close();
			}
			return null;
	}
	
	/**
	 * 
	* @Title: insert_into_TB_YYYBYPDZB 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dbBaseType
	* @param @param dto
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public int insert_into_TB_YYYBYPDZB_IF_NOT_EXIST (YbdbrsbmdzbDTO dto,String ybbm){
		
		/**
		 * `YYYPDM_ID` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
		  `XZQHDM` varchar(20) NOT NULL COMMENT '行政区划代码',
		  `YYID` int(16) NOT NULL COMMENT '医院ID',
		  `YYMC` varchar(100) NOT NULL COMMENT '医院名称',
		  `YYYPDM` varchar(20) NOT NULL COMMENT '医院药品代码',
		  `YYYPMC` varchar(100) NOT NULL COMMENT '医院药品名称',
		  `DFYBYPBM` varchar(20) DEFAULT NULL COMMENT '医保药品代码',
		 */
		///药品名称与 YPML_DFYBYPSP.DFYBYPMC AND ybjx=DFYBJXMC 取得医保编码
		//YYYPDM_ID
		String YYYPDM = dto.getXmwybh_3();
		{
		String sqlQe = "SELECT 1 FROM TB_YYYBYPDZB WHERE  YYID = ? AND YYYPDM = ? AND YYYPMC=? AND DFYBYPBM= ?";
		
		String [] objsQe = {YYID,YYYPDM,dto.getYpmc_6(),ybbm    };
		boolean isExist = (JdbcConnectUtils.isQueryExists(JdbcConnectUtils.getConn(dbtype), sqlQe, objsQe));
		
		if(isExist){
			return 0;
		}
		}
		String sql = "INSERT INTO TB_YYYBYPDZB (XZQHDM,YYID,YYMC,YYYPDM,YYYPMC,DFYBYPBM) values ( ?,?,?,?,?,?) " ;
		
		String [] objs = {XZQHDM,YYID,YYMC,YYYPDM,dto.getYpmc_6(),ybbm    };
		int insrtCount = JdbcConnectUtils.insert(JdbcConnectUtils.getConn(dbtype), sql, objs);
		return insrtCount;
	}
	
	
	public String getZSK_BWM (String DFYBYPBM){
		
		///药品名称与 YPML_DFYBYPSP.DFYBYPMC AND ybjx=DFYBJXMC 取得医保编码
		//
		String sql = "select BWM from YPPP_DFYBYPPPJG WHERE DFYBYPBM =  ? ";
		String [] objs = {DFYBYPBM};
		JdbcStatmentAndResult jsr = JdbcConnectUtils.query(JdbcConnectUtils.getConn(DataBaseType.SQLSERVER), sql, objs);
		
			try {
				if(jsr.getResultSet().next()){
					String obj =  jsr.getResultSet().getString(1);
					if(obj!=null){
						return obj;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				jsr.close();
			}
			return null;
	}
	
	
	/**
	 * 通过本位码得到药品人保编码
	* @Title: getZSK_YPLMBM_by_BWM 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param bwm
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public String getZSK_YPLMBM_by_BWM (String bwm){
		
		///药品名称与 YPML_DFYBYPSP.DFYBYPMC AND ybjx=DFYBJXMC 取得医保编码
		//
		String sql = "select YPMLBM from YPJC_YPSP WHERE BWM =  ? ";
		String [] objs = {bwm};
		JdbcStatmentAndResult jsr = JdbcConnectUtils.query(JdbcConnectUtils.getConn(DataBaseType.SQLSERVER), sql, objs);
			try {
				if(jsr.getResultSet().next()){
					String obj =  jsr.getResultSet().getString(1);
					if(obj!=null){
						return obj;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				jsr.close();
			}
			return null;
	}
	
	
	/**
	 * 插入最后结果表
	* @Title: insert_into_TB_YBDMRSBBMDZB 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param bwm
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public String insert_into_TB_YBDMRSBBMDZB (String BWM,String DFYBYPBM,String YPMLBM,YbdbrsbmdzbDTO dto){
		
		//YYYBDM` varchar(20) NOT NULL COMMENT '医院医保代码',
//		  `YYYBMC` varchar(100) NOT NULL COMMENT '医院医保名称',
//		  `DFYBYPBM` varchar(20) NOT NULL COMMENT '医保代码',
//		  `DFYBYPMC` varchar(100) NOT NULL COMMENT '医保药品名称',
//		  `DFYBMLBM` varchar(20) DEFAULT NULL COMMENT '医保目录编码',
//		  `DFYBJXBM` varchar(20) DEFAULT NULL COMMENT '医保剂型代码',
//		  `BWM` varchar(100) DEFAULT NULL COMMENT '人社部药品本位码',
//		  `YPMLBM` varchar(30) DEFAULT NULL COMMENT '人社部药品编码',
//		  `YPMC` varchar(100) DEFAULT NULL COMMENT '人社部药品名称',
//		String cloumnNameStr = "XZQHDM,YYYBDM,YYYBMC,DFYBYPBM,DFYBYPMC,DFYBMLBM,DFYBJXBM,BWM,YPMLBM,YPMC";
		String sql = "INSERT INTO TB_YBDMRSBBMDZB (XZQHDM,YYYBDM,YYYBMC,DFYBYPBM,DFYBYPMC,DFYBMLBM,DFYBJXBM,BWM,YPMLBM,YPMC) VALUES(?,?,?,?,?,?,?,?,?,?)";
		String [] objs = {XZQHDM,DFYBYPBM,dto.getYpmc_6(),DFYBYPBM,dto.getYpmc_6(),null,null,BWM,YPMLBM,dto.getYpmc_6()};
		
		 JdbcConnectUtils.insert(JdbcConnectUtils.getConn(dbtype), sql, objs);
			
			return null;
	}
	
	
	
	public void setAutoCommit(boolean autoCommit){
		try {
			JdbcConnectUtils.getConn(dbtype).setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("提交出现异常");
		}
	}
	
	
	public void commit(){
		try {
			JdbcConnectUtils.getConn(dbtype).commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("提交出现异常");
		}
	}
	
	
	
	
	
	
	
	
	
}
