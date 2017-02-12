package com.zy.test.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.jws.WebService;

import com.zy.test.inf.LunServiceInf;
import com.zy.test.storage.lun.LunStorage;

@WebService(
		targetNamespace = "http://ws.service.com/",
		portName = "LunPort",
		endpointInterface="com.zy.test.inf.LunServiceInf",
		serviceName="LunService") 
public class LunServiceImpl implements LunServiceInf {

	private HashMap<String, LunStorage> lunManager;
	
	public LunServiceImpl(){
		lunManager = new HashMap<String, LunStorage>();
	}

	@Override
	public synchronized List<LunStorage> createLUN(List<LunStorage> luns) {
		if (luns == null) {
			return null;
		}
		for (LunStorage lun : luns) {
			lun.setLunId(UUID.randomUUID().toString());
			lunManager.put(lun.getLunId(), lun);
		}
		return luns;
	}


	@Override
	public synchronized Integer resizeLUN(String lunId, Integer newSize) {
		LunStorage lun = lunManager.get(lunId);
		if (lun == null) {
			return null;
		}
		lun.setLunSize(newSize);
		return newSize;
	}

	@Override
	public synchronized Boolean removeLUN(String lunId) {
		LunStorage lun = lunManager.get(lunId);
		if (lun == null) {
			return false;
		}
		lunManager.remove(lunId);
		return true;
	}

	@Override
	public synchronized LunStorage fetchLUN(String lunId) {
		LunStorage lun = lunManager.get(lunId);
		if (lun == null) {
			return null;
		}

		return lun;
	}

	@Override
	public synchronized Boolean writeLUN(String lunId, byte[] data) {
		LunStorage lun = lunManager.get(lunId);
		if (lun == null) {
			return false;
		}
		lun.setData(data);
		return true;
	}

	@Override
	public synchronized byte[] readLUN(String lunId) {
		LunStorage lun = lunManager.get(lunId);
		if (lun == null) {
			return null;
		}

		return lun.getData();
	}

	@Override
	public synchronized Boolean saveLUN(String lunId) {
		LunStorage lun = lunManager.get(lunId);
		if (lun == null) {
			return false;
		}
		File f = new File("lun.dat");
        try    {
            byte[] data = lun.getData();      
            FileOutputStream out = new FileOutputStream(f);            
            out.write(data);        
            out.close();
        }catch(Exception e)    {
            System.out.println(e);
            return false;
        }
		return true;
	}

}
