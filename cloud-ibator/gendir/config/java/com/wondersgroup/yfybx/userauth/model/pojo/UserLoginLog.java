package com.wondersgroup.yfybx.userauth.model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 * @since 2016-07-27
 */
public class UserLoginLog implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** uuid **/
    private Long uuid;
	/** 账号 **/
    private String account;
	/** 用户id **/
    private Integer userId;
	/** 用户登录Token **/
    private String token;
	/** 登录标识,登录来自己什么地方 **/
    private String fromTag;
	/** 登录ip **/
    private String loginIp;
	/** created_at **/
    private Date createdAt;
	/** 客户端生成的唯一标识 **/
    private String appId;
	/** 客户端信息 **/
    private String clientInfo;
	/** 1防止黑客修改,签名字段使用md5(uuid+account+约定key)取16位小写 **/
    private String signature;

	
   /**
    * 获取属性:uuid
    * uuid
    * @return uuid
    */
   public Long getUuid() {
       return uuid;
   }
   /**
    * 设置属性:uuid
    * uuid
    * @param uuid
    */
   public void setUuid(Long uuid) {
       this.uuid = uuid;
   }
	
   /**
    * 获取属性:account
    * 账号
    * @return account
    */
   public String getAccount() {
       return account;
   }
   /**
    * 设置属性:account
    * 账号
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
    * 获取属性:token
    * 用户登录Token
    * @return token
    */
   public String getToken() {
       return token;
   }
   /**
    * 设置属性:token
    * 用户登录Token
    * @param token
    */
   public void setToken(String token) {
       this.token = token;
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
    * 获取属性:appId
    * 客户端生成的唯一标识
    * @return appId
    */
   public String getAppId() {
       return appId;
   }
   /**
    * 设置属性:appId
    * 客户端生成的唯一标识
    * @param appId
    */
   public void setAppId(String appId) {
       this.appId = appId;
   }
	
   /**
    * 获取属性:clientInfo
    * 客户端信息
    * @return clientInfo
    */
   public String getClientInfo() {
       return clientInfo;
   }
   /**
    * 设置属性:clientInfo
    * 客户端信息
    * @param clientInfo
    */
   public void setClientInfo(String clientInfo) {
       this.clientInfo = clientInfo;
   }
	
   /**
    * 获取属性:signature
    * 1防止黑客修改,签名字段使用md5(uuid+account+约定key)取16位小写
    * @return signature
    */
   public String getSignature() {
       return signature;
   }
   /**
    * 设置属性:signature
    * 1防止黑客修改,签名字段使用md5(uuid+account+约定key)取16位小写
    * @param signature
    */
   public void setSignature(String signature) {
       this.signature = signature;
   }

}