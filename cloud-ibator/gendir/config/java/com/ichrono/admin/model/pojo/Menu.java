package com.ichrono.admin.model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 * @since 2016-08-06
 */
public class Menu implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** menu_id **/
    private Long menuId;
	/** name **/
    private String name;
	/** url **/
    private String url;
	/** parent_id **/
    private Integer parentId;
	/** 在同一级菜单下的排位 **/
    private Integer position;
	/** 0为失效，1为有效 **/
    private Integer status;
	/** 创建时间 **/
    private Date createTime;

	
   /**
    * 获取属性:menuId
    * menu_id
    * @return menuId
    */
   public Long getMenuId() {
       return menuId;
   }
   /**
    * 设置属性:menuId
    * menu_id
    * @param menuId
    */
   public void setMenuId(Long menuId) {
       this.menuId = menuId;
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
    * 获取属性:url
    * url
    * @return url
    */
   public String getUrl() {
       return url;
   }
   /**
    * 设置属性:url
    * url
    * @param url
    */
   public void setUrl(String url) {
       this.url = url;
   }
	
   /**
    * 获取属性:parentId
    * parent_id
    * @return parentId
    */
   public Integer getParentId() {
       return parentId;
   }
   /**
    * 设置属性:parentId
    * parent_id
    * @param parentId
    */
   public void setParentId(Integer parentId) {
       this.parentId = parentId;
   }
	
   /**
    * 获取属性:position
    * 在同一级菜单下的排位
    * @return position
    */
   public Integer getPosition() {
       return position;
   }
   /**
    * 设置属性:position
    * 在同一级菜单下的排位
    * @param position
    */
   public void setPosition(Integer position) {
       this.position = position;
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