package com.sean.刷题.DFS;

import java.util.HashMap;
import java.util.Map;

/**
 * _290_单词规律
 * 给定一种规律 pattern  和一个字符串  str  ，判断 str 是否遵循相同的规律。
 *
 * 这里的  遵循  指完全匹配，例如，  pattern  里的每个字母和字符串  str  中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例  4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 链接：https://leetcode-cn.com/problems/word-pattern
 *
 * @author chenxu
 * @summary _290_单词规律
 * @since 2020-12-16 23:42
 */
public class _290_单词规律 {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] arr = s.split(" ");
        //如果二者长度都不等，那么根本无法匹配 直接返回false
        if(pattern.length() != arr.length)
            return false;
        for(int i = 0; i < pattern.length(); i++){
            if(!map.containsKey(pattern.charAt(i))){
                // 如果不包含key，包含对应的value 直接返回false
                if(map.containsValue(arr[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), arr[i]);
            }
            else{
                if(!map.get(pattern.charAt(i)).equals(arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _290_单词规律 test = new _290_单词规律();
        System.out.println(test.wordPattern("abba", "dog cat cat dog"));
    }
}
