package com.mytest.aes;


/**
 * 
 * AES加密解密
 * @author daiderong@wondersgroup.com
 *
 */
public class AES128Utils {

	
	//默认为1122334455EDCAFD
	private static String ivAndKey = "1122334455EDCAFD"; //AES固定格式为128/192/256 bits.即：16/24/32bytes。DES固定格式为128bits，即8bytes。
	
	private static AES128 aes128 ; 
	
	//使用前先调用init
	public  static  void init(String key){
		if(aes128 == null){
			if(key == null){
				aes128 =  new AES128(ivAndKey);
			}else{
				aes128 = new AES128(key);
			}
		}
	}
	
	/**
	 * 加密
	 * @param text
	 * @return
	 */
	public static String encrypt(String text){
		try {
			if(aes128==null){
				init(null);
			}
			String encText = aes128.encrypt(text);
			return encText;
		} catch (Exception e) {
			System.out.println("中密出现异常");
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	/**
	 * 解密
	 * @param text 密文
	 * @return
	 */
	public static String decrypt(String text){
		try {
			if(aes128==null){
				init(null);
			}
			String encText = aes128.decrypt(text);
			return encText;
		} catch (Exception e) {
			System.out.println("解密出现异常");
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
	
		long time1 = System.currentTimeMillis();
		AES128Utils.init("1122334455EDCAFD");
		//使用前先设置key
//		AES128Utils.init("123456abcd123456");
//		for (int i = 0; i < 1000; i++) {
//			String encC = (AES128Utils.encrypt("中国人"+i));
//			String desc  = AES128Utils.decrypt(encC);
//			System.out.println(encC+"--"+desc);
//		}
		
		
		
//		InputStreamReader inputReader = null;
//        BufferedReader bufferReader = null;
//        StringBuffer strBuffer = new StringBuffer();
//        try
//        {
//            InputStream inputStream = new FileInputStream("/ddr/devlop/workspace_sm/my_test/src/ppp/text.txt");
//            inputReader = new InputStreamReader(inputStream);
//            bufferReader = new BufferedReader(inputReader);
//             
//            // 读取一行
//            String line = null;
//           
//                 
//            while ((line = bufferReader.readLine()) != null)
//            {
//                strBuffer.append(line);
//            } 
//             
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//		System.out.println(aseAes128.decrypt(strBuffer.toString()));
		
		System.out.println("AES128Utils.ivAndKey:"+AES128Utils.ivAndKey);
		
		String json = "{\"name\":\"张三\",age:24}";
		String enc = AES128Utils.encrypt(json);
		System.out.println(AES128Utils.encrypt(json));
		System.out.println(AES128Utils.decrypt(enc));
		
		
		 String data = "111111";
		 String enc2 = AES128Utils.encrypt(data);
		 
		System.out.println(data);
		System.out.println(enc2);
		
		
		
//			System.out.println((System.currentTimeMillis() -time1)  );
	}
	
	
	
	
	
	
	
	
	
	


		 
	
}
