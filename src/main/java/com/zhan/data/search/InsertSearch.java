package com.zhan.data.search;

/**
 * @Author zhan
 * @Date 2020/9/28 20:48
 * 插值查找
 */
public class InsertSearch {

    /**
     * <p>插值查找，适用于要查找的关键字有序且分布均匀</p>
     * <p>
     * 思路:
     * <blockquote><pre>
     *         1、和二分查找基本类似，区别只在于mid值的取法不同;
     *         2、二分查找的mid值的取法为: (left + right)/2 =》left + (right - left)/2,
     *         而插值查找的mid值的取法为: left + (value - arr[left])/(arr[right] - arr[left])*(right - left)
     *     </pre></blockquote>
     * </p>
     *
     * @param arr   要查找的有序数组
     * @param left  左侧下标
     * @param right 右侧下标
     * @param value 要查找的值
     * @return 对应值的下标
     */
    public int insertSearch(int[] arr, int left, int right, int value) {
        System.out.println("查找");
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (arr[mid] > value) {
            return insertSearch(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return insertSearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }
}
