package com.ichrono.ibatis.autogen;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ichrono.ibatis.autogen.util.FileUtil;
import com.ichrono.ibatis.autogen.util.PropertiesUtil;
/**
 * Function: 数据库及生成路径的配置信息.
 * @Date:2014-12-1上午10:18:23
 */
public class Settings {
	private final static Logger logger = Logger.getLogger(Settings.class);
	
	/** 数据库驱动类名 */
	private String driver;
	/** 数据库类型 */
	private int dbType;
	/** 数据库服务器 */
	private String url;
	/** 数据库名 */
	private String dbName;
	/** 数据库用户名 */
	private String dbUser;
	/** 数据库用户密码 */
	private String dbPwd;
	/**模版路径 */
	private String tmplPath;
	/**包路径 */
	private String javaPackage;
	/** 代码输出路径 */
	private String genPath;

	public static final int DB_TYPE_MYSQL = 1;	//Mysql

	/**
	 * 初始化系统参数
	 * 
	 * @param dbname
	 * @return
	 */
	public boolean initSystemParam() {
		boolean blnRet = true;
		
		String dbConfPath = "config/";
		String absDbPath = ClassLoader.getSystemResource(dbConfPath).getPath();
		logger.info("开始初始化数据库环境,路径为【" + absDbPath + "】");
		//加载DB属性文件
		List<String> files = FileUtil.getFileListWithExt(absDbPath, ".properties");
		String propertiesFilename = null;
		if(files!=null&&files.size()==1){
			propertiesFilename = files.get(0);
			logger.info("找到DB属性配置文件,文件名为【" + absDbPath + propertiesFilename + "】");
		}
		if(propertiesFilename==null){
			logger.error("DB属性配置文件在["+absDbPath+"]找不到！");
			return false;
		}
		//解析属性文件
		Properties prop = PropertiesUtil.getPropertiesByResourceBundle(dbConfPath + FileUtil.getFilenameWithoutExt(propertiesFilename));
		if (prop == null) {
			logger.error("属性配置文件内容解析为空！");
			return false;
		}
		
		//设置DB类型及数据库连接信息
		String type = (String) prop.get("DB_TYPE");
		if("Mysql".equals(type)){
			dbType = Settings.DB_TYPE_MYSQL;
		}else{
			logger.error("属性配置文件指定的DB_TYPE不存在！type：" + type);
			blnRet = false;
		}
		url = (String) prop.get("DB_SERVER");
		dbName = (String) prop.get("DB_NAME");
		dbUser = (String) prop.get("DB_USER");
		dbPwd = (String) prop.get("DB_PWD");
		javaPackage = (String) prop.get("JAVA_PACKAGE");
		tmplPath = dbConfPath;
		logger.warn("模版路径：" + tmplPath);
		genPath = System.getProperty("user.dir") + "/gendir/";
		logger.warn("代码生成输出路径：" + genPath);
		//打印数据库DAO代码生成环境配置信息
		Iterator<Entry<Object,Object>> it = prop.entrySet().iterator();
		logger.info("代码生成环境配置信息如下：");
		while (it.hasNext()) {
			Entry<Object, Object> en = it.next();
			logger.info(en.getKey() + "=" + en.getValue());
		}
		logger.info("结束初始化数据库代码生成环境【" + absDbPath + propertiesFilename + "】！");
		return blnRet;
	}
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getDbType() {
		return dbType;
	}

	public void setDbType(int dbType) {
		this.dbType = dbType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPwd() {
		return dbPwd;
	}

	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}

	public String getTmplPath() {
		return tmplPath;
	}

	public void setTmplPath(String tmplPath) {
		this.tmplPath = tmplPath;
	}

	public String getJavaPackage() {
		return javaPackage;
	}

	public void setJavaPackage(String javaPackage) {
		this.javaPackage = javaPackage;
	}

	public String getGenPath() {
		return genPath;
	}

	public void setGenPath(String genPath) {
		this.genPath = genPath;
	}

	public static int getDbTypeMysql() {
		return DB_TYPE_MYSQL;
	}
	public static void main(String[] args) {
		Settings settings = new Settings();
		System.out.println(ClassLoader.getSystemResource("").getPath());
		System.out.println(settings.initSystemParam());
	}
}
