package com.zy.client;

import java.util.LinkedList;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.zy.test.inf.LunServiceInf;
import com.zy.test.storage.lun.LunStorage;

/**
 * @author yanzhang
 * 
 * Storage array simulator as a web service or application
 * WSDL Address: http://localhost:8080/lunInf?wsdl
 */
public class Client {
	public static void dumpLunInfo(String msg, LunStorage lun) {
		if (lun == null) {
			System.out.println("Not found lun!");
			return;
		}
		if (msg != null) {
			System.out.println(msg);
		}
		System.out.println("LUN's ID:" + lun.getLunId());
		System.out.println("LUN's Name:" + lun.getLunName());
		System.out.println("LUN's Size:" + lun.getLunSize());
		if(lun.getData() != null){
			System.out.println("LUN's Data:" + lun.getData().toString());
		}
		System.out.println();
	}

	public static void main(String[] args) {

		JaxWsProxyFactoryBean jwpfb = new JaxWsProxyFactoryBean();
		jwpfb.setServiceClass(LunServiceInf.class);
		jwpfb.setAddress("http://localhost:8080/lunInf");
		LunServiceInf lunService = (LunServiceInf) jwpfb.create();
		LunStorage lun = new LunStorage();
		lun.setLunName("First");
		lun.setLunSize(100);
		List<LunStorage> luns = new LinkedList<LunStorage>();
		luns.add(lun);

		List<LunStorage> createdLuns;

		// Create A LUN
		createdLuns = lunService.createLUN(luns);
		if (createdLuns != null && createdLuns.size() == 1) {
			LunStorage firstLun = createdLuns.get(0);
			dumpLunInfo("Create A LUN", firstLun);

			// Retrieve the information
			String lunId = firstLun.getLunId();
			firstLun = lunService.fetchLUN(lunId);
			dumpLunInfo("Retrieve the information(size=100)", firstLun);

			// Resize A LUN
			lunService.resizeLUN(lunId, 200);
			firstLun = lunService.fetchLUN(lunId);
			dumpLunInfo("Retrieve the information(size=200)", firstLun);

			// Data persistence
			byte[] savedData = "Hello LUN".getBytes();
			lunService.writeLUN(lunId, savedData);
			lunService.saveLUN(lunId);
			savedData = lunService.readLUN(lunId);
			System.out.println("Data persistence:" + new String(savedData));

			// Remove A LUN
			lunService.removeLUN(lunId);
			firstLun = lunService.fetchLUN(lunId);
			dumpLunInfo("Remove A LUN", firstLun);
		}

	}
}
