package com.wondersgroup.adjustment.hessian.test;
import com.caucho.hessian.client.HessianProxyFactory;
import com.wondersgroup.adjustment.dto.Jkx004rtn;
import com.wondersgroup.adjustment.dto.TbLpajxxDTO;
import com.wondersgroup.adjustment.hservice.Jkx004ServiceApi;


/**
 * 测试hessian hjk004
* @ClassName: Hjkx004HessianClientTest 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年7月6日 上午10:06:17 
*
 */
public class Hjkx004HessianClientTest {

    public static void main(String[] args) throws Exception {  
        //Spring Hessian代理Servelet  
        String url = "http://localhost:8380/insuranceService/hjkx004";  
        HessianProxyFactory factory = new HessianProxyFactory();  
        Jkx004ServiceApi api = (Jkx004ServiceApi) factory.create(Jkx004ServiceApi.class, url);  
        TbLpajxxDTO dto = new TbLpajxxDTO();
        dto.setCardType("01");
        Jkx004rtn rtn =  api.countLpxx(dto);
        
        System.out.println(rtn.getRetmsg());
        
        
        
    }  

}