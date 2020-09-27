package com.zhan.data.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhan
 * @Date 2020/9/27 20:28
 * 二分查找
 */
public class BinarySearch {

    private static List<Integer> index = new ArrayList<>();

    /**
     * <p>二分查找</p>
     * <p>思路，假定要查找的是一个升序数组:
     * <blockquote><pre>
     *     1、找到有序数组的中间为止的值，即下标为(left + right)/2 的值;
     *     2、将中间值 arr[mid] 与 value比较;
     *       2.1、如果比value值大，则说明要找的数据在arr[mid]的左边，则向左递归;
     *       2.2、如果比value值小，则说明要找的数据在arr[mid]的右边，则向右递归;
     *       2.3、如果与value相等，则说明找到，return。
     *     3、如果递归过程中 left > right,则说明数组中没有要找的数据，结束递归并return。
     * </pre></blockquote>
     * </p>
     * @param arr 要查找的有序数组
     * @param value 要查找的值
     * @param left 左侧下标
     * @param right 右侧下标
     * @return
     */
    public List binarySearch(int[] arr, int value, int left, int right){
        if (left > right){
            return new ArrayList<>();
        }
        int mid = (left + right)/2;
        if (arr[mid] > value){
            return binarySearch(arr, value, left, mid -1);
        } else if (arr[mid] < value){
            return binarySearch(arr, value, mid+1, right);
        } else {
            // 这里找到了和要查找的值相等的下标mid，然后从mid开始，分别向左和向右遍历，将查到的相等的值遍历出来
            for (int l = mid-1; l >= left;l--){
                if (arr[l] == value){
                    index.add(l);
                } else {
                    break;
                }
            }
            index.add(mid);
            for (int r = mid+1;r<=right;r++){
                if (arr[r] == value){
                    index.add(r);
                } else {
                    break;
                }
            }
            return index;
        }
    }
}
