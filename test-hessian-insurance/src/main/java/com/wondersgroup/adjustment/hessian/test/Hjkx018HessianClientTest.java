package com.wondersgroup.adjustment.hessian.test;
import com.caucho.hessian.client.HessianProxyFactory;
import com.wondersgroup.adjustment.dto.Jkx018rtn;
import com.wondersgroup.adjustment.dto.TbLpajxxDTO;
import com.wondersgroup.adjustment.hservice.Jkx018ServiceApi;

/**
 * 
* @ClassName: Hjkx018HessianClientTest 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author daiderong@wondersgroup.com（戴德荣）
* @date 2016年7月11日 下午4:59:15 
*
 */
public class Hjkx018HessianClientTest {

    public static void main(String[] args) throws Exception {  
        //Spring Hessian代理Servelet  
      //  String url = "http://10.1.65.141:8380/insuranceService/hjkx018"; 
        HessianProxyFactory factory = new HessianProxyFactory();  
       
        
//        for(int i=0;i<1;i++){
//        	 String url = "http://localhost:8080/insuranceService/hjkx018Moni";
//        	 Jkx018MoniServiceApi api = (Jkx018MoniServiceApi) factory.create(Jkx018MoniServiceApi.class, url);  
//             
//             TbLpajxxDTO dto  =new TbLpajxxDTO();
//             dto.setCardType("01");
//             dto.setNationalid("320505200706301527");
//          
////             dto.setName("徐文军");
//             Jkx018rtn rtn =  api.jkx018(dto);
//             
//             System.out.println(rtn);
//             System.out.println(rtn.getRetmsg());
//             System.out.println(rtn.getZrbe());
//        }
        
        for(int i=0;i<1;i++){
        	 String url = "http://10.1.92.187:8380/insuranceService/hjkx018";
//        	 String url = "http://localhost:8080/insuranceService/hjkx018";
        	 Jkx018ServiceApi api = (Jkx018ServiceApi) factory.create(Jkx018ServiceApi.class, url);  
            
            TbLpajxxDTO dto  =new TbLpajxxDTO();
            dto.setCardType("01");
            dto.setNationalid("320505200706301527");
         
//            dto.setName("徐文军");
            Jkx018rtn rtn =  api.jkx018(dto);
            
            System.out.println(rtn);
            System.out.println(rtn.getRetmsg());
            System.out.println(rtn.getZrbe());
       }
        
       
        
        //{\"cardType\":\"01\",\"no\":\"320681198607282422\",\"name\":\"黄毓衡\"
        
        
        
        
    }  

}