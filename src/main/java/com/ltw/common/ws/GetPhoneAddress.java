package com.ltw.common.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.ltw.ws.MobileCodeWS;
import com.ltw.ws.MobileCodeWSSoap;

/**
 * 查询电话号码归属地
 * @author Administrator
 *
 */
public class GetPhoneAddress {

	  public static String getPhoneAddress(String phone) throws MalformedURLException{
	        //1.实例化生成的服务类
	       // MobileCodeWS ws = new MobileCodeWS();
	        Service service = Service.create(new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL")
	                , new QName("http://WebXml.com.cn/","MobileCodeWS"));
	        //2.调用服务类的方法获取接口实例
	       // MobileCodeWSSoap soap = ws.getMobileCodeWSSoap();
	        MobileCodeWSSoap soap = service.getPort(MobileCodeWSSoap.class);
	        //3.通过接口直接获取数据
	        return soap.getMobileCodeInfo(phone,"");
}
}