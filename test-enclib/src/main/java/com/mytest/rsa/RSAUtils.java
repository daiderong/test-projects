/**
 * ddr
 * 2013-8-29 下午9:11:41
 *	
 */
package com.mytest.rsa;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.mytest.util.Base64Util;

/**
 *  @author daiderong@wondersgroup.com
 * 
 */
public class RSAUtils {

	
	private RSAUtils(){
	}
	
	
	private static RSAUtils instance;
	
	public static RSAUtils get() {
		if(instance == null ){
			instance = new RSAUtils(); 
		}
		return instance;
	}
	/**
	 * 生成RSA密钥对
	 * @param 自定义串
	 * @return
	 */
	public  RSAPairBase64 keyPairGenerater(String youString) {
		try {
			java.security.KeyPairGenerator keygen = java.security.KeyPairGenerator
					.getInstance("RSA");
			SecureRandom secrand = new SecureRandom();
			secrand.setSeed(youString.getBytes()); // 初始化随机产生器
			keygen.initialize(1048, secrand);
			KeyPair keys = keygen.genKeyPair();

			RSAPublicKey pubkey = (RSAPublicKey) keys.getPublic();
			RSAPrivateKey prikey = (RSAPrivateKey) keys.getPrivate();

//			byte[] pubKeyBy = Base64Util.encodeToByte(pubkey.getEncoded());
//			byte[] priKeyBy = Base64Util.encodeToByte(prikey.getEncoded());
//			String pubKeyString = new String(pubKeyBy);
//			String priKeyString = new String(priKeyBy);
			
			String pubKeyString = Base64Util.encode(pubkey.getEncoded());
			String priKeyString = Base64Util.encode(prikey.getEncoded());
			
			RSAPairBase64 pair = new RSAPairBase64(pubKeyString, priKeyString);
			System.out.println("生成的pubKey =" + pubKeyString);
			System.out.println("生成的priKey =" + priKeyString);
			return pair;
		} catch (java.lang.Exception e) {
			System.out.println("生成密钥对失败");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 通过base的key 得到原来的PublicKey对象 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public  PublicKey decodePublicKey(String key) throws Exception {
		byte[] keyBytes;
		keyBytes = Base64Util.decode(key);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}
	
	public  PrivateKey decodePrivateKey(String privateKeyBase64) throws Exception {
		byte[] keyBytes;
		keyBytes = Base64Util.decode(privateKeyBase64);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
		return privateKey;
	}
	
	public  String encRSAByPublicKey(String content,String publicKeyBase64	){
		RSAPublicKey pubkey = null;
		try {
			pubkey = (RSAPublicKey) decodePublicKey(publicKeyBase64);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		 return encRSA(content, pubkey.getPublicExponent().toString(),pubkey.getModulus().toString());
	}
	
	public  String decRSAByPriviteKey(String rsaStr,String privateKeyBase64	){
		RSAPrivateKey privateKey = null;
		try {
			privateKey = (RSAPrivateKey) decodePrivateKey(privateKeyBase64);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return decRSA(rsaStr, privateKey.getPrivateExponent().toString(),privateKey.getModulus().toString());
		 
	}
	
	//加密在RSA公钥中包含有两个整数信息：e和n。对于明文数字m,计算密文的公式是m的e次方再与n求模。
    private  String encRSA(String mingwen,String eStr,String nStr){
        String miwen = new String();
        try {
            BigInteger e = new BigInteger(eStr);
            BigInteger n = new BigInteger(nStr);          
            byte[] ptext = mingwen.getBytes("UTF8"); //获取明文的大整数
            BigInteger m = new BigInteger(ptext);
            BigInteger c = m.modPow(e, n);
            miwen =  new String(c.toString().getBytes(),"UTF8");
        } catch (UnsupportedEncodingException ex) {
           return null;
        }
        return miwen;
    }
    //解密
    private  String decRSA(String miwen,String dStr,String nStr){
        StringBuffer mingwen= new StringBuffer();       
        BigInteger d=new BigInteger(dStr);//获取私钥的参数d,n
        BigInteger n=new BigInteger(nStr);
        BigInteger c=new BigInteger(miwen);        
        BigInteger m=c.modPow(d,n);//解密明文
        byte[] mt=m.toByteArray();//计算明文对应的字符串并输出
        try {
			return new String(mt,"UTF8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new String(mt);
		}
    }
    
    
    public static void main(String[] args) {
    	//生成密钥对，并检测成功与否
    	RSAPairBase64 rsaPairBase64 = get().keyPairGenerater("cloude111111");
    	String myPwd = "Password00!!!";
    	System.out.println("我的明文密码:"+myPwd);
    	String encPwd =  instance.encRSAByPublicKey(myPwd, rsaPairBase64.getRsaPublicBase64());
    	System.out.println("加密后密码:"+encPwd);
    	String decPwd =  instance.decRSAByPriviteKey(encPwd, rsaPairBase64.getRsaPrivateBase64());
    	System.out.println("解密后密码:"+decPwd);
    	System.out.println("验证结果："+decPwd.equals(myPwd));
    	
    	//=----------
    /*	String publicKey = "MIGiMA0GCSqGSIb3DQEBAQUAA4GQADCBjAKBhACBgDj27R156+fzIQd+e2qrcCXE+BUDiFMPlRFM"+
"YlrMVosnl8shHeWEJO8xYo5i85NBUb6lLwwZoi/tWAkcU/QO96eglJfykqMFXPzB7iWu3ywL3YeZ"+
"yepiXTD7U4Bs2mAkgI5pvMIrUJKtofpZ6jTZp9ZhAmBu1XM7HYx0LfD0L4VUrQIDAQAB";
    	String privateKey = 
    			"MIICgwIBADANBgkqhkiG9w0BAQEFAASCAm0wggJpAgEAAoGEAIGAOPbtHXnr5/MhB357aqtwJcT4"+
    "FQOIUw+VEUxiWsxWiyeXyyEd5YQk7zFijmLzk0FRvqUvDBmiL+1YCRxT9A73p6CUl/KSowVc/MHu"+
    "Ja7fLAvdh5nJ6mJdMPtTgGzaYCSAjmm8witQkq2h+lnqNNmn1mECYG7VczsdjHQt8PQvhVStAgMB"+
    "AAECgYMMvcDdCpdL15oKocVK/HmSRIZyyrXGkzMY5WG+Ui78y8cFLjoeGALs7XVbNocr1Ss30gMf"+
    "3XEjVIHCqFa9IsVwc4sbDykMF/sY+zzAhDl2XS+oNYDTMXZwEwvKEgzk2ATV811NXQ9J2IFmMN/5"+
    "9EbQtRlDUXlLezzzfNTrvxmuSrMUAQJCDG8CF+6grQXYiGzOxaqIYAJEHl4WqHpVOvM68tfgAPtA"+
    "7zWb/Wd5Yy8dmB5l1bkC+fGvClpnRUyrMb6Yey3CnNcRAkIKalX9WGQEkgFeRJFSQbFljONf/qB0"+
    "B2qWObrlmyKke4DsCcqCbSOaQ/wyy4v2wEAZFVS9vn5cWq8AzO2K12ci+90CQgdKYBPgXF6X+uuj"+
    "wWquH+EL8x1LVkXb1XYHgR0776EjsmORL7Japha+XcAAsv2qyk/8owKTF9LOreMxOv+fSWnlwQJC"+
    "ALRlEPjz+2MteIVHF7ueFvLLR2lgzbjau0M4o+Q1Gc/JTy7yZpSfvgYvf/hJhe5H5+qLizLiNblk"+
    "8bbrs2MTdUh5AkIC2NmWbrtbcvmt0FMicKLnfXJv6OkTNaOvipUReTIurLVr85MwlPzyj5xTicKj"+
    "AWEPnPmCpE3ad5XKHPRiLml+HYA=";
    	String myPwd = "12345612345612345614561234561234561234561234561456123456";
    	System.out.println("我的明文密码:"+myPwd);
    	String encPwd =  RSAUtils.get().encRSAByPublicKey(myPwd, publicKey);
    	System.out.println("加密后密码:"+encPwd);
    	String decPwd =  RSAUtils.get().decRSAByPriviteKey(encPwd, privateKey);
    	System.out.println("解密后密码:"+decPwd);
    	System.out.println("验证结果："+decPwd.equals(myPwd));
    	*/
	}
	
	
	

}
