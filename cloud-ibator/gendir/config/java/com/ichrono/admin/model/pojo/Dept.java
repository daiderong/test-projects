package com.ichrono.admin.model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 
 * @since 2016-08-06
 */
public class Dept implements Serializable{

	/** 序列化ID */
	private static final long serialVersionUID = 1L;

	/** dept_id **/
    private Long deptId;
	/** name **/
    private String name;
	/** parent_id **/
    private Integer parentId;
	/** 在同一级部门下的显示排位 **/
    private Integer position;
	/** 创建时间 **/
    private Date createTime;

	
   /**
    * 获取属性:deptId
    * dept_id
    * @return deptId
    */
   public Long getDeptId() {
       return deptId;
   }
   /**
    * 设置属性:deptId
    * dept_id
    * @param deptId
    */
   public void setDeptId(Long deptId) {
       this.deptId = deptId;
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
    * 在同一级部门下的显示排位
    * @return position
    */
   public Integer getPosition() {
       return position;
   }
   /**
    * 设置属性:position
    * 在同一级部门下的显示排位
    * @param position
    */
   public void setPosition(Integer position) {
       this.position = position;
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