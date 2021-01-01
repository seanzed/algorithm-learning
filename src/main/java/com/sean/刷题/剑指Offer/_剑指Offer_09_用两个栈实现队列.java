package com.sean.刷题.剑指Offer;

import com.sean.学习.栈.Stack;

/**
 * _剑指Offer_09_用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead  操作返回 -1 )
 *
 *   
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对  appendTail、deleteHead 进行  10000  次调用
 *
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_09_用两个栈实现队列
 * @since 2020-09-05 11:27
 */
public class _剑指Offer_09_用两个栈实现队列 {

    private Stack<Integer> preStack;

    private Stack<Integer> stack;

    public _剑指Offer_09_用两个栈实现队列() {
        this.preStack = new Stack<>();
        this.stack = new Stack<>();
    }

    public void appendTail(int value) {
        preStack.push(value);
    }

    public int deleteHead() {
        if (stack.isEmpty()) {
            while (!preStack.isEmpty()) {
                stack.push(preStack.pop());
            }
        }

        if (stack.isEmpty()) {
            return -1;
        } else {
            int deleteValue = stack.pop();
            return deleteValue;
        }
    }
}
