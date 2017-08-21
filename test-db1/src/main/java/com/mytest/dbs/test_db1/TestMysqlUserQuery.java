/**
 * 
 */
package com.mytest.dbs.test_db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ddr
 *
 */
public class TestMysqlUserQuery {
	   public static final String url = "jdbc:mysql://192.168.2.222/test";  
	    public static final String name = "com.mysql.jdbc.Driver";  
	    public static final String user = "dev";  
	    public static final String password = "dev_shuomao";  
	  
	    public Connection conn = null;  
	    public PreparedStatement pst = null;  
	  
	    public TestMysqlUserQuery() {  
	        try {  
	            Class.forName(name);//指定连接类型  
	            conn = DriverManager.getConnection(url, user, password);//获取连接  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	    public void close() {  
	        try {  
	            this.conn.close();  
	            this.pst.close();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    
	    
	    
	    
	   @Override
	protected void finalize() throws Throwable {
		   close();
		   System.out.println("close");
		super.finalize();
	}
	   
	   public static void main(String[] args) throws Exception {
//		   
//		   queryIsamById(1000);
//		   queryIsamById(2000);
//		   queryIsamById(5000);
//		   queryIsamById(10000);
//		   
//		   
//		   
//		
//		   queryInnerById(1000);
//		   queryInnerById(2000);
//		   queryInnerById(5000);
//		   queryInnerById(10000);
//		   
		   
//		   queryByName(5000);
		   
		   queryInnerByName(1000);
		   queryInnerByName(2000);
		   queryInnerByName(5000);
		   
//		   queryByName(1,"327a033-ba6f-49d4-b");
		   
	   }
	    
	   
	   public static void queryIsamById(int times)throws Exception{
		   
		   
		  
		   Random ra = new Random();
		   long time1 = System.currentTimeMillis();
		   TestMysqlUserQuery testMysql = new TestMysqlUserQuery();
		   PreparedStatement prep =  testMysql.conn.prepareStatement("select name from  user where id = ?");
		   for(int i=0;i<times;i++){
			   prep.setInt(1, ra.nextInt(6000000));
			   ResultSet rs =  prep.executeQuery();
			   if(rs.next()){
//				   System.out.println(rs.getString(1));
				   rs.next();
				   rs.close();
			   }
		   }
		   long time2 = System.currentTimeMillis();
		   System.out.println((time2-time1));
//		   System.out.println((time2-time1)/times);
		   testMysql.conn.close();
		   
	   } 
	   
	   
	   
	   public static void queryInnerById(int times)throws Exception{
		   
		   
		  
		   Random ra = new Random();
		   long time1 = System.currentTimeMillis();
		   TestMysqlUserQuery testMysql = new TestMysqlUserQuery();
		   PreparedStatement prep =  testMysql.conn.prepareStatement("select name from  user_inn where id = ?");
		   for(int i=0;i<times;i++){
			   prep.setInt(1, ra.nextInt(5000000+1718510));
			   ResultSet rs =  prep.executeQuery();
			   if(rs.next()){
//				   System.out.println(rs.getString(1));
				   rs.next();
				   rs.close();
			   }
		   }
		   long time2 = System.currentTimeMillis();
		   System.out.println((time2-time1));
//		   System.out.println((time2-time1)/times);
		   testMysql.conn.close();
		   
	   } 
	   
	   
	   public static void queryIsamByName(int times)throws Exception{
		   
		   
		   List<String> list = new ArrayList<String>();
		   Random ra = new Random();
		   long time1 = System.currentTimeMillis();
		   TestMysqlUserQuery testMysql = new TestMysqlUserQuery();
		   PreparedStatement prep1 =  testMysql.conn.prepareStatement("select name from  user where id = ?");
		   for(int i=0;i<times;i++){
			   prep1.setInt(1, ra.nextInt(6000000));
			   ResultSet rs =  prep1.executeQuery();
			   if(rs.next()){
				   String name = 	(rs.getString(1));
				   rs.next();
				   rs.close();
				   list.add(name);
			   }else{
					   --i;
			   }
		   } 
		   prep1.close();
		   long time2 = System.currentTimeMillis();
		   System.out.println("组装names的时间为："+(time2-time1));
		   
		   PreparedStatement prep2 =  testMysql.conn.prepareStatement("select name from  user where name = ?");
		   for(int i=0;i<list.size();i++){
			   prep2.setString(1, list.get(i));
			   ResultSet rs =  prep2.executeQuery();
			   if(rs.next()){
				   rs.next();
				   rs.close();
			   }
		   }
		   long time3 = System.currentTimeMillis();
		   System.out.println("size:"+list.size());
		   System.out.println((time3-time2));
		   testMysql.conn.close();
		   
	   } 
	   
	   
	   
	   public static void queryInnerByName(int times)throws Exception{
		   
		   
		   List<String> list = new ArrayList<String>();
		   Random ra = new Random();
		   long time1 = System.currentTimeMillis();
		   TestMysqlUserQuery testMysql = new TestMysqlUserQuery();
		   PreparedStatement prep1 =  testMysql.conn.prepareStatement("select name from  user_inn where id = ?");
		   for(int i=0;i<times;i++){
			   prep1.setInt(1, ra.nextInt(6000000));
			   ResultSet rs =  prep1.executeQuery();
			   if(rs.next()){
				   String name = 	(rs.getString(1));
				   rs.next();
				   rs.close();
				   list.add(name);
			   }else{
					   --i;
			   }
		   } 
		   prep1.close();
		   long time2 = System.currentTimeMillis();
		   System.out.println("组装names的时间为："+(time2-time1));
		   
		   PreparedStatement prep2 =  testMysql.conn.prepareStatement("select name from  user_inn where name = ?");
		   for(int i=0;i<list.size();i++){
			   prep2.setString(1, list.get(i));
			   ResultSet rs =  prep2.executeQuery();
			   if(rs.next()){
				   rs.next();
				   rs.close();
			   }
		   }
		   long time3 = System.currentTimeMillis();
		   System.out.println("size:"+list.size());
		   System.out.println((time3-time2));
		   testMysql.conn.close();
		   
	   } 
	   
	   
	   
	    
	    
	    
}
