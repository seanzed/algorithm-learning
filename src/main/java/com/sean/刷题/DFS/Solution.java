package com.sean.刷题.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author chenxu
 * @summary Solution
 * @Copyright (c) 2021, Lianjia Group All Rights Reserved.
 * @since 2021-03-26 16:33
 */
public class Solution {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) return result;
        char[] ch = str.toCharArray();
        List<Character> list = new ArrayList<>();
        dfs(ch, result, list,  0);
        return result;
    }

    private void dfs(char[] ch, ArrayList<String> result, List<Character> list, int index) {
        if (index == ch.length) {
            StringBuilder sb = new StringBuilder();
            for (Character c : list) {
                sb.append(c);
            }
            result.add(sb.toString());
        }

        for (int i = index; i < ch.length; i++) {
            list.add(ch[i]);

            dfs(ch, result, list, index + 1);
            list.remove(list.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) return result;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(num, result, list, 0);
        return result;
    }

    private void dfs(int[] num, ArrayList<ArrayList<Integer>> result,
                     ArrayList<Integer> list, int index) {
        if (index == num.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (list.contains(num[i])) continue;
            list.add(num[i]);
            dfs(num, result, list, index + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> aa = solution.Permutation("aba");
        for (String s : aa) {
            System.out.println(s);
        }
    }
}
