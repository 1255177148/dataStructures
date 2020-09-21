package com.zhan.data.sort;

import lombok.Data;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Zhanzhan
 * @Date 2020/9/21 20:23
 * 冒泡排序
 */
@Data
public class BubbleSort {
    private int[] arr;
    private int size;
    private static int count = 0;

    public BubbleSort() {
        this.arr = new int[0];
    }

    /**
     * 初始化一个数组
     *
     * @param size 数组里生成随机数的个数
     */
    public BubbleSort(int size) {
        this.size = size;
        this.arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(80000);
        }
    }

    /**
     * <p>使用冒泡排序进行升序排序</p>
     * <p>如果不对冒泡排序进行优化，那么不论数组的顺序如何，都会经过数组size-1次排序</p>
     * <p>所以可以优化一下，声明一个boolean值，来标识当前这轮排序，是否有数据的变动，如果没有，则认为顺序已排完，不会再往下进行了</p>
     * @param optimization 是否为冒泡排序进行优化，即声明一个boolean值用来标识当前冒泡排序需不需要继续下去
     */
    public void sort(boolean optimization) {
        if (arr.length <= 0) {
            return;
        }
        int temp = 0; // 临时变量
        boolean change; // 标识是否在排序中进行过排序
        long start = System.currentTimeMillis();
        for (int i = 0; i < size - 1; i++) {
            change = false;
            for (int j = 0; j < size - 1 - i; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    change = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
//            System.out.println("第" + (i+1) + "次排序后的数组为:" + Arrays.toString(arr));
            if (optimization && !change){
                break;
            }
        }
        long end = System.currentTimeMillis();
//        System.out.println("排序后的数组为:" + Arrays.toString(arr));
        System.out.println("一共花费了" + (end - start)/1000 + "秒");
    }
}
