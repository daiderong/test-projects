package com.ichrono.admin.model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 * @since 2016-08-06
 */
public class Role implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** role_id **/
    private Long roleId;
	/** name **/
    private String name;
	/** 0为失效，1为有效 **/
    private Integer status;
	/** 备注 **/
    private String remark;
	/** create_time **/
    private Date createTime;

	
   /**
    * 获取属性:roleId
    * role_id
    * @return roleId
    */
   public Long getRoleId() {
       return roleId;
   }
   /**
    * 设置属性:roleId
    * role_id
    * @param roleId
    */
   public void setRoleId(Long roleId) {
       this.roleId = roleId;
   }
	
   /**
    * 获取属性:name
    * name
    * @return name
    */
   public String getName() {
       return name;
   }
   /**
    * 设置属性:name
    * name
    * @param name
    */
   public void setName(String name) {
       this.name = name;
   }
	
   /**
    * 获取属性:status
    * 0为失效，1为有效
    * @return status
    */
   public Integer getStatus() {
       return status;
   }
   /**
    * 设置属性:status
    * 0为失效，1为有效
    * @param status
    */
   public void setStatus(Integer status) {
       this.status = status;
   }
	
   /**
    * 获取属性:remark
    * 备注
    * @return remark
    */
   public String getRemark() {
       return remark;
   }
   /**
    * 设置属性:remark
    * 备注
    * @param remark
    */
   public void setRemark(String remark) {
       this.remark = remark;
   }
	
   /**
    * 获取属性:createTime
    * create_time
    * @return createTime
    */
   public Date getCreateTime() {
       return createTime;
   }
   /**
    * 设置属性:createTime
    * create_time
    * @param createTime
    */
   public void setCreateTime(Date createTime) {
       this.createTime = createTime;
   }

}