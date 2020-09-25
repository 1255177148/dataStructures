package com.zhan.data.sort;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Zhanzhan
 * @Date 2020/9/24 9:35
 * 快速排序demo
 */
@SpringBootTest
public class QuickSortDemo {
    @Test
    void demo() {
        int[] arr = {3, 5, 7, 8, 9, 0, 2, 2, 10};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    void timeDemo() {
        Random random = new Random();
        int[] arr = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr[i] = random.nextInt();
        }
        QuickSort quickSort = new QuickSort();
        long start = System.currentTimeMillis();
        quickSort.sort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("总共耗费" + (end - start) / 1000 + "秒");
    }
}
