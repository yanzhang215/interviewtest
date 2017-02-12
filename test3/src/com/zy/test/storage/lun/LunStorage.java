package com.zy.test.storage.lun;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LunStorage implements Serializable{
	/* LUN ID */
	private String lunId;
	/* LUN Name */
	private String lunName;
	/* LUN Storage Size */
	private Integer lunSize;
	/* LUN Storage Data */
	private byte[] data;
	
	public LunStorage(){
		super();
	}
	public String getLunId() {
		return lunId;
	}
	public void setLunId(String lunId) {
		this.lunId = lunId;
	}
	public String getLunName() {
		return lunName;
	}
	public void setLunName(String lunName) {
		this.lunName = lunName;
	}
	public Integer getLunSize() {
		return lunSize;
	}
	public void setLunSize(Integer lunSize) {
		this.lunSize = lunSize;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
}
