package com.ichrono.ibatis.autogen;

import java.util.ArrayList;
import java.util.List;

import com.ichrono.ibatis.autogen.util.CharUtil;


public class TableBean {
	/**================表结构信息======================*/
	/** 表名 */
	private String tableName;
	private String engine;
	private String charset;
	
	/**================根据表结构生成表对象及字段信息======================*/
	/** 类名 */
	private String className;
	/** 类对象名 */
	private String objectName;

	/** 主键 */
	private ColBean pkcol;
	/** 字段列表 */
	private List<ColBean> colList = new ArrayList<ColBean>();


	
	/**
	 * 有参构造函数
	 * @param tableName
	 */
	public TableBean(String tableName){
		this.tableName = tableName;
		this.className = getClassName(this.tableName);
		this.objectName = getObjectName(this.className);
	}
	
//	public static TableBean build(String tableName) {
//		return new TableBean(tableName).setConf((null != Gen.tconfig
//				.get(tableName)) ? Gen.tconfig.get(tableName) : Gen.tconfig
//				.get(tableName));
//	}
	
	/**
	 * 根据表名生成对象类名,例如：account_audit -> AcountAudit
	 * @param tablename
	 * @return
	 */
	public static String getClassName(String tablename) {
		if ("".equals(tablename) || tablename == null)
			return "";
		char[] a = tablename.toLowerCase().toCharArray();
		StringBuffer sb = new StringBuffer();
		// 首字母转大写
		sb.append(CharUtil.toUpperCase(a[0]));
		//下划线首字母转大写
		for (int i = 1; i < a.length; i++) {
			char c = a[i];
			if (c == '_' && i < a.length - 1) {
				a[i + 1] = CharUtil.toUpperCase(a[i + 1]);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 根据类名生成对象名,例如：FullName->fullName
	 * @param classname
	 * @return
	 */
	public static String getObjectName(String classname) {
		char[] a = classname.toCharArray();
		a[0] = CharUtil.toLowerCase(a[0]);
		return new String(a);
	}
	
	
	
	
	public String getTableName() {
		return tableName;
	}

	public TableBean setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	
	
	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	
	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public List<ColBean> getColList() {
		return colList;
	}


	public TableBean addColBean(ColBean colBean) {
		this.colList.add(colBean);
		return this;
	}

	public String getClassName() {
		return className;
	}

	public TableBean setClassName(String className) {
		this.className = className;
		return this;
	}
	
	public String getObjectName() {
		return objectName;
	}

	public TableBean setObjectName(String objectName) {
		this.objectName = objectName;
		return this;
	}

	public ColBean getPkcol() {
		return pkcol;
	}

	public TableBean setPkcol(ColBean pkcol) {
		this.pkcol = pkcol;
		return this;
	}

}