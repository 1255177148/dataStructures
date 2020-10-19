package com.zhan.data.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Zhanzhan
 * @Date 2020/10/19 20:52
 * 堆排序demo
 */
public class HeapSortDemo {
    @Test
    void demo() {
        int[] arr = {199, -5, -555, 49, 69, 1, 0};
        HeapSort heapSort = new HeapSort();
        System.out.println("堆排序前的数组为:" + Arrays.toString(arr));
        heapSort.heapSort(arr);
        System.out.println("堆排序后的数组为:" + Arrays.toString(arr));
    }

    @Test
    void time() {
        HeapSort heapSort = new HeapSort();
        Random random = new Random();
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = random.nextInt();
        }
        long start = System.currentTimeMillis();
        heapSort.heapSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("使用堆排序为八百万个数据进行排序，一共耗费 " + (end - start) / 1000 + "秒");
    }
}
