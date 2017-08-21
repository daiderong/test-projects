

public class ChengDeWebserviceConfig {

	private static String webserviceBaseUrl = "http://193.168.2.3/cdcqhlxjk/services/CdcqhlxjkService";
	
	private static String user =  "cqhlbx";
	
	private static String pwd =  "cqhlbx";
	
	private static String sid =  "cq_hlbx_query_person";
	

	public static String getWebserviceBaseUrl() {
		return webserviceBaseUrl;
	}

	public static void setWebserviceBaseUrl(String webserviceBaseUrl) {
		ChengDeWebserviceConfig.webserviceBaseUrl = webserviceBaseUrl;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		ChengDeWebserviceConfig.user = user;
	}

	public static String getPwd() {
		return pwd;
	}

	public static void setPwd(String pwd) {
		ChengDeWebserviceConfig.pwd = pwd;
	}

	public static String getSid() {
		return sid;
	}

	public static void setSid(String sid) {
		ChengDeWebserviceConfig.sid = sid;
	}

	
	
	
	
	
}
