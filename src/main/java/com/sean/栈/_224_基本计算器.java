package com.sean.栈;

import java.util.LinkedList;

/**
 * description 实现一个基本的计算器来计算一个简单的字符串表达式的值。 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * https://leetcode-cn.com/problems/basic-calculator/
 * @TODO
 * @author chenxu 2020/05/19 23:28
 */
public class _224_基本计算器 {

    public int calculate(String s) {
        LinkedList<Boolean> stack = new LinkedList<>();
        int result = 0, opr = 0; //result: 当前的结果值; opr: 当前的被加/被减数
        Character op = null; //当前要执行的运算符
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                if (op == null) {
                    //遇到第一个运算符时，将result置为opr（即第一个运算符左边的数字）
                    result = opr;
                } else {
                    //result = result +/- opr;
                    result = cal(op, result, opr);
                }
                //根据栈顶元素决定是否反转运算符
                op = swap(stack.peek() == null ? false : stack.peek(), c);
                opr = 0;
            } else if (c == '(') {
                stack.push(op != null && op == '-');
            } else if (c == ')') {
                stack.pop();
            } else if (c != ' ') {
                opr = opr * 10 + c - '0';
            }
        }
        if (op == null) {
            //算式中没有运算符时，opr就是最终结果
            return opr;
        } else {
            //否则将result与opr（即算式中最右边的数字）执行一次运算
            return cal(op, result, opr);
        }
    }

    char swap(boolean swap, char c) {
        if (swap) {
            return c == '+' ? '-' : '+';
        } else {
            return c;
        }
    }

    private int cal(char op, int opr1, int opr2) {
        switch (op) {
            case '+':
                return opr1 + opr2;
            case '-':
                return opr1 - opr2;
            default:
                return 0;
        }
    }
}
