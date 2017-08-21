package com.wondersgroup.yfybx.userauth.model.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author 
 * @since 2016-07-27
 */
public class UserAccount implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Long id;
	/** 账号 **/
    private String account;
	/** 账号类型,1为手机，2为emai，3为其它类别 **/
    private Integer accountType;
	/** mobile **/
    private String mobile;
	/** 手机是否验证过，为了兼容老平台 **/
    private Integer mobileValid;
	/** email **/
    private String email;
	/** email是否验证过 **/
    private Integer emailValid;
	/** 用户头像, **/
    private String avatar;
	/** 0表示系统生成，1表示自己上传 2表示系统强制修改 **/
    private Integer avatarFlag;
	/** 状态,0为未激活或临时用户不能登录,1为正常注册用户，可登录,2为禁用，3为逻辑删除用户 **/
    private Integer status;
	/** 昵称, **/
    private String nickname;
	/** 密码,加密过的密码 **/
    private String passwd;
	/** 姓名 **/
    private String fullname;
	/** 身高,CM **/
    private Integer height;
	/** 体重,KG **/
    private BigDecimal weight;
	/** 性别,M或F **/
    private String gender;
	/** 生日,日期格式 **/
    private Date birthday;
	/** 注册ip **/
    private String createdIp;
	/** 注册时间 **/
    private Date createdAt;
	/** 更新时间 **/
    private Date updatedAt;
	/** 最后登录时间 **/
    private Date lastLoginAt;
	/** 最后更新密码时间 **/
    private Date lastUpdatePwd;
	/** 注册时客户端信息,iphone6|ios|8.4.1 格式：model|系统系|统版本号 **/
    private String createdClientInfo;
	/** 注册时客户端信息,iphone6|ios|8.4.1 格式：model|系统系|统版本号 **/
    private String lastClientInfo;
	/** created_app_id **/
    private String createdAppId;
	/** created_from_tag **/
    private String createdFromTag;
	/** last_app_id **/
    private String lastAppId;
	/** last_from_tag **/
    private String lastFromTag;
	/** 签名,1防止并发,2防止黑客修改,签名字段使用md5(account+updated_at(格式是yyyyMMddHHmmss)+约定key)取16位小写 **/
    private String signature;

	
   /**
    * 获取属性:id
    * id
    * @return id
    */
   public Long getId() {
       return id;
   }
   /**
    * 设置属性:id
    * id
    * @param id
    */
   public void setId(Long id) {
       this.id = id;
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
    * 获取属性:accountType
    * 账号类型,1为手机，2为emai，3为其它类别
    * @return accountType
    */
   public Integer getAccountType() {
       return accountType;
   }
   /**
    * 设置属性:accountType
    * 账号类型,1为手机，2为emai，3为其它类别
    * @param accountType
    */
   public void setAccountType(Integer accountType) {
       this.accountType = accountType;
   }
	
   /**
    * 获取属性:mobile
    * mobile
    * @return mobile
    */
   public String getMobile() {
       return mobile;
   }
   /**
    * 设置属性:mobile
    * mobile
    * @param mobile
    */
   public void setMobile(String mobile) {
       this.mobile = mobile;
   }
	
   /**
    * 获取属性:mobileValid
    * 手机是否验证过，为了兼容老平台
    * @return mobileValid
    */
   public Integer getMobileValid() {
       return mobileValid;
   }
   /**
    * 设置属性:mobileValid
    * 手机是否验证过，为了兼容老平台
    * @param mobileValid
    */
   public void setMobileValid(Integer mobileValid) {
       this.mobileValid = mobileValid;
   }
	
   /**
    * 获取属性:email
    * email
    * @return email
    */
   public String getEmail() {
       return email;
   }
   /**
    * 设置属性:email
    * email
    * @param email
    */
   public void setEmail(String email) {
       this.email = email;
   }
	
   /**
    * 获取属性:emailValid
    * email是否验证过
    * @return emailValid
    */
   public Integer getEmailValid() {
       return emailValid;
   }
   /**
    * 设置属性:emailValid
    * email是否验证过
    * @param emailValid
    */
   public void setEmailValid(Integer emailValid) {
       this.emailValid = emailValid;
   }
	
   /**
    * 获取属性:avatar
    * 用户头像,
    * @return avatar
    */
   public String getAvatar() {
       return avatar;
   }
   /**
    * 设置属性:avatar
    * 用户头像,
    * @param avatar
    */
   public void setAvatar(String avatar) {
       this.avatar = avatar;
   }
	
   /**
    * 获取属性:avatarFlag
    * 0表示系统生成，1表示自己上传 2表示系统强制修改
    * @return avatarFlag
    */
   public Integer getAvatarFlag() {
       return avatarFlag;
   }
   /**
    * 设置属性:avatarFlag
    * 0表示系统生成，1表示自己上传 2表示系统强制修改
    * @param avatarFlag
    */
   public void setAvatarFlag(Integer avatarFlag) {
       this.avatarFlag = avatarFlag;
   }
	
   /**
    * 获取属性:status
    * 状态,0为未激活或临时用户不能登录,1为正常注册用户，可登录,2为禁用，3为逻辑删除用户
    * @return status
    */
   public Integer getStatus() {
       return status;
   }
   /**
    * 设置属性:status
    * 状态,0为未激活或临时用户不能登录,1为正常注册用户，可登录,2为禁用，3为逻辑删除用户
    * @param status
    */
   public void setStatus(Integer status) {
       this.status = status;
   }
	
   /**
    * 获取属性:nickname
    * 昵称,
    * @return nickname
    */
   public String getNickname() {
       return nickname;
   }
   /**
    * 设置属性:nickname
    * 昵称,
    * @param nickname
    */
   public void setNickname(String nickname) {
       this.nickname = nickname;
   }
	
   /**
    * 获取属性:passwd
    * 密码,加密过的密码
    * @return passwd
    */
   public String getPasswd() {
       return passwd;
   }
   /**
    * 设置属性:passwd
    * 密码,加密过的密码
    * @param passwd
    */
   public void setPasswd(String passwd) {
       this.passwd = passwd;
   }
	
   /**
    * 获取属性:fullname
    * 姓名
    * @return fullname
    */
   public String getFullname() {
       return fullname;
   }
   /**
    * 设置属性:fullname
    * 姓名
    * @param fullname
    */
   public void setFullname(String fullname) {
       this.fullname = fullname;
   }
	
   /**
    * 获取属性:height
    * 身高,CM
    * @return height
    */
   public Integer getHeight() {
       return height;
   }
   /**
    * 设置属性:height
    * 身高,CM
    * @param height
    */
   public void setHeight(Integer height) {
       this.height = height;
   }
	
   /**
    * 获取属性:weight
    * 体重,KG
    * @return weight
    */
   public BigDecimal getWeight() {
       return weight;
   }
   /**
    * 设置属性:weight
    * 体重,KG
    * @param weight
    */
   public void setWeight(BigDecimal weight) {
       this.weight = weight;
   }
	
   /**
    * 获取属性:gender
    * 性别,M或F
    * @return gender
    */
   public String getGender() {
       return gender;
   }
   /**
    * 设置属性:gender
    * 性别,M或F
    * @param gender
    */
   public void setGender(String gender) {
       this.gender = gender;
   }
	
   /**
    * 获取属性:birthday
    * 生日,日期格式
    * @return birthday
    */
   public Date getBirthday() {
       return birthday;
   }
   /**
    * 设置属性:birthday
    * 生日,日期格式
    * @param birthday
    */
   public void setBirthday(Date birthday) {
       this.birthday = birthday;
   }
	
   /**
    * 获取属性:createdIp
    * 注册ip
    * @return createdIp
    */
   public String getCreatedIp() {
       return createdIp;
   }
   /**
    * 设置属性:createdIp
    * 注册ip
    * @param createdIp
    */
   public void setCreatedIp(String createdIp) {
       this.createdIp = createdIp;
   }
	
   /**
    * 获取属性:createdAt
    * 注册时间
    * @return createdAt
    */
   public Date getCreatedAt() {
       return createdAt;
   }
   /**
    * 设置属性:createdAt
    * 注册时间
    * @param createdAt
    */
   public void setCreatedAt(Date createdAt) {
       this.createdAt = createdAt;
   }
	
   /**
    * 获取属性:updatedAt
    * 更新时间
    * @return updatedAt
    */
   public Date getUpdatedAt() {
       return updatedAt;
   }
   /**
    * 设置属性:updatedAt
    * 更新时间
    * @param updatedAt
    */
   public void setUpdatedAt(Date updatedAt) {
       this.updatedAt = updatedAt;
   }
	
   /**
    * 获取属性:lastLoginAt
    * 最后登录时间
    * @return lastLoginAt
    */
   public Date getLastLoginAt() {
       return lastLoginAt;
   }
   /**
    * 设置属性:lastLoginAt
    * 最后登录时间
    * @param lastLoginAt
    */
   public void setLastLoginAt(Date lastLoginAt) {
       this.lastLoginAt = lastLoginAt;
   }
	
   /**
    * 获取属性:lastUpdatePwd
    * 最后更新密码时间
    * @return lastUpdatePwd
    */
   public Date getLastUpdatePwd() {
       return lastUpdatePwd;
   }
   /**
    * 设置属性:lastUpdatePwd
    * 最后更新密码时间
    * @param lastUpdatePwd
    */
   public void setLastUpdatePwd(Date lastUpdatePwd) {
       this.lastUpdatePwd = lastUpdatePwd;
   }
	
   /**
    * 获取属性:createdClientInfo
    * 注册时客户端信息,iphone6|ios|8.4.1 格式：model|系统系|统版本号
    * @return createdClientInfo
    */
   public String getCreatedClientInfo() {
       return createdClientInfo;
   }
   /**
    * 设置属性:createdClientInfo
    * 注册时客户端信息,iphone6|ios|8.4.1 格式：model|系统系|统版本号
    * @param createdClientInfo
    */
   public void setCreatedClientInfo(String createdClientInfo) {
       this.createdClientInfo = createdClientInfo;
   }
	
   /**
    * 获取属性:lastClientInfo
    * 注册时客户端信息,iphone6|ios|8.4.1 格式：model|系统系|统版本号
    * @return lastClientInfo
    */
   public String getLastClientInfo() {
       return lastClientInfo;
   }
   /**
    * 设置属性:lastClientInfo
    * 注册时客户端信息,iphone6|ios|8.4.1 格式：model|系统系|统版本号
    * @param lastClientInfo
    */
   public void setLastClientInfo(String lastClientInfo) {
       this.lastClientInfo = lastClientInfo;
   }
	
   /**
    * 获取属性:createdAppId
    * created_app_id
    * @return createdAppId
    */
   public String getCreatedAppId() {
       return createdAppId;
   }
   /**
    * 设置属性:createdAppId
    * created_app_id
    * @param createdAppId
    */
   public void setCreatedAppId(String createdAppId) {
       this.createdAppId = createdAppId;
   }
	
   /**
    * 获取属性:createdFromTag
    * created_from_tag
    * @return createdFromTag
    */
   public String getCreatedFromTag() {
       return createdFromTag;
   }
   /**
    * 设置属性:createdFromTag
    * created_from_tag
    * @param createdFromTag
    */
   public void setCreatedFromTag(String createdFromTag) {
       this.createdFromTag = createdFromTag;
   }
	
   /**
    * 获取属性:lastAppId
    * last_app_id
    * @return lastAppId
    */
   public String getLastAppId() {
       return lastAppId;
   }
   /**
    * 设置属性:lastAppId
    * last_app_id
    * @param lastAppId
    */
   public void setLastAppId(String lastAppId) {
       this.lastAppId = lastAppId;
   }
	
   /**
    * 获取属性:lastFromTag
    * last_from_tag
    * @return lastFromTag
    */
   public String getLastFromTag() {
       return lastFromTag;
   }
   /**
    * 设置属性:lastFromTag
    * last_from_tag
    * @param lastFromTag
    */
   public void setLastFromTag(String lastFromTag) {
       this.lastFromTag = lastFromTag;
   }
	
   /**
    * 获取属性:signature
    * 签名,1防止并发,2防止黑客修改,签名字段使用md5(account+updated_at(格式是yyyyMMddHHmmss)+约定key)取16位小写
    * @return signature
    */
   public String getSignature() {
       return signature;
   }
   /**
    * 设置属性:signature
    * 签名,1防止并发,2防止黑客修改,签名字段使用md5(account+updated_at(格式是yyyyMMddHHmmss)+约定key)取16位小写
    * @param signature
    */
   public void setSignature(String signature) {
       this.signature = signature;
   }

}