package com.sean.刷题.高频题;

/**
 * _283_移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 *
 * @author chenxu
 * @summary _283_移动零
 * @since 2020-11-19 20:28
 */
public class _283_移动零 {

    public void moveZeroes(int[] nums) {
        int zeroNum=0;//用来计算0的个数
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0) {//如果nums[i]=0,zeroNum个数加一
                zeroNum++;
            } else if (zeroNum != 0) {//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                nums[i-zeroNum] = nums[i];
                nums[i] = 0;
            }
        }

    }

    public void moveZeroes1(int[] nums) {
        if (nums == null) return;
        for (int i = 0, cur = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (cur != i) {
                nums[cur] = nums[i];
                nums[i] = 0;
            }
            cur++;
        }
    }
}
