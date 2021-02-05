package com.sean.刷题.排序;

/**
 * _912_排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1] 输出：[1,2,3,5] 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0] 输出：[0,0,1,1,2,5]  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000 -50000 <= nums[i] <= 50000
 *
 *
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 *
 * @author chenxu
 * @summary _912_排序数组
 * @since 2021-01-21 11:32
 */
public class _912_排序数组 {


    /**
     * 快速排序
     */
    public int[] sortArray8(int[] nums) {
        sort1(nums, 0, nums.length);
        return nums;
    }

    private void sort1(int[] nums, int begin, int end) {
        // 至少要有两个元素
        if (end - begin < 2) return;

        int mid = pivotIndex(nums, begin, end);
        sort1(nums, begin, mid);
        sort1(nums, mid + 1, end);
    }

    /**
     * 轴点元素的最终位置
     * 构造出 [begin, end) 范围的轴点元素
     * @param   nums
     * @param   begin
     * @param   end
     * @return  {@link int}
     * @summary 轴点元素的最终位置
     * @since 2021-01-26 11:40:42
     */
    private int pivotIndex(int[] nums, int begin, int end) {
        // 随机交换begin位置的元素
        swap(nums, begin, begin + (int) (Math.random() * (end - begin)));
        // 备份begin位置的元素
        int pivot = nums[begin];
        // end指向最后一个元素
        end--;
        while (begin < end) {
            while (begin < end) {
                // 右边元素 > 轴点元素
                if (pivot < nums[end]) {
                    end--;
                } else {
                    nums[begin++] = nums[end];
                    break;
                }
            }

            while (begin < end) {
                // 左边元素 < 轴点元素
                if (pivot > nums[begin]) {
                    begin++;
                } else {
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }

        // 将轴点元素放入最终的位置
        nums[begin] = pivot;
        // 返回轴点元素的位置
        return begin;
    }

    private int[] leftArray;

    /**
     * 归并排序
     */
    public int[] sortArray7(int[] nums) {
        leftArray = new int[nums.length >> 1];
        sort(nums, 0, nums.length);
        return nums;
    }

    private void sort(int[] nums, int begin, int end) {
        // 至少要有2个元素
        if (end - begin < 2) return;

        int mid = (begin + end) >> 1;
        sort(nums, begin, mid);
        sort(nums, mid, end);
        merge(nums, begin, mid, end);
    }

    /**
     * [begin, mid), [mid, end)
     */
    private void merge(int[] nums, int begin, int mid, int end) {
        // 左边数组
        int li = 0, le = mid - begin;
        // 右边数组
        int ri = mid, re = end;
        // nums的索引
        int ai = begin;
        // 拷贝左边数组到leftArray
        for (int i = li; i < le; i++) {
            leftArray[i] = nums[begin + i];
        }

        while (li < le) {
            // 比较改为 <= 会失去稳定性
            if (ri < re && nums[ri] < leftArray[li]) {
                // 拷贝右边数组到nums
                nums[ai++] = nums[ri++];
            } else {
                // 拷贝左边数组到nums
                nums[ai++] = leftArray[li++];
            }
        }
    }

    /**
     * 插入排序优化
     */
    public int[] sortArray6(int[] nums) {
        for (int begin = 1; begin < nums.length; begin++) {
            int cur = begin;
            int v = nums[cur];
            while (cur > 0 && nums[cur - 1] > nums[cur]) {
                nums[cur] = nums[cur - 1];
                cur--;
            }
            nums[cur] = v;
        }
        return nums;
    }

    /**
     * 插入排序
     */
    public int[] sortArray5(int[] nums) {
        for (int begin = 1; begin < nums.length; begin++) {
            int cur = begin;
            while (cur > 0 && nums[cur - 1] > nums[cur]) {
                swap(nums, cur, cur - 1);
                cur--;
            }
        }
        return nums;
    }

    /**
     * 堆排序
     */
    public int[] sortArray4(int[] nums) {
        // 堆大小
        int heapSize = nums.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(nums, i, heapSize);
        }

        while (heapSize > 1) {
            swap(nums, 0, --heapSize);
            siftDown(nums, 0, heapSize);
        }
        return nums;
    }

    private void siftDown(int[] nums, int index, int heapSize) {
        int element = nums[index];

        int half = heapSize >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            int childValue = nums[childIndex];

            int rightChildIndex = childIndex + 1;
            if (rightChildIndex < heapSize && nums[rightChildIndex] > childValue) {
                childValue = nums[rightChildIndex];
                childIndex = rightChildIndex;
            }

            if (element >= childValue) break;
            nums[index] = childValue;
            index = childIndex;
        }
        nums[index] = element;
    }

    /**
     * 选择排序
     */
    public int[] sortArray3(int[] nums) {
        for (int end = nums.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[maxIndex] < nums[begin]) {
                    maxIndex = begin;
                }
            }
            swap(nums, maxIndex, end);
        }
        return nums;
    }

    /**
     * 冒泡排序优化
     */
    public int[] sortArray2(int[] nums) {
        for (int end = nums.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin - 1] > nums[begin]) {
                    swap(nums, begin - 1, begin);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
        return nums;
    }

    /**
     * 冒泡排序优化 如果已经有序直接退出
     */
    public int[] sortArray1(int[] nums) {
        for (int end = nums.length - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin - 1] > nums[begin]) {
                    swap(nums, begin - 1, begin);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
        return nums;
    }

    /**
     * 冒泡排序
     */
    public int[] sortArray(int[] nums) {
        for (int end = nums.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (nums[begin - 1] > nums[begin]) {
                    swap(nums, begin - 1, begin);
                }
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        _912_排序数组 test = new _912_排序数组();
        int[] nums = new int[]{
                18894,
                -19479,
                13966,
                6050,
                -18723,
                -15857,
                7074,
                5408,
                13928,
                -4107,
                19755,
                3899,
                17786
        };
        int[] result4 = test.sortArray8(nums);
        for(int i = 0; i < result4.length; i++) {
            System.out.println(result4[i]);
        }
    }
}
