package com.zy.ds;

/**
 * @author yanzhang
 * 
 *         Doubly Linked List
 */

public class LinkedList {
	//header
	private LinkedNode pre;
	//tailer
	private LinkedNode post;
	//list length
	private Integer length;

	public LinkedList() {
		pre = new LinkedNode();
		post = new LinkedNode();
		pre.setNextNode(post);
		post.setPrivNode(pre);
		length = 0;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public Integer size() {
		return length;
	}

	public void addNode(Integer val) {
		LinkedNode last = post.getPrivNode();
		LinkedNode newNode = new LinkedNode();
		newNode.setData(val);
		newNode.setNextNode(post);
		newNode.setPrivNode(last);
		post.setPrivNode(newNode);
		last.setNextNode(newNode);
		length++;
	}

	public void dumpList() {
		LinkedNode cur = pre;
		while (cur.getNextNode() != null) {
			cur = cur.getNextNode();
			if (cur.getNextNode() != null) {
				System.out.print(cur.getData() + "->");
			} else {
				System.out.print(cur.getData());
			}
		}
		System.out.println();
	}

	void reverse(int k) {
		if (k <= 0 || k > length) {
			return;
		}
		LinkedNode temp = null;
		LinkedNode current = pre;
		LinkedNode last = pre.getNextNode();
		int n = 0;

		while (current != null) {
			temp = current.getPrivNode();
			current.setPrivNode(current.getNextNode());
			current.setNextNode(temp);
			current = current.getPrivNode();
			n++;
			if (n > k) {
				last.setNextNode(current);
				pre.setNextNode(current.getPrivNode());
				pre.setPrivNode(null);
				current.getPrivNode().setPrivNode(pre);
				current.setPrivNode(last);
				break;
			}
		}
	}
}
