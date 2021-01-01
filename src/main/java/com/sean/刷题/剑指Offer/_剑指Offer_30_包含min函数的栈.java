package com.sean.刷题.剑指Offer;

import java.util.Stack;

/**
 * _剑指Offer_30_包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *   
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *   
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_30_包含min函数的栈
 * @since 2020-09-09 13:47
 */
public class _剑指Offer_30_包含min函数的栈 {

    Stack<Integer> A, B;

    /** initialize your data structure here. */
    public _剑指Offer_30_包含min函数的栈() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
