package com.zy.server;

import javax.xml.ws.Endpoint;

import com.zy.test.impl.LunServiceImpl;

/**
 * @author yanzhang
 * 
 * storage array simulator as a web service or application,
 * It provides SOAP or REST API to users. The following functions are supported:
 * 1. Create one or multiple LUN¡¯s
 * 2. Resize a LUN
 * 3. Remove a LUN
 * 4. Retrieve the information (size) of a LUN
 * 5. Concurrent requests
 * 6. Data persistence
 *
 */

public class Server {
	public static void main(String[] args) {  
        System.out.println("web service start");  
        LunServiceImpl implementor = new LunServiceImpl();  
        String address = "http://localhost:8080/lunInf";  
        Endpoint.publish(address, implementor);  
        System.out.println("web service started");  
   }
}
