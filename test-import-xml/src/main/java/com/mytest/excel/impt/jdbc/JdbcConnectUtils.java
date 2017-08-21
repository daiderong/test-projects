package com.mytest.excel.impt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnectUtils {

	
	private static String[] mysqlConnStr = "com.mysql.jdbc.Driver,jdbc:mysql://172.16.21.20:3306/temp_xml?characterEncoding=UTF-8,zfb,zfbdb".split(",");
	private static String[] oracleConnStr = "oracle.jdbc.driver.OracleDriver,jdbc:oracle:thin:@172.16.21.22:1521:orcl,jkbx,jkbx2013".split(",");
	private static String[] sqlServerConnStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver,jdbc:sqlserver://172.16.21.17:1433;DatabaseName=zsk,sa,saadminroot".split(",");
	
//	private static  String driver = "com.mysql.jdbc.Driver";  
//	private static  String user = "zfb";  
//	private static   String pwd = "zfbdb";
//	private static String url = "jdbc:mysql://172.16.21.20:3306/temp_xml?characterEncoding=UTF-8";
	/**
	 * 
	 */
	private static Connection mysqlConn ;
	
	/**
	 * 
	 */
	private static Connection oracleConn ;
	
	
	/**
	 * 
	 */
	private static Connection sqlServerConn ;
	
	
	
	public  static Connection getConn(DataBaseType dbtype){
		
		if(	 DataBaseType.MYSQL == dbtype){
			if(mysqlConn == null){
				mysqlConn = newConn(dbtype);
				
			}
			return mysqlConn;
		}
		else if(	 DataBaseType.ORACLE == dbtype){
			if(oracleConn  == null){
				oracleConn = newConn(dbtype);
				
			}
			return oracleConn;
		}
		else if(	 DataBaseType.SQLSERVER == dbtype){
			if(sqlServerConn  == null){
				sqlServerConn = newConn(dbtype);
			
			}
			return sqlServerConn;
		}
	
		return null;
	}
	
	
	public static Connection newConn(DataBaseType dbtype){
		String dbArray[] =  null;
		if(	 DataBaseType.MYSQL == dbtype){
			dbArray = mysqlConnStr;
		}
		else if(	 DataBaseType.ORACLE == dbtype){
			dbArray = oracleConnStr;
		}
		else if(	 DataBaseType.SQLSERVER == dbtype){
			dbArray = sqlServerConnStr;
		}
		try {
			Class.forName(dbArray[0]);  
			Connection conn  = DriverManager.getConnection(dbArray[1],dbArray[2],dbArray[3]);  
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	public static JdbcStatmentAndResult query(Connection conn,String sql,String[] objs){
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement(sql);
			int i = 1;
			if(objs!=null){
				for(String obj:objs){
					prep.setString(i, obj);
					i++;
				}
				
			}
			ResultSet result = prep.executeQuery();
			return new JdbcStatmentAndResult(prep,result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	} 
	
	
	public static boolean isQueryExists(Connection conn,String sql,String[] objs){
		
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement(sql);
			int i = 1;
			if(objs!=null){
				for(String obj:objs){
					prep.setString(i, obj);
					i++;
				}
				
			}
			ResultSet result = prep.executeQuery();
			if(result.next()){
				Object o =  result.getString(1);
				result.close();
				prep.close();
				return true;
			}
			result.close();
			prep.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	} 
	
	
	
	
	public static int insert(Connection conn,String sql,String[] objs){
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement(sql);
			int i = 1;
			if(objs!=null){
				for(String obj:objs){
					prep.setString(i++, obj);
				}
				
			}
			int exC =	 prep.executeUpdate();
			 prep.close();
			 return exC;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	} 
	
	
	
	
	public static  void close() throws SQLException{
		if(mysqlConn!=null){
			mysqlConn.close();
		}
		if(oracleConn!=null){
			oracleConn.close();
		}
		if(sqlServerConn!=null){
			sqlServerConn.close();
		}
		
		
	}
	
	
	
	
	
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
	
}
