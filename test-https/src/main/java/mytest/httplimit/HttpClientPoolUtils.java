package mytest.httplimit;
import java.io.IOException;  
import java.util.Random;  
  
import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  
import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.HttpStatus;  
import org.apache.http.HttpVersion;  
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.conn.scheme.PlainSocketFactory;  
import org.apache.http.conn.scheme.Scheme;  
import org.apache.http.conn.scheme.SchemeRegistry;  
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;  
import org.apache.http.params.BasicHttpParams;  
import org.apache.http.params.CoreConnectionPNames;  
import org.apache.http.params.CoreProtocolPNames;  
import org.apache.http.params.HttpParams;  
  
public class HttpClientPoolUtils {  
    private static final Log log = LogFactory.getLog(HttpClientPoolUtils.class);  
    private static ThreadSafeClientConnManager cm = null;  
    static {  
        SchemeRegistry schemeRegistry = new SchemeRegistry();  
        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory  
                .getSocketFactory()));  
  
        cm = new ThreadSafeClientConnManager(schemeRegistry);  
        try {  
            int maxTotal = 1000;  
            cm.setMaxTotal(maxTotal);  
        } catch (NumberFormatException e) {  
            log.error(  
                    "Key[httpclient.max_total] Not Found in systemConfig.properties",  
                    e);  
        }  
        // 每条通道的并发连接数设置（连接池）  
        try {  
            int defaultMaxConnection = 50;  
            cm.setDefaultMaxPerRoute(defaultMaxConnection);  
        } catch (NumberFormatException e) {  
            log.error(  
                    "Key[httpclient.default_max_connection] Not Found in systemConfig.properties",  
                    e);  
        }  
    }  
  
    public static HttpClient getHttpClient() {  
        HttpParams params = new BasicHttpParams();  
        params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION,  
                HttpVersion.HTTP_1_1);  
        params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000); // 3000ms  
        return new DefaultHttpClient(cm, params);  
    }  
  
    public static void release() {  
        if (cm != null) {  
            cm.shutdown();  
        }  
    }  
  
    public static void main(String[] args) throws ClientProtocolException,  
            IOException {  
        Random r = new Random();  
        long l1 = System.currentTimeMillis();  
        
        for (int i = 0; i < 100; i++) {  
        	HttpClient client = getHttpClient();  
            HttpGet get = new HttpGet("http://dev.healthcare-inc.com/asthma-app/test.htm"  );  
            HttpResponse response = client.execute(get);  
           
        }  
        System.out.println("查询耗时" + (System.currentTimeMillis() - l1));  
    }  
  
}  