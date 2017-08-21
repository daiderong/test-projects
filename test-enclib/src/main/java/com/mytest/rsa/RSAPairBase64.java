/**
 * ddr
 * 2013-8-29 下午9:13:01
 *	
 */
package com.mytest.rsa;


/**
 * @author daiderong@wondersgroup.com
 * 
 */
public class RSAPairBase64 {

	private String rsaPublicBase64;
	private String rsaPrivateBase64;

	public RSAPairBase64(String rsaPublicBase64,
			String rsaPrivateBase64) {
		super();
		this.rsaPublicBase64 = rsaPublicBase64;
		this.rsaPrivateBase64 = rsaPrivateBase64;
	}

	public String getRsaPublicBase64() {
		return rsaPublicBase64;
	}

	public String getRsaPrivateBase64() {
		return rsaPrivateBase64;
	}

}
