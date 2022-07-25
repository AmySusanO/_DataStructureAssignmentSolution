package com.gl.brackets;

import java.util.*;
import java.util.Scanner;

public class BalancingBrackets {
	
	
	static boolean checkingBracketsBalanced(String strBalancebrackts) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<strBalancebrackts.length();i++) {
			char character = strBalancebrackts.charAt(i);
			if(character=='{' ||  character == '[' || character == '(') {
				stack.push(character);
				continue;
			}
			if(stack.isEmpty())
				return false;
			char c;
			switch(character) {
			
			case '}':
				c= stack.pop();
				if(c=='(' || c=='[') 
					return false;
				break;
				
			case ')':
				c= stack.pop();
				if(c=='{' || c=='[') 
					return false;
				break;
			case ']':
				c= stack.pop();
				if(c=='{' || c=='(') 
					return false;
				break;
				
			}
		}
		
		return stack.isEmpty();
		
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println("Enter the bracket expression");
		
		Scanner sc = new Scanner(System.in);
		String  strBracketExpression = sc.next();
		
		Boolean result;
		
		result = checkingBracketsBalanced(strBracketExpression);
				
		if(result) {
			System.out.println("Entered brackets are balanced");
		}
		else {
			System.out.println("Entered brackets are not balanced");
		}
	}
	
	

}
