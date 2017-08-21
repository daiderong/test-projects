//package com.mytest.webservice;
//import java.security.Key;
//import java.security.SecureRandom;
//import java.util.Iterator;
//import java.util.Map.Entry;
//import java.util.Properties;
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
//
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//
///***
// * 
//* @ClassName: PasswordAutoEncrypPropertyPlaceholderConfigurer 
//* @Description: 包含password密码的自动解密，解密失败按原来value赋值
//* @author daiderong@wondersgroup.com（戴德荣）
//* @date 2016年7月12日 下午1:50:01 
//*
// */
//public class PasswordAutoEncrypPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{ 
//
//	private Log log =  LogFactory.getLog(PasswordAutoEncrypPropertyPlaceholderConfigurer.class);
//	
//
//	
//	private static Key key;
//	private static String KEY_STR = "myKey";// 密钥
//	private static String CHARSETNAME = "UTF-8";// 编码
//	private static String ALGORITHM = "DES";// 加密类型
//
//	static {
//		try {
//			KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
//			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
//			secureRandom.setSeed(KEY_STR.getBytes());
//			generator.init(secureRandom);
//			key = generator.generateKey();
//			generator = null;
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	
//	@Override 
//    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) 
//                    throws BeansException { 
//    	
//    	Iterator<Entry<Object, Object>> it = props.entrySet().iterator(); 
//    	//遍历所有配置文件值，将需要解密的值解密 
//        while (it.hasNext()) {  
//            Entry<Object, Object> entry = it.next();  
//            String key = (String) entry.getKey();  
//            String value = (String) entry.getValue();
//           
//            if( key.contains("password") && value !=null && !value.isEmpty() ){
//            	///已加载
//            	try{
//            		 String decValue = getDecryptString(value);
//                	log.info("正在自动解密"+key+":"+value);
//                	props.setProperty(key, decValue);
//             	   System.out.println("解出key   =" + decValue);  
//            	}catch(Exception e){
//            		log.info("正在自动解密"+key+":"+value+"失败");
//            		log.debug("按原来值 "+key+"="+value+"");
//            	}
//            	
////            	   System.out.println("key   :" + key);  
////                 System.out.println("value :" + value);  
////                 System.out.println("---------------"); 
//            }
//            
////         
//            
//            
//        }  
//          super.processProperties(beanFactory, props); 
//
//    } 
//	
//	
//	
//	
//	/**
//	 * 对str进行DES加密
//	 * 
//	 * @param str
//	 * @return
//	 */
//	public static String getEncryptString(String str) {
//		BASE64Encoder base64encoder = new BASE64Encoder();
//		try {
//			byte[] bytes = str.getBytes(CHARSETNAME);
//			Cipher cipher = Cipher.getInstance(ALGORITHM);
//			cipher.init(Cipher.ENCRYPT_MODE, key);
//			byte[] doFinal = cipher.doFinal(bytes);
//			return base64encoder.encode(doFinal);
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new RuntimeException(e);
//		}
//	}
//
//	/**
//	 * 对str进行DES解密
//	 * 
//	 * @param str
//	 * @return
//	 */
//	public static String getDecryptString(String str) {
//		BASE64Decoder base64decoder = new BASE64Decoder();
//		try {
//			byte[] bytes = base64decoder.decodeBuffer(str);
//			Cipher cipher = Cipher.getInstance(ALGORITHM);
//			cipher.init(Cipher.DECRYPT_MODE, key);
//			byte[] doFinal = cipher.doFinal(bytes);
//			return new String(doFinal, CHARSETNAME);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	public static void main(String[] args) {
//		
//		System.out.println(getEncryptString("ltcins_js_#$"));
//		System.out.println(getEncryptString("ltcins_!#$CD"));
//		System.out.println(getEncryptString("123456"));
//		System.out.println(getDecryptString("0QWvo/mIhIjJxAEswRErxA=="));
//	}
//
//	
//}