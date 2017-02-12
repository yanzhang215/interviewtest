package com.zy.ds;

/**
 * @author yanzhang
 * 
 * Doubly Linked List Data Node
 *
 */

public class LinkedNode {
	private Integer data;
	private LinkedNode nextNode;
	private LinkedNode privNode;
	
	public String toString(){
		return String.valueOf(data);
	}

	public LinkedNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(LinkedNode nextNode) {
		this.nextNode = nextNode;
	}

	public LinkedNode getPrivNode() {
		return privNode;
	}

	public void setPrivNode(LinkedNode privNode) {
		this.privNode = privNode;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}	
}
