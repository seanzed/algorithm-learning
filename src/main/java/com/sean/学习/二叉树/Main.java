package com.sean.学习.二叉树;

import java.util.ArrayList;
import java.util.List;


import com.sean.学习.printer.BinaryTrees;
import com.sean.学习.tools.Times;
import com.sean.学习.二叉树.avl.AVLTree;
import com.sean.学习.集合.ListSet;

@SuppressWarnings("unused")
public class Main {

	static void test1() {
		Integer data[] = new Integer[] {
				67, 52, 92, 96, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
		};
		
		AVLTree<Integer> avl = new AVLTree<>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
			System.out.println("【" + data[i] + "】");
			BinaryTrees.println(avl);
			System.out.println("---------------------------------------");
		}

		for (int i = 0; i < data.length; i++) {
			avl.remove(data[i]);
			System.out.println("【" + data[i] + "】");
			BinaryTrees.println(avl);
			System.out.println("---------------------------------------");
		}
		
		
		BinaryTrees.println(avl);
	}
	
	static void test2() {
		List<Integer> data = new ArrayList<>();
		for (int i = 0; i < 100_0000; i++) {
			data.add((int)(Math.random() * 100_0000));
		}
		
		BST<Integer> bst = new BST<>();
		Times.test("BST", new Times.Task() {

			@Override
			public void execute() {
				testBST(new BST<Integer>(), data);
			}
		});

		Times.test("AVL", new Times.Task() {

			@Override
			public void execute() {
				testBST(new AVLTree<>(), data);
			}
		});

	}

	public static void testBST(BST<Integer> bst, List<Integer> data) {
		System.out.println("----------测试新增功能------------");
		for (int i = 0; i < data.size(); i++) {
			bst.add(data.get(i));
		}
		System.out.println("----------测试包含功能------------");
		for (int i = 0; i < data.size(); i++) {
			bst.contains(data.get(i));
		}
		System.out.println("----------测试删除功能------------");
		for (int i = 0; i < data.size(); i++) {
			bst.remove(data.get(i));
		}
	}
	
	public static void main(String[] args) {
		test2();
	}
}
