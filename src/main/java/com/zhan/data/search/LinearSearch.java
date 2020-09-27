package com.zhan.data.search;

/**
 * @Author zhan
 * @Date 2020/9/27 20:11
 * 线性查找
 */
public class LinearSearch {

    /**
     * <p>线性查找</p>
     * <p>遍历数组，依次对比，找到要查找的值为止</p>
     * @param arr
     * @param value
     * @return
     */
    public int search(int[] arr, int value){
        for (int i = 0;i<arr.length;i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
