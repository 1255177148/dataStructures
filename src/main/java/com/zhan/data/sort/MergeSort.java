package com.zhan.data.sort;

/**
 * @Author Zhanzhan
 * @Date 2020/9/26 14:38
 * 归并排序
 */
public class MergeSort {

    /**
     * 将分隔后的数组进行排序并合并
     *
     * @param arr   要排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   数组中间索引，将数组一分为二
     * @param right 右边有序序列的初始索引
     * @param temp  临时数组，用来接收
     */
    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left; // 初始化一个左侧序列的索引
        int r = mid + 1; // 初始化一个右侧序列的索引
        int t = 0; // 指向temp数组的当前下标
        // 先把左右两边的数据按照规则填充到temp 数组,直到左右两边的序列中有一边梳理完毕为止
        while (l <= mid && r <= right) {
            temp[t++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
        }
        // 把有剩余数据的一侧序列依次全部填充到temp
        while (l <= mid) {
            temp[t++] = arr[l++];
        }
        while (r <= right) {
            temp[t++] = arr[r++];
        }
        // 最后把合并后的temp数组复制到arr中
        if (t >= 0) System.arraycopy(temp, 0, arr, left, t);
    }

    /**
     * <p>归并排序</p>
     * <p>
     *     思路:
     *     <blockquote><pre>
     *         将数组依次从中一分为二，最终不可分为止，然后按照规则依次排序合并
     *     </pre></blockquote>
     * </p>
     * @param arr 要排序的原始数组
     * @param left 分开后的数组的左侧初始下标
     * @param right 分开后的数组的右侧末尾下标
     * @param temp 临时数组，用来接收
     */
    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp); // 对左侧的数组进行归并排序
            mergeSort(arr, mid + 1, right, temp); // 对右侧的数组进行归并排序
            merge(arr, left, mid, right, temp);
        }
    }
}
