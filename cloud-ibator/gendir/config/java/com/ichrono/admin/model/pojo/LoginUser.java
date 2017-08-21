package com.ichrono.admin.model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 * @since 2016-08-06
 */
public class LoginUser implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** 用户的自增id号 **/
    private Long userId;
	/** 登录名 **/
    private String loginName;
	/** 登录密码 **/
    private String loginPwd;
	/** 0为未激活，1为正常，-1为禁止 **/
    private Integer status;
	/** 全名 **/
    private String fullName;
	/** 手机号 **/
    private String mobile;
	/** email **/
    private String email;
	/** QQ **/
    private String qq;
	/** 最后登录时间 **/
    private Date lastLoginTime;
	/** last_login_ip **/
    private String lastLoginIp;
	/** 部门id **/
    private Integer deptId;
	/** 创建时间 **/
    private Date createTime;

	
   /**
    * 获取属性:userId
    * 用户的自增id号
    * @return userId
    */
   public Long getUserId() {
       return userId;
   }
   /**
    * 设置属性:userId
    * 用户的自增id号
    * @param userId
    */
   public void setUserId(Long userId) {
       this.userId = userId;
   }
	
   /**
    * 获取属性:loginName
    * 登录名
    * @return loginName
    */
   public String getLoginName() {
       return loginName;
   }
   /**
    * 设置属性:loginName
    * 登录名
    * @param loginName
    */
   public void setLoginName(String loginName) {
       this.loginName = loginName;
   }
	
   /**
    * 获取属性:loginPwd
    * 登录密码
    * @return loginPwd
    */
   public String getLoginPwd() {
       return loginPwd;
   }
   /**
    * 设置属性:loginPwd
    * 登录密码
    * @param loginPwd
    */
   public void setLoginPwd(String loginPwd) {
       this.loginPwd = loginPwd;
   }
	
   /**
    * 获取属性:status
    * 0为未激活，1为正常，-1为禁止
    * @return status
    */
   public Integer getStatus() {
       return status;
   }
   /**
    * 设置属性:status
    * 0为未激活，1为正常，-1为禁止
    * @param status
    */
   public void setStatus(Integer status) {
       this.status = status;
   }
	
   /**
    * 获取属性:fullName
    * 全名
    * @return fullName
    */
   public String getFullName() {
       return fullName;
   }
   /**
    * 设置属性:fullName
    * 全名
    * @param fullName
    */
   public void setFullName(String fullName) {
       this.fullName = fullName;
   }
	
   /**
    * 获取属性:mobile
    * 手机号
    * @return mobile
    */
   public String getMobile() {
       return mobile;
   }
   /**
    * 设置属性:mobile
    * 手机号
    * @param mobile
    */
   public void setMobile(String mobile) {
       this.mobile = mobile;
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
    * 获取属性:qq
    * QQ
    * @return qq
    */
   public String getQq() {
       return qq;
   }
   /**
    * 设置属性:qq
    * QQ
    * @param qq
    */
   public void setQq(String qq) {
       this.qq = qq;
   }
	
   /**
    * 获取属性:lastLoginTime
    * 最后登录时间
    * @return lastLoginTime
    */
   public Date getLastLoginTime() {
       return lastLoginTime;
   }
   /**
    * 设置属性:lastLoginTime
    * 最后登录时间
    * @param lastLoginTime
    */
   public void setLastLoginTime(Date lastLoginTime) {
       this.lastLoginTime = lastLoginTime;
   }
	
   /**
    * 获取属性:lastLoginIp
    * last_login_ip
    * @return lastLoginIp
    */
   public String getLastLoginIp() {
       return lastLoginIp;
   }
   /**
    * 设置属性:lastLoginIp
    * last_login_ip
    * @param lastLoginIp
    */
   public void setLastLoginIp(String lastLoginIp) {
       this.lastLoginIp = lastLoginIp;
   }
	
   /**
    * 获取属性:deptId
    * 部门id
    * @return deptId
    */
   public Integer getDeptId() {
       return deptId;
   }
   /**
    * 设置属性:deptId
    * 部门id
    * @param deptId
    */
   public void setDeptId(Integer deptId) {
       this.deptId = deptId;
   }
	
   /**
    * 获取属性:createTime
    * 创建时间
    * @return createTime
    */
   public Date getCreateTime() {
       return createTime;
   }
   /**
    * 设置属性:createTime
    * 创建时间
    * @param createTime
    */
   public void setCreateTime(Date createTime) {
       this.createTime = createTime;
   }

}