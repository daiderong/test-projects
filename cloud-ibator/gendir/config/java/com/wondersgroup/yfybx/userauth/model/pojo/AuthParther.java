package com.wondersgroup.yfybx.userauth.model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 * @since 2016-08-05
 */
public class AuthParther implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** 合作者ID **/
    private Long partnerId;
	/** 分配给合作者的key **/
    private String partherKey;
	/** 合作者名称 **/
    private String partherName;
	/** 1为有效0为无效 **/
    private Byte authedStatus;
	/** created_at **/
    private Date createdAt;

	
   /**
    * 获取属性:partnerId
    * 合作者ID
    * @return partnerId
    */
   public Long getPartnerId() {
       return partnerId;
   }
   /**
    * 设置属性:partnerId
    * 合作者ID
    * @param partnerId
    */
   public void setPartnerId(Long partnerId) {
       this.partnerId = partnerId;
   }
	
   /**
    * 获取属性:partherKey
    * 分配给合作者的key
    * @return partherKey
    */
   public String getPartherKey() {
       return partherKey;
   }
   /**
    * 设置属性:partherKey
    * 分配给合作者的key
    * @param partherKey
    */
   public void setPartherKey(String partherKey) {
       this.partherKey = partherKey;
   }
	
   /**
    * 获取属性:partherName
    * 合作者名称
    * @return partherName
    */
   public String getPartherName() {
       return partherName;
   }
   /**
    * 设置属性:partherName
    * 合作者名称
    * @param partherName
    */
   public void setPartherName(String partherName) {
       this.partherName = partherName;
   }
	
   /**
    * 获取属性:authedStatus
    * 1为有效0为无效
    * @return authedStatus
    */
   public Byte getAuthedStatus() {
       return authedStatus;
   }
   /**
    * 设置属性:authedStatus
    * 1为有效0为无效
    * @param authedStatus
    */
   public void setAuthedStatus(Byte authedStatus) {
       this.authedStatus = authedStatus;
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

}