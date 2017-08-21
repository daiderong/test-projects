package com.mytest.des;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import com.mytest.util.Base64Util;

/**
 * 3DES加密工具类
 * @author daiderong@wondersgroup.com
 */
public class Des3 {
//	// 密钥
//	private final static String secretKey = "894D94361A243577F0A497C4EAB6462A178900022D1D95B2EAE04";
	// 向量
	private   String iv = "01234567";
	// 加解密统一使用的编码方式
	private   String encoding = "utf-8";

	private Des3(){
		
	}
	
	
	private static Des3 instance;
	
	public static Des3 get() {
		if(instance == null ){
			instance = new Des3(); 
		}
		return instance;
	}
	
	
	/**
	 * 3DES加密
	 * 
	 * @param plainText 普通文本
	 * @return
	 * @throws Exception 
	 */
	public  String encode(String plainText,String secretKey) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
		return Base64Util.encode(encryptData);
	}

	/**
	 * 3DES解密
	 * 
	 * @param encryptText 加密文本
	 * @return
	 * @throws Exception
	 */
	public  String decode(String encryptText,String secretKey) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

		byte[] decryptData = cipher.doFinal(Base64Util.decode(encryptText));

		return new String(decryptData, encoding);
	}
	
	public static void main(String[] args) throws Exception {
		String pwd = "123456";
		String secretKey = "894D94361A243577F0A497C4EAB6462A178900022D1D95B2EAE04";
		String newEnc = get().encode(pwd,secretKey);
		
		System.out.println(pwd+"加密后："+newEnc);
		
		System.out.println(get().encode(newEnc,secretKey));
		
	}
}


