package com.zhan.data.sort;

import lombok.Data;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Zhanzhan
 * @Date 2020/9/22 10:38
 * 插入排序
 */
@Data
public class InsertSort {
    private int[] arr;
    private int size;

    /**
     * 初始化一个要排序的数组
     *
     * @param size 数组大小
     */
    public InsertSort(int size) {
        this.size = size;
        this.arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(80000);
        }
    }

    /**
     * <p>插入排序,升序排序</p>
     * <p>排序思路:
     * <blockquote><pre>
     *     1、首先将数组下标为0即第一个数,预先认为是最小数;
     *     2、然后从下标为1即第二个数开始，依次和前面的数比对，找到要插入的位置，然后将数据插入.
     * </pre></blockquote>
     * </p>
     */
    public void sort() {
        if (arr.length <= 0) {
            return;
        }
        int insertValue; // 接收一个要进行插入排序的数
        int insertIndex; // 接收要插入的下标
        long start = System.currentTimeMillis();
        for (int i = 1; i < size; i++) {
            insertValue = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex]; // 将比要做插入比对数据小的数组元素后移
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue; // 将要插入的数据插入到找到的位置上
        }
        long end = System.currentTimeMillis();
        System.out.println("总共耗时" + (end - start) / 1000 + "秒");
    }
}
