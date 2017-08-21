package com.ichrono.admin.model.pojo;

import java.io.Serializable;

/**
 *
 * @author 
 * @since 2016-08-06
 */
public class RoleMenuOptDetail implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** id **/
    private Long roleMenuOptId;
	/** 权限号 **/
    private Integer roleId;
	/** 菜单id号 **/
    private Integer menuId;
	/** 查 **/
    private Integer dataQuery;
	/** 增 **/
    private Integer dataAdd;
	/** 改 **/
    private Integer dataUpdate;
	/** 删 **/
    private Integer dataDelete;
	/** 是否能导出 **/
    private Integer dataExport;

	
   /**
    * 获取属性:roleMenuOptId
    * id
    * @return roleMenuOptId
    */
   public Long getRoleMenuOptId() {
       return roleMenuOptId;
   }
   /**
    * 设置属性:roleMenuOptId
    * id
    * @param roleMenuOptId
    */
   public void setRoleMenuOptId(Long roleMenuOptId) {
       this.roleMenuOptId = roleMenuOptId;
   }
	
   /**
    * 获取属性:roleId
    * 权限号
    * @return roleId
    */
   public Integer getRoleId() {
       return roleId;
   }
   /**
    * 设置属性:roleId
    * 权限号
    * @param roleId
    */
   public void setRoleId(Integer roleId) {
       this.roleId = roleId;
   }
	
   /**
    * 获取属性:menuId
    * 菜单id号
    * @return menuId
    */
   public Integer getMenuId() {
       return menuId;
   }
   /**
    * 设置属性:menuId
    * 菜单id号
    * @param menuId
    */
   public void setMenuId(Integer menuId) {
       this.menuId = menuId;
   }
	
   /**
    * 获取属性:dataQuery
    * 查
    * @return dataQuery
    */
   public Integer getDataQuery() {
       return dataQuery;
   }
   /**
    * 设置属性:dataQuery
    * 查
    * @param dataQuery
    */
   public void setDataQuery(Integer dataQuery) {
       this.dataQuery = dataQuery;
   }
	
   /**
    * 获取属性:dataAdd
    * 增
    * @return dataAdd
    */
   public Integer getDataAdd() {
       return dataAdd;
   }
   /**
    * 设置属性:dataAdd
    * 增
    * @param dataAdd
    */
   public void setDataAdd(Integer dataAdd) {
       this.dataAdd = dataAdd;
   }
	
   /**
    * 获取属性:dataUpdate
    * 改
    * @return dataUpdate
    */
   public Integer getDataUpdate() {
       return dataUpdate;
   }
   /**
    * 设置属性:dataUpdate
    * 改
    * @param dataUpdate
    */
   public void setDataUpdate(Integer dataUpdate) {
       this.dataUpdate = dataUpdate;
   }
	
   /**
    * 获取属性:dataDelete
    * 删
    * @return dataDelete
    */
   public Integer getDataDelete() {
       return dataDelete;
   }
   /**
    * 设置属性:dataDelete
    * 删
    * @param dataDelete
    */
   public void setDataDelete(Integer dataDelete) {
       this.dataDelete = dataDelete;
   }
	
   /**
    * 获取属性:dataExport
    * 是否能导出
    * @return dataExport
    */
   public Integer getDataExport() {
       return dataExport;
   }
   /**
    * 设置属性:dataExport
    * 是否能导出
    * @param dataExport
    */
   public void setDataExport(Integer dataExport) {
       this.dataExport = dataExport;
   }

}