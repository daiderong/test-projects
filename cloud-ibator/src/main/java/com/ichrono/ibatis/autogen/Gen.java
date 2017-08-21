package com.ichrono.ibatis.autogen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;

import com.ichrono.ibatis.autogen.util.FileUtil;
import com.ichrono.ibatis.autogen.util.VelocityTemplate;

/**
 * Function: 入口.
 * @Date:2014-9-10下午4:53:35
 */
public class Gen {
	/** 日志记录 */
	private final static Logger logger = Logger.getLogger(Gen.class);
	//Source目录，从ClassPath中获取
	private final static String SOURCE_IN_PATH = ClassLoader.getSystemResource("").getPath();
	
	//生成的Maven结构的代码路径
	private final static String PATH_JAVA_VM = "/javatmp";
	private final static String PATH_RESOURCES_VM = "/imaptmp";
	private final static String PATH_RESOURCES1_VM = "/mymaptmp";
	private final static String PATH_JAVA = "/java/";
	private final static String PATH_RESOURCES = "/imap/";
	private final static String PATH_RESOURCES1 = "/mymap/";
	
	private AllTableInf allTableInf;
	private GlobalBean globalBean;
	private Settings settings;
	public static List<String> tables =new ArrayList<String>();
	static{
		//自定义生成的表 表名称添加进list即可，只生成list中的表 ,适合改动过的表重新生成配置文件
		tables.add("service_cost_settlement_bill_flag");
	}
	
	public Gen(DbConn dbConn){
		allTableInf = new AllTableInf(dbConn);
		globalBean = new GlobalBean();
		settings = dbConn.getSettings();
	}

	/**
	 * 生成入口
	 * @param args
	 */
	public static void main(String[] args) {
		//生成DAO代码
		Gen.doGen();
	}

	/**
	 *  开始生成。。。
	 * @Date:2014-11-28下午2:54:51
	 */
	private static void doGen() {
		logger.info("开始执行DAO代码生成===========================");
		//初始化系统环境
		Settings settings = new Settings();
		if(!settings.initSystemParam()){
			logger.error("系统初始化失败！");
			return;
		}
		//初始化数据库连接
		DbConn dbConn = new DbConn(settings);
		if(!dbConn.isInit()){
			logger.error("数据库连接创建失败！");
			return;
		}
		Gen gen = new Gen(dbConn);
		//设置工程的全局变量
		gen.globalBean.setNowDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
		gen.globalBean.setUserName(System.getenv().get("USERNAME"));
		gen.globalBean.setPackageName(settings.getJavaPackage());
		String tabName;
		List<String> tableList = gen.allTableInf.getAllTableName();
		//创建系统目录结构
		logger.info("共有" + tableList.size() + "个表需要生成数据访问层.");
		List<TableBean> tbList = new ArrayList<TableBean>();
		TableBean tb;
		for (int i = 0; i < tableList.size(); i++) {
			tabName = tableList.get(i);
			logger.info("第" + (i+1) + "个表["+tabName+"]sqlMap正在生成中...");
			tb = gen.beginGen(tabName);
			if(tb!=null){
				tbList.add(tb);
			}
		}
		logger.info("实际生成" + tbList.size() + "个表的sqlMap！");
		dbConn.closeConn();
		logger.info("结束执行DAO代码生成===========================");

	}

	/**生成文件
	 * @param tablename
	 * @return 
	 * @Date:2014-11-28下午3:25:10
	 */
	private TableBean beginGen(String tablename) {
		TableBean tableBean = allTableInf.getTableBean(tablename);
		if(tableBean==null){
			return null;
		}
		VelocityContext ctx = new VelocityContext();
		ctx.put("tbb", tableBean);	//设置表对象
		ctx.put("gb", globalBean); //设置全局信息
		ctx.put("sysInit", settings);	//设置系统信息
		try {
			//生成Java代码
			String javaVmDir = SOURCE_IN_PATH + settings.getTmplPath()+PATH_JAVA_VM;
			String javaDir = settings.getGenPath() + settings.getTmplPath()+PATH_JAVA;
			List<String> javaVmList = FileUtil.getFileListWithExt(javaVmDir,".vm");
			String createFilename;
			String packageDir = "";
			String packageStr;
			for(String vmFilename:javaVmList){
				createFilename = FileUtil.getFilenameWithoutExt(vmFilename);
				if(createFilename.startsWith("DO.")){
					createFilename = createFilename.replace("DO", "");
			    }
				packageStr = FileUtil.findLine(javaVmDir + "/" + vmFilename, "package");
				if(StringUtils.isNotBlank(packageStr)){
					packageStr = packageStr.substring(packageStr.indexOf("$!{gb.packageName}"),packageStr.indexOf(";"));
					packageDir = packageStr.replace("$!{gb.packageName}", globalBean.getPackageName()).replace(".", "/");
				}
				FileUtil.mkDirs(javaDir + packageDir);
				VelocityTemplate.mergeTemplate(settings.getTmplPath() + PATH_JAVA_VM + "/" + vmFilename, javaDir + packageDir + "/" + tableBean.getClassName() + createFilename, ctx);
				logger.info(tableBean.getClassName() + createFilename);
			}
			//生成ibatis的SqlMap配置文件
			String iSqlmapVm = settings.getTmplPath() + PATH_RESOURCES_VM + "/imap.xml.vm";
			String iSqlmapDir = settings.getGenPath() + settings.getTmplPath() + PATH_RESOURCES;
			FileUtil.mkDirs(iSqlmapDir);
			VelocityTemplate.mergeTemplate(iSqlmapVm, iSqlmapDir + tableBean.getTableName() + ".xml", ctx);
			//生成mybatis的SqlMap配置文件
			String mySqlmapVm = settings.getTmplPath() + PATH_RESOURCES1_VM + "/mymap.xml.vm";
			String mySqlmapDir = settings.getGenPath() + settings.getTmplPath() + PATH_RESOURCES1;
			FileUtil.mkDirs(mySqlmapDir);
			VelocityTemplate.mergeTemplate(mySqlmapVm, mySqlmapDir + tableBean.getTableName() + ".xml", ctx);
		} catch (Exception e) {
			logger.error("表[" + tablename +"]生成出错，异常是:",e);
		}
		return tableBean;
	}
	
}
