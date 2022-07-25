package com.gl.addpair;

import java.util.HashSet;
import java.util.Scanner;

public class FindPair {
	
	static class  Node{
		int nodedata;
		Node leftNode, rightNode;
	}
	
	static Node newNode(int nodeData) {
		Node temp = new Node();
		temp.nodedata = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}
	
	public Node insert(Node root, int key) {
		
		if(root==null) {
			return newNode(key);
		}
		if(key<root.nodedata) 
			root.leftNode = insert(root.leftNode,key);
		else
			root.rightNode = insert(root.rightNode,key);
		return root;
		
	}
	
	public boolean findPairUtil(Node root,int sum, HashSet<Integer> set) {
		if(root == null) {
			return false;
		}
		if(findPairUtil(root.leftNode,sum,set))
			return true;
		if(set.contains(sum-root.nodedata)) {
			System.out.println("Pair is found:"+(sum-root.nodedata)+","+root.nodedata+"");
			return true;
		}
		else
			set.add(root.nodedata);
		return findPairUtil(root.rightNode,sum,set);
	}
	
	public void findPairwithgivenSum(Node root,int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		if(!findPairUtil(root,sum,set))
			System.out.println("Pair do not exist");
	}
	
	public static void main(String[] args) {
		Node root = null;
		FindPair fp = new FindPair();
		
		System.out.println("Enter the number of elements");
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt(); 
		int [] arraySize = new int[size]; 
		
		System.out.println("Enter the elements");
		
		for(int i=0;i<size;i++)
		{
			arraySize[i] = sc.nextInt();
			root= fp.insert(root,arraySize[i]);
		}
		
		System.out.println("Enter the sum value");
		
		int sum = sc.nextInt();
		

		fp.findPairwithgivenSum(root,sum);
	}

}
