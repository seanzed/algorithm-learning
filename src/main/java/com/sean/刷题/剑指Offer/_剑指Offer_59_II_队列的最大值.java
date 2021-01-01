package com.sean.刷题.剑指Offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * _剑指Offer_59_II_队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value  需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出:  [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出:  [null,-1,-1]
 *   
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数  <= 10000
 * 1 <= value <= 10^5
 *
 *
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_59_II_队列的最大值
 * @since 2020-12-28 19:04
 */
public class _剑指Offer_59_II_队列的最大值 {

    Queue<Integer> q;
    Deque<Integer> d;

    public _剑指Offer_59_II_队列的最大值() {
        q = new LinkedList<Integer>();
        d = new LinkedList<Integer>();
    }

    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}
