package com.zhan.data.sort;

/**
 * @Author Zhanzhan
 * @Date 2020/9/24 8:07
 * 快速排序
 */
public class QuickSort {

    /**
     * <p>快速排序</p>
     * <p>思路
     * <blockquote><pre>
     *     1、以数组第一个数p为基准,遍历数组,比p小的就放左边,大的就放右边：
     *     2、然后在分别将左右两侧分组的数组第一个数为基准,再次重复步骤1,直到最后左右两侧的指针重合为止。
     * </pre></blockquote>
     * </p>
     *
     * @param arr   要排序的数组
     * @param left  表示分组的最左边
     * @param right 表示分组的最右边
     */
    public void sort(int[] arr, int left, int right) {
        if (arr.length <= 0 || left > right) {
            return;
        }
        int l = left; // 左侧指针
        int r = right; // 右侧指针
        int p = arr[left]; // 定义基准
        int temp;
        // 开始循环，将比p小的值放左边，比p大的值放右边
        while (l < r) {
            /**
             * 先看右边，指针依次往左递减,直到找到一个比基准p小的数,同时要保证指针r不到到指针l的左侧
             * 找到后跳出循环
             */
            while (p <= arr[r] && l < r) {
                r--;
            }

            /**
             * 再看左边,指针依次往右递增，直到找到一个比基准p大的数,
             * 找到后跳出循环
             */
            while (p >= arr[l] && l < r) {
                l++;
            }
            // 如果满足l < r,即左侧指针在右侧指针的左侧的条件，则交换值
            if (l < r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        // 这时跳出循环，说明指针l已经和指针r重合
        // 最后将基准位置的值与指针的值交换
        arr[left] = arr[l];
        arr[l] = p;

        // 此时,左侧数组的值 < (指针l和指针r所在位置的值) < 右侧数组的值
        // 也就是说 指针l和指针r所在的位置 已经确定下来的,现在只需要用相同的方法处理 左侧数组 和 右侧数组就可以了

        // 递归调用左侧数组,进行排序
        sort(arr, left, r - 1);

        // 递归调用右侧数组,进行排序
        sort(arr, l + 1, right);
    }
}
