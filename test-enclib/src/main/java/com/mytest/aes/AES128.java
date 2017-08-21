package com.mytest.aes;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * 
 * AES加密解密
 * @author daiderong@wondersgroup.com
 *
 */
public class AES128 {

	
	private final String encode = "UTF-8";
	private final String keyGen = "AES";
	private final String cipherStr = "AES/CBC/PKCS5Padding";
	
	
	//向量和key是同一个，保护16/24/32 Bytes
	//暂时默认是1122334455EDCAFD
	private String ivAndKey = "1122334455EDCAFD"; //AES固定格式为128/192/256 bits.即：16/24/32bytes。DES固定格式为128bits，即8bytes。
	
	
	
	public AES128(String ivAndKey) {
		super();
		this.ivAndKey = ivAndKey;
	}



	public String encrypt(String text) throws Exception{


		Key keySpec = new SecretKeySpec(ivAndKey.getBytes(), keyGen);    //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
		IvParameterSpec ivSpec = new IvParameterSpec(ivAndKey.getBytes());     
		Cipher cipher = Cipher.getInstance(cipherStr); //实例化加密类，参数为加密方式，要写全

		
		cipher.init(Cipher.ENCRYPT_MODE,  keySpec, ivSpec);           //初始化，此方法可以采用三种方式，按服务器要求来添加。（1）无第三个参数（2）第三个参数为SecureRandom random = new SecureRandom();中random对象，随机数。(AES不可采用这种方法)（3）采用此代码中的IVParameterSpec

		//cipher.init(Cipher.ENCRYPT_MODE, keySpec);

		//SecureRandom random = new SecureRandom();

		//cipher.init(Cipher.ENCRYPT_MODE, keySpec, random);

		
		byte [] b = cipher.doFinal(text.getBytes());                  //加密操作,返回加密后的字节数组，然后需要编码。主要编解码方式有Base64, HEX, UUE, 7bit等等。此处看服务器需要什么编码方式

		String ret = Base64.encode(b);                                       //Base64、HEX等编解码

		return ret;
	}
	
	
	
	public  String decrypt(String text) throws Exception{



		byte [] byte1 = Base64.decode(text);         //先用Base64解码


		Key keySpec = new SecretKeySpec(ivAndKey.getBytes(), keyGen);    //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
		IvParameterSpec ivSpec = new IvParameterSpec(ivAndKey.getBytes());     
		Cipher cipher = Cipher.getInstance(cipherStr); //实例化加密类，参数为加密方式，要写全

		
		cipher.init(cipher.DECRYPT_MODE, keySpec, ivSpec);               //与加密时不同MODE:Cipher.DECRYPT_MODE

		byte [] ret = cipher.doFinal(byte1);

		return new String(ret, encode);

		}


	
	
	public static void main(String[] args) throws Exception {
	
		long time1 = System.currentTimeMillis();
		AES128 aseAes128 =  new AES128("1122334455EDCAFD");
		for (int i = 0; i < 100; i++) {
			String encC = (aseAes128.encrypt("中国人"+i));
			String desc  = aseAes128.decrypt(encC);
			System.out.println(encC+"--"+desc);
		}
		
		
		
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
		
		System.out.println((System.currentTimeMillis() -time1)  );
	}
	
	
	
	
	
	
	
	
	
	


		 
	
}
