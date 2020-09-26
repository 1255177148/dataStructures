package com.zhan.data.sort;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Zhanzhan
 * @Date 2020/9/26 16:09
 * 归并排序demo
 */
@SpringBootTest
public class MergeSortDemo {
    @Test
    void demo() {
        int[] arr = {1, 5, 6, 8, 9, 4, 3, 7, 2};
        int[] temp = new int[arr.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("归并排序后的数组为:" + Arrays.toString(arr));
    }

    @Test
    void timeDemo() {
        Random random = new Random();
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = random.nextInt();
        }
        int[] temp = new int[arr.length];
        MergeSort mergeSort = new MergeSort();
        long start = System.currentTimeMillis();
        mergeSort.mergeSort(arr, 0, arr.length - 1, temp);
        long end = System.currentTimeMillis();
        System.out.println("总共耗时" + (end - start) / 1000 + "秒");
    }
}
