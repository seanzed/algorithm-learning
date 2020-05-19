package com.sean.栈;

import java.util.Stack;

/**
 * description 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author chenxu 2020/05/19 23:25
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character topChar = stack.pop();
                if (ch == ')' && topChar != '(') {
                    return false;
                } else if (ch == '}' && topChar != '{') {
                    return false;
                } else if (ch == ']' && topChar != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}