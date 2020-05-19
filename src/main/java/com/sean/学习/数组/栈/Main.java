package com.sean.学习.数组.栈;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(11);
		stack.push(22);
		stack.push(33);
		stack.push(44);
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
