package com.ichrono.admin.model.pojo;

import java.io.Serializable;

/**
 *
 * @author 
 * @since 2016-08-06
 */
public class UserRole implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** user_role_id **/
    private Long userRoleId;
	/** user_id **/
    private Integer userId;
	/** role_id **/
    private Integer roleId;

	
   /**
    * 获取属性:userRoleId
    * user_role_id
    * @return userRoleId
    */
   public Long getUserRoleId() {
       return userRoleId;
   }
   /**
    * 设置属性:userRoleId
    * user_role_id
    * @param userRoleId
    */
   public void setUserRoleId(Long userRoleId) {
       this.userRoleId = userRoleId;
   }
	
   /**
    * 获取属性:userId
    * user_id
    * @return userId
    */
   public Integer getUserId() {
       return userId;
   }
   /**
    * 设置属性:userId
    * user_id
    * @param userId
    */
   public void setUserId(Integer userId) {
       this.userId = userId;
   }
	
   /**
    * 获取属性:roleId
    * role_id
    * @return roleId
    */
   public Integer getRoleId() {
       return roleId;
   }
   /**
    * 设置属性:roleId
    * role_id
    * @param roleId
    */
   public void setRoleId(Integer roleId) {
       this.roleId = roleId;
   }

}