package com.wondersgroup.yfybx.userauth.model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 * @since 2016-07-27
 */
public class UserLoginLast implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** 登录token **/
    private Long token;
	/** 用户账号 **/
    private String account;
	/** 用户id **/
    private Integer userId;
	/** 登录标识,登录来自己什么地方 **/
    private String fromTag;
	/** 登录ip **/
    private String loginIp;
	/** created_at **/
    private Date createdAt;
	/** last_login_at **/
    private Date lastLoginAt;
	/** 有时效期 **/
    private Date effiAt;
	/** 是否退出，如果不为0表示退出了，如果1为自动退出，2为系统或用户其它地方登录被强制退出 **/
    private Integer logout;
	/** logout_at **/
    private Date logoutAt;
	/** 登录信息,一般是json **/
    private String loginContent;
	/** 客户端登录的唯一标识 **/
    private String appId;
	/** client_info **/
    private String clientInfo;
	/** 1防止黑客修改,签名字段使用md5(token+last_login_at(yyyyMMddHHmmss))取16位小写 **/
    private String signature;

	
   /**
    * 获取属性:token
    * 登录token
    * @return token
    */
   public Long getToken() {
       return token;
   }
   /**
    * 设置属性:token
    * 登录token
    * @param token
    */
   public void setToken(Long token) {
       this.token = token;
   }
	
   /**
    * 获取属性:account
    * 用户账号
    * @return account
    */
   public String getAccount() {
       return account;
   }
   /**
    * 设置属性:account
    * 用户账号
    * @param account
    */
   public void setAccount(String account) {
       this.account = account;
   }
	
   /**
    * 获取属性:userId
    * 用户id
    * @return userId
    */
   public Integer getUserId() {
       return userId;
   }
   /**
    * 设置属性:userId
    * 用户id
    * @param userId
    */
   public void setUserId(Integer userId) {
       this.userId = userId;
   }
	
   /**
    * 获取属性:fromTag
    * 登录标识,登录来自己什么地方
    * @return fromTag
    */
   public String getFromTag() {
       return fromTag;
   }
   /**
    * 设置属性:fromTag
    * 登录标识,登录来自己什么地方
    * @param fromTag
    */
   public void setFromTag(String fromTag) {
       this.fromTag = fromTag;
   }
	
   /**
    * 获取属性:loginIp
    * 登录ip
    * @return loginIp
    */
   public String getLoginIp() {
       return loginIp;
   }
   /**
    * 设置属性:loginIp
    * 登录ip
    * @param loginIp
    */
   public void setLoginIp(String loginIp) {
       this.loginIp = loginIp;
   }
	
   /**
    * 获取属性:createdAt
    * created_at
    * @return createdAt
    */
   public Date getCreatedAt() {
       return createdAt;
   }
   /**
    * 设置属性:createdAt
    * created_at
    * @param createdAt
    */
   public void setCreatedAt(Date createdAt) {
       this.createdAt = createdAt;
   }
	
   /**
    * 获取属性:lastLoginAt
    * last_login_at
    * @return lastLoginAt
    */
   public Date getLastLoginAt() {
       return lastLoginAt;
   }
   /**
    * 设置属性:lastLoginAt
    * last_login_at
    * @param lastLoginAt
    */
   public void setLastLoginAt(Date lastLoginAt) {
       this.lastLoginAt = lastLoginAt;
   }
	
   /**
    * 获取属性:effiAt
    * 有时效期
    * @return effiAt
    */
   public Date getEffiAt() {
       return effiAt;
   }
   /**
    * 设置属性:effiAt
    * 有时效期
    * @param effiAt
    */
   public void setEffiAt(Date effiAt) {
       this.effiAt = effiAt;
   }
	
   /**
    * 获取属性:logout
    * 是否退出，如果不为0表示退出了，如果1为自动退出，2为系统或用户其它地方登录被强制退出
    * @return logout
    */
   public Integer getLogout() {
       return logout;
   }
   /**
    * 设置属性:logout
    * 是否退出，如果不为0表示退出了，如果1为自动退出，2为系统或用户其它地方登录被强制退出
    * @param logout
    */
   public void setLogout(Integer logout) {
       this.logout = logout;
   }
	
   /**
    * 获取属性:logoutAt
    * logout_at
    * @return logoutAt
    */
   public Date getLogoutAt() {
       return logoutAt;
   }
   /**
    * 设置属性:logoutAt
    * logout_at
    * @param logoutAt
    */
   public void setLogoutAt(Date logoutAt) {
       this.logoutAt = logoutAt;
   }
	
   /**
    * 获取属性:loginContent
    * 登录信息,一般是json
    * @return loginContent
    */
   public String getLoginContent() {
       return loginContent;
   }
   /**
    * 设置属性:loginContent
    * 登录信息,一般是json
    * @param loginContent
    */
   public void setLoginContent(String loginContent) {
       this.loginContent = loginContent;
   }
	
   /**
    * 获取属性:appId
    * 客户端登录的唯一标识
    * @return appId
    */
   public String getAppId() {
       return appId;
   }
   /**
    * 设置属性:appId
    * 客户端登录的唯一标识
    * @param appId
    */
   public void setAppId(String appId) {
       this.appId = appId;
   }
	
   /**
    * 获取属性:clientInfo
    * client_info
    * @return clientInfo
    */
   public String getClientInfo() {
       return clientInfo;
   }
   /**
    * 设置属性:clientInfo
    * client_info
    * @param clientInfo
    */
   public void setClientInfo(String clientInfo) {
       this.clientInfo = clientInfo;
   }
	
   /**
    * 获取属性:signature
    * 1防止黑客修改,签名字段使用md5(token+last_login_at(yyyyMMddHHmmss))取16位小写
    * @return signature
    */
   public String getSignature() {
       return signature;
   }
   /**
    * 设置属性:signature
    * 1防止黑客修改,签名字段使用md5(token+last_login_at(yyyyMMddHHmmss))取16位小写
    * @param signature
    */
   public void setSignature(String signature) {
       this.signature = signature;
   }

}