package com.sean.栈;

import java.util.Stack;

/**
 * description 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 * https://leetcode-cn.com/problems/score-of-parentheses
 *
 * @author chenxu 2020/05/19 23:26
 */
public class _856_括号的分数 {

    public int scoreOfParentheses(String S) {
        int score = 0;
        int length = S.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<length; i++){
            char temp = S.charAt(i);
            if(temp=='(')
                stack.add(temp);
            else{
                if(S.charAt(i-1)=='('){
                    score += Math.pow(2, stack.size()-1);
                    stack.pop();
                }else{
                    stack.pop();
                }
            }

        }

        return score;
    }
}
