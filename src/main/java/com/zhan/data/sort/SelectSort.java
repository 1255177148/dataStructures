package com.zhan.data.sort;

import lombok.Data;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Zhanzhan
 * @Date 2020/9/21 22:07
 * 选择排序
 */
@Data
public class SelectSort {
    private int[] arr;
    private int size;

    /**
     * 初始化一个待排序的数组
     *
     * @param size 数组的大小
     */
    public SelectSort(int size) {
        this.size = size;
        this.arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
    }

    /**
     * <p>选择排序</p>
     * <p>排序思路:
     * <blockquote><pre>
     *     1、从下标为0开始，遍历数组，一次比较，获取整个数组的最小值，将arr[0] 和 找到的最小值的arr[]互换值;
     *     2、再从下标为1开始，遍历数组，一次比较，获取整个数组的最小值，将arr[1] 和 找到的最小值的arr[]互换值;
     *     3、就这样依次递增遍历，直到最后，这样数组就从小到大升序排列完毕。
     * </pre></blockquote>
     * </p>
     */
    public void sort(){
        if (arr.length <= 0){
            return;
        }
        int minIndex = 0; //表示数组中最小值的下标位置
        int min = 0; // 表示数组中最小值
        for (int i =0;i<size-1;i++){
            minIndex = i;
            min = arr[i];
            for (int j = i + 1;j<size;j++){
                if (min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
            System.out.println("第" + (i+1) + "次排序后的数组为:" + Arrays.toString(arr));
        }
        System.out.println("升序后的数组为:" + Arrays.toString(arr));
    }
}
