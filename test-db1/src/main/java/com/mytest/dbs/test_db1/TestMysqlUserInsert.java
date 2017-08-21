/**
 * 
 */
package com.mytest.dbs.test_db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author ddr
 *
 */
public class TestMysqlUserInsert {
	   public static final String url = "jdbc:mysql://192.168.2.209/test";  
	    public static final String name = "com.mysql.jdbc.Driver";  
	    public static final String user = "dev";  
	    public static final String password = "123456";  
	  
	    public Connection conn = null;  
	    public PreparedStatement pst = null;  
	  
	    public TestMysqlUserInsert() {  
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
		   
		   System.out.println("-->1000");
		   for(int i=0;i<5;i++){
			   insertMyIsamMax(1000);
		   }
//		   System.out.println("-->2000");
//		   for(int i=0;i<5;i++){
//			   insertMyIsamMax(2000);
//		   }
//		   System.out.println("-->5000");
//		   for(int i=0;i<5;i++){
//			   insertMyIsamMax(5000);
//		   }
//		   System.out.println("-->10000");
//		   for(int i=0;i<5;i++){
//			   insertMyIsamMax(10000);
//		   }
//		   System.out.println("-->20000");
//		   for(int i=0;i<5;i++){
//			   insertMyIsamMax(20000);
//		   }
//		   System.out.println("-->50000");
//		   for(int i=0;i<5;i++){
//			   insertMyIsamMax(50000);
//		   }
//		   System.out.println("-->100000");
//		   for(int i=0;i<5;i++){
//			   insertMyIsamMax(100000);
//		   }
//		   
//		   
//		   System.out.println("-->1000");
//		   
//		   for(int i=0;i<5;i++){
//			   insertInnerMax(1000);
//		   }
//		   System.out.println("-->2000");
//		   for(int i=0;i<5;i++){
//			   insertInnerMax(2000);
//		   }
//		   System.out.println("-->5000");
//		   for(int i=0;i<5;i++){
//			   insertInnerMax(5000);
//		   }
//		   System.out.println("-->10000");
//		   for(int i=0;i<5;i++){
//			   insertInnerMax(10000);
//		   }
//		   System.out.println("-->20000");
//		   for(int i=0;i<5;i++){
//			   insertInnerMax(20000);
//		   }
//		   System.out.println("-->50000");
//		   for(int i=0;i<5;i++){
//			   insertInnerMax(50000);
//		   }
//		   System.out.println("-->100000");
//		   for(int i=0;i<5;i++){
//			   insertInnerMax(100000);
//		   }
//		   
	   }
	    
	   
	   public static void insertMyIsamMax(int maxV)throws Exception{
		   
		   int max = maxV;
		   long time1 = System.currentTimeMillis();
		   TestMysqlUserInsert testMysql = new TestMysqlUserInsert();
		   testMysql.conn.setAutoCommit(false);
		   PreparedStatement prep =  testMysql.conn.prepareStatement("insert into user values(null,?,sysdate())");
		   for(int i=1;i<=max;i++){
			   String rand = UUID.randomUUID().toString().substring(1, 20);
			   prep.setString(1,  rand);
			   prep.execute();
			   if(i%1000== 0){
				   testMysql.conn.commit();
				//   System.out.println("--》"+i+"条，用时 "+(System.currentTimeMillis()-time1));
			   }
		   }
		   testMysql.conn.commit();
		   long time2= System.currentTimeMillis();
		   System.out.println((time2-time1));
		   testMysql.conn.close();
		   
	   } 
	   
	   
  public static void insertInnerMax(int maxV)throws Exception{
		   
		   int max = maxV;
		   long time1 = System.currentTimeMillis();
		   TestMysqlUserInsert testMysql = new TestMysqlUserInsert();
		   testMysql.conn.setAutoCommit(false);
		   PreparedStatement prep =  testMysql.conn.prepareStatement("insert into user_inn values(null,?,sysdate())");
		   for(int i=1;i<=max;i++){
			   String rand = UUID.randomUUID().toString().substring(1, 20);
			   prep.setString(1,  rand);
			   prep.execute();
			   if(i%1000== 0){
				   testMysql.conn.commit();
				//   System.out.println("--》"+i+"条，用时 "+(System.currentTimeMillis()-time1));
			   }
		   }
		   testMysql.conn.commit();
		   long time2= System.currentTimeMillis();
		   System.out.println((time2-time1));
		   testMysql.conn.close();
		   
	   } 
	   
	   
	   
	    
	    
	    
}
