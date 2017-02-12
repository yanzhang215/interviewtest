package com.zy.test.inf;

import java.util.List;

import javax.jws.WebService;

import com.zy.test.storage.lun.LunStorage;

/**
 * @author yanzhang
 * 
 * use cxf@3.1.10 implement web service server.
 * 
 * CXF is An Open-Source Services Framework,
 * Apache CXF is an open source services framework. 
 * CXF helps you build and develop services using frontend programming APIs, 
 * like JAX-WS and JAX-RS. These services can speak a variety of protocols such as SOAP,
 * XML/HTTP, RESTful HTTP, or CORBA and work over a variety of transports such as HTTP,
 * JMS or JBI.
 * 
 * storage array simulator as a web service or application,
 * It provides SOAP or REST API to users. The following functions are supported:
 * 1. createLUN: Create one or multiple LUN¡¯s.
 * 2. resizeLUN: Resize a LUN
 * 3. removeLUN: Remove a LUN
 * 4. fetchLUN: Retrieve the information (size) of a LUN
 * 5. Concurrent requests,use synchronized key word with method
 * 6. writeLUN,readLUN,saveLUN: Data persistence
 *
 */

@WebService
public interface LunServiceInf {
	/* Create one or multiple LUN¡¯s */
	List<LunStorage> createLUN(List<LunStorage> luns);
	/* Resize a LUN */
	Integer resizeLUN(String lunId,Integer newSize);
	/* Remove a LUN*/
	Boolean removeLUN(String lunId);
	/* Retrieve the information (size) of a LUN.*/
	LunStorage fetchLUN(String lunId);
	/* Data persistence. */
	Boolean writeLUN(String lunId,byte[] data);
	byte[] readLUN(String lunId);
	/* Data persistence.*/
	Boolean saveLUN(String lunId);
}
