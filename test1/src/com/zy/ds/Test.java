package com.zy.ds;

/**
 * @author yanzhang
 * 
 * Write a program to reverse every k nodes of a linked list.
 * If the list size is not a multiple of k, then leave the remainder nodes as is.
 * 
 * @see LinkedList
 * @see LinkedNode
 * 
 * Example:
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
 * Output:  3->2->1->6->5->4->7->8->NULL
 */

public class Test {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for (int i = 1; i <= 10; ++i) {
			list.addNode(i);
		}
		
		for(int i=0;i<12;++i)
		{
			System.out.println("K="+i);
			list.reverse(i);
			list.dumpList();
			//recover list
			list.reverse(i);
			System.out.println();
		}
	}
}
