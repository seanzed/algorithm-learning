package com.sean.学习.排序;

public class Student implements Comparable<Student> {
	public int score;
	public int age;
	
	public Student(int score, int age) {
		this.score = score;
		this.age = age;
	}
	
	@Override
	public int compareTo(Student o) {
		return age - o.age;
	}
}
