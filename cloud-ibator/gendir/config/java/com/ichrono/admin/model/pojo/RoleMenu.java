package com.ichrono.admin.model.pojo;

import java.io.Serializable;

/**
 *
 * @author 
 * @since 2016-08-06
 */
public class RoleMenu implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** role_menu_id **/
    private Long roleMenuId;
	/** role_id **/
    private Integer roleId;
	/** menu_id **/
    private Integer menuId;

	
   /**
    * 获取属性:roleMenuId
    * role_menu_id
    * @return roleMenuId
    */
   public Long getRoleMenuId() {
       return roleMenuId;
   }
   /**
    * 设置属性:roleMenuId
    * role_menu_id
    * @param roleMenuId
    */
   public void setRoleMenuId(Long roleMenuId) {
       this.roleMenuId = roleMenuId;
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
	
   /**
    * 获取属性:menuId
    * menu_id
    * @return menuId
    */
   public Integer getMenuId() {
       return menuId;
   }
   /**
    * 设置属性:menuId
    * menu_id
    * @param menuId
    */
   public void setMenuId(Integer menuId) {
       this.menuId = menuId;
   }

}